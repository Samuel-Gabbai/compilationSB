package instruction;
import expressionboolean.*;

public class InstIf extends Instruction{
	
	ExpressionBool m_expB;
	InstSuite m_si;
	
	public InstIf(ExpressionBool expB, InstSuite si){
		this.m_expB=expB;
		this.m_si=si;
	}
	@Override
	public void eval() {
		if(m_expB.eval()){
			m_si.eval();
		}
	}

}
