package expressionboolean;

import expression.*;

public abstract class ExpBoolBinC extends ExpressionBool{
	Expression m_right, m_left;
	
	public ExpBoolBinC(Expression left, Expression right){
		super();
		this.m_right=right;
		this.m_left=left;
	}
	
}
