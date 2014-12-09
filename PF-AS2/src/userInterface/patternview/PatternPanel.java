package userInterface.patternview;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import patternManagement.Pattern;

public class PatternPanel extends JPanel {

	// compponents
	private JTabbedPane jtp = new JTabbedPane();
	private GPIPanel p1 = new GPIPanel();
	private DiagramPanel p2 = new DiagramPanel();

	public PatternPanel() {

		this.setVisible(true);
		this.add(jtp);

		this.jtp.add("General pattern information", p1);

		this.jtp.add("Problems", new JPanel());
		this.jtp.add("Consequences", new JPanel());
		this.jtp.add("Solutions", new JPanel());
		this.jtp.add("Forces", new JPanel());
		this.jtp.add("Participants", new JPanel());
		this.jtp.add("Pattern diagram", p2);

	}

	public void updateItem(Pattern p) {
		p1.updateItem(p);
		p2.updateItem(p);

	}

}
