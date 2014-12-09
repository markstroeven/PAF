package userInterface.diagramview;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import patternManagement.Pattern;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class DiagramImporter extends JInternalFrame {
	private JTextField name = new JTextField(30);
	public JComboBox<Pattern> combo = new JComboBox<Pattern>();
	private ContextClassification p, s;
	private File imageFile;
	private Image theCurrentImage;

	public DiagramImporter(ContextClassification purpose,
			ContextClassification scope) {

		super("Diaram importer", true, true, true, true);
		p = purpose;
		s = scope;
		populateList();

		this.setVisible(true);
		this.setSize(new Dimension(400, 400));
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		final JTextField url = new JTextField(30);

		JButton file, submit;
		file = new JButton("Pick file");
		submit = new JButton("Add diagram");

		container.add(new JLabel("Please give the diagram a name"));
		container.add(name);
		container.add(new JLabel("SELECTED FILE = "));
		container.add(url);
		container.add(combo);
		container.add(file);
		container.add(submit);

		this.add(container);

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				addImageTopattern();

			}
		});

		file.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				// chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					imageFile = chooser.getSelectedFile();
				} else {
					System.out.println("No Selection ");
				}

				theCurrentImage = convertToImage(imageFile);
				url.setText("" + chooser.getSelectedFile());
			}

		});

	}

	public void populateList() {
		for (ContextCategory c : p.getTheCategory()) {
			for (Pattern p : c.getThePattern()) {
				combo.addItem(p);
			}
		}
		for (ContextCategory c : s.getTheCategory()) {
			for (Pattern p : c.getThePattern()) {
				combo.addItem(p);
			}
		}
	}

	public Image convertToImage(File f) {

		File img = new File(f.getPath());
		BufferedImage bimg;
		Image i = null;
		try {
			bimg = ImageIO.read(img);
			i = bimg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("SAHBIE IKheb plaatje gemaakt");
		return i;

	}

	public void addImageTopattern() {

		Pattern p = (Pattern) combo.getSelectedItem();
		p.addDiagram(name.getText(), theCurrentImage);
		System.out.println("SAHBIE IK GA NU DINGETJE TOEVOEGEN");
	}
}
