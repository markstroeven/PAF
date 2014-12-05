package patternManagement;
import java.util.ArrayList;
import java.util.List;


public class Pattern {
	private String name, description;
	private List<Pattern> relatedPattern = new ArrayList<Pattern>();
	private List<Participant> theParticipant = new ArrayList<Participant>();
	private List<Consequence> theConsequence = new ArrayList<Consequence>();
	private List<Solution> theSolution = new ArrayList<Solution>();
	private List<Problem> theProblem = new ArrayList<Problem>();
	private List<Diagram> theDiagram = new ArrayList<Diagram>();
	private Force force;
	
	public Pattern(Force fc, String nm, String d){
		setForce(fc);
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

	public List<Pattern> getRelatedPattern() {
		return relatedPattern;
	}

	public void setRelatedPattern(List<Pattern> relatedPattern) {
		this.relatedPattern = relatedPattern;
	}

	public List<Participant> getTheParticipant() {
		return theParticipant;
	}

	public void setTheParticipant(List<Participant> theParticipant) {
		this.theParticipant = theParticipant;
	}

	public List<Solution> getTheSolution() {
		return theSolution;
	}

	public void setTheSolution(List<Solution> theSolution) {
		this.theSolution = theSolution;
	}

	public List<Consequence> getTheConsequence() {
		return theConsequence;
	}

	public void setTheConsequence(List<Consequence> theConsequence) {
		this.theConsequence = theConsequence;
	}

	public List<Problem> getTheProblem() {
		return theProblem;
	}

	public void setTheProblem(List<Problem> theProblem) {
		this.theProblem = theProblem;
	}

	public List<Diagram> getTheDiagram() {
		return theDiagram;
	}

	public void setTheDiagram(List<Diagram> theDiagram) {
		this.theDiagram = theDiagram;
	}

	public Force getForce() {
		return force;
	}

	public void setForce(Force fc) {
		force = fc;
	}
	
	public String toString(){
		return name;
	}
}
