package userInterface.patternview;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import patternManagement.Pattern;

public class DiagramPanel extends JPanel{
	
	private Image toSHow;
	
	public DiagramPanel(){
		
		
		
	}
	
	public void updateItem(Pattern p) {
		this.removeAll();
		toSHow = p.getTheDiagram().getImage();
		this.add(new JLabel(new ImageIcon(toSHow)));
	}

}