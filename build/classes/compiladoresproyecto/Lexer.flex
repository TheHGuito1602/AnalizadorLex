package compiladoresproyecto;
import static compiladoresproyecto.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
PAL=[L|D]*
SIGNO=["-"|"+"|""]
espacio=[ ,\t,\r,\n,""]+

cadena="\""[^"\""]*"\""

C="/*"[^"*/"]*.*"*/"
Caux="/*"[^"\*/"]+
CI=["/*".*]
CF=["*/"]
CM={CI}({espacio}|{L}|{D}){CF}

cmntrI=[/\*].
cmntrF=[\*/]

cmntrM={cmntrI}[^"/"]*{cmntrF}

%{
    public String lexeme;
%}
%% 
abstract | assert | boolean | break | byte | case | catch | char | class | continue | default | do |
double | else | enum | extends | final | finally | float | for | if | implements | import | instanceof | int |
interface | long | native | new | package | print | println | private | protected | public | return | short |
static | String | strictfp | super | switch | synchronized | this | throw | throws | transient | try | void |
volatile | while |
while {lexeme=yytext(); return PALRE;}

"=" | "*=" | "/=" | "%=" | "+=" | "-=" |
while {lexeme=yytext(); return OPASI;}

"+" | "-" | "*" | "/" | "%" | 
while {lexeme=yytext(); return OPARI;}

"++" | --|
while {lexeme=yytext(); return OPIND;}

"==" | "!=" | ">" | "<" | ">=" | "<=" |
while {lexeme=yytext(); return OPREL;}

"!" | "^" | "&&" | "||" |
while {lexeme=yytext(); return OPLOG;}

"[" | "]" | "." | "," | "//" | "/*" | "*/" | ":" | ";" | "(" | ")" | "{" | "}" |
while {lexeme=yytext(); return OPESP;}

{espacio} {/*Ignore*/}

"//".* {/*Ignore*/}

"System.out." {/*Ignore*/}

"UNPA.WinForm." {/*Ignore*/}

{cmntrM} {/*Ignore*/}

{cadena} {lexeme=yytext(); return CDNA;}
{L}({L}|{D})* {lexeme=yytext(); return ID;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUM;}
 . {return ERROR;}
