package expression;

public class ExpSub extends ExpBin{

	public ExpSub(Expression right, Expression left) {
		super(right, left);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int eval() {
		return right.eval()-left.eval();
	}
	

}
