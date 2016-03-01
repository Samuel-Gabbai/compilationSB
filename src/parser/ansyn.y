%{
  import java.io.*;
  import instruction.*;
  import expression.*;
  import expressionboolean.*;
%}

%token <i> NB
%token PRINT AFF END PV PO PF G READ BEGIN FOR TO DO END PRINTLN INT DOUBLE CHAR CO CF PP PPE PG PGE IF IO FI WHILE ELSE
%token <s> ID
%token <s> CH
%token <v> SYMBOL

%left PLUS MOINS
%left MULT DIV

%type <exp>	E
%type <expB> EB
%type <inst> Inst
%type <si> ListeI

%%

Start: ListeI {$1.eval();}
;

ListeI: Inst {$$= new InstSuite(); $$.add($1);}
       | ListeI PV Inst {$$=$1; $$.add($3);}
;

Inst:	PRINT PO E PF {$$= new InstPrint($3);}
	  | PRINT PO CH PF {$$= new InstPrintString($3);}
	  | PRINTLN PO CH PF {$$= new InstPrintString($3,1);}
      | ID AFF E {$$= new InstAff(env.getSym($1),$3);}
      | ID PLUS PLUS {$$= new InstAff(env.getSym($1));}
      | READ PO ID PF {$$ = new InstRead(env.getSym($3));}
      | {$$=new InstVide();}
      | FOR ID AFF E TO E DO BEGIN ListeI END { $$= new InstFor(env.getSym($2),$4,$6,$9);}
      | IF PO EB PF IO ListeI FI { $$= new InstIf($3,$6);}
      |	WHILE PO EB PF IO ListeI FI { $$= new InstWhile($3,$6);}
;

E: 		E PLUS E {$$=new ExpPlus($1,$3);}
	|	E MOINS E {$$=new ExpSub($1,$3);}
	|	E MULT E {$$=new ExpMult($1,$3);}
	| 	E DIV E {$$=new ExpDiv($1,$3);}
	|	ID {$$=new ExpID(env.getSym($1));}
	|	NB {$$= new ExpNB($1);}
	|	PO E PF {$$ = $2;}
;

EB:		E PP E {$$= new ExpBPP($1,$3);}
	|	E PPE E	{$$= new ExpBPPE($1,$3);}
	|	E PG E	{$$= new ExpBPG($1,$3);}
	|	E PGE E {$$= new ExpBPGE($1,$3);}
	|	E EE E {$$= new ExpBE($1,$3);}
	 
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
