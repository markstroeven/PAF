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

import patternManagement.Consequence;
import patternManagement.Force;
import patternManagement.Participant;
import patternManagement.Pattern;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class AddParticitpantWindow extends JPanel {

	public JComboBox<Pattern> combo = new JComboBox<Pattern>();
	ContextClassification p, s;

	public AddParticitpantWindow(ContextClassification purpose,
			ContextClassification scope) {

		p = purpose;
		s = scope;

		populateList();

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		final JTextField name;
		final JTextField description;
		this.add(new JLabel("The name of the Participant"));
		this.add(name = new JTextField(22));
		this.add(new JLabel("The description of the Participant"));
		this.add(description = new JTextField(22));
		this.add(new JLabel("The reffered pattern"));
		this.add(combo);
		JButton submit;
		this.add(submit = new JButton("Create new Participant"));
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pattern p = (Pattern) combo.getSelectedItem();

				p.addParticipant((new Participant(name.getText(), description
						.getText())));

				System.out.println("Zojuist toegevoegd: "
						+ p.getTheParticipant().get(0).getName());

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
