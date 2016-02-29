package instruction;

import expression.*;
import parser.*;

public class InstAff extends Instruction {
	
	private Symbol id;
	private Expression exp;
	private boolean auto;
	
	public InstAff(Symbol id , Expression exp){
		this.id=id;
		this.exp=exp;
		auto=false;
	}

	public InstAff(Symbol id){
		this.id=id;
		this.exp=null;
		auto=true;
	}

	@Override
	public void eval() {
		if(auto)
			id.val=id.val+1;
		else
			id.val=exp.eval();
	}

}

