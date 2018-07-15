package core;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOM_XPath_Parser_WS {
	public static void main(String[] args) throws Throwable, Exception, ParserConfigurationException {

		File xml = new File("./WS.xml");

		String xpath = "//Servers/Server";

		// Get the DOM Builder Factory
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder b = f.newDocumentBuilder();

		// Load and Parse the XML document contains the complete XML as a Tree.
		Document doc = b.parse(xml);

		// Optional
		doc.getDocumentElement().normalize();

		// xPath
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xPath = xPathfactory.newXPath();

		NodeList serverNode = (NodeList) xPath.compile(xpath).evaluate(doc, XPathConstants.NODESET);

		System.out.println("Amount of Servers: " + serverNode.getLength());
		
		for (int i = 0; i < serverNode.getLength(); i++) {
			
			Element e = (Element) serverNode.item(i);
			
			System.out.println("Server's ID: " + e.getAttribute("Id") + "; " + "Name: "
					+ e.getAttribute("Name") + "; " + "Status: " + e.getAttribute("Status") + "; "
					+ "Type: " + e.getAttribute("Types"));
			

			}
		}
	}

