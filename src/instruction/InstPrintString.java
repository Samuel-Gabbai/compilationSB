package instruction;

public class InstPrintString extends Instruction{
	
	private String str;
	
	public InstPrintString(String str){
		super();
		this.str=str;
	}
	public InstPrintString(String str,int i){
		super();
		this.str=str+"\n";
	}
	
	@Override
	public void eval() {
		System.out.print(str);
	}
	
}
