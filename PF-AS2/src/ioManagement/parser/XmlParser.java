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
import userInterface.MainFrame;
import contextManagement.ContextClassification;

public class XmlParser {

	private Document doc;
	private MainFrame frameLink;

	public XmlParser(String path, MainFrame mf) throws SAXException,
			IOException, ParserConfigurationException {

		frameLink = mf;
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(fXmlFile);

	}

	public void generatePatterns(ContextClassification purpose,
			ContextClassification scope) throws Exception {

		System.out.println("Ik wordt gerunned");

		String classification, category, name, description, path;
		int counter = 0;

		while (true) {

			try {
				classification = doc.getElementsByTagName("classification")
						.item(counter).getTextContent();
			} catch (NullPointerException e) {
				break;
			}

			category = doc.getElementsByTagName("category").item(counter)
					.getTextContent();
			name = doc.getElementsByTagName("name").item(counter)
					.getTextContent();
			description = doc.getElementsByTagName("description").item(counter)
					.getTextContent();
			path = doc.getElementsByTagName("diagram-path").item(counter)
					.getTextContent();

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
