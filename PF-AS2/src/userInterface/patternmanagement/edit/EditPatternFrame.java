package userInterface.patternmanagement.edit;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import patternManagement.Pattern;

public class EditPatternFrame extends JPanel {

	public EditPatternFrame(final Pattern p) {

		this.setLayout(new GridLayout(10, 1));
		this.add(new JLabel("Please enter new pattern information"));
		final JTextField name;
		final JTextField description;
		name = new JTextField(p.getName());
		description = new JTextField(p.getDescription());

		this.add(new JLabel("Name:"));
		this.add(name);
		this.add(new JLabel("Description:"));
		this.add(description);

		JButton submit = new JButton("Submit edit");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p.setName(name.getText());
				p.setDescription(description.getText());
				p.doUpdate();
			}
		});

		this.add(submit);
		this.setVisible(true);

	}

}
