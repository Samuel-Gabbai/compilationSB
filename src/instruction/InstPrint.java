package instruction;

import expression.*;

public class InstPrint extends Instruction{

	private Expression m_exp;
	private boolean m_back =false;
	
	public InstPrint(Expression exp){
		this.m_exp=exp;
	}
	
	public InstPrint(Expression exp, int i){
		this.m_exp=exp;
		m_back=true;
	}
	
	@Override
	public void eval() {
		if(m_back)
			System.out.println(m_exp.eval());
		else
			System.out.print(m_exp.eval());
			
	}
	
	

}
