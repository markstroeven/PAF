package userInterface.patternview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import patternManagement.Consequence;
import patternManagement.Pattern;

public class ConesequencePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1500272645459321267L;
	private JLabel name, descript;
	private JComboBox<Consequence> consequenceCombo = new JComboBox<Consequence>();

	public ConesequencePanel() {

		this.setVisible(true);
		this.setLayout(new GridLayout(20, 1));
		this.add(new JLabel("Select a consequence to view:"));
		this.add(consequenceCombo);

		this.add(new JLabel("consequence name:"));
		this.add(name = new JLabel(""));
		name.setForeground(Color.RED);
		this.add(new JLabel("consequence Description keywords:"));
		this.add(descript = new JLabel(""));
		descript.setForeground(Color.RED);

		name.setPreferredSize(new Dimension(200, 200));

		consequenceCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Consequence c = (Consequence) consequenceCombo.getSelectedItem();
				if (c != null) {
					name.setText(c.getName());
					descript.setText(c.getDescription());
				}
				
			}
		});
	}

	public void updateItem(Pattern p) {
		
		populateList(p);

	}
	
	public void populateList(Pattern p){
		
		consequenceCombo.removeAllItems();
		
		for(Consequence c : p.getTheConsequence()){
			consequenceCombo.addItem(c);
		}
		
	}
}
