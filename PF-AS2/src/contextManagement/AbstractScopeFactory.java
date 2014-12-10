package contextManagement;

import userInterface.MainFrame;

public class AbstractScopeFactory {
	
	private MainFrame frameLink;
	
	public AbstractScopeFactory(MainFrame mf){
		
		frameLink = mf;
	}
	
	public ContextCategory makeCategory(String name){
		return new ContextCategory(name, new ContextObserver(frameLink));
	}

}
