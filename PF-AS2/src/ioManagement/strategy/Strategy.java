package ioManagement.strategy;

import contextManagement.ContextClassification;

public interface Strategy {
	
	abstract void generatePatterns(ContextClassification purpose,
			ContextClassification scope) throws Exception;

}
