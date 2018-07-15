package core;

import java.io.*;
import javax.xml.stream.*;

public class Stax_Parser_WS {

	public static void main(String[] args) throws XMLStreamException, IOException {

		File xml = new File("./WS.xml");

		final String node_Server = "Server";

		InputStream in = new FileInputStream(xml);

		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(in);
		int eventType = reader.getEventType();

		while (reader.hasNext()) {

			eventType = reader.next();

			if (eventType == XMLStreamReader.START_ELEMENT) {
				if (reader.getLocalName() == node_Server) {
					System.out.println("Server's Id: " + reader.getAttributeValue(0) + "; " + "Name: " + reader.getAttributeValue(1)
					+ "; " + "Status: " + reader.getAttributeValue(2) + "; " + "Type: " + reader.getAttributeValue(3));
				}

			}
		}
	}
}
