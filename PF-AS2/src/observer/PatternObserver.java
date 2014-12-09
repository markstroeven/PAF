package observer;

import userInterface.MainFrame;

public class PatternObserver extends Observer {
	
	private MainFrame frameLink;
	
	public PatternObserver(MainFrame mf) {
	frameLink = mf;
	}

	@Override
	public void alertMembers() {
		
		frameLink.updateAll();
		
	}

}
