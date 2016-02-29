package expression;

public class ExpDiv extends ExpBin{

	public ExpDiv(Expression right, Expression left) {
		super(right, left);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int eval() {
		return left.eval()/right.eval();
	}
	
}
