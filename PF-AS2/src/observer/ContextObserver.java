package observer;

import userInterface.MainFrame;

public class ContextObserver extends Observer{
	
	private MainFrame frameLink;
	
	public ContextObserver(MainFrame m){
		frameLink = m ;
	}
	
	public void alertMembers(){
		frameLink.updateAll();
	}
	
}
