package expressionboolean;

import expression.*;

public class ExpBPPE extends ExpBoolBinC{
	
	public ExpBPPE(Expression left, Expression right){
		super(left,right);
	}

	@Override
	public boolean eval(){
		return m_left.eval()<=m_right.eval();
	}
	
}
