package instruction;

import java.util.Scanner;
import parser.*;

public class InstRead extends Instruction{
	
	Symbol var;
	
	public InstRead(Symbol var){
		this.var=var;
	}
	@Override
	public void eval() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		var.val=(sc.nextInt());
		
	}
	

}
