%{
  import java.io.*;
%}

%token <i> NB
%token WRITE AFF END PV
%token <s> ID

%%

Start: ListeI {}
;

ListeI: {}
       | ListeI Instr {}
;

Instr:   PV  {System.out.println("VIDE");}
      | WRITE {System.out.println("WRITE");}
      | ID {System.out.println("ID: "+$1);}
      | NB {System.out.println("NB: "+$1);}
;

%%

  /* a reference to the lexer object */
  private Yylex lexer;
  private Environnement env;

  /* interface to the lexer */
  private int yylex () {
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);
    }
    return yyl_return;
  }

  /* error reporting */
  public void yyerror (String error) {
    System.err.println ("Error: " + error);
  }

  /* lexer is created in the constructor */
  public Parser(Reader r) {
    env = new Environnement();
    lexer = new Yylex(r, this);
  }
