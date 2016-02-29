package expressionboolean;

import expression.*;

public class ExpBPGE extends ExpBoolBinC{
	
	public ExpBPGE(Expression left, Expression right){
		super(left,right);
	}
	
	@Override
	public boolean eval(){
		return m_left.eval()>=m_right.eval();
	}
	
}
