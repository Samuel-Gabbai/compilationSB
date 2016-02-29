package expression;

public class ExpMult extends ExpBin{

	public ExpMult(Expression right, Expression left) {
		super(right, left);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int eval() {
		return left.eval()*right.eval();
	}


}
