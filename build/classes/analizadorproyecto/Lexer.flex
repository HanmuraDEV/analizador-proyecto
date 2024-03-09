package analizadorproyecto;
import static analizadorproyecto.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+
%{
    public String lexeme;
%}
%%
{espacio} {/*Ignore comentarios en una sola línea*/}
"//".* {/*Ignore comentarios en una sola línea*/}
"=" {
lexeme = yytext();
return Igual;
}

"int" {
    lexeme = yytext();
    return Int;
}

"string" {
    lexeme = yytext();
    return String;
}

"void" {
    lexeme = yytext();
    return Void;
}

"boolean" {
    lexeme = yytext();
    return Boolean;
}

"float" {
    lexeme = yytext();
    return Float;
}

"for" {
    lexeme = yytext();
    return For;
}

"switch" {
    lexeme = yytext();
    return Switch;
}

"do" {
    lexeme = yytext();
    return Do;
}

"while" {
    lexeme = yytext();
    return While;
}

"public" {
    lexeme = yytext();
    return Public;
}

"private" {
    lexeme = yytext();
    return Private;
}

"protected" {
    lexeme = yytext();
    return Protected;
}

"Main" {
    lexeme = yytext();
    return Main;
}

";" {
     lexeme = yytext();
    return P_coma;
}

"," {
    lexeme = yytext();
    return Coma;
}


"{" {
     lexeme = yytext();
    return LlaveAbierta;
}

"}" {
     lexeme = yytext();
    return LlaveCerrada;
}

"(" {
     lexeme = yytext();
    return Parentesis_abierta;
}

")" {
     lexeme = yytext();
    return Parentesis_cerrada;
}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {lexeme=yytext(); return Op_logico;}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {lexeme = yytext(); return Op_relacional;}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return Op_atribucion;}

/* Operadores Incremento y decremento */
( "++" | "--" ) {lexeme = yytext(); return Op_incremento;}

/*Operadores Booleanos*/
(true | false)      {lexeme = yytext(); return Op_booleano;}

/*Operadores Aritmeticos*/
("+" | "-" | "/" | "*" | "^" ) {lexeme = yytext(); return Op_aritmeticos;}

"if" { lexeme = yytext(); return If; }
"else" { lexeme = yytext(); return Else; }


{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}

