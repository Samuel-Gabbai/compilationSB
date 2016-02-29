package instruction;

import expression.Expression;
import parser.Symbol;

public class InstFor extends Instruction{
	
	Symbol s;
	Expression exp,exp2;
	InstSuite si;
	
	public InstFor(Symbol s,Expression exp,Expression exp2, InstSuite si){
		this.s=s;
		this.exp=exp;
		this.exp2=exp2;
		this.si=si;
	}
	@Override
	public void eval() {
		s.val=exp.eval();
		while(s.val<=exp2.eval()){
			si.eval();
			s.val++;
		}
	}

}
