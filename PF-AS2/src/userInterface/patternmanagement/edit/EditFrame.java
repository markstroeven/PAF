package userInterface.patternmanagement.edit;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import patternManagement.Pattern;

public class EditFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -803234752309684306L;
	private JTabbedPane jtp = new JTabbedPane();
	
	public EditFrame(final Pattern p){
		
		super("Edit pattern", true,true,true,true);
		this.setSize(new Dimension(700,400));
		
		JPanel container = new JPanel();
		
		container.add(jtp);
		EditPatternFrame epf = new EditPatternFrame(p);
		EditProblemWindow eprobf = new EditProblemWindow(p);
		EditSolutionFrame esolf = new EditSolutionFrame(p);
		EditForceFrame eforf = new EditForceFrame(p);
		EditParticipantFrame epartf = new EditParticipantFrame(p);
		EditConsequenceFrame econf = new EditConsequenceFrame(p);
		
		this.jtp.add("Edit pattern", epf);
		this.jtp.add("Edit Problem", eprobf);
		this.jtp.add("Edit Solution", esolf);
		this.jtp.add("Edit Force", eforf);
		this.jtp.add("Edit Participant", epartf);
		this.jtp.add("Edit Consequence", econf);
	
		jtp.setPreferredSize(new Dimension(690,390));
		
		this.add(container);
		this.repaint();
		this.revalidate();
		this.setVisible(true);
		
	}

}
