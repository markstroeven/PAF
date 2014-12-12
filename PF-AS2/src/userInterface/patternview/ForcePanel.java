package userInterface.patternview;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import patternManagement.Pattern;

public class ForcePanel extends JPanel {

	private static final long serialVersionUID = -6824067720827804539L;
	private JLabel name, descript;

	public ForcePanel() {
	this.setLayout(new GridLayout(10,1));
	this.add(new JLabel("Force name"));
	this.add(name = new JLabel(""));
	this.add(new JLabel("Force description"));
	this.add(descript = new JLabel(""));
	this.setVisible(true);
	
	
	}
	
	public void updateItem(Pattern p) {
		name.setText(p.getForce().getName());
		descript.setText(p.getForce().getDescription());
	}
}
