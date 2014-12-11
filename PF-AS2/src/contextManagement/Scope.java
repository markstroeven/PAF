package contextManagement;


public class Scope extends ContextClassification{

	public Scope(String nm, String d){
		super(nm, d);
	}
	
	@Override
	public void addContextCategory(ContextCategory c){
		super.getTheCategory().add(c);
	}
	
	public String getName(){
		return super.name;
	}
}
