package userInterface.patternmanagement.edit;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import patternManagement.Pattern;

public class EditForceFrame extends JPanel {
	
	private JButton submit = new JButton("Submit");
	private JTextField name, description;
	
	public EditForceFrame(final Pattern p){
		
		this.setLayout(new GridLayout(11,1));
		this.add(new JLabel("Force name"));
		this.add(name = new JTextField(22));
		this.add(new JLabel("Force description"));
		this.add(description = new JTextField(22));
		
		this.add(submit);
		
		name.setText(p.getForce().getName());
		description.setText(p.getForce().getDescription());
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.getForce().setName(name.getText());
				p.getForce().setDescription((description.getText()));
				
			}
		});
	}

}
