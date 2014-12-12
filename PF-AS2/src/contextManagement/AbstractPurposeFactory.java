package contextManagement;

import observer.ContextObserver;
import userInterface.MainFrame;

public class AbstractPurposeFactory implements AbstractFactory{
	
	
	private MainFrame frameLink;
	
	public AbstractPurposeFactory(MainFrame mf){
		
		frameLink = mf;
	}

	@Override
	public void createContextCategory(ContextClassification c, String nm) {
		c.addContextCategory(new ContextCategory(nm, new ContextObserver(frameLink)));
		
	}

}
