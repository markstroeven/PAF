package patternManagement;

public class Force {
	private double totalWeigh, keywordWeight, contextWeight;
	
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
}
