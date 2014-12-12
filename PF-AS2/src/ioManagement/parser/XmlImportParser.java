package ioManagement.parser;

import ioManagement.strategy.ImportStrategy;

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

import patternManagement.Consequence;
import patternManagement.Force;
import patternManagement.Participant;
import patternManagement.Pattern;
import patternManagement.Problem;
import patternManagement.Solution;
import userInterface.MainFrame;
import contextManagement.ContextClassification;

public class XmlImportParser implements ImportStrategy {

	private Document doc;
	private MainFrame frameLink;

	public XmlImportParser(String path, MainFrame mf) throws SAXException,
			IOException, ParserConfigurationException {
		frameLink = mf;
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(fXmlFile);
	}

	@Override
	public void generatePatterns(ContextClassification purpose,
			ContextClassification scope) throws Exception {
		
		System.out.println("Starting generator");
		
		int patternAmmount = Integer.parseInt(doc
				.getElementsByTagName("meta-pattern-ammount").item(0)
				.getTextContent());

		int problemAmmount;
		int solutionAmmount;
		int participantAmmount;
		int consequenceAmmount;

		int patternCounter = 0;
		String patternName, patternDescription, category, category2, patternClassification, diagramPath;
		String problemName, problemDescription;
		String solutionName, solutionDescription;
		String consequenceName, consequenceDescription;
		String participantName, participantDescription;

		for(int ammount = 0; ammount < patternAmmount; ammount++){
			System.out.println("Building pattern:" + patternCounter);
			problemAmmount = Integer.parseInt(doc
					.getElementsByTagName("meta-problem").item(patternCounter)
					.getTextContent());
			solutionAmmount = Integer.parseInt(doc
					.getElementsByTagName("meta-solution").item(patternCounter)
					.getTextContent());
			participantAmmount = Integer.parseInt(doc
					.getElementsByTagName("meta-participant")
					.item(patternCounter).getTextContent());
			consequenceAmmount = Integer.parseInt(doc
					.getElementsByTagName("meta-consequence")
					.item(patternCounter).getTextContent());

			System.out.println("Detected headers:");
			System.out.println("");
			System.out.println(problemAmmount + " Problems");
			System.out.println(solutionAmmount + " Solutions");
			System.out.println(participantAmmount + " Participants");
			System.out.println(consequenceAmmount + " Consequences");
			System.out.println("");

			patternName = doc.getElementsByTagName("pattern-name")
					.item(ammount).getTextContent();
			System.out.println("Dtected tag value -> " + patternName);
			
			patternDescription = doc
					.getElementsByTagName("pattern-description")
					.item(ammount).getTextContent();
			System.out.println("Dtected tag value -> " + patternDescription);
			
			patternClassification = doc
					.getElementsByTagName("pattern-classification")
					.item(ammount).getTextContent();
			System.out.println("Dtected tag value -> " + patternClassification);
			
			diagramPath = doc.getElementsByTagName("diagram-path")
					.item(ammount).getTextContent();
			System.out.println("Dtected tag value -> " + diagramPath);
			
			category = doc.getElementsByTagName("pattern-category-scope")
					.item(ammount).getTextContent();
			System.out.println("Dtected tag value -> " + category);
			
			category2 = doc.getElementsByTagName("pattern-category-purpose")
					.item(ammount).getTextContent();
			System.out.println("Dtected tag value -> " + category2);
			

			Pattern buildPattern = new Pattern(new Force(), patternName,
					patternDescription, new PatternObserver(frameLink));
			buildPattern.getPatternLinks().add(category);
			buildPattern.getPatternLinks().add(category2);
			
			System.out.println("Pattern : " + ammount + " built." );
			
			if (problemAmmount > 0) {
				for (int i = 0; i < problemAmmount; i++) {
					System.out.println("");
					System.out.println("Building problem : " + i);
					problemName = doc.getElementsByTagName("problem-name")
							.item(i).getTextContent();
					System.out.println("Dtected tag value -> " + problemName);
					
					problemDescription = doc
							.getElementsByTagName("probleem-description")
							.item(i).getTextContent();
					System.out.println("Dtected tag value -> " + problemDescription);

					Problem p = new Problem(problemName, problemDescription);
					buildPattern.addProblem(p);
					System.out.println("Problem : " + i + " built.");
				}
			}
			
			if (solutionAmmount > 0) {
				for (int i = 0; i < solutionAmmount; i++) {
					System.out.println("");
					System.out.println("Building solution : " + i);
					solutionName = doc.getElementsByTagName("solution-name")
							.item(i).getTextContent();
					System.out.println("Dtected tag value -> " + solutionName);
					
					solutionDescription = doc
							.getElementsByTagName("solution-description")
							.item(i).getTextContent();
					System.out.println("Dtected tag value -> " + solutionDescription);
					
					Solution sol = new Solution(solutionName, solutionDescription);
					buildPattern.addSolution(sol);
					System.out.println("Solution : " + i + " built.");
				}
			}
			
			
			if (consequenceAmmount > 0) {
				for (int i = 0; i < consequenceAmmount; i++) {
					System.out.println("");
					System.out.println("Building consequence : " + i);
					consequenceName = doc.getElementsByTagName("consequence-name")
							.item(i).getTextContent();
					System.out.println("Dtected tag value -> " + consequenceName);
					
					consequenceDescription = doc
							.getElementsByTagName("consequence-description")
							.item(i).getTextContent();
					System.out.println("Dtected tag value -> " + consequenceAmmount);
					

					Consequence con = new Consequence(consequenceName,
							consequenceDescription);
					buildPattern.addConsequence(con);
					System.out.println("Consequence : " + i + " built.");
				}
			}
			
			
			if (participantAmmount > 0) {
				for (int i = 0; i < participantAmmount; i++) {
					System.out.println("");
					System.out.println("Building participant : " + i);
					participantName = doc.getElementsByTagName("participant-name")
							.item(i).getTextContent();
					System.out.println("Dtected tag value -> " + participantName);
					
					participantDescription = doc
							.getElementsByTagName("participant-description")
							.item(i).getTextContent();
					System.out.println("Dtected tag value -> " + participantDescription);
					

					Participant p = new Participant(participantName,
							participantDescription);
					buildPattern.addParticipant(p);
					System.out.println("Participant : " + i + " built.");
				}
			}
			
			
			if(!diagramPath.isEmpty()){
				System.out.println("");
				System.out.println("Diagram building!");
				File f = new File(diagramPath);
				Image i = convertToImage(f);
				buildPattern.addDiagram(i, new File(diagramPath));	
				System.out.println("Diagram built.");
			}else{
				System.out.println("NO DIAGRAM FOUND WITHIN THIS PATTERN");
			}
			
			
			scope.searchCategory(category).addPattern(buildPattern);
			purpose.searchCategory(category2).addPattern(buildPattern);

			
	
		}
		
		

	}
	public Image convertToImage(File f) {

		File img = new File(f.getPath());
		BufferedImage bimg;
		Image i = null;
		try {
			bimg = ImageIO.read(img);
			i = bimg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}
	
	


}
