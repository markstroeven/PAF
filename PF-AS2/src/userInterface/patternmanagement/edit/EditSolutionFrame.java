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
import patternManagement.Solution;

public class EditSolutionFrame extends JPanel {

	/**
	 * @author Mark Stroeven
	 */
	private static final long serialVersionUID = 3529154926208443259L;
	private Solution solution;

	public EditSolutionFrame(final Pattern p) {

		final JComboBox<Solution> combo = new JComboBox<Solution>();
		for (Solution sol : p.getTheSolution()) {

			combo.addItem(sol);

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
				solution.setName(name.getText());
				solution.setDescription((description.getText()));
				
			}
		});

		combo.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				Solution s = (Solution) combo.getSelectedItem();
				solution = s;

				if (s != null) {
					name.setText(s.getName());
					description.setText(s.getDescription());
				}

			}
		});
		;
	}

}
