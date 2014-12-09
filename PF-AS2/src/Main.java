import userInterface.MainFrame;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;
import contextManagement.ContextObserver;
import contextManagement.Purpose;
import contextManagement.Scope;


public class Main {

	public static void main(String[] args) {
		
		//Initialization of controllers 
		ContextClassification p = new Purpose("Purpose","[Hier komt de omschrijving]");
		ContextClassification s = new Scope("Purpose","[Hier komt de omschrijving]");
		
		MainFrame mf11 = new MainFrame(s,p);
		
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
