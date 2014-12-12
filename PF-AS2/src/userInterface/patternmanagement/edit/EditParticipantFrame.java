package userInterface.patternmanagement.edit;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import patternManagement.Participant;
import patternManagement.Pattern;
import patternManagement.Solution;

public class EditParticipantFrame extends JPanel {

	/**
	 * @author Mark Stroeven
	 */
	private static final long serialVersionUID = 3529154926208443259L;
	private Participant participant;

	public EditParticipantFrame(final Pattern p) {

		final JComboBox<Participant> combo = new JComboBox<Participant>();
		for (Participant part : p.getTheParticipant()) {

			combo.addItem(part);

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
				participant.setName(name.getText());
				participant.setDescription((description.getText()));

			}
		});

		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Participant part = (Participant) combo.getSelectedItem();
				participant = part;

				if (part != null) {
					name.setText(part.getName());
					description.setText(part.getDescription());
				}

			}
		});
		;
	}

}

