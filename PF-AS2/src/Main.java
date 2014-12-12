import observer.ContextObserver;
import userInterface.MainFrame;
import contextManagement.AbstractFactory;
import contextManagement.AbstractPurposeFactory;
import contextManagement.AbstractScopeFactory;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;
import contextManagement.Purpose;
import contextManagement.Scope;


public class Main {

	public static void main(String[] args) {
		
		
		
		//Initialization of controllers 
		ContextClassification p = new Purpose("Purpose","[Hier komt de omschrijving]");
		ContextClassification s = new Scope("Scope","[Hier komt de omschrijving]");
		
		MainFrame mf11 = new MainFrame(s,p);
		AbstractFactory scopeFactory = new AbstractScopeFactory(mf11);
		AbstractFactory pruposeFactory = new AbstractPurposeFactory(mf11);
		
		p.setTheFactory(pruposeFactory);
		s.setTheFactory(scopeFactory);
		
		ContextObserver o = new ContextObserver(mf11);
		
		ContextCategory behave = new ContextCategory("Behavioral", o);
		ContextCategory create = new ContextCategory("Creational", o);
		ContextCategory structure = new ContextCategory("Structural", o);
		ContextCategory byClass = new ContextCategory("Class", o);
		ContextCategory object = new ContextCategory("Object", o);
		
		p.getTheCategory().add(behave);
		p.getTheCategory().add(create);
		p.getTheCategory().add(structure);
		
		s.getTheCategory().add(byClass);
		s.getTheCategory().add(object);
		
	
		
		
		
	}

}
