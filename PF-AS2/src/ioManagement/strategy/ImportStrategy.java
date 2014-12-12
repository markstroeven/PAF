package ioManagement.strategy;

import contextManagement.ContextClassification;

public interface ImportStrategy {
	
	abstract void generatePatterns(ContextClassification purpose,
			ContextClassification scope) throws Exception;

}
