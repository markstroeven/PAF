package ioManagement.parser;

import ioManagement.strategy.ImportStrategy;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import observer.PatternObserver;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import patternManagement.Consequence;
import patternManagement.Diagram;
import patternManagement.Force;
import patternManagement.Participant;
import patternManagement.Pattern;
import patternManagement.Problem;
import patternManagement.Solution;
import userInterface.MainFrame;
import contextManagement.ContextClassification;

public class XmlParser implements ImportStrategy {

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

	@Override
	public void generatePatterns(ContextClassification purpose,
			ContextClassification scope) throws Exception {

		Pattern buildPattern = null;
		int patternCounter = 0;

		System.out.println("Initiating parser");
		System.out.println("Starting pattern parser.....");
		// Hier wordt het pattern object geparsed

		String patternName, patternDescription, category, category2 = null, patternClassification, diagramPath;

		patternName = doc.getElementsByTagName("pattern-name")
				.item(patternCounter).getTextContent();
		patternDescription = doc.getElementsByTagName("pattern-description")
				.item(patternCounter).getTextContent();
		patternClassification = doc
				.getElementsByTagName("pattern-classification")
				.item(patternCounter).getTextContent();
		diagramPath = doc.getElementsByTagName("diagram-path")
				.item(patternCounter).getTextContent();
		category = doc.getElementsByTagName("pattern-category-scope")
				.item(patternCounter).getTextContent();
		category2 = doc.getElementsByTagName("pattern-category-purpose")
				.item(patternCounter).getTextContent();
		prio = patternClassification;

		System.out.println(category);

		System.out.println(category2);

		System.out.println(diagramPath);
		
		

		buildPattern = new Pattern(new Force(), patternName,
				patternDescription, new PatternObserver(frameLink));
		if(!diagramPath.isEmpty()){
			File f = new File(diagramPath);
			Image i = convertToImage(f);
			buildPattern.addDiagram(i, new File(diagramPath));			
		}else{
			System.out.println("NO DIAGRAM FOUND WITHIN THIS PATTERN");
		}


		buildPattern.getPatternLinks().add(category);
		buildPattern.getPatternLinks().add(category2);
		
		String tester = doc.getElementsByTagName("problem-name")
						.item(0).getTextContent();
		if(tester.isEmpty()){
			System.out.println("NULL");
		}
		else{
			System.out.println();
		}
		
		/////////////////////////////////////////////
		System.out.println("Pattern BUILT!");

		System.out.println("Starting problem parser.....");


			String problemName, problemDescription;
			int problemCounter = 0;

			while (true) {

				System.out.println("Loop tick : " + problemCounter);

				problemName = doc.getElementsByTagName("problem-name")
						.item(problemCounter).getTextContent();
				problemDescription = doc
						.getElementsByTagName("probleem-description")
						.item(problemCounter).getTextContent();

				Problem p = new Problem(problemName, problemDescription);
				buildPattern.addProblem(p);

				try {
					doc.getElementsByTagName("problem-name")
							.item(problemCounter + 1).getTextContent();
				} catch (NullPointerException e) {
					break;
				}

				problemCounter++;

			}

		
		
		/////////////////////////////////////////////
		System.out.println("problems BUILT!");
		
		int solutionCounter = 0;
		String solutionName, solutionDescription;

		System.out.println("Init parameters");
		


			while (true) {
				
				try {
					doc.getElementsByTagName("solution-name")
							.item(solutionCounter).getTextContent();
				} catch (NullPointerException e) {
					break;
				}
				System.out.println(doc.getElementsByTagName("solution-name")
							.item(solutionCounter).getTextContent());
				System.out.println("Loop tick : " + solutionCounter);

				solutionName = doc.getElementsByTagName("solution-name")
						.item(solutionCounter).getTextContent();
				solutionDescription = doc
						.getElementsByTagName("solution-description")
						.item(solutionCounter).getTextContent();
				Solution sol = new Solution(solutionName, solutionDescription);
				buildPattern.addSolution(sol);
				;

				try {
					doc.getElementsByTagName("solution-name")
							.item(solutionCounter + 1).getTextContent();
				} catch (NullPointerException e) {
					break;
				}

				solutionCounter++;

			}
	

		/////////////////////////////////////////////
		System.out.println("solutions BUILT!");

			int consequenceCounter = 0;
			String consequenceName, consequenceDescription;

			while (true) {

				System.out.println("Loop tick : " + consequenceCounter);

				consequenceName = doc.getElementsByTagName("consequence-name")
						.item(consequenceCounter).getTextContent();
				consequenceDescription = doc
						.getElementsByTagName("consequence-description")
						.item(consequenceCounter).getTextContent();

				Consequence con = new Consequence(consequenceName,
						consequenceDescription);
				buildPattern.addConsequence(con);

				try {
					doc.getElementsByTagName("consequence-name")
							.item(consequenceCounter + 1).getTextContent();
				} catch (NullPointerException e) {
					break;
				}

				solutionCounter++;
			}

		
		/////////////////////////////////////////////
		System.out.println("consequences BUILT!");

			int participantCounter = 0;
			String participantName, participantDescription;

			while (true) {

				System.out.println("Loop tick : " + participantCounter);

				participantName = doc.getElementsByTagName("participant-name")
						.item(participantCounter).getTextContent();
				participantDescription = doc
						.getElementsByTagName("participant-description")
						.item(participantCounter).getTextContent();

				Participant p = new Participant(participantName,
						participantDescription);
				buildPattern.addParticipant(p);

				try {
					doc.getElementsByTagName("participant-name")
							.item(participantCounter + 1).getTextContent();
				} catch (NullPointerException e) {
					break;
				}

				participantCounter++;
			}

		
		/////////////////////////////////////////////
		System.out.println("participants built");

		scope.searchCategory(category).addPattern(buildPattern);
		purpose.searchCategory(category2).addPattern(buildPattern);

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
