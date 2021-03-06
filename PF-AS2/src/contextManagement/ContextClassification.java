package contextManagement;
import java.util.ArrayList;
import java.util.List;


public abstract class ContextClassification {
	protected String name;
	private String description;
	private List<ContextCategory> theCategory = new ArrayList<ContextCategory>();
	private AbstractFactory theFactory;
	
	ContextClassification(String nm, String d){
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

	public List<ContextCategory> getTheCategory() {
		return theCategory;
	}

	public void setTheCategory(List<ContextCategory> theCategory) {
		this.theCategory = theCategory;
	}
	
	public abstract void addContextCategory(ContextCategory c);

	public ContextCategory searchCategory(String nm){
		ContextCategory searched = null;
		for(ContextCategory c : theCategory){
			if(c.getName().equals(nm)){
				searched = c;
			}
		}
		return searched;
	}
	
	public String toString(){
		return name;
	}

	public AbstractFactory getTheFactory() {
		return theFactory;
	}

	public void setTheFactory(AbstractFactory theFactory) {
		this.theFactory = theFactory;
	}
	
}	

