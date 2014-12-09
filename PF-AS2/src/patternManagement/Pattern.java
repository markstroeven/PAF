package patternManagement;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import observer.PatternObserver;

public class Pattern {
	private String name, description;
	private List<Pattern> relatedPattern = new ArrayList<Pattern>();
	private List<Participant> theParticipant = new ArrayList<Participant>();
	private List<Consequence> theConsequence = new ArrayList<Consequence>();
	private List<Solution> theSolution = new ArrayList<Solution>();
	private List<Problem> theProblem = new ArrayList<Problem>();
	private Diagram theDiagram;
	private Force force;
	private PatternObserver observer;

	public Pattern(Force fc, String nm, String d, PatternObserver pob) {
		setForce(fc);
		setName(nm);
		setDescription(d);
		observer = pob;
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

	public Diagram getTheDiagram() {
		return theDiagram;
	}


	public Force getForce() {
		return force;
	}

	public void setForce(Force fc) {
		force = fc;
	}

	public String toString() {
		return name;
	}

	public void addConsequence(Consequence c) {
		theConsequence.add(c);
		observer.alertMembers();
	}

	public void addProblem(Problem p) {
		theProblem.add(p);
		observer.alertMembers();
	}

	public void addSolution(Solution s) {
		theSolution.add(s);
		observer.alertMembers();
	}

	public void addDiagram(String nm, Image i) {

		Diagram d = new Diagram(nm);
		d.setImage(i);
		theDiagram = (d);
		observer.alertMembers();
		System.out.println("SAHBIE alles is gedaan");

	}

	public void addParticipant(Participant p) {

		theParticipant.add(p);
		observer.alertMembers();

	}
	
	
	public String totring(){
		return name;
	}
	

}
