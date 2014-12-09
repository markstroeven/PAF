package contextManagement;

import userInterface.MainFrame;

public class ContextObserver {
	
	private MainFrame frameLink;
	
	public ContextObserver(MainFrame m){
		frameLink = m ;
	}
	
	public void alert(){
		frameLink.updateAll();
	}
	
}
