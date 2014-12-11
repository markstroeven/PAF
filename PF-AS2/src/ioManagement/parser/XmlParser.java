package ioManagement.parser;

import ioManagement.strategy.Strategy;
import ioManagement.strategy.XmlStrategy;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import observer.PatternObserver;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import patternManagement.Force;
import patternManagement.Pattern;
import patternManagement.Problem;
import userInterface.MainFrame;
import contextManagement.ContextClassification;

public class XmlParser {

	private Document doc;
	private MainFrame frameLink;
	private String prio; 

	public XmlParser(String path, MainFrame mf) throws SAXException,
			IOException, ParserConfigurationException {

		frameLink = mf;
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(fXmlFile);

	}

//	public void generatePatterns(ContextClassification purpose,
//			ContextClassification scope) throws Exception {
//
//		System.out.println("Ik wordt gerunned");
//
//		String classification, category, name, description, path;
//		int counter = 0;
//
//		while (true) {
//
//			try {
//				classification = doc.getElementsByTagName("classification")
//						.item(counter).getTextContent();
//			} catch (NullPointerException e) {
//				break;
//			}
//
//			category = doc.getElementsByTagName("category").item(counter)
//					.getTextContent();
//			name = doc.getElementsByTagName("name").item(counter)
//					.getTextContent();
//			description = doc.getElementsByTagName("description").item(counter)
//					.getTextContent();
//			path = doc.getElementsByTagName("diagram-path").item(counter)
//					.getTextContent();
//
//			File img = new File(path);
//			BufferedImage bimg;
//			Image i = null;
//			try {
//				bimg = ImageIO.read(img);
//				i = bimg;
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			if (classification.equals("Scope")) {
//				Pattern p = new Pattern(new Force(), name, description,
//						new PatternObserver(frameLink));
//				scope.searchCategory(category).addPattern(p);
//				p.addDiagram(i);
//
//			} else {
//				Pattern p = new Pattern(new Force(), name, description,
//						new PatternObserver(frameLink));
//				purpose.searchCategory(category).addPattern(p);
//				p.addDiagram(i);
//			}
//
//			counter++;
//
//		}
//	}
	
	public void generatePatterns(ContextClassification purpose,
			ContextClassification scope) throws Exception {
		
		Pattern buildPattern = null;
		int patternCounter = 0;
		
		System.out.println("Initiating parser");
		System.out.println("Starting pattern parser.....");
		//Hier wordt het pattern object geparsed
		
		String patternName, patternDescription, category, category2 = null, patternClassification, diagramPath;
		
		patternName = doc.getElementsByTagName("pattern-name").item(patternCounter).getTextContent();
		patternDescription = doc.getElementsByTagName("pattern-description").item(patternCounter).getTextContent();
		patternClassification = doc.getElementsByTagName("pattern-classification").item(patternCounter).getTextContent();
		diagramPath = doc.getElementsByTagName("diagram-path").item(patternCounter).getTextContent();
		category = doc.getElementsByTagName("pattern-category-scope").item(patternCounter).getTextContent();
		category2 = doc.getElementsByTagName("pattern-category-purpose").item(patternCounter).getTextContent();
		prio = patternClassification;
		
		System.out.println(category);
		
		System.out.println(category2);
		
		
		
		buildPattern  = new Pattern(new Force(), patternName, patternDescription, new PatternObserver(frameLink));
		buildPattern.getPatternLinks().add(category);
		buildPattern.getPatternLinks().add(category2);
		
		System.out.println("Starting problem parser.....");
		
		if(doc.getElementsByTagName("problem-name").item(0).getTextContent() != null){
			System.out.println("Problem tag found -> parsing !");
			String problemName, problemDescription;
			int problemCounter = 0; 
			
			while(true){
				
				System.out.println("Loop tick : " + problemCounter);
				
				problemName = doc.getElementsByTagName("problem-name").item(problemCounter).getTextContent();
				problemDescription = doc.getElementsByTagName("probleem-description").item(problemCounter).getTextContent();
				
				
				Problem p = new Problem(problemName, problemDescription);
				buildPattern.addProblem(p);
				
				try{
					doc.getElementsByTagName("problem-name").item(problemCounter+1).getTextContent();
					}
					catch(NullPointerException e){
						break;
					}
				
				problemCounter++;

				
			}
			
		}

		
		
		
		
		scope.searchCategory(category).addPattern(buildPattern);
		purpose.searchCategory(category2).addPattern(buildPattern);
		

	}

}
