package expression;

public class ExpPlus extends ExpBin{

	public ExpPlus(Expression right, Expression left) {
		super(right, left);
	}

	@Override
	public int eval() {
		return left.eval()+right.eval();
	}

}
