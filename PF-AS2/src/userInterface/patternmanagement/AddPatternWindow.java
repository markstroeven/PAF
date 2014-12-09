package userInterface.patternmanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import observer.PatternObserver;
import patternManagement.Force;
import patternManagement.Pattern;
import userInterface.MainFrame;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class AddPatternWindow extends JPanel {

	final JComboBox<ContextCategory> combo = new JComboBox<ContextCategory>();
	final ContextClassification p, s;
	private MainFrame frameLink;

	public AddPatternWindow(ContextClassification purpose,
			ContextClassification scope, MainFrame mf) {
		frameLink = mf;
		p = purpose;
		s = scope;

		populateList();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		final JTextField name;
		final JTextField description;
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

				if (name.getText().isEmpty()) {
					JOptionPane
							.showMessageDialog(
									getRootPane(),
									"The name for this pattern is empty! Please enter a name.",
									"ERROR", JOptionPane.ERROR_MESSAGE);

				}
				if (description.getText().isEmpty()) {
					JOptionPane
							.showMessageDialog(
									getRootPane(),
									"The description for this pattern is empty! Please enter a description.",
									"ERROR", JOptionPane.ERROR_MESSAGE);

				}

				ContextCategory selected = (ContextCategory) combo
						.getSelectedItem();

				Pattern p = selected.searchPattern(name.getText());

				if (p != null) {
					JOptionPane
							.showMessageDialog(
									getRootPane(),
									"The pattern name you have entered already exists, please select a different name",
									"ERROR", JOptionPane.ERROR_MESSAGE);
				} else {

					selected.addPattern(new Pattern(new Force(),
							name.getText(), description.getText(), new PatternObserver(frameLink)));
					

				}

			}
		});

		this.setSize(100, 100);
		this.setVisible(true);
	}

	public void populateList() {
		for (ContextCategory c : p.getTheCategory()) {
			combo.addItem(c);
		}
		for (ContextCategory c : s.getTheCategory()) {
			combo.addItem(c);
		}
	}

}
