package analizadorproyecto;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+
%{
    private Symbol symbol (int type, Object value){
    return new Symbol (type, yyline, yycolumn, value);
 }
    private Symbol symbol(int type){
    return new Symbol(type, yyline, yycolumn);
}

%}
%%
{espacio} {/*Ignore comentarios en una sola línea*/}
"=" {
return new Symbol(sym.Igual, yychar, yyline,yytext());
}

"int" {
   return new Symbol (sym.Int, yychar, yyline, yytext());
}

"string" {
    return new Symbol (sym.String, yychar, yyline, yytext());
}

"void" {
   return new Symbol (sym.Void, yychar, yyline, yytext());
}

"boolean" {
   return new Symbol (sym.Boolean, yychar, yyline, yytext());
}

"float" {
    return new Symbol (sym.Float, yychar, yyline, yytext());
}

"for" {
   return new Symbol (sym.For, yychar, yyline, yytext());
}

"switch" {
  return new Symbol (sym.Switch, yychar, yyline, yytext());
}

"do" {
    return new Symbol (sym.Do, yychar, yyline, yytext());
}

"while" {
  return new Symbol (sym.While, yychar, yyline, yytext());
}

"public" {
    return new Symbol (sym.Public, yychar, yyline, yytext());
}

"private" {
    return new Symbol (sym.Private, yychar, yyline, yytext());
}

"protected" {
    return new Symbol (sym.Protected, yychar, yyline, yytext());
}

"Main" {
    return new Symbol (sym.Main, yychar, yyline, yytext());
}

";" {
     return new Symbol (sym.P_coma, yychar, yyline, yytext());
}

"," {
   return new Symbol (sym.Coma, yychar, yyline, yytext());
}


"{" {
    return new Symbol (sym.LlaveAbierta, yychar, yyline, yytext());
}

"}" {
    return new Symbol (sym.LlaveCerrada, yychar, yyline, yytext());
}

"(" {
    return new Symbol (sym.Parentesis_abierta, yychar, yyline, yytext());
}

")" {
    return new Symbol (sym.Parentesis_cerrada, yychar, yyline, yytext());
}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {return new Symbol(sym.Op_logico, yychar, yyline, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {return new Symbol(sym.Op_atribucion, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.Op_incremento, yychar, yyline, yytext());}

/*Operadores Booleanos*/
( true | false ) {return new Symbol(sym.Op_booleano, yychar, yyline, yytext());}

/*Operadores Aritmeticos*/
("+" | "-" | "/" | "*" |"^" ) {return new Symbol(sym.Op_aritmeticos, yychar, yyline, yytext());}

"if" { return new Symbol(sym.If, yychar, yyline, yytext()); }
"else" { return new Symbol(sym.Else, yychar, yyline, yytext()); }




{L}({L}|{D})* {return new Symbol (sym.Identificador, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol (sym.Numero, yychar, yyline, yytext());}
 . {return new Symbol (sym.Error, yychar, yyline, yytext());;}


