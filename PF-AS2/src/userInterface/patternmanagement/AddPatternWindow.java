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

	final JComboBox<ContextCategory> scopeCombo = new JComboBox<ContextCategory>();
	final JComboBox<ContextCategory> purposeCombo = new JComboBox<ContextCategory>();
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
		this.add(new JLabel("The scope category of the pattern"));
		this.add(scopeCombo);
		this.add(new JLabel("The purpose category of the pattern"));
		this.add(purposeCombo);
		JButton submit;
		this.add(submit = new JButton("Create new Pattern"));
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ContextCategory selected = (ContextCategory) scopeCombo
						.getSelectedItem();
				Pattern tester = selected.searchPattern(name.getText());

				if (tester != null) {
					JOptionPane
							.showMessageDialog(
									getRootPane(),
									"The pattern name you have entered already exists, please select a different name",
									"ERROR", JOptionPane.ERROR_MESSAGE);
				} else

				if (name.getText().isEmpty()) {
					JOptionPane
							.showMessageDialog(
									getRootPane(),
									"The name for this pattern is empty! Please enter a name.",
									"ERROR", JOptionPane.ERROR_MESSAGE);

				} else if (description.getText().isEmpty()) {
					JOptionPane
							.showMessageDialog(
									getRootPane(),
									"The description for this pattern is empty! Please enter a description.",
									"ERROR", JOptionPane.ERROR_MESSAGE);

				} else {

					Pattern p = new Pattern(new Force(), name.getText(),
							description.getText(), new PatternObserver(
									frameLink));

					ContextCategory selected2 = (ContextCategory) purposeCombo
							.getSelectedItem();

					selected.addPattern(p);
					selected2.addPattern(p);

					ContextCategory temp1 = (ContextCategory) scopeCombo
							.getSelectedItem();
					String scopeString = temp1.getName();
					ContextCategory temp2 = (ContextCategory) purposeCombo
							.getSelectedItem();
					String purposeString = temp2.getName();

					p.getPatternLinks().add(scopeString);
					p.getPatternLinks().add(purposeString);

				}

			}
		});

		this.setSize(100, 100);
		this.setVisible(true);
	}

	public void populateList() {
		purposeCombo.removeAllItems();
		scopeCombo.removeAllItems();

		for (ContextCategory c : p.getTheCategory()) {
			purposeCombo.addItem(c);
		}
		for (ContextCategory c : s.getTheCategory()) {
			scopeCombo.addItem(c);
		}
	}

}
