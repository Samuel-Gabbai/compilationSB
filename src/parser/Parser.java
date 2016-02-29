//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package parser;



//#line 1 "ansyn.y"

  import java.io.*;
  import instruction.*;
  import expression.*;
  import expressionboolean.*;
//#line 23 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//## **user defined:Pval
String   yytext;//user variable to return contextual strings
Pval yyval; //used to return semantic vals from action routines
Pval yylval;//the 'lval' (result) I got from yylex()
Pval valstk[] = new Pval[YYSTACKSIZE];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
final void val_init()
{
  yyval=new Pval();
  yylval=new Pval();
  valptr=-1;
}
final void val_push(Pval val)
{
  try {
    valptr++;
    valstk[valptr]=val;
  }
  catch (ArrayIndexOutOfBoundsException e) {
    int oldsize = valstk.length;
    int newsize = oldsize*2;
    Pval[] newstack = new Pval[newsize];
    System.arraycopy(valstk,0,newstack,0,oldsize);
    valstk = newstack;
    valstk[valptr]=val;
  }
}
final Pval val_pop()
{
  return valstk[valptr--];
}
final void val_drop(int cnt)
{
  valptr -= cnt;
}
final Pval val_peek(int relative)
{
  return valstk[valptr-relative];
}
final Pval dup_yyval(Pval val)
{
  return val.clone();
}
//#### end semantic value section ####
public final static short NB=257;
public final static short PRINT=258;
public final static short AFF=259;
public final static short END=260;
public final static short PV=261;
public final static short PO=262;
public final static short PF=263;
public final static short G=264;
public final static short READ=265;
public final static short BEGIN=266;
public final static short FOR=267;
public final static short TO=268;
public final static short DO=269;
public final static short PRINTLN=270;
public final static short INT=271;
public final static short DOUBLE=272;
public final static short CHAR=273;
public final static short CO=274;
public final static short CF=275;
public final static short PP=276;
public final static short PPE=277;
public final static short PG=278;
public final static short PGE=279;
public final static short IF=280;
public final static short IO=281;
public final static short FI=282;
public final static short ID=283;
public final static short CH=284;
public final static short SYMBOL=285;
public final static short PLUS=286;
public final static short MOINS=287;
public final static short MULT=288;
public final static short DIV=289;
public final static short EE=290;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    4,    4,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    1,    1,    1,    1,    1,    1,    1,    2,
    2,    2,    2,    2,
};
final static short yylen[] = {                            2,
    1,    1,    3,    4,    4,    4,    3,    3,    4,    0,
   10,    7,    3,    3,    3,    3,    1,    1,    3,    3,
    3,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    2,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   18,    0,   17,
    0,    0,    0,    0,    0,    0,    0,    0,    8,    3,
    0,    5,    4,    0,    0,    0,    0,    9,    0,    6,
    0,    0,    0,    0,    0,    0,   19,    0,    0,   15,
   16,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   12,    0,    0,   11,
};
final static short yydgoto[] = {                          7,
   22,   27,    8,    9,
};
final static short yysindex[] = {                      -211,
 -262, -256, -261, -179, -178, -249,    0,    0, -176, -254,
 -201, -173, -197, -234, -234, -198, -211,    0, -234,    0,
 -174, -248, -172, -234, -171, -226, -170, -270,    0,    0,
 -243,    0,    0, -234, -234, -234, -234,    0, -213,    0,
 -234, -234, -234, -234, -234, -191,    0, -218, -218,    0,
    0, -234, -270, -270, -270, -270, -270, -211, -221, -225,
 -169,    0, -211, -183,    0,
};
final static short yyrindex[] = {                         2,
    0,    0,    0,    0,    0,    0,    0,    0,   94,    0,
    0,    0,    0,    0,    0,    0,   11,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   13,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    1,   21,    0,
    0,    0, -168, -167, -165, -164, -163, -203,    0,    0,
    0,    0, -180,    0,    0,
};
final static short yygindex[] = {                         0,
  -10,    0,   84,  -51,
};
final static int YYTABLESIZE=311;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         10,
   13,   10,   18,   26,   28,   11,   60,   19,   31,   15,
   10,   64,    7,   39,   33,   34,   35,   36,   37,   47,
   14,   12,   18,   48,   49,   50,   51,   19,   20,   21,
   53,   54,   55,   56,   57,   17,   16,   34,   35,   36,
   37,   59,   34,   35,   36,   37,    1,   61,   20,   41,
   42,   43,   44,    2,   52,    3,   62,   10,    4,   34,
   35,   36,   37,   45,   34,   35,   36,   37,    5,   36,
   37,    6,   34,   35,   36,   37,   65,   17,   10,   10,
   10,   23,   13,   14,   17,   24,   25,   29,   32,   58,
   38,   40,   46,    1,   20,   21,   63,   22,   23,   24,
   30,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   13,   13,   10,   13,    0,    0,    0,    0,   13,   13,
   10,   10,    7,    7,    0,    0,   13,   13,   13,   13,
   14,   14,   13,   14,    0,    0,   13,   13,   14,   14,
   13,    0,   10,    0,    7,    0,   14,   14,   14,   14,
    0,    0,   14,    0,    0,    0,   14,   14,    0,    0,
   14,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                        262,
    0,    0,  257,   14,   15,  262,   58,  262,   19,  259,
    0,   63,    0,   24,  263,  286,  287,  288,  289,  263,
    0,  283,  257,   34,   35,   36,   37,  262,  283,  284,
   41,   42,   43,   44,   45,  261,  286,  286,  287,  288,
  289,   52,  286,  287,  288,  289,  258,  269,  283,  276,
  277,  278,  279,  265,  268,  267,  282,  261,  270,  286,
  287,  288,  289,  290,  286,  287,  288,  289,  280,  288,
  289,  283,  286,  287,  288,  289,  260,  261,  282,  260,
  261,  283,  262,  262,  261,  259,  284,  286,  263,  281,
  263,  263,  263,    0,  263,  263,  266,  263,  263,  263,
   17,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  260,  261,  261,  263,   -1,   -1,   -1,   -1,  268,  269,
  260,  261,  260,  261,   -1,   -1,  276,  277,  278,  279,
  260,  261,  282,  263,   -1,   -1,  286,  287,  268,  269,
  290,   -1,  282,   -1,  282,   -1,  276,  277,  278,  279,
   -1,   -1,  282,   -1,   -1,   -1,  286,  287,   -1,   -1,
  290,
};
}
final static short YYFINAL=7;
final static short YYMAXTOKEN=290;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"NB","PRINT","AFF","END","PV","PO","PF","G","READ","BEGIN","FOR",
"TO","DO","PRINTLN","INT","DOUBLE","CHAR","CO","CF","PP","PPE","PG","PGE","IF",
"IO","FI","ID","CH","SYMBOL","PLUS","MOINS","MULT","DIV","EE",
};
final static String yyrule[] = {
"$accept : Start",
"Start : ListeI",
"ListeI : Inst",
"ListeI : ListeI PV Inst",
"Inst : PRINT PO E PF",
"Inst : PRINT PO CH PF",
"Inst : PRINTLN PO CH PF",
"Inst : ID AFF E",
"Inst : ID PLUS PLUS",
"Inst : READ PO ID PF",
"Inst :",
"Inst : FOR ID AFF E TO E DO BEGIN ListeI END",
"Inst : IF PO EB PF IO ListeI FI",
"E : E PLUS E",
"E : E MOINS E",
"E : E MULT E",
"E : E DIV E",
"E : ID",
"E : NB",
"E : PO E PF",
"EB : E PP E",
"EB : E PPE E",
"EB : E PG E",
"EB : E PGE E",
"EB : E EE E",
};

//#line 60 "ansyn.y"


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
//#line 327 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 24 "ansyn.y"
{val_peek(0).si.eval();}
break;
case 2:
//#line 27 "ansyn.y"
{yyval.si= new InstSuite(); yyval.si.add(val_peek(0).inst);}
break;
case 3:
//#line 28 "ansyn.y"
{yyval.si=val_peek(2).si; yyval.si.add(val_peek(0).inst);}
break;
case 4:
//#line 31 "ansyn.y"
{yyval.inst= new InstPrint(val_peek(1).exp);}
break;
case 5:
//#line 32 "ansyn.y"
{yyval.inst= new InstPrintString(val_peek(1).s);}
break;
case 6:
//#line 33 "ansyn.y"
{yyval.inst= new InstPrintString(val_peek(1).s,1);}
break;
case 7:
//#line 34 "ansyn.y"
{yyval.inst= new InstAff(env.getSym(val_peek(2).s),val_peek(0).exp);}
break;
case 8:
//#line 35 "ansyn.y"
{yyval.inst= new InstAff(env.getSym(val_peek(2).s));}
break;
case 9:
//#line 36 "ansyn.y"
{yyval.inst = new InstRead(env.getSym(val_peek(1).s));}
break;
case 10:
//#line 37 "ansyn.y"
{yyval.inst=new InstVide();}
break;
case 11:
//#line 38 "ansyn.y"
{ yyval.inst= new InstFor(env.getSym(val_peek(8).s),val_peek(6).exp,val_peek(4).exp,val_peek(1).si);}
break;
case 12:
//#line 39 "ansyn.y"
{ yyval.inst= new InstIf(val_peek(4).expB,val_peek(1).si);}
break;
case 13:
//#line 42 "ansyn.y"
{yyval.exp=new ExpPlus(val_peek(2).exp,val_peek(0).exp);}
break;
case 14:
//#line 43 "ansyn.y"
{yyval.exp=new ExpSub(val_peek(2).exp,val_peek(0).exp);}
break;
case 15:
//#line 44 "ansyn.y"
{yyval.exp=new ExpMult(val_peek(2).exp,val_peek(0).exp);}
break;
case 16:
//#line 45 "ansyn.y"
{yyval.exp=new ExpDiv(val_peek(2).exp,val_peek(0).exp);}
break;
case 17:
//#line 46 "ansyn.y"
{yyval.exp=new ExpID(env.getSym(val_peek(0).s));}
break;
case 18:
//#line 47 "ansyn.y"
{yyval.exp= new ExpNB(val_peek(0).i);}
break;
case 19:
//#line 48 "ansyn.y"
{yyval.exp = val_peek(1).exp;}
break;
case 20:
//#line 51 "ansyn.y"
{yyval.expB= new ExpBPP(val_peek(2).exp,val_peek(0).exp);}
break;
case 21:
//#line 52 "ansyn.y"
{yyval.expB= new ExpBPPE(val_peek(2).exp,val_peek(0).exp);}
break;
case 22:
//#line 53 "ansyn.y"
{yyval.expB= new ExpBPG(val_peek(2).exp,val_peek(0).exp);}
break;
case 23:
//#line 54 "ansyn.y"
{yyval.expB= new ExpBPGE(val_peek(2).exp,val_peek(0).exp);}
break;
case 24:
//#line 55 "ansyn.y"
{yyval.expB= new ExpBE(val_peek(2).exp,val_peek(0).exp);}
break;
//#line 572 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
