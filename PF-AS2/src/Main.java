import userInterface.MainFrame;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;
import contextManagement.Purpose;
import contextManagement.Scope;


public class Main {

	public static void main(String[] args) {
		
		//Initialization of controllers 
		ContextClassification p = new Purpose("Purpose","[Hier komt de omschrijving]");
		ContextClassification s = new Scope("Purpose","[Hier komt de omschrijving]");
		
		ContextCategory behave = new ContextCategory("Behavioral");
		ContextCategory create = new ContextCategory("Creational");
		ContextCategory structure = new ContextCategory("Structural");
		ContextCategory byClass = new ContextCategory("Class");
		ContextCategory object = new ContextCategory("Object");
		
		p.getTheCategory().add(behave);
		p.getTheCategory().add(create);
		p.getTheCategory().add(structure);
		
		s.getTheCategory().add(byClass);
		s.getTheCategory().add(object);
		
		MainFrame mf11 = new MainFrame(s,p);
	}

}
