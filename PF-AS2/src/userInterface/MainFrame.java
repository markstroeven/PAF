package userInterface;

import finder.CategorySearcherFrame;
import ioManagement.InFrame;
import ioManagement.OutFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import patternManagement.Pattern;
import userInterface.diagramview.DiagramImporter;
import userInterface.patternmanagement.PatternManFrame;
import userInterface.patternmanagement.edit.EditFrame;
import userInterface.patternview.PatternPanel;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 199816998292226292L;
	// frame components

	private JDesktopPane desktop = new JDesktopPane();
	private JMenuBar menu = new JMenuBar();
	private JMenu file = new JMenu("file");
	private JMenuItem newManagementView = new JMenuItem("New management view");
	private JMenu resource = new JMenu("External resources");
	private JMenuItem newDiagramm = new JMenuItem("New diagram resource");
	private JMenu io = new JMenu("Import / exort repository");
	private JMenuItem in = new JMenuItem("Import repository");
	private JMenuItem out = new JMenuItem("Export repository");
	private JMenu catMan = new JMenu("Category Management");
	private JMenuItem addCat = new JMenuItem("Add new category");

	private JMenu search = new JMenu("Search pattern");
	JMenuItem searchGeneral = new JMenuItem("Search pattern by category");
	JMenuItem searchKeyword = new JMenuItem("Search pattern by keywords");

	private ContextClassification purpose, scope;

	private PatternManFrame patternmanlink;
	private MainFrame mainFrameLink = this;
	private DefaultListModel<Object> listModel;
	private PatternPanel patternPanel1;

	private JList<Object> patternlist;

	public MainFrame(ContextClassification s, ContextClassification p) {

		super("Patternative");
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
		this.menu.add(resource);
		this.menu.add(io);
		this.io.add(in);
		this.io.add(out);
		this.resource.add(newDiagramm);
		this.menu.add(search);
		this.search.add(searchGeneral);
		this.search.add(searchKeyword);
		this.menu.add(catMan);
		this.catMan.add(addCat);
		
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OutFrame out = new OutFrame(scope, purpose, mainFrameLink);
				addInternalFrame(out);
				
			}
		});

		addCat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CategoryManagementFrame catManFrame = new CategoryManagementFrame(
						scope, purpose, mainFrameLink);
				addInternalFrame(catManFrame);
			}
		});

		// COLOR ASSIGNMENT
		menu.setBackground(Color.WHITE);
		// IMAGEICON ASSIGNMENT
		file.setIcon(new ImageIcon("resources\\interfaceimages\\file.png"));
		io.setIcon(new ImageIcon("resources\\interfaceimages\\import.jpg"));
		resource.setIcon(new ImageIcon(
				"resources\\interfaceimages\\external.jpg"));
		search.setIcon(new ImageIcon("resources\\interfaceimages\\search.jpg"));
		catMan.setIcon(new ImageIcon("resources\\interfaceimages\\category.png"));
		// SWING ACCELERATOR'S
		KeyStroke ctrlKeystrokeNewManView = KeyStroke.getKeyStroke("control N");
		newManagementView.setAccelerator(ctrlKeystrokeNewManView);

		KeyStroke ctrlKeystrokeImport = KeyStroke.getKeyStroke("control I");
		in.setAccelerator(ctrlKeystrokeImport);

		KeyStroke ctrlKeystrokeNewDiagram = KeyStroke.getKeyStroke("control D");
		newDiagramm.setAccelerator(ctrlKeystrokeNewDiagram);

		KeyStroke ctrlKeystrokesearch = KeyStroke.getKeyStroke("control S");
		searchGeneral.setAccelerator(ctrlKeystrokesearch);

		this.desktop.setBackground(Color.DARK_GRAY);

		in.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InFrame iframe = new InFrame(mainFrameLink, purpose, scope);
				addInternalFrame(iframe);

			}
		});

		listModel = new DefaultListModel<Object>();
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

		patternlist = new JList<Object>(listModel);
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
					JMenuItem editItem = new JMenuItem("Edit pattern");
					editItem.setIcon(new ImageIcon(
							"resources\\interfaceimages\\edit.jpg"));
					JMenuItem delete = new JMenuItem("Delete this pattern");
					JPopupMenu pop = new JPopupMenu();
					pop.add(editItem);
					pop.add(delete);
					pop.show(patternlist, e.getX(), e.getY());

					editItem.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							Pattern p = (Pattern) patternlist
									.getSelectedValue();
							System.out.println("GESELECTEERD : " + p.getName());

							EditFrame ef = new EditFrame(p);
							addInternalFrame(ef);

						}
					});
					delete.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Pattern p = (Pattern) patternlist
									.getSelectedValue();

							Iterator<ContextCategory> contextIter = scope
									.getTheCategory().iterator();
							while (contextIter.hasNext()) {
								ContextCategory current = contextIter.next();

								Iterator<Pattern> patternIter = current
										.getPatterns().iterator();
								while (patternIter.hasNext()) {

									Pattern currentPattern = patternIter.next();
									if (current.getPatterns().contains(
											currentPattern)) {

										patternIter.remove();
										System.out
												.println("Ik heb hem verwijderd");
										refreshList();
										patternlist.revalidate();
										patternlist.repaint();
									}

								}

							}

							contextIter = purpose.getTheCategory().iterator();
							while (contextIter.hasNext()) {
								ContextCategory current = contextIter.next();

								Iterator<Pattern> patternIter = current
										.getPatterns().iterator();
								while (patternIter.hasNext()) {

									Pattern currentPattern = patternIter.next();
									if (current.getPatterns().contains(
											currentPattern)) {

										patternIter.remove();
										System.out
												.println("Ik heb hem verwijderd");
										refreshList();
										patternlist.revalidate();
										patternlist.repaint();
									}

								}

							}

						}
					});

				}
			}
		});

		searchGeneral.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CategorySearcherFrame frame = new CategorySearcherFrame(
						mainFrameLink, scope, purpose);
				addInternalFrame(frame);
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
		splitPane.setDividerLocation(850);

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
				if (!listModel.contains(pat)) {
					listModel.addElement(pat);

				}
			}
		}

		for (ContextCategory c : scope.getTheCategory()) {
			for (Pattern pat : c.getPatterns()) {
				if (!listModel.contains(pat)) {
					listModel.addElement(pat);
				}
			}
		}
		this.revalidate();
		this.repaint();
	}

	public void setSelectedPattern(Pattern p) {
		patternPanel1.updateItem(p);
		patternlist.setSelectedValue(p, true);

	}

}
