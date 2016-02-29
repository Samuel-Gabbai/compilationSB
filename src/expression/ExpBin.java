package expression;

public abstract class ExpBin extends Expression{
	
	Expression right;
	Expression left;
	
	public ExpBin(Expression right, Expression left) {
		super();
		this.right = right;
		this.left = left;
	}
	
	
	

}
