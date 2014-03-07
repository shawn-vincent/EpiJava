/*
 * EpiJava.g
 *
 * Java grammar from the Antlr website:
 *   http://www.antlr.org/grammar/1152141644268/Java.g
 *
 * A Java 1.5 grammar for ANTLR v3 derived from the spec
 *
 *  This is a very close representation of the spec; the changes
 *  are comestic (remove left recursion) and also fixes (the spec
 *  isn't exactly perfect).  I have run this on the 1.4.2 source
 *  and some nasty looking enums from 1.5, but have not really
 *  tested for 1.5 compatibility.
 *
 *  I built this with: java -Xmx100M org.antlr.Tool java.g 
 *  and got two errors that are ok (for now):
 *  java.g:691:9: Decision can match input such as
 *    "'0'..'9'{'E', 'e'}{'+', '-'}'0'..'9'{'D', 'F', 'd', 'f'}"
 *    using multiple alternatives: 3, 4
 *  As a result, alternative(s) 4 were disabled for that input
 *  java.g:734:35: Decision can match input such as "{'$', 'A'..'Z',
 *    '_', 'a'..'z', '\u00C0'..'\u00D6', '\u00D8'..'\u00F6',
 *    '\u00F8'..'\u1FFF', '\u3040'..'\u318F', '\u3300'..'\u337F',
 *    '\u3400'..'\u3D2D', '\u4E00'..'\u9FFF', '\uF900'..'\uFAFF'}"
 *    using multiple alternatives: 1, 2
 *  As a result, alternative(s) 2 were disabled for that input
 *
 *  You can turn enum on/off as a keyword :)
 *
 *  Version 1.0 -- initial release July 5, 2006 (requires 3.0b2 or higher)
 *
 *  Primary author: Terence Parr, July 2006
 *
 *  Version 1.0.1 -- corrections by Koen Vanderkimpen & Marko van Dooren,
 *      October 25, 2006;
 *      fixed normalInterfaceDeclaration: now uses typeParameters instead
 *          of typeParameter (according to JLS, 3rd edition)
 *      fixed castExpression: no longer allows expression next to type
 *          (according to semantics in JLS, in contrast with syntax in JLS)
 *
 *  Version 1.0.2 -- Terence Parr, Nov 27, 2006
 *      java spec I built this from had some bizarre for-loop control.
 *          Looked weird and so I looked elsewhere...Yep, it's messed up.
 *          simplified.
 *
 *  Version 1.0.3 -- Chris Hogue, Feb 26, 2007
 *      Factored out an annotationName rule and used it in the annotation rule.
 *          Not sure why, but typeName wasn't recognizing references to inner
 *          annotations (e.g. @InterfaceName.InnerAnnotation())
 *      Factored out the elementValue section of an annotation reference.  Created 
 *          elementValuePair and elementValuePairs rules, then used them in the 
 *          annotation rule.  Allows it to recognize annotation references with 
 *          multiple, comma separated attributes.
 *      Updated elementValueArrayInitializer so that it allows multiple elements.
 *          (It was only allowing 0 or 1 element).
 *      Updated localVariableDeclaration to allow annotations.  Interestingly the JLS
 *          doesn't appear to indicate this is legal, but it does work as of at least
 *          JDK 1.5.0_06.
 *      Moved the Identifier portion of annotationTypeElementRest to annotationMethodRest.
 *          Because annotationConstantRest already references variableDeclarator which 
 *          has the Identifier portion in it, the parser would fail on constants in 
 *          annotation definitions because it expected two identifiers.  
 *      Added optional trailing ';' to the alternatives in annotationTypeElementRest.
 *          Wouldn't handle an inner interface that has a trailing ';'.
 *      Swapped the expression and type rule reference order in castExpression to 
 *          make it check for genericized casts first.  It was failing to recognize a
 *          statement like  "Class<Byte> TYPE = (Class<Byte>)...;" because it was seeing
 *          'Class<Byte' in the cast expression as a less than expression, then failing 
 *          on the '>'.
 *      Changed createdName to use typeArguments instead of nonWildcardTypeArguments.
 *          Again, JLS doesn't seem to allow this, but java.lang.Class has an example of
 *          of this construct.
 *      Changed the 'this' alternative in primary to allow 'identifierSuffix' rather than
 *          just 'arguments'.  The case it couldn't handle was a call to an explicit
 *          generic method invocation (e.g. this.<E>doSomething()).  Using identifierSuffix
 *          may be overly aggressive--perhaps should create a more constrained thisSuffix rule?
 * 		
 *  Version 1.0.4 -- Hiroaki Nakamura, May 3, 2007
 *
 *	Fixed formalParameterDecls, localVariableDeclaration, forInit,
 *	and forVarControl to use variableModifier* not 'final'? (annotation)?
 *
 *  Version 1.0.5 -- Terence, June 21, 2007
 *	--a[i].foo didn't work. Fixed unaryExpression
 *
 *  Version 1.1.0 -- Shawn Vincent, Dec 23 07
 *    Included in javai source package.
 */
grammar EpiJava;
options {k=2; backtrack=true; memoize=true;}

@header {
  package com.epijava.grammar;
  import com.epijava.tree.*;
  import com.epijava.util.*;
  import java.util.*;
  import org.antlr.runtime.BitSet;
}

@members {
  private String locusModule;
  public EpiJavaParser setLocusModule(String _locusModule)
  { locusModule = _locusModule; return this; }
  
  public Locus l(Token t) { return new Locus.ConstantLocus(locusModule, t.getLine()); }
  public Locus l(Locus l) { return l; }
  
  /**
   * Do not recover from exceptions (reconsider this in the future - maybe add 
   * ErrorSink stuff...)
   **/
  @Override
  protected void mismatch(IntStream input, int ttype, BitSet follow)
    throws RecognitionException
  {
  //        MismatchedTokenException mte =
  //              new MismatchedTokenException(ttype, input);
  //      recoverFromMismatchedToken(input, mte, ttype, follow);
    throw new MismatchedTokenException(ttype, input);
  }
  
  @Override
  public void recoverFromMismatchedSet(IntStream input, RecognitionException ex, BitSet follow)
    throws RecognitionException
  {
    throw ex;
  }
}

@lexer::header {
  package com.epijava.grammar;
}

@lexer::members {
  protected boolean enumIsKeyword = true;
}

@rulecatch {
  catch (RecognitionException e) {
    throw e;
  }
}

// starting point for parsing a java file
compilationUnit returns [CompilationUnit r]
	:	as=annotations
		packageName=packageDeclaration?
        is=importDeclarations
        ts=typeDeclarations
        
        {
      	   r = new CompilationUnit(new Locus.ConstantLocus(locusModule, -1));
           r.setAnnotations(as);
           r.setPackageName(packageName);
           r.setImports(is);
           r.addTypes(ts);
        }
    
        // EpiJava extension:
        // here, topLevelStatements is a list of local var decls and statements
        // that live directly in the module.  This allows concise scripts that
        // simply contain statements.
        topLevelStatements[r]
	;
	
topLevelStatements[CompilationUnit c]
    :  
            (s=topLevelStatement {c.addTopLevelStatement(s);})*
    ;

packageDeclaration returns [QualifiedName r]
    @after { r=r_; }
	:	'package' r_=qualifiedName ';'
	;
	
importDeclarations returns [List<Import> r]
    @init {
      r=new ArrayList<Import>();
    }
    :   (i=importDeclaration { r.add(i); })*
    ;

importDeclaration returns [Import r]
    @init {
      boolean importStar = false;
      boolean staticImport = false;
    }
    @after {
      r = new Import(l(t), qname, importStar, staticImport);
    }
	:	t='import' ('static' {staticImport=true;})?
        qname=qualifiedName ('.' '*' {importStar=true;})? ';'
	;
	
typeDeclarations returns [List<TypeDeclaration> r]
    @init {
      r = new ArrayList<TypeDeclaration>();
    }
    :   (typeDecl=typeDeclaration {if (typeDecl != null) r.add(typeDecl);})*
    ;

typeDeclaration returns [TypeDeclaration r]
    @after { r=r_; }
	:	r_=classOrInterfaceDeclaration
    |   ';'
	;
	
classOrInterfaceDeclaration returns [TypeDeclaration r]
    @after { r=r_; }
      // XXX add modifiers to returned type
	:	modifier* (r_=classDeclaration | r_=interfaceDeclaration)
	;
	
classDeclaration returns [TypeDeclaration r]
    @after { r=r_; }
	:	r_=normalClassDeclaration
    |   enumDeclaration
	;
	
normalClassDeclaration returns [ClassDeclaration r]
	:	t='class' id=Identifier (typeParameters)?
	      { r = new ClassDeclaration(l(t), id.getText()); }
        ('extends' superType=type { r.setSuperType(superType); })?
        ('implements' interfaces=typeList { r.setInterfaces(interfaces); })?
        classBody[r]
	;
	
typeParameters
	:	'<' typeParameter (',' typeParameter)* '>'
	;

typeParameter
	:	Identifier ('extends' bound)?
	;
		
bound
	:	type ('&' type)*
	;

enumDeclaration
	:	ENUM Identifier ('implements' typeList)? enumBody
	;
	
enumBody
	:	'{' enumConstants? ','? enumBodyDeclarations? '}'
	;

enumConstants
	:	enumConstant (',' enumConstant)*
	;
	
enumConstant
	:	annotations Identifier (arguments)? (classBody[null])?
	;
	
enumBodyDeclarations
	:	';' (classBodyDeclaration)*
	;
	
interfaceDeclaration returns [TypeDeclaration r]
	:	normalInterfaceDeclaration
		| annotationTypeDeclaration
	;
	
normalInterfaceDeclaration
	:	'interface' Identifier typeParameters? ('extends' typeList)? interfaceBody
	;
	
typeList returns[List<TypeReference> r]
    @init{ r=new ArrayList<TypeReference>(); }
	:	t=type {r.add(t);} (',' t=type {r.add(t);})*
	;
	
classBody[TypeDeclaration r]
	:	'{' (member=classBodyDeclaration { if (member != null) r.add(member); })* '}'
	;
	
interfaceBody
	:	'{' interfaceBodyDeclaration* '}'
	;

classBodyDeclaration returns [MemberDeclaration r]
    @init {
       boolean staticBlock = false;
    }
	:	';'
	|	('static' {staticBlock=true;})? b=block
	      { r = new BlockMember(l(b), staticBlock, b); }
	|	modifier* r_=memberDecl { r = r_; }
	;
	
memberDecl returns [MemberDeclaration r]
	:	genericMethodOrConstructorDecl
	|	r_=methodDeclaration { r = r_; }
	|	fieldDeclaration
	|	'void' Identifier voidMethodDeclaratorRest
	|	Identifier constructorDeclaratorRest
	|	interfaceDeclaration
	|	classDecl=classDeclaration { r=classDecl; }
	;
	
genericMethodOrConstructorDecl
	:	typeParameters genericMethodOrConstructorRest
	;
	
genericMethodOrConstructorRest
	:	(type | 'void') Identifier methodDeclaratorRest[null,null,null] // XXX
	|	Identifier constructorDeclaratorRest
	;

methodDeclaration returns [MethodDeclaration r]
	:	t=type id=Identifier r_=methodDeclaratorRest[l(id), t, id.getText()]
	    { r = r_; }
	;

fieldDeclaration
	:	type variableDeclarators ';'
	;
		
interfaceBodyDeclaration
	:	modifier* interfaceMemberDecl
	|   ';'
	;

interfaceMemberDecl
	:	interfaceMethodOrFieldDecl
	|   interfaceGenericMethodDecl
    |   'void' Identifier voidInterfaceMethodDeclaratorRest
    |   interfaceDeclaration
    |   classDeclaration
	;
	
interfaceMethodOrFieldDecl
	:	type Identifier interfaceMethodOrFieldRest
	;
	
interfaceMethodOrFieldRest
	:	constantDeclaratorsRest ';'
	|	interfaceMethodDeclaratorRest
	;
	
methodDeclaratorRest[Locus l, TypeReference returnType, String name]
            returns [MethodDeclaration r]

	:	formalParameters ('[' ']')*
        ('throws' qualifiedNameList)?
        (   methodBody
        |   ';'
        )
        { r = new MethodDeclaration(l, name).setFunctionType(new FunctionTypeReference(l, returnType)); }
	;
	
voidMethodDeclaratorRest
	:	formalParameters ('throws' qualifiedNameList)?
        (   methodBody
        |   ';'
        )
	;
	
interfaceMethodDeclaratorRest
	:	formalParameters ('[' ']')* ('throws' qualifiedNameList)? ';'
	;
	
interfaceGenericMethodDecl
	:	typeParameters (type | 'void') Identifier
        interfaceMethodDeclaratorRest
	;
	
voidInterfaceMethodDeclaratorRest
	:	formalParameters ('throws' qualifiedNameList)? ';'
	;
	
constructorDeclaratorRest
	:	formalParameters ('throws' qualifiedNameList)? methodBody
	;

constantDeclarator
	:	Identifier constantDeclaratorRest
	;
	
variableDeclarators
	:	variableDeclarator (',' variableDeclarator)*
	;

variableDeclarator
	:	Identifier variableDeclaratorRest
	;
	
variableDeclaratorRest
	:	('[' ']')+ ('=' variableInitializer)?
	|	'=' variableInitializer
	|
	;
	
constantDeclaratorsRest
    :   constantDeclaratorRest (',' constantDeclarator)*
    ;

constantDeclaratorRest
	:	('[' ']')* '=' variableInitializer
	;
	
variableDeclaratorId
	:	Identifier ('[' ']')*
	;

variableInitializer
	:	arrayInitializer
    |   expression
	;
	
arrayInitializer
	:	'{' (variableInitializer (',' variableInitializer)* (',')? )? '}'
	;

modifier
    :   annotation
    |   'public'
    |   'protected'
    |   'private'
    |   'static'
    |   'abstract'
    |   'final'
    |   'native'
    |   'synchronized'
    |   'transient'
    |   'volatile'
    |   'strictfp'
    ;

packageOrTypeName
	:	Identifier ('.' Identifier)*
	;

enumConstantName
    :   Identifier
    ;

typeName
	:   Identifier
    |   packageOrTypeName '.' Identifier
	;

type returns [TypeReference r]
    @init {
      List<String> components = new ArrayList<String>();
      Locus l = null; // the locus of the LAST component
    }
        // XXX this is difficult.  It should be an AmbiguousName iff it 
        // doesn't have type arguments
        
	:	id=Identifier (typeArguments)?
        { r = new PackageOrTypeReference(l(id), null, id.getText()); }
        
	    (
	        '.' id=Identifier (typeArguments)?
            { r = new PackageOrTypeReference(l(id), (PackageOrTypeReference)r, id.getText()); }
 	    )*
 	    
 	    { r = ((PackageOrTypeReference)r).toNamedTypeReference(); }
        
	    (t='[' ']' { r = new ArrayTypeReference(l(t), r); } )*
	    
	|	r_=primitiveType { r = r_; }
	    ('[' ']' { r = new ArrayTypeReference(l(t), r); } )*
	;

primitiveType returns [NamedTypeReference r]
    @after { r = new NamedTypeReference(l(t), null, t.getText()); }
    :   t='boolean'
    |	t='char'
    |	t='byte'
    |	t='short'
    |	t='int'
    |	t='long'
    |	t='float'
    |	t='double'
    ;

variableModifier
	:	'final'
    |   annotation
	;

typeArguments
	:	'<' typeArgument (',' typeArgument)* '>'
	;
	
typeArgument
	:	type
	|	'?' (('extends' | 'super') type)?
	;
	
qualifiedNameList
	:	qualifiedName (',' qualifiedName)*
	;
	
formalParameters
	:	'(' formalParameterDecls? ')'
	;
	
formalParameterDecls
	:	variableModifier* type formalParameterDeclsRest?
	;
	
formalParameterDeclsRest
	:	variableDeclaratorId (',' formalParameterDecls)?
	|   '...' variableDeclaratorId
	;
	
methodBody
	:	block
	;

qualifiedName returns [QualifiedName r]
    @init {
      List<String> components = new ArrayList<String>();
      Locus l = null; // the locus of the LAST component
    }
    @after {
      r = new QualifiedName(l, components);
    }
	:	t=Identifier { l=l(t); components.add(t.getText()); }
        ('.' t=Identifier { l=l(t); components.add(t.getText()); })*
	;
	
literal	returns[Expression r] // XXX
	:   r_=integerLiteral{r=r_;}
    |   t=FloatingPointLiteral{r=FloatLiteral.make(l(t), t.getText());}
    |   t=CharacterLiteral{r=CharLiteral.make(l(t), t.getText());}
    |   t=StringLiteral{r=com.epijava.tree.StringLiteral.make(l(t), t.getText());}
    |   r_=booleanLiteral{r=r_;}
    |   t='null' {r=new NullLiteral(l(t));}
	;

integerLiteral returns[Expression r]
    :   t=HexLiteral{r=IntLiteral.makeHex(l(t), t.getText());}
    |   t=OctalLiteral{r=IntLiteral.makeOctal(l(t), t.getText());}
    |   t=DecimalLiteral{r=IntLiteral.makeDecimal(l(t), t.getText());}
    ;

booleanLiteral returns[Expression r]
    :   t='true'{r=new BooleanLiteral(l(t),true);}
    |   t='false'{r=new BooleanLiteral(l(t),false);}
    ;

// ANNOTATIONS

annotations returns [List<Annotation> r]
	:	annotation*
	;

annotation
	:	'@' annotationName ('(' elementValuePairs? ')')?
	;
	
annotationName
	: Identifier ('.' Identifier)*
	;
	
elementValuePairs
	: elementValuePair (',' elementValuePair)*
	;
	
elementValuePair
	: (Identifier '=')? elementValue
	;
	
elementValue
	:	conditionalExpression
	|   annotation
	|   elementValueArrayInitializer
	;
	
elementValueArrayInitializer
	:	'{' (elementValue (',' elementValue )*)? '}'
	;
	
annotationTypeDeclaration
	:	'@' 'interface' Identifier annotationTypeBody
	;
	
annotationTypeBody
	:	'{' (annotationTypeElementDeclarations)? '}'
	;
	
annotationTypeElementDeclarations
	:	(annotationTypeElementDeclaration) (annotationTypeElementDeclaration)*
	;
	
annotationTypeElementDeclaration
	:	(modifier)* annotationTypeElementRest
	;
	
annotationTypeElementRest
	:	type annotationMethodOrConstantRest ';'
	|   classDeclaration ';'?
	|   interfaceDeclaration ';'?
	|   enumDeclaration ';'?
	|   annotationTypeDeclaration ';'?
	;
	
annotationMethodOrConstantRest
	:	annotationMethodRest
	|   annotationConstantRest
	;
	
annotationMethodRest
 	:	Identifier '(' ')' (defaultValue)?
 	;
 	
annotationConstantRest
 	:	variableDeclarators
 	;
 	
defaultValue
 	:	'default' elementValue
 	;

// STATEMENTS / BLOCKS

block returns [Block r]
	:	t='{' 
	    { r = new Block(l(t)); }
	    (s=blockStatement {r.add(s);})*
	    '}'
	;
	
blockStatement returns [Expression r]
	:	localVariableDeclaration
	|	classOrInterfaceDeclaration // XXX
    |	r_=statement { r = r_; }
	;
	
topLevelStatement returns [Expression r]
    :   localVariableDeclaration
    |   r_=statement { r = r_; }
    ;	
	
localVariableDeclaration
	:	variableModifier* type variableDeclarators ';'
	;
	
	// XXX lots more here
statement returns [Expression r]
	: r_=block { r = r_; }
    | 'assert' expression (':' expression)? ';'
    | 'if' parExpression statement (options {k=1;}:'else' statement)?
    | 'for' '(' forControl ')' statement
    | 'while' parExpression statement
    | 'do' statement 'while' parExpression ';'
    | 'try' block
      (	catches 'finally' block
      | catches
      | 'finally' block
      )
    | 'switch' parExpression '{' switchBlockStatementGroups '}'
    | 'synchronized' parExpression block
    | 'return' expression? ';'
    | 'throw' expression ';'
    | 'break' Identifier? ';'
    | 'continue' Identifier? ';'
    | ';'
    | r_=statementExpression { r = r_; } ';'
    | Identifier ':' statement
	;
	
catches
	:	catchClause (catchClause)*
	;
	
catchClause
	:	'catch' '(' formalParameter ')' block
	;

formalParameter
	:	variableModifier* type variableDeclaratorId
	;
		
switchBlockStatementGroups
	:	(switchBlockStatementGroup)*
	;
	
switchBlockStatementGroup
	:	switchLabel blockStatement*
	;
	
switchLabel
	:	'case' constantExpression ':'
	|   'case' enumConstantName ':'
	|   'default' ':'
	;
	
moreStatementExpressions
	:	(',' statementExpression)*
	;

forControl
options {k=3;} // be efficient for common case: for (ID ID : ID) ...
	:	forVarControl
	|	forInit? ';' expression? ';' forUpdate?
	;

forInit
	:	variableModifier* type variableDeclarators
	|	expressionList
	;
	
forVarControl
	:	variableModifier* type Identifier ':' expression
	;

forUpdate
	:	expressionList
	;

// EXPRESSIONS

parExpression returns [Expression r]
	:	'(' r_=expression {r=r_;} ')'
	;
	
expressionList returns [List<Expression> r]
@before{ r = new ArrayList<Expression>(); }
    :   expr=expression {r.add(expr);} (',' expr=expression {r.add(expr);})*
    ;

statementExpression returns [Expression r]
	:	r_=expression {r = r_;}
	;
	
constantExpression returns [Expression r]
	:	r_=expression {r = r_;}
	;
	
expression returns [Expression r]
	:	r_=conditionalExpression {r=r_;} (assignmentOperator expression)?
	;
	
assignmentOperator
	:	'='
    |   '+='
    |   '-='
    |   '*='
    |   '/='
    |   '&='
    |   '|='
    |   '^='
    |   '%='
    |   '<' '<' '='
    |   '>' '>' '='
    |   '>' '>' '>' '='
	;

conditionalExpression returns [Expression r]
    :   r_=conditionalOrExpression {r = r_;} ( '?' expression ':' expression )?
	;

conditionalOrExpression returns [Expression r]
    :   r_=conditionalAndExpression {r = r_;} ( '||' conditionalAndExpression )*
	;

conditionalAndExpression returns [Expression r]
    :   r_=inclusiveOrExpression {r = r_;} ( '&&' inclusiveOrExpression )*
	;

inclusiveOrExpression returns [Expression r]
    :   r_=exclusiveOrExpression {r = r_;} ( '|' exclusiveOrExpression )*
	;

exclusiveOrExpression returns [Expression r]
    :   r_=andExpression {r = r_;} ( '^' andExpression )*
	;

andExpression returns [Expression r]
    :   r_=equalityExpression {r = r_;} ( '&' equalityExpression )*
	;

equalityExpression returns [Expression r]
    :   r_=instanceOfExpression {r = r_;} ( ('==' | '!=') instanceOfExpression )*
	;

instanceOfExpression returns [Expression r]
    :   r_=relationalExpression {r = r_;} ('instanceof' type)?
	;

relationalExpression returns [Expression r]
    :   r_=shiftExpression {r = r_;} ( relationalOp shiftExpression )*
	;
	
relationalOp
	:	('<' '=' | '>' '=' | '<' | '>')
	;

shiftExpression returns [Expression r]
    :   r_=additiveExpression {r = r_;} ( shiftOp additiveExpression )*
	;

        // TODO: need a sem pred to check column on these >>>
shiftOp
	:	('<' '<' | '>' '>' '>' | '>' '>')
	;


additiveExpression returns [Expression r]
    :   r_=multiplicativeExpression {r = r_;} ( ('+' | '-') multiplicativeExpression )*
	;

multiplicativeExpression returns [Expression r]
    :   r_=unaryExpression {r = r_;} ( ( '*' | '/' | '%' ) unaryExpression )*
	;
	
unaryExpression returns [Expression r]
    :   '+' unaryExpression
    |	'-' unaryExpression
    |   '++' unaryExpression
    |   '--' unaryExpression
    |   r_=unaryExpressionNotPlusMinus {r = r_;}
    ;

unaryExpressionNotPlusMinus returns [Expression r]
    :   '~' unaryExpression
    | 	'!' unaryExpression
    |   castExpression
    |   r_=primary {r = r_;} selector* ('++'|'--')?
    ;

castExpression
    :  '(' primitiveType ')' unaryExpression
    |  '(' (type | expression) ')' unaryExpressionNotPlusMinus
    ;

primary returns [Expression r]
    :	r_=parExpression{r=r_;}
    |   nonWildcardTypeArguments
        (explicitGenericInvocationSuffix | 'this' arguments)
    |   'this' ('.' Identifier)* identifierSuffix[new NullLiteral(Locus.Unknown)] // XXX
    |   'super' superSuffix
    |   r_=literal {r = r_;}
    |   'new' creator
    |   q=qualifiedName {r=new AmbiguousReference(l(q), q); } r_=identifierSuffix[r] { r=r_;}
    |   primitiveType ('[' ']')* '.' 'class'
    |   'void' '.' 'class'
	;

identifierSuffix[Expression orig] returns[Expression r]
	:	('[' ']')+ '.' 'class'
	|	('[' expression ']')+ // can also be matched by selector, but do here
    |   args=arguments { r = new Call(l(orig), (AmbiguousReference)orig, args); }
    |   '.' 'class'
    |   '.' explicitGenericInvocation
    |   '.' 'this'
    |   '.' 'super' arguments
    |   '.' 'new' (nonWildcardTypeArguments)? innerCreator
    |   ( { r = orig; } ) // no suffix 
	;
	
creator
	:	nonWildcardTypeArguments? createdName
        (arrayCreatorRest | classCreatorRest)
	;

createdName
	:	Identifier typeArguments?
        ('.' Identifier typeArguments?)*
    |	primitiveType
	;
	
innerCreator
	:	Identifier classCreatorRest
	;

arrayCreatorRest
	:	'['
        (   ']' ('[' ']')* arrayInitializer
        |   expression ']' ('[' expression ']')* ('[' ']')*
        )
	;

classCreatorRest
	:	arguments classBody[null]?
	;
	
explicitGenericInvocation
	:	nonWildcardTypeArguments explicitGenericInvocationSuffix
	;
	
nonWildcardTypeArguments
	:	'<' typeList '>'
	;
	
explicitGenericInvocationSuffix
	:	'super' superSuffix
	|   Identifier arguments
	;
	
selector
	:	'.' Identifier (arguments)?
	|   '.' 'this'
	|   '.' 'super' superSuffix
	|   '.' 'new' (nonWildcardTypeArguments)? innerCreator
	|   '[' expression ']'
	;
	
superSuffix
	:	arguments
	|   '.' Identifier (arguments)?
    ;

arguments returns [List<Expression> r]
@after{ if (r == null) r = new ArrayList<Expression>(); }
	:	'(' (r_=expressionList {r=r_;})? ')'
	;

// LEXER

HexLiteral : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;

DecimalLiteral : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;

OctalLiteral : '0' ('0'..'7')+ IntegerTypeSuffix? ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
IntegerTypeSuffix : ('l'|'L') ;

FloatingPointLiteral
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   ('0'..'9')+ Exponent FloatTypeSuffix?
    |   ('0'..'9')+ Exponent? FloatTypeSuffix
	;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D') ;

CharacterLiteral
    :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
    ;

StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

ENUM:	'enum' {if ( !enumIsKeyword ) $type=Identifier;}
	;
	
Identifier 
    :   Letter (Letter|JavaIDDigit)*
    ;

/**I found this char range in JavaCC's grammar, but Letter and Digit overlap.
   Still works, but...
 */
fragment
Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

JAVADOC
    :   '/**' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ; 

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
