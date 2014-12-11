package userInterface.patternmanagement.edit;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import patternManagement.Pattern;
import patternManagement.Problem;

public class EditProblemWindow extends JPanel {

	/**
	 * @author Mark Stroeven
	 */
	private static final long serialVersionUID = 3529154926208443259L;
	private Problem problem = null;

	public EditProblemWindow(final Pattern p) {

		final JComboBox<Problem> combo = new JComboBox<Problem>();

		for (Problem prob : p.getTheProblem()) {

			combo.addItem(prob);

		}

		final JTextField name;
		final JTextField description;

		name = new JTextField(30);
		description = new JTextField(30);

		this.setLayout(new GridLayout(10, 1));

		this.add(new JLabel("Name:"));
		this.add(name);
		this.add(new JLabel("Description:"));
		this.add(description);
		this.add(combo);
		JButton submit = new JButton("Submit change");
		this.add(submit);
		this.setVisible(true);

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				problem.setName(name.getText());
				problem.setDescription((description.getText()));

			}
		});

		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Problem p = (Problem) combo.getSelectedItem();
				problem = p;

				if (p != null) {
					name.setText(p.getName());
					description.setText(p.getDescription());
				}

			}
		});

	}

}
