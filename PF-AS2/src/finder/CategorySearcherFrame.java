package finder;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import patternManagement.Pattern;
import userInterface.MainFrame;
import userInterface.patternmanagement.edit.EditFrame;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class CategorySearcherFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3980299374710370130L;
	private MainFrame frameLink;
	private ContextClassification scope, purpose;
	private JComboBox<ContextCategory> scopeCombo = new JComboBox<ContextCategory>();
	private JComboBox<ContextCategory> purposeCombo = new JComboBox<ContextCategory>();
	private DefaultListModel<Object> listModel = new DefaultListModel<Object>();
	private JButton search = new JButton("Search for patterns");
	private Finder theFinder = new Finder();
	private JCheckBox includeScope, includePurpose;
	private Collection<Pattern> foundPatterns = null;

	public CategorySearcherFrame(MainFrame mf, ContextClassification s,
			ContextClassification p) {
		super("Search pattern by category", true, true, true, true);

		frameLink = mf;
		scope = s;
		purpose = p;

		this.setSize(new Dimension(400, 700));
		setLayout(new GridLayout(11, 1));
		this.add(new JLabel("Please specify a scope category:"));
		this.add(scopeCombo);
		this.add(includeScope = new JCheckBox("Include in search"));
		this.add(new JLabel("Please specify a purpose category:"));
		this.add(purposeCombo);
		this.add(includePurpose = new JCheckBox("Include in search"));
		this.add(search);
		this.add(new JLabel("Please select a result in order to view"));

		final JList<Object> patternlist = new JList<Object>(listModel);
		ListSelectionModel selectList = patternlist.getSelectionModel();
		patternlist.setVisible(true);
		patternlist.setSize(100, 90000);
		patternlist
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		patternlist.add("Pattern 1", new JLabel("Pattern 1"));
		JScrollPane listScroller = new JScrollPane(patternlist);
		listScroller.setPreferredSize(new Dimension(250, 300));
		this.add(listScroller);

		populateList();

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listModel.removeAllElements();
				boolean passed = false;
				ContextCategory onScope, onPurpose;
				onScope = (ContextCategory) scopeCombo.getSelectedItem();
				onPurpose = (ContextCategory) purposeCombo.getSelectedItem();

				if (includePurpose.isSelected() && includeScope.isSelected()) {
					System.out.println("search op beide cat");
					// voer find op beide category's uit

					ContextCategory temp1 = (ContextCategory)scopeCombo.getSelectedItem();
					String scopeString = temp1.getName();
					ContextCategory temp2 = (ContextCategory)purposeCombo.getSelectedItem();
					String purposeString = temp2.getName();
					foundPatterns = theFinder.findAll(onScope, onPurpose, scopeString, purposeString);

					passed = true;

				}
				if (includePurpose.isSelected() && !includeScope.isSelected()) {
					System.out.println("search op purpose");
					// voer find op alleen purpose uit

					foundPatterns = theFinder.findPurpose(onScope, onPurpose);

					passed = true;
				}
				if (!includePurpose.isSelected() && includeScope.isSelected()) {
					System.out.println("search op scope");
					// voer find op alleen purpose uit

					foundPatterns = (ArrayList<Pattern>) theFinder.findScope(
							onScope, onPurpose);

					passed = true;

				}
				if (!includePurpose.isSelected() && !includeScope.isSelected()) {
					JOptionPane.showMessageDialog(getRootPane(),
							"Include at least one category in your search!",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}

				if (passed) {
					for (Pattern p : foundPatterns) {
						listModel.addElement(p);
					}
				}
				passed = false;
				theFinder.resetFinder();

			}
		});

		patternlist.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				check(e);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				check(e);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void check(MouseEvent e) {
				if (e.isPopupTrigger()) { // if the event shows the menu
					patternlist.setSelectedIndex(patternlist.locationToIndex(e
							.getPoint())); // select the item

					System.out.println("ik doe het");
					JMenuItem editItem = new JMenuItem(
							"Select this pattern into view");
					JPopupMenu pop = new JPopupMenu();
					pop.add(editItem);
					pop.show(patternlist, e.getX(), e.getY());

					editItem.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							Pattern p = (Pattern) patternlist
									.getSelectedValue();
							if (p != null) {
								frameLink.setSelectedPattern(p);
							}

						}
					});

				}
			}
		});

		this.setVisible(true);
	}

	public void populateList() {

		for (ContextCategory cont : scope.getTheCategory()) {

			scopeCombo.addItem(cont);

		}

		for (ContextCategory cont : purpose.getTheCategory()) {

			purposeCombo.addItem(cont);

		}

	}

}
