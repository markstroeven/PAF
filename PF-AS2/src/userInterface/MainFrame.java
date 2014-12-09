package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import patternManagement.Pattern;
import userInterface.diagramview.DiagramImporter;
import userInterface.patternmanagement.PatternManFrame;
import userInterface.patternview.PatternPanel;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class MainFrame extends JFrame {

	// frame components
	private JDesktopPane desktop = new JDesktopPane();
	private JMenuBar menu = new JMenuBar();
	private JMenu file = new JMenu("file");
	private JMenuItem newManagementView = new JMenuItem("New management view");

	private JMenu resource = new JMenu("External resources");
	private JMenuItem newDiagramm = new JMenuItem("New diagram resource");

	private ContextClassification purpose, scope;

	private PatternManFrame patternmanlink;
	private MainFrame mainFrameLink = this;
	private DefaultListModel listModel;
	private PatternPanel patternPanel1;

	public MainFrame(ContextClassification s, ContextClassification p) {

		super("Cindy");

		purpose = p;
		scope = s;

		this.setLayout(new BorderLayout());

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		newManagementView.setMnemonic(KeyEvent.VK_N);

		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		this.setSize(xSize, ySize);

		this.setUndecorated(false);

		this.setJMenuBar(menu);
		this.menu.add(file);
		this.file.setMnemonic('f');
		this.menu.add(resource);
		this.resource.add(newDiagramm);

		this.desktop.setBackground(Color.DARK_GRAY);
		this.add(desktop);

		listModel = new DefaultListModel();

		for (ContextCategory c : purpose.getTheCategory()) {
			for (Pattern pat : c.getPatterns()) {
				listModel.addElement(pat);
			}
		}

		for (ContextCategory c : scope.getTheCategory()) {
			for (Pattern pat : c.getPatterns()) {
				listModel.addElement(pat);
			}
		}

		final JList patternlist = new JList(listModel);

		ListSelectionModel selectList = patternlist.getSelectionModel();
		selectList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("Ik ben evrnaderd");

				Pattern p = (Pattern) patternlist.getSelectedValue();

				if (p != null) {
					patternPanel1.updateItem(p);
				}

			}
		});

		patternlist.setVisible(true);
		patternlist.setSize(100, 90000);
		patternlist
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		patternlist.add("Pattern 1", new JLabel("Pattern 1"));
		JScrollPane listScroller = new JScrollPane(patternlist);
		listScroller.setPreferredSize(new Dimension(250, 80));

		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				patternlist, desktop);
		splitPane1.setOneTouchExpandable(true);
		splitPane1.setDividerLocation(150);

		patternPanel1 = new PatternPanel();
		patternPanel1.setLayout(new GridLayout());
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				splitPane1, patternPanel1);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);

		this.add(splitPane);

		this.file.add(newManagementView);
		this.newManagementView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				patternmanlink = new PatternManFrame(purpose, scope,
						mainFrameLink);

				addInternalFrame(patternmanlink);

			}
		});

		newDiagramm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DiagramImporter dip = new DiagramImporter(scope, purpose);
				addInternalFrame(dip);

			}
		});

		listModel.addListDataListener(new ListDataListener() {

			@Override
			public void intervalRemoved(ListDataEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void intervalAdded(ListDataEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void contentsChanged(ListDataEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.setVisible(true);
	}

	public void addInternalFrame(JInternalFrame frame) {
		desktop.add(frame);
	}

	public void updateAll() {
		refreshList();
	}

	public void refreshList() {
		listModel.removeAllElements();
		for (ContextCategory c : purpose.getTheCategory()) {
			for (Pattern pat : c.getPatterns()) {
				listModel.addElement(pat);
			}
		}

		for (ContextCategory c : scope.getTheCategory()) {
			for (Pattern pat : c.getPatterns()) {
				listModel.addElement(pat);
			}
		}
		this.revalidate();
		this.repaint();
	}

}
