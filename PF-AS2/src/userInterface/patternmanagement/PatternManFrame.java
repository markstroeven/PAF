package userInterface.patternmanagement;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import contextManagement.ContextClassification;


public class PatternManFrame extends JInternalFrame {
	
	private JTabbedPane jtp = new JTabbedPane();
	
	public PatternManFrame(ContextClassification purpose, ContextClassification scope){
		super("Pattern management", true, true, true, true);
		

		
		JPanel addPatterncontainer = new JPanel();
		this.setVisible(true);
		this.setSize(600,600);
		addPatterncontainer.setVisible(true);
		addPatterncontainer.setSize(new Dimension(300,300));
		//addPatterncontainer.setLayout(new BoxLayout(addPatterncontainer, BoxLayout.PAGE_AXIS));
		addPatterncontainer.add(new AddPatternWindow(purpose, scope));
		this.add(addPatterncontainer);
		
		JPanel addConsequencecontainer = new JPanel();
		this.setVisible(true);
		this.setSize(600,600);
		addConsequencecontainer.setVisible(true);
		addConsequencecontainer.setSize(new Dimension(300,300));
		//addConsequencecontainer.setLayout(new BoxLayout(addPatterncontainer, BoxLayout.PAGE_AXIS));
		addConsequencecontainer.add(new AddConsequenceWindow(purpose, scope));
		this.add(addConsequencecontainer);
		
		jtp.addTab("Add new Pattern", addPatterncontainer);
		jtp.addTab("Add new Consequence", addConsequencecontainer);
		this.add(jtp);
		
	}

}
