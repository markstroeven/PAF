package userInterface;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import observer.ContextObserver;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class CategoryManagementFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1710824297540641133L;
	private JComboBox<ContextClassification> classificationCombo = new JComboBox<ContextClassification>();
	private MainFrame frameLink;

	public CategoryManagementFrame(ContextClassification scope,
			ContextClassification purpose, MainFrame mf) {

		super("Category management", true, true, true, true);
		frameLink = mf;
		this.setSize(new Dimension(400, 400));
		this.setLayout(new GridLayout(10, 1));

		this.add(new JLabel("Select context classification"));
		this.add(classificationCombo);
		this.add(new JLabel("Category name"));
		final JTextField name = new JTextField(20);
		this.add(name);
		JButton submit = new JButton("Add new category");
		this.add(submit);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
	
				ContextClassification temp = (ContextClassification)classificationCombo.getSelectedItem();
				temp.getTheFactory().createContextCategory(temp, name.getText());

			}
		});
		
		PopulateCombo(scope, purpose);
		this.setVisible(true);

	}

	public void PopulateCombo(ContextClassification s, ContextClassification p) {

		classificationCombo.addItem(s);
		classificationCombo.addItem(p);

	}

}
