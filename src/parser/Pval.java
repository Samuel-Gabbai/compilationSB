/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ver
 */

import expression.*;
import expressionboolean.*;
import instruction.*;

public class Pval implements Cloneable{
   public int i;

   public Symbol v;
   public String s;
   public Expression exp;
   public ExpressionBool expB;
   public InstSuite si;
   public Instruction inst;

    @Override
   public Pval clone(){
        try {
            return (Pval) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Pval.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }

   public Pval(){
       
   }

   public Pval(int i){
       this.i = i;
   }

   public Pval(Symbol v){
       this.v = v;
   }

   public Pval(String s){
       this.s=s;
   }
   
   public Pval(Expression exp){
	   super();
	   this.exp=exp;
   }
   
   public Pval(ExpressionBool expB){
	   super();
	   this.expB=expB;
   }
   
   public Pval(Instruction inst){
	   super();
	   this.inst=inst;
   }
   
   public Pval(InstSuite si){
	   super();
	   this.si=si;
   }
  
   


}
