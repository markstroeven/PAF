package userInterface.patternview;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import patternManagement.Pattern;

public class DiagramPanel extends JPanel {

	private Image toSHow;

	public DiagramPanel() {

	}

	public Image getToSHow() {
		return toSHow;
	}

	public void setToSHow(Image toSHow) {
		this.toSHow = toSHow;
	}

	public void updateItem(Pattern p) {
		this.removeAll();
		toSHow = p.getTheDiagram().getImage();
		if (toSHow != null) {
			this.add(new JLabel(new ImageIcon(toSHow)));
		}

	}

}
