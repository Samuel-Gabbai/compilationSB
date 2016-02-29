package expression;
import parser.*;

public class ExpID extends Expression {
	
	private Symbol sym;
	
	public ExpID(Symbol sym){
		this.sym = sym;
	}
	
	@Override
	public int eval() {
		return sym.val;
	}

}
