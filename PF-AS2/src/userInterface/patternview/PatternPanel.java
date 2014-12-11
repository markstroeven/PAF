package userInterface.patternview;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import patternManagement.Consequence;
import patternManagement.Pattern;

public class PatternPanel extends JPanel {

	// compponents
	private JTabbedPane jtp = new JTabbedPane();
	private GPIPanel p1 = new GPIPanel();
	private DiagramPanel p2 = new DiagramPanel();
	private ProblemPanel p3 = new ProblemPanel();
	private ConesequencePanel p4 = new ConesequencePanel();

	public PatternPanel() {

		this.setVisible(true);
		this.add(jtp);

		this.jtp.add("General pattern information", p1);
		this.jtp.add("Problems", p3);
		this.jtp.add("Consequences", p4);
		this.jtp.add("Solutions", new JPanel());
		this.jtp.add("Forces", new JPanel());
		this.jtp.add("Participants", new JPanel());
		this.jtp.add("Pattern diagram", p2);

	}

	public void updateItem(Pattern p) {

		p1.updateItem(p);
		try{
		if(p.getTheDiagram().getImage() != null){
			p2.updateItem(p);	
		}
		}
		catch(Exception e){
			System.out.println("Ow nee geen diagram!");
		}
		p3.updateItem(p);
		p4.updateItem(p);
		
		
		

	}

}
