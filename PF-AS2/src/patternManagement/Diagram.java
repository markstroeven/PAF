package patternManagement;

import java.awt.Image;

public class Diagram {
	private String name;
	private Image image;
	
	public Diagram(String nm){
		setName(nm);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	
	
}
