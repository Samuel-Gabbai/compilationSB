package instruction;

import expressionboolean.*;

public class InstWhile extends Instruction{

	ExpressionBool m_expB;
	InstSuite m_si;
	
	public InstWhile(ExpressionBool expB, InstSuite si){
		this.m_expB=expB;
		this.m_si=si;
	}
	@Override
	public void eval() {
		while(m_expB.eval()){
			m_si.eval();
		}
	}

}
