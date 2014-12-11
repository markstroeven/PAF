package finder;

import java.util.ArrayList;
import java.util.Collection;

import patternManagement.Pattern;
import contextManagement.ContextCategory;

public class Finder {

	private ArrayList<Pattern> foundItems = new ArrayList<Pattern>();

	public Finder() {

	}

	public Collection<Pattern> findScope(ContextCategory scope,
			ContextCategory purpose) {
		for (Pattern p : scope.getPatterns()) {
			foundItems.add(p);
		}
		return foundItems;
	}

	public Collection<Pattern> findPurpose(ContextCategory scope,
			ContextCategory purpose) {
		for (Pattern p : purpose.getPatterns()) {
			foundItems.add(p);
		}
		return foundItems;
	}

	public Collection<Pattern> findAll(ContextCategory scope,
			ContextCategory purpose, String s, String pur) {

		for (Pattern p : scope.getPatterns()) {
			if (p.getPatternLinks().contains(s)
					&& p.getPatternLinks().contains(pur)) {
				foundItems.add(p);
			}
		}
		for (Pattern p : purpose.getPatterns()) {
			if (p.getPatternLinks().contains(s)
					&& p.getPatternLinks().contains(p)
					&& !foundItems.contains(pur)) {
				foundItems.add(p);
			}
		}

		return foundItems;
	}

	public void resetFinder() {
		foundItems.clear();
	}

}
