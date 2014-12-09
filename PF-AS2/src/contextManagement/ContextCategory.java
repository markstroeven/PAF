package contextManagement;

import java.util.ArrayList;
import java.util.List;

import patternManagement.Pattern;

public class ContextCategory implements AbstractContextCategory {
	private String name;
	private List<Pattern> thePattern = new ArrayList<Pattern>();
	private ContextObserver observer;

	public Pattern searchPattern(String nm) {

		Pattern searched = null;

		for (Pattern p : thePattern) {
			if (p.getName().equals(nm)) {
				searched = p;
			}
		}

		return searched;
	}

	public ContextCategory(String nm, ContextObserver o) {
		observer = o;
		setName(nm);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pattern> getThePattern() {
		return thePattern;
	}

	public void setThePattern(List<Pattern> thePattern) {
		this.thePattern = thePattern;
	}

	public List<Pattern> getPatterns() {
		return thePattern;
	}

	public String toString() {
		return name;
	}

	public void addPattern(Pattern p) {
		thePattern.add(p);
		observer.alert();
	}
}
