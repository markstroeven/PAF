package patternManagement;

public class Solution {
	private String name, description;
	
	public Solution(String nm, String d){
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
