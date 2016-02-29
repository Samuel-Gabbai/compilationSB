package expression;

public class ExpNB extends Expression{
	
	private int value;
	
	public ExpNB(int value){
		this.value=value;
	}
	@Override
	public int eval() {
		return value;
	}

}
