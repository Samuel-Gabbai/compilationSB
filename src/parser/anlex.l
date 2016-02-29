package parser;

%%

%{
  StringBuffer string ;

  private Parser parser;

  public Yylex(java.io.Reader r, Parser parser) {
    this(r);
    this.parser = parser;
  }
%}


%byaccj

nb=[0-9]+
id=[a-z]+

%x c
%x ch

%%

{nb} {parser.yylval = new Pval(Integer.parseInt(yytext())); return parser.NB;}

print {return parser.PRINT;}

println {return parser.PRINTLN;}

read {return parser.READ;}

END {return parser.END;}

for {return parser.FOR;}

if {return parser.IF;}

to  {return parser.TO;}

do {return parser.DO;}

begin {return parser.BEGIN;}

end { return parser.END;}

{id} { parser.yylval = new Pval(yytext()); return parser.ID;}

=  {return parser.AFF;}

; {return parser.PV;}

\+ {return parser.PLUS;}

\- {return parser.MOINS;}

\/ {return parser.DIV;}

\* {return parser.MULT;}

\( {return parser.PO;}

\) {return parser.PF;}

\< {return parser.PP;}

\> {return parser.PG;}

\<= {return parser.PPE;}

\>= {return parser.PGE;}

\== {return parser.EE;}

int {return parser.INT;}

double {return parser.DOUBLE;}

char {return parser.CHAR;}

\[ {return parser.CO;}

\] {return parser.CF;} 

\{ {return parser.IO;}

\} {return parser.FI;}



\/\* { yybegin(c);}
<c> \*\/  {yybegin(YYINITIAL);}
<c> .| \n | \r  {}

\" { yybegin(ch);string = new StringBuffer();}
<ch> \" { yybegin(YYINITIAL); parser.yylval= new Pval(string.toString()); return parser.CH;}
<ch> .  { string.append(yytext());}
<ch> \\n {string.append("\n");}


\n\r| \r | \n | [ ] | \t  {}



