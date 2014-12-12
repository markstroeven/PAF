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

import patternManagement.Consequence;
import patternManagement.Pattern;
import patternManagement.Solution;

public class EditConsequenceFrame extends JPanel {

	/**
	 * @author Mark Stroeven
	 */
	private static final long serialVersionUID = 3529154926208443259L;
	private Consequence consequence;

	public EditConsequenceFrame(final Pattern p) {

		final JComboBox<Consequence> combo = new JComboBox<Consequence>();
		for (Consequence con : p.getTheConsequence()) {

			combo.addItem(con);

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
				consequence.setName(name.getText());
				consequence.setDescription((description.getText()));

			}
		});

		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consequence con = (Consequence) combo.getSelectedItem();
				consequence = con;

				if (con != null) {
					name.setText(con.getName());
					description.setText(con.getDescription());
				}

			}
		});
		;
	}

}
