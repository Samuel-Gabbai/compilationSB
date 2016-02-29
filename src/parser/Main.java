/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import java.io.*;

/**
 *
 * @author ver
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
   /* that's how you use the parser */
    Parser yyparser;
    if (args.length > 0)
        yyparser = new Parser(new FileReader(args[0]));
    else
        yyparser = new Parser(new InputStreamReader(System.in)); 
//	yyparser.yydebug=true;
    yyparser.yyparse();
  }

}
