package core;

import java.io.IOException;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SAX_Parser {
        public static void main(String[] args) throws IOException, SAXException, 
        ParserConfigurationException {
		
		String url = "http://alex.academy/ebay.xml";

		final String element_01 = "orig-kw";
		final String element_02 = "engine";
		final String element_03 = "kadu-version";
		final String element_04 = "response-time";
		final String element_05 = "deals";
		final String attribute_01 = "count";

		// Create a "parser factory" for creating SAX parsers
		SAXParserFactory f = SAXParserFactory.newInstance();

		// Now use the parser factory to create a SAXParser object
		SAXParser p = f.newSAXParser();

		// Create an instance of this class; it defines all the handler methods
		DefaultHandler h = new DefaultHandler() {

			boolean handler_01 = false;
			boolean handler_02 = false;
			boolean handler_03 = false;
			boolean handler_04 = false;
			boolean handler_05 = false;
			String attribute_count = null;

			// a - uri; b - localName; c - qName; d - attributes
			public void startElement(String a, String b, String c, Attributes d) throws SAXException {

				if (c.equalsIgnoreCase(element_01)) {handler_01 = true;}
				if (c.equalsIgnoreCase(element_02)) {handler_02 = true;}
				if (c.equalsIgnoreCase(element_03)) {handler_03 = true;}
				if (c.equalsIgnoreCase(element_04)) {handler_04 = true;}
				if (c.equalsIgnoreCase(element_05)) {handler_05 = true; attribute_count = d.getValue(attribute_01);}
			}

			public void endElement(String a, String b, String c) throws SAXException {}

			public void characters(char ch[], int start, int length) throws SAXException {
				if (handler_01) {System.out.println("Key Word: \t " + new String(ch, start, length)); handler_01 = false;}
				if (handler_02) {System.out.println("Engine: \t " + new String(ch, start, length)); handler_02 = false;}
				if (handler_03) {System.out.println("Version: \t " + new String(ch, start, length)); handler_03 = false;}
				if (handler_04) {System.out.println("Response time:\t " + new String(ch, start, length)); handler_04 = false;}
				if (handler_05) {System.out.println("Number of deals: " + attribute_count); handler_05 = false;}
			}
		};
		p.parse(url, h);
	}
}