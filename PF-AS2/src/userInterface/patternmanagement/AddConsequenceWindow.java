package userInterface.patternmanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import patternManagement.Force;
import patternManagement.Pattern;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class AddConsequenceWindow extends JPanel {

	public JComboBox<Pattern> combo = new JComboBox<Pattern>();
	ContextClassification p,s;
	

	
	public AddConsequenceWindow(ContextClassification purpose,
			ContextClassification scope) {
		
		p = purpose;
		s = scope;
		
		populateList();

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		

		JTextField name, description;
		this.add(new JLabel("The name of the pattern"));
		this.add(name = new JTextField(22));
		this.add(new JLabel("The description of the pattern"));
		this.add(description = new JTextField(22));
		this.add(new JLabel("The category of the pattern"));
		this.add(combo);
		JButton submit;
		this.add(submit = new JButton("Create new Pattern"));
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pattern p = new Pattern(new Force(), "", "");

			}
		});


		this.setSize(100, 100);
		this.setVisible(true);
	}
	
	public void populateList(){
		for(ContextCategory c : p.getTheCategory()){
			for(Pattern p : c.getThePattern()){
				combo.addItem(p);
			}
		}
		for(ContextCategory c : s.getTheCategory()){
			for(Pattern p : c.getThePattern()){
				combo.addItem(p);
			}
		}
	}

}
