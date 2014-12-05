package patternManagement;

public class Diagram {
	private String name, imagePath;
	
	Diagram(String nm, String ip){
		setName(nm);
		setImagePath(ip);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
