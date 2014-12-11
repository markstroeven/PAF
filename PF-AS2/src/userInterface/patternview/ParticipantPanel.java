package userInterface.patternview;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import patternManagement.Participant;
import patternManagement.Pattern;

public class ParticipantPanel extends JPanel {

	private static final long serialVersionUID = -6824067720827804539L;
	private JLabel name, descript;
	private JComboBox<Participant> participantCombo = new JComboBox<Participant>();

	public ParticipantPanel() {

		this.setLayout(new GridLayout(20, 1));
		this.add(new JLabel("Select a participant to view:"));
		this.add(participantCombo);

		this.add(new JLabel("participant name:"));
		this.add(name = new JLabel(""));
		this.add(new JLabel("participant Description keywords:"));
		this.add(descript = new JLabel(""));

		name.setPreferredSize(new Dimension(200, 200));

		participantCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Participant p = (Participant) participantCombo.getSelectedItem();

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
		participantCombo.removeAllItems();
		for (Participant par : p.getTheParticipant()) {
			participantCombo.addItem(par);
		}
	}
}
