package ioManagement;

import ioManagement.parser.XmlImportParser;
import ioManagement.parser.XmlParser;
import ioManagement.strategy.ImportStrategy;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import userInterface.MainFrame;
import contextManagement.ContextClassification;

public class InFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3048348149916976801L;
	private MainFrame frameLink;

	private String path;
	private JLabel pathText;
	private JButton file, submit;
	private JComboBox<String> combo;
	private ContextClassification purpose, scope;

	private InFrame self = this;

	public InFrame(MainFrame mf, ContextClassification p,
			ContextClassification s) {
		super("Import repository", true, true, true, true);
		frameLink = mf;
		scope = s;
		purpose = p;
		setLayout(new GridLayout(7, 1));
		this.setSize(new Dimension(400, 150));
		this.add(new JLabel("Please select a repository to add"));
		this.add(pathText = new JLabel("..................."));
		this.add(pathText = new JLabel("Please select a parser"));
		this.add(combo = new JComboBox<String>());
		this.combo.addItem(new String("XML parser"));
		this.combo.addItem(new String("TXT parser"));
		this.add(file = new JButton("Pick file"));
		this.add(submit = new JButton("Submit and import"));
		submit.setEnabled(false);
		this.setVisible(true);

		file.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				// chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					path = chooser.getSelectedFile().getAbsolutePath();
					pathText.setText(path);
					submit.setEnabled(true);
					System.out.println(path);
				} else {
					System.out.println("No Selection ");

				}

			}
		});

		submit.addActionListener(new ActionListener() {
			
	
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String strategyDefinition = (String) combo.getSelectedItem();
				
				if(strategyDefinition.equals("XML parser")){
					try{
					ImportStrategy xgen = new XmlImportParser(path, frameLink);
					xgen.generatePatterns(purpose, scope);
					self.dispose();
					}
					catch(Exception ex){
						
					}
				}
				else if(strategyDefinition.equals("TXT parser")){
					
					JOptionPane
					.showMessageDialog(
							getRootPane(),
							"This function is not yet implemented for TXT parsing, please use a xml parser",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
	}
}
