package instruction;
import java.util.*;

public class InstSuite extends Instruction {

	private ArrayList<Instruction> suiteInst = new ArrayList<>();
	
	public InstSuite(){
	}
	public InstSuite(Instruction i){
		add(i);
	}
	public void add(Instruction i) {
		suiteInst.add(i);
		
	}
	@Override
	public void eval() {
		suiteInst.forEach(Instruction::eval);
		
	}
 
}
