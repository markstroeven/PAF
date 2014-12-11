package userInterface.patternview;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import patternManagement.Pattern;
import patternManagement.Solution;

public class SolutionPanel extends JPanel {

	private JLabel name, descript;
	private JComboBox<Solution> solutionCombo = new JComboBox<Solution>();

	public SolutionPanel() {

		this.setLayout(new GridLayout(20, 1));
		this.add(new JLabel("Select a solution to view:"));
		this.add(solutionCombo);

		this.add(new JLabel("Solution name:"));
		this.add(name = new JLabel(""));
		this.add(new JLabel("Solution Description keywords:"));
		this.add(descript = new JLabel(""));

		name.setPreferredSize(new Dimension(200, 200));

		solutionCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Solution s = (Solution) solutionCombo.getSelectedItem();

				if (s != null) {
					name.setText(s.getName());
					descript.setText(s.getDescription());
				}
			}
		});

		this.setVisible(true);
	}

	public void updateItem(Pattern p) {

		populateList(p);

	}

	public void populateList(Pattern p) {
		solutionCombo.removeAllItems();
		for (Solution sol : p.getTheSolution()) {
			solutionCombo.addItem(sol);
		}
	}
}
