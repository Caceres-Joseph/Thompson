package metdothompson;
import java_cup.runtime.Symbol;
import java.util.ArrayList;

%%

%class Scanner
%cup
%public
%unicode
%line
%char


%{

	//CODIGO DE USUARIO TODO LO QUE NECESITE PARA CAPTURAR LOS ERRORES EN EL ÁREA LÉXICA

%}
 
//identificador = [a-zA-Z]([a-zA-Z]*|[0-9]*)
caracter = \'.?\'
flecha = ->
cadena = [\"][^\"\n]+[\"]
letra = [:jletter:]
%%

{flecha}		{ System.out.println("Token flecha: "+yytext()); return new Symbol(sym.Flecha, yychar, yyline, new String(yytext())); }
";"				{ System.out.println("Token punto_coma: "+yytext()); return new Symbol(sym.P_Coma, yychar, yyline, new String(yytext())); }
"%%"			{ System.out.println("Token doble_Porcentaje: "+yytext()); return new Symbol(sym.Doble_por, yychar, yyline, new String(yytext())); }
"|"				{ System.out.println("Token Disyuncion: "+yytext()); return new Symbol(sym.Disy, yychar, yyline, new String(yytext())); }
"."				{ System.out.println("Token Concatenacion: "+yytext()); return new Symbol(sym.Conc, yychar, yyline, new String(yytext())); }
"*"				{ System.out.println("Token Cero o Mas: "+yytext()); return new Symbol(sym.Cero_Mas, yychar, yyline, new String(yytext())); }
"+"				{ System.out.println("Token Una o Mas: "+yytext()); return new Symbol(sym.Uno_Mas, yychar, yyline, new String(yytext())); }
"?"				{ System.out.println("Token Uno o Cero: "+yytext()); return new Symbol(sym.Uno_Cero, yychar, yyline, new String(yytext())); }
"\\n"			{ System.out.println("Token Salto de linea: "+yytext()); return new Symbol(sym.Salto, yychar, yyline, new String(yytext())); }
"\'"			{ System.out.println("Token Comilla simple: "+yytext()); return new Symbol(sym.C_simple, yychar, yyline, new String(yytext())); }
"\""			{ System.out.println("Token Comilla doble: "+yytext()); return new Symbol(sym.C_doble, yychar, yyline, new String(yytext())); }
"\\t"			{ System.out.println("Token Tabulacion: "+yytext()); return new Symbol(sym.Tabu, yychar, yyline, new String(yytext())); }
"[:todo:]"		{ System.out.println("Token Todo: "+yytext()); return new Symbol(sym.Todo, yychar, yyline, new String(yytext())); }
"RESERV"		{ System.out.println("Token Reservar: "+yytext()); return new Symbol(sym.R_reserv, yychar, yyline, new String(yytext())); }
"error"			{ System.out.println("Token Error: "+yytext()); return new Symbol(sym.Err, yychar, yyline, new String(yytext())); }
"yytext"		{ System.out.println("Token YYtext: "+yytext()); return new Symbol(sym.Text, yychar, yyline, new String(yytext())); }
"yyrow"			{ System.out.println("Token YYrow: "+yytext()); return new Symbol(sym.Row, yychar, yyline, new String(yytext())); }
"yycol"			{ System.out.println("Token YYcol: "+yytext()); return new Symbol(sym.Col, yychar, yyline, new String(yytext())); }
"("				{ System.out.println("Token Abre Parentesis: "+yytext()); return new Symbol(sym.O_par, yychar, yyline, new String(yytext())); }
")"				{ System.out.println("Token Cierra Parentesis: "+yytext()); return new Symbol(sym.C_par, yychar, yyline, new String(yytext())); }
"retorno"		{ System.out.println("Token Palabra Reservada retorno: "+yytext()); return new Symbol(sym.Retorno, yychar, yyline, new String(yytext())); }
"CONJ"			{ System.out.println("Token Palabra Reservada CONJ: "+yytext()); return new Symbol(sym.Conj, yychar, yyline, new String(yytext())); }
":"				{ System.out.println("Token Dos Puntos: "+yytext()); return new Symbol(sym.DosPt, yychar, yyline, new String(yytext())); }
","				{ System.out.println("Token Coma: "+yytext()); return new Symbol(sym.Coma, yychar, yyline, new String(yytext())); }
"["				{ System.out.println("Token Open Bracket: "+yytext()); return new Symbol(sym.O_Bra, yychar, yyline, new String(yytext())); }
"]"				{ System.out.println("Token Close Bracket: "+yytext()); return new Symbol(sym.C_Bra, yychar, yyline, new String(yytext())); }
{cadena}		{ System.out.println("Token Cadena: "+yytext()); return new Symbol(sym.Cadena, yychar, yyline, new String(yytext())); }
//{identificador} { System.out.println("Token identificador: "+yytext()); return new Symbol(sym.Identificador, yychar, yyline, new String(yytext())); }
{letra}             { System.out.println("Token Letra: "+yytext()); return new Symbol(sym.Letra, yychar, yyline, new String(yytext())); }
{caracter}		{ System.out.println("Token caracter: "+yytext()); return new Symbol(sym.Caracter, yychar, yyline, new String(yytext())); }
[\t\r\f\n\s]+   { /* Se ignoran */}
.				{ System.out.println("Error Lexico, token no reconocido: "+yytext()+" en Linea: "+(int)(yyline+1));}





