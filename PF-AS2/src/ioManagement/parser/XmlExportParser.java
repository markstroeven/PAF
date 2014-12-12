package ioManagement.parser;

import ioManagement.strategy.ExportStrategy;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import patternManagement.Consequence;
import patternManagement.Participant;
import patternManagement.Pattern;
import patternManagement.Problem;
import patternManagement.Solution;
import contextManagement.ContextCategory;
import contextManagement.ContextClassification;

public class XmlExportParser implements ExportStrategy {

	@Override
	public void exportXml(ContextClassification scope,
			ContextClassification purpose) {

		int patternCounter = 0;

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("pattern");
			doc.appendChild(rootElement);

			for (ContextCategory cat : scope.getTheCategory()) {
				for (Pattern pat : cat.getThePattern()) {
					patternCounter++;
					// ////////////////////////// META DATA
					// /////////////////////////////////

					String first = pat.getPatternLinks().get(0);
					String second = pat.getPatternLinks().get(1);

					Element meta = doc.createElement("pattern-meta");
					rootElement.appendChild(meta);

					Element metaProblem = doc.createElement("meta-problem");
					metaProblem.appendChild(doc.createTextNode(pat
							.getTheProblem().size() + ""));
					meta.appendChild(metaProblem);

					Element metaSolution = doc.createElement("meta-solution");
					metaSolution.appendChild(doc.createTextNode(pat
							.getTheSolution().size() + ""));
					meta.appendChild(metaSolution);

					Element metaParticipant = doc
							.createElement("meta-participant");
					metaParticipant.appendChild(doc.createTextNode(pat
							.getTheParticipant().size() + ""));
					meta.appendChild(metaParticipant);

					Element metaConsequence = doc
							.createElement("meta-consequence");
					metaConsequence.appendChild(doc.createTextNode(pat
							.getTheConsequence().size() + ""));
					meta.appendChild(metaConsequence);

					// //////////////////////////REAL DATA//////////////////

					Element classification = doc
							.createElement("pattern-classification");
					classification.appendChild(doc.createTextNode("Scope"));
					rootElement.appendChild(classification);

					Element patternCategoryScope = doc
							.createElement("pattern-category-scope");
					patternCategoryScope.appendChild(doc.createTextNode(first));
					rootElement.appendChild(patternCategoryScope);

					Element category2 = doc
							.createElement("pattern-category-purpose");
					category2.appendChild(doc.createTextNode(second));
					rootElement.appendChild(category2);

					Element patternName = doc.createElement("pattern-name");
					patternName.appendChild(doc.createTextNode(pat.getName()));
					rootElement.appendChild(patternName);

					Element patternDescription = doc
							.createElement("pattern-description");
					patternDescription.appendChild(doc.createTextNode(pat
							.getDescription()));
					rootElement.appendChild(patternDescription);

					if (pat.getTheDiagram() != null) {
						if (!pat.getTheDiagram().hasValue()) {
							Element diagramPath = doc
									.createElement("diagram-path");
							diagramPath.appendChild(doc.createTextNode(""));
							rootElement.appendChild(diagramPath);
						} else {
							Element diagramPath = doc
									.createElement("diagram-path");
							diagramPath.appendChild(doc.createTextNode(pat
									.getTheDiagram().getFilePath()));
							rootElement.appendChild(diagramPath);
						}
					} else {
						Element diagramPath = doc.createElement("diagram-path");
						diagramPath.appendChild(doc.createTextNode(""));
						rootElement.appendChild(diagramPath);
					}

					for (Problem p : pat.getTheProblem()) {

						Element problem = doc.createElement("problem");
						rootElement.appendChild(problem);

						Element problemName = doc.createElement("problem-name");
						problemName
								.appendChild(doc.createTextNode(p.getName()));
						problem.appendChild(problemName);

						Element problemDescription = doc
								.createElement("probleem-description");
						problemDescription.appendChild(doc.createTextNode(p
								.getDescription()));
						problem.appendChild(problemDescription);

					}

					for (Solution s : pat.getTheSolution()) {

						Element solution = doc.createElement("solution");
						rootElement.appendChild(solution);

						Element solutionName = doc
								.createElement("solution-name");
						solutionName
								.appendChild(doc.createTextNode(s.getName()));
						solution.appendChild(solutionName);

						Element solutionDescription = doc
								.createElement("solution-description");
						solutionDescription.appendChild(doc.createTextNode(s
								.getDescription()));
						solution.appendChild(solutionDescription);

					}

					for (Consequence c : pat.getTheConsequence()) {

						Element consequence = doc.createElement("consequence");
						rootElement.appendChild(consequence);

						Element consequenceName = doc
								.createElement("consequence-name");
						consequenceName.appendChild(doc.createTextNode(c
								.getName()));
						consequence.appendChild(consequenceName);

						Element consequenceDescription = doc
								.createElement("consequence-description");
						consequenceDescription.appendChild(doc.createTextNode(c
								.getDescription()));
						consequence.appendChild(consequenceDescription);

					}

					for (Participant p : pat.getTheParticipant()) {

						Element participant = doc.createElement("participant");
						rootElement.appendChild(participant);

						Element participantName = doc
								.createElement("participant-name");
						participantName.appendChild(doc.createTextNode(p
								.getName()));
						participant.appendChild(participantName);

						Element participantDescription = doc
								.createElement("participant-description");
						participantDescription.appendChild(doc.createTextNode(p
								.getDescription()));
						participant.appendChild(participantDescription);

					}

				}

			}

			Element patternAmmount = doc.createElement("meta-pattern-ammount");
			patternAmmount.appendChild(doc.createTextNode(patternCounter + ""));
			rootElement.appendChild(patternAmmount);

			System.out.println("Exporting to file!");

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("output.xml"));

			StreamResult resultoutput = new StreamResult(System.out);

			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
