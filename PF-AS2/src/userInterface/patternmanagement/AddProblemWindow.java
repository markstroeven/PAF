package userInterface.patternmanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import patternManagement.Pattern;
import patternManagement.Problem;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class AddProblemWindow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7339403409940239606L;
	public JComboBox<Pattern> combo = new JComboBox<Pattern>();
	ContextClassification p, s;

	public AddProblemWindow(ContextClassification purpose,
			ContextClassification scope) {

		p = purpose;
		s = scope;

		populateList();

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		final JTextField name;
		
		final JTextField description;
		this.add(new JLabel("The name of the problem"));
		this.add(name = new JTextField(22));
		this.add(new JLabel("The description of the problem"));
		this.add(description = new JTextField(22));
		this.add(new JLabel("The related  pattern of the problem"));
		this.add(combo);
		JButton submit;
		this.add(submit = new JButton("Create new problem"));
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pattern p = (Pattern) combo.getSelectedItem();

				p.addProblem(new Problem(name.getText(), description
						.getText()));

				System.out.println("Zojuist toegevoegd: "
						+ p.getTheProblem().get(0).getName());

			}
		});

		this.setSize(100, 100);
		this.setVisible(true);
	}

	public void populateList() {
ArrayList<Pattern> buffer = new ArrayList<Pattern>();
		
		combo.removeAllItems();
		
		for (ContextCategory c : p.getTheCategory()) {
			for (Pattern p : c.getThePattern()) {
				combo.addItem(p);
				buffer.add(p);
			}
		}
		for (ContextCategory c : s.getTheCategory()) {
			for (Pattern p : c.getThePattern()) {
				if(!buffer.contains(p)){
					combo.addItem(p);	
				}
				
			}
		}
	}

}
