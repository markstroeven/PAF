package patternManagement;

public class Force {
	private double totalWeigh, keywordWeight, contextWeight;
	private String name, description;
	
	public Force(){
		
	}
	
	public void calculateTotalWeight(){
		
	}
	
	public void updateKeywordWeight(double newKeywordWeight){
		keywordWeight = newKeywordWeight;
	}
	
	public void updateContextWeight(double newContextWeight){
		contextWeight = newContextWeight;
	}

	public double getTotalWeigh() {
		return totalWeigh;
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
}
