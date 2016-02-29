package expressionboolean;

import expression.*;

public class ExpBPP extends ExpBoolBinC{
	
	public ExpBPP(Expression left, Expression right) {
		super(left,right);
	}
	
	@Override
	public boolean eval() {
		return m_left.eval()<m_right.eval();
	}

}
