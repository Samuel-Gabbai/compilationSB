package expressionboolean;

import expression.*;

public class ExpBPG extends ExpBoolBinC {
	
	public ExpBPG(Expression left, Expression right){
		super(left,right);
	}
	
	@Override
	public boolean eval(){
		return m_left.eval()>m_right.eval();
	}
}
