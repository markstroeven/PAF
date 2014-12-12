package userInterface.patternmanagement.edit;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import patternManagement.Pattern;

public class EditPatternFrame extends JPanel {
	
	private JScrollPane jcp;

	public EditPatternFrame(final Pattern p) {

		this.setLayout(new GridLayout(7, 1));
		this.add(new JLabel("Please enter new pattern information"));
		final JTextField name;
		final JTextArea description = new JTextArea();
		name = new JTextField(p.getName());
		

		this.add(new JLabel("Name:"));
		this.add(name);
		this.add(new JLabel("Description:"));
		this.add(jcp = new JScrollPane(description));

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
