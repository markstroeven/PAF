package ioManagement;

import ioManagement.parser.XmlExportParser;
import ioManagement.strategy.ExportStrategy;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import userInterface.MainFrame;
import contextManagement.ContextClassification;

public class OutFrame extends JInternalFrame {
	
	public OutFrame(final ContextClassification scope, final ContextClassification purpose, MainFrame mf){
		
		super("Export repository",true,true,true,true);
		this.setSize(new Dimension(500,400));
		this.setLayout(new GridLayout(10,1));
		this.add(new JLabel("Select export strategy (in this build XML is the only strategy available)"));
		JButton export = new JButton("Export current data to as repository");
		this.add(export);
		this.setVisible(true);
		
		
		export.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					ExportStrategy XExport = new XmlExportParser();
					XExport.exportXml(scope, purpose);
				}
				catch(Exception excp){
					
				}
			}
		});
		
		
	}

}
