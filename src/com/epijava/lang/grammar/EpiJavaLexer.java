// $ANTLR 3.0.1 src/com/epijava/grammar/EpiJava.g 2008-08-18 22:21:26

  package com.epijava.lang.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EpiJavaLexer extends Lexer {
    public static final int T29=29;
    public static final int HexDigit=12;
    public static final int T70=70;
    public static final int T74=74;
    public static final int T85=85;
    public static final int T102=102;
    public static final int Letter=19;
    public static final int T114=114;
    public static final int T103=103;
    public static final int T32=32;
    public static final int T81=81;
    public static final int T41=41;
    public static final int FloatTypeSuffix=15;
    public static final int T113=113;
    public static final int T62=62;
    public static final int T109=109;
    public static final int IntegerTypeSuffix=13;
    public static final int T68=68;
    public static final int T73=73;
    public static final int T84=84;
    public static final int T33=33;
    public static final int Identifier=4;
    public static final int T78=78;
    public static final int WS=21;
    public static final int T42=42;
    public static final int T96=96;
    public static final int T71=71;
    public static final int LINE_COMMENT=24;
    public static final int T72=72;
    public static final int T94=94;
    public static final int T76=76;
    public static final int UnicodeEscape=17;
    public static final int HexLiteral=9;
    public static final int T75=75;
    public static final int T89=89;
    public static final int DecimalLiteral=11;
    public static final int T67=67;
    public static final int T31=31;
    public static final int T60=60;
    public static final int T82=82;
    public static final int T100=100;
    public static final int T49=49;
    public static final int T30=30;
    public static final int T79=79;
    public static final int OctalLiteral=10;
    public static final int T36=36;
    public static final int T58=58;
    public static final int T93=93;
    public static final int T35=35;
    public static final int JAVADOC=22;
    public static final int T107=107;
    public static final int T83=83;
    public static final int T61=61;
    public static final int T45=45;
    public static final int T34=34;
    public static final int T101=101;
    public static final int T64=64;
    public static final int T25=25;
    public static final int T91=91;
    public static final int T105=105;
    public static final int T37=37;
    public static final int T86=86;
    public static final int EscapeSequence=16;
    public static final int T26=26;
    public static final int T51=51;
    public static final int T111=111;
    public static final int T46=46;
    public static final int T77=77;
    public static final int T38=38;
    public static final int FloatingPointLiteral=6;
    public static final int T106=106;
    public static final int T112=112;
    public static final int T69=69;
    public static final int T39=39;
    public static final int ENUM=5;
    public static final int T44=44;
    public static final int T55=55;
    public static final int Exponent=14;
    public static final int T95=95;
    public static final int T50=50;
    public static final int T110=110;
    public static final int T108=108;
    public static final int CharacterLiteral=7;
    public static final int T92=92;
    public static final int T43=43;
    public static final int T28=28;
    public static final int T40=40;
    public static final int T66=66;
    public static final int COMMENT=23;
    public static final int T88=88;
    public static final int StringLiteral=8;
    public static final int T63=63;
    public static final int T57=57;
    public static final int T65=65;
    public static final int T98=98;
    public static final int T56=56;
    public static final int T87=87;
    public static final int T80=80;
    public static final int JavaIDDigit=20;
    public static final int T59=59;
    public static final int T97=97;
    public static final int T48=48;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T104=104;
    public static final int T47=47;
    public static final int Tokens=115;
    public static final int T53=53;
    public static final int OctalEscape=18;
    public static final int T99=99;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T90=90;

      protected boolean enumIsKeyword = true;

    public EpiJavaLexer() {;} 
    public EpiJavaLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "src/com/epijava/grammar/EpiJava.g"; }

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // src/com/epijava/grammar/EpiJava.g:9:5: ( 'package' )
            // src/com/epijava/grammar/EpiJava.g:9:7: 'package'
            {
            match("package"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // src/com/epijava/grammar/EpiJava.g:10:5: ( ';' )
            // src/com/epijava/grammar/EpiJava.g:10:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // src/com/epijava/grammar/EpiJava.g:11:5: ( 'import' )
            // src/com/epijava/grammar/EpiJava.g:11:7: 'import'
            {
            match("import"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // src/com/epijava/grammar/EpiJava.g:12:5: ( 'static' )
            // src/com/epijava/grammar/EpiJava.g:12:7: 'static'
            {
            match("static"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // src/com/epijava/grammar/EpiJava.g:13:5: ( '.' )
            // src/com/epijava/grammar/EpiJava.g:13:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // src/com/epijava/grammar/EpiJava.g:14:5: ( '*' )
            // src/com/epijava/grammar/EpiJava.g:14:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // src/com/epijava/grammar/EpiJava.g:15:5: ( 'class' )
            // src/com/epijava/grammar/EpiJava.g:15:7: 'class'
            {
            match("class"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // src/com/epijava/grammar/EpiJava.g:16:5: ( 'extends' )
            // src/com/epijava/grammar/EpiJava.g:16:7: 'extends'
            {
            match("extends"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // src/com/epijava/grammar/EpiJava.g:17:5: ( 'implements' )
            // src/com/epijava/grammar/EpiJava.g:17:7: 'implements'
            {
            match("implements"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // src/com/epijava/grammar/EpiJava.g:18:5: ( '<' )
            // src/com/epijava/grammar/EpiJava.g:18:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // src/com/epijava/grammar/EpiJava.g:19:5: ( ',' )
            // src/com/epijava/grammar/EpiJava.g:19:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // src/com/epijava/grammar/EpiJava.g:20:5: ( '>' )
            // src/com/epijava/grammar/EpiJava.g:20:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // src/com/epijava/grammar/EpiJava.g:21:5: ( '&' )
            // src/com/epijava/grammar/EpiJava.g:21:7: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // src/com/epijava/grammar/EpiJava.g:22:5: ( '{' )
            // src/com/epijava/grammar/EpiJava.g:22:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // src/com/epijava/grammar/EpiJava.g:23:5: ( '}' )
            // src/com/epijava/grammar/EpiJava.g:23:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // src/com/epijava/grammar/EpiJava.g:24:5: ( 'interface' )
            // src/com/epijava/grammar/EpiJava.g:24:7: 'interface'
            {
            match("interface"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // src/com/epijava/grammar/EpiJava.g:25:5: ( 'void' )
            // src/com/epijava/grammar/EpiJava.g:25:7: 'void'
            {
            match("void"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // src/com/epijava/grammar/EpiJava.g:26:5: ( '[' )
            // src/com/epijava/grammar/EpiJava.g:26:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // src/com/epijava/grammar/EpiJava.g:27:5: ( ']' )
            // src/com/epijava/grammar/EpiJava.g:27:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // src/com/epijava/grammar/EpiJava.g:28:5: ( 'throws' )
            // src/com/epijava/grammar/EpiJava.g:28:7: 'throws'
            {
            match("throws"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // src/com/epijava/grammar/EpiJava.g:29:5: ( '=' )
            // src/com/epijava/grammar/EpiJava.g:29:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // src/com/epijava/grammar/EpiJava.g:30:5: ( 'public' )
            // src/com/epijava/grammar/EpiJava.g:30:7: 'public'
            {
            match("public"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // src/com/epijava/grammar/EpiJava.g:31:5: ( 'protected' )
            // src/com/epijava/grammar/EpiJava.g:31:7: 'protected'
            {
            match("protected"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // src/com/epijava/grammar/EpiJava.g:32:5: ( 'private' )
            // src/com/epijava/grammar/EpiJava.g:32:7: 'private'
            {
            match("private"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // src/com/epijava/grammar/EpiJava.g:33:5: ( 'abstract' )
            // src/com/epijava/grammar/EpiJava.g:33:7: 'abstract'
            {
            match("abstract"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // src/com/epijava/grammar/EpiJava.g:34:5: ( 'final' )
            // src/com/epijava/grammar/EpiJava.g:34:7: 'final'
            {
            match("final"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // src/com/epijava/grammar/EpiJava.g:35:5: ( 'native' )
            // src/com/epijava/grammar/EpiJava.g:35:7: 'native'
            {
            match("native"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public final void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // src/com/epijava/grammar/EpiJava.g:36:5: ( 'synchronized' )
            // src/com/epijava/grammar/EpiJava.g:36:7: 'synchronized'
            {
            match("synchronized"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // src/com/epijava/grammar/EpiJava.g:37:5: ( 'transient' )
            // src/com/epijava/grammar/EpiJava.g:37:7: 'transient'
            {
            match("transient"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // src/com/epijava/grammar/EpiJava.g:38:5: ( 'volatile' )
            // src/com/epijava/grammar/EpiJava.g:38:7: 'volatile'
            {
            match("volatile"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start T55
    public final void mT55() throws RecognitionException {
        try {
            int _type = T55;
            // src/com/epijava/grammar/EpiJava.g:39:5: ( 'strictfp' )
            // src/com/epijava/grammar/EpiJava.g:39:7: 'strictfp'
            {
            match("strictfp"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T55

    // $ANTLR start T56
    public final void mT56() throws RecognitionException {
        try {
            int _type = T56;
            // src/com/epijava/grammar/EpiJava.g:40:5: ( 'boolean' )
            // src/com/epijava/grammar/EpiJava.g:40:7: 'boolean'
            {
            match("boolean"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start T57
    public final void mT57() throws RecognitionException {
        try {
            int _type = T57;
            // src/com/epijava/grammar/EpiJava.g:41:5: ( 'char' )
            // src/com/epijava/grammar/EpiJava.g:41:7: 'char'
            {
            match("char"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T57

    // $ANTLR start T58
    public final void mT58() throws RecognitionException {
        try {
            int _type = T58;
            // src/com/epijava/grammar/EpiJava.g:42:5: ( 'byte' )
            // src/com/epijava/grammar/EpiJava.g:42:7: 'byte'
            {
            match("byte"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T58

    // $ANTLR start T59
    public final void mT59() throws RecognitionException {
        try {
            int _type = T59;
            // src/com/epijava/grammar/EpiJava.g:43:5: ( 'short' )
            // src/com/epijava/grammar/EpiJava.g:43:7: 'short'
            {
            match("short"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T59

    // $ANTLR start T60
    public final void mT60() throws RecognitionException {
        try {
            int _type = T60;
            // src/com/epijava/grammar/EpiJava.g:44:5: ( 'int' )
            // src/com/epijava/grammar/EpiJava.g:44:7: 'int'
            {
            match("int"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T60

    // $ANTLR start T61
    public final void mT61() throws RecognitionException {
        try {
            int _type = T61;
            // src/com/epijava/grammar/EpiJava.g:45:5: ( 'long' )
            // src/com/epijava/grammar/EpiJava.g:45:7: 'long'
            {
            match("long"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T61

    // $ANTLR start T62
    public final void mT62() throws RecognitionException {
        try {
            int _type = T62;
            // src/com/epijava/grammar/EpiJava.g:46:5: ( 'float' )
            // src/com/epijava/grammar/EpiJava.g:46:7: 'float'
            {
            match("float"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T62

    // $ANTLR start T63
    public final void mT63() throws RecognitionException {
        try {
            int _type = T63;
            // src/com/epijava/grammar/EpiJava.g:47:5: ( 'double' )
            // src/com/epijava/grammar/EpiJava.g:47:7: 'double'
            {
            match("double"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T63

    // $ANTLR start T64
    public final void mT64() throws RecognitionException {
        try {
            int _type = T64;
            // src/com/epijava/grammar/EpiJava.g:48:5: ( '?' )
            // src/com/epijava/grammar/EpiJava.g:48:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T64

    // $ANTLR start T65
    public final void mT65() throws RecognitionException {
        try {
            int _type = T65;
            // src/com/epijava/grammar/EpiJava.g:49:5: ( 'super' )
            // src/com/epijava/grammar/EpiJava.g:49:7: 'super'
            {
            match("super"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T65

    // $ANTLR start T66
    public final void mT66() throws RecognitionException {
        try {
            int _type = T66;
            // src/com/epijava/grammar/EpiJava.g:50:5: ( '(' )
            // src/com/epijava/grammar/EpiJava.g:50:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T66

    // $ANTLR start T67
    public final void mT67() throws RecognitionException {
        try {
            int _type = T67;
            // src/com/epijava/grammar/EpiJava.g:51:5: ( ')' )
            // src/com/epijava/grammar/EpiJava.g:51:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T67

    // $ANTLR start T68
    public final void mT68() throws RecognitionException {
        try {
            int _type = T68;
            // src/com/epijava/grammar/EpiJava.g:52:5: ( '...' )
            // src/com/epijava/grammar/EpiJava.g:52:7: '...'
            {
            match("..."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T68

    // $ANTLR start T69
    public final void mT69() throws RecognitionException {
        try {
            int _type = T69;
            // src/com/epijava/grammar/EpiJava.g:53:5: ( 'null' )
            // src/com/epijava/grammar/EpiJava.g:53:7: 'null'
            {
            match("null"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T69

    // $ANTLR start T70
    public final void mT70() throws RecognitionException {
        try {
            int _type = T70;
            // src/com/epijava/grammar/EpiJava.g:54:5: ( 'true' )
            // src/com/epijava/grammar/EpiJava.g:54:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T70

    // $ANTLR start T71
    public final void mT71() throws RecognitionException {
        try {
            int _type = T71;
            // src/com/epijava/grammar/EpiJava.g:55:5: ( 'false' )
            // src/com/epijava/grammar/EpiJava.g:55:7: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T71

    // $ANTLR start T72
    public final void mT72() throws RecognitionException {
        try {
            int _type = T72;
            // src/com/epijava/grammar/EpiJava.g:56:5: ( '@' )
            // src/com/epijava/grammar/EpiJava.g:56:7: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T72

    // $ANTLR start T73
    public final void mT73() throws RecognitionException {
        try {
            int _type = T73;
            // src/com/epijava/grammar/EpiJava.g:57:5: ( 'default' )
            // src/com/epijava/grammar/EpiJava.g:57:7: 'default'
            {
            match("default"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T73

    // $ANTLR start T74
    public final void mT74() throws RecognitionException {
        try {
            int _type = T74;
            // src/com/epijava/grammar/EpiJava.g:58:5: ( 'assert' )
            // src/com/epijava/grammar/EpiJava.g:58:7: 'assert'
            {
            match("assert"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T74

    // $ANTLR start T75
    public final void mT75() throws RecognitionException {
        try {
            int _type = T75;
            // src/com/epijava/grammar/EpiJava.g:59:5: ( ':' )
            // src/com/epijava/grammar/EpiJava.g:59:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T75

    // $ANTLR start T76
    public final void mT76() throws RecognitionException {
        try {
            int _type = T76;
            // src/com/epijava/grammar/EpiJava.g:60:5: ( 'if' )
            // src/com/epijava/grammar/EpiJava.g:60:7: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T76

    // $ANTLR start T77
    public final void mT77() throws RecognitionException {
        try {
            int _type = T77;
            // src/com/epijava/grammar/EpiJava.g:61:5: ( 'else' )
            // src/com/epijava/grammar/EpiJava.g:61:7: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T77

    // $ANTLR start T78
    public final void mT78() throws RecognitionException {
        try {
            int _type = T78;
            // src/com/epijava/grammar/EpiJava.g:62:5: ( 'for' )
            // src/com/epijava/grammar/EpiJava.g:62:7: 'for'
            {
            match("for"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T78

    // $ANTLR start T79
    public final void mT79() throws RecognitionException {
        try {
            int _type = T79;
            // src/com/epijava/grammar/EpiJava.g:63:5: ( 'while' )
            // src/com/epijava/grammar/EpiJava.g:63:7: 'while'
            {
            match("while"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T79

    // $ANTLR start T80
    public final void mT80() throws RecognitionException {
        try {
            int _type = T80;
            // src/com/epijava/grammar/EpiJava.g:64:5: ( 'do' )
            // src/com/epijava/grammar/EpiJava.g:64:7: 'do'
            {
            match("do"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T80

    // $ANTLR start T81
    public final void mT81() throws RecognitionException {
        try {
            int _type = T81;
            // src/com/epijava/grammar/EpiJava.g:65:5: ( 'try' )
            // src/com/epijava/grammar/EpiJava.g:65:7: 'try'
            {
            match("try"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T81

    // $ANTLR start T82
    public final void mT82() throws RecognitionException {
        try {
            int _type = T82;
            // src/com/epijava/grammar/EpiJava.g:66:5: ( 'finally' )
            // src/com/epijava/grammar/EpiJava.g:66:7: 'finally'
            {
            match("finally"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T82

    // $ANTLR start T83
    public final void mT83() throws RecognitionException {
        try {
            int _type = T83;
            // src/com/epijava/grammar/EpiJava.g:67:5: ( 'switch' )
            // src/com/epijava/grammar/EpiJava.g:67:7: 'switch'
            {
            match("switch"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T83

    // $ANTLR start T84
    public final void mT84() throws RecognitionException {
        try {
            int _type = T84;
            // src/com/epijava/grammar/EpiJava.g:68:5: ( 'return' )
            // src/com/epijava/grammar/EpiJava.g:68:7: 'return'
            {
            match("return"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T84

    // $ANTLR start T85
    public final void mT85() throws RecognitionException {
        try {
            int _type = T85;
            // src/com/epijava/grammar/EpiJava.g:69:5: ( 'throw' )
            // src/com/epijava/grammar/EpiJava.g:69:7: 'throw'
            {
            match("throw"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T85

    // $ANTLR start T86
    public final void mT86() throws RecognitionException {
        try {
            int _type = T86;
            // src/com/epijava/grammar/EpiJava.g:70:5: ( 'break' )
            // src/com/epijava/grammar/EpiJava.g:70:7: 'break'
            {
            match("break"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T86

    // $ANTLR start T87
    public final void mT87() throws RecognitionException {
        try {
            int _type = T87;
            // src/com/epijava/grammar/EpiJava.g:71:5: ( 'continue' )
            // src/com/epijava/grammar/EpiJava.g:71:7: 'continue'
            {
            match("continue"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T87

    // $ANTLR start T88
    public final void mT88() throws RecognitionException {
        try {
            int _type = T88;
            // src/com/epijava/grammar/EpiJava.g:72:5: ( 'catch' )
            // src/com/epijava/grammar/EpiJava.g:72:7: 'catch'
            {
            match("catch"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T88

    // $ANTLR start T89
    public final void mT89() throws RecognitionException {
        try {
            int _type = T89;
            // src/com/epijava/grammar/EpiJava.g:73:5: ( 'case' )
            // src/com/epijava/grammar/EpiJava.g:73:7: 'case'
            {
            match("case"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T89

    // $ANTLR start T90
    public final void mT90() throws RecognitionException {
        try {
            int _type = T90;
            // src/com/epijava/grammar/EpiJava.g:74:5: ( '+=' )
            // src/com/epijava/grammar/EpiJava.g:74:7: '+='
            {
            match("+="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T90

    // $ANTLR start T91
    public final void mT91() throws RecognitionException {
        try {
            int _type = T91;
            // src/com/epijava/grammar/EpiJava.g:75:5: ( '-=' )
            // src/com/epijava/grammar/EpiJava.g:75:7: '-='
            {
            match("-="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T91

    // $ANTLR start T92
    public final void mT92() throws RecognitionException {
        try {
            int _type = T92;
            // src/com/epijava/grammar/EpiJava.g:76:5: ( '*=' )
            // src/com/epijava/grammar/EpiJava.g:76:7: '*='
            {
            match("*="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T92

    // $ANTLR start T93
    public final void mT93() throws RecognitionException {
        try {
            int _type = T93;
            // src/com/epijava/grammar/EpiJava.g:77:5: ( '/=' )
            // src/com/epijava/grammar/EpiJava.g:77:7: '/='
            {
            match("/="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T93

    // $ANTLR start T94
    public final void mT94() throws RecognitionException {
        try {
            int _type = T94;
            // src/com/epijava/grammar/EpiJava.g:78:5: ( '&=' )
            // src/com/epijava/grammar/EpiJava.g:78:7: '&='
            {
            match("&="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T94

    // $ANTLR start T95
    public final void mT95() throws RecognitionException {
        try {
            int _type = T95;
            // src/com/epijava/grammar/EpiJava.g:79:5: ( '|=' )
            // src/com/epijava/grammar/EpiJava.g:79:7: '|='
            {
            match("|="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T95

    // $ANTLR start T96
    public final void mT96() throws RecognitionException {
        try {
            int _type = T96;
            // src/com/epijava/grammar/EpiJava.g:80:5: ( '^=' )
            // src/com/epijava/grammar/EpiJava.g:80:7: '^='
            {
            match("^="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T96

    // $ANTLR start T97
    public final void mT97() throws RecognitionException {
        try {
            int _type = T97;
            // src/com/epijava/grammar/EpiJava.g:81:5: ( '%=' )
            // src/com/epijava/grammar/EpiJava.g:81:7: '%='
            {
            match("%="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T97

    // $ANTLR start T98
    public final void mT98() throws RecognitionException {
        try {
            int _type = T98;
            // src/com/epijava/grammar/EpiJava.g:82:5: ( '||' )
            // src/com/epijava/grammar/EpiJava.g:82:7: '||'
            {
            match("||"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T98

    // $ANTLR start T99
    public final void mT99() throws RecognitionException {
        try {
            int _type = T99;
            // src/com/epijava/grammar/EpiJava.g:83:5: ( '&&' )
            // src/com/epijava/grammar/EpiJava.g:83:7: '&&'
            {
            match("&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T99

    // $ANTLR start T100
    public final void mT100() throws RecognitionException {
        try {
            int _type = T100;
            // src/com/epijava/grammar/EpiJava.g:84:6: ( '|' )
            // src/com/epijava/grammar/EpiJava.g:84:8: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T100

    // $ANTLR start T101
    public final void mT101() throws RecognitionException {
        try {
            int _type = T101;
            // src/com/epijava/grammar/EpiJava.g:85:6: ( '^' )
            // src/com/epijava/grammar/EpiJava.g:85:8: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T101

    // $ANTLR start T102
    public final void mT102() throws RecognitionException {
        try {
            int _type = T102;
            // src/com/epijava/grammar/EpiJava.g:86:6: ( '==' )
            // src/com/epijava/grammar/EpiJava.g:86:8: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T102

    // $ANTLR start T103
    public final void mT103() throws RecognitionException {
        try {
            int _type = T103;
            // src/com/epijava/grammar/EpiJava.g:87:6: ( '!=' )
            // src/com/epijava/grammar/EpiJava.g:87:8: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T103

    // $ANTLR start T104
    public final void mT104() throws RecognitionException {
        try {
            int _type = T104;
            // src/com/epijava/grammar/EpiJava.g:88:6: ( 'instanceof' )
            // src/com/epijava/grammar/EpiJava.g:88:8: 'instanceof'
            {
            match("instanceof"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T104

    // $ANTLR start T105
    public final void mT105() throws RecognitionException {
        try {
            int _type = T105;
            // src/com/epijava/grammar/EpiJava.g:89:6: ( '+' )
            // src/com/epijava/grammar/EpiJava.g:89:8: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T105

    // $ANTLR start T106
    public final void mT106() throws RecognitionException {
        try {
            int _type = T106;
            // src/com/epijava/grammar/EpiJava.g:90:6: ( '-' )
            // src/com/epijava/grammar/EpiJava.g:90:8: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T106

    // $ANTLR start T107
    public final void mT107() throws RecognitionException {
        try {
            int _type = T107;
            // src/com/epijava/grammar/EpiJava.g:91:6: ( '/' )
            // src/com/epijava/grammar/EpiJava.g:91:8: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T107

    // $ANTLR start T108
    public final void mT108() throws RecognitionException {
        try {
            int _type = T108;
            // src/com/epijava/grammar/EpiJava.g:92:6: ( '%' )
            // src/com/epijava/grammar/EpiJava.g:92:8: '%'
            {
            match('%'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T108

    // $ANTLR start T109
    public final void mT109() throws RecognitionException {
        try {
            int _type = T109;
            // src/com/epijava/grammar/EpiJava.g:93:6: ( '++' )
            // src/com/epijava/grammar/EpiJava.g:93:8: '++'
            {
            match("++"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T109

    // $ANTLR start T110
    public final void mT110() throws RecognitionException {
        try {
            int _type = T110;
            // src/com/epijava/grammar/EpiJava.g:94:6: ( '--' )
            // src/com/epijava/grammar/EpiJava.g:94:8: '--'
            {
            match("--"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T110

    // $ANTLR start T111
    public final void mT111() throws RecognitionException {
        try {
            int _type = T111;
            // src/com/epijava/grammar/EpiJava.g:95:6: ( '~' )
            // src/com/epijava/grammar/EpiJava.g:95:8: '~'
            {
            match('~'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T111

    // $ANTLR start T112
    public final void mT112() throws RecognitionException {
        try {
            int _type = T112;
            // src/com/epijava/grammar/EpiJava.g:96:6: ( '!' )
            // src/com/epijava/grammar/EpiJava.g:96:8: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T112

    // $ANTLR start T113
    public final void mT113() throws RecognitionException {
        try {
            int _type = T113;
            // src/com/epijava/grammar/EpiJava.g:97:6: ( 'this' )
            // src/com/epijava/grammar/EpiJava.g:97:8: 'this'
            {
            match("this"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T113

    // $ANTLR start T114
    public final void mT114() throws RecognitionException {
        try {
            int _type = T114;
            // src/com/epijava/grammar/EpiJava.g:98:6: ( 'new' )
            // src/com/epijava/grammar/EpiJava.g:98:8: 'new'
            {
            match("new"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T114

    // $ANTLR start HexLiteral
    public final void mHexLiteral() throws RecognitionException {
        try {
            int _type = HexLiteral;
            // src/com/epijava/grammar/EpiJava.g:917:12: ( '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )? )
            // src/com/epijava/grammar/EpiJava.g:917:14: '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // src/com/epijava/grammar/EpiJava.g:917:28: ( HexDigit )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='F')||(LA1_0>='a' && LA1_0<='f')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:917:28: HexDigit
            	    {
            	    mHexDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // src/com/epijava/grammar/EpiJava.g:917:38: ( IntegerTypeSuffix )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='l') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:917:38: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end HexLiteral

    // $ANTLR start DecimalLiteral
    public final void mDecimalLiteral() throws RecognitionException {
        try {
            int _type = DecimalLiteral;
            // src/com/epijava/grammar/EpiJava.g:919:16: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )? )
            // src/com/epijava/grammar/EpiJava.g:919:18: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )?
            {
            // src/com/epijava/grammar/EpiJava.g:919:18: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='0') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("919:18: ( '0' | '1' .. '9' ( '0' .. '9' )* )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:919:19: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:919:25: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // src/com/epijava/grammar/EpiJava.g:919:34: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:919:34: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // src/com/epijava/grammar/EpiJava.g:919:45: ( IntegerTypeSuffix )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='L'||LA5_0=='l') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:919:45: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DecimalLiteral

    // $ANTLR start OctalLiteral
    public final void mOctalLiteral() throws RecognitionException {
        try {
            int _type = OctalLiteral;
            // src/com/epijava/grammar/EpiJava.g:921:14: ( '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )? )
            // src/com/epijava/grammar/EpiJava.g:921:16: '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            // src/com/epijava/grammar/EpiJava.g:921:20: ( '0' .. '7' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='7')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:921:21: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // src/com/epijava/grammar/EpiJava.g:921:32: ( IntegerTypeSuffix )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='L'||LA7_0=='l') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:921:32: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OctalLiteral

    // $ANTLR start HexDigit
    public final void mHexDigit() throws RecognitionException {
        try {
            // src/com/epijava/grammar/EpiJava.g:924:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // src/com/epijava/grammar/EpiJava.g:924:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end HexDigit

    // $ANTLR start IntegerTypeSuffix
    public final void mIntegerTypeSuffix() throws RecognitionException {
        try {
            // src/com/epijava/grammar/EpiJava.g:927:19: ( ( 'l' | 'L' ) )
            // src/com/epijava/grammar/EpiJava.g:927:21: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end IntegerTypeSuffix

    // $ANTLR start FloatingPointLiteral
    public final void mFloatingPointLiteral() throws RecognitionException {
        try {
            int _type = FloatingPointLiteral;
            // src/com/epijava/grammar/EpiJava.g:930:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ ( Exponent )? FloatTypeSuffix )
            int alt19=4;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:930:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )?
                    {
                    // src/com/epijava/grammar/EpiJava.g:930:9: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:930:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    match('.'); 
                    // src/com/epijava/grammar/EpiJava.g:930:25: ( '0' .. '9' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:930:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // src/com/epijava/grammar/EpiJava.g:930:37: ( Exponent )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:930:37: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // src/com/epijava/grammar/EpiJava.g:930:47: ( FloatTypeSuffix )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='D'||LA11_0=='F'||LA11_0=='d'||LA11_0=='f') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:930:47: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:931:9: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )?
                    {
                    match('.'); 
                    // src/com/epijava/grammar/EpiJava.g:931:13: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:931:14: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // src/com/epijava/grammar/EpiJava.g:931:25: ( Exponent )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:931:25: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // src/com/epijava/grammar/EpiJava.g:931:35: ( FloatTypeSuffix )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='D'||LA14_0=='F'||LA14_0=='d'||LA14_0=='f') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:931:35: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:932:9: ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )?
                    {
                    // src/com/epijava/grammar/EpiJava.g:932:9: ( '0' .. '9' )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:932:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    mExponent(); 
                    // src/com/epijava/grammar/EpiJava.g:932:30: ( FloatTypeSuffix )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='D'||LA16_0=='F'||LA16_0=='d'||LA16_0=='f') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:932:30: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // src/com/epijava/grammar/EpiJava.g:933:9: ( '0' .. '9' )+ ( Exponent )? FloatTypeSuffix
                    {
                    // src/com/epijava/grammar/EpiJava.g:933:9: ( '0' .. '9' )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // src/com/epijava/grammar/EpiJava.g:933:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    // src/com/epijava/grammar/EpiJava.g:933:21: ( Exponent )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='E'||LA18_0=='e') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // src/com/epijava/grammar/EpiJava.g:933:21: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    mFloatTypeSuffix(); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FloatingPointLiteral

    // $ANTLR start Exponent
    public final void mExponent() throws RecognitionException {
        try {
            // src/com/epijava/grammar/EpiJava.g:937:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // src/com/epijava/grammar/EpiJava.g:937:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // src/com/epijava/grammar/EpiJava.g:937:22: ( '+' | '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='+'||LA20_0=='-') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // src/com/epijava/grammar/EpiJava.g:937:33: ( '0' .. '9' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='0' && LA21_0<='9')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:937:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end Exponent

    // $ANTLR start FloatTypeSuffix
    public final void mFloatTypeSuffix() throws RecognitionException {
        try {
            // src/com/epijava/grammar/EpiJava.g:940:17: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // src/com/epijava/grammar/EpiJava.g:940:19: ( 'f' | 'F' | 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end FloatTypeSuffix

    // $ANTLR start CharacterLiteral
    public final void mCharacterLiteral() throws RecognitionException {
        try {
            int _type = CharacterLiteral;
            // src/com/epijava/grammar/EpiJava.g:943:5: ( '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // src/com/epijava/grammar/EpiJava.g:943:9: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // src/com/epijava/grammar/EpiJava.g:943:14: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\\') ) {
                alt22=1;
            }
            else if ( ((LA22_0>='\u0000' && LA22_0<='&')||(LA22_0>='(' && LA22_0<='[')||(LA22_0>=']' && LA22_0<='\uFFFE')) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("943:14: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:943:16: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:943:33: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CharacterLiteral

    // $ANTLR start StringLiteral
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            // src/com/epijava/grammar/EpiJava.g:947:5: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
            // src/com/epijava/grammar/EpiJava.g:947:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // src/com/epijava/grammar/EpiJava.g:947:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='\\') ) {
                    alt23=1;
                }
                else if ( ((LA23_0>='\u0000' && LA23_0<='!')||(LA23_0>='#' && LA23_0<='[')||(LA23_0>=']' && LA23_0<='\uFFFE')) ) {
                    alt23=2;
                }


                switch (alt23) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:947:14: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // src/com/epijava/grammar/EpiJava.g:947:31: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end StringLiteral

    // $ANTLR start EscapeSequence
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // src/com/epijava/grammar/EpiJava.g:952:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape )
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt24=1;
                    }
                    break;
                case 'u':
                    {
                    alt24=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt24=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("950:1: fragment EscapeSequence : ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape );", 24, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("950:1: fragment EscapeSequence : ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape );", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:952:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:953:9: UnicodeEscape
                    {
                    mUnicodeEscape(); 

                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:954:9: OctalEscape
                    {
                    mOctalEscape(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end EscapeSequence

    // $ANTLR start OctalEscape
    public final void mOctalEscape() throws RecognitionException {
        try {
            // src/com/epijava/grammar/EpiJava.g:959:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='\\') ) {
                int LA25_1 = input.LA(2);

                if ( ((LA25_1>='0' && LA25_1<='3')) ) {
                    int LA25_2 = input.LA(3);

                    if ( ((LA25_2>='0' && LA25_2<='7')) ) {
                        int LA25_5 = input.LA(4);

                        if ( ((LA25_5>='0' && LA25_5<='7')) ) {
                            alt25=1;
                        }
                        else {
                            alt25=2;}
                    }
                    else {
                        alt25=3;}
                }
                else if ( ((LA25_1>='4' && LA25_1<='7')) ) {
                    int LA25_3 = input.LA(3);

                    if ( ((LA25_3>='0' && LA25_3<='7')) ) {
                        alt25=2;
                    }
                    else {
                        alt25=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("957:1: fragment OctalEscape : ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) );", 25, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("957:1: fragment OctalEscape : ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) );", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:959:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // src/com/epijava/grammar/EpiJava.g:959:14: ( '0' .. '3' )
                    // src/com/epijava/grammar/EpiJava.g:959:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // src/com/epijava/grammar/EpiJava.g:959:25: ( '0' .. '7' )
                    // src/com/epijava/grammar/EpiJava.g:959:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // src/com/epijava/grammar/EpiJava.g:959:36: ( '0' .. '7' )
                    // src/com/epijava/grammar/EpiJava.g:959:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // src/com/epijava/grammar/EpiJava.g:960:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // src/com/epijava/grammar/EpiJava.g:960:14: ( '0' .. '7' )
                    // src/com/epijava/grammar/EpiJava.g:960:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // src/com/epijava/grammar/EpiJava.g:960:25: ( '0' .. '7' )
                    // src/com/epijava/grammar/EpiJava.g:960:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // src/com/epijava/grammar/EpiJava.g:961:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // src/com/epijava/grammar/EpiJava.g:961:14: ( '0' .. '7' )
                    // src/com/epijava/grammar/EpiJava.g:961:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end OctalEscape

    // $ANTLR start UnicodeEscape
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // src/com/epijava/grammar/EpiJava.g:966:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // src/com/epijava/grammar/EpiJava.g:966:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); 
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end UnicodeEscape

    // $ANTLR start ENUM
    public final void mENUM() throws RecognitionException {
        try {
            int _type = ENUM;
            // src/com/epijava/grammar/EpiJava.g:969:5: ( 'enum' )
            // src/com/epijava/grammar/EpiJava.g:969:7: 'enum'
            {
            match("enum"); 

            if ( !enumIsKeyword ) _type=Identifier;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ENUM

    // $ANTLR start Identifier
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            // src/com/epijava/grammar/EpiJava.g:973:5: ( Letter ( Letter | JavaIDDigit )* )
            // src/com/epijava/grammar/EpiJava.g:973:9: Letter ( Letter | JavaIDDigit )*
            {
            mLetter(); 
            // src/com/epijava/grammar/EpiJava.g:973:16: ( Letter | JavaIDDigit )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0=='$'||(LA26_0>='0' && LA26_0<='9')||(LA26_0>='A' && LA26_0<='Z')||LA26_0=='_'||(LA26_0>='a' && LA26_0<='z')||(LA26_0>='\u00C0' && LA26_0<='\u00D6')||(LA26_0>='\u00D8' && LA26_0<='\u00F6')||(LA26_0>='\u00F8' && LA26_0<='\u1FFF')||(LA26_0>='\u3040' && LA26_0<='\u318F')||(LA26_0>='\u3300' && LA26_0<='\u337F')||(LA26_0>='\u3400' && LA26_0<='\u3D2D')||(LA26_0>='\u4E00' && LA26_0<='\u9FFF')||(LA26_0>='\uF900' && LA26_0<='\uFAFF')) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Identifier

    // $ANTLR start Letter
    public final void mLetter() throws RecognitionException {
        try {
            // src/com/epijava/grammar/EpiJava.g:981:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // src/com/epijava/grammar/EpiJava.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Letter

    // $ANTLR start JavaIDDigit
    public final void mJavaIDDigit() throws RecognitionException {
        try {
            // src/com/epijava/grammar/EpiJava.g:998:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06f0' .. '\\u06f9' | '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' | '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7' .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' | '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' .. '\\u0ed9' | '\\u1040' .. '\\u1049' )
            // src/com/epijava/grammar/EpiJava.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06F9')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09EF')||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A6F')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end JavaIDDigit

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // src/com/epijava/grammar/EpiJava.g:1015:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // src/com/epijava/grammar/EpiJava.g:1015:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start JAVADOC
    public final void mJAVADOC() throws RecognitionException {
        try {
            int _type = JAVADOC;
            // src/com/epijava/grammar/EpiJava.g:1019:5: ( '/**' ( options {greedy=false; } : . )* '*/' )
            // src/com/epijava/grammar/EpiJava.g:1019:9: '/**' ( options {greedy=false; } : . )* '*/'
            {
            match("/**"); 

            // src/com/epijava/grammar/EpiJava.g:1019:15: ( options {greedy=false; } : . )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0=='*') ) {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1=='/') ) {
                        alt27=2;
                    }
                    else if ( ((LA27_1>='\u0000' && LA27_1<='.')||(LA27_1>='0' && LA27_1<='\uFFFE')) ) {
                        alt27=1;
                    }


                }
                else if ( ((LA27_0>='\u0000' && LA27_0<=')')||(LA27_0>='+' && LA27_0<='\uFFFE')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:1019:43: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end JAVADOC

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // src/com/epijava/grammar/EpiJava.g:1023:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // src/com/epijava/grammar/EpiJava.g:1023:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // src/com/epijava/grammar/EpiJava.g:1023:14: ( options {greedy=false; } : . )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0=='*') ) {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1=='/') ) {
                        alt28=2;
                    }
                    else if ( ((LA28_1>='\u0000' && LA28_1<='.')||(LA28_1>='0' && LA28_1<='\uFFFE')) ) {
                        alt28=1;
                    }


                }
                else if ( ((LA28_0>='\u0000' && LA28_0<=')')||(LA28_0>='+' && LA28_0<='\uFFFE')) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:1023:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    // $ANTLR start LINE_COMMENT
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            // src/com/epijava/grammar/EpiJava.g:1027:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // src/com/epijava/grammar/EpiJava.g:1027:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // src/com/epijava/grammar/EpiJava.g:1027:12: (~ ( '\\n' | '\\r' ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='\u0000' && LA29_0<='\t')||(LA29_0>='\u000B' && LA29_0<='\f')||(LA29_0>='\u000E' && LA29_0<='\uFFFE')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // src/com/epijava/grammar/EpiJava.g:1027:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // src/com/epijava/grammar/EpiJava.g:1027:26: ( '\\r' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0=='\r') ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // src/com/epijava/grammar/EpiJava.g:1027:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LINE_COMMENT

    public void mTokens() throws RecognitionException {
        // src/com/epijava/grammar/EpiJava.g:1:8: ( T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | ENUM | Identifier | WS | JAVADOC | COMMENT | LINE_COMMENT )
        int alt31=102;
        alt31 = dfa31.predict(input);
        switch (alt31) {
            case 1 :
                // src/com/epijava/grammar/EpiJava.g:1:10: T25
                {
                mT25(); 

                }
                break;
            case 2 :
                // src/com/epijava/grammar/EpiJava.g:1:14: T26
                {
                mT26(); 

                }
                break;
            case 3 :
                // src/com/epijava/grammar/EpiJava.g:1:18: T27
                {
                mT27(); 

                }
                break;
            case 4 :
                // src/com/epijava/grammar/EpiJava.g:1:22: T28
                {
                mT28(); 

                }
                break;
            case 5 :
                // src/com/epijava/grammar/EpiJava.g:1:26: T29
                {
                mT29(); 

                }
                break;
            case 6 :
                // src/com/epijava/grammar/EpiJava.g:1:30: T30
                {
                mT30(); 

                }
                break;
            case 7 :
                // src/com/epijava/grammar/EpiJava.g:1:34: T31
                {
                mT31(); 

                }
                break;
            case 8 :
                // src/com/epijava/grammar/EpiJava.g:1:38: T32
                {
                mT32(); 

                }
                break;
            case 9 :
                // src/com/epijava/grammar/EpiJava.g:1:42: T33
                {
                mT33(); 

                }
                break;
            case 10 :
                // src/com/epijava/grammar/EpiJava.g:1:46: T34
                {
                mT34(); 

                }
                break;
            case 11 :
                // src/com/epijava/grammar/EpiJava.g:1:50: T35
                {
                mT35(); 

                }
                break;
            case 12 :
                // src/com/epijava/grammar/EpiJava.g:1:54: T36
                {
                mT36(); 

                }
                break;
            case 13 :
                // src/com/epijava/grammar/EpiJava.g:1:58: T37
                {
                mT37(); 

                }
                break;
            case 14 :
                // src/com/epijava/grammar/EpiJava.g:1:62: T38
                {
                mT38(); 

                }
                break;
            case 15 :
                // src/com/epijava/grammar/EpiJava.g:1:66: T39
                {
                mT39(); 

                }
                break;
            case 16 :
                // src/com/epijava/grammar/EpiJava.g:1:70: T40
                {
                mT40(); 

                }
                break;
            case 17 :
                // src/com/epijava/grammar/EpiJava.g:1:74: T41
                {
                mT41(); 

                }
                break;
            case 18 :
                // src/com/epijava/grammar/EpiJava.g:1:78: T42
                {
                mT42(); 

                }
                break;
            case 19 :
                // src/com/epijava/grammar/EpiJava.g:1:82: T43
                {
                mT43(); 

                }
                break;
            case 20 :
                // src/com/epijava/grammar/EpiJava.g:1:86: T44
                {
                mT44(); 

                }
                break;
            case 21 :
                // src/com/epijava/grammar/EpiJava.g:1:90: T45
                {
                mT45(); 

                }
                break;
            case 22 :
                // src/com/epijava/grammar/EpiJava.g:1:94: T46
                {
                mT46(); 

                }
                break;
            case 23 :
                // src/com/epijava/grammar/EpiJava.g:1:98: T47
                {
                mT47(); 

                }
                break;
            case 24 :
                // src/com/epijava/grammar/EpiJava.g:1:102: T48
                {
                mT48(); 

                }
                break;
            case 25 :
                // src/com/epijava/grammar/EpiJava.g:1:106: T49
                {
                mT49(); 

                }
                break;
            case 26 :
                // src/com/epijava/grammar/EpiJava.g:1:110: T50
                {
                mT50(); 

                }
                break;
            case 27 :
                // src/com/epijava/grammar/EpiJava.g:1:114: T51
                {
                mT51(); 

                }
                break;
            case 28 :
                // src/com/epijava/grammar/EpiJava.g:1:118: T52
                {
                mT52(); 

                }
                break;
            case 29 :
                // src/com/epijava/grammar/EpiJava.g:1:122: T53
                {
                mT53(); 

                }
                break;
            case 30 :
                // src/com/epijava/grammar/EpiJava.g:1:126: T54
                {
                mT54(); 

                }
                break;
            case 31 :
                // src/com/epijava/grammar/EpiJava.g:1:130: T55
                {
                mT55(); 

                }
                break;
            case 32 :
                // src/com/epijava/grammar/EpiJava.g:1:134: T56
                {
                mT56(); 

                }
                break;
            case 33 :
                // src/com/epijava/grammar/EpiJava.g:1:138: T57
                {
                mT57(); 

                }
                break;
            case 34 :
                // src/com/epijava/grammar/EpiJava.g:1:142: T58
                {
                mT58(); 

                }
                break;
            case 35 :
                // src/com/epijava/grammar/EpiJava.g:1:146: T59
                {
                mT59(); 

                }
                break;
            case 36 :
                // src/com/epijava/grammar/EpiJava.g:1:150: T60
                {
                mT60(); 

                }
                break;
            case 37 :
                // src/com/epijava/grammar/EpiJava.g:1:154: T61
                {
                mT61(); 

                }
                break;
            case 38 :
                // src/com/epijava/grammar/EpiJava.g:1:158: T62
                {
                mT62(); 

                }
                break;
            case 39 :
                // src/com/epijava/grammar/EpiJava.g:1:162: T63
                {
                mT63(); 

                }
                break;
            case 40 :
                // src/com/epijava/grammar/EpiJava.g:1:166: T64
                {
                mT64(); 

                }
                break;
            case 41 :
                // src/com/epijava/grammar/EpiJava.g:1:170: T65
                {
                mT65(); 

                }
                break;
            case 42 :
                // src/com/epijava/grammar/EpiJava.g:1:174: T66
                {
                mT66(); 

                }
                break;
            case 43 :
                // src/com/epijava/grammar/EpiJava.g:1:178: T67
                {
                mT67(); 

                }
                break;
            case 44 :
                // src/com/epijava/grammar/EpiJava.g:1:182: T68
                {
                mT68(); 

                }
                break;
            case 45 :
                // src/com/epijava/grammar/EpiJava.g:1:186: T69
                {
                mT69(); 

                }
                break;
            case 46 :
                // src/com/epijava/grammar/EpiJava.g:1:190: T70
                {
                mT70(); 

                }
                break;
            case 47 :
                // src/com/epijava/grammar/EpiJava.g:1:194: T71
                {
                mT71(); 

                }
                break;
            case 48 :
                // src/com/epijava/grammar/EpiJava.g:1:198: T72
                {
                mT72(); 

                }
                break;
            case 49 :
                // src/com/epijava/grammar/EpiJava.g:1:202: T73
                {
                mT73(); 

                }
                break;
            case 50 :
                // src/com/epijava/grammar/EpiJava.g:1:206: T74
                {
                mT74(); 

                }
                break;
            case 51 :
                // src/com/epijava/grammar/EpiJava.g:1:210: T75
                {
                mT75(); 

                }
                break;
            case 52 :
                // src/com/epijava/grammar/EpiJava.g:1:214: T76
                {
                mT76(); 

                }
                break;
            case 53 :
                // src/com/epijava/grammar/EpiJava.g:1:218: T77
                {
                mT77(); 

                }
                break;
            case 54 :
                // src/com/epijava/grammar/EpiJava.g:1:222: T78
                {
                mT78(); 

                }
                break;
            case 55 :
                // src/com/epijava/grammar/EpiJava.g:1:226: T79
                {
                mT79(); 

                }
                break;
            case 56 :
                // src/com/epijava/grammar/EpiJava.g:1:230: T80
                {
                mT80(); 

                }
                break;
            case 57 :
                // src/com/epijava/grammar/EpiJava.g:1:234: T81
                {
                mT81(); 

                }
                break;
            case 58 :
                // src/com/epijava/grammar/EpiJava.g:1:238: T82
                {
                mT82(); 

                }
                break;
            case 59 :
                // src/com/epijava/grammar/EpiJava.g:1:242: T83
                {
                mT83(); 

                }
                break;
            case 60 :
                // src/com/epijava/grammar/EpiJava.g:1:246: T84
                {
                mT84(); 

                }
                break;
            case 61 :
                // src/com/epijava/grammar/EpiJava.g:1:250: T85
                {
                mT85(); 

                }
                break;
            case 62 :
                // src/com/epijava/grammar/EpiJava.g:1:254: T86
                {
                mT86(); 

                }
                break;
            case 63 :
                // src/com/epijava/grammar/EpiJava.g:1:258: T87
                {
                mT87(); 

                }
                break;
            case 64 :
                // src/com/epijava/grammar/EpiJava.g:1:262: T88
                {
                mT88(); 

                }
                break;
            case 65 :
                // src/com/epijava/grammar/EpiJava.g:1:266: T89
                {
                mT89(); 

                }
                break;
            case 66 :
                // src/com/epijava/grammar/EpiJava.g:1:270: T90
                {
                mT90(); 

                }
                break;
            case 67 :
                // src/com/epijava/grammar/EpiJava.g:1:274: T91
                {
                mT91(); 

                }
                break;
            case 68 :
                // src/com/epijava/grammar/EpiJava.g:1:278: T92
                {
                mT92(); 

                }
                break;
            case 69 :
                // src/com/epijava/grammar/EpiJava.g:1:282: T93
                {
                mT93(); 

                }
                break;
            case 70 :
                // src/com/epijava/grammar/EpiJava.g:1:286: T94
                {
                mT94(); 

                }
                break;
            case 71 :
                // src/com/epijava/grammar/EpiJava.g:1:290: T95
                {
                mT95(); 

                }
                break;
            case 72 :
                // src/com/epijava/grammar/EpiJava.g:1:294: T96
                {
                mT96(); 

                }
                break;
            case 73 :
                // src/com/epijava/grammar/EpiJava.g:1:298: T97
                {
                mT97(); 

                }
                break;
            case 74 :
                // src/com/epijava/grammar/EpiJava.g:1:302: T98
                {
                mT98(); 

                }
                break;
            case 75 :
                // src/com/epijava/grammar/EpiJava.g:1:306: T99
                {
                mT99(); 

                }
                break;
            case 76 :
                // src/com/epijava/grammar/EpiJava.g:1:310: T100
                {
                mT100(); 

                }
                break;
            case 77 :
                // src/com/epijava/grammar/EpiJava.g:1:315: T101
                {
                mT101(); 

                }
                break;
            case 78 :
                // src/com/epijava/grammar/EpiJava.g:1:320: T102
                {
                mT102(); 

                }
                break;
            case 79 :
                // src/com/epijava/grammar/EpiJava.g:1:325: T103
                {
                mT103(); 

                }
                break;
            case 80 :
                // src/com/epijava/grammar/EpiJava.g:1:330: T104
                {
                mT104(); 

                }
                break;
            case 81 :
                // src/com/epijava/grammar/EpiJava.g:1:335: T105
                {
                mT105(); 

                }
                break;
            case 82 :
                // src/com/epijava/grammar/EpiJava.g:1:340: T106
                {
                mT106(); 

                }
                break;
            case 83 :
                // src/com/epijava/grammar/EpiJava.g:1:345: T107
                {
                mT107(); 

                }
                break;
            case 84 :
                // src/com/epijava/grammar/EpiJava.g:1:350: T108
                {
                mT108(); 

                }
                break;
            case 85 :
                // src/com/epijava/grammar/EpiJava.g:1:355: T109
                {
                mT109(); 

                }
                break;
            case 86 :
                // src/com/epijava/grammar/EpiJava.g:1:360: T110
                {
                mT110(); 

                }
                break;
            case 87 :
                // src/com/epijava/grammar/EpiJava.g:1:365: T111
                {
                mT111(); 

                }
                break;
            case 88 :
                // src/com/epijava/grammar/EpiJava.g:1:370: T112
                {
                mT112(); 

                }
                break;
            case 89 :
                // src/com/epijava/grammar/EpiJava.g:1:375: T113
                {
                mT113(); 

                }
                break;
            case 90 :
                // src/com/epijava/grammar/EpiJava.g:1:380: T114
                {
                mT114(); 

                }
                break;
            case 91 :
                // src/com/epijava/grammar/EpiJava.g:1:385: HexLiteral
                {
                mHexLiteral(); 

                }
                break;
            case 92 :
                // src/com/epijava/grammar/EpiJava.g:1:396: DecimalLiteral
                {
                mDecimalLiteral(); 

                }
                break;
            case 93 :
                // src/com/epijava/grammar/EpiJava.g:1:411: OctalLiteral
                {
                mOctalLiteral(); 

                }
                break;
            case 94 :
                // src/com/epijava/grammar/EpiJava.g:1:424: FloatingPointLiteral
                {
                mFloatingPointLiteral(); 

                }
                break;
            case 95 :
                // src/com/epijava/grammar/EpiJava.g:1:445: CharacterLiteral
                {
                mCharacterLiteral(); 

                }
                break;
            case 96 :
                // src/com/epijava/grammar/EpiJava.g:1:462: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 97 :
                // src/com/epijava/grammar/EpiJava.g:1:476: ENUM
                {
                mENUM(); 

                }
                break;
            case 98 :
                // src/com/epijava/grammar/EpiJava.g:1:481: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 99 :
                // src/com/epijava/grammar/EpiJava.g:1:492: WS
                {
                mWS(); 

                }
                break;
            case 100 :
                // src/com/epijava/grammar/EpiJava.g:1:495: JAVADOC
                {
                mJAVADOC(); 

                }
                break;
            case 101 :
                // src/com/epijava/grammar/EpiJava.g:1:503: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 102 :
                // src/com/epijava/grammar/EpiJava.g:1:511: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA31 dfa31 = new DFA31(this);
    static final String DFA19_eotS =
        "\7\uffff\1\10\2\uffff";
    static final String DFA19_eofS =
        "\12\uffff";
    static final String DFA19_minS =
        "\2\56\1\uffff\1\53\2\uffff\2\60\2\uffff";
    static final String DFA19_maxS =
        "\1\71\1\146\1\uffff\1\71\2\uffff\1\71\1\146\2\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\1\2\uffff\2\3";
    static final String DFA19_specialS =
        "\12\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\5\1\uffff\12\1\12\uffff\1\4\1\3\1\4\35\uffff\1\4\1\3\1\4",
            "",
            "\1\6\1\uffff\1\6\2\uffff\12\7",
            "",
            "",
            "\12\7",
            "\12\7\12\uffff\1\11\1\uffff\1\11\35\uffff\1\11\1\uffff\1\11",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "929:1: FloatingPointLiteral : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ ( Exponent )? FloatTypeSuffix );";
        }
    }
    static final String DFA31_eotS =
        "\1\uffff\1\55\1\uffff\2\55\1\74\1\76\2\55\3\uffff\1\110\2\uffff"+
        "\1\55\2\uffff\1\55\1\115\6\55\5\uffff\2\55\1\141\1\144\1\150\1\153"+
        "\1\155\1\157\1\161\1\uffff\2\164\4\uffff\5\55\1\175\5\55\5\uffff"+
        "\7\55\3\uffff\3\55\2\uffff\15\55\1\u00a1\3\55\24\uffff\1\u00a7\1"+
        "\uffff\1\164\5\55\1\u00ae\1\55\1\uffff\21\55\1\u00c2\7\55\1\u00ca"+
        "\1\55\1\u00cc\7\55\1\uffff\3\55\3\uffff\6\55\1\uffff\11\55\1\u00e9"+
        "\1\55\1\u00eb\1\55\1\u00ed\1\u00ee\2\55\1\u00f1\1\55\1\uffff\1\u00f3"+
        "\1\u00f4\5\55\1\uffff\1\55\1\uffff\1\u00fb\3\55\1\u00ff\1\u0100"+
        "\4\55\1\u00a6\2\uffff\12\55\1\u0110\2\55\1\u0113\1\u0114\1\uffff"+
        "\1\55\1\uffff\1\u0116\2\uffff\2\55\1\uffff\1\55\2\uffff\1\u011b"+
        "\2\55\1\u011e\1\u0120\1\u0121\1\uffff\2\55\1\u0124\2\uffff\2\55"+
        "\1\u0127\1\55\1\u0129\2\55\1\u012c\3\55\1\u0130\1\55\1\u0132\1\55"+
        "\1\uffff\1\55\1\u0135\2\uffff\1\55\1\uffff\3\55\1\u013a\1\uffff"+
        "\1\55\1\u013c\1\uffff\1\55\2\uffff\1\u013e\1\55\1\uffff\1\u0140"+
        "\1\55\1\uffff\1\u0142\1\uffff\1\55\1\u0144\1\uffff\1\u0145\2\55"+
        "\1\uffff\1\55\1\uffff\2\55\1\uffff\1\55\1\u014c\2\55\1\uffff\1\55"+
        "\1\uffff\1\u0150\1\uffff\1\u0151\1\uffff\1\u0152\1\uffff\1\55\2"+
        "\uffff\3\55\1\u0157\1\55\1\u0159\1\uffff\1\u015a\1\55\1\u015c\3"+
        "\uffff\1\u015d\1\55\1\u015f\1\55\1\uffff\1\55\2\uffff\1\u0162\2"+
        "\uffff\1\u0163\1\uffff\1\u0164\1\55\3\uffff\1\55\1\u0167\1\uffff";
    static final String DFA31_eofS =
        "\u0168\uffff";
    static final String DFA31_minS =
        "\1\11\1\141\1\uffff\1\146\1\150\1\56\1\75\1\141\1\154\3\uffff\1"+
        "\46\2\uffff\1\157\2\uffff\1\150\1\75\1\142\2\141\2\157\1\145\5\uffff"+
        "\1\150\1\145\1\53\1\55\1\52\4\75\1\uffff\2\56\4\uffff\1\151\1\142"+
        "\1\143\1\163\1\160\1\44\1\141\1\157\1\156\1\151\1\160\5\uffff\1"+
        "\163\1\156\2\141\1\163\1\165\1\164\3\uffff\1\151\1\141\1\151\2\uffff"+
        "\2\163\1\154\1\156\1\162\1\157\1\167\1\154\1\164\1\157\1\145\1\164"+
        "\1\156\1\44\1\146\1\151\1\164\7\uffff\1\0\14\uffff\1\56\1\uffff"+
        "\1\56\1\164\1\166\1\154\1\153\1\164\1\44\1\154\1\uffff\1\164\1\151"+
        "\1\162\1\143\1\164\1\145\1\143\1\145\1\164\1\162\1\163\1\145\1\155"+
        "\1\145\1\141\1\144\1\156\1\44\1\145\1\163\1\157\1\164\1\145\1\163"+
        "\1\141\1\44\1\141\1\44\1\154\1\151\1\154\1\141\1\145\1\147\1\142"+
        "\1\uffff\1\141\1\154\1\165\1\0\2\uffff\1\145\1\141\1\151\2\141\1"+
        "\162\1\uffff\1\162\1\145\1\151\1\143\1\164\1\150\1\143\1\162\1\150"+
        "\1\44\1\151\1\44\1\163\2\44\1\156\1\164\1\44\1\163\1\uffff\2\44"+
        "\1\167\2\162\1\145\1\154\1\uffff\1\164\1\uffff\1\44\1\166\1\145"+
        "\1\153\2\44\1\154\1\165\1\145\1\162\3\0\1\143\1\164\1\143\1\147"+
        "\1\156\1\146\1\164\1\155\1\143\1\164\1\44\1\162\1\150\2\44\1\uffff"+
        "\1\156\1\uffff\1\44\2\uffff\1\144\1\151\1\uffff\1\151\2\uffff\1"+
        "\44\1\141\1\164\3\44\1\uffff\1\145\1\141\1\44\2\uffff\1\145\1\154"+
        "\1\44\1\156\1\0\1\164\1\145\1\44\1\145\1\143\1\141\1\44\1\145\1"+
        "\44\1\146\1\uffff\1\157\1\44\2\uffff\1\165\1\uffff\1\163\1\154\1"+
        "\145\1\44\1\uffff\1\143\1\44\1\uffff\1\171\2\uffff\1\44\1\156\1"+
        "\uffff\1\44\1\164\1\uffff\1\44\1\uffff\1\145\1\44\1\uffff\1\44\1"+
        "\145\1\143\1\uffff\1\156\1\uffff\1\160\1\156\1\uffff\1\145\1\44"+
        "\1\145\1\156\1\uffff\1\164\1\uffff\1\44\1\uffff\1\44\1\uffff\1\44"+
        "\1\uffff\1\144\2\uffff\1\157\1\145\1\164\1\44\1\151\1\44\1\uffff"+
        "\1\44\1\164\1\44\3\uffff\1\44\1\146\1\44\1\163\1\uffff\1\172\2\uffff"+
        "\1\44\2\uffff\1\44\1\uffff\1\44\1\145\3\uffff\1\144\1\44\1\uffff";
    static final String DFA31_maxS =
        "\1\ufaff\1\165\1\uffff\1\156\1\171\1\71\1\75\1\157\1\170\3\uffff"+
        "\1\75\2\uffff\1\157\2\uffff\1\162\1\75\1\163\1\157\1\165\1\171\2"+
        "\157\5\uffff\1\150\1\145\3\75\1\174\3\75\1\uffff\1\170\1\146\4\uffff"+
        "\1\157\1\142\1\143\1\164\1\160\1\ufaff\1\162\1\157\1\156\1\151\1"+
        "\160\5\uffff\1\164\1\156\2\141\1\163\1\165\1\164\3\uffff\1\154\1"+
        "\171\1\162\2\uffff\2\163\1\154\1\156\1\162\1\157\1\167\1\154\1\164"+
        "\1\157\1\145\1\164\1\156\1\ufaff\1\146\1\151\1\164\7\uffff\1\ufffe"+
        "\14\uffff\1\146\1\uffff\1\146\1\164\1\166\1\154\1\153\1\164\1\ufaff"+
        "\1\157\1\uffff\1\164\1\151\1\162\1\143\1\164\1\145\1\143\1\145\1"+
        "\164\1\162\1\163\1\145\1\155\1\145\1\141\1\144\1\156\1\ufaff\1\145"+
        "\1\163\1\157\1\164\1\145\1\163\1\141\1\ufaff\1\141\1\ufaff\1\154"+
        "\1\151\1\154\1\141\1\145\1\147\1\142\1\uffff\1\141\1\154\1\165\1"+
        "\ufffe\2\uffff\1\145\1\141\1\151\2\141\1\162\1\uffff\1\162\1\145"+
        "\1\151\1\143\1\164\1\150\1\143\1\162\1\150\1\ufaff\1\151\1\ufaff"+
        "\1\163\2\ufaff\1\156\1\164\1\ufaff\1\163\1\uffff\2\ufaff\1\167\2"+
        "\162\1\145\1\154\1\uffff\1\164\1\uffff\1\ufaff\1\166\1\145\1\153"+
        "\2\ufaff\1\154\1\165\1\145\1\162\3\ufffe\1\143\1\164\1\143\1\147"+
        "\1\156\1\146\1\164\1\155\1\143\1\164\1\ufaff\1\162\1\150\2\ufaff"+
        "\1\uffff\1\156\1\uffff\1\ufaff\2\uffff\1\144\1\151\1\uffff\1\151"+
        "\2\uffff\1\ufaff\1\141\1\164\3\ufaff\1\uffff\1\145\1\141\1\ufaff"+
        "\2\uffff\1\145\1\154\1\ufaff\1\156\1\ufffe\1\164\1\145\1\ufaff\1"+
        "\145\1\143\1\141\1\ufaff\1\145\1\ufaff\1\146\1\uffff\1\157\1\ufaff"+
        "\2\uffff\1\165\1\uffff\1\163\1\154\1\145\1\ufaff\1\uffff\1\143\1"+
        "\ufaff\1\uffff\1\171\2\uffff\1\ufaff\1\156\1\uffff\1\ufaff\1\164"+
        "\1\uffff\1\ufaff\1\uffff\1\145\1\ufaff\1\uffff\1\ufaff\1\145\1\143"+
        "\1\uffff\1\156\1\uffff\1\160\1\156\1\uffff\1\145\1\ufaff\1\145\1"+
        "\156\1\uffff\1\164\1\uffff\1\ufaff\1\uffff\1\ufaff\1\uffff\1\ufaff"+
        "\1\uffff\1\144\2\uffff\1\157\1\145\1\164\1\ufaff\1\151\1\ufaff\1"+
        "\uffff\1\ufaff\1\164\1\ufaff\3\uffff\1\ufaff\1\146\1\ufaff\1\163"+
        "\1\uffff\1\172\2\uffff\1\ufaff\2\uffff\1\ufaff\1\uffff\1\ufaff\1"+
        "\145\3\uffff\1\144\1\ufaff\1\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\6\uffff\1\12\1\13\1\14\1\uffff\1\16\1\17\1\uffff\1"+
        "\22\1\23\10\uffff\1\50\1\52\1\53\1\60\1\63\11\uffff\1\127\2\uffff"+
        "\1\137\1\140\1\142\1\143\13\uffff\1\54\1\136\1\5\1\104\1\6\7\uffff"+
        "\1\106\1\113\1\15\3\uffff\1\116\1\25\21\uffff\1\102\1\125\1\121"+
        "\1\103\1\126\1\122\1\105\1\uffff\1\146\1\123\1\112\1\107\1\114\1"+
        "\110\1\115\1\111\1\124\1\117\1\130\1\133\1\uffff\1\134\10\uffff"+
        "\1\64\43\uffff\1\70\4\uffff\1\145\1\135\6\uffff\1\44\23\uffff\1"+
        "\71\7\uffff\1\66\1\uffff\1\132\34\uffff\1\101\1\uffff\1\41\1\uffff"+
        "\1\65\1\141\2\uffff\1\21\1\uffff\1\56\1\131\6\uffff\1\55\3\uffff"+
        "\1\42\1\45\17\uffff\1\43\2\uffff\1\51\1\100\1\uffff\1\7\4\uffff"+
        "\1\75\2\uffff\1\57\1\uffff\1\32\1\46\2\uffff\1\76\2\uffff\1\67\1"+
        "\uffff\1\144\2\uffff\1\26\3\uffff\1\3\1\uffff\1\4\2\uffff\1\73\4"+
        "\uffff\1\24\1\uffff\1\62\1\uffff\1\33\1\uffff\1\47\1\uffff\1\74"+
        "\1\uffff\1\30\1\1\6\uffff\1\10\3\uffff\1\72\1\40\1\61\4\uffff\1"+
        "\37\1\uffff\1\77\1\36\1\uffff\1\31\1\27\1\uffff\1\20\2\uffff\1\35"+
        "\1\120\1\11\2\uffff\1\34";
    static final String DFA31_specialS =
        "\u0168\uffff}>";
    static final String[] DFA31_transitionS = {
            "\2\56\1\uffff\2\56\22\uffff\1\56\1\47\1\54\1\uffff\1\55\1\46"+
            "\1\14\1\53\1\33\1\34\1\6\1\41\1\12\1\42\1\5\1\43\1\51\11\52"+
            "\1\36\1\2\1\11\1\23\1\13\1\32\1\35\32\55\1\20\1\uffff\1\21\1"+
            "\45\1\55\1\uffff\1\24\1\27\1\7\1\31\1\10\1\25\2\55\1\3\2\55"+
            "\1\30\1\55\1\26\1\55\1\1\1\55\1\40\1\4\1\22\1\55\1\17\1\37\3"+
            "\55\1\15\1\44\1\16\1\50\101\uffff\27\55\1\uffff\37\55\1\uffff"+
            "\u1f08\55\u1040\uffff\u0150\55\u0170\uffff\u0080\55\u0080\uffff"+
            "\u092e\55\u10d2\uffff\u5200\55\u5900\uffff\u0200\55",
            "\1\61\20\uffff\1\57\2\uffff\1\60",
            "",
            "\1\64\6\uffff\1\63\1\62",
            "\1\66\13\uffff\1\65\1\71\1\uffff\1\70\1\uffff\1\67",
            "\1\72\1\uffff\12\73",
            "\1\75",
            "\1\77\6\uffff\1\101\3\uffff\1\102\2\uffff\1\100",
            "\1\103\1\uffff\1\104\11\uffff\1\105",
            "",
            "",
            "",
            "\1\107\26\uffff\1\106",
            "",
            "",
            "\1\111",
            "",
            "",
            "\1\113\11\uffff\1\112",
            "\1\114",
            "\1\116\20\uffff\1\117",
            "\1\120\7\uffff\1\121\2\uffff\1\123\2\uffff\1\122",
            "\1\126\3\uffff\1\124\17\uffff\1\125",
            "\1\127\2\uffff\1\130\6\uffff\1\131",
            "\1\132",
            "\1\134\11\uffff\1\133",
            "",
            "",
            "",
            "",
            "",
            "\1\135",
            "\1\136",
            "\1\140\21\uffff\1\137",
            "\1\143\17\uffff\1\142",
            "\1\146\4\uffff\1\147\15\uffff\1\145",
            "\1\152\76\uffff\1\151",
            "\1\154",
            "\1\156",
            "\1\160",
            "",
            "\1\73\1\uffff\10\163\2\73\12\uffff\3\73\21\uffff\1\162\13\uffff"+
            "\3\73\21\uffff\1\162",
            "\1\73\1\uffff\12\165\12\uffff\3\73\35\uffff\3\73",
            "",
            "",
            "",
            "",
            "\1\167\5\uffff\1\166",
            "\1\170",
            "\1\171",
            "\1\172\1\173",
            "\1\174",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\176\20\uffff\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "",
            "",
            "",
            "",
            "",
            "\1\u0085\1\u0084",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "",
            "",
            "",
            "\1\u008d\2\uffff\1\u008c",
            "\1\u008e\23\uffff\1\u0090\3\uffff\1\u008f",
            "\1\u0091\10\uffff\1\u0092",
            "",
            "",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\24\55"+
            "\1\u00a0\5\55\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55"+
            "\u1040\uffff\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e"+
            "\55\u10d2\uffff\u5200\55\u5900\uffff\u0200\55",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\52\u00a6\1\u00a5\uffd4\u00a6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\73\1\uffff\10\163\2\73\12\uffff\3\73\35\uffff\3\73",
            "",
            "\1\73\1\uffff\12\165\12\uffff\3\73\35\uffff\3\73",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\4\55"+
            "\1\u00ad\25\55\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55"+
            "\u1040\uffff\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e"+
            "\55\u10d2\uffff\u5200\55\u5900\uffff\u0200\55",
            "\1\u00b0\2\uffff\1\u00af",
            "",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u00cb",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\52\u00d9\1\u00d8\4\u00d9\1\u00d7\uffcf\u00d9",
            "",
            "",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u00ea",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u00ec",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u00ef",
            "\1\u00f0",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u00f2",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "",
            "\1\u00fa",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\52\u00d9\1\u00d8\uffd4\u00d9",
            "\52\u00d9\1\u00d8\4\u00d9\1\u0105\uffcf\u00d9",
            "\52\u00d9\1\u00d8\uffd4\u00d9",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0111",
            "\1\u0112",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\u0115",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "",
            "\1\u0117",
            "\1\u0118",
            "",
            "\1\u0119",
            "",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55"+
            "\1\u011a\7\55\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55"+
            "\u1040\uffff\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e"+
            "\55\u10d2\uffff\u5200\55\u5900\uffff\u0200\55",
            "\1\u011c",
            "\1\u011d",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\13\55"+
            "\1\u011f\16\55\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55"+
            "\u1040\uffff\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e"+
            "\55\u10d2\uffff\u5200\55\u5900\uffff\u0200\55",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\u0122",
            "\1\u0123",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "",
            "\1\u0125",
            "\1\u0126",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0128",
            "\52\u00d9\1\u00d8\uffd4\u00d9",
            "\1\u012a",
            "\1\u012b",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0131",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0133",
            "",
            "\1\u0134",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "",
            "\1\u0136",
            "",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\u013b",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\u013d",
            "",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u013f",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0141",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\u0143",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0146",
            "\1\u0147",
            "",
            "\1\u0148",
            "",
            "\1\u0149",
            "\1\u014a",
            "",
            "\1\u014b",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u014d",
            "\1\u014e",
            "",
            "\1\u014f",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\u0153",
            "",
            "",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0158",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u015b",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u015e",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0160",
            "",
            "\1\u0161",
            "",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            "\1\u0165",
            "",
            "",
            "",
            "\1\u0166",
            "\1\55\13\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\105\uffff\27\55\1\uffff\37\55\1\uffff\u1f08\55\u1040\uffff"+
            "\u0150\55\u0170\uffff\u0080\55\u0080\uffff\u092e\55\u10d2\uffff"+
            "\u5200\55\u5900\uffff\u0200\55",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | ENUM | Identifier | WS | JAVADOC | COMMENT | LINE_COMMENT );";
        }
    }
 

}