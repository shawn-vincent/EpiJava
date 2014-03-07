lexer grammar EpiJava;
@members {
  protected boolean enumIsKeyword = true;
}
@header {
  package com.epijava.grammar;
}

T25 : 'package' ;
T26 : ';' ;
T27 : 'import' ;
T28 : 'static' ;
T29 : '.' ;
T30 : '*' ;
T31 : 'class' ;
T32 : 'extends' ;
T33 : 'implements' ;
T34 : '<' ;
T35 : ',' ;
T36 : '>' ;
T37 : '&' ;
T38 : '{' ;
T39 : '}' ;
T40 : 'interface' ;
T41 : 'void' ;
T42 : '[' ;
T43 : ']' ;
T44 : 'throws' ;
T45 : '=' ;
T46 : 'public' ;
T47 : 'protected' ;
T48 : 'private' ;
T49 : 'abstract' ;
T50 : 'final' ;
T51 : 'native' ;
T52 : 'synchronized' ;
T53 : 'transient' ;
T54 : 'volatile' ;
T55 : 'strictfp' ;
T56 : 'boolean' ;
T57 : 'char' ;
T58 : 'byte' ;
T59 : 'short' ;
T60 : 'int' ;
T61 : 'long' ;
T62 : 'float' ;
T63 : 'double' ;
T64 : '?' ;
T65 : 'super' ;
T66 : '(' ;
T67 : ')' ;
T68 : '...' ;
T69 : 'null' ;
T70 : 'true' ;
T71 : 'false' ;
T72 : '@' ;
T73 : 'default' ;
T74 : 'assert' ;
T75 : ':' ;
T76 : 'if' ;
T77 : 'else' ;
T78 : 'for' ;
T79 : 'while' ;
T80 : 'do' ;
T81 : 'try' ;
T82 : 'finally' ;
T83 : 'switch' ;
T84 : 'return' ;
T85 : 'throw' ;
T86 : 'break' ;
T87 : 'continue' ;
T88 : 'catch' ;
T89 : 'case' ;
T90 : '+=' ;
T91 : '-=' ;
T92 : '*=' ;
T93 : '/=' ;
T94 : '&=' ;
T95 : '|=' ;
T96 : '^=' ;
T97 : '%=' ;
T98 : '||' ;
T99 : '&&' ;
T100 : '|' ;
T101 : '^' ;
T102 : '==' ;
T103 : '!=' ;
T104 : 'instanceof' ;
T105 : '+' ;
T106 : '-' ;
T107 : '/' ;
T108 : '%' ;
T109 : '++' ;
T110 : '--' ;
T111 : '~' ;
T112 : '!' ;
T113 : 'this' ;
T114 : 'new' ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 917
HexLiteral : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 919
DecimalLiteral : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 921
OctalLiteral : '0' ('0'..'7')+ IntegerTypeSuffix? ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 923
fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 926
fragment
IntegerTypeSuffix : ('l'|'L') ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 929
FloatingPointLiteral
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   ('0'..'9')+ Exponent FloatTypeSuffix?
    |   ('0'..'9')+ Exponent? FloatTypeSuffix
	;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 936
fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 939
fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D') ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 942
CharacterLiteral
    :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
    ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 946
StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 950
fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UnicodeEscape
    |   OctalEscape
    ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 957
fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 964
fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 969
ENUM:	'enum' {if ( !enumIsKeyword ) $type=Identifier;}
	;
	
// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 972
Identifier 
    :   Letter (Letter|JavaIDDigit)*
    ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 976
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

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 996
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

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 1015
WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 1018
JAVADOC
    :   '/**' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ; 

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 1022
COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

// $ANTLR src "src/com/epijava/grammar/EpiJava.g" 1026
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
