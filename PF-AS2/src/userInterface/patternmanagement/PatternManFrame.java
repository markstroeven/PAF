package userInterface.patternmanagement;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import userInterface.MainFrame;
import contextManagement.ContextClassification;


public class PatternManFrame extends JInternalFrame {
	
	private JTabbedPane jtp = new JTabbedPane();
	private AddPatternWindow link;
	private AddConsequenceWindow link2;
	private AddProblemWindow link3;
	private AddSolutionWindow link4;
	private AddParticitpantWindow link5;
	private MainFrame frameLink;

	
	
	public PatternManFrame(ContextClassification purpose, ContextClassification scope, MainFrame mf){
		super("Pattern management", true, true, true, true);
		frameLink = mf;

		
		JPanel addPatterncontainer = new JPanel();
		this.setVisible(true);
		this.setSize(600,600);
		addPatterncontainer.setVisible(true);
		addPatterncontainer.setSize(new Dimension(300,300));
		//addPatterncontainer.setLayout(new BoxLayout(addPatterncontainer, BoxLayout.PAGE_AXIS));
		link = new AddPatternWindow(purpose, scope, frameLink);
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
		
		JPanel addProblemcontainer = new JPanel();
		this.setVisible(true);
		this.setSize(600,600);
		addProblemcontainer.setVisible(true);
		addProblemcontainer.setSize(new Dimension(300,300));
		//addConsequencecontainer.setLayout(new BoxLayout(addPatterncontainer, BoxLayout.PAGE_AXIS));
		link3 = new AddProblemWindow(purpose, scope);
		addProblemcontainer.add(link3);
		this.add(addProblemcontainer);
		
		JPanel addSolutionContainer = new JPanel();
		this.setVisible(true);
		this.setSize(600,600);
		addSolutionContainer.setVisible(true);
		addSolutionContainer.setSize(new Dimension(300,300));
		//addConsequencecontainer.setLayout(new BoxLayout(addPatterncontainer, BoxLayout.PAGE_AXIS));
		link4 = new AddSolutionWindow(purpose, scope);
		addSolutionContainer.add(link4);
		this.add(addSolutionContainer);
		
		JPanel addparticipantWindow = new JPanel();
		this.setVisible(true);
		this.setSize(600,600);
		addparticipantWindow.setVisible(true);
		addparticipantWindow.setSize(new Dimension(300,300));
		//addConsequencecontainer.setLayout(new BoxLayout(addPatterncontainer, BoxLayout.PAGE_AXIS));
		link5 = new AddParticitpantWindow(purpose, scope);
		addparticipantWindow.add(link5);
		this.add(addparticipantWindow);
		
		
		
		jtp.addTab("Add new Pattern", addPatterncontainer);
		jtp.addTab("Add new Consequence", addConsequencecontainer);
		jtp.addTab("Add new Problem", addProblemcontainer);
		jtp.addTab("Add new Solution", addSolutionContainer);
		jtp.addTab("Add new participant", addparticipantWindow);
		this.add(jtp);
		
	}
	
	public void updateAll(){
		
	
		link.revalidate();
		link.repaint();
		

		link2.repaint();
		
	}

}
