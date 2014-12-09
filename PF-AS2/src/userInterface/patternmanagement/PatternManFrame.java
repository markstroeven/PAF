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
	private AddPatternWindow link;
	private AddConsequenceWindow link2;
	
	public PatternManFrame(ContextClassification purpose, ContextClassification scope){
		super("Pattern management", true, true, true, true);
		

		
		JPanel addPatterncontainer = new JPanel();
		this.setVisible(true);
		this.setSize(600,600);
		addPatterncontainer.setVisible(true);
		addPatterncontainer.setSize(new Dimension(300,300));
		//addPatterncontainer.setLayout(new BoxLayout(addPatterncontainer, BoxLayout.PAGE_AXIS));
		link = new AddPatternWindow(purpose, scope);
		addPatterncontainer.add(link);
		this.add(addPatterncontainer);
		
		JPanel addConsequencecontainer = new JPanel();
		this.setVisible(true);
		this.setSize(600,600);
		addConsequencecontainer.setVisible(true);
		addConsequencecontainer.setSize(new Dimension(300,300));
		//addConsequencecontainer.setLayout(new BoxLayout(addPatterncontainer, BoxLayout.PAGE_AXIS));
		link2 = new AddConsequenceWindow(purpose, scope);
		addConsequencecontainer.add(link2);
		this.add(addConsequencecontainer);
		
		jtp.addTab("Add new Pattern", addPatterncontainer);
		jtp.addTab("Add new Consequence", addConsequencecontainer);
		this.add(jtp);
		
	}
	
	public void updateAll(){
		
	
		link.revalidate();
		link.repaint();
		

		link2.repaint();
		
	}

}
