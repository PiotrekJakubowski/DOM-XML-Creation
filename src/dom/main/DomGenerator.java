package dom.main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomGenerator {

	public static final String xmlFilePath = "/Users/praca/Desktop/2 semestr/Java_XML/Laboratory/4lab/task1/xmlfile.xml";

	public static void main(String argv[]) {

		try {

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();

			Element root = document.createElement("ComputerEngineering");
			document.appendChild(root);

			Element course = document.createElement("Course");

			root.appendChild(course);

			Attr attr2 = document.createAttribute("Author");
			attr2.setValue("Write Your Name Here");
			course.setAttributeNode(attr2);
			
			Attr attr = document.createAttribute("Name");
			attr.setValue("Application programming - Java and XML technologies");
			course.setAttributeNode(attr);


			Element topic = document.createElement("Topics");
			topic.appendChild(document.createTextNode("XML"));
			course.appendChild(topic);

			Element topic2 = document.createElement("Topics");
			topic2.appendChild(document.createTextNode("XSD"));
			course.appendChild(topic2);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));


			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}