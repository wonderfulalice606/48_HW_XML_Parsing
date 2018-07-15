package core;

import java.io.File;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOM_Parser_WS {
	public static void main(String[] args) throws Throwable, Exception, ParserConfigurationException {


		File xml = new File("./WS.xml");

		String rootNode = "Servers";

		String node = "Server";

		// Get the DOM Builder Factory
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder b = f.newDocumentBuilder();

		// Load and Parse the XML document contains the complete XML as a Tree.
		Document doc = b.parse(xml);

		// Optional
		doc.getDocumentElement().normalize();

		NodeList serversNode = doc.getElementsByTagName(rootNode);
		System.out.println("Amount of Root Server: " + serversNode.getLength());

		// Checking by Servers Node
		for (int i = 0; i < serversNode.getLength(); i++) {

			NodeList serverNode = doc.getElementsByTagName(node);

			System.out.println("Amount of Servers: " + serverNode.getLength());

			// Checking by Server Node
			for (int j = 0; j < serverNode.getLength(); j++) {
				if (serverNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) serverNode.item(j);

					System.out.println("Server's ID: " + e.getAttribute("Id") + "; " + "Name: " + e.getAttribute("Name")
							+ "; " + "Status: " + e.getAttribute("Status") + "; " + "Type: " + e.getAttribute("Type"));

				}
			}
		}
	}
}