package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import userInterface.diagramview.DiagramWindow;
import userInterface.patternmanagement.PatternManFrame;
import contextManagement.ContextClassification;

public class MainFrame extends JFrame {

	// frame components
	private JDesktopPane desktop = new JDesktopPane();
	private JMenuBar menu = new JMenuBar();
	private JMenu file = new JMenu("file");
	private JMenuItem newWorkspace = new JMenuItem("New Workspace");

	private ContextClassification purpose, scope;
	
	private PatternManFrame patternmanlink;

	public MainFrame(ContextClassification s, ContextClassification p) {

		super("Cindy");

		purpose = p;
		scope = s;

		this.setLayout(new BorderLayout());

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		this.setSize(xSize, ySize);

		this.setUndecorated(false);

		this.setJMenuBar(menu);
		this.menu.add(file);
		this.file.setMnemonic('f');

		this.desktop.setBackground(Color.DARK_GRAY);
		this.add(desktop);

		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("Observer Pattern");
		listModel.addElement("Model-View_controller Pattern");
		JList patternlist = new JList(listModel);
		
		patternlist.setVisible(true);
		patternlist.setSize(100, 90000);
		patternlist
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		patternlist.add("Pattern 1", new JLabel("Pattern 1"));
		JScrollPane listScroller = new JScrollPane(patternlist);
		listScroller.setPreferredSize(new Dimension(250, 80));

		JPanel eastConatiner = new JPanel();
		eastConatiner.add(new DiagramWindow());

		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				patternlist, desktop);
		splitPane1.setOneTouchExpandable(true);
		splitPane1.setDividerLocation(150);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				splitPane1, eastConatiner);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);

		this.add(splitPane);

		this.file.add(newWorkspace);
		this.newWorkspace.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				 patternmanlink = new PatternManFrame(purpose, scope);
				
				addInternalFrame(patternmanlink);

			}
		});

		this.setVisible(true);
	}

	public void addInternalFrame(JInternalFrame frame) {
		desktop.add(frame);
	}

	public void updateAll(){
	patternmanlink.updateAll();
	}
	
	

}
