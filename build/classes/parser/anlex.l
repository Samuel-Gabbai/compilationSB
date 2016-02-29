package parser;

%%

%{
  StringBuffer string = new StringBuffer();

  private Parser parser;

  public Yylex(java.io.Reader r, Parser parser) {
    this(r);
    this.parser = parser;
  }
%}


%byaccj

nb=[0-9]+
id=[a-z]+

%%

{nb} {parser.yylval = new Pval(Integer.parseInt(yytext())); return parser.NB;}

write {return parser.WRITE;}

END {return parser.END;}

{id} { parser.yylval = new Pval(yytext()); return parser.ID;}

:=  {return parser.AFF;}

; {return parser.PV;}

\n\r| \r | \n | [ ] | \t {}



