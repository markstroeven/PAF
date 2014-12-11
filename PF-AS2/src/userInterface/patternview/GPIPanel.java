package userInterface.patternview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import patternManagement.Pattern;

public class GPIPanel extends JPanel {

	private JTextArea description;
	private JLabel name, keywords;

	public GPIPanel() {

		this.setVisible(true);
		this.setLayout(new GridLayout(20, 1));
		this.add(new JLabel("Pattern name:"));
		this.add(name = new JLabel(""));
		name.setForeground(Color.RED);
		this.add(new JLabel("Pattern description:"));
		this.add(description = new JTextArea(""));
		description.setForeground(Color.RED);
		this.add(new JLabel("Pattern keywords:"));
		this.add(keywords = new JLabel(""));
		keywords.setForeground(Color.RED);

		description.setPreferredSize(new Dimension(200, 200));
	}

	public void updateItem(Pattern p){
		
		name.setText(p.getName());
		description.setText(p.getDescription());
		
	}
}
