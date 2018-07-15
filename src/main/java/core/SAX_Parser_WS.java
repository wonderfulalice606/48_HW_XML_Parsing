package core;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SAX_Parser_WS {
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

		File xml = new File("./WS.xml");
		
		// Create a "parser factory" for creating SAX parsers
		SAXParserFactory f = SAXParserFactory.newInstance();

		// Now use the parser factory to create a SAXParser object
		SAXParser sax_parser = f.newSAXParser();

		// Create an instance of this class; it defines all the handler methods
		DefaultHandler handler = new DefaultHandler() {

			boolean server = false;

			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {

				if (qName.equals("Server")) {
					server = true;
					
					System.out.println("Server's ID: " + attributes.getValue("Id") + "; " + "Name: "
							+ attributes.getValue("Name") + "; " + "Status: " + attributes.getValue("Status") + "; "
							+ "Type: " + attributes.getValue("Type"));
				}

			}

			public void endElement(String uri, String localName, String qName) throws SAXException {
			}

			public void characters(char ch[], int start, int length) throws SAXException {
				// if (server) {
				// String Id = new String(ch, start, length);
				// System.out.println("Id: " + Id);
				// server = false;
				// }

			}

		};

		sax_parser.parse(xml, handler);

	}
}
