package patternManagement;

public class Problem {
	private String name, description;
	
	public Problem(String nm, String d){
		setName(nm);
		setDescription(d);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		return name;
	}
}
