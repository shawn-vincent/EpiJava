// $ANTLR 3.0.1 src/com/epijava/grammar/EpiJava.g 2008-08-18 22:21:23

  package com.epijava.lang.grammar;
  import com.epijava.lang.tree.*;
import com.epijava.util.*;

  import java.util.*;
  import org.antlr.runtime.BitSet;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class EpiJavaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "ENUM", "FloatingPointLiteral", "CharacterLiteral", "StringLiteral", "HexLiteral", "OctalLiteral", "DecimalLiteral", "HexDigit", "IntegerTypeSuffix", "Exponent", "FloatTypeSuffix", "EscapeSequence", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "JAVADOC", "COMMENT", "LINE_COMMENT", "'package'", "';'", "'import'", "'static'", "'.'", "'*'", "'class'", "'extends'", "'implements'", "'<'", "','", "'>'", "'&'", "'{'", "'}'", "'interface'", "'void'", "'['", "']'", "'throws'", "'='", "'public'", "'protected'", "'private'", "'abstract'", "'final'", "'native'", "'synchronized'", "'transient'", "'volatile'", "'strictfp'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'?'", "'super'", "'('", "')'", "'...'", "'null'", "'true'", "'false'", "'@'", "'default'", "'assert'", "':'", "'if'", "'else'", "'for'", "'while'", "'do'", "'try'", "'finally'", "'switch'", "'return'", "'throw'", "'break'", "'continue'", "'catch'", "'case'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", "'||'", "'&&'", "'|'", "'^'", "'=='", "'!='", "'instanceof'", "'+'", "'-'", "'/'", "'%'", "'++'", "'--'", "'~'", "'!'", "'this'", "'new'"
    };
    public static final int Exponent=14;
    public static final int OctalLiteral=10;
    public static final int IntegerTypeSuffix=13;
    public static final int Identifier=4;
    public static final int HexDigit=12;
    public static final int WS=21;
    public static final int CharacterLiteral=7;
    public static final int COMMENT=23;
    public static final int JAVADOC=22;
    public static final int StringLiteral=8;
    public static final int LINE_COMMENT=24;
    public static final int JavaIDDigit=20;
    public static final int Letter=19;
    public static final int UnicodeEscape=17;
    public static final int HexLiteral=9;
    public static final int EscapeSequence=16;
    public static final int EOF=-1;
    public static final int DecimalLiteral=11;
    public static final int OctalEscape=18;
    public static final int FloatingPointLiteral=6;
    public static final int FloatTypeSuffix=15;
    public static final int ENUM=5;

        public EpiJavaParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[404+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "src/com/epijava/grammar/EpiJava.g"; }


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



    // $ANTLR start compilationUnit
    // src/com/epijava/grammar/EpiJava.g:145:1: compilationUnit returns [CompilationUnit r] : as= annotations (packageName= packageDeclaration )? is= importDeclarations ts= typeDeclarations topLevelStatements[r] ;
    public final CompilationUnit compilationUnit() throws RecognitionException {
        CompilationUnit r = null;
        int compilationUnit_StartIndex = input.index();
        List<Annotation> as = null;

        QualifiedName packageName = null;

        List<Import> is = null;

        List<TypeDeclaration> ts = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 1) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:146:2: (as= annotations (packageName= packageDeclaration )? is= importDeclarations ts= typeDeclarations topLevelStatements[r] )
            // src/com/epijava/grammar/EpiJava.g:146:4: as= annotations (packageName= packageDeclaration )? is= importDeclarations ts= typeDeclarations topLevelStatements[r]
            {
            pushFollow(FOLLOW_annotations_in_compilationUnit73);
            as=annotations();
            _fsp--;
            if (failed) return r;
            // src/com/epijava/grammar/EpiJava.g:147:14: (packageName= packageDeclaration )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==25) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:0:0: packageName= packageDeclaration
                    {
                    pushFollow(FOLLOW_packageDeclaration_in_compilationUnit79);
                    packageName=packageDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }

            pushFollow(FOLLOW_importDeclarations_in_compilationUnit92);
            is=importDeclarations();
            _fsp--;
            if (failed) return r;
            pushFollow(FOLLOW_typeDeclarations_in_compilationUnit104);
            ts=typeDeclarations();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {

                    	   r = new CompilationUnit(new Locus.ConstantLocus(locusModule, -1));
                         r.setAnnotations(as);
                         r.setPackageName(packageName);
                         r.setImports(is);
                         r.addTypes(ts);
                      
            }
            pushFollow(FOLLOW_topLevelStatements_in_compilationUnit174);
            topLevelStatements(r);
            _fsp--;
            if (failed) return r;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 1, compilationUnit_StartIndex); }
        }
        return r;
    }
    // $ANTLR end compilationUnit


    // $ANTLR start topLevelStatements
    // src/com/epijava/grammar/EpiJava.g:166:1: topLevelStatements[CompilationUnit c] : (s= topLevelStatement )* ;
    public final void topLevelStatements(CompilationUnit c) throws RecognitionException {
        int topLevelStatements_StartIndex = input.index();
        Expression s = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:167:5: ( (s= topLevelStatement )* )
            // src/com/epijava/grammar/EpiJava.g:168:13: (s= topLevelStatement )*
            {
            // src/com/epijava/grammar/EpiJava.g:168:13: (s= topLevelStatement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||(LA2_0>=FloatingPointLiteral && LA2_0<=DecimalLiteral)||LA2_0==26||LA2_0==34||LA2_0==38||LA2_0==41||LA2_0==50||LA2_0==52||(LA2_0>=56 && LA2_0<=63)||(LA2_0>=65 && LA2_0<=66)||(LA2_0>=69 && LA2_0<=72)||LA2_0==74||LA2_0==76||(LA2_0>=78 && LA2_0<=81)||(LA2_0>=83 && LA2_0<=87)||(LA2_0>=105 && LA2_0<=106)||(LA2_0>=109 && LA2_0<=114)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:168:14: s= topLevelStatement
            	    {
            	    pushFollow(FOLLOW_topLevelStatement_in_topLevelStatements208);
            	    s=topLevelStatement();
            	    _fsp--;
            	    if (failed) return ;
            	    if ( backtracking==0 ) {
            	      c.addTopLevelStatement(s);
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 2, topLevelStatements_StartIndex); }
        }
        return ;
    }
    // $ANTLR end topLevelStatements


    // $ANTLR start packageDeclaration
    // src/com/epijava/grammar/EpiJava.g:171:1: packageDeclaration returns [QualifiedName r] : 'package' r_= qualifiedName ';' ;
    public final QualifiedName packageDeclaration() throws RecognitionException {
        QualifiedName r = null;
        int packageDeclaration_StartIndex = input.index();
        QualifiedName r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 3) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:173:2: ( 'package' r_= qualifiedName ';' )
            // src/com/epijava/grammar/EpiJava.g:173:4: 'package' r_= qualifiedName ';'
            {
            match(input,25,FOLLOW_25_in_packageDeclaration239); if (failed) return r;
            pushFollow(FOLLOW_qualifiedName_in_packageDeclaration243);
            r_=qualifiedName();
            _fsp--;
            if (failed) return r;
            match(input,26,FOLLOW_26_in_packageDeclaration245); if (failed) return r;

            }

            if ( backtracking==0 ) {
               r=r_; 
            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 3, packageDeclaration_StartIndex); }
        }
        return r;
    }
    // $ANTLR end packageDeclaration


    // $ANTLR start importDeclarations
    // src/com/epijava/grammar/EpiJava.g:176:1: importDeclarations returns [List<Import> r] : (i= importDeclaration )* ;
    public final List<Import> importDeclarations() throws RecognitionException {
        List<Import> r = null;
        int importDeclarations_StartIndex = input.index();
        Import i = null;



              r=new ArrayList<Import>();
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 4) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:180:5: ( (i= importDeclaration )* )
            // src/com/epijava/grammar/EpiJava.g:180:9: (i= importDeclaration )*
            {
            // src/com/epijava/grammar/EpiJava.g:180:9: (i= importDeclaration )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==27) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:180:10: i= importDeclaration
            	    {
            	    pushFollow(FOLLOW_importDeclaration_in_importDeclarations278);
            	    i=importDeclaration();
            	    _fsp--;
            	    if (failed) return r;
            	    if ( backtracking==0 ) {
            	       r.add(i); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 4, importDeclarations_StartIndex); }
        }
        return r;
    }
    // $ANTLR end importDeclarations


    // $ANTLR start importDeclaration
    // src/com/epijava/grammar/EpiJava.g:183:1: importDeclaration returns [Import r] : t= 'import' ( 'static' )? qname= qualifiedName ( '.' '*' )? ';' ;
    public final Import importDeclaration() throws RecognitionException {
        Import r = null;
        int importDeclaration_StartIndex = input.index();
        Token t=null;
        QualifiedName qname = null;



              boolean importStar = false;
              boolean staticImport = false;
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 5) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:191:2: (t= 'import' ( 'static' )? qname= qualifiedName ( '.' '*' )? ';' )
            // src/com/epijava/grammar/EpiJava.g:191:4: t= 'import' ( 'static' )? qname= qualifiedName ( '.' '*' )? ';'
            {
            t=(Token)input.LT(1);
            match(input,27,FOLLOW_27_in_importDeclaration320); if (failed) return r;
            // src/com/epijava/grammar/EpiJava.g:191:15: ( 'static' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==28) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:191:16: 'static'
                    {
                    match(input,28,FOLLOW_28_in_importDeclaration323); if (failed) return r;
                    if ( backtracking==0 ) {
                      staticImport=true;
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_qualifiedName_in_importDeclaration339);
            qname=qualifiedName();
            _fsp--;
            if (failed) return r;
            // src/com/epijava/grammar/EpiJava.g:192:29: ( '.' '*' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==29) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:192:30: '.' '*'
                    {
                    match(input,29,FOLLOW_29_in_importDeclaration342); if (failed) return r;
                    match(input,30,FOLLOW_30_in_importDeclaration344); if (failed) return r;
                    if ( backtracking==0 ) {
                      importStar=true;
                    }

                    }
                    break;

            }

            match(input,26,FOLLOW_26_in_importDeclaration350); if (failed) return r;

            }

            if ( backtracking==0 ) {

                    r = new Import(l(t), qname, importStar, staticImport);
                  
            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 5, importDeclaration_StartIndex); }
        }
        return r;
    }
    // $ANTLR end importDeclaration


    // $ANTLR start typeDeclarations
    // src/com/epijava/grammar/EpiJava.g:195:1: typeDeclarations returns [List<TypeDeclaration> r] : (typeDecl= typeDeclaration )* ;
    public final List<TypeDeclaration> typeDeclarations() throws RecognitionException {
        List<TypeDeclaration> r = null;
        int typeDeclarations_StartIndex = input.index();
        TypeDeclaration typeDecl = null;



              r = new ArrayList<TypeDeclaration>();
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 6) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:199:5: ( (typeDecl= typeDeclaration )* )
            // src/com/epijava/grammar/EpiJava.g:199:9: (typeDecl= typeDeclaration )*
            {
            // src/com/epijava/grammar/EpiJava.g:199:9: (typeDecl= typeDeclaration )*
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case 50:
                    {
                    switch ( input.LA(2) ) {
                    case ENUM:
                    case 28:
                    case 31:
                    case 40:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                        {
                        alt6=1;
                        }
                        break;
                    case 72:
                        {
                        int LA6_63 = input.LA(3);

                        if ( (synpred6()) ) {
                            alt6=1;
                        }


                        }
                        break;
                    case 50:
                        {
                        int LA6_69 = input.LA(3);

                        if ( (synpred6()) ) {
                            alt6=1;
                        }


                        }
                        break;

                    }

                    }
                    break;
                case 72:
                    {
                    int LA6_2 = input.LA(2);

                    if ( (LA6_2==40) ) {
                        alt6=1;
                    }
                    else if ( (LA6_2==Identifier) ) {
                        int LA6_85 = input.LA(3);

                        if ( (synpred6()) ) {
                            alt6=1;
                        }


                    }


                    }
                    break;
                case 52:
                    {
                    int LA6_20 = input.LA(2);

                    if ( (LA6_20==ENUM||LA6_20==28||LA6_20==31||LA6_20==40||(LA6_20>=46 && LA6_20<=55)||LA6_20==72) ) {
                        alt6=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA6_25 = input.LA(2);

                    if ( (synpred6()) ) {
                        alt6=1;
                    }


                    }
                    break;
                case ENUM:
                case 28:
                case 31:
                case 40:
                case 46:
                case 47:
                case 48:
                case 49:
                case 51:
                case 53:
                case 54:
                case 55:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:199:10: typeDecl= typeDeclaration
            	    {
            	    pushFollow(FOLLOW_typeDeclaration_in_typeDeclarations383);
            	    typeDecl=typeDeclaration();
            	    _fsp--;
            	    if (failed) return r;
            	    if ( backtracking==0 ) {
            	      if (typeDecl != null) r.add(typeDecl);
            	    }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 6, typeDeclarations_StartIndex); }
        }
        return r;
    }
    // $ANTLR end typeDeclarations


    // $ANTLR start typeDeclaration
    // src/com/epijava/grammar/EpiJava.g:202:1: typeDeclaration returns [TypeDeclaration r] : (r_= classOrInterfaceDeclaration | ';' );
    public final TypeDeclaration typeDeclaration() throws RecognitionException {
        TypeDeclaration r = null;
        int typeDeclaration_StartIndex = input.index();
        TypeDeclaration r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 7) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:204:2: (r_= classOrInterfaceDeclaration | ';' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ENUM||LA7_0==28||LA7_0==31||LA7_0==40||(LA7_0>=46 && LA7_0<=55)||LA7_0==72) ) {
                alt7=1;
            }
            else if ( (LA7_0==26) ) {
                alt7=2;
            }
            else {
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("202:1: typeDeclaration returns [TypeDeclaration r] : (r_= classOrInterfaceDeclaration | ';' );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:204:4: r_= classOrInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_typeDeclaration416);
                    r_=classOrInterfaceDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:205:9: ';'
                    {
                    match(input,26,FOLLOW_26_in_typeDeclaration426); if (failed) return r;

                    }
                    break;

            }
            if ( backtracking==0 ) {
               r=r_; 
            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 7, typeDeclaration_StartIndex); }
        }
        return r;
    }
    // $ANTLR end typeDeclaration


    // $ANTLR start classOrInterfaceDeclaration
    // src/com/epijava/grammar/EpiJava.g:208:1: classOrInterfaceDeclaration returns [TypeDeclaration r] : ( modifier )* (r_= classDeclaration | r_= interfaceDeclaration ) ;
    public final TypeDeclaration classOrInterfaceDeclaration() throws RecognitionException {
        TypeDeclaration r = null;
        int classOrInterfaceDeclaration_StartIndex = input.index();
        TypeDeclaration r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 8) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:211:2: ( ( modifier )* (r_= classDeclaration | r_= interfaceDeclaration ) )
            // src/com/epijava/grammar/EpiJava.g:211:4: ( modifier )* (r_= classDeclaration | r_= interfaceDeclaration )
            {
            // src/com/epijava/grammar/EpiJava.g:211:4: ( modifier )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==72) ) {
                    int LA8_4 = input.LA(2);

                    if ( (LA8_4==Identifier) ) {
                        alt8=1;
                    }


                }
                else if ( (LA8_0==28||(LA8_0>=46 && LA8_0<=55)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:0:0: modifier
            	    {
            	    pushFollow(FOLLOW_modifier_in_classOrInterfaceDeclaration458);
            	    modifier();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // src/com/epijava/grammar/EpiJava.g:211:14: (r_= classDeclaration | r_= interfaceDeclaration )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ENUM||LA9_0==31) ) {
                alt9=1;
            }
            else if ( (LA9_0==40||LA9_0==72) ) {
                alt9=2;
            }
            else {
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("211:14: (r_= classDeclaration | r_= interfaceDeclaration )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:211:15: r_= classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_classOrInterfaceDeclaration464);
                    r_=classDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:211:37: r_= interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_classOrInterfaceDeclaration470);
                    r_=interfaceDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               r=r_; 
            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 8, classOrInterfaceDeclaration_StartIndex); }
        }
        return r;
    }
    // $ANTLR end classOrInterfaceDeclaration


    // $ANTLR start classDeclaration
    // src/com/epijava/grammar/EpiJava.g:214:1: classDeclaration returns [TypeDeclaration r] : (r_= normalClassDeclaration | enumDeclaration );
    public final TypeDeclaration classDeclaration() throws RecognitionException {
        TypeDeclaration r = null;
        int classDeclaration_StartIndex = input.index();
        ClassDeclaration r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 9) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:216:2: (r_= normalClassDeclaration | enumDeclaration )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==31) ) {
                alt10=1;
            }
            else if ( (LA10_0==ENUM) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("214:1: classDeclaration returns [TypeDeclaration r] : (r_= normalClassDeclaration | enumDeclaration );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:216:4: r_= normalClassDeclaration
                    {
                    pushFollow(FOLLOW_normalClassDeclaration_in_classDeclaration498);
                    r_=normalClassDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:217:9: enumDeclaration
                    {
                    pushFollow(FOLLOW_enumDeclaration_in_classDeclaration508);
                    enumDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }
            if ( backtracking==0 ) {
               r=r_; 
            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 9, classDeclaration_StartIndex); }
        }
        return r;
    }
    // $ANTLR end classDeclaration


    // $ANTLR start normalClassDeclaration
    // src/com/epijava/grammar/EpiJava.g:220:1: normalClassDeclaration returns [ClassDeclaration r] : t= 'class' id= Identifier ( typeParameters )? ( 'extends' superType= type )? ( 'implements' interfaces= typeList )? classBody[r] ;
    public final ClassDeclaration normalClassDeclaration() throws RecognitionException {
        ClassDeclaration r = null;
        int normalClassDeclaration_StartIndex = input.index();
        Token t=null;
        Token id=null;
        TypeReference superType = null;

        List<TypeReference> interfaces = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 10) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:221:2: (t= 'class' id= Identifier ( typeParameters )? ( 'extends' superType= type )? ( 'implements' interfaces= typeList )? classBody[r] )
            // src/com/epijava/grammar/EpiJava.g:221:4: t= 'class' id= Identifier ( typeParameters )? ( 'extends' superType= type )? ( 'implements' interfaces= typeList )? classBody[r]
            {
            t=(Token)input.LT(1);
            match(input,31,FOLLOW_31_in_normalClassDeclaration526); if (failed) return r;
            id=(Token)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_normalClassDeclaration530); if (failed) return r;
            // src/com/epijava/grammar/EpiJava.g:221:28: ( typeParameters )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==34) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:221:29: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_normalClassDeclaration533);
                    typeParameters();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               r = new ClassDeclaration(l(t), id.getText()); 
            }
            // src/com/epijava/grammar/EpiJava.g:223:9: ( 'extends' superType= type )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:223:10: 'extends' superType= type
                    {
                    match(input,32,FOLLOW_32_in_normalClassDeclaration555); if (failed) return r;
                    pushFollow(FOLLOW_type_in_normalClassDeclaration559);
                    superType=type();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r.setSuperType(superType); 
                    }

                    }
                    break;

            }

            // src/com/epijava/grammar/EpiJava.g:224:9: ( 'implements' interfaces= typeList )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==33) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:224:10: 'implements' interfaces= typeList
                    {
                    match(input,33,FOLLOW_33_in_normalClassDeclaration574); if (failed) return r;
                    pushFollow(FOLLOW_typeList_in_normalClassDeclaration578);
                    interfaces=typeList();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r.setInterfaces(interfaces); 
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_classBody_in_normalClassDeclaration592);
            classBody(r);
            _fsp--;
            if (failed) return r;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 10, normalClassDeclaration_StartIndex); }
        }
        return r;
    }
    // $ANTLR end normalClassDeclaration


    // $ANTLR start typeParameters
    // src/com/epijava/grammar/EpiJava.g:228:1: typeParameters : '<' typeParameter ( ',' typeParameter )* '>' ;
    public final void typeParameters() throws RecognitionException {
        int typeParameters_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:229:2: ( '<' typeParameter ( ',' typeParameter )* '>' )
            // src/com/epijava/grammar/EpiJava.g:229:4: '<' typeParameter ( ',' typeParameter )* '>'
            {
            match(input,34,FOLLOW_34_in_typeParameters605); if (failed) return ;
            pushFollow(FOLLOW_typeParameter_in_typeParameters607);
            typeParameter();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:229:22: ( ',' typeParameter )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==35) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:229:23: ',' typeParameter
            	    {
            	    match(input,35,FOLLOW_35_in_typeParameters610); if (failed) return ;
            	    pushFollow(FOLLOW_typeParameter_in_typeParameters612);
            	    typeParameter();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match(input,36,FOLLOW_36_in_typeParameters616); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 11, typeParameters_StartIndex); }
        }
        return ;
    }
    // $ANTLR end typeParameters


    // $ANTLR start typeParameter
    // src/com/epijava/grammar/EpiJava.g:232:1: typeParameter : Identifier ( 'extends' bound )? ;
    public final void typeParameter() throws RecognitionException {
        int typeParameter_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:233:2: ( Identifier ( 'extends' bound )? )
            // src/com/epijava/grammar/EpiJava.g:233:4: Identifier ( 'extends' bound )?
            {
            match(input,Identifier,FOLLOW_Identifier_in_typeParameter627); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:233:15: ( 'extends' bound )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==32) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:233:16: 'extends' bound
                    {
                    match(input,32,FOLLOW_32_in_typeParameter630); if (failed) return ;
                    pushFollow(FOLLOW_bound_in_typeParameter632);
                    bound();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 12, typeParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end typeParameter


    // $ANTLR start bound
    // src/com/epijava/grammar/EpiJava.g:236:1: bound : type ( '&' type )* ;
    public final void bound() throws RecognitionException {
        int bound_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:237:2: ( type ( '&' type )* )
            // src/com/epijava/grammar/EpiJava.g:237:4: type ( '&' type )*
            {
            pushFollow(FOLLOW_type_in_bound647);
            type();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:237:9: ( '&' type )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==37) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:237:10: '&' type
            	    {
            	    match(input,37,FOLLOW_37_in_bound650); if (failed) return ;
            	    pushFollow(FOLLOW_type_in_bound652);
            	    type();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 13, bound_StartIndex); }
        }
        return ;
    }
    // $ANTLR end bound


    // $ANTLR start enumDeclaration
    // src/com/epijava/grammar/EpiJava.g:240:1: enumDeclaration : ENUM Identifier ( 'implements' typeList )? enumBody ;
    public final void enumDeclaration() throws RecognitionException {
        int enumDeclaration_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:241:2: ( ENUM Identifier ( 'implements' typeList )? enumBody )
            // src/com/epijava/grammar/EpiJava.g:241:4: ENUM Identifier ( 'implements' typeList )? enumBody
            {
            match(input,ENUM,FOLLOW_ENUM_in_enumDeclaration665); if (failed) return ;
            match(input,Identifier,FOLLOW_Identifier_in_enumDeclaration667); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:241:20: ( 'implements' typeList )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:241:21: 'implements' typeList
                    {
                    match(input,33,FOLLOW_33_in_enumDeclaration670); if (failed) return ;
                    pushFollow(FOLLOW_typeList_in_enumDeclaration672);
                    typeList();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_enumBody_in_enumDeclaration676);
            enumBody();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 14, enumDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end enumDeclaration


    // $ANTLR start enumBody
    // src/com/epijava/grammar/EpiJava.g:244:1: enumBody : '{' ( enumConstants )? ( ',' )? ( enumBodyDeclarations )? '}' ;
    public final void enumBody() throws RecognitionException {
        int enumBody_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:245:2: ( '{' ( enumConstants )? ( ',' )? ( enumBodyDeclarations )? '}' )
            // src/com/epijava/grammar/EpiJava.g:245:4: '{' ( enumConstants )? ( ',' )? ( enumBodyDeclarations )? '}'
            {
            match(input,38,FOLLOW_38_in_enumBody688); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:245:8: ( enumConstants )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==Identifier||LA18_0==72) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:0:0: enumConstants
                    {
                    pushFollow(FOLLOW_enumConstants_in_enumBody690);
                    enumConstants();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            // src/com/epijava/grammar/EpiJava.g:245:23: ( ',' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:0:0: ','
                    {
                    match(input,35,FOLLOW_35_in_enumBody693); if (failed) return ;

                    }
                    break;

            }

            // src/com/epijava/grammar/EpiJava.g:245:28: ( enumBodyDeclarations )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:0:0: enumBodyDeclarations
                    {
                    pushFollow(FOLLOW_enumBodyDeclarations_in_enumBody696);
                    enumBodyDeclarations();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            match(input,39,FOLLOW_39_in_enumBody699); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 15, enumBody_StartIndex); }
        }
        return ;
    }
    // $ANTLR end enumBody


    // $ANTLR start enumConstants
    // src/com/epijava/grammar/EpiJava.g:248:1: enumConstants : enumConstant ( ',' enumConstant )* ;
    public final void enumConstants() throws RecognitionException {
        int enumConstants_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:249:2: ( enumConstant ( ',' enumConstant )* )
            // src/com/epijava/grammar/EpiJava.g:249:4: enumConstant ( ',' enumConstant )*
            {
            pushFollow(FOLLOW_enumConstant_in_enumConstants710);
            enumConstant();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:249:17: ( ',' enumConstant )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==35) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==Identifier||LA21_1==72) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:249:18: ',' enumConstant
            	    {
            	    match(input,35,FOLLOW_35_in_enumConstants713); if (failed) return ;
            	    pushFollow(FOLLOW_enumConstant_in_enumConstants715);
            	    enumConstant();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 16, enumConstants_StartIndex); }
        }
        return ;
    }
    // $ANTLR end enumConstants


    // $ANTLR start enumConstant
    // src/com/epijava/grammar/EpiJava.g:252:1: enumConstant : annotations Identifier ( arguments )? ( classBody[null] )? ;
    public final void enumConstant() throws RecognitionException {
        int enumConstant_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:253:2: ( annotations Identifier ( arguments )? ( classBody[null] )? )
            // src/com/epijava/grammar/EpiJava.g:253:4: annotations Identifier ( arguments )? ( classBody[null] )?
            {
            pushFollow(FOLLOW_annotations_in_enumConstant729);
            annotations();
            _fsp--;
            if (failed) return ;
            match(input,Identifier,FOLLOW_Identifier_in_enumConstant731); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:253:27: ( arguments )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==66) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:253:28: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_enumConstant734);
                    arguments();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            // src/com/epijava/grammar/EpiJava.g:253:40: ( classBody[null] )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==38) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:253:41: classBody[null]
                    {
                    pushFollow(FOLLOW_classBody_in_enumConstant739);
                    classBody(null);
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 17, enumConstant_StartIndex); }
        }
        return ;
    }
    // $ANTLR end enumConstant


    // $ANTLR start enumBodyDeclarations
    // src/com/epijava/grammar/EpiJava.g:256:1: enumBodyDeclarations : ';' ( classBodyDeclaration )* ;
    public final void enumBodyDeclarations() throws RecognitionException {
        int enumBodyDeclarations_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:257:2: ( ';' ( classBodyDeclaration )* )
            // src/com/epijava/grammar/EpiJava.g:257:4: ';' ( classBodyDeclaration )*
            {
            match(input,26,FOLLOW_26_in_enumBodyDeclarations754); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:257:8: ( classBodyDeclaration )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=Identifier && LA24_0<=ENUM)||LA24_0==26||LA24_0==28||LA24_0==31||LA24_0==34||LA24_0==38||(LA24_0>=40 && LA24_0<=41)||(LA24_0>=46 && LA24_0<=63)||LA24_0==72) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:257:9: classBodyDeclaration
            	    {
            	    pushFollow(FOLLOW_classBodyDeclaration_in_enumBodyDeclarations757);
            	    classBodyDeclaration();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 18, enumBodyDeclarations_StartIndex); }
        }
        return ;
    }
    // $ANTLR end enumBodyDeclarations


    // $ANTLR start interfaceDeclaration
    // src/com/epijava/grammar/EpiJava.g:260:1: interfaceDeclaration returns [TypeDeclaration r] : ( normalInterfaceDeclaration | annotationTypeDeclaration );
    public final TypeDeclaration interfaceDeclaration() throws RecognitionException {
        TypeDeclaration r = null;
        int interfaceDeclaration_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 19) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:261:2: ( normalInterfaceDeclaration | annotationTypeDeclaration )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==40) ) {
                alt25=1;
            }
            else if ( (LA25_0==72) ) {
                alt25=2;
            }
            else {
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("260:1: interfaceDeclaration returns [TypeDeclaration r] : ( normalInterfaceDeclaration | annotationTypeDeclaration );", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:261:4: normalInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_normalInterfaceDeclaration_in_interfaceDeclaration775);
                    normalInterfaceDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:262:5: annotationTypeDeclaration
                    {
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_interfaceDeclaration781);
                    annotationTypeDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 19, interfaceDeclaration_StartIndex); }
        }
        return r;
    }
    // $ANTLR end interfaceDeclaration


    // $ANTLR start normalInterfaceDeclaration
    // src/com/epijava/grammar/EpiJava.g:265:1: normalInterfaceDeclaration : 'interface' Identifier ( typeParameters )? ( 'extends' typeList )? interfaceBody ;
    public final void normalInterfaceDeclaration() throws RecognitionException {
        int normalInterfaceDeclaration_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:266:2: ( 'interface' Identifier ( typeParameters )? ( 'extends' typeList )? interfaceBody )
            // src/com/epijava/grammar/EpiJava.g:266:4: 'interface' Identifier ( typeParameters )? ( 'extends' typeList )? interfaceBody
            {
            match(input,40,FOLLOW_40_in_normalInterfaceDeclaration793); if (failed) return ;
            match(input,Identifier,FOLLOW_Identifier_in_normalInterfaceDeclaration795); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:266:27: ( typeParameters )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:0:0: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_normalInterfaceDeclaration797);
                    typeParameters();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            // src/com/epijava/grammar/EpiJava.g:266:43: ( 'extends' typeList )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:266:44: 'extends' typeList
                    {
                    match(input,32,FOLLOW_32_in_normalInterfaceDeclaration801); if (failed) return ;
                    pushFollow(FOLLOW_typeList_in_normalInterfaceDeclaration803);
                    typeList();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_interfaceBody_in_normalInterfaceDeclaration807);
            interfaceBody();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 20, normalInterfaceDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end normalInterfaceDeclaration


    // $ANTLR start typeList
    // src/com/epijava/grammar/EpiJava.g:269:1: typeList returns [List<TypeReference> r] : t= type ( ',' t= type )* ;
    public final List<TypeReference> typeList() throws RecognitionException {
        List<TypeReference> r = null;
        int typeList_StartIndex = input.index();
        TypeReference t = null;


         r=new ArrayList<TypeReference>(); 
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 21) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:271:2: (t= type ( ',' t= type )* )
            // src/com/epijava/grammar/EpiJava.g:271:4: t= type ( ',' t= type )*
            {
            pushFollow(FOLLOW_type_in_typeList832);
            t=type();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r.add(t);
            }
            // src/com/epijava/grammar/EpiJava.g:271:23: ( ',' t= type )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==35) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:271:24: ',' t= type
            	    {
            	    match(input,35,FOLLOW_35_in_typeList837); if (failed) return r;
            	    pushFollow(FOLLOW_type_in_typeList841);
            	    t=type();
            	    _fsp--;
            	    if (failed) return r;
            	    if ( backtracking==0 ) {
            	      r.add(t);
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 21, typeList_StartIndex); }
        }
        return r;
    }
    // $ANTLR end typeList


    // $ANTLR start classBody
    // src/com/epijava/grammar/EpiJava.g:274:1: classBody[TypeDeclaration r] : '{' (member= classBodyDeclaration )* '}' ;
    public final void classBody(TypeDeclaration r) throws RecognitionException {
        int classBody_StartIndex = input.index();
        MemberDeclaration member = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:275:2: ( '{' (member= classBodyDeclaration )* '}' )
            // src/com/epijava/grammar/EpiJava.g:275:4: '{' (member= classBodyDeclaration )* '}'
            {
            match(input,38,FOLLOW_38_in_classBody858); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:275:8: (member= classBodyDeclaration )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=Identifier && LA29_0<=ENUM)||LA29_0==26||LA29_0==28||LA29_0==31||LA29_0==34||LA29_0==38||(LA29_0>=40 && LA29_0<=41)||(LA29_0>=46 && LA29_0<=63)||LA29_0==72) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:275:9: member= classBodyDeclaration
            	    {
            	    pushFollow(FOLLOW_classBodyDeclaration_in_classBody863);
            	    member=classBodyDeclaration();
            	    _fsp--;
            	    if (failed) return ;
            	    if ( backtracking==0 ) {
            	       if (member != null) r.add(member); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            match(input,39,FOLLOW_39_in_classBody869); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 22, classBody_StartIndex); }
        }
        return ;
    }
    // $ANTLR end classBody


    // $ANTLR start interfaceBody
    // src/com/epijava/grammar/EpiJava.g:278:1: interfaceBody : '{' ( interfaceBodyDeclaration )* '}' ;
    public final void interfaceBody() throws RecognitionException {
        int interfaceBody_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:279:2: ( '{' ( interfaceBodyDeclaration )* '}' )
            // src/com/epijava/grammar/EpiJava.g:279:4: '{' ( interfaceBodyDeclaration )* '}'
            {
            match(input,38,FOLLOW_38_in_interfaceBody881); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:279:8: ( interfaceBodyDeclaration )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=Identifier && LA30_0<=ENUM)||LA30_0==26||LA30_0==28||LA30_0==31||LA30_0==34||(LA30_0>=40 && LA30_0<=41)||(LA30_0>=46 && LA30_0<=63)||LA30_0==72) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:0:0: interfaceBodyDeclaration
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody883);
            	    interfaceBodyDeclaration();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            match(input,39,FOLLOW_39_in_interfaceBody886); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 23, interfaceBody_StartIndex); }
        }
        return ;
    }
    // $ANTLR end interfaceBody


    // $ANTLR start classBodyDeclaration
    // src/com/epijava/grammar/EpiJava.g:282:1: classBodyDeclaration returns [MemberDeclaration r] : ( ';' | ( 'static' )? b= block | ( modifier )* r_= memberDecl );
    public final MemberDeclaration classBodyDeclaration() throws RecognitionException {
        MemberDeclaration r = null;
        int classBodyDeclaration_StartIndex = input.index();
        Block b = null;

        MemberDeclaration r_ = null;



               boolean staticBlock = false;
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 24) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:286:2: ( ';' | ( 'static' )? b= block | ( modifier )* r_= memberDecl )
            int alt33=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt33=1;
                }
                break;
            case 28:
                {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==38) ) {
                    alt33=2;
                }
                else if ( ((LA33_2>=Identifier && LA33_2<=ENUM)||LA33_2==28||LA33_2==31||LA33_2==34||(LA33_2>=40 && LA33_2<=41)||(LA33_2>=46 && LA33_2<=63)||LA33_2==72) ) {
                    alt33=3;
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("282:1: classBodyDeclaration returns [MemberDeclaration r] : ( ';' | ( 'static' )? b= block | ( modifier )* r_= memberDecl );", 33, 2, input);

                    throw nvae;
                }
                }
                break;
            case 38:
                {
                alt33=2;
                }
                break;
            case Identifier:
            case ENUM:
            case 31:
            case 34:
            case 40:
            case 41:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 72:
                {
                alt33=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("282:1: classBodyDeclaration returns [MemberDeclaration r] : ( ';' | ( 'static' )? b= block | ( modifier )* r_= memberDecl );", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:286:4: ';'
                    {
                    match(input,26,FOLLOW_26_in_classBodyDeclaration910); if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:287:4: ( 'static' )? b= block
                    {
                    // src/com/epijava/grammar/EpiJava.g:287:4: ( 'static' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==28) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:287:5: 'static'
                            {
                            match(input,28,FOLLOW_28_in_classBodyDeclaration916); if (failed) return r;
                            if ( backtracking==0 ) {
                              staticBlock=true;
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_classBodyDeclaration924);
                    b=block();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r = new BlockMember(l(b), staticBlock, b); 
                    }

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:289:4: ( modifier )* r_= memberDecl
                    {
                    // src/com/epijava/grammar/EpiJava.g:289:4: ( modifier )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==72) ) {
                            int LA32_13 = input.LA(2);

                            if ( (LA32_13==Identifier) ) {
                                alt32=1;
                            }


                        }
                        else if ( (LA32_0==28||(LA32_0>=46 && LA32_0<=55)) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:0:0: modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_classBodyDeclaration938);
                    	    modifier();
                    	    _fsp--;
                    	    if (failed) return r;

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    pushFollow(FOLLOW_memberDecl_in_classBodyDeclaration943);
                    r_=memberDecl();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r = r_; 
                    }

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 24, classBodyDeclaration_StartIndex); }
        }
        return r;
    }
    // $ANTLR end classBodyDeclaration


    // $ANTLR start memberDecl
    // src/com/epijava/grammar/EpiJava.g:292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );
    public final MemberDeclaration memberDecl() throws RecognitionException {
        MemberDeclaration r = null;
        int memberDecl_StartIndex = input.index();
        MethodDeclaration r_ = null;

        TypeDeclaration classDecl = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 25) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:293:2: ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration )
            int alt34=7;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt34=1;
                }
                break;
            case Identifier:
                {
                switch ( input.LA(2) ) {
                case 66:
                    {
                    alt34=5;
                    }
                    break;
                case 34:
                    {
                    int LA34_17 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 17, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    int LA34_18 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 18, input);

                        throw nvae;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA34_19 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 19, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    int LA34_20 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 20, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 2, input);

                    throw nvae;
                }

                }
                break;
            case 56:
                {
                int LA34_3 = input.LA(2);

                if ( (LA34_3==42) ) {
                    int LA34_21 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 21, input);

                        throw nvae;
                    }
                }
                else if ( (LA34_3==Identifier) ) {
                    int LA34_22 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 22, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 3, input);

                    throw nvae;
                }
                }
                break;
            case 57:
                {
                int LA34_4 = input.LA(2);

                if ( (LA34_4==42) ) {
                    int LA34_23 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 23, input);

                        throw nvae;
                    }
                }
                else if ( (LA34_4==Identifier) ) {
                    int LA34_24 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 24, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 4, input);

                    throw nvae;
                }
                }
                break;
            case 58:
                {
                int LA34_5 = input.LA(2);

                if ( (LA34_5==42) ) {
                    int LA34_25 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 25, input);

                        throw nvae;
                    }
                }
                else if ( (LA34_5==Identifier) ) {
                    int LA34_26 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 26, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 5, input);

                    throw nvae;
                }
                }
                break;
            case 59:
                {
                int LA34_6 = input.LA(2);

                if ( (LA34_6==42) ) {
                    int LA34_27 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 27, input);

                        throw nvae;
                    }
                }
                else if ( (LA34_6==Identifier) ) {
                    int LA34_28 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 28, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 6, input);

                    throw nvae;
                }
                }
                break;
            case 60:
                {
                int LA34_7 = input.LA(2);

                if ( (LA34_7==42) ) {
                    int LA34_29 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 29, input);

                        throw nvae;
                    }
                }
                else if ( (LA34_7==Identifier) ) {
                    int LA34_30 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 30, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 7, input);

                    throw nvae;
                }
                }
                break;
            case 61:
                {
                int LA34_8 = input.LA(2);

                if ( (LA34_8==42) ) {
                    int LA34_31 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 31, input);

                        throw nvae;
                    }
                }
                else if ( (LA34_8==Identifier) ) {
                    int LA34_32 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 32, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 8, input);

                    throw nvae;
                }
                }
                break;
            case 62:
                {
                int LA34_9 = input.LA(2);

                if ( (LA34_9==42) ) {
                    int LA34_33 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 33, input);

                        throw nvae;
                    }
                }
                else if ( (LA34_9==Identifier) ) {
                    int LA34_34 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 34, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 9, input);

                    throw nvae;
                }
                }
                break;
            case 63:
                {
                int LA34_10 = input.LA(2);

                if ( (LA34_10==42) ) {
                    int LA34_35 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 35, input);

                        throw nvae;
                    }
                }
                else if ( (LA34_10==Identifier) ) {
                    int LA34_36 = input.LA(3);

                    if ( (synpred36()) ) {
                        alt34=2;
                    }
                    else if ( (synpred37()) ) {
                        alt34=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 36, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 10, input);

                    throw nvae;
                }
                }
                break;
            case 41:
                {
                alt34=4;
                }
                break;
            case 40:
            case 72:
                {
                alt34=6;
                }
                break;
            case ENUM:
            case 31:
                {
                alt34=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("292:1: memberDecl returns [MemberDeclaration r] : ( genericMethodOrConstructorDecl | r_= methodDeclaration | fieldDeclaration | 'void' Identifier voidMethodDeclaratorRest | Identifier constructorDeclaratorRest | interfaceDeclaration | classDecl= classDeclaration );", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:293:4: genericMethodOrConstructorDecl
                    {
                    pushFollow(FOLLOW_genericMethodOrConstructorDecl_in_memberDecl961);
                    genericMethodOrConstructorDecl();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:294:4: r_= methodDeclaration
                    {
                    pushFollow(FOLLOW_methodDeclaration_in_memberDecl968);
                    r_=methodDeclaration();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r = r_; 
                    }

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:295:4: fieldDeclaration
                    {
                    pushFollow(FOLLOW_fieldDeclaration_in_memberDecl975);
                    fieldDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:296:4: 'void' Identifier voidMethodDeclaratorRest
                    {
                    match(input,41,FOLLOW_41_in_memberDecl980); if (failed) return r;
                    match(input,Identifier,FOLLOW_Identifier_in_memberDecl982); if (failed) return r;
                    pushFollow(FOLLOW_voidMethodDeclaratorRest_in_memberDecl984);
                    voidMethodDeclaratorRest();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:297:4: Identifier constructorDeclaratorRest
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_memberDecl989); if (failed) return r;
                    pushFollow(FOLLOW_constructorDeclaratorRest_in_memberDecl991);
                    constructorDeclaratorRest();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 6 :
                    // src/com/epijava/grammar/EpiJava.g:298:4: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_memberDecl996);
                    interfaceDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 7 :
                    // src/com/epijava/grammar/EpiJava.g:299:4: classDecl= classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_memberDecl1003);
                    classDecl=classDeclaration();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r=classDecl; 
                    }

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 25, memberDecl_StartIndex); }
        }
        return r;
    }
    // $ANTLR end memberDecl


    // $ANTLR start genericMethodOrConstructorDecl
    // src/com/epijava/grammar/EpiJava.g:302:1: genericMethodOrConstructorDecl : typeParameters genericMethodOrConstructorRest ;
    public final void genericMethodOrConstructorDecl() throws RecognitionException {
        int genericMethodOrConstructorDecl_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:303:2: ( typeParameters genericMethodOrConstructorRest )
            // src/com/epijava/grammar/EpiJava.g:303:4: typeParameters genericMethodOrConstructorRest
            {
            pushFollow(FOLLOW_typeParameters_in_genericMethodOrConstructorDecl1017);
            typeParameters();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_genericMethodOrConstructorRest_in_genericMethodOrConstructorDecl1019);
            genericMethodOrConstructorRest();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 26, genericMethodOrConstructorDecl_StartIndex); }
        }
        return ;
    }
    // $ANTLR end genericMethodOrConstructorDecl


    // $ANTLR start genericMethodOrConstructorRest
    // src/com/epijava/grammar/EpiJava.g:306:1: genericMethodOrConstructorRest : ( ( type | 'void' ) Identifier methodDeclaratorRest[null,null,null] | Identifier constructorDeclaratorRest );
    public final void genericMethodOrConstructorRest() throws RecognitionException {
        int genericMethodOrConstructorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:307:2: ( ( type | 'void' ) Identifier methodDeclaratorRest[null,null,null] | Identifier constructorDeclaratorRest )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Identifier) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==66) ) {
                    alt36=2;
                }
                else if ( (LA36_1==Identifier||LA36_1==29||LA36_1==34||LA36_1==42) ) {
                    alt36=1;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("306:1: genericMethodOrConstructorRest : ( ( type | 'void' ) Identifier methodDeclaratorRest[null,null,null] | Identifier constructorDeclaratorRest );", 36, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA36_0==41||(LA36_0>=56 && LA36_0<=63)) ) {
                alt36=1;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("306:1: genericMethodOrConstructorRest : ( ( type | 'void' ) Identifier methodDeclaratorRest[null,null,null] | Identifier constructorDeclaratorRest );", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:307:4: ( type | 'void' ) Identifier methodDeclaratorRest[null,null,null]
                    {
                    // src/com/epijava/grammar/EpiJava.g:307:4: ( type | 'void' )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==Identifier||(LA35_0>=56 && LA35_0<=63)) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==41) ) {
                        alt35=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("307:4: ( type | 'void' )", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:307:5: type
                            {
                            pushFollow(FOLLOW_type_in_genericMethodOrConstructorRest1032);
                            type();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;
                        case 2 :
                            // src/com/epijava/grammar/EpiJava.g:307:12: 'void'
                            {
                            match(input,41,FOLLOW_41_in_genericMethodOrConstructorRest1036); if (failed) return ;

                            }
                            break;

                    }

                    match(input,Identifier,FOLLOW_Identifier_in_genericMethodOrConstructorRest1039); if (failed) return ;
                    pushFollow(FOLLOW_methodDeclaratorRest_in_genericMethodOrConstructorRest1041);
                    methodDeclaratorRest(null, null, null);
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:308:4: Identifier constructorDeclaratorRest
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_genericMethodOrConstructorRest1048); if (failed) return ;
                    pushFollow(FOLLOW_constructorDeclaratorRest_in_genericMethodOrConstructorRest1050);
                    constructorDeclaratorRest();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 27, genericMethodOrConstructorRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end genericMethodOrConstructorRest


    // $ANTLR start methodDeclaration
    // src/com/epijava/grammar/EpiJava.g:311:1: methodDeclaration returns [MethodDeclaration r] : t= type id= Identifier r_= methodDeclaratorRest[l(id), t, id.getText()] ;
    public final MethodDeclaration methodDeclaration() throws RecognitionException {
        MethodDeclaration r = null;
        int methodDeclaration_StartIndex = input.index();
        Token id=null;
        TypeReference t = null;

        MethodDeclaration r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 28) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:312:2: (t= type id= Identifier r_= methodDeclaratorRest[l(id), t, id.getText()] )
            // src/com/epijava/grammar/EpiJava.g:312:4: t= type id= Identifier r_= methodDeclaratorRest[l(id), t, id.getText()]
            {
            pushFollow(FOLLOW_type_in_methodDeclaration1067);
            t=type();
            _fsp--;
            if (failed) return r;
            id=(Token)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_methodDeclaration1071); if (failed) return r;
            pushFollow(FOLLOW_methodDeclaratorRest_in_methodDeclaration1075);
            r_=methodDeclaratorRest(l(id),  t,  id.getText());
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
               r = r_; 
            }

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 28, methodDeclaration_StartIndex); }
        }
        return r;
    }
    // $ANTLR end methodDeclaration


    // $ANTLR start fieldDeclaration
    // src/com/epijava/grammar/EpiJava.g:316:1: fieldDeclaration : type variableDeclarators ';' ;
    public final void fieldDeclaration() throws RecognitionException {
        int fieldDeclaration_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:317:2: ( type variableDeclarators ';' )
            // src/com/epijava/grammar/EpiJava.g:317:4: type variableDeclarators ';'
            {
            pushFollow(FOLLOW_type_in_fieldDeclaration1094);
            type();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_variableDeclarators_in_fieldDeclaration1096);
            variableDeclarators();
            _fsp--;
            if (failed) return ;
            match(input,26,FOLLOW_26_in_fieldDeclaration1098); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 29, fieldDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end fieldDeclaration


    // $ANTLR start interfaceBodyDeclaration
    // src/com/epijava/grammar/EpiJava.g:320:1: interfaceBodyDeclaration : ( ( modifier )* interfaceMemberDecl | ';' );
    public final void interfaceBodyDeclaration() throws RecognitionException {
        int interfaceBodyDeclaration_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:321:2: ( ( modifier )* interfaceMemberDecl | ';' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=Identifier && LA38_0<=ENUM)||LA38_0==28||LA38_0==31||LA38_0==34||(LA38_0>=40 && LA38_0<=41)||(LA38_0>=46 && LA38_0<=63)||LA38_0==72) ) {
                alt38=1;
            }
            else if ( (LA38_0==26) ) {
                alt38=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("320:1: interfaceBodyDeclaration : ( ( modifier )* interfaceMemberDecl | ';' );", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:321:4: ( modifier )* interfaceMemberDecl
                    {
                    // src/com/epijava/grammar/EpiJava.g:321:4: ( modifier )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==72) ) {
                            int LA37_13 = input.LA(2);

                            if ( (LA37_13==Identifier) ) {
                                alt37=1;
                            }


                        }
                        else if ( (LA37_0==28||(LA37_0>=46 && LA37_0<=55)) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:0:0: modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_interfaceBodyDeclaration1111);
                    	    modifier();
                    	    _fsp--;
                    	    if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    pushFollow(FOLLOW_interfaceMemberDecl_in_interfaceBodyDeclaration1114);
                    interfaceMemberDecl();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:322:6: ';'
                    {
                    match(input,26,FOLLOW_26_in_interfaceBodyDeclaration1121); if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 30, interfaceBodyDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end interfaceBodyDeclaration


    // $ANTLR start interfaceMemberDecl
    // src/com/epijava/grammar/EpiJava.g:325:1: interfaceMemberDecl : ( interfaceMethodOrFieldDecl | interfaceGenericMethodDecl | 'void' Identifier voidInterfaceMethodDeclaratorRest | interfaceDeclaration | classDeclaration );
    public final void interfaceMemberDecl() throws RecognitionException {
        int interfaceMemberDecl_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:326:2: ( interfaceMethodOrFieldDecl | interfaceGenericMethodDecl | 'void' Identifier voidInterfaceMethodDeclaratorRest | interfaceDeclaration | classDeclaration )
            int alt39=5;
            switch ( input.LA(1) ) {
            case Identifier:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt39=1;
                }
                break;
            case 34:
                {
                alt39=2;
                }
                break;
            case 41:
                {
                alt39=3;
                }
                break;
            case 40:
            case 72:
                {
                alt39=4;
                }
                break;
            case ENUM:
            case 31:
                {
                alt39=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("325:1: interfaceMemberDecl : ( interfaceMethodOrFieldDecl | interfaceGenericMethodDecl | 'void' Identifier voidInterfaceMethodDeclaratorRest | interfaceDeclaration | classDeclaration );", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:326:4: interfaceMethodOrFieldDecl
                    {
                    pushFollow(FOLLOW_interfaceMethodOrFieldDecl_in_interfaceMemberDecl1132);
                    interfaceMethodOrFieldDecl();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:327:6: interfaceGenericMethodDecl
                    {
                    pushFollow(FOLLOW_interfaceGenericMethodDecl_in_interfaceMemberDecl1139);
                    interfaceGenericMethodDecl();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:328:9: 'void' Identifier voidInterfaceMethodDeclaratorRest
                    {
                    match(input,41,FOLLOW_41_in_interfaceMemberDecl1149); if (failed) return ;
                    match(input,Identifier,FOLLOW_Identifier_in_interfaceMemberDecl1151); if (failed) return ;
                    pushFollow(FOLLOW_voidInterfaceMethodDeclaratorRest_in_interfaceMemberDecl1153);
                    voidInterfaceMethodDeclaratorRest();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:329:9: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_interfaceMemberDecl1163);
                    interfaceDeclaration();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:330:9: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_interfaceMemberDecl1173);
                    classDeclaration();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 31, interfaceMemberDecl_StartIndex); }
        }
        return ;
    }
    // $ANTLR end interfaceMemberDecl


    // $ANTLR start interfaceMethodOrFieldDecl
    // src/com/epijava/grammar/EpiJava.g:333:1: interfaceMethodOrFieldDecl : type Identifier interfaceMethodOrFieldRest ;
    public final void interfaceMethodOrFieldDecl() throws RecognitionException {
        int interfaceMethodOrFieldDecl_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:334:2: ( type Identifier interfaceMethodOrFieldRest )
            // src/com/epijava/grammar/EpiJava.g:334:4: type Identifier interfaceMethodOrFieldRest
            {
            pushFollow(FOLLOW_type_in_interfaceMethodOrFieldDecl1185);
            type();
            _fsp--;
            if (failed) return ;
            match(input,Identifier,FOLLOW_Identifier_in_interfaceMethodOrFieldDecl1187); if (failed) return ;
            pushFollow(FOLLOW_interfaceMethodOrFieldRest_in_interfaceMethodOrFieldDecl1189);
            interfaceMethodOrFieldRest();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 32, interfaceMethodOrFieldDecl_StartIndex); }
        }
        return ;
    }
    // $ANTLR end interfaceMethodOrFieldDecl


    // $ANTLR start interfaceMethodOrFieldRest
    // src/com/epijava/grammar/EpiJava.g:337:1: interfaceMethodOrFieldRest : ( constantDeclaratorsRest ';' | interfaceMethodDeclaratorRest );
    public final void interfaceMethodOrFieldRest() throws RecognitionException {
        int interfaceMethodOrFieldRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:338:2: ( constantDeclaratorsRest ';' | interfaceMethodDeclaratorRest )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==42||LA40_0==45) ) {
                alt40=1;
            }
            else if ( (LA40_0==66) ) {
                alt40=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("337:1: interfaceMethodOrFieldRest : ( constantDeclaratorsRest ';' | interfaceMethodDeclaratorRest );", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:338:4: constantDeclaratorsRest ';'
                    {
                    pushFollow(FOLLOW_constantDeclaratorsRest_in_interfaceMethodOrFieldRest1201);
                    constantDeclaratorsRest();
                    _fsp--;
                    if (failed) return ;
                    match(input,26,FOLLOW_26_in_interfaceMethodOrFieldRest1203); if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:339:4: interfaceMethodDeclaratorRest
                    {
                    pushFollow(FOLLOW_interfaceMethodDeclaratorRest_in_interfaceMethodOrFieldRest1208);
                    interfaceMethodDeclaratorRest();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 33, interfaceMethodOrFieldRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end interfaceMethodOrFieldRest


    // $ANTLR start methodDeclaratorRest
    // src/com/epijava/grammar/EpiJava.g:342:1: methodDeclaratorRest[Locus l, TypeReference returnType, String name] returns [MethodDeclaration r] : formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( methodBody | ';' ) ;
    public final MethodDeclaration methodDeclaratorRest(Locus l, TypeReference returnType, String name) throws RecognitionException {
        MethodDeclaration r = null;
        int methodDeclaratorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 34) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:345:2: ( formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( methodBody | ';' ) )
            // src/com/epijava/grammar/EpiJava.g:345:4: formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( methodBody | ';' )
            {
            pushFollow(FOLLOW_formalParameters_in_methodDeclaratorRest1238);
            formalParameters();
            _fsp--;
            if (failed) return r;
            // src/com/epijava/grammar/EpiJava.g:345:21: ( '[' ']' )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==42) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:345:22: '[' ']'
            	    {
            	    match(input,42,FOLLOW_42_in_methodDeclaratorRest1241); if (failed) return r;
            	    match(input,43,FOLLOW_43_in_methodDeclaratorRest1243); if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            // src/com/epijava/grammar/EpiJava.g:346:9: ( 'throws' qualifiedNameList )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==44) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:346:10: 'throws' qualifiedNameList
                    {
                    match(input,44,FOLLOW_44_in_methodDeclaratorRest1256); if (failed) return r;
                    pushFollow(FOLLOW_qualifiedNameList_in_methodDeclaratorRest1258);
                    qualifiedNameList();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }

            // src/com/epijava/grammar/EpiJava.g:347:9: ( methodBody | ';' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==38) ) {
                alt43=1;
            }
            else if ( (LA43_0==26) ) {
                alt43=2;
            }
            else {
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("347:9: ( methodBody | ';' )", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:347:13: methodBody
                    {
                    pushFollow(FOLLOW_methodBody_in_methodDeclaratorRest1274);
                    methodBody();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:348:13: ';'
                    {
                    match(input,26,FOLLOW_26_in_methodDeclaratorRest1288); if (failed) return r;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               r = new MethodDeclaration(l, name).setFunctionType(new FunctionTypeReference(l, returnType)); 
            }

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 34, methodDeclaratorRest_StartIndex); }
        }
        return r;
    }
    // $ANTLR end methodDeclaratorRest


    // $ANTLR start voidMethodDeclaratorRest
    // src/com/epijava/grammar/EpiJava.g:353:1: voidMethodDeclaratorRest : formalParameters ( 'throws' qualifiedNameList )? ( methodBody | ';' ) ;
    public final void voidMethodDeclaratorRest() throws RecognitionException {
        int voidMethodDeclaratorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:354:2: ( formalParameters ( 'throws' qualifiedNameList )? ( methodBody | ';' ) )
            // src/com/epijava/grammar/EpiJava.g:354:4: formalParameters ( 'throws' qualifiedNameList )? ( methodBody | ';' )
            {
            pushFollow(FOLLOW_formalParameters_in_voidMethodDeclaratorRest1320);
            formalParameters();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:354:21: ( 'throws' qualifiedNameList )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==44) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:354:22: 'throws' qualifiedNameList
                    {
                    match(input,44,FOLLOW_44_in_voidMethodDeclaratorRest1323); if (failed) return ;
                    pushFollow(FOLLOW_qualifiedNameList_in_voidMethodDeclaratorRest1325);
                    qualifiedNameList();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            // src/com/epijava/grammar/EpiJava.g:355:9: ( methodBody | ';' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==38) ) {
                alt45=1;
            }
            else if ( (LA45_0==26) ) {
                alt45=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("355:9: ( methodBody | ';' )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:355:13: methodBody
                    {
                    pushFollow(FOLLOW_methodBody_in_voidMethodDeclaratorRest1341);
                    methodBody();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:356:13: ';'
                    {
                    match(input,26,FOLLOW_26_in_voidMethodDeclaratorRest1355); if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 35, voidMethodDeclaratorRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end voidMethodDeclaratorRest


    // $ANTLR start interfaceMethodDeclaratorRest
    // src/com/epijava/grammar/EpiJava.g:360:1: interfaceMethodDeclaratorRest : formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';' ;
    public final void interfaceMethodDeclaratorRest() throws RecognitionException {
        int interfaceMethodDeclaratorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:361:2: ( formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';' )
            // src/com/epijava/grammar/EpiJava.g:361:4: formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';'
            {
            pushFollow(FOLLOW_formalParameters_in_interfaceMethodDeclaratorRest1377);
            formalParameters();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:361:21: ( '[' ']' )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==42) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:361:22: '[' ']'
            	    {
            	    match(input,42,FOLLOW_42_in_interfaceMethodDeclaratorRest1380); if (failed) return ;
            	    match(input,43,FOLLOW_43_in_interfaceMethodDeclaratorRest1382); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            // src/com/epijava/grammar/EpiJava.g:361:32: ( 'throws' qualifiedNameList )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==44) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:361:33: 'throws' qualifiedNameList
                    {
                    match(input,44,FOLLOW_44_in_interfaceMethodDeclaratorRest1387); if (failed) return ;
                    pushFollow(FOLLOW_qualifiedNameList_in_interfaceMethodDeclaratorRest1389);
                    qualifiedNameList();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            match(input,26,FOLLOW_26_in_interfaceMethodDeclaratorRest1393); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 36, interfaceMethodDeclaratorRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end interfaceMethodDeclaratorRest


    // $ANTLR start interfaceGenericMethodDecl
    // src/com/epijava/grammar/EpiJava.g:364:1: interfaceGenericMethodDecl : typeParameters ( type | 'void' ) Identifier interfaceMethodDeclaratorRest ;
    public final void interfaceGenericMethodDecl() throws RecognitionException {
        int interfaceGenericMethodDecl_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:365:2: ( typeParameters ( type | 'void' ) Identifier interfaceMethodDeclaratorRest )
            // src/com/epijava/grammar/EpiJava.g:365:4: typeParameters ( type | 'void' ) Identifier interfaceMethodDeclaratorRest
            {
            pushFollow(FOLLOW_typeParameters_in_interfaceGenericMethodDecl1405);
            typeParameters();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:365:19: ( type | 'void' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Identifier||(LA48_0>=56 && LA48_0<=63)) ) {
                alt48=1;
            }
            else if ( (LA48_0==41) ) {
                alt48=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("365:19: ( type | 'void' )", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:365:20: type
                    {
                    pushFollow(FOLLOW_type_in_interfaceGenericMethodDecl1408);
                    type();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:365:27: 'void'
                    {
                    match(input,41,FOLLOW_41_in_interfaceGenericMethodDecl1412); if (failed) return ;

                    }
                    break;

            }

            match(input,Identifier,FOLLOW_Identifier_in_interfaceGenericMethodDecl1415); if (failed) return ;
            pushFollow(FOLLOW_interfaceMethodDeclaratorRest_in_interfaceGenericMethodDecl1425);
            interfaceMethodDeclaratorRest();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 37, interfaceGenericMethodDecl_StartIndex); }
        }
        return ;
    }
    // $ANTLR end interfaceGenericMethodDecl


    // $ANTLR start voidInterfaceMethodDeclaratorRest
    // src/com/epijava/grammar/EpiJava.g:369:1: voidInterfaceMethodDeclaratorRest : formalParameters ( 'throws' qualifiedNameList )? ';' ;
    public final void voidInterfaceMethodDeclaratorRest() throws RecognitionException {
        int voidInterfaceMethodDeclaratorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:370:2: ( formalParameters ( 'throws' qualifiedNameList )? ';' )
            // src/com/epijava/grammar/EpiJava.g:370:4: formalParameters ( 'throws' qualifiedNameList )? ';'
            {
            pushFollow(FOLLOW_formalParameters_in_voidInterfaceMethodDeclaratorRest1437);
            formalParameters();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:370:21: ( 'throws' qualifiedNameList )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==44) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:370:22: 'throws' qualifiedNameList
                    {
                    match(input,44,FOLLOW_44_in_voidInterfaceMethodDeclaratorRest1440); if (failed) return ;
                    pushFollow(FOLLOW_qualifiedNameList_in_voidInterfaceMethodDeclaratorRest1442);
                    qualifiedNameList();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            match(input,26,FOLLOW_26_in_voidInterfaceMethodDeclaratorRest1446); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 38, voidInterfaceMethodDeclaratorRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end voidInterfaceMethodDeclaratorRest


    // $ANTLR start constructorDeclaratorRest
    // src/com/epijava/grammar/EpiJava.g:373:1: constructorDeclaratorRest : formalParameters ( 'throws' qualifiedNameList )? methodBody ;
    public final void constructorDeclaratorRest() throws RecognitionException {
        int constructorDeclaratorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:374:2: ( formalParameters ( 'throws' qualifiedNameList )? methodBody )
            // src/com/epijava/grammar/EpiJava.g:374:4: formalParameters ( 'throws' qualifiedNameList )? methodBody
            {
            pushFollow(FOLLOW_formalParameters_in_constructorDeclaratorRest1458);
            formalParameters();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:374:21: ( 'throws' qualifiedNameList )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==44) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:374:22: 'throws' qualifiedNameList
                    {
                    match(input,44,FOLLOW_44_in_constructorDeclaratorRest1461); if (failed) return ;
                    pushFollow(FOLLOW_qualifiedNameList_in_constructorDeclaratorRest1463);
                    qualifiedNameList();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_methodBody_in_constructorDeclaratorRest1467);
            methodBody();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 39, constructorDeclaratorRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end constructorDeclaratorRest


    // $ANTLR start constantDeclarator
    // src/com/epijava/grammar/EpiJava.g:377:1: constantDeclarator : Identifier constantDeclaratorRest ;
    public final void constantDeclarator() throws RecognitionException {
        int constantDeclarator_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 40) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:378:2: ( Identifier constantDeclaratorRest )
            // src/com/epijava/grammar/EpiJava.g:378:4: Identifier constantDeclaratorRest
            {
            match(input,Identifier,FOLLOW_Identifier_in_constantDeclarator1478); if (failed) return ;
            pushFollow(FOLLOW_constantDeclaratorRest_in_constantDeclarator1480);
            constantDeclaratorRest();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 40, constantDeclarator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end constantDeclarator


    // $ANTLR start variableDeclarators
    // src/com/epijava/grammar/EpiJava.g:381:1: variableDeclarators : variableDeclarator ( ',' variableDeclarator )* ;
    public final void variableDeclarators() throws RecognitionException {
        int variableDeclarators_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 41) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:382:2: ( variableDeclarator ( ',' variableDeclarator )* )
            // src/com/epijava/grammar/EpiJava.g:382:4: variableDeclarator ( ',' variableDeclarator )*
            {
            pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators1492);
            variableDeclarator();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:382:23: ( ',' variableDeclarator )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==35) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:382:24: ',' variableDeclarator
            	    {
            	    match(input,35,FOLLOW_35_in_variableDeclarators1495); if (failed) return ;
            	    pushFollow(FOLLOW_variableDeclarator_in_variableDeclarators1497);
            	    variableDeclarator();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 41, variableDeclarators_StartIndex); }
        }
        return ;
    }
    // $ANTLR end variableDeclarators


    // $ANTLR start variableDeclarator
    // src/com/epijava/grammar/EpiJava.g:385:1: variableDeclarator : Identifier variableDeclaratorRest ;
    public final void variableDeclarator() throws RecognitionException {
        int variableDeclarator_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:386:2: ( Identifier variableDeclaratorRest )
            // src/com/epijava/grammar/EpiJava.g:386:4: Identifier variableDeclaratorRest
            {
            match(input,Identifier,FOLLOW_Identifier_in_variableDeclarator1510); if (failed) return ;
            pushFollow(FOLLOW_variableDeclaratorRest_in_variableDeclarator1512);
            variableDeclaratorRest();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 42, variableDeclarator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end variableDeclarator


    // $ANTLR start variableDeclaratorRest
    // src/com/epijava/grammar/EpiJava.g:389:1: variableDeclaratorRest : ( ( '[' ']' )+ ( '=' variableInitializer )? | '=' variableInitializer | );
    public final void variableDeclaratorRest() throws RecognitionException {
        int variableDeclaratorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:390:2: ( ( '[' ']' )+ ( '=' variableInitializer )? | '=' variableInitializer | )
            int alt54=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt54=1;
                }
                break;
            case 45:
                {
                alt54=2;
                }
                break;
            case EOF:
            case 26:
            case 35:
                {
                alt54=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("389:1: variableDeclaratorRest : ( ( '[' ']' )+ ( '=' variableInitializer )? | '=' variableInitializer | );", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:390:4: ( '[' ']' )+ ( '=' variableInitializer )?
                    {
                    // src/com/epijava/grammar/EpiJava.g:390:4: ( '[' ']' )+
                    int cnt52=0;
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==42) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:390:5: '[' ']'
                    	    {
                    	    match(input,42,FOLLOW_42_in_variableDeclaratorRest1525); if (failed) return ;
                    	    match(input,43,FOLLOW_43_in_variableDeclaratorRest1527); if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt52 >= 1 ) break loop52;
                    	    if (backtracking>0) {failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
                    } while (true);

                    // src/com/epijava/grammar/EpiJava.g:390:15: ( '=' variableInitializer )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==45) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:390:16: '=' variableInitializer
                            {
                            match(input,45,FOLLOW_45_in_variableDeclaratorRest1532); if (failed) return ;
                            pushFollow(FOLLOW_variableInitializer_in_variableDeclaratorRest1534);
                            variableInitializer();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:391:4: '=' variableInitializer
                    {
                    match(input,45,FOLLOW_45_in_variableDeclaratorRest1541); if (failed) return ;
                    pushFollow(FOLLOW_variableInitializer_in_variableDeclaratorRest1543);
                    variableInitializer();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:393:2: 
                    {
                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 43, variableDeclaratorRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end variableDeclaratorRest


    // $ANTLR start constantDeclaratorsRest
    // src/com/epijava/grammar/EpiJava.g:395:1: constantDeclaratorsRest : constantDeclaratorRest ( ',' constantDeclarator )* ;
    public final void constantDeclaratorsRest() throws RecognitionException {
        int constantDeclaratorsRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:396:5: ( constantDeclaratorRest ( ',' constantDeclarator )* )
            // src/com/epijava/grammar/EpiJava.g:396:9: constantDeclaratorRest ( ',' constantDeclarator )*
            {
            pushFollow(FOLLOW_constantDeclaratorRest_in_constantDeclaratorsRest1563);
            constantDeclaratorRest();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:396:32: ( ',' constantDeclarator )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==35) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:396:33: ',' constantDeclarator
            	    {
            	    match(input,35,FOLLOW_35_in_constantDeclaratorsRest1566); if (failed) return ;
            	    pushFollow(FOLLOW_constantDeclarator_in_constantDeclaratorsRest1568);
            	    constantDeclarator();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 44, constantDeclaratorsRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end constantDeclaratorsRest


    // $ANTLR start constantDeclaratorRest
    // src/com/epijava/grammar/EpiJava.g:399:1: constantDeclaratorRest : ( '[' ']' )* '=' variableInitializer ;
    public final void constantDeclaratorRest() throws RecognitionException {
        int constantDeclaratorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:400:2: ( ( '[' ']' )* '=' variableInitializer )
            // src/com/epijava/grammar/EpiJava.g:400:4: ( '[' ']' )* '=' variableInitializer
            {
            // src/com/epijava/grammar/EpiJava.g:400:4: ( '[' ']' )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==42) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:400:5: '[' ']'
            	    {
            	    match(input,42,FOLLOW_42_in_constantDeclaratorRest1585); if (failed) return ;
            	    match(input,43,FOLLOW_43_in_constantDeclaratorRest1587); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            match(input,45,FOLLOW_45_in_constantDeclaratorRest1591); if (failed) return ;
            pushFollow(FOLLOW_variableInitializer_in_constantDeclaratorRest1593);
            variableInitializer();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 45, constantDeclaratorRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end constantDeclaratorRest


    // $ANTLR start variableDeclaratorId
    // src/com/epijava/grammar/EpiJava.g:403:1: variableDeclaratorId : Identifier ( '[' ']' )* ;
    public final void variableDeclaratorId() throws RecognitionException {
        int variableDeclaratorId_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:404:2: ( Identifier ( '[' ']' )* )
            // src/com/epijava/grammar/EpiJava.g:404:4: Identifier ( '[' ']' )*
            {
            match(input,Identifier,FOLLOW_Identifier_in_variableDeclaratorId1605); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:404:15: ( '[' ']' )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==42) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:404:16: '[' ']'
            	    {
            	    match(input,42,FOLLOW_42_in_variableDeclaratorId1608); if (failed) return ;
            	    match(input,43,FOLLOW_43_in_variableDeclaratorId1610); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 46, variableDeclaratorId_StartIndex); }
        }
        return ;
    }
    // $ANTLR end variableDeclaratorId


    // $ANTLR start variableInitializer
    // src/com/epijava/grammar/EpiJava.g:407:1: variableInitializer : ( arrayInitializer | expression );
    public final void variableInitializer() throws RecognitionException {
        int variableInitializer_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:408:2: ( arrayInitializer | expression )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==38) ) {
                alt58=1;
            }
            else if ( (LA58_0==Identifier||(LA58_0>=FloatingPointLiteral && LA58_0<=DecimalLiteral)||LA58_0==34||LA58_0==41||(LA58_0>=56 && LA58_0<=63)||(LA58_0>=65 && LA58_0<=66)||(LA58_0>=69 && LA58_0<=71)||(LA58_0>=105 && LA58_0<=106)||(LA58_0>=109 && LA58_0<=114)) ) {
                alt58=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("407:1: variableInitializer : ( arrayInitializer | expression );", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:408:4: arrayInitializer
                    {
                    pushFollow(FOLLOW_arrayInitializer_in_variableInitializer1623);
                    arrayInitializer();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:409:9: expression
                    {
                    pushFollow(FOLLOW_expression_in_variableInitializer1633);
                    expression();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 47, variableInitializer_StartIndex); }
        }
        return ;
    }
    // $ANTLR end variableInitializer


    // $ANTLR start arrayInitializer
    // src/com/epijava/grammar/EpiJava.g:412:1: arrayInitializer : '{' ( variableInitializer ( ',' variableInitializer )* ( ',' )? )? '}' ;
    public final void arrayInitializer() throws RecognitionException {
        int arrayInitializer_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:413:2: ( '{' ( variableInitializer ( ',' variableInitializer )* ( ',' )? )? '}' )
            // src/com/epijava/grammar/EpiJava.g:413:4: '{' ( variableInitializer ( ',' variableInitializer )* ( ',' )? )? '}'
            {
            match(input,38,FOLLOW_38_in_arrayInitializer1645); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:413:8: ( variableInitializer ( ',' variableInitializer )* ( ',' )? )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==Identifier||(LA61_0>=FloatingPointLiteral && LA61_0<=DecimalLiteral)||LA61_0==34||LA61_0==38||LA61_0==41||(LA61_0>=56 && LA61_0<=63)||(LA61_0>=65 && LA61_0<=66)||(LA61_0>=69 && LA61_0<=71)||(LA61_0>=105 && LA61_0<=106)||(LA61_0>=109 && LA61_0<=114)) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:413:9: variableInitializer ( ',' variableInitializer )* ( ',' )?
                    {
                    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer1648);
                    variableInitializer();
                    _fsp--;
                    if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:413:29: ( ',' variableInitializer )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==35) ) {
                            int LA59_1 = input.LA(2);

                            if ( (LA59_1==Identifier||(LA59_1>=FloatingPointLiteral && LA59_1<=DecimalLiteral)||LA59_1==34||LA59_1==38||LA59_1==41||(LA59_1>=56 && LA59_1<=63)||(LA59_1>=65 && LA59_1<=66)||(LA59_1>=69 && LA59_1<=71)||(LA59_1>=105 && LA59_1<=106)||(LA59_1>=109 && LA59_1<=114)) ) {
                                alt59=1;
                            }


                        }


                        switch (alt59) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:413:30: ',' variableInitializer
                    	    {
                    	    match(input,35,FOLLOW_35_in_arrayInitializer1651); if (failed) return ;
                    	    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer1653);
                    	    variableInitializer();
                    	    _fsp--;
                    	    if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);

                    // src/com/epijava/grammar/EpiJava.g:413:56: ( ',' )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==35) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:413:57: ','
                            {
                            match(input,35,FOLLOW_35_in_arrayInitializer1658); if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }

            match(input,39,FOLLOW_39_in_arrayInitializer1665); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 48, arrayInitializer_StartIndex); }
        }
        return ;
    }
    // $ANTLR end arrayInitializer


    // $ANTLR start modifier
    // src/com/epijava/grammar/EpiJava.g:416:1: modifier : ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' );
    public final void modifier() throws RecognitionException {
        int modifier_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:417:5: ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )
            int alt62=12;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt62=1;
                }
                break;
            case 46:
                {
                alt62=2;
                }
                break;
            case 47:
                {
                alt62=3;
                }
                break;
            case 48:
                {
                alt62=4;
                }
                break;
            case 28:
                {
                alt62=5;
                }
                break;
            case 49:
                {
                alt62=6;
                }
                break;
            case 50:
                {
                alt62=7;
                }
                break;
            case 51:
                {
                alt62=8;
                }
                break;
            case 52:
                {
                alt62=9;
                }
                break;
            case 53:
                {
                alt62=10;
                }
                break;
            case 54:
                {
                alt62=11;
                }
                break;
            case 55:
                {
                alt62=12;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("416:1: modifier : ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' );", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:417:9: annotation
                    {
                    pushFollow(FOLLOW_annotation_in_modifier1681);
                    annotation();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:418:9: 'public'
                    {
                    match(input,46,FOLLOW_46_in_modifier1691); if (failed) return ;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:419:9: 'protected'
                    {
                    match(input,47,FOLLOW_47_in_modifier1701); if (failed) return ;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:420:9: 'private'
                    {
                    match(input,48,FOLLOW_48_in_modifier1711); if (failed) return ;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:421:9: 'static'
                    {
                    match(input,28,FOLLOW_28_in_modifier1721); if (failed) return ;

                    }
                    break;
                case 6 :
                    // src/com/epijava/grammar/EpiJava.g:422:9: 'abstract'
                    {
                    match(input,49,FOLLOW_49_in_modifier1731); if (failed) return ;

                    }
                    break;
                case 7 :
                    // src/com/epijava/grammar/EpiJava.g:423:9: 'final'
                    {
                    match(input,50,FOLLOW_50_in_modifier1741); if (failed) return ;

                    }
                    break;
                case 8 :
                    // src/com/epijava/grammar/EpiJava.g:424:9: 'native'
                    {
                    match(input,51,FOLLOW_51_in_modifier1751); if (failed) return ;

                    }
                    break;
                case 9 :
                    // src/com/epijava/grammar/EpiJava.g:425:9: 'synchronized'
                    {
                    match(input,52,FOLLOW_52_in_modifier1761); if (failed) return ;

                    }
                    break;
                case 10 :
                    // src/com/epijava/grammar/EpiJava.g:426:9: 'transient'
                    {
                    match(input,53,FOLLOW_53_in_modifier1771); if (failed) return ;

                    }
                    break;
                case 11 :
                    // src/com/epijava/grammar/EpiJava.g:427:9: 'volatile'
                    {
                    match(input,54,FOLLOW_54_in_modifier1781); if (failed) return ;

                    }
                    break;
                case 12 :
                    // src/com/epijava/grammar/EpiJava.g:428:9: 'strictfp'
                    {
                    match(input,55,FOLLOW_55_in_modifier1791); if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 49, modifier_StartIndex); }
        }
        return ;
    }
    // $ANTLR end modifier


    // $ANTLR start packageOrTypeName
    // src/com/epijava/grammar/EpiJava.g:431:1: packageOrTypeName : Identifier ( '.' Identifier )* ;
    public final void packageOrTypeName() throws RecognitionException {
        int packageOrTypeName_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:432:2: ( Identifier ( '.' Identifier )* )
            // src/com/epijava/grammar/EpiJava.g:432:4: Identifier ( '.' Identifier )*
            {
            match(input,Identifier,FOLLOW_Identifier_in_packageOrTypeName1805); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:432:15: ( '.' Identifier )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==29) ) {
                    int LA63_1 = input.LA(2);

                    if ( (LA63_1==Identifier) ) {
                        int LA63_2 = input.LA(3);

                        if ( (synpred83()) ) {
                            alt63=1;
                        }


                    }


                }


                switch (alt63) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:432:16: '.' Identifier
            	    {
            	    match(input,29,FOLLOW_29_in_packageOrTypeName1808); if (failed) return ;
            	    match(input,Identifier,FOLLOW_Identifier_in_packageOrTypeName1810); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 50, packageOrTypeName_StartIndex); }
        }
        return ;
    }
    // $ANTLR end packageOrTypeName


    // $ANTLR start enumConstantName
    // src/com/epijava/grammar/EpiJava.g:435:1: enumConstantName : Identifier ;
    public final void enumConstantName() throws RecognitionException {
        int enumConstantName_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:436:5: ( Identifier )
            // src/com/epijava/grammar/EpiJava.g:436:9: Identifier
            {
            match(input,Identifier,FOLLOW_Identifier_in_enumConstantName1828); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 51, enumConstantName_StartIndex); }
        }
        return ;
    }
    // $ANTLR end enumConstantName


    // $ANTLR start typeName
    // src/com/epijava/grammar/EpiJava.g:439:1: typeName : ( Identifier | packageOrTypeName '.' Identifier );
    public final void typeName() throws RecognitionException {
        int typeName_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:440:2: ( Identifier | packageOrTypeName '.' Identifier )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==Identifier) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==EOF) ) {
                    alt64=1;
                }
                else if ( (LA64_1==29) ) {
                    alt64=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("439:1: typeName : ( Identifier | packageOrTypeName '.' Identifier );", 64, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("439:1: typeName : ( Identifier | packageOrTypeName '.' Identifier );", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:440:6: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_typeName1844); if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:441:9: packageOrTypeName '.' Identifier
                    {
                    pushFollow(FOLLOW_packageOrTypeName_in_typeName1854);
                    packageOrTypeName();
                    _fsp--;
                    if (failed) return ;
                    match(input,29,FOLLOW_29_in_typeName1856); if (failed) return ;
                    match(input,Identifier,FOLLOW_Identifier_in_typeName1858); if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 52, typeName_StartIndex); }
        }
        return ;
    }
    // $ANTLR end typeName


    // $ANTLR start type
    // src/com/epijava/grammar/EpiJava.g:444:1: type returns [TypeReference r] : (id= Identifier ( typeArguments )? ( '.' id= Identifier ( typeArguments )? )* (t= '[' ']' )* | r_= primitiveType ( '[' ']' )* );
    public final TypeReference type() throws RecognitionException {
        TypeReference r = null;
        int type_StartIndex = input.index();
        Token id=null;
        Token t=null;
        NamedTypeReference r_ = null;



              List<String> components = new ArrayList<String>();
              Locus l = null; // the locus of the LAST component
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 53) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:452:2: (id= Identifier ( typeArguments )? ( '.' id= Identifier ( typeArguments )? )* (t= '[' ']' )* | r_= primitiveType ( '[' ']' )* )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==Identifier) ) {
                alt70=1;
            }
            else if ( ((LA70_0>=56 && LA70_0<=63)) ) {
                alt70=2;
            }
            else {
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("444:1: type returns [TypeReference r] : (id= Identifier ( typeArguments )? ( '.' id= Identifier ( typeArguments )? )* (t= '[' ']' )* | r_= primitiveType ( '[' ']' )* );", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:452:4: id= Identifier ( typeArguments )? ( '.' id= Identifier ( typeArguments )? )* (t= '[' ']' )*
                    {
                    id=(Token)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_type1911); if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:452:18: ( typeArguments )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==34) ) {
                        int LA65_1 = input.LA(2);

                        if ( (LA65_1==Identifier||(LA65_1>=56 && LA65_1<=64)) ) {
                            alt65=1;
                        }
                    }
                    switch (alt65) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:452:19: typeArguments
                            {
                            pushFollow(FOLLOW_typeArguments_in_type1914);
                            typeArguments();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;

                    }

                    if ( backtracking==0 ) {
                       r = new PackageOrTypeReference(l(id), null, id.getText()); 
                    }
                    // src/com/epijava/grammar/EpiJava.g:455:6: ( '.' id= Identifier ( typeArguments )? )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==29) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:456:10: '.' id= Identifier ( typeArguments )?
                    	    {
                    	    match(input,29,FOLLOW_29_in_type1953); if (failed) return r;
                    	    id=(Token)input.LT(1);
                    	    match(input,Identifier,FOLLOW_Identifier_in_type1957); if (failed) return r;
                    	    // src/com/epijava/grammar/EpiJava.g:456:28: ( typeArguments )?
                    	    int alt66=2;
                    	    int LA66_0 = input.LA(1);

                    	    if ( (LA66_0==34) ) {
                    	        int LA66_1 = input.LA(2);

                    	        if ( (LA66_1==Identifier||(LA66_1>=56 && LA66_1<=64)) ) {
                    	            alt66=1;
                    	        }
                    	    }
                    	    switch (alt66) {
                    	        case 1 :
                    	            // src/com/epijava/grammar/EpiJava.g:456:29: typeArguments
                    	            {
                    	            pushFollow(FOLLOW_typeArguments_in_type1960);
                    	            typeArguments();
                    	            _fsp--;
                    	            if (failed) return r;

                    	            }
                    	            break;

                    	    }

                    	    if ( backtracking==0 ) {
                    	       r = new PackageOrTypeReference(l(id), (PackageOrTypeReference)r, id.getText()); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);

                    if ( backtracking==0 ) {
                       r = ((PackageOrTypeReference)r).toNamedTypeReference(); 
                    }
                    // src/com/epijava/grammar/EpiJava.g:462:6: (t= '[' ']' )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==42) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:462:7: t= '[' ']'
                    	    {
                    	    t=(Token)input.LT(1);
                    	    match(input,42,FOLLOW_42_in_type2019); if (failed) return r;
                    	    match(input,43,FOLLOW_43_in_type2021); if (failed) return r;
                    	    if ( backtracking==0 ) {
                    	       r = new ArrayTypeReference(l(t), r); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:464:4: r_= primitiveType ( '[' ']' )*
                    {
                    pushFollow(FOLLOW_primitiveType_in_type2039);
                    r_=primitiveType();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r = r_; 
                    }
                    // src/com/epijava/grammar/EpiJava.g:465:6: ( '[' ']' )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==42) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:465:7: '[' ']'
                    	    {
                    	    match(input,42,FOLLOW_42_in_type2049); if (failed) return r;
                    	    match(input,43,FOLLOW_43_in_type2051); if (failed) return r;
                    	    if ( backtracking==0 ) {
                    	       r = new ArrayTypeReference(l(t), r); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);


                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 53, type_StartIndex); }
        }
        return r;
    }
    // $ANTLR end type


    // $ANTLR start primitiveType
    // src/com/epijava/grammar/EpiJava.g:468:1: primitiveType returns [NamedTypeReference r] : (t= 'boolean' | t= 'char' | t= 'byte' | t= 'short' | t= 'int' | t= 'long' | t= 'float' | t= 'double' );
    public final NamedTypeReference primitiveType() throws RecognitionException {
        NamedTypeReference r = null;
        int primitiveType_StartIndex = input.index();
        Token t=null;

        try {
            if ( backtracking>0 && alreadyParsedRule(input, 54) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:470:5: (t= 'boolean' | t= 'char' | t= 'byte' | t= 'short' | t= 'int' | t= 'long' | t= 'float' | t= 'double' )
            int alt71=8;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt71=1;
                }
                break;
            case 57:
                {
                alt71=2;
                }
                break;
            case 58:
                {
                alt71=3;
                }
                break;
            case 59:
                {
                alt71=4;
                }
                break;
            case 60:
                {
                alt71=5;
                }
                break;
            case 61:
                {
                alt71=6;
                }
                break;
            case 62:
                {
                alt71=7;
                }
                break;
            case 63:
                {
                alt71=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("468:1: primitiveType returns [NamedTypeReference r] : (t= 'boolean' | t= 'char' | t= 'byte' | t= 'short' | t= 'int' | t= 'long' | t= 'float' | t= 'double' );", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:470:9: t= 'boolean'
                    {
                    t=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_primitiveType2087); if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:471:7: t= 'char'
                    {
                    t=(Token)input.LT(1);
                    match(input,57,FOLLOW_57_in_primitiveType2097); if (failed) return r;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:472:7: t= 'byte'
                    {
                    t=(Token)input.LT(1);
                    match(input,58,FOLLOW_58_in_primitiveType2107); if (failed) return r;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:473:7: t= 'short'
                    {
                    t=(Token)input.LT(1);
                    match(input,59,FOLLOW_59_in_primitiveType2117); if (failed) return r;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:474:7: t= 'int'
                    {
                    t=(Token)input.LT(1);
                    match(input,60,FOLLOW_60_in_primitiveType2127); if (failed) return r;

                    }
                    break;
                case 6 :
                    // src/com/epijava/grammar/EpiJava.g:475:7: t= 'long'
                    {
                    t=(Token)input.LT(1);
                    match(input,61,FOLLOW_61_in_primitiveType2137); if (failed) return r;

                    }
                    break;
                case 7 :
                    // src/com/epijava/grammar/EpiJava.g:476:7: t= 'float'
                    {
                    t=(Token)input.LT(1);
                    match(input,62,FOLLOW_62_in_primitiveType2147); if (failed) return r;

                    }
                    break;
                case 8 :
                    // src/com/epijava/grammar/EpiJava.g:477:7: t= 'double'
                    {
                    t=(Token)input.LT(1);
                    match(input,63,FOLLOW_63_in_primitiveType2157); if (failed) return r;

                    }
                    break;

            }
            if ( backtracking==0 ) {
               r = new NamedTypeReference(l(t), null, t.getText()); 
            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 54, primitiveType_StartIndex); }
        }
        return r;
    }
    // $ANTLR end primitiveType


    // $ANTLR start variableModifier
    // src/com/epijava/grammar/EpiJava.g:480:1: variableModifier : ( 'final' | annotation );
    public final void variableModifier() throws RecognitionException {
        int variableModifier_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:481:2: ( 'final' | annotation )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==50) ) {
                alt72=1;
            }
            else if ( (LA72_0==72) ) {
                alt72=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("480:1: variableModifier : ( 'final' | annotation );", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:481:4: 'final'
                    {
                    match(input,50,FOLLOW_50_in_variableModifier2171); if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:482:9: annotation
                    {
                    pushFollow(FOLLOW_annotation_in_variableModifier2181);
                    annotation();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 55, variableModifier_StartIndex); }
        }
        return ;
    }
    // $ANTLR end variableModifier


    // $ANTLR start typeArguments
    // src/com/epijava/grammar/EpiJava.g:485:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final void typeArguments() throws RecognitionException {
        int typeArguments_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:486:2: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // src/com/epijava/grammar/EpiJava.g:486:4: '<' typeArgument ( ',' typeArgument )* '>'
            {
            match(input,34,FOLLOW_34_in_typeArguments2192); if (failed) return ;
            pushFollow(FOLLOW_typeArgument_in_typeArguments2194);
            typeArgument();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:486:21: ( ',' typeArgument )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==35) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:486:22: ',' typeArgument
            	    {
            	    match(input,35,FOLLOW_35_in_typeArguments2197); if (failed) return ;
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2199);
            	    typeArgument();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            match(input,36,FOLLOW_36_in_typeArguments2203); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 56, typeArguments_StartIndex); }
        }
        return ;
    }
    // $ANTLR end typeArguments


    // $ANTLR start typeArgument
    // src/com/epijava/grammar/EpiJava.g:489:1: typeArgument : ( type | '?' ( ( 'extends' | 'super' ) type )? );
    public final void typeArgument() throws RecognitionException {
        int typeArgument_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:490:2: ( type | '?' ( ( 'extends' | 'super' ) type )? )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==Identifier||(LA75_0>=56 && LA75_0<=63)) ) {
                alt75=1;
            }
            else if ( (LA75_0==64) ) {
                alt75=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("489:1: typeArgument : ( type | '?' ( ( 'extends' | 'super' ) type )? );", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:490:4: type
                    {
                    pushFollow(FOLLOW_type_in_typeArgument2215);
                    type();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:491:4: '?' ( ( 'extends' | 'super' ) type )?
                    {
                    match(input,64,FOLLOW_64_in_typeArgument2220); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:491:8: ( ( 'extends' | 'super' ) type )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==32||LA74_0==65) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:491:9: ( 'extends' | 'super' ) type
                            {
                            if ( input.LA(1)==32||input.LA(1)==65 ) {
                                input.consume();
                                errorRecovery=false;failed=false;
                            }
                            else {
                                if (backtracking>0) {failed=true; return ;}
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_typeArgument2223);    throw mse;
                            }

                            pushFollow(FOLLOW_type_in_typeArgument2231);
                            type();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 57, typeArgument_StartIndex); }
        }
        return ;
    }
    // $ANTLR end typeArgument


    // $ANTLR start qualifiedNameList
    // src/com/epijava/grammar/EpiJava.g:494:1: qualifiedNameList : qualifiedName ( ',' qualifiedName )* ;
    public final void qualifiedNameList() throws RecognitionException {
        int qualifiedNameList_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:495:2: ( qualifiedName ( ',' qualifiedName )* )
            // src/com/epijava/grammar/EpiJava.g:495:4: qualifiedName ( ',' qualifiedName )*
            {
            pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList2245);
            qualifiedName();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:495:18: ( ',' qualifiedName )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==35) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:495:19: ',' qualifiedName
            	    {
            	    match(input,35,FOLLOW_35_in_qualifiedNameList2248); if (failed) return ;
            	    pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList2250);
            	    qualifiedName();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 58, qualifiedNameList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end qualifiedNameList


    // $ANTLR start formalParameters
    // src/com/epijava/grammar/EpiJava.g:498:1: formalParameters : '(' ( formalParameterDecls )? ')' ;
    public final void formalParameters() throws RecognitionException {
        int formalParameters_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:499:2: ( '(' ( formalParameterDecls )? ')' )
            // src/com/epijava/grammar/EpiJava.g:499:4: '(' ( formalParameterDecls )? ')'
            {
            match(input,66,FOLLOW_66_in_formalParameters2264); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:499:8: ( formalParameterDecls )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==Identifier||LA77_0==50||(LA77_0>=56 && LA77_0<=63)||LA77_0==72) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:0:0: formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters2266);
                    formalParameterDecls();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            match(input,67,FOLLOW_67_in_formalParameters2269); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 59, formalParameters_StartIndex); }
        }
        return ;
    }
    // $ANTLR end formalParameters


    // $ANTLR start formalParameterDecls
    // src/com/epijava/grammar/EpiJava.g:502:1: formalParameterDecls : ( variableModifier )* type ( formalParameterDeclsRest )? ;
    public final void formalParameterDecls() throws RecognitionException {
        int formalParameterDecls_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:503:2: ( ( variableModifier )* type ( formalParameterDeclsRest )? )
            // src/com/epijava/grammar/EpiJava.g:503:4: ( variableModifier )* type ( formalParameterDeclsRest )?
            {
            // src/com/epijava/grammar/EpiJava.g:503:4: ( variableModifier )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==50||LA78_0==72) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:0:0: variableModifier
            	    {
            	    pushFollow(FOLLOW_variableModifier_in_formalParameterDecls2281);
            	    variableModifier();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            pushFollow(FOLLOW_type_in_formalParameterDecls2284);
            type();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:503:27: ( formalParameterDeclsRest )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==Identifier||LA79_0==68) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:0:0: formalParameterDeclsRest
                    {
                    pushFollow(FOLLOW_formalParameterDeclsRest_in_formalParameterDecls2286);
                    formalParameterDeclsRest();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 60, formalParameterDecls_StartIndex); }
        }
        return ;
    }
    // $ANTLR end formalParameterDecls


    // $ANTLR start formalParameterDeclsRest
    // src/com/epijava/grammar/EpiJava.g:506:1: formalParameterDeclsRest : ( variableDeclaratorId ( ',' formalParameterDecls )? | '...' variableDeclaratorId );
    public final void formalParameterDeclsRest() throws RecognitionException {
        int formalParameterDeclsRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:507:2: ( variableDeclaratorId ( ',' formalParameterDecls )? | '...' variableDeclaratorId )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==Identifier) ) {
                alt81=1;
            }
            else if ( (LA81_0==68) ) {
                alt81=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("506:1: formalParameterDeclsRest : ( variableDeclaratorId ( ',' formalParameterDecls )? | '...' variableDeclaratorId );", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:507:4: variableDeclaratorId ( ',' formalParameterDecls )?
                    {
                    pushFollow(FOLLOW_variableDeclaratorId_in_formalParameterDeclsRest2299);
                    variableDeclaratorId();
                    _fsp--;
                    if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:507:25: ( ',' formalParameterDecls )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==35) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:507:26: ',' formalParameterDecls
                            {
                            match(input,35,FOLLOW_35_in_formalParameterDeclsRest2302); if (failed) return ;
                            pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDeclsRest2304);
                            formalParameterDecls();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:508:6: '...' variableDeclaratorId
                    {
                    match(input,68,FOLLOW_68_in_formalParameterDeclsRest2313); if (failed) return ;
                    pushFollow(FOLLOW_variableDeclaratorId_in_formalParameterDeclsRest2315);
                    variableDeclaratorId();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 61, formalParameterDeclsRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end formalParameterDeclsRest


    // $ANTLR start methodBody
    // src/com/epijava/grammar/EpiJava.g:511:1: methodBody : block ;
    public final void methodBody() throws RecognitionException {
        int methodBody_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:512:2: ( block )
            // src/com/epijava/grammar/EpiJava.g:512:4: block
            {
            pushFollow(FOLLOW_block_in_methodBody2327);
            block();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 62, methodBody_StartIndex); }
        }
        return ;
    }
    // $ANTLR end methodBody


    // $ANTLR start qualifiedName
    // src/com/epijava/grammar/EpiJava.g:515:1: qualifiedName returns [QualifiedName r] : t= Identifier ( '.' t= Identifier )* ;
    public final QualifiedName qualifiedName() throws RecognitionException {
        QualifiedName r = null;
        int qualifiedName_StartIndex = input.index();
        Token t=null;


              List<String> components = new ArrayList<String>();
              Locus l = null; // the locus of the LAST component
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 63) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:523:2: (t= Identifier ( '.' t= Identifier )* )
            // src/com/epijava/grammar/EpiJava.g:523:4: t= Identifier ( '.' t= Identifier )*
            {
            t=(Token)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_qualifiedName2362); if (failed) return r;
            if ( backtracking==0 ) {
               l=l(t); components.add(t.getText()); 
            }
            // src/com/epijava/grammar/EpiJava.g:524:9: ( '.' t= Identifier )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==29) ) {
                    int LA82_2 = input.LA(2);

                    if ( (LA82_2==Identifier) ) {
                        int LA82_37 = input.LA(3);

                        if ( (synpred109()) ) {
                            alt82=1;
                        }


                    }


                }


                switch (alt82) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:524:10: '.' t= Identifier
            	    {
            	    match(input,29,FOLLOW_29_in_qualifiedName2375); if (failed) return r;
            	    t=(Token)input.LT(1);
            	    match(input,Identifier,FOLLOW_Identifier_in_qualifiedName2379); if (failed) return r;
            	    if ( backtracking==0 ) {
            	       l=l(t); components.add(t.getText()); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }

            if ( backtracking==0 ) {

                    r = new QualifiedName(l, components);
                  
            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 63, qualifiedName_StartIndex); }
        }
        return r;
    }
    // $ANTLR end qualifiedName


    // $ANTLR start literal
    // src/com/epijava/grammar/EpiJava.g:527:1: literal returns [Expression r] : (r_= integerLiteral | t= FloatingPointLiteral | t= CharacterLiteral | t= StringLiteral | r_= booleanLiteral | t= 'null' );
    public final Expression literal() throws RecognitionException {
        Expression r = null;
        int literal_StartIndex = input.index();
        Token t=null;
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 64) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:528:2: (r_= integerLiteral | t= FloatingPointLiteral | t= CharacterLiteral | t= StringLiteral | r_= booleanLiteral | t= 'null' )
            int alt83=6;
            switch ( input.LA(1) ) {
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
                {
                alt83=1;
                }
                break;
            case FloatingPointLiteral:
                {
                alt83=2;
                }
                break;
            case CharacterLiteral:
                {
                alt83=3;
                }
                break;
            case StringLiteral:
                {
                alt83=4;
                }
                break;
            case 70:
            case 71:
                {
                alt83=5;
                }
                break;
            case 69:
                {
                alt83=6;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("527:1: literal returns [Expression r] : (r_= integerLiteral | t= FloatingPointLiteral | t= CharacterLiteral | t= StringLiteral | r_= booleanLiteral | t= 'null' );", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:528:6: r_= integerLiteral
                    {
                    pushFollow(FOLLOW_integerLiteral_in_literal2403);
                    r_=integerLiteral();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                      r=r_;
                    }

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:529:9: t= FloatingPointLiteral
                    {
                    t=(Token)input.LT(1);
                    match(input,FloatingPointLiteral,FOLLOW_FloatingPointLiteral_in_literal2416); if (failed) return r;
                    if ( backtracking==0 ) {
                      r=FloatLiteral.make(l(t), t.getText());
                    }

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:530:9: t= CharacterLiteral
                    {
                    t=(Token)input.LT(1);
                    match(input,CharacterLiteral,FOLLOW_CharacterLiteral_in_literal2429); if (failed) return r;
                    if ( backtracking==0 ) {
                      r=CharLiteral.make(l(t), t.getText());
                    }

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:531:9: t= StringLiteral
                    {
                    t=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_literal2442); if (failed) return r;
                    if ( backtracking==0 ) {
                      r=com.epijava.lang.tree.StringLiteral.make(l(t), t.getText());
                    }

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:532:9: r_= booleanLiteral
                    {
                    pushFollow(FOLLOW_booleanLiteral_in_literal2455);
                    r_=booleanLiteral();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                      r=r_;
                    }

                    }
                    break;
                case 6 :
                    // src/com/epijava/grammar/EpiJava.g:533:9: t= 'null'
                    {
                    t=(Token)input.LT(1);
                    match(input,69,FOLLOW_69_in_literal2468); if (failed) return r;
                    if ( backtracking==0 ) {
                      r=new NullLiteral(l(t));
                    }

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 64, literal_StartIndex); }
        }
        return r;
    }
    // $ANTLR end literal


    // $ANTLR start integerLiteral
    // src/com/epijava/grammar/EpiJava.g:536:1: integerLiteral returns [Expression r] : (t= HexLiteral | t= OctalLiteral | t= DecimalLiteral );
    public final Expression integerLiteral() throws RecognitionException {
        Expression r = null;
        int integerLiteral_StartIndex = input.index();
        Token t=null;

        try {
            if ( backtracking>0 && alreadyParsedRule(input, 65) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:537:5: (t= HexLiteral | t= OctalLiteral | t= DecimalLiteral )
            int alt84=3;
            switch ( input.LA(1) ) {
            case HexLiteral:
                {
                alt84=1;
                }
                break;
            case OctalLiteral:
                {
                alt84=2;
                }
                break;
            case DecimalLiteral:
                {
                alt84=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("536:1: integerLiteral returns [Expression r] : (t= HexLiteral | t= OctalLiteral | t= DecimalLiteral );", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:537:9: t= HexLiteral
                    {
                    t=(Token)input.LT(1);
                    match(input,HexLiteral,FOLLOW_HexLiteral_in_integerLiteral2491); if (failed) return r;
                    if ( backtracking==0 ) {
                      r=IntLiteral.makeHex(l(t), t.getText());
                    }

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:538:9: t= OctalLiteral
                    {
                    t=(Token)input.LT(1);
                    match(input,OctalLiteral,FOLLOW_OctalLiteral_in_integerLiteral2504); if (failed) return r;
                    if ( backtracking==0 ) {
                      r=IntLiteral.makeOctal(l(t), t.getText());
                    }

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:539:9: t= DecimalLiteral
                    {
                    t=(Token)input.LT(1);
                    match(input,DecimalLiteral,FOLLOW_DecimalLiteral_in_integerLiteral2517); if (failed) return r;
                    if ( backtracking==0 ) {
                      r=IntLiteral.makeDecimal(l(t), t.getText());
                    }

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 65, integerLiteral_StartIndex); }
        }
        return r;
    }
    // $ANTLR end integerLiteral


    // $ANTLR start booleanLiteral
    // src/com/epijava/grammar/EpiJava.g:542:1: booleanLiteral returns [Expression r] : (t= 'true' | t= 'false' );
    public final Expression booleanLiteral() throws RecognitionException {
        Expression r = null;
        int booleanLiteral_StartIndex = input.index();
        Token t=null;

        try {
            if ( backtracking>0 && alreadyParsedRule(input, 66) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:543:5: (t= 'true' | t= 'false' )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==70) ) {
                alt85=1;
            }
            else if ( (LA85_0==71) ) {
                alt85=2;
            }
            else {
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("542:1: booleanLiteral returns [Expression r] : (t= 'true' | t= 'false' );", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:543:9: t= 'true'
                    {
                    t=(Token)input.LT(1);
                    match(input,70,FOLLOW_70_in_booleanLiteral2542); if (failed) return r;
                    if ( backtracking==0 ) {
                      r=new BooleanLiteral(l(t),true);
                    }

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:544:9: t= 'false'
                    {
                    t=(Token)input.LT(1);
                    match(input,71,FOLLOW_71_in_booleanLiteral2555); if (failed) return r;
                    if ( backtracking==0 ) {
                      r=new BooleanLiteral(l(t),false);
                    }

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 66, booleanLiteral_StartIndex); }
        }
        return r;
    }
    // $ANTLR end booleanLiteral


    // $ANTLR start annotations
    // src/com/epijava/grammar/EpiJava.g:549:1: annotations returns [List<Annotation> r] : ( annotation )* ;
    public final List<Annotation> annotations() throws RecognitionException {
        List<Annotation> r = null;
        int annotations_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 67) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:550:2: ( ( annotation )* )
            // src/com/epijava/grammar/EpiJava.g:550:4: ( annotation )*
            {
            // src/com/epijava/grammar/EpiJava.g:550:4: ( annotation )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==72) ) {
                    int LA86_3 = input.LA(2);

                    if ( (LA86_3==Identifier) ) {
                        int LA86_63 = input.LA(3);

                        if ( (synpred118()) ) {
                            alt86=1;
                        }


                    }


                }


                switch (alt86) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations2576);
            	    annotation();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 67, annotations_StartIndex); }
        }
        return r;
    }
    // $ANTLR end annotations


    // $ANTLR start annotation
    // src/com/epijava/grammar/EpiJava.g:553:1: annotation : '@' annotationName ( '(' ( elementValuePairs )? ')' )? ;
    public final void annotation() throws RecognitionException {
        int annotation_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 68) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:554:2: ( '@' annotationName ( '(' ( elementValuePairs )? ')' )? )
            // src/com/epijava/grammar/EpiJava.g:554:4: '@' annotationName ( '(' ( elementValuePairs )? ')' )?
            {
            match(input,72,FOLLOW_72_in_annotation2588); if (failed) return ;
            pushFollow(FOLLOW_annotationName_in_annotation2590);
            annotationName();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:554:23: ( '(' ( elementValuePairs )? ')' )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==66) ) {
                switch ( input.LA(2) ) {
                    case Identifier:
                        {
                        int LA88_65 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 105:
                        {
                        int LA88_66 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 106:
                        {
                        int LA88_67 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 109:
                        {
                        int LA88_68 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 110:
                        {
                        int LA88_69 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 111:
                        {
                        int LA88_70 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 112:
                        {
                        int LA88_71 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 66:
                        {
                        int LA88_72 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 34:
                        {
                        int LA88_73 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 113:
                        {
                        int LA88_74 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 65:
                        {
                        int LA88_75 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case HexLiteral:
                        {
                        int LA88_76 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case OctalLiteral:
                        {
                        int LA88_77 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case DecimalLiteral:
                        {
                        int LA88_78 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case FloatingPointLiteral:
                        {
                        int LA88_79 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case CharacterLiteral:
                        {
                        int LA88_80 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case StringLiteral:
                        {
                        int LA88_81 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 70:
                        {
                        int LA88_82 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 71:
                        {
                        int LA88_83 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 69:
                        {
                        int LA88_84 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 114:
                        {
                        int LA88_85 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 56:
                        {
                        int LA88_86 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 57:
                        {
                        int LA88_87 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 58:
                        {
                        int LA88_88 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 59:
                        {
                        int LA88_89 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 60:
                        {
                        int LA88_90 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 61:
                        {
                        int LA88_91 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 62:
                        {
                        int LA88_92 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 63:
                        {
                        int LA88_93 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 41:
                        {
                        int LA88_94 = input.LA(3);

                        if ( (synpred120()) ) {
                            alt88=1;
                        }
                        }
                        break;
                    case 38:
                    case 67:
                    case 72:
                        {
                        alt88=1;
                        }
                        break;
                }

            }
            switch (alt88) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:554:24: '(' ( elementValuePairs )? ')'
                    {
                    match(input,66,FOLLOW_66_in_annotation2593); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:554:28: ( elementValuePairs )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==Identifier||(LA87_0>=FloatingPointLiteral && LA87_0<=DecimalLiteral)||LA87_0==34||LA87_0==38||LA87_0==41||(LA87_0>=56 && LA87_0<=63)||(LA87_0>=65 && LA87_0<=66)||(LA87_0>=69 && LA87_0<=72)||(LA87_0>=105 && LA87_0<=106)||(LA87_0>=109 && LA87_0<=114)) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation2595);
                            elementValuePairs();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }

                    match(input,67,FOLLOW_67_in_annotation2598); if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 68, annotation_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotation


    // $ANTLR start annotationName
    // src/com/epijava/grammar/EpiJava.g:557:1: annotationName : Identifier ( '.' Identifier )* ;
    public final void annotationName() throws RecognitionException {
        int annotationName_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 69) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:558:2: ( Identifier ( '.' Identifier )* )
            // src/com/epijava/grammar/EpiJava.g:558:4: Identifier ( '.' Identifier )*
            {
            match(input,Identifier,FOLLOW_Identifier_in_annotationName2612); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:558:15: ( '.' Identifier )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==29) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:558:16: '.' Identifier
            	    {
            	    match(input,29,FOLLOW_29_in_annotationName2615); if (failed) return ;
            	    match(input,Identifier,FOLLOW_Identifier_in_annotationName2617); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 69, annotationName_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotationName


    // $ANTLR start elementValuePairs
    // src/com/epijava/grammar/EpiJava.g:561:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final void elementValuePairs() throws RecognitionException {
        int elementValuePairs_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 70) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:562:2: ( elementValuePair ( ',' elementValuePair )* )
            // src/com/epijava/grammar/EpiJava.g:562:4: elementValuePair ( ',' elementValuePair )*
            {
            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2631);
            elementValuePair();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:562:21: ( ',' elementValuePair )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==35) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:562:22: ',' elementValuePair
            	    {
            	    match(input,35,FOLLOW_35_in_elementValuePairs2634); if (failed) return ;
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2636);
            	    elementValuePair();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 70, elementValuePairs_StartIndex); }
        }
        return ;
    }
    // $ANTLR end elementValuePairs


    // $ANTLR start elementValuePair
    // src/com/epijava/grammar/EpiJava.g:565:1: elementValuePair : ( Identifier '=' )? elementValue ;
    public final void elementValuePair() throws RecognitionException {
        int elementValuePair_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 71) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:566:2: ( ( Identifier '=' )? elementValue )
            // src/com/epijava/grammar/EpiJava.g:566:4: ( Identifier '=' )? elementValue
            {
            // src/com/epijava/grammar/EpiJava.g:566:4: ( Identifier '=' )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==Identifier) ) {
                int LA91_1 = input.LA(2);

                if ( (LA91_1==45) ) {
                    alt91=1;
                }
            }
            switch (alt91) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:566:5: Identifier '='
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2651); if (failed) return ;
                    match(input,45,FOLLOW_45_in_elementValuePair2653); if (failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_elementValue_in_elementValuePair2657);
            elementValue();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 71, elementValuePair_StartIndex); }
        }
        return ;
    }
    // $ANTLR end elementValuePair


    // $ANTLR start elementValue
    // src/com/epijava/grammar/EpiJava.g:569:1: elementValue : ( conditionalExpression | annotation | elementValueArrayInitializer );
    public final void elementValue() throws RecognitionException {
        int elementValue_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 72) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:570:2: ( conditionalExpression | annotation | elementValueArrayInitializer )
            int alt92=3;
            switch ( input.LA(1) ) {
            case Identifier:
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 34:
            case 41:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 65:
            case 66:
            case 69:
            case 70:
            case 71:
            case 105:
            case 106:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                {
                alt92=1;
                }
                break;
            case 72:
                {
                alt92=2;
                }
                break;
            case 38:
                {
                alt92=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("569:1: elementValue : ( conditionalExpression | annotation | elementValueArrayInitializer );", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:570:4: conditionalExpression
                    {
                    pushFollow(FOLLOW_conditionalExpression_in_elementValue2669);
                    conditionalExpression();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:571:6: annotation
                    {
                    pushFollow(FOLLOW_annotation_in_elementValue2676);
                    annotation();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:572:6: elementValueArrayInitializer
                    {
                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2683);
                    elementValueArrayInitializer();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 72, elementValue_StartIndex); }
        }
        return ;
    }
    // $ANTLR end elementValue


    // $ANTLR start elementValueArrayInitializer
    // src/com/epijava/grammar/EpiJava.g:575:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? '}' ;
    public final void elementValueArrayInitializer() throws RecognitionException {
        int elementValueArrayInitializer_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 73) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:576:2: ( '{' ( elementValue ( ',' elementValue )* )? '}' )
            // src/com/epijava/grammar/EpiJava.g:576:4: '{' ( elementValue ( ',' elementValue )* )? '}'
            {
            match(input,38,FOLLOW_38_in_elementValueArrayInitializer2695); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:576:8: ( elementValue ( ',' elementValue )* )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==Identifier||(LA94_0>=FloatingPointLiteral && LA94_0<=DecimalLiteral)||LA94_0==34||LA94_0==38||LA94_0==41||(LA94_0>=56 && LA94_0<=63)||(LA94_0>=65 && LA94_0<=66)||(LA94_0>=69 && LA94_0<=72)||(LA94_0>=105 && LA94_0<=106)||(LA94_0>=109 && LA94_0<=114)) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:576:9: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2698);
                    elementValue();
                    _fsp--;
                    if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:576:22: ( ',' elementValue )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==35) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:576:23: ',' elementValue
                    	    {
                    	    match(input,35,FOLLOW_35_in_elementValueArrayInitializer2701); if (failed) return ;
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2703);
                    	    elementValue();
                    	    _fsp--;
                    	    if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop93;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,39,FOLLOW_39_in_elementValueArrayInitializer2710); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 73, elementValueArrayInitializer_StartIndex); }
        }
        return ;
    }
    // $ANTLR end elementValueArrayInitializer


    // $ANTLR start annotationTypeDeclaration
    // src/com/epijava/grammar/EpiJava.g:579:1: annotationTypeDeclaration : '@' 'interface' Identifier annotationTypeBody ;
    public final void annotationTypeDeclaration() throws RecognitionException {
        int annotationTypeDeclaration_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 74) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:580:2: ( '@' 'interface' Identifier annotationTypeBody )
            // src/com/epijava/grammar/EpiJava.g:580:4: '@' 'interface' Identifier annotationTypeBody
            {
            match(input,72,FOLLOW_72_in_annotationTypeDeclaration2722); if (failed) return ;
            match(input,40,FOLLOW_40_in_annotationTypeDeclaration2724); if (failed) return ;
            match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2726); if (failed) return ;
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2728);
            annotationTypeBody();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 74, annotationTypeDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotationTypeDeclaration


    // $ANTLR start annotationTypeBody
    // src/com/epijava/grammar/EpiJava.g:583:1: annotationTypeBody : '{' ( annotationTypeElementDeclarations )? '}' ;
    public final void annotationTypeBody() throws RecognitionException {
        int annotationTypeBody_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 75) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:584:2: ( '{' ( annotationTypeElementDeclarations )? '}' )
            // src/com/epijava/grammar/EpiJava.g:584:4: '{' ( annotationTypeElementDeclarations )? '}'
            {
            match(input,38,FOLLOW_38_in_annotationTypeBody2740); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:584:8: ( annotationTypeElementDeclarations )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( ((LA95_0>=Identifier && LA95_0<=ENUM)||LA95_0==28||LA95_0==31||LA95_0==40||(LA95_0>=46 && LA95_0<=63)||LA95_0==72) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:584:9: annotationTypeElementDeclarations
                    {
                    pushFollow(FOLLOW_annotationTypeElementDeclarations_in_annotationTypeBody2743);
                    annotationTypeElementDeclarations();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            match(input,39,FOLLOW_39_in_annotationTypeBody2747); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 75, annotationTypeBody_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotationTypeBody


    // $ANTLR start annotationTypeElementDeclarations
    // src/com/epijava/grammar/EpiJava.g:587:1: annotationTypeElementDeclarations : ( annotationTypeElementDeclaration ) ( annotationTypeElementDeclaration )* ;
    public final void annotationTypeElementDeclarations() throws RecognitionException {
        int annotationTypeElementDeclarations_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 76) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:588:2: ( ( annotationTypeElementDeclaration ) ( annotationTypeElementDeclaration )* )
            // src/com/epijava/grammar/EpiJava.g:588:4: ( annotationTypeElementDeclaration ) ( annotationTypeElementDeclaration )*
            {
            // src/com/epijava/grammar/EpiJava.g:588:4: ( annotationTypeElementDeclaration )
            // src/com/epijava/grammar/EpiJava.g:588:5: annotationTypeElementDeclaration
            {
            pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeElementDeclarations2760);
            annotationTypeElementDeclaration();
            _fsp--;
            if (failed) return ;

            }

            // src/com/epijava/grammar/EpiJava.g:588:39: ( annotationTypeElementDeclaration )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( ((LA96_0>=Identifier && LA96_0<=ENUM)||LA96_0==28||LA96_0==31||LA96_0==40||(LA96_0>=46 && LA96_0<=63)||LA96_0==72) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:588:40: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeElementDeclarations2764);
            	    annotationTypeElementDeclaration();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 76, annotationTypeElementDeclarations_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotationTypeElementDeclarations


    // $ANTLR start annotationTypeElementDeclaration
    // src/com/epijava/grammar/EpiJava.g:591:1: annotationTypeElementDeclaration : ( modifier )* annotationTypeElementRest ;
    public final void annotationTypeElementDeclaration() throws RecognitionException {
        int annotationTypeElementDeclaration_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 77) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:592:2: ( ( modifier )* annotationTypeElementRest )
            // src/com/epijava/grammar/EpiJava.g:592:4: ( modifier )* annotationTypeElementRest
            {
            // src/com/epijava/grammar/EpiJava.g:592:4: ( modifier )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==72) ) {
                    int LA97_13 = input.LA(2);

                    if ( (LA97_13==Identifier) ) {
                        alt97=1;
                    }


                }
                else if ( (LA97_0==28||(LA97_0>=46 && LA97_0<=55)) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:592:5: modifier
            	    {
            	    pushFollow(FOLLOW_modifier_in_annotationTypeElementDeclaration2779);
            	    modifier();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2783);
            annotationTypeElementRest();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 77, annotationTypeElementDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotationTypeElementDeclaration


    // $ANTLR start annotationTypeElementRest
    // src/com/epijava/grammar/EpiJava.g:595:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | classDeclaration ( ';' )? | interfaceDeclaration ( ';' )? | enumDeclaration ( ';' )? | annotationTypeDeclaration ( ';' )? );
    public final void annotationTypeElementRest() throws RecognitionException {
        int annotationTypeElementRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 78) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:596:2: ( type annotationMethodOrConstantRest ';' | classDeclaration ( ';' )? | interfaceDeclaration ( ';' )? | enumDeclaration ( ';' )? | annotationTypeDeclaration ( ';' )? )
            int alt102=5;
            switch ( input.LA(1) ) {
            case Identifier:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt102=1;
                }
                break;
            case 31:
                {
                alt102=2;
                }
                break;
            case ENUM:
                {
                int LA102_11 = input.LA(2);

                if ( (LA102_11==Identifier) ) {
                    int LA102_14 = input.LA(3);

                    if ( (synpred133()) ) {
                        alt102=2;
                    }
                    else if ( (synpred137()) ) {
                        alt102=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("595:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | classDeclaration ( ';' )? | interfaceDeclaration ( ';' )? | enumDeclaration ( ';' )? | annotationTypeDeclaration ( ';' )? );", 102, 14, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("595:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | classDeclaration ( ';' )? | interfaceDeclaration ( ';' )? | enumDeclaration ( ';' )? | annotationTypeDeclaration ( ';' )? );", 102, 11, input);

                    throw nvae;
                }
                }
                break;
            case 40:
                {
                alt102=3;
                }
                break;
            case 72:
                {
                int LA102_13 = input.LA(2);

                if ( (LA102_13==40) ) {
                    int LA102_15 = input.LA(3);

                    if ( (synpred135()) ) {
                        alt102=3;
                    }
                    else if ( (true) ) {
                        alt102=5;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("595:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | classDeclaration ( ';' )? | interfaceDeclaration ( ';' )? | enumDeclaration ( ';' )? | annotationTypeDeclaration ( ';' )? );", 102, 15, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("595:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | classDeclaration ( ';' )? | interfaceDeclaration ( ';' )? | enumDeclaration ( ';' )? | annotationTypeDeclaration ( ';' )? );", 102, 13, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("595:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | classDeclaration ( ';' )? | interfaceDeclaration ( ';' )? | enumDeclaration ( ';' )? | annotationTypeDeclaration ( ';' )? );", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:596:4: type annotationMethodOrConstantRest ';'
                    {
                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2795);
                    type();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2797);
                    annotationMethodOrConstantRest();
                    _fsp--;
                    if (failed) return ;
                    match(input,26,FOLLOW_26_in_annotationTypeElementRest2799); if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:597:6: classDeclaration ( ';' )?
                    {
                    pushFollow(FOLLOW_classDeclaration_in_annotationTypeElementRest2806);
                    classDeclaration();
                    _fsp--;
                    if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:597:23: ( ';' )?
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==26) ) {
                        alt98=1;
                    }
                    switch (alt98) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: ';'
                            {
                            match(input,26,FOLLOW_26_in_annotationTypeElementRest2808); if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:598:6: interfaceDeclaration ( ';' )?
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_annotationTypeElementRest2816);
                    interfaceDeclaration();
                    _fsp--;
                    if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:598:27: ( ';' )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==26) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: ';'
                            {
                            match(input,26,FOLLOW_26_in_annotationTypeElementRest2818); if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:599:6: enumDeclaration ( ';' )?
                    {
                    pushFollow(FOLLOW_enumDeclaration_in_annotationTypeElementRest2826);
                    enumDeclaration();
                    _fsp--;
                    if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:599:22: ( ';' )?
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==26) ) {
                        alt100=1;
                    }
                    switch (alt100) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: ';'
                            {
                            match(input,26,FOLLOW_26_in_annotationTypeElementRest2828); if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:600:6: annotationTypeDeclaration ( ';' )?
                    {
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2836);
                    annotationTypeDeclaration();
                    _fsp--;
                    if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:600:32: ( ';' )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==26) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: ';'
                            {
                            match(input,26,FOLLOW_26_in_annotationTypeElementRest2838); if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 78, annotationTypeElementRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotationTypeElementRest


    // $ANTLR start annotationMethodOrConstantRest
    // src/com/epijava/grammar/EpiJava.g:603:1: annotationMethodOrConstantRest : ( annotationMethodRest | annotationConstantRest );
    public final void annotationMethodOrConstantRest() throws RecognitionException {
        int annotationMethodOrConstantRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 79) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:604:2: ( annotationMethodRest | annotationConstantRest )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==Identifier) ) {
                int LA103_1 = input.LA(2);

                if ( (LA103_1==66) ) {
                    alt103=1;
                }
                else if ( (LA103_1==26||LA103_1==35||LA103_1==42||LA103_1==45) ) {
                    alt103=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("603:1: annotationMethodOrConstantRest : ( annotationMethodRest | annotationConstantRest );", 103, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("603:1: annotationMethodOrConstantRest : ( annotationMethodRest | annotationConstantRest );", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:604:4: annotationMethodRest
                    {
                    pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2851);
                    annotationMethodRest();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:605:6: annotationConstantRest
                    {
                    pushFollow(FOLLOW_annotationConstantRest_in_annotationMethodOrConstantRest2858);
                    annotationConstantRest();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 79, annotationMethodOrConstantRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotationMethodOrConstantRest


    // $ANTLR start annotationMethodRest
    // src/com/epijava/grammar/EpiJava.g:608:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final void annotationMethodRest() throws RecognitionException {
        int annotationMethodRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 80) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:609:3: ( Identifier '(' ')' ( defaultValue )? )
            // src/com/epijava/grammar/EpiJava.g:609:5: Identifier '(' ')' ( defaultValue )?
            {
            match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2871); if (failed) return ;
            match(input,66,FOLLOW_66_in_annotationMethodRest2873); if (failed) return ;
            match(input,67,FOLLOW_67_in_annotationMethodRest2875); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:609:24: ( defaultValue )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==73) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:609:25: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2878);
                    defaultValue();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 80, annotationMethodRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotationMethodRest


    // $ANTLR start annotationConstantRest
    // src/com/epijava/grammar/EpiJava.g:612:1: annotationConstantRest : variableDeclarators ;
    public final void annotationConstantRest() throws RecognitionException {
        int annotationConstantRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 81) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:613:3: ( variableDeclarators )
            // src/com/epijava/grammar/EpiJava.g:613:5: variableDeclarators
            {
            pushFollow(FOLLOW_variableDeclarators_in_annotationConstantRest2895);
            variableDeclarators();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 81, annotationConstantRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end annotationConstantRest


    // $ANTLR start defaultValue
    // src/com/epijava/grammar/EpiJava.g:616:1: defaultValue : 'default' elementValue ;
    public final void defaultValue() throws RecognitionException {
        int defaultValue_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 82) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:617:3: ( 'default' elementValue )
            // src/com/epijava/grammar/EpiJava.g:617:5: 'default' elementValue
            {
            match(input,73,FOLLOW_73_in_defaultValue2910); if (failed) return ;
            pushFollow(FOLLOW_elementValue_in_defaultValue2912);
            elementValue();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 82, defaultValue_StartIndex); }
        }
        return ;
    }
    // $ANTLR end defaultValue


    // $ANTLR start block
    // src/com/epijava/grammar/EpiJava.g:622:1: block returns [Block r] : t= '{' (s= blockStatement )* '}' ;
    public final Block block() throws RecognitionException {
        Block r = null;
        int block_StartIndex = input.index();
        Token t=null;
        Expression s = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 83) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:623:2: (t= '{' (s= blockStatement )* '}' )
            // src/com/epijava/grammar/EpiJava.g:623:4: t= '{' (s= blockStatement )* '}'
            {
            t=(Token)input.LT(1);
            match(input,38,FOLLOW_38_in_block2932); if (failed) return r;
            if ( backtracking==0 ) {
               r = new Block(l(t)); 
            }
            // src/com/epijava/grammar/EpiJava.g:625:6: (s= blockStatement )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( ((LA105_0>=Identifier && LA105_0<=DecimalLiteral)||LA105_0==26||LA105_0==28||LA105_0==31||LA105_0==34||LA105_0==38||(LA105_0>=40 && LA105_0<=41)||(LA105_0>=46 && LA105_0<=63)||(LA105_0>=65 && LA105_0<=66)||(LA105_0>=69 && LA105_0<=72)||LA105_0==74||LA105_0==76||(LA105_0>=78 && LA105_0<=81)||(LA105_0>=83 && LA105_0<=87)||(LA105_0>=105 && LA105_0<=106)||(LA105_0>=109 && LA105_0<=114)) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:625:7: s= blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_block2950);
            	    s=blockStatement();
            	    _fsp--;
            	    if (failed) return r;
            	    if ( backtracking==0 ) {
            	      r.add(s);
            	    }

            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);

            match(input,39,FOLLOW_39_in_block2961); if (failed) return r;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 83, block_StartIndex); }
        }
        return r;
    }
    // $ANTLR end block


    // $ANTLR start blockStatement
    // src/com/epijava/grammar/EpiJava.g:629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );
    public final Expression blockStatement() throws RecognitionException {
        Expression r = null;
        int blockStatement_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 84) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:630:2: ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement )
            int alt106=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                switch ( input.LA(2) ) {
                case Identifier:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                    {
                    alt106=1;
                    }
                    break;
                case 50:
                    {
                    int LA106_68 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (synpred143()) ) {
                        alt106=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 68, input);

                        throw nvae;
                    }
                    }
                    break;
                case 72:
                    {
                    int LA106_69 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (synpred143()) ) {
                        alt106=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 69, input);

                        throw nvae;
                    }
                    }
                    break;
                case ENUM:
                case 28:
                case 31:
                case 40:
                case 46:
                case 47:
                case 48:
                case 49:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                    {
                    alt106=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 1, input);

                    throw nvae;
                }

                }
                break;
            case 72:
                {
                int LA106_2 = input.LA(2);

                if ( (LA106_2==40) ) {
                    alt106=2;
                }
                else if ( (LA106_2==Identifier) ) {
                    int LA106_84 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (synpred143()) ) {
                        alt106=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 84, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 2, input);

                    throw nvae;
                }
                }
                break;
            case Identifier:
                {
                switch ( input.LA(2) ) {
                case 26:
                case 30:
                case 36:
                case 37:
                case 45:
                case 64:
                case 66:
                case 75:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                    {
                    alt106=3;
                    }
                    break;
                case 29:
                    {
                    int LA106_86 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 86, input);

                        throw nvae;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA106_87 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 87, input);

                        throw nvae;
                    }
                    }
                    break;
                case 34:
                    {
                    int LA106_92 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 92, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt106=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 3, input);

                    throw nvae;
                }

                }
                break;
            case 56:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA106_113 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 113, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt106=3;
                    }
                    break;
                case Identifier:
                    {
                    alt106=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 4, input);

                    throw nvae;
                }

                }
                break;
            case 57:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA106_116 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 116, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt106=1;
                    }
                    break;
                case 29:
                    {
                    alt106=3;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 5, input);

                    throw nvae;
                }

                }
                break;
            case 58:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA106_119 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 119, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt106=3;
                    }
                    break;
                case Identifier:
                    {
                    alt106=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 6, input);

                    throw nvae;
                }

                }
                break;
            case 59:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA106_122 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 122, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt106=3;
                    }
                    break;
                case Identifier:
                    {
                    alt106=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 7, input);

                    throw nvae;
                }

                }
                break;
            case 60:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA106_125 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 125, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt106=1;
                    }
                    break;
                case 29:
                    {
                    alt106=3;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 8, input);

                    throw nvae;
                }

                }
                break;
            case 61:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA106_128 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 128, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt106=3;
                    }
                    break;
                case Identifier:
                    {
                    alt106=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 9, input);

                    throw nvae;
                }

                }
                break;
            case 62:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA106_131 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 131, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt106=1;
                    }
                    break;
                case 29:
                    {
                    alt106=3;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 10, input);

                    throw nvae;
                }

                }
                break;
            case 63:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA106_134 = input.LA(3);

                    if ( (synpred142()) ) {
                        alt106=1;
                    }
                    else if ( (true) ) {
                        alt106=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 134, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt106=1;
                    }
                    break;
                case 29:
                    {
                    alt106=3;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 11, input);

                    throw nvae;
                }

                }
                break;
            case ENUM:
            case 28:
            case 31:
            case 40:
            case 46:
            case 47:
            case 48:
            case 49:
            case 51:
            case 53:
            case 54:
            case 55:
                {
                alt106=2;
                }
                break;
            case 52:
                {
                int LA106_18 = input.LA(2);

                if ( (LA106_18==66) ) {
                    alt106=3;
                }
                else if ( (LA106_18==ENUM||LA106_18==28||LA106_18==31||LA106_18==40||(LA106_18>=46 && LA106_18<=55)||LA106_18==72) ) {
                    alt106=2;
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 18, input);

                    throw nvae;
                }
                }
                break;
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 26:
            case 34:
            case 38:
            case 41:
            case 65:
            case 66:
            case 69:
            case 70:
            case 71:
            case 74:
            case 76:
            case 78:
            case 79:
            case 80:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 105:
            case 106:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                {
                alt106=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("629:1: blockStatement returns [Expression r] : ( localVariableDeclaration | classOrInterfaceDeclaration | r_= statement );", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:630:4: localVariableDeclaration
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_blockStatement2977);
                    localVariableDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:631:4: classOrInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_blockStatement2982);
                    classOrInterfaceDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:632:7: r_= statement
                    {
                    pushFollow(FOLLOW_statement_in_blockStatement2993);
                    r_=statement();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r = r_; 
                    }

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 84, blockStatement_StartIndex); }
        }
        return r;
    }
    // $ANTLR end blockStatement


    // $ANTLR start topLevelStatement
    // src/com/epijava/grammar/EpiJava.g:635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );
    public final Expression topLevelStatement() throws RecognitionException {
        Expression r = null;
        int topLevelStatement_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 85) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:636:5: ( localVariableDeclaration | r_= statement )
            int alt107=2;
            switch ( input.LA(1) ) {
            case 50:
            case 72:
                {
                alt107=1;
                }
                break;
            case Identifier:
                {
                switch ( input.LA(2) ) {
                case 26:
                case 30:
                case 36:
                case 37:
                case 45:
                case 64:
                case 66:
                case 75:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                    {
                    alt107=2;
                    }
                    break;
                case 34:
                    {
                    int LA107_48 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 48, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    int LA107_49 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 49, input);

                        throw nvae;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA107_50 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 50, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt107=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 3, input);

                    throw nvae;
                }

                }
                break;
            case 56:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA107_75 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 75, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt107=2;
                    }
                    break;
                case Identifier:
                    {
                    alt107=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 4, input);

                    throw nvae;
                }

                }
                break;
            case 57:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA107_78 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 78, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt107=1;
                    }
                    break;
                case 29:
                    {
                    alt107=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 5, input);

                    throw nvae;
                }

                }
                break;
            case 58:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA107_81 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 81, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt107=2;
                    }
                    break;
                case Identifier:
                    {
                    alt107=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 6, input);

                    throw nvae;
                }

                }
                break;
            case 59:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA107_84 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 84, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt107=2;
                    }
                    break;
                case Identifier:
                    {
                    alt107=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 7, input);

                    throw nvae;
                }

                }
                break;
            case 60:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA107_87 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 87, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt107=1;
                    }
                    break;
                case 29:
                    {
                    alt107=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 8, input);

                    throw nvae;
                }

                }
                break;
            case 61:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA107_90 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 90, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt107=2;
                    }
                    break;
                case Identifier:
                    {
                    alt107=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 9, input);

                    throw nvae;
                }

                }
                break;
            case 62:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA107_93 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 93, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt107=1;
                    }
                    break;
                case 29:
                    {
                    alt107=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 10, input);

                    throw nvae;
                }

                }
                break;
            case 63:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA107_96 = input.LA(3);

                    if ( (synpred144()) ) {
                        alt107=1;
                    }
                    else if ( (true) ) {
                        alt107=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 96, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt107=1;
                    }
                    break;
                case 29:
                    {
                    alt107=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 11, input);

                    throw nvae;
                }

                }
                break;
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 26:
            case 34:
            case 38:
            case 41:
            case 52:
            case 65:
            case 66:
            case 69:
            case 70:
            case 71:
            case 74:
            case 76:
            case 78:
            case 79:
            case 80:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 105:
            case 106:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                {
                alt107=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("635:1: topLevelStatement returns [Expression r] : ( localVariableDeclaration | r_= statement );", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:636:9: localVariableDeclaration
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_topLevelStatement3016);
                    localVariableDeclaration();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:637:9: r_= statement
                    {
                    pushFollow(FOLLOW_statement_in_topLevelStatement3028);
                    r_=statement();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r = r_; 
                    }

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 85, topLevelStatement_StartIndex); }
        }
        return r;
    }
    // $ANTLR end topLevelStatement


    // $ANTLR start localVariableDeclaration
    // src/com/epijava/grammar/EpiJava.g:640:1: localVariableDeclaration : ( variableModifier )* type variableDeclarators ';' ;
    public final void localVariableDeclaration() throws RecognitionException {
        int localVariableDeclaration_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 86) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:641:2: ( ( variableModifier )* type variableDeclarators ';' )
            // src/com/epijava/grammar/EpiJava.g:641:4: ( variableModifier )* type variableDeclarators ';'
            {
            // src/com/epijava/grammar/EpiJava.g:641:4: ( variableModifier )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==50||LA108_0==72) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:0:0: variableModifier
            	    {
            	    pushFollow(FOLLOW_variableModifier_in_localVariableDeclaration3046);
            	    variableModifier();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);

            pushFollow(FOLLOW_type_in_localVariableDeclaration3049);
            type();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_variableDeclarators_in_localVariableDeclaration3051);
            variableDeclarators();
            _fsp--;
            if (failed) return ;
            match(input,26,FOLLOW_26_in_localVariableDeclaration3053); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 86, localVariableDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end localVariableDeclaration


    // $ANTLR start statement
    // src/com/epijava/grammar/EpiJava.g:645:1: statement returns [Expression r] : (r_= block | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( options {k=1; } : 'else' statement )? | 'for' '(' forControl ')' statement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | 'try' block ( catches 'finally' block | catches | 'finally' block ) | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( Identifier )? ';' | 'continue' ( Identifier )? ';' | ';' | r_= statementExpression ';' | Identifier ':' statement );
    public final Expression statement() throws RecognitionException {
        Expression r = null;
        int statement_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 87) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:646:2: (r_= block | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( options {k=1; } : 'else' statement )? | 'for' '(' forControl ')' statement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | 'try' block ( catches 'finally' block | catches | 'finally' block ) | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( Identifier )? ';' | 'continue' ( Identifier )? ';' | ';' | r_= statementExpression ';' | Identifier ':' statement )
            int alt115=16;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt115=1;
                }
                break;
            case 74:
                {
                alt115=2;
                }
                break;
            case 76:
                {
                alt115=3;
                }
                break;
            case 78:
                {
                alt115=4;
                }
                break;
            case 79:
                {
                alt115=5;
                }
                break;
            case 80:
                {
                alt115=6;
                }
                break;
            case 81:
                {
                alt115=7;
                }
                break;
            case 83:
                {
                alt115=8;
                }
                break;
            case 52:
                {
                alt115=9;
                }
                break;
            case 84:
                {
                alt115=10;
                }
                break;
            case 85:
                {
                alt115=11;
                }
                break;
            case 86:
                {
                alt115=12;
                }
                break;
            case 87:
                {
                alt115=13;
                }
                break;
            case 26:
                {
                alt115=14;
                }
                break;
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 34:
            case 41:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 65:
            case 66:
            case 69:
            case 70:
            case 71:
            case 105:
            case 106:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                {
                alt115=15;
                }
                break;
            case Identifier:
                {
                int LA115_35 = input.LA(2);

                if ( (LA115_35==75) ) {
                    alt115=16;
                }
                else if ( (LA115_35==26||(LA115_35>=29 && LA115_35<=30)||LA115_35==34||(LA115_35>=36 && LA115_35<=37)||LA115_35==42||LA115_35==45||LA115_35==64||LA115_35==66||(LA115_35>=90 && LA115_35<=110)) ) {
                    alt115=15;
                }
                else {
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("645:1: statement returns [Expression r] : (r_= block | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( options {k=1; } : 'else' statement )? | 'for' '(' forControl ')' statement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | 'try' block ( catches 'finally' block | catches | 'finally' block ) | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( Identifier )? ';' | 'continue' ( Identifier )? ';' | ';' | r_= statementExpression ';' | Identifier ':' statement );", 115, 35, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("645:1: statement returns [Expression r] : (r_= block | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( options {k=1; } : 'else' statement )? | 'for' '(' forControl ')' statement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | 'try' block ( catches 'finally' block | catches | 'finally' block ) | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( Identifier )? ';' | 'continue' ( Identifier )? ';' | ';' | r_= statementExpression ';' | Identifier ':' statement );", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:646:4: r_= block
                    {
                    pushFollow(FOLLOW_block_in_statement3073);
                    r_=block();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r = r_; 
                    }

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:647:7: 'assert' expression ( ':' expression )? ';'
                    {
                    match(input,74,FOLLOW_74_in_statement3083); if (failed) return r;
                    pushFollow(FOLLOW_expression_in_statement3085);
                    expression();
                    _fsp--;
                    if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:647:27: ( ':' expression )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==75) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:647:28: ':' expression
                            {
                            match(input,75,FOLLOW_75_in_statement3088); if (failed) return r;
                            pushFollow(FOLLOW_expression_in_statement3090);
                            expression();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;

                    }

                    match(input,26,FOLLOW_26_in_statement3094); if (failed) return r;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:648:7: 'if' parExpression statement ( options {k=1; } : 'else' statement )?
                    {
                    match(input,76,FOLLOW_76_in_statement3102); if (failed) return r;
                    pushFollow(FOLLOW_parExpression_in_statement3104);
                    parExpression();
                    _fsp--;
                    if (failed) return r;
                    pushFollow(FOLLOW_statement_in_statement3106);
                    statement();
                    _fsp--;
                    if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:648:36: ( options {k=1; } : 'else' statement )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==77) ) {
                        int LA110_1 = input.LA(2);

                        if ( (synpred149()) ) {
                            alt110=1;
                        }
                    }
                    switch (alt110) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:648:52: 'else' statement
                            {
                            match(input,77,FOLLOW_77_in_statement3116); if (failed) return r;
                            pushFollow(FOLLOW_statement_in_statement3118);
                            statement();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:649:7: 'for' '(' forControl ')' statement
                    {
                    match(input,78,FOLLOW_78_in_statement3128); if (failed) return r;
                    match(input,66,FOLLOW_66_in_statement3130); if (failed) return r;
                    pushFollow(FOLLOW_forControl_in_statement3132);
                    forControl();
                    _fsp--;
                    if (failed) return r;
                    match(input,67,FOLLOW_67_in_statement3134); if (failed) return r;
                    pushFollow(FOLLOW_statement_in_statement3136);
                    statement();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:650:7: 'while' parExpression statement
                    {
                    match(input,79,FOLLOW_79_in_statement3144); if (failed) return r;
                    pushFollow(FOLLOW_parExpression_in_statement3146);
                    parExpression();
                    _fsp--;
                    if (failed) return r;
                    pushFollow(FOLLOW_statement_in_statement3148);
                    statement();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 6 :
                    // src/com/epijava/grammar/EpiJava.g:651:7: 'do' statement 'while' parExpression ';'
                    {
                    match(input,80,FOLLOW_80_in_statement3156); if (failed) return r;
                    pushFollow(FOLLOW_statement_in_statement3158);
                    statement();
                    _fsp--;
                    if (failed) return r;
                    match(input,79,FOLLOW_79_in_statement3160); if (failed) return r;
                    pushFollow(FOLLOW_parExpression_in_statement3162);
                    parExpression();
                    _fsp--;
                    if (failed) return r;
                    match(input,26,FOLLOW_26_in_statement3164); if (failed) return r;

                    }
                    break;
                case 7 :
                    // src/com/epijava/grammar/EpiJava.g:652:7: 'try' block ( catches 'finally' block | catches | 'finally' block )
                    {
                    match(input,81,FOLLOW_81_in_statement3172); if (failed) return r;
                    pushFollow(FOLLOW_block_in_statement3174);
                    block();
                    _fsp--;
                    if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:653:7: ( catches 'finally' block | catches | 'finally' block )
                    int alt111=3;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==88) ) {
                        int LA111_1 = input.LA(2);

                        if ( (LA111_1==66) ) {
                            int LA111_3 = input.LA(3);

                            if ( (synpred154()) ) {
                                alt111=1;
                            }
                            else if ( (synpred155()) ) {
                                alt111=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return r;}
                                NoViableAltException nvae =
                                    new NoViableAltException("653:7: ( catches 'finally' block | catches | 'finally' block )", 111, 3, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return r;}
                            NoViableAltException nvae =
                                new NoViableAltException("653:7: ( catches 'finally' block | catches | 'finally' block )", 111, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA111_0==82) ) {
                        alt111=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("653:7: ( catches 'finally' block | catches | 'finally' block )", 111, 0, input);

                        throw nvae;
                    }
                    switch (alt111) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:653:9: catches 'finally' block
                            {
                            pushFollow(FOLLOW_catches_in_statement3184);
                            catches();
                            _fsp--;
                            if (failed) return r;
                            match(input,82,FOLLOW_82_in_statement3186); if (failed) return r;
                            pushFollow(FOLLOW_block_in_statement3188);
                            block();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;
                        case 2 :
                            // src/com/epijava/grammar/EpiJava.g:654:9: catches
                            {
                            pushFollow(FOLLOW_catches_in_statement3198);
                            catches();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;
                        case 3 :
                            // src/com/epijava/grammar/EpiJava.g:655:9: 'finally' block
                            {
                            match(input,82,FOLLOW_82_in_statement3208); if (failed) return r;
                            pushFollow(FOLLOW_block_in_statement3210);
                            block();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // src/com/epijava/grammar/EpiJava.g:657:7: 'switch' parExpression '{' switchBlockStatementGroups '}'
                    {
                    match(input,83,FOLLOW_83_in_statement3226); if (failed) return r;
                    pushFollow(FOLLOW_parExpression_in_statement3228);
                    parExpression();
                    _fsp--;
                    if (failed) return r;
                    match(input,38,FOLLOW_38_in_statement3230); if (failed) return r;
                    pushFollow(FOLLOW_switchBlockStatementGroups_in_statement3232);
                    switchBlockStatementGroups();
                    _fsp--;
                    if (failed) return r;
                    match(input,39,FOLLOW_39_in_statement3234); if (failed) return r;

                    }
                    break;
                case 9 :
                    // src/com/epijava/grammar/EpiJava.g:658:7: 'synchronized' parExpression block
                    {
                    match(input,52,FOLLOW_52_in_statement3242); if (failed) return r;
                    pushFollow(FOLLOW_parExpression_in_statement3244);
                    parExpression();
                    _fsp--;
                    if (failed) return r;
                    pushFollow(FOLLOW_block_in_statement3246);
                    block();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 10 :
                    // src/com/epijava/grammar/EpiJava.g:659:7: 'return' ( expression )? ';'
                    {
                    match(input,84,FOLLOW_84_in_statement3254); if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:659:16: ( expression )?
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( (LA112_0==Identifier||(LA112_0>=FloatingPointLiteral && LA112_0<=DecimalLiteral)||LA112_0==34||LA112_0==41||(LA112_0>=56 && LA112_0<=63)||(LA112_0>=65 && LA112_0<=66)||(LA112_0>=69 && LA112_0<=71)||(LA112_0>=105 && LA112_0<=106)||(LA112_0>=109 && LA112_0<=114)) ) {
                        alt112=1;
                    }
                    switch (alt112) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement3256);
                            expression();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;

                    }

                    match(input,26,FOLLOW_26_in_statement3259); if (failed) return r;

                    }
                    break;
                case 11 :
                    // src/com/epijava/grammar/EpiJava.g:660:7: 'throw' expression ';'
                    {
                    match(input,85,FOLLOW_85_in_statement3267); if (failed) return r;
                    pushFollow(FOLLOW_expression_in_statement3269);
                    expression();
                    _fsp--;
                    if (failed) return r;
                    match(input,26,FOLLOW_26_in_statement3271); if (failed) return r;

                    }
                    break;
                case 12 :
                    // src/com/epijava/grammar/EpiJava.g:661:7: 'break' ( Identifier )? ';'
                    {
                    match(input,86,FOLLOW_86_in_statement3279); if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:661:15: ( Identifier )?
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( (LA113_0==Identifier) ) {
                        alt113=1;
                    }
                    switch (alt113) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: Identifier
                            {
                            match(input,Identifier,FOLLOW_Identifier_in_statement3281); if (failed) return r;

                            }
                            break;

                    }

                    match(input,26,FOLLOW_26_in_statement3284); if (failed) return r;

                    }
                    break;
                case 13 :
                    // src/com/epijava/grammar/EpiJava.g:662:7: 'continue' ( Identifier )? ';'
                    {
                    match(input,87,FOLLOW_87_in_statement3292); if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:662:18: ( Identifier )?
                    int alt114=2;
                    int LA114_0 = input.LA(1);

                    if ( (LA114_0==Identifier) ) {
                        alt114=1;
                    }
                    switch (alt114) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: Identifier
                            {
                            match(input,Identifier,FOLLOW_Identifier_in_statement3294); if (failed) return r;

                            }
                            break;

                    }

                    match(input,26,FOLLOW_26_in_statement3297); if (failed) return r;

                    }
                    break;
                case 14 :
                    // src/com/epijava/grammar/EpiJava.g:663:7: ';'
                    {
                    match(input,26,FOLLOW_26_in_statement3305); if (failed) return r;

                    }
                    break;
                case 15 :
                    // src/com/epijava/grammar/EpiJava.g:664:7: r_= statementExpression ';'
                    {
                    pushFollow(FOLLOW_statementExpression_in_statement3315);
                    r_=statementExpression();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r = r_; 
                    }
                    match(input,26,FOLLOW_26_in_statement3319); if (failed) return r;

                    }
                    break;
                case 16 :
                    // src/com/epijava/grammar/EpiJava.g:665:7: Identifier ':' statement
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_statement3327); if (failed) return r;
                    match(input,75,FOLLOW_75_in_statement3329); if (failed) return r;
                    pushFollow(FOLLOW_statement_in_statement3331);
                    statement();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 87, statement_StartIndex); }
        }
        return r;
    }
    // $ANTLR end statement


    // $ANTLR start catches
    // src/com/epijava/grammar/EpiJava.g:668:1: catches : catchClause ( catchClause )* ;
    public final void catches() throws RecognitionException {
        int catches_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 88) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:669:2: ( catchClause ( catchClause )* )
            // src/com/epijava/grammar/EpiJava.g:669:4: catchClause ( catchClause )*
            {
            pushFollow(FOLLOW_catchClause_in_catches3343);
            catchClause();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:669:16: ( catchClause )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==88) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:669:17: catchClause
            	    {
            	    pushFollow(FOLLOW_catchClause_in_catches3346);
            	    catchClause();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop116;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 88, catches_StartIndex); }
        }
        return ;
    }
    // $ANTLR end catches


    // $ANTLR start catchClause
    // src/com/epijava/grammar/EpiJava.g:672:1: catchClause : 'catch' '(' formalParameter ')' block ;
    public final void catchClause() throws RecognitionException {
        int catchClause_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 89) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:673:2: ( 'catch' '(' formalParameter ')' block )
            // src/com/epijava/grammar/EpiJava.g:673:4: 'catch' '(' formalParameter ')' block
            {
            match(input,88,FOLLOW_88_in_catchClause3360); if (failed) return ;
            match(input,66,FOLLOW_66_in_catchClause3362); if (failed) return ;
            pushFollow(FOLLOW_formalParameter_in_catchClause3364);
            formalParameter();
            _fsp--;
            if (failed) return ;
            match(input,67,FOLLOW_67_in_catchClause3366); if (failed) return ;
            pushFollow(FOLLOW_block_in_catchClause3368);
            block();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 89, catchClause_StartIndex); }
        }
        return ;
    }
    // $ANTLR end catchClause


    // $ANTLR start formalParameter
    // src/com/epijava/grammar/EpiJava.g:676:1: formalParameter : ( variableModifier )* type variableDeclaratorId ;
    public final void formalParameter() throws RecognitionException {
        int formalParameter_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 90) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:677:2: ( ( variableModifier )* type variableDeclaratorId )
            // src/com/epijava/grammar/EpiJava.g:677:4: ( variableModifier )* type variableDeclaratorId
            {
            // src/com/epijava/grammar/EpiJava.g:677:4: ( variableModifier )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==50||LA117_0==72) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:0:0: variableModifier
            	    {
            	    pushFollow(FOLLOW_variableModifier_in_formalParameter3379);
            	    variableModifier();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop117;
                }
            } while (true);

            pushFollow(FOLLOW_type_in_formalParameter3382);
            type();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_variableDeclaratorId_in_formalParameter3384);
            variableDeclaratorId();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 90, formalParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end formalParameter


    // $ANTLR start switchBlockStatementGroups
    // src/com/epijava/grammar/EpiJava.g:680:1: switchBlockStatementGroups : ( switchBlockStatementGroup )* ;
    public final void switchBlockStatementGroups() throws RecognitionException {
        int switchBlockStatementGroups_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 91) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:681:2: ( ( switchBlockStatementGroup )* )
            // src/com/epijava/grammar/EpiJava.g:681:4: ( switchBlockStatementGroup )*
            {
            // src/com/epijava/grammar/EpiJava.g:681:4: ( switchBlockStatementGroup )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==73||LA118_0==89) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:681:5: switchBlockStatementGroup
            	    {
            	    pushFollow(FOLLOW_switchBlockStatementGroup_in_switchBlockStatementGroups3398);
            	    switchBlockStatementGroup();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop118;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 91, switchBlockStatementGroups_StartIndex); }
        }
        return ;
    }
    // $ANTLR end switchBlockStatementGroups


    // $ANTLR start switchBlockStatementGroup
    // src/com/epijava/grammar/EpiJava.g:684:1: switchBlockStatementGroup : switchLabel ( blockStatement )* ;
    public final void switchBlockStatementGroup() throws RecognitionException {
        int switchBlockStatementGroup_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 92) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:685:2: ( switchLabel ( blockStatement )* )
            // src/com/epijava/grammar/EpiJava.g:685:4: switchLabel ( blockStatement )*
            {
            pushFollow(FOLLOW_switchLabel_in_switchBlockStatementGroup3412);
            switchLabel();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:685:16: ( blockStatement )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( ((LA119_0>=Identifier && LA119_0<=DecimalLiteral)||LA119_0==26||LA119_0==28||LA119_0==31||LA119_0==34||LA119_0==38||(LA119_0>=40 && LA119_0<=41)||(LA119_0>=46 && LA119_0<=63)||(LA119_0>=65 && LA119_0<=66)||(LA119_0>=69 && LA119_0<=72)||LA119_0==74||LA119_0==76||(LA119_0>=78 && LA119_0<=81)||(LA119_0>=83 && LA119_0<=87)||(LA119_0>=105 && LA119_0<=106)||(LA119_0>=109 && LA119_0<=114)) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:0:0: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_switchBlockStatementGroup3414);
            	    blockStatement();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop119;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 92, switchBlockStatementGroup_StartIndex); }
        }
        return ;
    }
    // $ANTLR end switchBlockStatementGroup


    // $ANTLR start switchLabel
    // src/com/epijava/grammar/EpiJava.g:688:1: switchLabel : ( 'case' constantExpression ':' | 'case' enumConstantName ':' | 'default' ':' );
    public final void switchLabel() throws RecognitionException {
        int switchLabel_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 93) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:689:2: ( 'case' constantExpression ':' | 'case' enumConstantName ':' | 'default' ':' )
            int alt120=3;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==89) ) {
                int LA120_1 = input.LA(2);

                if ( (LA120_1==Identifier) ) {
                    int LA120_3 = input.LA(3);

                    if ( (synpred172()) ) {
                        alt120=1;
                    }
                    else if ( (synpred173()) ) {
                        alt120=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("688:1: switchLabel : ( 'case' constantExpression ':' | 'case' enumConstantName ':' | 'default' ':' );", 120, 3, input);

                        throw nvae;
                    }
                }
                else if ( ((LA120_1>=FloatingPointLiteral && LA120_1<=DecimalLiteral)||LA120_1==34||LA120_1==41||(LA120_1>=56 && LA120_1<=63)||(LA120_1>=65 && LA120_1<=66)||(LA120_1>=69 && LA120_1<=71)||(LA120_1>=105 && LA120_1<=106)||(LA120_1>=109 && LA120_1<=114)) ) {
                    alt120=1;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("688:1: switchLabel : ( 'case' constantExpression ':' | 'case' enumConstantName ':' | 'default' ':' );", 120, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA120_0==73) ) {
                alt120=3;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("688:1: switchLabel : ( 'case' constantExpression ':' | 'case' enumConstantName ':' | 'default' ':' );", 120, 0, input);

                throw nvae;
            }
            switch (alt120) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:689:4: 'case' constantExpression ':'
                    {
                    match(input,89,FOLLOW_89_in_switchLabel3427); if (failed) return ;
                    pushFollow(FOLLOW_constantExpression_in_switchLabel3429);
                    constantExpression();
                    _fsp--;
                    if (failed) return ;
                    match(input,75,FOLLOW_75_in_switchLabel3431); if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:690:6: 'case' enumConstantName ':'
                    {
                    match(input,89,FOLLOW_89_in_switchLabel3438); if (failed) return ;
                    pushFollow(FOLLOW_enumConstantName_in_switchLabel3440);
                    enumConstantName();
                    _fsp--;
                    if (failed) return ;
                    match(input,75,FOLLOW_75_in_switchLabel3442); if (failed) return ;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:691:6: 'default' ':'
                    {
                    match(input,73,FOLLOW_73_in_switchLabel3449); if (failed) return ;
                    match(input,75,FOLLOW_75_in_switchLabel3451); if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 93, switchLabel_StartIndex); }
        }
        return ;
    }
    // $ANTLR end switchLabel


    // $ANTLR start moreStatementExpressions
    // src/com/epijava/grammar/EpiJava.g:694:1: moreStatementExpressions : ( ',' statementExpression )* ;
    public final void moreStatementExpressions() throws RecognitionException {
        int moreStatementExpressions_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 94) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:695:2: ( ( ',' statementExpression )* )
            // src/com/epijava/grammar/EpiJava.g:695:4: ( ',' statementExpression )*
            {
            // src/com/epijava/grammar/EpiJava.g:695:4: ( ',' statementExpression )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==35) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:695:5: ',' statementExpression
            	    {
            	    match(input,35,FOLLOW_35_in_moreStatementExpressions3464); if (failed) return ;
            	    pushFollow(FOLLOW_statementExpression_in_moreStatementExpressions3466);
            	    statementExpression();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop121;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 94, moreStatementExpressions_StartIndex); }
        }
        return ;
    }
    // $ANTLR end moreStatementExpressions


    // $ANTLR start forControl
    // src/com/epijava/grammar/EpiJava.g:698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );
    public final void forControl() throws RecognitionException {
        int forControl_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 95) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:700:2: ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? )
            int alt125=2;
            switch ( input.LA(1) ) {
            case 50:
                {
                switch ( input.LA(2) ) {
                case Identifier:
                    {
                    switch ( input.LA(3) ) {
                    case 34:
                        {
                        int LA125_98 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 98, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 29:
                        {
                        int LA125_99 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 99, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 42:
                        {
                        int LA125_100 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 100, input);

                            throw nvae;
                        }
                        }
                        break;
                    case Identifier:
                        {
                        int LA125_101 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 101, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 34, input);

                        throw nvae;
                    }

                    }
                    break;
                case 56:
                    {
                    int LA125_35 = input.LA(3);

                    if ( (LA125_35==42) ) {
                        int LA125_102 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 102, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_35==Identifier) ) {
                        int LA125_103 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 103, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 35, input);

                        throw nvae;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA125_36 = input.LA(3);

                    if ( (LA125_36==42) ) {
                        int LA125_104 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 104, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_36==Identifier) ) {
                        int LA125_105 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 105, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 36, input);

                        throw nvae;
                    }
                    }
                    break;
                case 58:
                    {
                    int LA125_37 = input.LA(3);

                    if ( (LA125_37==42) ) {
                        int LA125_106 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 106, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_37==Identifier) ) {
                        int LA125_107 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 107, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 37, input);

                        throw nvae;
                    }
                    }
                    break;
                case 59:
                    {
                    int LA125_38 = input.LA(3);

                    if ( (LA125_38==42) ) {
                        int LA125_108 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 108, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_38==Identifier) ) {
                        int LA125_109 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 109, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 38, input);

                        throw nvae;
                    }
                    }
                    break;
                case 60:
                    {
                    int LA125_39 = input.LA(3);

                    if ( (LA125_39==42) ) {
                        int LA125_110 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 110, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_39==Identifier) ) {
                        int LA125_111 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 111, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 39, input);

                        throw nvae;
                    }
                    }
                    break;
                case 61:
                    {
                    int LA125_40 = input.LA(3);

                    if ( (LA125_40==42) ) {
                        int LA125_112 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 112, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_40==Identifier) ) {
                        int LA125_113 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 113, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 40, input);

                        throw nvae;
                    }
                    }
                    break;
                case 62:
                    {
                    int LA125_41 = input.LA(3);

                    if ( (LA125_41==42) ) {
                        int LA125_114 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 114, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_41==Identifier) ) {
                        int LA125_115 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 115, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 41, input);

                        throw nvae;
                    }
                    }
                    break;
                case 63:
                    {
                    int LA125_42 = input.LA(3);

                    if ( (LA125_42==42) ) {
                        int LA125_116 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 116, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_42==Identifier) ) {
                        int LA125_117 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 117, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 42, input);

                        throw nvae;
                    }
                    }
                    break;
                case 50:
                    {
                    switch ( input.LA(3) ) {
                    case Identifier:
                        {
                        int LA125_118 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 118, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 56:
                        {
                        int LA125_119 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 119, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 57:
                        {
                        int LA125_120 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 120, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 58:
                        {
                        int LA125_121 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 121, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 59:
                        {
                        int LA125_122 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 122, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 60:
                        {
                        int LA125_123 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 123, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 61:
                        {
                        int LA125_124 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 124, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 62:
                        {
                        int LA125_125 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 125, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 63:
                        {
                        int LA125_126 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 126, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 50:
                        {
                        int LA125_127 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 127, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 72:
                        {
                        int LA125_128 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 128, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 43, input);

                        throw nvae;
                    }

                    }
                    break;
                case 72:
                    {
                    int LA125_44 = input.LA(3);

                    if ( (LA125_44==Identifier) ) {
                        int LA125_129 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 129, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 44, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 1, input);

                    throw nvae;
                }

                }
                break;
            case 72:
                {
                int LA125_2 = input.LA(2);

                if ( (LA125_2==Identifier) ) {
                    switch ( input.LA(3) ) {
                    case 29:
                        {
                        int LA125_130 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 130, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 66:
                        {
                        int LA125_131 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 131, input);

                            throw nvae;
                        }
                        }
                        break;
                    case Identifier:
                        {
                        int LA125_132 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 132, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 56:
                        {
                        int LA125_133 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 133, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 57:
                        {
                        int LA125_134 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 134, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 58:
                        {
                        int LA125_135 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 135, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 59:
                        {
                        int LA125_136 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 136, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 60:
                        {
                        int LA125_137 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 137, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 61:
                        {
                        int LA125_138 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 138, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 62:
                        {
                        int LA125_139 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 139, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 63:
                        {
                        int LA125_140 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 140, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 50:
                        {
                        int LA125_141 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 141, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 72:
                        {
                        int LA125_142 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 142, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 45, input);

                        throw nvae;
                    }

                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 2, input);

                    throw nvae;
                }
                }
                break;
            case Identifier:
                {
                switch ( input.LA(2) ) {
                case 34:
                    {
                    switch ( input.LA(3) ) {
                    case FloatingPointLiteral:
                    case CharacterLiteral:
                    case StringLiteral:
                    case HexLiteral:
                    case OctalLiteral:
                    case DecimalLiteral:
                    case 34:
                    case 41:
                    case 45:
                    case 65:
                    case 66:
                    case 69:
                    case 70:
                    case 71:
                    case 105:
                    case 106:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                        {
                        alt125=2;
                        }
                        break;
                    case Identifier:
                        {
                        int LA125_145 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 145, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 56:
                        {
                        int LA125_146 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 146, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 57:
                        {
                        int LA125_147 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 147, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 58:
                        {
                        int LA125_148 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 148, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 59:
                        {
                        int LA125_149 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 149, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 60:
                        {
                        int LA125_150 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 150, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 61:
                        {
                        int LA125_151 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 151, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 62:
                        {
                        int LA125_152 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 152, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 63:
                        {
                        int LA125_153 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 153, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 64:
                        {
                        int LA125_154 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 154, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 46, input);

                        throw nvae;
                    }

                    }
                    break;
                case 29:
                    {
                    int LA125_47 = input.LA(3);

                    if ( (LA125_47==Identifier) ) {
                        int LA125_175 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 175, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_47==31||LA125_47==34||LA125_47==65||(LA125_47>=113 && LA125_47<=114)) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 47, input);

                        throw nvae;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA125_48 = input.LA(3);

                    if ( (LA125_48==43) ) {
                        int LA125_181 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 181, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA125_48==Identifier||(LA125_48>=FloatingPointLiteral && LA125_48<=DecimalLiteral)||LA125_48==34||LA125_48==41||(LA125_48>=56 && LA125_48<=63)||(LA125_48>=65 && LA125_48<=66)||(LA125_48>=69 && LA125_48<=71)||(LA125_48>=105 && LA125_48<=106)||(LA125_48>=109 && LA125_48<=114)) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 48, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    int LA125_49 = input.LA(3);

                    if ( (LA125_49==75) ) {
                        alt125=1;
                    }
                    else if ( (LA125_49==26||LA125_49==35||LA125_49==42||LA125_49==45) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 49, input);

                        throw nvae;
                    }
                    }
                    break;
                case 26:
                case 30:
                case 35:
                case 36:
                case 37:
                case 45:
                case 64:
                case 66:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                    {
                    alt125=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 3, input);

                    throw nvae;
                }

                }
                break;
            case 56:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA125_74 = input.LA(3);

                    if ( (LA125_74==43) ) {
                        int LA125_217 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 217, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 74, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt125=2;
                    }
                    break;
                case Identifier:
                    {
                    int LA125_76 = input.LA(3);

                    if ( (LA125_76==75) ) {
                        alt125=1;
                    }
                    else if ( (LA125_76==26||LA125_76==35||LA125_76==42||LA125_76==45) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 76, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 4, input);

                    throw nvae;
                }

                }
                break;
            case 57:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA125_77 = input.LA(3);

                    if ( (LA125_77==43) ) {
                        int LA125_223 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 223, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 77, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    int LA125_78 = input.LA(3);

                    if ( (LA125_78==75) ) {
                        alt125=1;
                    }
                    else if ( (LA125_78==26||LA125_78==35||LA125_78==42||LA125_78==45) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 78, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt125=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 5, input);

                    throw nvae;
                }

                }
                break;
            case 58:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA125_80 = input.LA(3);

                    if ( (LA125_80==43) ) {
                        int LA125_229 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 229, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 80, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    int LA125_81 = input.LA(3);

                    if ( (LA125_81==75) ) {
                        alt125=1;
                    }
                    else if ( (LA125_81==26||LA125_81==35||LA125_81==42||LA125_81==45) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 81, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt125=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 6, input);

                    throw nvae;
                }

                }
                break;
            case 59:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA125_83 = input.LA(3);

                    if ( (LA125_83==43) ) {
                        int LA125_235 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 235, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 83, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt125=2;
                    }
                    break;
                case Identifier:
                    {
                    int LA125_85 = input.LA(3);

                    if ( (LA125_85==75) ) {
                        alt125=1;
                    }
                    else if ( (LA125_85==26||LA125_85==35||LA125_85==42||LA125_85==45) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 85, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 7, input);

                    throw nvae;
                }

                }
                break;
            case 60:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA125_86 = input.LA(3);

                    if ( (LA125_86==43) ) {
                        int LA125_241 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 241, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 86, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    int LA125_87 = input.LA(3);

                    if ( (LA125_87==75) ) {
                        alt125=1;
                    }
                    else if ( (LA125_87==26||LA125_87==35||LA125_87==42||LA125_87==45) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 87, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt125=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 8, input);

                    throw nvae;
                }

                }
                break;
            case 61:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA125_89 = input.LA(3);

                    if ( (LA125_89==43) ) {
                        int LA125_247 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 247, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 89, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    int LA125_90 = input.LA(3);

                    if ( (LA125_90==75) ) {
                        alt125=1;
                    }
                    else if ( (LA125_90==26||LA125_90==35||LA125_90==42||LA125_90==45) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 90, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt125=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 9, input);

                    throw nvae;
                }

                }
                break;
            case 62:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA125_92 = input.LA(3);

                    if ( (LA125_92==43) ) {
                        int LA125_253 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 253, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 92, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt125=2;
                    }
                    break;
                case Identifier:
                    {
                    int LA125_94 = input.LA(3);

                    if ( (LA125_94==75) ) {
                        alt125=1;
                    }
                    else if ( (LA125_94==26||LA125_94==35||LA125_94==42||LA125_94==45) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 94, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 10, input);

                    throw nvae;
                }

                }
                break;
            case 63:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA125_95 = input.LA(3);

                    if ( (LA125_95==43) ) {
                        int LA125_259 = input.LA(4);

                        if ( (synpred175()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 259, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 95, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    int LA125_96 = input.LA(3);

                    if ( (LA125_96==75) ) {
                        alt125=1;
                    }
                    else if ( (LA125_96==26||LA125_96==35||LA125_96==42||LA125_96==45) ) {
                        alt125=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 96, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt125=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 11, input);

                    throw nvae;
                }

                }
                break;
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 26:
            case 34:
            case 41:
            case 65:
            case 66:
            case 69:
            case 70:
            case 71:
            case 105:
            case 106:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                {
                alt125=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("698:1: forControl options {k=3; } : ( forVarControl | ( forInit )? ';' ( expression )? ';' ( forUpdate )? );", 125, 0, input);

                throw nvae;
            }

            switch (alt125) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:700:4: forVarControl
                    {
                    pushFollow(FOLLOW_forVarControl_in_forControl3487);
                    forVarControl();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:701:4: ( forInit )? ';' ( expression )? ';' ( forUpdate )?
                    {
                    // src/com/epijava/grammar/EpiJava.g:701:4: ( forInit )?
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==Identifier||(LA122_0>=FloatingPointLiteral && LA122_0<=DecimalLiteral)||LA122_0==34||LA122_0==41||LA122_0==50||(LA122_0>=56 && LA122_0<=63)||(LA122_0>=65 && LA122_0<=66)||(LA122_0>=69 && LA122_0<=72)||(LA122_0>=105 && LA122_0<=106)||(LA122_0>=109 && LA122_0<=114)) ) {
                        alt122=1;
                    }
                    switch (alt122) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: forInit
                            {
                            pushFollow(FOLLOW_forInit_in_forControl3492);
                            forInit();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }

                    match(input,26,FOLLOW_26_in_forControl3495); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:701:17: ( expression )?
                    int alt123=2;
                    int LA123_0 = input.LA(1);

                    if ( (LA123_0==Identifier||(LA123_0>=FloatingPointLiteral && LA123_0<=DecimalLiteral)||LA123_0==34||LA123_0==41||(LA123_0>=56 && LA123_0<=63)||(LA123_0>=65 && LA123_0<=66)||(LA123_0>=69 && LA123_0<=71)||(LA123_0>=105 && LA123_0<=106)||(LA123_0>=109 && LA123_0<=114)) ) {
                        alt123=1;
                    }
                    switch (alt123) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_forControl3497);
                            expression();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }

                    match(input,26,FOLLOW_26_in_forControl3500); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:701:33: ( forUpdate )?
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==Identifier||(LA124_0>=FloatingPointLiteral && LA124_0<=DecimalLiteral)||LA124_0==34||LA124_0==41||(LA124_0>=56 && LA124_0<=63)||(LA124_0>=65 && LA124_0<=66)||(LA124_0>=69 && LA124_0<=71)||(LA124_0>=105 && LA124_0<=106)||(LA124_0>=109 && LA124_0<=114)) ) {
                        alt124=1;
                    }
                    switch (alt124) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: forUpdate
                            {
                            pushFollow(FOLLOW_forUpdate_in_forControl3502);
                            forUpdate();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 95, forControl_StartIndex); }
        }
        return ;
    }
    // $ANTLR end forControl


    // $ANTLR start forInit
    // src/com/epijava/grammar/EpiJava.g:704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );
    public final void forInit() throws RecognitionException {
        int forInit_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 96) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:705:2: ( ( variableModifier )* type variableDeclarators | expressionList )
            int alt127=2;
            switch ( input.LA(1) ) {
            case 50:
            case 72:
                {
                alt127=1;
                }
                break;
            case Identifier:
                {
                switch ( input.LA(2) ) {
                case 34:
                    {
                    int LA127_33 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 33, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    int LA127_34 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 34, input);

                        throw nvae;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA127_35 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 35, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt127=1;
                    }
                    break;
                case EOF:
                case 26:
                case 30:
                case 35:
                case 36:
                case 37:
                case 45:
                case 64:
                case 66:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                    {
                    alt127=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 3, input);

                    throw nvae;
                }

                }
                break;
            case 56:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA127_62 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 62, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt127=1;
                    }
                    break;
                case 29:
                    {
                    alt127=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 4, input);

                    throw nvae;
                }

                }
                break;
            case 57:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA127_65 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 65, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt127=2;
                    }
                    break;
                case Identifier:
                    {
                    alt127=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 5, input);

                    throw nvae;
                }

                }
                break;
            case 58:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA127_68 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 68, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt127=1;
                    }
                    break;
                case 29:
                    {
                    alt127=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 6, input);

                    throw nvae;
                }

                }
                break;
            case 59:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA127_71 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 71, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt127=1;
                    }
                    break;
                case 29:
                    {
                    alt127=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 7, input);

                    throw nvae;
                }

                }
                break;
            case 60:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA127_74 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 74, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt127=2;
                    }
                    break;
                case Identifier:
                    {
                    alt127=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 8, input);

                    throw nvae;
                }

                }
                break;
            case 61:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA127_77 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 77, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt127=2;
                    }
                    break;
                case Identifier:
                    {
                    alt127=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 9, input);

                    throw nvae;
                }

                }
                break;
            case 62:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA127_80 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 80, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt127=2;
                    }
                    break;
                case Identifier:
                    {
                    alt127=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 10, input);

                    throw nvae;
                }

                }
                break;
            case 63:
                {
                switch ( input.LA(2) ) {
                case 42:
                    {
                    int LA127_83 = input.LA(3);

                    if ( (synpred180()) ) {
                        alt127=1;
                    }
                    else if ( (true) ) {
                        alt127=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 83, input);

                        throw nvae;
                    }
                    }
                    break;
                case 29:
                    {
                    alt127=2;
                    }
                    break;
                case Identifier:
                    {
                    alt127=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 11, input);

                    throw nvae;
                }

                }
                break;
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 34:
            case 41:
            case 65:
            case 66:
            case 69:
            case 70:
            case 71:
            case 105:
            case 106:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                {
                alt127=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("704:1: forInit : ( ( variableModifier )* type variableDeclarators | expressionList );", 127, 0, input);

                throw nvae;
            }

            switch (alt127) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:705:4: ( variableModifier )* type variableDeclarators
                    {
                    // src/com/epijava/grammar/EpiJava.g:705:4: ( variableModifier )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==50||LA126_0==72) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:0:0: variableModifier
                    	    {
                    	    pushFollow(FOLLOW_variableModifier_in_forInit3514);
                    	    variableModifier();
                    	    _fsp--;
                    	    if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop126;
                        }
                    } while (true);

                    pushFollow(FOLLOW_type_in_forInit3517);
                    type();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_variableDeclarators_in_forInit3519);
                    variableDeclarators();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:706:4: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_forInit3524);
                    expressionList();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 96, forInit_StartIndex); }
        }
        return ;
    }
    // $ANTLR end forInit


    // $ANTLR start forVarControl
    // src/com/epijava/grammar/EpiJava.g:709:1: forVarControl : ( variableModifier )* type Identifier ':' expression ;
    public final void forVarControl() throws RecognitionException {
        int forVarControl_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 97) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:710:2: ( ( variableModifier )* type Identifier ':' expression )
            // src/com/epijava/grammar/EpiJava.g:710:4: ( variableModifier )* type Identifier ':' expression
            {
            // src/com/epijava/grammar/EpiJava.g:710:4: ( variableModifier )*
            loop128:
            do {
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==50||LA128_0==72) ) {
                    alt128=1;
                }


                switch (alt128) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:0:0: variableModifier
            	    {
            	    pushFollow(FOLLOW_variableModifier_in_forVarControl3536);
            	    variableModifier();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop128;
                }
            } while (true);

            pushFollow(FOLLOW_type_in_forVarControl3539);
            type();
            _fsp--;
            if (failed) return ;
            match(input,Identifier,FOLLOW_Identifier_in_forVarControl3541); if (failed) return ;
            match(input,75,FOLLOW_75_in_forVarControl3543); if (failed) return ;
            pushFollow(FOLLOW_expression_in_forVarControl3545);
            expression();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 97, forVarControl_StartIndex); }
        }
        return ;
    }
    // $ANTLR end forVarControl


    // $ANTLR start forUpdate
    // src/com/epijava/grammar/EpiJava.g:713:1: forUpdate : expressionList ;
    public final void forUpdate() throws RecognitionException {
        int forUpdate_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 98) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:714:2: ( expressionList )
            // src/com/epijava/grammar/EpiJava.g:714:4: expressionList
            {
            pushFollow(FOLLOW_expressionList_in_forUpdate3556);
            expressionList();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 98, forUpdate_StartIndex); }
        }
        return ;
    }
    // $ANTLR end forUpdate


    // $ANTLR start parExpression
    // src/com/epijava/grammar/EpiJava.g:719:1: parExpression returns [Expression r] : '(' r_= expression ')' ;
    public final Expression parExpression() throws RecognitionException {
        Expression r = null;
        int parExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 99) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:720:2: ( '(' r_= expression ')' )
            // src/com/epijava/grammar/EpiJava.g:720:4: '(' r_= expression ')'
            {
            match(input,66,FOLLOW_66_in_parExpression3573); if (failed) return r;
            pushFollow(FOLLOW_expression_in_parExpression3577);
            r_=expression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r=r_;
            }
            match(input,67,FOLLOW_67_in_parExpression3581); if (failed) return r;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 99, parExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end parExpression


    // $ANTLR start expressionList
    // src/com/epijava/grammar/EpiJava.g:723:1: expressionList returns [List<Expression> r] : expr= expression ( ',' expr= expression )* ;
    public final List<Expression> expressionList() throws RecognitionException {
        List<Expression> r = null;
        int expressionList_StartIndex = input.index();
        Expression expr = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 100) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:725:5: (expr= expression ( ',' expr= expression )* )
            // src/com/epijava/grammar/EpiJava.g:725:9: expr= expression ( ',' expr= expression )*
            {
            pushFollow(FOLLOW_expression_in_expressionList3608);
            expr=expression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r.add(expr);
            }
            // src/com/epijava/grammar/EpiJava.g:725:40: ( ',' expr= expression )*
            loop129:
            do {
                int alt129=2;
                int LA129_0 = input.LA(1);

                if ( (LA129_0==35) ) {
                    alt129=1;
                }


                switch (alt129) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:725:41: ',' expr= expression
            	    {
            	    match(input,35,FOLLOW_35_in_expressionList3613); if (failed) return r;
            	    pushFollow(FOLLOW_expression_in_expressionList3617);
            	    expr=expression();
            	    _fsp--;
            	    if (failed) return r;
            	    if ( backtracking==0 ) {
            	      r.add(expr);
            	    }

            	    }
            	    break;

            	default :
            	    break loop129;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 100, expressionList_StartIndex); }
        }
        return r;
    }
    // $ANTLR end expressionList


    // $ANTLR start statementExpression
    // src/com/epijava/grammar/EpiJava.g:728:1: statementExpression returns [Expression r] : r_= expression ;
    public final Expression statementExpression() throws RecognitionException {
        Expression r = null;
        int statementExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 101) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:729:2: (r_= expression )
            // src/com/epijava/grammar/EpiJava.g:729:4: r_= expression
            {
            pushFollow(FOLLOW_expression_in_statementExpression3641);
            r_=expression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 101, statementExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end statementExpression


    // $ANTLR start constantExpression
    // src/com/epijava/grammar/EpiJava.g:732:1: constantExpression returns [Expression r] : r_= expression ;
    public final Expression constantExpression() throws RecognitionException {
        Expression r = null;
        int constantExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 102) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:733:2: (r_= expression )
            // src/com/epijava/grammar/EpiJava.g:733:4: r_= expression
            {
            pushFollow(FOLLOW_expression_in_constantExpression3661);
            r_=expression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 102, constantExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end constantExpression


    // $ANTLR start expression
    // src/com/epijava/grammar/EpiJava.g:736:1: expression returns [Expression r] : r_= conditionalExpression ( assignmentOperator expression )? ;
    public final Expression expression() throws RecognitionException {
        Expression r = null;
        int expression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 103) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:737:2: (r_= conditionalExpression ( assignmentOperator expression )? )
            // src/com/epijava/grammar/EpiJava.g:737:4: r_= conditionalExpression ( assignmentOperator expression )?
            {
            pushFollow(FOLLOW_conditionalExpression_in_expression3681);
            r_=conditionalExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r=r_;
            }
            // src/com/epijava/grammar/EpiJava.g:737:37: ( assignmentOperator expression )?
            int alt130=2;
            switch ( input.LA(1) ) {
                case 45:
                    {
                    int LA130_1 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 90:
                    {
                    int LA130_2 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 91:
                    {
                    int LA130_3 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 92:
                    {
                    int LA130_4 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 93:
                    {
                    int LA130_5 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 94:
                    {
                    int LA130_6 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 95:
                    {
                    int LA130_7 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 96:
                    {
                    int LA130_8 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 97:
                    {
                    int LA130_9 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 34:
                    {
                    int LA130_10 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
                case 36:
                    {
                    int LA130_11 = input.LA(2);

                    if ( (synpred183()) ) {
                        alt130=1;
                    }
                    }
                    break;
            }

            switch (alt130) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:737:38: assignmentOperator expression
                    {
                    pushFollow(FOLLOW_assignmentOperator_in_expression3686);
                    assignmentOperator();
                    _fsp--;
                    if (failed) return r;
                    pushFollow(FOLLOW_expression_in_expression3688);
                    expression();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 103, expression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end expression


    // $ANTLR start assignmentOperator
    // src/com/epijava/grammar/EpiJava.g:740:1: assignmentOperator : ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '=' | '>' '>' '>' '=' );
    public final void assignmentOperator() throws RecognitionException {
        int assignmentOperator_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 104) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:741:2: ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '=' | '>' '>' '>' '=' )
            int alt131=12;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt131=1;
                }
                break;
            case 90:
                {
                alt131=2;
                }
                break;
            case 91:
                {
                alt131=3;
                }
                break;
            case 92:
                {
                alt131=4;
                }
                break;
            case 93:
                {
                alt131=5;
                }
                break;
            case 94:
                {
                alt131=6;
                }
                break;
            case 95:
                {
                alt131=7;
                }
                break;
            case 96:
                {
                alt131=8;
                }
                break;
            case 97:
                {
                alt131=9;
                }
                break;
            case 34:
                {
                alt131=10;
                }
                break;
            case 36:
                {
                int LA131_11 = input.LA(2);

                if ( (LA131_11==36) ) {
                    int LA131_12 = input.LA(3);

                    if ( (synpred194()) ) {
                        alt131=11;
                    }
                    else if ( (true) ) {
                        alt131=12;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("740:1: assignmentOperator : ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '=' | '>' '>' '>' '=' );", 131, 12, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("740:1: assignmentOperator : ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '=' | '>' '>' '>' '=' );", 131, 11, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("740:1: assignmentOperator : ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '=' | '>' '>' '>' '=' );", 131, 0, input);

                throw nvae;
            }

            switch (alt131) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:741:4: '='
                    {
                    match(input,45,FOLLOW_45_in_assignmentOperator3702); if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:742:9: '+='
                    {
                    match(input,90,FOLLOW_90_in_assignmentOperator3712); if (failed) return ;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:743:9: '-='
                    {
                    match(input,91,FOLLOW_91_in_assignmentOperator3722); if (failed) return ;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:744:9: '*='
                    {
                    match(input,92,FOLLOW_92_in_assignmentOperator3732); if (failed) return ;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:745:9: '/='
                    {
                    match(input,93,FOLLOW_93_in_assignmentOperator3742); if (failed) return ;

                    }
                    break;
                case 6 :
                    // src/com/epijava/grammar/EpiJava.g:746:9: '&='
                    {
                    match(input,94,FOLLOW_94_in_assignmentOperator3752); if (failed) return ;

                    }
                    break;
                case 7 :
                    // src/com/epijava/grammar/EpiJava.g:747:9: '|='
                    {
                    match(input,95,FOLLOW_95_in_assignmentOperator3762); if (failed) return ;

                    }
                    break;
                case 8 :
                    // src/com/epijava/grammar/EpiJava.g:748:9: '^='
                    {
                    match(input,96,FOLLOW_96_in_assignmentOperator3772); if (failed) return ;

                    }
                    break;
                case 9 :
                    // src/com/epijava/grammar/EpiJava.g:749:9: '%='
                    {
                    match(input,97,FOLLOW_97_in_assignmentOperator3782); if (failed) return ;

                    }
                    break;
                case 10 :
                    // src/com/epijava/grammar/EpiJava.g:750:9: '<' '<' '='
                    {
                    match(input,34,FOLLOW_34_in_assignmentOperator3792); if (failed) return ;
                    match(input,34,FOLLOW_34_in_assignmentOperator3794); if (failed) return ;
                    match(input,45,FOLLOW_45_in_assignmentOperator3796); if (failed) return ;

                    }
                    break;
                case 11 :
                    // src/com/epijava/grammar/EpiJava.g:751:9: '>' '>' '='
                    {
                    match(input,36,FOLLOW_36_in_assignmentOperator3806); if (failed) return ;
                    match(input,36,FOLLOW_36_in_assignmentOperator3808); if (failed) return ;
                    match(input,45,FOLLOW_45_in_assignmentOperator3810); if (failed) return ;

                    }
                    break;
                case 12 :
                    // src/com/epijava/grammar/EpiJava.g:752:9: '>' '>' '>' '='
                    {
                    match(input,36,FOLLOW_36_in_assignmentOperator3820); if (failed) return ;
                    match(input,36,FOLLOW_36_in_assignmentOperator3822); if (failed) return ;
                    match(input,36,FOLLOW_36_in_assignmentOperator3824); if (failed) return ;
                    match(input,45,FOLLOW_45_in_assignmentOperator3826); if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 104, assignmentOperator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end assignmentOperator


    // $ANTLR start conditionalExpression
    // src/com/epijava/grammar/EpiJava.g:755:1: conditionalExpression returns [Expression r] : r_= conditionalOrExpression ( '?' expression ':' expression )? ;
    public final Expression conditionalExpression() throws RecognitionException {
        Expression r = null;
        int conditionalExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 105) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:756:5: (r_= conditionalOrExpression ( '?' expression ':' expression )? )
            // src/com/epijava/grammar/EpiJava.g:756:9: r_= conditionalOrExpression ( '?' expression ':' expression )?
            {
            pushFollow(FOLLOW_conditionalOrExpression_in_conditionalExpression3848);
            r_=conditionalOrExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:756:46: ( '?' expression ':' expression )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==64) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:756:48: '?' expression ':' expression
                    {
                    match(input,64,FOLLOW_64_in_conditionalExpression3854); if (failed) return r;
                    pushFollow(FOLLOW_expression_in_conditionalExpression3856);
                    expression();
                    _fsp--;
                    if (failed) return r;
                    match(input,75,FOLLOW_75_in_conditionalExpression3858); if (failed) return r;
                    pushFollow(FOLLOW_expression_in_conditionalExpression3860);
                    expression();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 105, conditionalExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end conditionalExpression


    // $ANTLR start conditionalOrExpression
    // src/com/epijava/grammar/EpiJava.g:759:1: conditionalOrExpression returns [Expression r] : r_= conditionalAndExpression ( '||' conditionalAndExpression )* ;
    public final Expression conditionalOrExpression() throws RecognitionException {
        Expression r = null;
        int conditionalOrExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 106) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:760:5: (r_= conditionalAndExpression ( '||' conditionalAndExpression )* )
            // src/com/epijava/grammar/EpiJava.g:760:9: r_= conditionalAndExpression ( '||' conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression3885);
            r_=conditionalAndExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:760:47: ( '||' conditionalAndExpression )*
            loop133:
            do {
                int alt133=2;
                int LA133_0 = input.LA(1);

                if ( (LA133_0==98) ) {
                    alt133=1;
                }


                switch (alt133) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:760:49: '||' conditionalAndExpression
            	    {
            	    match(input,98,FOLLOW_98_in_conditionalOrExpression3891); if (failed) return r;
            	    pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression3893);
            	    conditionalAndExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop133;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 106, conditionalOrExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end conditionalOrExpression


    // $ANTLR start conditionalAndExpression
    // src/com/epijava/grammar/EpiJava.g:763:1: conditionalAndExpression returns [Expression r] : r_= inclusiveOrExpression ( '&&' inclusiveOrExpression )* ;
    public final Expression conditionalAndExpression() throws RecognitionException {
        Expression r = null;
        int conditionalAndExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 107) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:764:5: (r_= inclusiveOrExpression ( '&&' inclusiveOrExpression )* )
            // src/com/epijava/grammar/EpiJava.g:764:9: r_= inclusiveOrExpression ( '&&' inclusiveOrExpression )*
            {
            pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression3918);
            r_=inclusiveOrExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:764:44: ( '&&' inclusiveOrExpression )*
            loop134:
            do {
                int alt134=2;
                int LA134_0 = input.LA(1);

                if ( (LA134_0==99) ) {
                    alt134=1;
                }


                switch (alt134) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:764:46: '&&' inclusiveOrExpression
            	    {
            	    match(input,99,FOLLOW_99_in_conditionalAndExpression3924); if (failed) return r;
            	    pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression3926);
            	    inclusiveOrExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop134;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 107, conditionalAndExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end conditionalAndExpression


    // $ANTLR start inclusiveOrExpression
    // src/com/epijava/grammar/EpiJava.g:767:1: inclusiveOrExpression returns [Expression r] : r_= exclusiveOrExpression ( '|' exclusiveOrExpression )* ;
    public final Expression inclusiveOrExpression() throws RecognitionException {
        Expression r = null;
        int inclusiveOrExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 108) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:768:5: (r_= exclusiveOrExpression ( '|' exclusiveOrExpression )* )
            // src/com/epijava/grammar/EpiJava.g:768:9: r_= exclusiveOrExpression ( '|' exclusiveOrExpression )*
            {
            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression3951);
            r_=exclusiveOrExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:768:44: ( '|' exclusiveOrExpression )*
            loop135:
            do {
                int alt135=2;
                int LA135_0 = input.LA(1);

                if ( (LA135_0==100) ) {
                    alt135=1;
                }


                switch (alt135) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:768:46: '|' exclusiveOrExpression
            	    {
            	    match(input,100,FOLLOW_100_in_inclusiveOrExpression3957); if (failed) return r;
            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression3959);
            	    exclusiveOrExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop135;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 108, inclusiveOrExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end inclusiveOrExpression


    // $ANTLR start exclusiveOrExpression
    // src/com/epijava/grammar/EpiJava.g:771:1: exclusiveOrExpression returns [Expression r] : r_= andExpression ( '^' andExpression )* ;
    public final Expression exclusiveOrExpression() throws RecognitionException {
        Expression r = null;
        int exclusiveOrExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 109) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:772:5: (r_= andExpression ( '^' andExpression )* )
            // src/com/epijava/grammar/EpiJava.g:772:9: r_= andExpression ( '^' andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression3984);
            r_=andExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:772:36: ( '^' andExpression )*
            loop136:
            do {
                int alt136=2;
                int LA136_0 = input.LA(1);

                if ( (LA136_0==101) ) {
                    alt136=1;
                }


                switch (alt136) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:772:38: '^' andExpression
            	    {
            	    match(input,101,FOLLOW_101_in_exclusiveOrExpression3990); if (failed) return r;
            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression3992);
            	    andExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop136;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 109, exclusiveOrExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end exclusiveOrExpression


    // $ANTLR start andExpression
    // src/com/epijava/grammar/EpiJava.g:775:1: andExpression returns [Expression r] : r_= equalityExpression ( '&' equalityExpression )* ;
    public final Expression andExpression() throws RecognitionException {
        Expression r = null;
        int andExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 110) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:776:5: (r_= equalityExpression ( '&' equalityExpression )* )
            // src/com/epijava/grammar/EpiJava.g:776:9: r_= equalityExpression ( '&' equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_andExpression4017);
            r_=equalityExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:776:41: ( '&' equalityExpression )*
            loop137:
            do {
                int alt137=2;
                int LA137_0 = input.LA(1);

                if ( (LA137_0==37) ) {
                    alt137=1;
                }


                switch (alt137) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:776:43: '&' equalityExpression
            	    {
            	    match(input,37,FOLLOW_37_in_andExpression4023); if (failed) return r;
            	    pushFollow(FOLLOW_equalityExpression_in_andExpression4025);
            	    equalityExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop137;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 110, andExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end andExpression


    // $ANTLR start equalityExpression
    // src/com/epijava/grammar/EpiJava.g:779:1: equalityExpression returns [Expression r] : r_= instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )* ;
    public final Expression equalityExpression() throws RecognitionException {
        Expression r = null;
        int equalityExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 111) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:780:5: (r_= instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )* )
            // src/com/epijava/grammar/EpiJava.g:780:9: r_= instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )*
            {
            pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression4050);
            r_=instanceOfExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:780:43: ( ( '==' | '!=' ) instanceOfExpression )*
            loop138:
            do {
                int alt138=2;
                int LA138_0 = input.LA(1);

                if ( ((LA138_0>=102 && LA138_0<=103)) ) {
                    alt138=1;
                }


                switch (alt138) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:780:45: ( '==' | '!=' ) instanceOfExpression
            	    {
            	    if ( (input.LA(1)>=102 && input.LA(1)<=103) ) {
            	        input.consume();
            	        errorRecovery=false;failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return r;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_equalityExpression4056);    throw mse;
            	    }

            	    pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression4064);
            	    instanceOfExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop138;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 111, equalityExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end equalityExpression


    // $ANTLR start instanceOfExpression
    // src/com/epijava/grammar/EpiJava.g:783:1: instanceOfExpression returns [Expression r] : r_= relationalExpression ( 'instanceof' type )? ;
    public final Expression instanceOfExpression() throws RecognitionException {
        Expression r = null;
        int instanceOfExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 112) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:784:5: (r_= relationalExpression ( 'instanceof' type )? )
            // src/com/epijava/grammar/EpiJava.g:784:9: r_= relationalExpression ( 'instanceof' type )?
            {
            pushFollow(FOLLOW_relationalExpression_in_instanceOfExpression4089);
            r_=relationalExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:784:43: ( 'instanceof' type )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==104) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:784:44: 'instanceof' type
                    {
                    match(input,104,FOLLOW_104_in_instanceOfExpression4094); if (failed) return r;
                    pushFollow(FOLLOW_type_in_instanceOfExpression4096);
                    type();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 112, instanceOfExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end instanceOfExpression


    // $ANTLR start relationalExpression
    // src/com/epijava/grammar/EpiJava.g:787:1: relationalExpression returns [Expression r] : r_= shiftExpression ( relationalOp shiftExpression )* ;
    public final Expression relationalExpression() throws RecognitionException {
        Expression r = null;
        int relationalExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 113) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:788:5: (r_= shiftExpression ( relationalOp shiftExpression )* )
            // src/com/epijava/grammar/EpiJava.g:788:9: r_= shiftExpression ( relationalOp shiftExpression )*
            {
            pushFollow(FOLLOW_shiftExpression_in_relationalExpression4120);
            r_=shiftExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:788:38: ( relationalOp shiftExpression )*
            loop140:
            do {
                int alt140=2;
                int LA140_0 = input.LA(1);

                if ( (LA140_0==34) ) {
                    int LA140_23 = input.LA(2);

                    if ( (LA140_23==34) ) {
                        int LA140_27 = input.LA(3);

                        if ( (synpred204()) ) {
                            alt140=1;
                        }


                    }
                    else if ( (LA140_23==Identifier||(LA140_23>=FloatingPointLiteral && LA140_23<=DecimalLiteral)||LA140_23==41||LA140_23==45||(LA140_23>=56 && LA140_23<=63)||(LA140_23>=65 && LA140_23<=66)||(LA140_23>=69 && LA140_23<=71)||(LA140_23>=105 && LA140_23<=106)||(LA140_23>=109 && LA140_23<=114)) ) {
                        alt140=1;
                    }


                }
                else if ( (LA140_0==36) ) {
                    int LA140_24 = input.LA(2);

                    if ( (LA140_24==Identifier||(LA140_24>=FloatingPointLiteral && LA140_24<=DecimalLiteral)||LA140_24==34||LA140_24==41||LA140_24==45||(LA140_24>=56 && LA140_24<=63)||(LA140_24>=65 && LA140_24<=66)||(LA140_24>=69 && LA140_24<=71)||(LA140_24>=105 && LA140_24<=106)||(LA140_24>=109 && LA140_24<=114)) ) {
                        alt140=1;
                    }


                }


                switch (alt140) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:788:40: relationalOp shiftExpression
            	    {
            	    pushFollow(FOLLOW_relationalOp_in_relationalExpression4126);
            	    relationalOp();
            	    _fsp--;
            	    if (failed) return r;
            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression4128);
            	    shiftExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop140;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 113, relationalExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end relationalExpression


    // $ANTLR start relationalOp
    // src/com/epijava/grammar/EpiJava.g:791:1: relationalOp : ( '<' '=' | '>' '=' | '<' | '>' ) ;
    public final void relationalOp() throws RecognitionException {
        int relationalOp_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 114) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:792:2: ( ( '<' '=' | '>' '=' | '<' | '>' ) )
            // src/com/epijava/grammar/EpiJava.g:792:4: ( '<' '=' | '>' '=' | '<' | '>' )
            {
            // src/com/epijava/grammar/EpiJava.g:792:4: ( '<' '=' | '>' '=' | '<' | '>' )
            int alt141=4;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==34) ) {
                int LA141_1 = input.LA(2);

                if ( (LA141_1==45) ) {
                    alt141=1;
                }
                else if ( (LA141_1==Identifier||(LA141_1>=FloatingPointLiteral && LA141_1<=DecimalLiteral)||LA141_1==34||LA141_1==41||(LA141_1>=56 && LA141_1<=63)||(LA141_1>=65 && LA141_1<=66)||(LA141_1>=69 && LA141_1<=71)||(LA141_1>=105 && LA141_1<=106)||(LA141_1>=109 && LA141_1<=114)) ) {
                    alt141=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("792:4: ( '<' '=' | '>' '=' | '<' | '>' )", 141, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA141_0==36) ) {
                int LA141_2 = input.LA(2);

                if ( (LA141_2==45) ) {
                    alt141=2;
                }
                else if ( (LA141_2==Identifier||(LA141_2>=FloatingPointLiteral && LA141_2<=DecimalLiteral)||LA141_2==34||LA141_2==41||(LA141_2>=56 && LA141_2<=63)||(LA141_2>=65 && LA141_2<=66)||(LA141_2>=69 && LA141_2<=71)||(LA141_2>=105 && LA141_2<=106)||(LA141_2>=109 && LA141_2<=114)) ) {
                    alt141=4;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("792:4: ( '<' '=' | '>' '=' | '<' | '>' )", 141, 2, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("792:4: ( '<' '=' | '>' '=' | '<' | '>' )", 141, 0, input);

                throw nvae;
            }
            switch (alt141) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:792:5: '<' '='
                    {
                    match(input,34,FOLLOW_34_in_relationalOp4144); if (failed) return ;
                    match(input,45,FOLLOW_45_in_relationalOp4146); if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:792:15: '>' '='
                    {
                    match(input,36,FOLLOW_36_in_relationalOp4150); if (failed) return ;
                    match(input,45,FOLLOW_45_in_relationalOp4152); if (failed) return ;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:792:25: '<'
                    {
                    match(input,34,FOLLOW_34_in_relationalOp4156); if (failed) return ;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:792:31: '>'
                    {
                    match(input,36,FOLLOW_36_in_relationalOp4160); if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 114, relationalOp_StartIndex); }
        }
        return ;
    }
    // $ANTLR end relationalOp


    // $ANTLR start shiftExpression
    // src/com/epijava/grammar/EpiJava.g:795:1: shiftExpression returns [Expression r] : r_= additiveExpression ( shiftOp additiveExpression )* ;
    public final Expression shiftExpression() throws RecognitionException {
        Expression r = null;
        int shiftExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 115) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:796:5: (r_= additiveExpression ( shiftOp additiveExpression )* )
            // src/com/epijava/grammar/EpiJava.g:796:9: r_= additiveExpression ( shiftOp additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_shiftExpression4183);
            r_=additiveExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:796:41: ( shiftOp additiveExpression )*
            loop142:
            do {
                int alt142=2;
                int LA142_0 = input.LA(1);

                if ( (LA142_0==34) ) {
                    int LA142_1 = input.LA(2);

                    if ( (LA142_1==34) ) {
                        int LA142_27 = input.LA(3);

                        if ( (synpred208()) ) {
                            alt142=1;
                        }


                    }


                }
                else if ( (LA142_0==36) ) {
                    int LA142_2 = input.LA(2);

                    if ( (LA142_2==36) ) {
                        int LA142_59 = input.LA(3);

                        if ( (synpred208()) ) {
                            alt142=1;
                        }


                    }


                }


                switch (alt142) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:796:43: shiftOp additiveExpression
            	    {
            	    pushFollow(FOLLOW_shiftOp_in_shiftExpression4189);
            	    shiftOp();
            	    _fsp--;
            	    if (failed) return r;
            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression4191);
            	    additiveExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop142;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 115, shiftExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end shiftExpression


    // $ANTLR start shiftOp
    // src/com/epijava/grammar/EpiJava.g:800:1: shiftOp : ( '<' '<' | '>' '>' '>' | '>' '>' ) ;
    public final void shiftOp() throws RecognitionException {
        int shiftOp_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 116) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:801:2: ( ( '<' '<' | '>' '>' '>' | '>' '>' ) )
            // src/com/epijava/grammar/EpiJava.g:801:4: ( '<' '<' | '>' '>' '>' | '>' '>' )
            {
            // src/com/epijava/grammar/EpiJava.g:801:4: ( '<' '<' | '>' '>' '>' | '>' '>' )
            int alt143=3;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==34) ) {
                alt143=1;
            }
            else if ( (LA143_0==36) ) {
                int LA143_2 = input.LA(2);

                if ( (LA143_2==36) ) {
                    int LA143_3 = input.LA(3);

                    if ( (synpred210()) ) {
                        alt143=2;
                    }
                    else if ( (true) ) {
                        alt143=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("801:4: ( '<' '<' | '>' '>' '>' | '>' '>' )", 143, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("801:4: ( '<' '<' | '>' '>' '>' | '>' '>' )", 143, 2, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("801:4: ( '<' '<' | '>' '>' '>' | '>' '>' )", 143, 0, input);

                throw nvae;
            }
            switch (alt143) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:801:5: '<' '<'
                    {
                    match(input,34,FOLLOW_34_in_shiftOp4215); if (failed) return ;
                    match(input,34,FOLLOW_34_in_shiftOp4217); if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:801:15: '>' '>' '>'
                    {
                    match(input,36,FOLLOW_36_in_shiftOp4221); if (failed) return ;
                    match(input,36,FOLLOW_36_in_shiftOp4223); if (failed) return ;
                    match(input,36,FOLLOW_36_in_shiftOp4225); if (failed) return ;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:801:29: '>' '>'
                    {
                    match(input,36,FOLLOW_36_in_shiftOp4229); if (failed) return ;
                    match(input,36,FOLLOW_36_in_shiftOp4231); if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 116, shiftOp_StartIndex); }
        }
        return ;
    }
    // $ANTLR end shiftOp


    // $ANTLR start additiveExpression
    // src/com/epijava/grammar/EpiJava.g:805:1: additiveExpression returns [Expression r] : r_= multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final Expression additiveExpression() throws RecognitionException {
        Expression r = null;
        int additiveExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 117) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:806:5: (r_= multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // src/com/epijava/grammar/EpiJava.g:806:9: r_= multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression4255);
            r_=multiplicativeExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:806:47: ( ( '+' | '-' ) multiplicativeExpression )*
            loop144:
            do {
                int alt144=2;
                int LA144_0 = input.LA(1);

                if ( ((LA144_0>=105 && LA144_0<=106)) ) {
                    alt144=1;
                }


                switch (alt144) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:806:49: ( '+' | '-' ) multiplicativeExpression
            	    {
            	    if ( (input.LA(1)>=105 && input.LA(1)<=106) ) {
            	        input.consume();
            	        errorRecovery=false;failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return r;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_additiveExpression4261);    throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression4269);
            	    multiplicativeExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop144;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 117, additiveExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end additiveExpression


    // $ANTLR start multiplicativeExpression
    // src/com/epijava/grammar/EpiJava.g:809:1: multiplicativeExpression returns [Expression r] : r_= unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )* ;
    public final Expression multiplicativeExpression() throws RecognitionException {
        Expression r = null;
        int multiplicativeExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 118) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:810:5: (r_= unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )* )
            // src/com/epijava/grammar/EpiJava.g:810:9: r_= unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression4294);
            r_=unaryExpression();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {
              r = r_;
            }
            // src/com/epijava/grammar/EpiJava.g:810:38: ( ( '*' | '/' | '%' ) unaryExpression )*
            loop145:
            do {
                int alt145=2;
                int LA145_0 = input.LA(1);

                if ( (LA145_0==30||(LA145_0>=107 && LA145_0<=108)) ) {
                    alt145=1;
                }


                switch (alt145) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:810:40: ( '*' | '/' | '%' ) unaryExpression
            	    {
            	    if ( input.LA(1)==30||(input.LA(1)>=107 && input.LA(1)<=108) ) {
            	        input.consume();
            	        errorRecovery=false;failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return r;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_multiplicativeExpression4300);    throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression4314);
            	    unaryExpression();
            	    _fsp--;
            	    if (failed) return r;

            	    }
            	    break;

            	default :
            	    break loop145;
                }
            } while (true);


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 118, multiplicativeExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end multiplicativeExpression


    // $ANTLR start unaryExpression
    // src/com/epijava/grammar/EpiJava.g:813:1: unaryExpression returns [Expression r] : ( '+' unaryExpression | '-' unaryExpression | '++' unaryExpression | '--' unaryExpression | r_= unaryExpressionNotPlusMinus );
    public final Expression unaryExpression() throws RecognitionException {
        Expression r = null;
        int unaryExpression_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 119) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:814:5: ( '+' unaryExpression | '-' unaryExpression | '++' unaryExpression | '--' unaryExpression | r_= unaryExpressionNotPlusMinus )
            int alt146=5;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt146=1;
                }
                break;
            case 106:
                {
                alt146=2;
                }
                break;
            case 109:
                {
                alt146=3;
                }
                break;
            case 110:
                {
                alt146=4;
                }
                break;
            case Identifier:
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 34:
            case 41:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 65:
            case 66:
            case 69:
            case 70:
            case 71:
            case 111:
            case 112:
            case 113:
            case 114:
                {
                alt146=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("813:1: unaryExpression returns [Expression r] : ( '+' unaryExpression | '-' unaryExpression | '++' unaryExpression | '--' unaryExpression | r_= unaryExpressionNotPlusMinus );", 146, 0, input);

                throw nvae;
            }

            switch (alt146) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:814:9: '+' unaryExpression
                    {
                    match(input,105,FOLLOW_105_in_unaryExpression4338); if (failed) return r;
                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression4340);
                    unaryExpression();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:815:7: '-' unaryExpression
                    {
                    match(input,106,FOLLOW_106_in_unaryExpression4348); if (failed) return r;
                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression4350);
                    unaryExpression();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:816:9: '++' unaryExpression
                    {
                    match(input,109,FOLLOW_109_in_unaryExpression4360); if (failed) return r;
                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression4362);
                    unaryExpression();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:817:9: '--' unaryExpression
                    {
                    match(input,110,FOLLOW_110_in_unaryExpression4372); if (failed) return r;
                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression4374);
                    unaryExpression();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:818:9: r_= unaryExpressionNotPlusMinus
                    {
                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression4386);
                    r_=unaryExpressionNotPlusMinus();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                      r = r_;
                    }

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 119, unaryExpression_StartIndex); }
        }
        return r;
    }
    // $ANTLR end unaryExpression


    // $ANTLR start unaryExpressionNotPlusMinus
    // src/com/epijava/grammar/EpiJava.g:821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );
    public final Expression unaryExpressionNotPlusMinus() throws RecognitionException {
        Expression r = null;
        int unaryExpressionNotPlusMinus_StartIndex = input.index();
        Expression r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 120) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:822:5: ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? )
            int alt149=4;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt149=1;
                }
                break;
            case 112:
                {
                alt149=2;
                }
                break;
            case 66:
                {
                switch ( input.LA(2) ) {
                case 56:
                    {
                    int LA149_27 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 27, input);

                        throw nvae;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA149_28 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 28, input);

                        throw nvae;
                    }
                    }
                    break;
                case 58:
                    {
                    int LA149_29 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 29, input);

                        throw nvae;
                    }
                    }
                    break;
                case 59:
                    {
                    int LA149_30 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 30, input);

                        throw nvae;
                    }
                    }
                    break;
                case 60:
                    {
                    int LA149_31 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 31, input);

                        throw nvae;
                    }
                    }
                    break;
                case 61:
                    {
                    int LA149_32 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 32, input);

                        throw nvae;
                    }
                    }
                    break;
                case 62:
                    {
                    int LA149_33 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 33, input);

                        throw nvae;
                    }
                    }
                    break;
                case 63:
                    {
                    int LA149_34 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 34, input);

                        throw nvae;
                    }
                    }
                    break;
                case 105:
                    {
                    int LA149_35 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 35, input);

                        throw nvae;
                    }
                    }
                    break;
                case 106:
                    {
                    int LA149_36 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 36, input);

                        throw nvae;
                    }
                    }
                    break;
                case 109:
                    {
                    int LA149_37 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 37, input);

                        throw nvae;
                    }
                    }
                    break;
                case 110:
                    {
                    int LA149_38 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 38, input);

                        throw nvae;
                    }
                    }
                    break;
                case 111:
                    {
                    int LA149_39 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 39, input);

                        throw nvae;
                    }
                    }
                    break;
                case 112:
                    {
                    int LA149_40 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 40, input);

                        throw nvae;
                    }
                    }
                    break;
                case 66:
                    {
                    int LA149_41 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 41, input);

                        throw nvae;
                    }
                    }
                    break;
                case 34:
                    {
                    int LA149_42 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 42, input);

                        throw nvae;
                    }
                    }
                    break;
                case 113:
                    {
                    int LA149_43 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 43, input);

                        throw nvae;
                    }
                    }
                    break;
                case 65:
                    {
                    int LA149_44 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 44, input);

                        throw nvae;
                    }
                    }
                    break;
                case HexLiteral:
                    {
                    int LA149_45 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 45, input);

                        throw nvae;
                    }
                    }
                    break;
                case OctalLiteral:
                    {
                    int LA149_46 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 46, input);

                        throw nvae;
                    }
                    }
                    break;
                case DecimalLiteral:
                    {
                    int LA149_47 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 47, input);

                        throw nvae;
                    }
                    }
                    break;
                case FloatingPointLiteral:
                    {
                    int LA149_48 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 48, input);

                        throw nvae;
                    }
                    }
                    break;
                case CharacterLiteral:
                    {
                    int LA149_49 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 49, input);

                        throw nvae;
                    }
                    }
                    break;
                case StringLiteral:
                    {
                    int LA149_50 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 50, input);

                        throw nvae;
                    }
                    }
                    break;
                case 70:
                    {
                    int LA149_51 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 51, input);

                        throw nvae;
                    }
                    }
                    break;
                case 71:
                    {
                    int LA149_52 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 52, input);

                        throw nvae;
                    }
                    }
                    break;
                case 69:
                    {
                    int LA149_53 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 53, input);

                        throw nvae;
                    }
                    }
                    break;
                case 114:
                    {
                    int LA149_54 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 54, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    int LA149_55 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 55, input);

                        throw nvae;
                    }
                    }
                    break;
                case 41:
                    {
                    int LA149_56 = input.LA(3);

                    if ( (synpred222()) ) {
                        alt149=3;
                    }
                    else if ( (true) ) {
                        alt149=4;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 56, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 3, input);

                    throw nvae;
                }

                }
                break;
            case Identifier:
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 34:
            case 41:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 65:
            case 69:
            case 70:
            case 71:
            case 113:
            case 114:
                {
                alt149=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("821:1: unaryExpressionNotPlusMinus returns [Expression r] : ( '~' unaryExpression | '!' unaryExpression | castExpression | r_= primary ( selector )* ( '++' | '--' )? );", 149, 0, input);

                throw nvae;
            }

            switch (alt149) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:822:9: '~' unaryExpression
                    {
                    match(input,111,FOLLOW_111_in_unaryExpressionNotPlusMinus4411); if (failed) return r;
                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus4413);
                    unaryExpression();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:823:8: '!' unaryExpression
                    {
                    match(input,112,FOLLOW_112_in_unaryExpressionNotPlusMinus4422); if (failed) return r;
                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus4424);
                    unaryExpression();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:824:9: castExpression
                    {
                    pushFollow(FOLLOW_castExpression_in_unaryExpressionNotPlusMinus4434);
                    castExpression();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:825:9: r_= primary ( selector )* ( '++' | '--' )?
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpressionNotPlusMinus4446);
                    r_=primary();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                      r = r_;
                    }
                    // src/com/epijava/grammar/EpiJava.g:825:30: ( selector )*
                    loop147:
                    do {
                        int alt147=2;
                        int LA147_0 = input.LA(1);

                        if ( (LA147_0==29||LA147_0==42) ) {
                            alt147=1;
                        }


                        switch (alt147) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:0:0: selector
                    	    {
                    	    pushFollow(FOLLOW_selector_in_unaryExpressionNotPlusMinus4450);
                    	    selector();
                    	    _fsp--;
                    	    if (failed) return r;

                    	    }
                    	    break;

                    	default :
                    	    break loop147;
                        }
                    } while (true);

                    // src/com/epijava/grammar/EpiJava.g:825:40: ( '++' | '--' )?
                    int alt148=2;
                    int LA148_0 = input.LA(1);

                    if ( ((LA148_0>=109 && LA148_0<=110)) ) {
                        alt148=1;
                    }
                    switch (alt148) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:
                            {
                            if ( (input.LA(1)>=109 && input.LA(1)<=110) ) {
                                input.consume();
                                errorRecovery=false;failed=false;
                            }
                            else {
                                if (backtracking>0) {failed=true; return r;}
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_unaryExpressionNotPlusMinus4453);    throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 120, unaryExpressionNotPlusMinus_StartIndex); }
        }
        return r;
    }
    // $ANTLR end unaryExpressionNotPlusMinus


    // $ANTLR start castExpression
    // src/com/epijava/grammar/EpiJava.g:828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );
    public final void castExpression() throws RecognitionException {
        int castExpression_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 121) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:829:5: ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus )
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==66) ) {
                switch ( input.LA(2) ) {
                case Identifier:
                case FloatingPointLiteral:
                case CharacterLiteral:
                case StringLiteral:
                case HexLiteral:
                case OctalLiteral:
                case DecimalLiteral:
                case 34:
                case 41:
                case 65:
                case 66:
                case 69:
                case 70:
                case 71:
                case 105:
                case 106:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                    {
                    alt151=2;
                    }
                    break;
                case 56:
                    {
                    int LA151_3 = input.LA(3);

                    if ( (synpred226()) ) {
                        alt151=1;
                    }
                    else if ( (true) ) {
                        alt151=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA151_4 = input.LA(3);

                    if ( (synpred226()) ) {
                        alt151=1;
                    }
                    else if ( (true) ) {
                        alt151=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 58:
                    {
                    int LA151_5 = input.LA(3);

                    if ( (synpred226()) ) {
                        alt151=1;
                    }
                    else if ( (true) ) {
                        alt151=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case 59:
                    {
                    int LA151_6 = input.LA(3);

                    if ( (synpred226()) ) {
                        alt151=1;
                    }
                    else if ( (true) ) {
                        alt151=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 6, input);

                        throw nvae;
                    }
                    }
                    break;
                case 60:
                    {
                    int LA151_7 = input.LA(3);

                    if ( (synpred226()) ) {
                        alt151=1;
                    }
                    else if ( (true) ) {
                        alt151=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case 61:
                    {
                    int LA151_8 = input.LA(3);

                    if ( (synpred226()) ) {
                        alt151=1;
                    }
                    else if ( (true) ) {
                        alt151=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 8, input);

                        throw nvae;
                    }
                    }
                    break;
                case 62:
                    {
                    int LA151_9 = input.LA(3);

                    if ( (synpred226()) ) {
                        alt151=1;
                    }
                    else if ( (true) ) {
                        alt151=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 9, input);

                        throw nvae;
                    }
                    }
                    break;
                case 63:
                    {
                    int LA151_10 = input.LA(3);

                    if ( (synpred226()) ) {
                        alt151=1;
                    }
                    else if ( (true) ) {
                        alt151=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 10, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 1, input);

                    throw nvae;
                }

            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("828:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' ( type | expression ) ')' unaryExpressionNotPlusMinus );", 151, 0, input);

                throw nvae;
            }
            switch (alt151) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:829:8: '(' primitiveType ')' unaryExpression
                    {
                    match(input,66,FOLLOW_66_in_castExpression4476); if (failed) return ;
                    pushFollow(FOLLOW_primitiveType_in_castExpression4478);
                    primitiveType();
                    _fsp--;
                    if (failed) return ;
                    match(input,67,FOLLOW_67_in_castExpression4480); if (failed) return ;
                    pushFollow(FOLLOW_unaryExpression_in_castExpression4482);
                    unaryExpression();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:830:8: '(' ( type | expression ) ')' unaryExpressionNotPlusMinus
                    {
                    match(input,66,FOLLOW_66_in_castExpression4491); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:830:12: ( type | expression )
                    int alt150=2;
                    switch ( input.LA(1) ) {
                    case Identifier:
                        {
                        int LA150_1 = input.LA(2);

                        if ( (synpred227()) ) {
                            alt150=1;
                        }
                        else if ( (true) ) {
                            alt150=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("830:12: ( type | expression )", 150, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 56:
                        {
                        switch ( input.LA(2) ) {
                        case 42:
                            {
                            int LA150_58 = input.LA(3);

                            if ( (synpred227()) ) {
                                alt150=1;
                            }
                            else if ( (true) ) {
                                alt150=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("830:12: ( type | expression )", 150, 58, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 67:
                            {
                            alt150=1;
                            }
                            break;
                        case 29:
                            {
                            alt150=2;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("830:12: ( type | expression )", 150, 2, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 57:
                        {
                        switch ( input.LA(2) ) {
                        case 42:
                            {
                            int LA150_61 = input.LA(3);

                            if ( (synpred227()) ) {
                                alt150=1;
                            }
                            else if ( (true) ) {
                                alt150=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("830:12: ( type | expression )", 150, 61, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 29:
                            {
                            alt150=2;
                            }
                            break;
                        case 67:
                            {
                            alt150=1;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("830:12: ( type | expression )", 150, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 58:
                        {
                        switch ( input.LA(2) ) {
                        case 42:
                            {
                            int LA150_64 = input.LA(3);

                            if ( (synpred227()) ) {
                                alt150=1;
                            }
                            else if ( (true) ) {
                                alt150=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("830:12: ( type | expression )", 150, 64, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 67:
                            {
                            alt150=1;
                            }
                            break;
                        case 29:
                            {
                            alt150=2;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("830:12: ( type | expression )", 150, 4, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 59:
                        {
                        switch ( input.LA(2) ) {
                        case 42:
                            {
                            int LA150_67 = input.LA(3);

                            if ( (synpred227()) ) {
                                alt150=1;
                            }
                            else if ( (true) ) {
                                alt150=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("830:12: ( type | expression )", 150, 67, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 67:
                            {
                            alt150=1;
                            }
                            break;
                        case 29:
                            {
                            alt150=2;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("830:12: ( type | expression )", 150, 5, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 60:
                        {
                        switch ( input.LA(2) ) {
                        case 42:
                            {
                            int LA150_70 = input.LA(3);

                            if ( (synpred227()) ) {
                                alt150=1;
                            }
                            else if ( (true) ) {
                                alt150=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("830:12: ( type | expression )", 150, 70, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 29:
                            {
                            alt150=2;
                            }
                            break;
                        case 67:
                            {
                            alt150=1;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("830:12: ( type | expression )", 150, 6, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 61:
                        {
                        switch ( input.LA(2) ) {
                        case 42:
                            {
                            int LA150_73 = input.LA(3);

                            if ( (synpred227()) ) {
                                alt150=1;
                            }
                            else if ( (true) ) {
                                alt150=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("830:12: ( type | expression )", 150, 73, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 29:
                            {
                            alt150=2;
                            }
                            break;
                        case 67:
                            {
                            alt150=1;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("830:12: ( type | expression )", 150, 7, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 62:
                        {
                        switch ( input.LA(2) ) {
                        case 42:
                            {
                            int LA150_76 = input.LA(3);

                            if ( (synpred227()) ) {
                                alt150=1;
                            }
                            else if ( (true) ) {
                                alt150=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("830:12: ( type | expression )", 150, 76, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 67:
                            {
                            alt150=1;
                            }
                            break;
                        case 29:
                            {
                            alt150=2;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("830:12: ( type | expression )", 150, 8, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 63:
                        {
                        switch ( input.LA(2) ) {
                        case 42:
                            {
                            int LA150_79 = input.LA(3);

                            if ( (synpred227()) ) {
                                alt150=1;
                            }
                            else if ( (true) ) {
                                alt150=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("830:12: ( type | expression )", 150, 79, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 29:
                            {
                            alt150=2;
                            }
                            break;
                        case 67:
                            {
                            alt150=1;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("830:12: ( type | expression )", 150, 9, input);

                            throw nvae;
                        }

                        }
                        break;
                    case FloatingPointLiteral:
                    case CharacterLiteral:
                    case StringLiteral:
                    case HexLiteral:
                    case OctalLiteral:
                    case DecimalLiteral:
                    case 34:
                    case 41:
                    case 65:
                    case 66:
                    case 69:
                    case 70:
                    case 71:
                    case 105:
                    case 106:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                        {
                        alt150=2;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("830:12: ( type | expression )", 150, 0, input);

                        throw nvae;
                    }

                    switch (alt150) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:830:13: type
                            {
                            pushFollow(FOLLOW_type_in_castExpression4494);
                            type();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;
                        case 2 :
                            // src/com/epijava/grammar/EpiJava.g:830:20: expression
                            {
                            pushFollow(FOLLOW_expression_in_castExpression4498);
                            expression();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }

                    match(input,67,FOLLOW_67_in_castExpression4501); if (failed) return ;
                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_castExpression4503);
                    unaryExpressionNotPlusMinus();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 121, castExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end castExpression


    // $ANTLR start primary
    // src/com/epijava/grammar/EpiJava.g:833:1: primary returns [Expression r] : (r_= parExpression | nonWildcardTypeArguments ( explicitGenericInvocationSuffix | 'this' arguments ) | 'this' ( '.' Identifier )* identifierSuffix[new NullLiteral(Locus.Unknown)] | 'super' superSuffix | r_= literal | 'new' creator | q= qualifiedName r_= identifierSuffix[r] | primitiveType ( '[' ']' )* '.' 'class' | 'void' '.' 'class' );
    public final Expression primary() throws RecognitionException {
        Expression r = null;
        int primary_StartIndex = input.index();
        Expression r_ = null;

        QualifiedName q = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 122) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:834:5: (r_= parExpression | nonWildcardTypeArguments ( explicitGenericInvocationSuffix | 'this' arguments ) | 'this' ( '.' Identifier )* identifierSuffix[new NullLiteral(Locus.Unknown)] | 'super' superSuffix | r_= literal | 'new' creator | q= qualifiedName r_= identifierSuffix[r] | primitiveType ( '[' ']' )* '.' 'class' | 'void' '.' 'class' )
            int alt155=9;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt155=1;
                }
                break;
            case 34:
                {
                alt155=2;
                }
                break;
            case 113:
                {
                alt155=3;
                }
                break;
            case 65:
                {
                alt155=4;
                }
                break;
            case FloatingPointLiteral:
            case CharacterLiteral:
            case StringLiteral:
            case HexLiteral:
            case OctalLiteral:
            case DecimalLiteral:
            case 69:
            case 70:
            case 71:
                {
                alt155=5;
                }
                break;
            case 114:
                {
                alt155=6;
                }
                break;
            case Identifier:
                {
                alt155=7;
                }
                break;
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt155=8;
                }
                break;
            case 41:
                {
                alt155=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("833:1: primary returns [Expression r] : (r_= parExpression | nonWildcardTypeArguments ( explicitGenericInvocationSuffix | 'this' arguments ) | 'this' ( '.' Identifier )* identifierSuffix[new NullLiteral(Locus.Unknown)] | 'super' superSuffix | r_= literal | 'new' creator | q= qualifiedName r_= identifierSuffix[r] | primitiveType ( '[' ']' )* '.' 'class' | 'void' '.' 'class' );", 155, 0, input);

                throw nvae;
            }

            switch (alt155) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:834:7: r_= parExpression
                    {
                    pushFollow(FOLLOW_parExpression_in_primary4526);
                    r_=parExpression();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                      r=r_;
                    }

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:835:9: nonWildcardTypeArguments ( explicitGenericInvocationSuffix | 'this' arguments )
                    {
                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_primary4537);
                    nonWildcardTypeArguments();
                    _fsp--;
                    if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:836:9: ( explicitGenericInvocationSuffix | 'this' arguments )
                    int alt152=2;
                    int LA152_0 = input.LA(1);

                    if ( (LA152_0==Identifier||LA152_0==65) ) {
                        alt152=1;
                    }
                    else if ( (LA152_0==113) ) {
                        alt152=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("836:9: ( explicitGenericInvocationSuffix | 'this' arguments )", 152, 0, input);

                        throw nvae;
                    }
                    switch (alt152) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:836:10: explicitGenericInvocationSuffix
                            {
                            pushFollow(FOLLOW_explicitGenericInvocationSuffix_in_primary4548);
                            explicitGenericInvocationSuffix();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;
                        case 2 :
                            // src/com/epijava/grammar/EpiJava.g:836:44: 'this' arguments
                            {
                            match(input,113,FOLLOW_113_in_primary4552); if (failed) return r;
                            pushFollow(FOLLOW_arguments_in_primary4554);
                            arguments();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:837:9: 'this' ( '.' Identifier )* identifierSuffix[new NullLiteral(Locus.Unknown)]
                    {
                    match(input,113,FOLLOW_113_in_primary4565); if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:837:16: ( '.' Identifier )*
                    loop153:
                    do {
                        int alt153=2;
                        int LA153_0 = input.LA(1);

                        if ( (LA153_0==29) ) {
                            int LA153_3 = input.LA(2);

                            if ( (LA153_3==Identifier) ) {
                                int LA153_33 = input.LA(3);

                                if ( (synpred231()) ) {
                                    alt153=1;
                                }


                            }


                        }


                        switch (alt153) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:837:17: '.' Identifier
                    	    {
                    	    match(input,29,FOLLOW_29_in_primary4568); if (failed) return r;
                    	    match(input,Identifier,FOLLOW_Identifier_in_primary4570); if (failed) return r;

                    	    }
                    	    break;

                    	default :
                    	    break loop153;
                        }
                    } while (true);

                    pushFollow(FOLLOW_identifierSuffix_in_primary4574);
                    identifierSuffix(new NullLiteral(Locus.Unknown));
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:838:9: 'super' superSuffix
                    {
                    match(input,65,FOLLOW_65_in_primary4586); if (failed) return r;
                    pushFollow(FOLLOW_superSuffix_in_primary4588);
                    superSuffix();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:839:9: r_= literal
                    {
                    pushFollow(FOLLOW_literal_in_primary4600);
                    r_=literal();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                      r = r_;
                    }

                    }
                    break;
                case 6 :
                    // src/com/epijava/grammar/EpiJava.g:840:9: 'new' creator
                    {
                    match(input,114,FOLLOW_114_in_primary4612); if (failed) return r;
                    pushFollow(FOLLOW_creator_in_primary4614);
                    creator();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 7 :
                    // src/com/epijava/grammar/EpiJava.g:841:9: q= qualifiedName r_= identifierSuffix[r]
                    {
                    pushFollow(FOLLOW_qualifiedName_in_primary4626);
                    q=qualifiedName();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                      r=new AmbiguousReference(l(q), q); 
                    }
                    pushFollow(FOLLOW_identifierSuffix_in_primary4632);
                    r_=identifierSuffix(r);
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r=r_;
                    }

                    }
                    break;
                case 8 :
                    // src/com/epijava/grammar/EpiJava.g:842:9: primitiveType ( '[' ']' )* '.' 'class'
                    {
                    pushFollow(FOLLOW_primitiveType_in_primary4645);
                    primitiveType();
                    _fsp--;
                    if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:842:23: ( '[' ']' )*
                    loop154:
                    do {
                        int alt154=2;
                        int LA154_0 = input.LA(1);

                        if ( (LA154_0==42) ) {
                            alt154=1;
                        }


                        switch (alt154) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:842:24: '[' ']'
                    	    {
                    	    match(input,42,FOLLOW_42_in_primary4648); if (failed) return r;
                    	    match(input,43,FOLLOW_43_in_primary4650); if (failed) return r;

                    	    }
                    	    break;

                    	default :
                    	    break loop154;
                        }
                    } while (true);

                    match(input,29,FOLLOW_29_in_primary4654); if (failed) return r;
                    match(input,31,FOLLOW_31_in_primary4656); if (failed) return r;

                    }
                    break;
                case 9 :
                    // src/com/epijava/grammar/EpiJava.g:843:9: 'void' '.' 'class'
                    {
                    match(input,41,FOLLOW_41_in_primary4666); if (failed) return r;
                    match(input,29,FOLLOW_29_in_primary4668); if (failed) return r;
                    match(input,31,FOLLOW_31_in_primary4670); if (failed) return r;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 122, primary_StartIndex); }
        }
        return r;
    }
    // $ANTLR end primary


    // $ANTLR start identifierSuffix
    // src/com/epijava/grammar/EpiJava.g:846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );
    public final Expression identifierSuffix(Expression orig) throws RecognitionException {
        Expression r = null;
        int identifierSuffix_StartIndex = input.index();
        List<Expression> args = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 123) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:847:2: ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () )
            int alt159=9;
            switch ( input.LA(1) ) {
            case 42:
                {
                switch ( input.LA(2) ) {
                case 43:
                    {
                    alt159=1;
                    }
                    break;
                case 105:
                    {
                    int LA159_34 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 34, input);

                        throw nvae;
                    }
                    }
                    break;
                case 106:
                    {
                    int LA159_35 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 35, input);

                        throw nvae;
                    }
                    }
                    break;
                case 109:
                    {
                    int LA159_36 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 36, input);

                        throw nvae;
                    }
                    }
                    break;
                case 110:
                    {
                    int LA159_37 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 37, input);

                        throw nvae;
                    }
                    }
                    break;
                case 111:
                    {
                    int LA159_38 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 38, input);

                        throw nvae;
                    }
                    }
                    break;
                case 112:
                    {
                    int LA159_39 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 39, input);

                        throw nvae;
                    }
                    }
                    break;
                case 66:
                    {
                    int LA159_40 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 40, input);

                        throw nvae;
                    }
                    }
                    break;
                case 34:
                    {
                    int LA159_41 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 41, input);

                        throw nvae;
                    }
                    }
                    break;
                case 113:
                    {
                    int LA159_42 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 42, input);

                        throw nvae;
                    }
                    }
                    break;
                case 65:
                    {
                    int LA159_43 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 43, input);

                        throw nvae;
                    }
                    }
                    break;
                case HexLiteral:
                    {
                    int LA159_44 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 44, input);

                        throw nvae;
                    }
                    }
                    break;
                case OctalLiteral:
                    {
                    int LA159_45 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 45, input);

                        throw nvae;
                    }
                    }
                    break;
                case DecimalLiteral:
                    {
                    int LA159_46 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 46, input);

                        throw nvae;
                    }
                    }
                    break;
                case FloatingPointLiteral:
                    {
                    int LA159_47 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 47, input);

                        throw nvae;
                    }
                    }
                    break;
                case CharacterLiteral:
                    {
                    int LA159_48 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 48, input);

                        throw nvae;
                    }
                    }
                    break;
                case StringLiteral:
                    {
                    int LA159_49 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 49, input);

                        throw nvae;
                    }
                    }
                    break;
                case 70:
                    {
                    int LA159_50 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 50, input);

                        throw nvae;
                    }
                    }
                    break;
                case 71:
                    {
                    int LA159_51 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 51, input);

                        throw nvae;
                    }
                    }
                    break;
                case 69:
                    {
                    int LA159_52 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 52, input);

                        throw nvae;
                    }
                    }
                    break;
                case 114:
                    {
                    int LA159_53 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 53, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    int LA159_54 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 54, input);

                        throw nvae;
                    }
                    }
                    break;
                case 56:
                    {
                    int LA159_55 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 55, input);

                        throw nvae;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA159_56 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 56, input);

                        throw nvae;
                    }
                    }
                    break;
                case 58:
                    {
                    int LA159_57 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 57, input);

                        throw nvae;
                    }
                    }
                    break;
                case 59:
                    {
                    int LA159_58 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 58, input);

                        throw nvae;
                    }
                    }
                    break;
                case 60:
                    {
                    int LA159_59 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 59, input);

                        throw nvae;
                    }
                    }
                    break;
                case 61:
                    {
                    int LA159_60 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 60, input);

                        throw nvae;
                    }
                    }
                    break;
                case 62:
                    {
                    int LA159_61 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 61, input);

                        throw nvae;
                    }
                    }
                    break;
                case 63:
                    {
                    int LA159_62 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 62, input);

                        throw nvae;
                    }
                    }
                    break;
                case 41:
                    {
                    int LA159_63 = input.LA(3);

                    if ( (synpred242()) ) {
                        alt159=2;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 63, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 1, input);

                    throw nvae;
                }

                }
                break;
            case 66:
                {
                alt159=3;
                }
                break;
            case 29:
                {
                switch ( input.LA(2) ) {
                case 113:
                    {
                    int LA159_64 = input.LA(3);

                    if ( (synpred246()) ) {
                        alt159=6;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 64, input);

                        throw nvae;
                    }
                    }
                    break;
                case 31:
                    {
                    alt159=4;
                    }
                    break;
                case 65:
                    {
                    int LA159_66 = input.LA(3);

                    if ( (synpred247()) ) {
                        alt159=7;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 66, input);

                        throw nvae;
                    }
                    }
                    break;
                case 114:
                    {
                    int LA159_67 = input.LA(3);

                    if ( (synpred249()) ) {
                        alt159=8;
                    }
                    else if ( (true) ) {
                        alt159=9;
                    }
                    else {
                        if (backtracking>0) {failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 67, input);

                        throw nvae;
                    }
                    }
                    break;
                case Identifier:
                    {
                    alt159=9;
                    }
                    break;
                case 34:
                    {
                    alt159=5;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 3, input);

                    throw nvae;
                }

                }
                break;
            case EOF:
            case 26:
            case 30:
            case 34:
            case 35:
            case 36:
            case 37:
            case 39:
            case 43:
            case 45:
            case 64:
            case 67:
            case 75:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
                {
                alt159=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("846:1: identifierSuffix[Expression orig] returns [Expression r] : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | args= arguments | '.' 'class' | '.' explicitGenericInvocation | '.' 'this' | '.' 'super' arguments | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | () );", 159, 0, input);

                throw nvae;
            }

            switch (alt159) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:847:4: ( '[' ']' )+ '.' 'class'
                    {
                    // src/com/epijava/grammar/EpiJava.g:847:4: ( '[' ']' )+
                    int cnt156=0;
                    loop156:
                    do {
                        int alt156=2;
                        int LA156_0 = input.LA(1);

                        if ( (LA156_0==42) ) {
                            alt156=1;
                        }


                        switch (alt156) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:847:5: '[' ']'
                    	    {
                    	    match(input,42,FOLLOW_42_in_identifierSuffix4686); if (failed) return r;
                    	    match(input,43,FOLLOW_43_in_identifierSuffix4688); if (failed) return r;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt156 >= 1 ) break loop156;
                    	    if (backtracking>0) {failed=true; return r;}
                                EarlyExitException eee =
                                    new EarlyExitException(156, input);
                                throw eee;
                        }
                        cnt156++;
                    } while (true);

                    match(input,29,FOLLOW_29_in_identifierSuffix4692); if (failed) return r;
                    match(input,31,FOLLOW_31_in_identifierSuffix4694); if (failed) return r;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:848:4: ( '[' expression ']' )+
                    {
                    // src/com/epijava/grammar/EpiJava.g:848:4: ( '[' expression ']' )+
                    int cnt157=0;
                    loop157:
                    do {
                        int alt157=2;
                        int LA157_0 = input.LA(1);

                        if ( (LA157_0==42) ) {
                            switch ( input.LA(2) ) {
                            case 105:
                                {
                                int LA157_32 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 106:
                                {
                                int LA157_33 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 109:
                                {
                                int LA157_34 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 110:
                                {
                                int LA157_35 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 111:
                                {
                                int LA157_36 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 112:
                                {
                                int LA157_37 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 66:
                                {
                                int LA157_38 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 34:
                                {
                                int LA157_39 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 113:
                                {
                                int LA157_40 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 65:
                                {
                                int LA157_41 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case HexLiteral:
                                {
                                int LA157_42 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case OctalLiteral:
                                {
                                int LA157_43 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case DecimalLiteral:
                                {
                                int LA157_44 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case FloatingPointLiteral:
                                {
                                int LA157_45 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case CharacterLiteral:
                                {
                                int LA157_46 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case StringLiteral:
                                {
                                int LA157_47 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 70:
                                {
                                int LA157_48 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 71:
                                {
                                int LA157_49 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 69:
                                {
                                int LA157_50 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 114:
                                {
                                int LA157_51 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case Identifier:
                                {
                                int LA157_52 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 56:
                                {
                                int LA157_53 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 57:
                                {
                                int LA157_54 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 58:
                                {
                                int LA157_55 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 59:
                                {
                                int LA157_56 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 60:
                                {
                                int LA157_57 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 61:
                                {
                                int LA157_58 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 62:
                                {
                                int LA157_59 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 63:
                                {
                                int LA157_60 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;
                            case 41:
                                {
                                int LA157_61 = input.LA(3);

                                if ( (synpred241()) ) {
                                    alt157=1;
                                }


                                }
                                break;

                            }

                        }


                        switch (alt157) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:848:5: '[' expression ']'
                    	    {
                    	    match(input,42,FOLLOW_42_in_identifierSuffix4700); if (failed) return r;
                    	    pushFollow(FOLLOW_expression_in_identifierSuffix4702);
                    	    expression();
                    	    _fsp--;
                    	    if (failed) return r;
                    	    match(input,43,FOLLOW_43_in_identifierSuffix4704); if (failed) return r;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt157 >= 1 ) break loop157;
                    	    if (backtracking>0) {failed=true; return r;}
                                EarlyExitException eee =
                                    new EarlyExitException(157, input);
                                throw eee;
                        }
                        cnt157++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:849:9: args= arguments
                    {
                    pushFollow(FOLLOW_arguments_in_identifierSuffix4719);
                    args=arguments();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                       r = new Call(l(orig), (AmbiguousReference)orig, args); 
                    }

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:850:9: '.' 'class'
                    {
                    match(input,29,FOLLOW_29_in_identifierSuffix4731); if (failed) return r;
                    match(input,31,FOLLOW_31_in_identifierSuffix4733); if (failed) return r;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:851:9: '.' explicitGenericInvocation
                    {
                    match(input,29,FOLLOW_29_in_identifierSuffix4743); if (failed) return r;
                    pushFollow(FOLLOW_explicitGenericInvocation_in_identifierSuffix4745);
                    explicitGenericInvocation();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 6 :
                    // src/com/epijava/grammar/EpiJava.g:852:9: '.' 'this'
                    {
                    match(input,29,FOLLOW_29_in_identifierSuffix4755); if (failed) return r;
                    match(input,113,FOLLOW_113_in_identifierSuffix4757); if (failed) return r;

                    }
                    break;
                case 7 :
                    // src/com/epijava/grammar/EpiJava.g:853:9: '.' 'super' arguments
                    {
                    match(input,29,FOLLOW_29_in_identifierSuffix4767); if (failed) return r;
                    match(input,65,FOLLOW_65_in_identifierSuffix4769); if (failed) return r;
                    pushFollow(FOLLOW_arguments_in_identifierSuffix4771);
                    arguments();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 8 :
                    // src/com/epijava/grammar/EpiJava.g:854:9: '.' 'new' ( nonWildcardTypeArguments )? innerCreator
                    {
                    match(input,29,FOLLOW_29_in_identifierSuffix4781); if (failed) return r;
                    match(input,114,FOLLOW_114_in_identifierSuffix4783); if (failed) return r;
                    // src/com/epijava/grammar/EpiJava.g:854:19: ( nonWildcardTypeArguments )?
                    int alt158=2;
                    int LA158_0 = input.LA(1);

                    if ( (LA158_0==34) ) {
                        alt158=1;
                    }
                    switch (alt158) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:854:20: nonWildcardTypeArguments
                            {
                            pushFollow(FOLLOW_nonWildcardTypeArguments_in_identifierSuffix4786);
                            nonWildcardTypeArguments();
                            _fsp--;
                            if (failed) return r;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_innerCreator_in_identifierSuffix4790);
                    innerCreator();
                    _fsp--;
                    if (failed) return r;

                    }
                    break;
                case 9 :
                    // src/com/epijava/grammar/EpiJava.g:855:9: ()
                    {
                    // src/com/epijava/grammar/EpiJava.g:855:9: ()
                    // src/com/epijava/grammar/EpiJava.g:855:11: 
                    {
                    if ( backtracking==0 ) {
                       r = orig; 
                    }

                    }


                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 123, identifierSuffix_StartIndex); }
        }
        return r;
    }
    // $ANTLR end identifierSuffix


    // $ANTLR start creator
    // src/com/epijava/grammar/EpiJava.g:858:1: creator : ( nonWildcardTypeArguments )? createdName ( arrayCreatorRest | classCreatorRest ) ;
    public final void creator() throws RecognitionException {
        int creator_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 124) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:859:2: ( ( nonWildcardTypeArguments )? createdName ( arrayCreatorRest | classCreatorRest ) )
            // src/com/epijava/grammar/EpiJava.g:859:4: ( nonWildcardTypeArguments )? createdName ( arrayCreatorRest | classCreatorRest )
            {
            // src/com/epijava/grammar/EpiJava.g:859:4: ( nonWildcardTypeArguments )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==34) ) {
                alt160=1;
            }
            switch (alt160) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:0:0: nonWildcardTypeArguments
                    {
                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_creator4817);
                    nonWildcardTypeArguments();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_createdName_in_creator4820);
            createdName();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:860:9: ( arrayCreatorRest | classCreatorRest )
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==42) ) {
                alt161=1;
            }
            else if ( (LA161_0==66) ) {
                alt161=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("860:9: ( arrayCreatorRest | classCreatorRest )", 161, 0, input);

                throw nvae;
            }
            switch (alt161) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:860:10: arrayCreatorRest
                    {
                    pushFollow(FOLLOW_arrayCreatorRest_in_creator4831);
                    arrayCreatorRest();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:860:29: classCreatorRest
                    {
                    pushFollow(FOLLOW_classCreatorRest_in_creator4835);
                    classCreatorRest();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 124, creator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end creator


    // $ANTLR start createdName
    // src/com/epijava/grammar/EpiJava.g:863:1: createdName : ( Identifier ( typeArguments )? ( '.' Identifier ( typeArguments )? )* | primitiveType );
    public final void createdName() throws RecognitionException {
        int createdName_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 125) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:864:2: ( Identifier ( typeArguments )? ( '.' Identifier ( typeArguments )? )* | primitiveType )
            int alt165=2;
            int LA165_0 = input.LA(1);

            if ( (LA165_0==Identifier) ) {
                alt165=1;
            }
            else if ( ((LA165_0>=56 && LA165_0<=63)) ) {
                alt165=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("863:1: createdName : ( Identifier ( typeArguments )? ( '.' Identifier ( typeArguments )? )* | primitiveType );", 165, 0, input);

                throw nvae;
            }
            switch (alt165) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:864:4: Identifier ( typeArguments )? ( '.' Identifier ( typeArguments )? )*
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_createdName4847); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:864:15: ( typeArguments )?
                    int alt162=2;
                    int LA162_0 = input.LA(1);

                    if ( (LA162_0==34) ) {
                        alt162=1;
                    }
                    switch (alt162) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:0:0: typeArguments
                            {
                            pushFollow(FOLLOW_typeArguments_in_createdName4849);
                            typeArguments();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }

                    // src/com/epijava/grammar/EpiJava.g:865:9: ( '.' Identifier ( typeArguments )? )*
                    loop164:
                    do {
                        int alt164=2;
                        int LA164_0 = input.LA(1);

                        if ( (LA164_0==29) ) {
                            alt164=1;
                        }


                        switch (alt164) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:865:10: '.' Identifier ( typeArguments )?
                    	    {
                    	    match(input,29,FOLLOW_29_in_createdName4861); if (failed) return ;
                    	    match(input,Identifier,FOLLOW_Identifier_in_createdName4863); if (failed) return ;
                    	    // src/com/epijava/grammar/EpiJava.g:865:25: ( typeArguments )?
                    	    int alt163=2;
                    	    int LA163_0 = input.LA(1);

                    	    if ( (LA163_0==34) ) {
                    	        alt163=1;
                    	    }
                    	    switch (alt163) {
                    	        case 1 :
                    	            // src/com/epijava/grammar/EpiJava.g:0:0: typeArguments
                    	            {
                    	            pushFollow(FOLLOW_typeArguments_in_createdName4865);
                    	            typeArguments();
                    	            _fsp--;
                    	            if (failed) return ;

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop164;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:866:7: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_createdName4876);
                    primitiveType();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 125, createdName_StartIndex); }
        }
        return ;
    }
    // $ANTLR end createdName


    // $ANTLR start innerCreator
    // src/com/epijava/grammar/EpiJava.g:869:1: innerCreator : Identifier classCreatorRest ;
    public final void innerCreator() throws RecognitionException {
        int innerCreator_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 126) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:870:2: ( Identifier classCreatorRest )
            // src/com/epijava/grammar/EpiJava.g:870:4: Identifier classCreatorRest
            {
            match(input,Identifier,FOLLOW_Identifier_in_innerCreator4888); if (failed) return ;
            pushFollow(FOLLOW_classCreatorRest_in_innerCreator4890);
            classCreatorRest();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 126, innerCreator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end innerCreator


    // $ANTLR start arrayCreatorRest
    // src/com/epijava/grammar/EpiJava.g:873:1: arrayCreatorRest : '[' ( ']' ( '[' ']' )* arrayInitializer | expression ']' ( '[' expression ']' )* ( '[' ']' )* ) ;
    public final void arrayCreatorRest() throws RecognitionException {
        int arrayCreatorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 127) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:874:2: ( '[' ( ']' ( '[' ']' )* arrayInitializer | expression ']' ( '[' expression ']' )* ( '[' ']' )* ) )
            // src/com/epijava/grammar/EpiJava.g:874:4: '[' ( ']' ( '[' ']' )* arrayInitializer | expression ']' ( '[' expression ']' )* ( '[' ']' )* )
            {
            match(input,42,FOLLOW_42_in_arrayCreatorRest4901); if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:875:9: ( ']' ( '[' ']' )* arrayInitializer | expression ']' ( '[' expression ']' )* ( '[' ']' )* )
            int alt169=2;
            int LA169_0 = input.LA(1);

            if ( (LA169_0==43) ) {
                alt169=1;
            }
            else if ( (LA169_0==Identifier||(LA169_0>=FloatingPointLiteral && LA169_0<=DecimalLiteral)||LA169_0==34||LA169_0==41||(LA169_0>=56 && LA169_0<=63)||(LA169_0>=65 && LA169_0<=66)||(LA169_0>=69 && LA169_0<=71)||(LA169_0>=105 && LA169_0<=106)||(LA169_0>=109 && LA169_0<=114)) ) {
                alt169=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("875:9: ( ']' ( '[' ']' )* arrayInitializer | expression ']' ( '[' expression ']' )* ( '[' ']' )* )", 169, 0, input);

                throw nvae;
            }
            switch (alt169) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:875:13: ']' ( '[' ']' )* arrayInitializer
                    {
                    match(input,43,FOLLOW_43_in_arrayCreatorRest4915); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:875:17: ( '[' ']' )*
                    loop166:
                    do {
                        int alt166=2;
                        int LA166_0 = input.LA(1);

                        if ( (LA166_0==42) ) {
                            alt166=1;
                        }


                        switch (alt166) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:875:18: '[' ']'
                    	    {
                    	    match(input,42,FOLLOW_42_in_arrayCreatorRest4918); if (failed) return ;
                    	    match(input,43,FOLLOW_43_in_arrayCreatorRest4920); if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop166;
                        }
                    } while (true);

                    pushFollow(FOLLOW_arrayInitializer_in_arrayCreatorRest4924);
                    arrayInitializer();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:876:13: expression ']' ( '[' expression ']' )* ( '[' ']' )*
                    {
                    pushFollow(FOLLOW_expression_in_arrayCreatorRest4938);
                    expression();
                    _fsp--;
                    if (failed) return ;
                    match(input,43,FOLLOW_43_in_arrayCreatorRest4940); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:876:28: ( '[' expression ']' )*
                    loop167:
                    do {
                        int alt167=2;
                        int LA167_0 = input.LA(1);

                        if ( (LA167_0==42) ) {
                            switch ( input.LA(2) ) {
                            case 105:
                                {
                                int LA167_33 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 106:
                                {
                                int LA167_34 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 109:
                                {
                                int LA167_35 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 110:
                                {
                                int LA167_36 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 111:
                                {
                                int LA167_37 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 112:
                                {
                                int LA167_38 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 66:
                                {
                                int LA167_39 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 34:
                                {
                                int LA167_40 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 113:
                                {
                                int LA167_41 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 65:
                                {
                                int LA167_42 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case HexLiteral:
                                {
                                int LA167_43 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case OctalLiteral:
                                {
                                int LA167_44 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case DecimalLiteral:
                                {
                                int LA167_45 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case FloatingPointLiteral:
                                {
                                int LA167_46 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case CharacterLiteral:
                                {
                                int LA167_47 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case StringLiteral:
                                {
                                int LA167_48 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 70:
                                {
                                int LA167_49 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 71:
                                {
                                int LA167_50 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 69:
                                {
                                int LA167_51 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 114:
                                {
                                int LA167_52 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case Identifier:
                                {
                                int LA167_53 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 56:
                                {
                                int LA167_54 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 57:
                                {
                                int LA167_55 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 58:
                                {
                                int LA167_56 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 59:
                                {
                                int LA167_57 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 60:
                                {
                                int LA167_58 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 61:
                                {
                                int LA167_59 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 62:
                                {
                                int LA167_60 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 63:
                                {
                                int LA167_61 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;
                            case 41:
                                {
                                int LA167_62 = input.LA(3);

                                if ( (synpred258()) ) {
                                    alt167=1;
                                }


                                }
                                break;

                            }

                        }


                        switch (alt167) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:876:29: '[' expression ']'
                    	    {
                    	    match(input,42,FOLLOW_42_in_arrayCreatorRest4943); if (failed) return ;
                    	    pushFollow(FOLLOW_expression_in_arrayCreatorRest4945);
                    	    expression();
                    	    _fsp--;
                    	    if (failed) return ;
                    	    match(input,43,FOLLOW_43_in_arrayCreatorRest4947); if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop167;
                        }
                    } while (true);

                    // src/com/epijava/grammar/EpiJava.g:876:50: ( '[' ']' )*
                    loop168:
                    do {
                        int alt168=2;
                        int LA168_0 = input.LA(1);

                        if ( (LA168_0==42) ) {
                            int LA168_2 = input.LA(2);

                            if ( (LA168_2==43) ) {
                                alt168=1;
                            }


                        }


                        switch (alt168) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:876:51: '[' ']'
                    	    {
                    	    match(input,42,FOLLOW_42_in_arrayCreatorRest4952); if (failed) return ;
                    	    match(input,43,FOLLOW_43_in_arrayCreatorRest4954); if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop168;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 127, arrayCreatorRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end arrayCreatorRest


    // $ANTLR start classCreatorRest
    // src/com/epijava/grammar/EpiJava.g:880:1: classCreatorRest : arguments ( classBody[null] )? ;
    public final void classCreatorRest() throws RecognitionException {
        int classCreatorRest_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 128) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:881:2: ( arguments ( classBody[null] )? )
            // src/com/epijava/grammar/EpiJava.g:881:4: arguments ( classBody[null] )?
            {
            pushFollow(FOLLOW_arguments_in_classCreatorRest4977);
            arguments();
            _fsp--;
            if (failed) return ;
            // src/com/epijava/grammar/EpiJava.g:881:14: ( classBody[null] )?
            int alt170=2;
            int LA170_0 = input.LA(1);

            if ( (LA170_0==38) ) {
                alt170=1;
            }
            switch (alt170) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:0:0: classBody[null]
                    {
                    pushFollow(FOLLOW_classBody_in_classCreatorRest4979);
                    classBody(null);
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 128, classCreatorRest_StartIndex); }
        }
        return ;
    }
    // $ANTLR end classCreatorRest


    // $ANTLR start explicitGenericInvocation
    // src/com/epijava/grammar/EpiJava.g:884:1: explicitGenericInvocation : nonWildcardTypeArguments explicitGenericInvocationSuffix ;
    public final void explicitGenericInvocation() throws RecognitionException {
        int explicitGenericInvocation_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 129) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:885:2: ( nonWildcardTypeArguments explicitGenericInvocationSuffix )
            // src/com/epijava/grammar/EpiJava.g:885:4: nonWildcardTypeArguments explicitGenericInvocationSuffix
            {
            pushFollow(FOLLOW_nonWildcardTypeArguments_in_explicitGenericInvocation4993);
            nonWildcardTypeArguments();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_explicitGenericInvocationSuffix_in_explicitGenericInvocation4995);
            explicitGenericInvocationSuffix();
            _fsp--;
            if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 129, explicitGenericInvocation_StartIndex); }
        }
        return ;
    }
    // $ANTLR end explicitGenericInvocation


    // $ANTLR start nonWildcardTypeArguments
    // src/com/epijava/grammar/EpiJava.g:888:1: nonWildcardTypeArguments : '<' typeList '>' ;
    public final void nonWildcardTypeArguments() throws RecognitionException {
        int nonWildcardTypeArguments_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 130) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:889:2: ( '<' typeList '>' )
            // src/com/epijava/grammar/EpiJava.g:889:4: '<' typeList '>'
            {
            match(input,34,FOLLOW_34_in_nonWildcardTypeArguments5007); if (failed) return ;
            pushFollow(FOLLOW_typeList_in_nonWildcardTypeArguments5009);
            typeList();
            _fsp--;
            if (failed) return ;
            match(input,36,FOLLOW_36_in_nonWildcardTypeArguments5011); if (failed) return ;

            }

        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 130, nonWildcardTypeArguments_StartIndex); }
        }
        return ;
    }
    // $ANTLR end nonWildcardTypeArguments


    // $ANTLR start explicitGenericInvocationSuffix
    // src/com/epijava/grammar/EpiJava.g:892:1: explicitGenericInvocationSuffix : ( 'super' superSuffix | Identifier arguments );
    public final void explicitGenericInvocationSuffix() throws RecognitionException {
        int explicitGenericInvocationSuffix_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 131) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:893:2: ( 'super' superSuffix | Identifier arguments )
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==65) ) {
                alt171=1;
            }
            else if ( (LA171_0==Identifier) ) {
                alt171=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("892:1: explicitGenericInvocationSuffix : ( 'super' superSuffix | Identifier arguments );", 171, 0, input);

                throw nvae;
            }
            switch (alt171) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:893:4: 'super' superSuffix
                    {
                    match(input,65,FOLLOW_65_in_explicitGenericInvocationSuffix5023); if (failed) return ;
                    pushFollow(FOLLOW_superSuffix_in_explicitGenericInvocationSuffix5025);
                    superSuffix();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:894:6: Identifier arguments
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_explicitGenericInvocationSuffix5032); if (failed) return ;
                    pushFollow(FOLLOW_arguments_in_explicitGenericInvocationSuffix5034);
                    arguments();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 131, explicitGenericInvocationSuffix_StartIndex); }
        }
        return ;
    }
    // $ANTLR end explicitGenericInvocationSuffix


    // $ANTLR start selector
    // src/com/epijava/grammar/EpiJava.g:897:1: selector : ( '.' Identifier ( arguments )? | '.' 'this' | '.' 'super' superSuffix | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | '[' expression ']' );
    public final void selector() throws RecognitionException {
        int selector_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 132) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:898:2: ( '.' Identifier ( arguments )? | '.' 'this' | '.' 'super' superSuffix | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | '[' expression ']' )
            int alt174=5;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==29) ) {
                switch ( input.LA(2) ) {
                case 113:
                    {
                    alt174=2;
                    }
                    break;
                case Identifier:
                    {
                    alt174=1;
                    }
                    break;
                case 114:
                    {
                    alt174=4;
                    }
                    break;
                case 65:
                    {
                    alt174=3;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("897:1: selector : ( '.' Identifier ( arguments )? | '.' 'this' | '.' 'super' superSuffix | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | '[' expression ']' );", 174, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA174_0==42) ) {
                alt174=5;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("897:1: selector : ( '.' Identifier ( arguments )? | '.' 'this' | '.' 'super' superSuffix | '.' 'new' ( nonWildcardTypeArguments )? innerCreator | '[' expression ']' );", 174, 0, input);

                throw nvae;
            }
            switch (alt174) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:898:4: '.' Identifier ( arguments )?
                    {
                    match(input,29,FOLLOW_29_in_selector5046); if (failed) return ;
                    match(input,Identifier,FOLLOW_Identifier_in_selector5048); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:898:19: ( arguments )?
                    int alt172=2;
                    int LA172_0 = input.LA(1);

                    if ( (LA172_0==66) ) {
                        alt172=1;
                    }
                    switch (alt172) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:898:20: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_selector5051);
                            arguments();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:899:6: '.' 'this'
                    {
                    match(input,29,FOLLOW_29_in_selector5060); if (failed) return ;
                    match(input,113,FOLLOW_113_in_selector5062); if (failed) return ;

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:900:6: '.' 'super' superSuffix
                    {
                    match(input,29,FOLLOW_29_in_selector5069); if (failed) return ;
                    match(input,65,FOLLOW_65_in_selector5071); if (failed) return ;
                    pushFollow(FOLLOW_superSuffix_in_selector5073);
                    superSuffix();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:901:6: '.' 'new' ( nonWildcardTypeArguments )? innerCreator
                    {
                    match(input,29,FOLLOW_29_in_selector5080); if (failed) return ;
                    match(input,114,FOLLOW_114_in_selector5082); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:901:16: ( nonWildcardTypeArguments )?
                    int alt173=2;
                    int LA173_0 = input.LA(1);

                    if ( (LA173_0==34) ) {
                        alt173=1;
                    }
                    switch (alt173) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:901:17: nonWildcardTypeArguments
                            {
                            pushFollow(FOLLOW_nonWildcardTypeArguments_in_selector5085);
                            nonWildcardTypeArguments();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_innerCreator_in_selector5089);
                    innerCreator();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 5 :
                    // src/com/epijava/grammar/EpiJava.g:902:6: '[' expression ']'
                    {
                    match(input,42,FOLLOW_42_in_selector5096); if (failed) return ;
                    pushFollow(FOLLOW_expression_in_selector5098);
                    expression();
                    _fsp--;
                    if (failed) return ;
                    match(input,43,FOLLOW_43_in_selector5100); if (failed) return ;

                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 132, selector_StartIndex); }
        }
        return ;
    }
    // $ANTLR end selector


    // $ANTLR start superSuffix
    // src/com/epijava/grammar/EpiJava.g:905:1: superSuffix : ( arguments | '.' Identifier ( arguments )? );
    public final void superSuffix() throws RecognitionException {
        int superSuffix_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 133) ) { return ; }
            // src/com/epijava/grammar/EpiJava.g:906:2: ( arguments | '.' Identifier ( arguments )? )
            int alt176=2;
            int LA176_0 = input.LA(1);

            if ( (LA176_0==66) ) {
                alt176=1;
            }
            else if ( (LA176_0==29) ) {
                alt176=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("905:1: superSuffix : ( arguments | '.' Identifier ( arguments )? );", 176, 0, input);

                throw nvae;
            }
            switch (alt176) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:906:4: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_superSuffix5112);
                    arguments();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:907:6: '.' Identifier ( arguments )?
                    {
                    match(input,29,FOLLOW_29_in_superSuffix5119); if (failed) return ;
                    match(input,Identifier,FOLLOW_Identifier_in_superSuffix5121); if (failed) return ;
                    // src/com/epijava/grammar/EpiJava.g:907:21: ( arguments )?
                    int alt175=2;
                    int LA175_0 = input.LA(1);

                    if ( (LA175_0==66) ) {
                        alt175=1;
                    }
                    switch (alt175) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:907:22: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_superSuffix5124);
                            arguments();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 133, superSuffix_StartIndex); }
        }
        return ;
    }
    // $ANTLR end superSuffix


    // $ANTLR start arguments
    // src/com/epijava/grammar/EpiJava.g:910:1: arguments returns [List<Expression> r] : '(' (r_= expressionList )? ')' ;
    public final List<Expression> arguments() throws RecognitionException {
        List<Expression> r = null;
        int arguments_StartIndex = input.index();
        List<Expression> r_ = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 134) ) { return r; }
            // src/com/epijava/grammar/EpiJava.g:912:2: ( '(' (r_= expressionList )? ')' )
            // src/com/epijava/grammar/EpiJava.g:912:4: '(' (r_= expressionList )? ')'
            {
            match(input,66,FOLLOW_66_in_arguments5148); if (failed) return r;
            // src/com/epijava/grammar/EpiJava.g:912:8: (r_= expressionList )?
            int alt177=2;
            int LA177_0 = input.LA(1);

            if ( (LA177_0==Identifier||(LA177_0>=FloatingPointLiteral && LA177_0<=DecimalLiteral)||LA177_0==34||LA177_0==41||(LA177_0>=56 && LA177_0<=63)||(LA177_0>=65 && LA177_0<=66)||(LA177_0>=69 && LA177_0<=71)||(LA177_0>=105 && LA177_0<=106)||(LA177_0>=109 && LA177_0<=114)) ) {
                alt177=1;
            }
            switch (alt177) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:912:9: r_= expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_arguments5153);
                    r_=expressionList();
                    _fsp--;
                    if (failed) return r;
                    if ( backtracking==0 ) {
                      r=r_;
                    }

                    }
                    break;

            }

            match(input,67,FOLLOW_67_in_arguments5159); if (failed) return r;

            }

            if ( backtracking==0 ) {
               if (r == null) r = new ArrayList<Expression>(); 
            }
        }

          catch (RecognitionException e) {
            throw e;
          }
        finally {
            if ( backtracking>0 ) { memoize(input, 134, arguments_StartIndex); }
        }
        return r;
    }
    // $ANTLR end arguments

    // $ANTLR start synpred6
    public final void synpred6_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:199:10: ( typeDeclaration )
        // src/com/epijava/grammar/EpiJava.g:199:10: typeDeclaration
        {
        pushFollow(FOLLOW_typeDeclaration_in_synpred6383);
        typeDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred6

    // $ANTLR start synpred36
    public final void synpred36_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:294:4: ( methodDeclaration )
        // src/com/epijava/grammar/EpiJava.g:294:4: methodDeclaration
        {
        pushFollow(FOLLOW_methodDeclaration_in_synpred36968);
        methodDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred36

    // $ANTLR start synpred37
    public final void synpred37_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:295:4: ( fieldDeclaration )
        // src/com/epijava/grammar/EpiJava.g:295:4: fieldDeclaration
        {
        pushFollow(FOLLOW_fieldDeclaration_in_synpred37975);
        fieldDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred37

    // $ANTLR start synpred83
    public final void synpred83_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:432:16: ( '.' Identifier )
        // src/com/epijava/grammar/EpiJava.g:432:16: '.' Identifier
        {
        match(input,29,FOLLOW_29_in_synpred831808); if (failed) return ;
        match(input,Identifier,FOLLOW_Identifier_in_synpred831810); if (failed) return ;

        }
    }
    // $ANTLR end synpred83

    // $ANTLR start synpred109
    public final void synpred109_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:524:10: ( '.' Identifier )
        // src/com/epijava/grammar/EpiJava.g:524:10: '.' Identifier
        {
        match(input,29,FOLLOW_29_in_synpred1092375); if (failed) return ;
        match(input,Identifier,FOLLOW_Identifier_in_synpred1092379); if (failed) return ;

        }
    }
    // $ANTLR end synpred109

    // $ANTLR start synpred118
    public final void synpred118_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:550:4: ( annotation )
        // src/com/epijava/grammar/EpiJava.g:550:4: annotation
        {
        pushFollow(FOLLOW_annotation_in_synpred1182576);
        annotation();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred118

    // $ANTLR start synpred120
    public final void synpred120_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:554:24: ( '(' ( elementValuePairs )? ')' )
        // src/com/epijava/grammar/EpiJava.g:554:24: '(' ( elementValuePairs )? ')'
        {
        match(input,66,FOLLOW_66_in_synpred1202593); if (failed) return ;
        // src/com/epijava/grammar/EpiJava.g:554:28: ( elementValuePairs )?
        int alt191=2;
        int LA191_0 = input.LA(1);

        if ( (LA191_0==Identifier||(LA191_0>=FloatingPointLiteral && LA191_0<=DecimalLiteral)||LA191_0==34||LA191_0==38||LA191_0==41||(LA191_0>=56 && LA191_0<=63)||(LA191_0>=65 && LA191_0<=66)||(LA191_0>=69 && LA191_0<=72)||(LA191_0>=105 && LA191_0<=106)||(LA191_0>=109 && LA191_0<=114)) ) {
            alt191=1;
        }
        switch (alt191) {
            case 1 :
                // src/com/epijava/grammar/EpiJava.g:0:0: elementValuePairs
                {
                pushFollow(FOLLOW_elementValuePairs_in_synpred1202595);
                elementValuePairs();
                _fsp--;
                if (failed) return ;

                }
                break;

        }

        match(input,67,FOLLOW_67_in_synpred1202598); if (failed) return ;

        }
    }
    // $ANTLR end synpred120

    // $ANTLR start synpred133
    public final void synpred133_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:597:6: ( classDeclaration ( ';' )? )
        // src/com/epijava/grammar/EpiJava.g:597:6: classDeclaration ( ';' )?
        {
        pushFollow(FOLLOW_classDeclaration_in_synpred1332806);
        classDeclaration();
        _fsp--;
        if (failed) return ;
        // src/com/epijava/grammar/EpiJava.g:597:23: ( ';' )?
        int alt193=2;
        int LA193_0 = input.LA(1);

        if ( (LA193_0==26) ) {
            alt193=1;
        }
        switch (alt193) {
            case 1 :
                // src/com/epijava/grammar/EpiJava.g:0:0: ';'
                {
                match(input,26,FOLLOW_26_in_synpred1332808); if (failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred133

    // $ANTLR start synpred135
    public final void synpred135_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:598:6: ( interfaceDeclaration ( ';' )? )
        // src/com/epijava/grammar/EpiJava.g:598:6: interfaceDeclaration ( ';' )?
        {
        pushFollow(FOLLOW_interfaceDeclaration_in_synpred1352816);
        interfaceDeclaration();
        _fsp--;
        if (failed) return ;
        // src/com/epijava/grammar/EpiJava.g:598:27: ( ';' )?
        int alt194=2;
        int LA194_0 = input.LA(1);

        if ( (LA194_0==26) ) {
            alt194=1;
        }
        switch (alt194) {
            case 1 :
                // src/com/epijava/grammar/EpiJava.g:0:0: ';'
                {
                match(input,26,FOLLOW_26_in_synpred1352818); if (failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred135

    // $ANTLR start synpred137
    public final void synpred137_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:599:6: ( enumDeclaration ( ';' )? )
        // src/com/epijava/grammar/EpiJava.g:599:6: enumDeclaration ( ';' )?
        {
        pushFollow(FOLLOW_enumDeclaration_in_synpred1372826);
        enumDeclaration();
        _fsp--;
        if (failed) return ;
        // src/com/epijava/grammar/EpiJava.g:599:22: ( ';' )?
        int alt195=2;
        int LA195_0 = input.LA(1);

        if ( (LA195_0==26) ) {
            alt195=1;
        }
        switch (alt195) {
            case 1 :
                // src/com/epijava/grammar/EpiJava.g:0:0: ';'
                {
                match(input,26,FOLLOW_26_in_synpred1372828); if (failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred137

    // $ANTLR start synpred142
    public final void synpred142_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:630:4: ( localVariableDeclaration )
        // src/com/epijava/grammar/EpiJava.g:630:4: localVariableDeclaration
        {
        pushFollow(FOLLOW_localVariableDeclaration_in_synpred1422977);
        localVariableDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred142

    // $ANTLR start synpred143
    public final void synpred143_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:631:4: ( classOrInterfaceDeclaration )
        // src/com/epijava/grammar/EpiJava.g:631:4: classOrInterfaceDeclaration
        {
        pushFollow(FOLLOW_classOrInterfaceDeclaration_in_synpred1432982);
        classOrInterfaceDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred143

    // $ANTLR start synpred144
    public final void synpred144_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:636:9: ( localVariableDeclaration )
        // src/com/epijava/grammar/EpiJava.g:636:9: localVariableDeclaration
        {
        pushFollow(FOLLOW_localVariableDeclaration_in_synpred1443016);
        localVariableDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred144

    // $ANTLR start synpred149
    public final void synpred149_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:648:52: ( 'else' statement )
        // src/com/epijava/grammar/EpiJava.g:648:52: 'else' statement
        {
        match(input,77,FOLLOW_77_in_synpred1493116); if (failed) return ;
        pushFollow(FOLLOW_statement_in_synpred1493118);
        statement();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred149

    // $ANTLR start synpred154
    public final void synpred154_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:653:9: ( catches 'finally' block )
        // src/com/epijava/grammar/EpiJava.g:653:9: catches 'finally' block
        {
        pushFollow(FOLLOW_catches_in_synpred1543184);
        catches();
        _fsp--;
        if (failed) return ;
        match(input,82,FOLLOW_82_in_synpred1543186); if (failed) return ;
        pushFollow(FOLLOW_block_in_synpred1543188);
        block();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred154

    // $ANTLR start synpred155
    public final void synpred155_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:654:9: ( catches )
        // src/com/epijava/grammar/EpiJava.g:654:9: catches
        {
        pushFollow(FOLLOW_catches_in_synpred1553198);
        catches();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred155

    // $ANTLR start synpred172
    public final void synpred172_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:689:4: ( 'case' constantExpression ':' )
        // src/com/epijava/grammar/EpiJava.g:689:4: 'case' constantExpression ':'
        {
        match(input,89,FOLLOW_89_in_synpred1723427); if (failed) return ;
        pushFollow(FOLLOW_constantExpression_in_synpred1723429);
        constantExpression();
        _fsp--;
        if (failed) return ;
        match(input,75,FOLLOW_75_in_synpred1723431); if (failed) return ;

        }
    }
    // $ANTLR end synpred172

    // $ANTLR start synpred173
    public final void synpred173_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:690:6: ( 'case' enumConstantName ':' )
        // src/com/epijava/grammar/EpiJava.g:690:6: 'case' enumConstantName ':'
        {
        match(input,89,FOLLOW_89_in_synpred1733438); if (failed) return ;
        pushFollow(FOLLOW_enumConstantName_in_synpred1733440);
        enumConstantName();
        _fsp--;
        if (failed) return ;
        match(input,75,FOLLOW_75_in_synpred1733442); if (failed) return ;

        }
    }
    // $ANTLR end synpred173

    // $ANTLR start synpred175
    public final void synpred175_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:700:4: ( forVarControl )
        // src/com/epijava/grammar/EpiJava.g:700:4: forVarControl
        {
        pushFollow(FOLLOW_forVarControl_in_synpred1753487);
        forVarControl();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred175

    // $ANTLR start synpred180
    public final void synpred180_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:705:4: ( ( variableModifier )* type variableDeclarators )
        // src/com/epijava/grammar/EpiJava.g:705:4: ( variableModifier )* type variableDeclarators
        {
        // src/com/epijava/grammar/EpiJava.g:705:4: ( variableModifier )*
        loop202:
        do {
            int alt202=2;
            int LA202_0 = input.LA(1);

            if ( (LA202_0==50||LA202_0==72) ) {
                alt202=1;
            }


            switch (alt202) {
        	case 1 :
        	    // src/com/epijava/grammar/EpiJava.g:0:0: variableModifier
        	    {
        	    pushFollow(FOLLOW_variableModifier_in_synpred1803514);
        	    variableModifier();
        	    _fsp--;
        	    if (failed) return ;

        	    }
        	    break;

        	default :
        	    break loop202;
            }
        } while (true);

        pushFollow(FOLLOW_type_in_synpred1803517);
        type();
        _fsp--;
        if (failed) return ;
        pushFollow(FOLLOW_variableDeclarators_in_synpred1803519);
        variableDeclarators();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred180

    // $ANTLR start synpred183
    public final void synpred183_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:737:38: ( assignmentOperator expression )
        // src/com/epijava/grammar/EpiJava.g:737:38: assignmentOperator expression
        {
        pushFollow(FOLLOW_assignmentOperator_in_synpred1833686);
        assignmentOperator();
        _fsp--;
        if (failed) return ;
        pushFollow(FOLLOW_expression_in_synpred1833688);
        expression();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred183

    // $ANTLR start synpred194
    public final void synpred194_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:751:9: ( '>' '>' '=' )
        // src/com/epijava/grammar/EpiJava.g:751:9: '>' '>' '='
        {
        match(input,36,FOLLOW_36_in_synpred1943806); if (failed) return ;
        match(input,36,FOLLOW_36_in_synpred1943808); if (failed) return ;
        match(input,45,FOLLOW_45_in_synpred1943810); if (failed) return ;

        }
    }
    // $ANTLR end synpred194

    // $ANTLR start synpred204
    public final void synpred204_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:788:40: ( relationalOp shiftExpression )
        // src/com/epijava/grammar/EpiJava.g:788:40: relationalOp shiftExpression
        {
        pushFollow(FOLLOW_relationalOp_in_synpred2044126);
        relationalOp();
        _fsp--;
        if (failed) return ;
        pushFollow(FOLLOW_shiftExpression_in_synpred2044128);
        shiftExpression();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred204

    // $ANTLR start synpred208
    public final void synpred208_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:796:43: ( shiftOp additiveExpression )
        // src/com/epijava/grammar/EpiJava.g:796:43: shiftOp additiveExpression
        {
        pushFollow(FOLLOW_shiftOp_in_synpred2084189);
        shiftOp();
        _fsp--;
        if (failed) return ;
        pushFollow(FOLLOW_additiveExpression_in_synpred2084191);
        additiveExpression();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred208

    // $ANTLR start synpred210
    public final void synpred210_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:801:15: ( '>' '>' '>' )
        // src/com/epijava/grammar/EpiJava.g:801:15: '>' '>' '>'
        {
        match(input,36,FOLLOW_36_in_synpred2104221); if (failed) return ;
        match(input,36,FOLLOW_36_in_synpred2104223); if (failed) return ;
        match(input,36,FOLLOW_36_in_synpred2104225); if (failed) return ;

        }
    }
    // $ANTLR end synpred210

    // $ANTLR start synpred222
    public final void synpred222_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:824:9: ( castExpression )
        // src/com/epijava/grammar/EpiJava.g:824:9: castExpression
        {
        pushFollow(FOLLOW_castExpression_in_synpred2224434);
        castExpression();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred222

    // $ANTLR start synpred226
    public final void synpred226_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:829:8: ( '(' primitiveType ')' unaryExpression )
        // src/com/epijava/grammar/EpiJava.g:829:8: '(' primitiveType ')' unaryExpression
        {
        match(input,66,FOLLOW_66_in_synpred2264476); if (failed) return ;
        pushFollow(FOLLOW_primitiveType_in_synpred2264478);
        primitiveType();
        _fsp--;
        if (failed) return ;
        match(input,67,FOLLOW_67_in_synpred2264480); if (failed) return ;
        pushFollow(FOLLOW_unaryExpression_in_synpred2264482);
        unaryExpression();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred226

    // $ANTLR start synpred227
    public final void synpred227_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:830:13: ( type )
        // src/com/epijava/grammar/EpiJava.g:830:13: type
        {
        pushFollow(FOLLOW_type_in_synpred2274494);
        type();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred227

    // $ANTLR start synpred231
    public final void synpred231_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:837:17: ( '.' Identifier )
        // src/com/epijava/grammar/EpiJava.g:837:17: '.' Identifier
        {
        match(input,29,FOLLOW_29_in_synpred2314568); if (failed) return ;
        match(input,Identifier,FOLLOW_Identifier_in_synpred2314570); if (failed) return ;

        }
    }
    // $ANTLR end synpred231

    // $ANTLR start synpred241
    public final void synpred241_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:848:5: ( '[' expression ']' )
        // src/com/epijava/grammar/EpiJava.g:848:5: '[' expression ']'
        {
        match(input,42,FOLLOW_42_in_synpred2414700); if (failed) return ;
        pushFollow(FOLLOW_expression_in_synpred2414702);
        expression();
        _fsp--;
        if (failed) return ;
        match(input,43,FOLLOW_43_in_synpred2414704); if (failed) return ;

        }
    }
    // $ANTLR end synpred241

    // $ANTLR start synpred242
    public final void synpred242_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:848:4: ( ( '[' expression ']' )+ )
        // src/com/epijava/grammar/EpiJava.g:848:4: ( '[' expression ']' )+
        {
        // src/com/epijava/grammar/EpiJava.g:848:4: ( '[' expression ']' )+
        int cnt207=0;
        loop207:
        do {
            int alt207=2;
            int LA207_0 = input.LA(1);

            if ( (LA207_0==42) ) {
                alt207=1;
            }


            switch (alt207) {
        	case 1 :
        	    // src/com/epijava/grammar/EpiJava.g:848:5: '[' expression ']'
        	    {
        	    match(input,42,FOLLOW_42_in_synpred2424700); if (failed) return ;
        	    pushFollow(FOLLOW_expression_in_synpred2424702);
        	    expression();
        	    _fsp--;
        	    if (failed) return ;
        	    match(input,43,FOLLOW_43_in_synpred2424704); if (failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt207 >= 1 ) break loop207;
        	    if (backtracking>0) {failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(207, input);
                    throw eee;
            }
            cnt207++;
        } while (true);


        }
    }
    // $ANTLR end synpred242

    // $ANTLR start synpred246
    public final void synpred246_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:852:9: ( '.' 'this' )
        // src/com/epijava/grammar/EpiJava.g:852:9: '.' 'this'
        {
        match(input,29,FOLLOW_29_in_synpred2464755); if (failed) return ;
        match(input,113,FOLLOW_113_in_synpred2464757); if (failed) return ;

        }
    }
    // $ANTLR end synpred246

    // $ANTLR start synpred247
    public final void synpred247_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:853:9: ( '.' 'super' arguments )
        // src/com/epijava/grammar/EpiJava.g:853:9: '.' 'super' arguments
        {
        match(input,29,FOLLOW_29_in_synpred2474767); if (failed) return ;
        match(input,65,FOLLOW_65_in_synpred2474769); if (failed) return ;
        pushFollow(FOLLOW_arguments_in_synpred2474771);
        arguments();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred247

    // $ANTLR start synpred249
    public final void synpred249_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:854:9: ( '.' 'new' ( nonWildcardTypeArguments )? innerCreator )
        // src/com/epijava/grammar/EpiJava.g:854:9: '.' 'new' ( nonWildcardTypeArguments )? innerCreator
        {
        match(input,29,FOLLOW_29_in_synpred2494781); if (failed) return ;
        match(input,114,FOLLOW_114_in_synpred2494783); if (failed) return ;
        // src/com/epijava/grammar/EpiJava.g:854:19: ( nonWildcardTypeArguments )?
        int alt208=2;
        int LA208_0 = input.LA(1);

        if ( (LA208_0==34) ) {
            alt208=1;
        }
        switch (alt208) {
            case 1 :
                // src/com/epijava/grammar/EpiJava.g:854:20: nonWildcardTypeArguments
                {
                pushFollow(FOLLOW_nonWildcardTypeArguments_in_synpred2494786);
                nonWildcardTypeArguments();
                _fsp--;
                if (failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_innerCreator_in_synpred2494790);
        innerCreator();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred249

    // $ANTLR start synpred258
    public final void synpred258_fragment() throws RecognitionException {   
        // src/com/epijava/grammar/EpiJava.g:876:29: ( '[' expression ']' )
        // src/com/epijava/grammar/EpiJava.g:876:29: '[' expression ']'
        {
        match(input,42,FOLLOW_42_in_synpred2584943); if (failed) return ;
        pushFollow(FOLLOW_expression_in_synpred2584945);
        expression();
        _fsp--;
        if (failed) return ;
        match(input,43,FOLLOW_43_in_synpred2584947); if (failed) return ;

        }
    }
    // $ANTLR end synpred258

    public final boolean synpred143() {
        backtracking++;
        int start = input.mark();
        try {
            synpred143_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred242() {
        backtracking++;
        int start = input.mark();
        try {
            synpred242_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred37() {
        backtracking++;
        int start = input.mark();
        try {
            synpred37_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred142() {
        backtracking++;
        int start = input.mark();
        try {
            synpred142_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred120() {
        backtracking++;
        int start = input.mark();
        try {
            synpred120_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred173() {
        backtracking++;
        int start = input.mark();
        try {
            synpred173_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred109() {
        backtracking++;
        int start = input.mark();
        try {
            synpred109_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred210() {
        backtracking++;
        int start = input.mark();
        try {
            synpred210_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred155() {
        backtracking++;
        int start = input.mark();
        try {
            synpred155_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred249() {
        backtracking++;
        int start = input.mark();
        try {
            synpred249_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred227() {
        backtracking++;
        int start = input.mark();
        try {
            synpred227_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred246() {
        backtracking++;
        int start = input.mark();
        try {
            synpred246_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred175() {
        backtracking++;
        int start = input.mark();
        try {
            synpred175_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred154() {
        backtracking++;
        int start = input.mark();
        try {
            synpred154_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred133() {
        backtracking++;
        int start = input.mark();
        try {
            synpred133_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred36() {
        backtracking++;
        int start = input.mark();
        try {
            synpred36_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred222() {
        backtracking++;
        int start = input.mark();
        try {
            synpred222_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred208() {
        backtracking++;
        int start = input.mark();
        try {
            synpred208_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred241() {
        backtracking++;
        int start = input.mark();
        try {
            synpred241_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred118() {
        backtracking++;
        int start = input.mark();
        try {
            synpred118_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred83() {
        backtracking++;
        int start = input.mark();
        try {
            synpred83_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred231() {
        backtracking++;
        int start = input.mark();
        try {
            synpred231_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred135() {
        backtracking++;
        int start = input.mark();
        try {
            synpred135_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred258() {
        backtracking++;
        int start = input.mark();
        try {
            synpred258_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred247() {
        backtracking++;
        int start = input.mark();
        try {
            synpred247_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred180() {
        backtracking++;
        int start = input.mark();
        try {
            synpred180_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred137() {
        backtracking++;
        int start = input.mark();
        try {
            synpred137_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred172() {
        backtracking++;
        int start = input.mark();
        try {
            synpred172_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred183() {
        backtracking++;
        int start = input.mark();
        try {
            synpred183_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred194() {
        backtracking++;
        int start = input.mark();
        try {
            synpred194_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred6() {
        backtracking++;
        int start = input.mark();
        try {
            synpred6_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred226() {
        backtracking++;
        int start = input.mark();
        try {
            synpred226_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred144() {
        backtracking++;
        int start = input.mark();
        try {
            synpred144_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred149() {
        backtracking++;
        int start = input.mark();
        try {
            synpred149_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred204() {
        backtracking++;
        int start = input.mark();
        try {
            synpred204_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_annotations_in_compilationUnit73 = new BitSet(new long[]{0xFFFFC3449E000FF2L,0x0007E60000FBD5E6L});
    public static final BitSet FOLLOW_packageDeclaration_in_compilationUnit79 = new BitSet(new long[]{0xFFFFC3449C000FF2L,0x0007E60000FBD5E6L});
    public static final BitSet FOLLOW_importDeclarations_in_compilationUnit92 = new BitSet(new long[]{0xFFFFC34494000FF2L,0x0007E60000FBD5E6L});
    public static final BitSet FOLLOW_typeDeclarations_in_compilationUnit104 = new BitSet(new long[]{0xFF14024404000FD2L,0x0007E60000FBD5E6L});
    public static final BitSet FOLLOW_topLevelStatements_in_compilationUnit174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelStatement_in_topLevelStatements208 = new BitSet(new long[]{0xFF14024404000FD2L,0x0007E60000FBD5E6L});
    public static final BitSet FOLLOW_25_in_packageDeclaration239 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qualifiedName_in_packageDeclaration243 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_packageDeclaration245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importDeclaration_in_importDeclarations278 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_importDeclaration320 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_28_in_importDeclaration323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qualifiedName_in_importDeclaration339 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_29_in_importDeclaration342 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_importDeclaration344 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_importDeclaration350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDeclaration_in_typeDeclarations383 = new BitSet(new long[]{0x00FFC10094000022L,0x0000000000000100L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_typeDeclaration416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_typeDeclaration426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_classOrInterfaceDeclaration458 = new BitSet(new long[]{0x00FFC10090000020L,0x0000000000000100L});
    public static final BitSet FOLLOW_classDeclaration_in_classOrInterfaceDeclaration464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_classOrInterfaceDeclaration470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_classDeclaration498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_classDeclaration508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_normalClassDeclaration526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_normalClassDeclaration530 = new BitSet(new long[]{0x0000004700000000L});
    public static final BitSet FOLLOW_typeParameters_in_normalClassDeclaration533 = new BitSet(new long[]{0x0000004300000000L});
    public static final BitSet FOLLOW_32_in_normalClassDeclaration555 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_type_in_normalClassDeclaration559 = new BitSet(new long[]{0x0000004200000000L});
    public static final BitSet FOLLOW_33_in_normalClassDeclaration574 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_typeList_in_normalClassDeclaration578 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_classBody_in_normalClassDeclaration592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_typeParameters605 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_typeParameter_in_typeParameters607 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_typeParameters610 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_typeParameter_in_typeParameters612 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_typeParameters616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_typeParameter627 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_typeParameter630 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_bound_in_typeParameter632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_bound647 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_bound650 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_type_in_bound652 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ENUM_in_enumDeclaration665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_enumDeclaration667 = new BitSet(new long[]{0x0000004200000000L});
    public static final BitSet FOLLOW_33_in_enumDeclaration670 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_typeList_in_enumDeclaration672 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_enumBody_in_enumDeclaration676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_enumBody688 = new BitSet(new long[]{0x0000008804000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_enumConstants_in_enumBody690 = new BitSet(new long[]{0x0000008804000000L});
    public static final BitSet FOLLOW_35_in_enumBody693 = new BitSet(new long[]{0x0000008004000000L});
    public static final BitSet FOLLOW_enumBodyDeclarations_in_enumBody696 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_enumBody699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumConstant_in_enumConstants710 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_enumConstants713 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_enumConstant_in_enumConstants715 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_annotations_in_enumConstant729 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_enumConstant731 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_enumConstant734 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_classBody_in_enumConstant739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_enumBodyDeclarations754 = new BitSet(new long[]{0xFFFFC34494000032L,0x0000000000000100L});
    public static final BitSet FOLLOW_classBodyDeclaration_in_enumBodyDeclarations757 = new BitSet(new long[]{0xFFFFC34494000032L,0x0000000000000100L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_interfaceDeclaration775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_interfaceDeclaration781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_normalInterfaceDeclaration793 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_normalInterfaceDeclaration795 = new BitSet(new long[]{0x0000004500000000L});
    public static final BitSet FOLLOW_typeParameters_in_normalInterfaceDeclaration797 = new BitSet(new long[]{0x0000004100000000L});
    public static final BitSet FOLLOW_32_in_normalInterfaceDeclaration801 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_typeList_in_normalInterfaceDeclaration803 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_interfaceBody_in_normalInterfaceDeclaration807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeList832 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_typeList837 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_type_in_typeList841 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_38_in_classBody858 = new BitSet(new long[]{0xFFFFC3C494000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_classBodyDeclaration_in_classBody863 = new BitSet(new long[]{0xFFFFC3C494000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_39_in_classBody869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_interfaceBody881 = new BitSet(new long[]{0xFFFFC38494000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody883 = new BitSet(new long[]{0xFFFFC38494000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_39_in_interfaceBody886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_classBodyDeclaration910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_classBodyDeclaration916 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_block_in_classBodyDeclaration924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_classBodyDeclaration938 = new BitSet(new long[]{0xFFFFC30490000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_memberDecl_in_classBodyDeclaration943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genericMethodOrConstructorDecl_in_memberDecl961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDeclaration_in_memberDecl968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDeclaration_in_memberDecl975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_memberDecl980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_memberDecl982 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_voidMethodDeclaratorRest_in_memberDecl984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_memberDecl989 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_constructorDeclaratorRest_in_memberDecl991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_memberDecl996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_memberDecl1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeParameters_in_genericMethodOrConstructorDecl1017 = new BitSet(new long[]{0xFF00020000000010L});
    public static final BitSet FOLLOW_genericMethodOrConstructorRest_in_genericMethodOrConstructorDecl1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_genericMethodOrConstructorRest1032 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_41_in_genericMethodOrConstructorRest1036 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_genericMethodOrConstructorRest1039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_methodDeclaratorRest_in_genericMethodOrConstructorRest1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_genericMethodOrConstructorRest1048 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_constructorDeclaratorRest_in_genericMethodOrConstructorRest1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_methodDeclaration1067 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_methodDeclaration1071 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_methodDeclaratorRest_in_methodDeclaration1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_fieldDeclaration1094 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarators_in_fieldDeclaration1096 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_fieldDeclaration1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_interfaceBodyDeclaration1111 = new BitSet(new long[]{0xFFFFC30490000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_interfaceMemberDecl_in_interfaceBodyDeclaration1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceMethodOrFieldDecl_in_interfaceMemberDecl1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceGenericMethodDecl_in_interfaceMemberDecl1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_interfaceMemberDecl1149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceMemberDecl1151 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_voidInterfaceMethodDeclaratorRest_in_interfaceMemberDecl1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_interfaceMemberDecl1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_interfaceMemberDecl1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_interfaceMethodOrFieldDecl1185 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceMethodOrFieldDecl1187 = new BitSet(new long[]{0x0000240000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_interfaceMethodOrFieldRest_in_interfaceMethodOrFieldDecl1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constantDeclaratorsRest_in_interfaceMethodOrFieldRest1201 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceMethodOrFieldRest1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceMethodDeclaratorRest_in_interfaceMethodOrFieldRest1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameters_in_methodDeclaratorRest1238 = new BitSet(new long[]{0x0000144004000000L});
    public static final BitSet FOLLOW_42_in_methodDeclaratorRest1241 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_methodDeclaratorRest1243 = new BitSet(new long[]{0x0000144004000000L});
    public static final BitSet FOLLOW_44_in_methodDeclaratorRest1256 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qualifiedNameList_in_methodDeclaratorRest1258 = new BitSet(new long[]{0x0000004004000000L});
    public static final BitSet FOLLOW_methodBody_in_methodDeclaratorRest1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_methodDeclaratorRest1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameters_in_voidMethodDeclaratorRest1320 = new BitSet(new long[]{0x0000104004000000L});
    public static final BitSet FOLLOW_44_in_voidMethodDeclaratorRest1323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qualifiedNameList_in_voidMethodDeclaratorRest1325 = new BitSet(new long[]{0x0000004004000000L});
    public static final BitSet FOLLOW_methodBody_in_voidMethodDeclaratorRest1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_voidMethodDeclaratorRest1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameters_in_interfaceMethodDeclaratorRest1377 = new BitSet(new long[]{0x0000140004000000L});
    public static final BitSet FOLLOW_42_in_interfaceMethodDeclaratorRest1380 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_interfaceMethodDeclaratorRest1382 = new BitSet(new long[]{0x0000140004000000L});
    public static final BitSet FOLLOW_44_in_interfaceMethodDeclaratorRest1387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qualifiedNameList_in_interfaceMethodDeclaratorRest1389 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceMethodDeclaratorRest1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeParameters_in_interfaceGenericMethodDecl1405 = new BitSet(new long[]{0xFF00020000000010L});
    public static final BitSet FOLLOW_type_in_interfaceGenericMethodDecl1408 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_41_in_interfaceGenericMethodDecl1412 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceGenericMethodDecl1415 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_interfaceMethodDeclaratorRest_in_interfaceGenericMethodDecl1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameters_in_voidInterfaceMethodDeclaratorRest1437 = new BitSet(new long[]{0x0000100004000000L});
    public static final BitSet FOLLOW_44_in_voidInterfaceMethodDeclaratorRest1440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qualifiedNameList_in_voidInterfaceMethodDeclaratorRest1442 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_voidInterfaceMethodDeclaratorRest1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameters_in_constructorDeclaratorRest1458 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_44_in_constructorDeclaratorRest1461 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qualifiedNameList_in_constructorDeclaratorRest1463 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_methodBody_in_constructorDeclaratorRest1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_constantDeclarator1478 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_constantDeclaratorRest_in_constantDeclarator1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators1492 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_variableDeclarators1495 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarator_in_variableDeclarators1497 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclarator1510 = new BitSet(new long[]{0x0000240000000002L});
    public static final BitSet FOLLOW_variableDeclaratorRest_in_variableDeclarator1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_variableDeclaratorRest1525 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_variableDeclaratorRest1527 = new BitSet(new long[]{0x0000240000000002L});
    public static final BitSet FOLLOW_45_in_variableDeclaratorRest1532 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_variableInitializer_in_variableDeclaratorRest1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_variableDeclaratorRest1541 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_variableInitializer_in_variableDeclaratorRest1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constantDeclaratorRest_in_constantDeclaratorsRest1563 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_constantDeclaratorsRest1566 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constantDeclarator_in_constantDeclaratorsRest1568 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_42_in_constantDeclaratorRest1585 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_constantDeclaratorRest1587 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_constantDeclaratorRest1591 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_variableInitializer_in_constantDeclaratorRest1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclaratorId1605 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_variableDeclaratorId1608 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_variableDeclaratorId1610 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_arrayInitializer_in_variableInitializer1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_variableInitializer1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_arrayInitializer1645 = new BitSet(new long[]{0xFF0002C400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer1648 = new BitSet(new long[]{0x0000008800000000L});
    public static final BitSet FOLLOW_35_in_arrayInitializer1651 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer1653 = new BitSet(new long[]{0x0000008800000000L});
    public static final BitSet FOLLOW_35_in_arrayInitializer1658 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_arrayInitializer1665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_modifier1681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_modifier1691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_modifier1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_modifier1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_modifier1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_modifier1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_modifier1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_modifier1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_modifier1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_modifier1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_modifier1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_modifier1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_packageOrTypeName1805 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_packageOrTypeName1808 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_packageOrTypeName1810 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_enumConstantName1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_typeName1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_packageOrTypeName_in_typeName1854 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_typeName1856 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_typeName1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_type1911 = new BitSet(new long[]{0x0000040420000002L});
    public static final BitSet FOLLOW_typeArguments_in_type1914 = new BitSet(new long[]{0x0000040020000002L});
    public static final BitSet FOLLOW_29_in_type1953 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_type1957 = new BitSet(new long[]{0x0000040420000002L});
    public static final BitSet FOLLOW_typeArguments_in_type1960 = new BitSet(new long[]{0x0000040020000002L});
    public static final BitSet FOLLOW_42_in_type2019 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_type2021 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type2039 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_type2049 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_type2051 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_56_in_primitiveType2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_primitiveType2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_primitiveType2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_primitiveType2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_primitiveType2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitiveType2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_variableModifier2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_variableModifier2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_typeArguments2192 = new BitSet(new long[]{0xFF00000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2194 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_typeArguments2197 = new BitSet(new long[]{0xFF00000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2199 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_typeArguments2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_typeArgument2220 = new BitSet(new long[]{0x0000000100000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeArgument2223 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_type_in_typeArgument2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList2245 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_qualifiedNameList2248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList2250 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_66_in_formalParameters2264 = new BitSet(new long[]{0xFF04000000000010L,0x0000000000000108L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters2266 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_formalParameters2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifier_in_formalParameterDecls2281 = new BitSet(new long[]{0xFF04000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls2284 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000010L});
    public static final BitSet FOLLOW_formalParameterDeclsRest_in_formalParameterDecls2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaratorId_in_formalParameterDeclsRest2299 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_formalParameterDeclsRest2302 = new BitSet(new long[]{0xFF04000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDeclsRest2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_formalParameterDeclsRest2313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaratorId_in_formalParameterDeclsRest2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_methodBody2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedName2362 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_qualifiedName2375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedName2379 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_integerLiteral_in_literal2403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloatingPointLiteral_in_literal2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CharacterLiteral_in_literal2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_literal2455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_literal2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HexLiteral_in_integerLiteral2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OctalLiteral_in_integerLiteral2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DecimalLiteral_in_integerLiteral2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_booleanLiteral2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_booleanLiteral2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2576 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_annotation2588 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation2590 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_annotation2593 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000001EEL});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2595 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_annotation2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2612 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_annotationName2615 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2617 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2631 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_elementValuePairs2634 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000001E6L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2636 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2651 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_elementValuePair2653 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000001E6L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_elementValue2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_elementValueArrayInitializer2695 = new BitSet(new long[]{0xFF0002C400000FD0L,0x0007E600000001E6L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2698 = new BitSet(new long[]{0x0000008800000000L});
    public static final BitSet FOLLOW_35_in_elementValueArrayInitializer2701 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000001E6L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2703 = new BitSet(new long[]{0x0000008800000000L});
    public static final BitSet FOLLOW_39_in_elementValueArrayInitializer2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_annotationTypeDeclaration2722 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_annotationTypeDeclaration2724 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2726 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_annotationTypeBody2740 = new BitSet(new long[]{0xFFFFC18090000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_annotationTypeElementDeclarations_in_annotationTypeBody2743 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_annotationTypeBody2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeElementDeclarations2760 = new BitSet(new long[]{0xFFFFC10090000032L,0x0000000000000100L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeElementDeclarations2764 = new BitSet(new long[]{0xFFFFC10090000032L,0x0000000000000100L});
    public static final BitSet FOLLOW_modifier_in_annotationTypeElementDeclaration2779 = new BitSet(new long[]{0xFFFFC10090000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2795 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2797 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_annotationTypeElementRest2806 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_annotationTypeElementRest2816 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_annotationTypeElementRest2826 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2836 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationConstantRest_in_annotationMethodOrConstantRest2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2871 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_annotationMethodRest2873 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_annotationMethodRest2875 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarators_in_annotationConstantRest2895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_defaultValue2910 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000001E6L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_block2932 = new BitSet(new long[]{0xFFFFC3C494000FF0L,0x0007E60000FBD5E6L});
    public static final BitSet FOLLOW_blockStatement_in_block2950 = new BitSet(new long[]{0xFFFFC3C494000FF0L,0x0007E60000FBD5E6L});
    public static final BitSet FOLLOW_39_in_block2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_blockStatement2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_blockStatement2982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_blockStatement2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_topLevelStatement3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_topLevelStatement3028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifier_in_localVariableDeclaration3046 = new BitSet(new long[]{0xFF04000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_type_in_localVariableDeclaration3049 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarators_in_localVariableDeclaration3051 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_localVariableDeclaration3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement3073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_statement3083 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_statement3085 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_statement3088 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_statement3090 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_statement3102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_parExpression_in_statement3104 = new BitSet(new long[]{0xFF10024404000FD0L,0x0007E60000FBD4E6L});
    public static final BitSet FOLLOW_statement_in_statement3106 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_statement3116 = new BitSet(new long[]{0xFF10024404000FD0L,0x0007E60000FBD4E6L});
    public static final BitSet FOLLOW_statement_in_statement3118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_statement3128 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_statement3130 = new BitSet(new long[]{0xFF04020404000FD0L,0x0007E600000001E6L});
    public static final BitSet FOLLOW_forControl_in_statement3132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_statement3134 = new BitSet(new long[]{0xFF10024404000FD0L,0x0007E60000FBD4E6L});
    public static final BitSet FOLLOW_statement_in_statement3136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_statement3144 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_parExpression_in_statement3146 = new BitSet(new long[]{0xFF10024404000FD0L,0x0007E60000FBD4E6L});
    public static final BitSet FOLLOW_statement_in_statement3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_statement3156 = new BitSet(new long[]{0xFF10024404000FD0L,0x0007E60000FBD4E6L});
    public static final BitSet FOLLOW_statement_in_statement3158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_statement3160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_parExpression_in_statement3162 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_statement3172 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_block_in_statement3174 = new BitSet(new long[]{0x0000000000000000L,0x0000000001040000L});
    public static final BitSet FOLLOW_catches_in_statement3184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_statement3186 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_block_in_statement3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_statement3198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_statement3208 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_block_in_statement3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_statement3226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_parExpression_in_statement3228 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_statement3230 = new BitSet(new long[]{0x0000008000000000L,0x0000000002000200L});
    public static final BitSet FOLLOW_switchBlockStatementGroups_in_statement3232 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_statement3234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_statement3242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_parExpression_in_statement3244 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_block_in_statement3246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_statement3254 = new BitSet(new long[]{0xFF00020404000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_statement3256 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_statement3267 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_statement3269 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement3271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_statement3279 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_Identifier_in_statement3281 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement3284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_statement3292 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_Identifier_in_statement3294 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement3297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_statement3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementExpression_in_statement3315 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement3319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_statement3327 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_statement3329 = new BitSet(new long[]{0xFF10024404000FD0L,0x0007E60000FBD4E6L});
    public static final BitSet FOLLOW_statement_in_statement3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catchClause_in_catches3343 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_catchClause_in_catches3346 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_catchClause3360 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_catchClause3362 = new BitSet(new long[]{0xFF04000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_formalParameter_in_catchClause3364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_catchClause3366 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_block_in_catchClause3368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifier_in_formalParameter3379 = new BitSet(new long[]{0xFF04000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_type_in_formalParameter3382 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaratorId_in_formalParameter3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchBlockStatementGroup_in_switchBlockStatementGroups3398 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000200L});
    public static final BitSet FOLLOW_switchLabel_in_switchBlockStatementGroup3412 = new BitSet(new long[]{0xFFFFC34494000FF2L,0x0007E60000FBD5E6L});
    public static final BitSet FOLLOW_blockStatement_in_switchBlockStatementGroup3414 = new BitSet(new long[]{0xFFFFC34494000FF2L,0x0007E60000FBD5E6L});
    public static final BitSet FOLLOW_89_in_switchLabel3427 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_constantExpression_in_switchLabel3429 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_switchLabel3431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_switchLabel3438 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_enumConstantName_in_switchLabel3440 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_switchLabel3442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_switchLabel3449 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_switchLabel3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_moreStatementExpressions3464 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_statementExpression_in_moreStatementExpressions3466 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_forVarControl_in_forControl3487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forInit_in_forControl3492 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_forControl3495 = new BitSet(new long[]{0xFF00020404000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_forControl3497 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_forControl3500 = new BitSet(new long[]{0xFF00020400000FD2L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_forUpdate_in_forControl3502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifier_in_forInit3514 = new BitSet(new long[]{0xFF04000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_type_in_forInit3517 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarators_in_forInit3519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_forInit3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifier_in_forVarControl3536 = new BitSet(new long[]{0xFF04000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_type_in_forVarControl3539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_forVarControl3541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_forVarControl3543 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_forVarControl3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_forUpdate3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_parExpression3573 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_parExpression3577 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_parExpression3581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionList3608 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_expressionList3613 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_expressionList3617 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_expression_in_statementExpression3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_constantExpression3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_expression3681 = new BitSet(new long[]{0x0000201400000002L,0x00000003FC000000L});
    public static final BitSet FOLLOW_assignmentOperator_in_expression3686 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_expression3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_assignmentOperator3702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_assignmentOperator3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_assignmentOperator3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_assignmentOperator3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_assignmentOperator3742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_assignmentOperator3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_assignmentOperator3762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_assignmentOperator3772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_assignmentOperator3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_assignmentOperator3792 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_assignmentOperator3794 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_assignmentOperator3796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_assignmentOperator3806 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_assignmentOperator3808 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_assignmentOperator3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_assignmentOperator3820 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_assignmentOperator3822 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_assignmentOperator3824 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_assignmentOperator3826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalExpression3848 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_conditionalExpression3854 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_conditionalExpression3856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_conditionalExpression3858 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_conditionalExpression3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression3885 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_conditionalOrExpression3891 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression3893 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression3918 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_conditionalAndExpression3924 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression3926 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression3951 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_inclusiveOrExpression3957 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression3959 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression3984 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_exclusiveOrExpression3990 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression3992 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression4017 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_andExpression4023 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression4025 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression4050 = new BitSet(new long[]{0x0000000000000002L,0x000000C000000000L});
    public static final BitSet FOLLOW_set_in_equalityExpression4056 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression4064 = new BitSet(new long[]{0x0000000000000002L,0x000000C000000000L});
    public static final BitSet FOLLOW_relationalExpression_in_instanceOfExpression4089 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_instanceOfExpression4094 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_type_in_instanceOfExpression4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression4120 = new BitSet(new long[]{0x0000001400000002L});
    public static final BitSet FOLLOW_relationalOp_in_relationalExpression4126 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression4128 = new BitSet(new long[]{0x0000001400000002L});
    public static final BitSet FOLLOW_34_in_relationalOp4144 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_relationalOp4146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_relationalOp4150 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_relationalOp4152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_relationalOp4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_relationalOp4160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression4183 = new BitSet(new long[]{0x0000001400000002L});
    public static final BitSet FOLLOW_shiftOp_in_shiftExpression4189 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression4191 = new BitSet(new long[]{0x0000001400000002L});
    public static final BitSet FOLLOW_34_in_shiftOp4215 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_shiftOp4217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_shiftOp4221 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_shiftOp4223 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_shiftOp4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_shiftOp4229 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_shiftOp4231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression4255 = new BitSet(new long[]{0x0000000000000002L,0x0000060000000000L});
    public static final BitSet FOLLOW_set_in_additiveExpression4261 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression4269 = new BitSet(new long[]{0x0000000000000002L,0x0000060000000000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression4294 = new BitSet(new long[]{0x0000000040000002L,0x0000180000000000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression4300 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression4314 = new BitSet(new long[]{0x0000000040000002L,0x0000180000000000L});
    public static final BitSet FOLLOW_105_in_unaryExpression4338 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression4340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_unaryExpression4348 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression4350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_unaryExpression4360 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression4362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_unaryExpression4372 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression4374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression4386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_unaryExpressionNotPlusMinus4411 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus4413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_unaryExpressionNotPlusMinus4422 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus4424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpression_in_unaryExpressionNotPlusMinus4434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpressionNotPlusMinus4446 = new BitSet(new long[]{0x0000040020000002L,0x0000600000000000L});
    public static final BitSet FOLLOW_selector_in_unaryExpressionNotPlusMinus4450 = new BitSet(new long[]{0x0000040020000002L,0x0000600000000000L});
    public static final BitSet FOLLOW_set_in_unaryExpressionNotPlusMinus4453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_castExpression4476 = new BitSet(new long[]{0xFF00000000000000L});
    public static final BitSet FOLLOW_primitiveType_in_castExpression4478 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_castExpression4480 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_unaryExpression_in_castExpression4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_castExpression4491 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_type_in_castExpression4494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_castExpression4498 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_castExpression4501 = new BitSet(new long[]{0xFF00020400000FD0L,0x00078000000000E6L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_castExpression4503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parExpression_in_primary4526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_primary4537 = new BitSet(new long[]{0x0000000000000010L,0x0002000000000002L});
    public static final BitSet FOLLOW_explicitGenericInvocationSuffix_in_primary4548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_primary4552 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_primary4554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_primary4565 = new BitSet(new long[]{0x0000040020000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_29_in_primary4568 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_primary4570 = new BitSet(new long[]{0x0000040020000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary4574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primary4586 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_superSuffix_in_primary4588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primary4600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_primary4612 = new BitSet(new long[]{0xFF00000400000010L});
    public static final BitSet FOLLOW_creator_in_primary4614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedName_in_primary4626 = new BitSet(new long[]{0x0000040020000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary4632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_primary4645 = new BitSet(new long[]{0x0000040020000000L});
    public static final BitSet FOLLOW_42_in_primary4648 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_primary4650 = new BitSet(new long[]{0x0000040020000000L});
    public static final BitSet FOLLOW_29_in_primary4654 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_primary4656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_primary4666 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_primary4668 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_primary4670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_identifierSuffix4686 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_identifierSuffix4688 = new BitSet(new long[]{0x0000040020000000L});
    public static final BitSet FOLLOW_29_in_identifierSuffix4692 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_identifierSuffix4694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_identifierSuffix4700 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_identifierSuffix4702 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_identifierSuffix4704 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix4719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_identifierSuffix4731 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_identifierSuffix4733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_identifierSuffix4743 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_explicitGenericInvocation_in_identifierSuffix4745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_identifierSuffix4755 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_identifierSuffix4757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_identifierSuffix4767 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_identifierSuffix4769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix4771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_identifierSuffix4781 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_identifierSuffix4783 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_identifierSuffix4786 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_innerCreator_in_identifierSuffix4790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_creator4817 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_createdName_in_creator4820 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_arrayCreatorRest_in_creator4831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classCreatorRest_in_creator4835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_createdName4847 = new BitSet(new long[]{0x0000000420000002L});
    public static final BitSet FOLLOW_typeArguments_in_createdName4849 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_createdName4861 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_createdName4863 = new BitSet(new long[]{0x0000000420000002L});
    public static final BitSet FOLLOW_typeArguments_in_createdName4865 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_primitiveType_in_createdName4876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_innerCreator4888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_classCreatorRest_in_innerCreator4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_arrayCreatorRest4901 = new BitSet(new long[]{0xFF000A0400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_43_in_arrayCreatorRest4915 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_arrayCreatorRest4918 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_arrayCreatorRest4920 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_arrayInitializer_in_arrayCreatorRest4924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_arrayCreatorRest4938 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_arrayCreatorRest4940 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_arrayCreatorRest4943 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_arrayCreatorRest4945 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_arrayCreatorRest4947 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_arrayCreatorRest4952 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_arrayCreatorRest4954 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_arguments_in_classCreatorRest4977 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_classBody_in_classCreatorRest4979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_explicitGenericInvocation4993 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000002L});
    public static final BitSet FOLLOW_explicitGenericInvocationSuffix_in_explicitGenericInvocation4995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_nonWildcardTypeArguments5007 = new BitSet(new long[]{0xFF00000000000010L});
    public static final BitSet FOLLOW_typeList_in_nonWildcardTypeArguments5009 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_nonWildcardTypeArguments5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_explicitGenericInvocationSuffix5023 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_superSuffix_in_explicitGenericInvocationSuffix5025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_explicitGenericInvocationSuffix5032 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_explicitGenericInvocationSuffix5034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_selector5046 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_selector5048 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_selector5051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_selector5060 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_selector5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_selector5069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_selector5071 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_superSuffix_in_selector5073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_selector5080 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_selector5082 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_selector5085 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_innerCreator_in_selector5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_selector5096 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_selector5098 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_selector5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_superSuffix5112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_superSuffix5119 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_superSuffix5121 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_superSuffix5124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_arguments5148 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000EEL});
    public static final BitSet FOLLOW_expressionList_in_arguments5153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_arguments5159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDeclaration_in_synpred6383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDeclaration_in_synpred36968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDeclaration_in_synpred37975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred831808 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_synpred831810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred1092375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_synpred1092379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred1182576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred1202593 = new BitSet(new long[]{0xFF00024400000FD0L,0x0007E600000001EEL});
    public static final BitSet FOLLOW_elementValuePairs_in_synpred1202595 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred1202598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred1332806 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_synpred1332808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_synpred1352816 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_synpred1352818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_synpred1372826 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_synpred1372828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_synpred1422977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_synpred1432982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_synpred1443016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_synpred1493116 = new BitSet(new long[]{0xFF10024404000FD0L,0x0007E60000FBD4E6L});
    public static final BitSet FOLLOW_statement_in_synpred1493118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_synpred1543184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_synpred1543186 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_block_in_synpred1543188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_synpred1553198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_synpred1723427 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_constantExpression_in_synpred1723429 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_synpred1723431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_synpred1733438 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_enumConstantName_in_synpred1733440 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_synpred1733442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forVarControl_in_synpred1753487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifier_in_synpred1803514 = new BitSet(new long[]{0xFF04000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_type_in_synpred1803517 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclarators_in_synpred1803519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOperator_in_synpred1833686 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_synpred1833688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_synpred1943806 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_synpred1943808 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_synpred1943810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalOp_in_synpred2044126 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_shiftExpression_in_synpred2044128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_shiftOp_in_synpred2084189 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred2084191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_synpred2104221 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_synpred2104223 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_synpred2104225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpression_in_synpred2224434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred2264476 = new BitSet(new long[]{0xFF00000000000000L});
    public static final BitSet FOLLOW_primitiveType_in_synpred2264478 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred2264480 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_unaryExpression_in_synpred2264482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_synpred2274494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred2314568 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_synpred2314570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred2414700 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_synpred2414702 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred2414704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred2424700 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_synpred2424702 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred2424704 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_29_in_synpred2464755 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_synpred2464757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred2474767 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred2474769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_synpred2474771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred2494781 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_synpred2494783 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_synpred2494786 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_innerCreator_in_synpred2494790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred2584943 = new BitSet(new long[]{0xFF00020400000FD0L,0x0007E600000000E6L});
    public static final BitSet FOLLOW_expression_in_synpred2584945 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred2584947 = new BitSet(new long[]{0x0000000000000002L});

}