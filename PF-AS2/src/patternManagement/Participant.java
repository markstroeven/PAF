package patternManagement;
import java.util.ArrayList;
import java.util.List;


public class Participant {
	private String name, description;
	private List<String> superType = new ArrayList<String>();
	private List<String> method = new ArrayList<String>();
	
	Participant(String nm, String d){
		name = nm;
		description = d;
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

	public List<String> getSuperType() {
		return superType;
	}

	public void setSuperType(List<String> superType) {
		this.superType = superType;
	}

	public List<String> getMethod() {
		return method;
	}

	public void setMethod(List<String> method) {
		this.method = method;
	}
	
}
