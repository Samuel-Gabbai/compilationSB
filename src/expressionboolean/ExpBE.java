package expressionboolean;

import expression.*;

public class ExpBE extends ExpBoolBinC{
	
	public ExpBE(Expression left,Expression right){
		super(left,right);
	}
	
	@Override
	public boolean eval(){
		return m_left.eval()==m_right.eval();
	}
}
