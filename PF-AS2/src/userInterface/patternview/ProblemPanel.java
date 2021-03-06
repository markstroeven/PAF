package userInterface.patternview;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import patternManagement.Pattern;
import patternManagement.Problem;

public class ProblemPanel extends JPanel {

	private JLabel name, descript;
	private JComboBox<Problem> problemCombo = new JComboBox<Problem>();

	public ProblemPanel() {

		this.setLayout(new GridLayout(20, 1));
		this.add(new JLabel("Select a problem to view:"));
		this.add(problemCombo);

		this.add(new JLabel("Problem name:"));
		this.add(name = new JLabel(""));
		this.add(new JLabel("Problem Description keywords:"));
		this.add(descript = new JLabel(""));

		name.setPreferredSize(new Dimension(200, 200));

		problemCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Problem p = (Problem) problemCombo.getSelectedItem();

				if (p != null) {
					name.setText(p.getName());
					descript.setText(p.getDescription());
				}
			}
		});

		this.setVisible(true);
	}

	public void updateItem(Pattern p) {

		populateList(p);

	}

	public void populateList(Pattern p) {
		problemCombo.removeAllItems();
		for (Problem prob : p.getTheProblem()) {
			problemCombo.addItem(prob);
		}
	}
}
