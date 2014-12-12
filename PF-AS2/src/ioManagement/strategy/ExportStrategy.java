package ioManagement.strategy;

import contextManagement.ContextClassification;

public interface ExportStrategy {
	
	abstract void exportXml(ContextClassification scope, ContextClassification purposes);

}
