package patternManagement;

public class Consequence {
	private String name, description;
	
	Consequence(String nm, String d){
		setName(nm);
		setDescription(d);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
