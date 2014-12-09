package contextManagement;

import java.util.List;

import patternManagement.Pattern;


public class Purpose extends ContextClassification{
	
	public Purpose(String nm, String d){
		super(nm, d);
	}
	
	@Override
	public void addContextCategory(ContextCategory c){
		super.getTheCategory().add(c);
	}

}
