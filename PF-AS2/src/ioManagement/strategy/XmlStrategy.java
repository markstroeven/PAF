package ioManagement.strategy;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.w3c.dom.Document;

import observer.PatternObserver;
import patternManagement.Force;
import patternManagement.Pattern;
import userInterface.MainFrame;
import contextManagement.ContextClassification;

public class XmlStrategy implements Strategy {
	
	private Document doc;
	private MainFrame frameLink;
	
	public XmlStrategy(MainFrame mf){
		
	}
	

	@Override
	public void generatePatterns(ContextClassification purpose,
			ContextClassification scope) throws Exception {
	
		System.out.println("Ik wordt gerunned");
		
		String classification, category, name, description, path;
		int counter = 0;
		
		while(true){
			
			try{
				classification = doc.getElementsByTagName("classification").item(counter).getTextContent();
			}
			catch(NullPointerException e){
				break;
			}
			
			category = doc.getElementsByTagName("category").item(counter).getTextContent();
			name = doc.getElementsByTagName("name").item(counter).getTextContent();
			description = doc.getElementsByTagName("description").item(counter).getTextContent();
			path = doc.getElementsByTagName("diagram-path").item(counter).getTextContent();
			

			File img = new File(path);
			BufferedImage bimg;
			Image i = null;
			try {
				bimg = ImageIO.read(img);
				i = bimg;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (classification.equals("Scope")) {
				Pattern p = new Pattern(new Force(), name, description,
						new PatternObserver(frameLink));
				scope.searchCategory(category).addPattern(p);
				p.addDiagram(i);

			} else {
				Pattern p = new Pattern(new Force(), name, description,
						new PatternObserver(frameLink));
				purpose.searchCategory(category).addPattern(p);
				p.addDiagram(i);
			}

			counter++;
			
			
		}
		
		
	}

}
