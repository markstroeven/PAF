package patternManagement;

import java.awt.Image;

public class Diagram {
	private Image image;
	private String filePath;

	public Diagram() {

	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean hasValue() {
		if (filePath.isEmpty()) {
			return false;
		} else {

			return true;
		}
	}

}
