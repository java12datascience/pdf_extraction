package com.cgi.bank.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLStreamException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Office;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class Test {
	public static void main(String[] args) throws XMLStreamException, SAXException, IOException, TikaException {
		//XFAExtractor fExtractor  = new XFAExtractor();
		BodyContentHandler bodyContentHandler =new BodyContentHandler(-1);
		PDFParser parser = new PDFParser();
		ParseContext parseContext = new ParseContext();
		//ToXMLContentHandler xmlContentHandler =new ToXMLContentHandler();
		Metadata metadata = new Metadata();
		//XHTMLContentHandler xmlContentHandler = new XHTMLContentHandler(bodyContentHandler, metadata);
		
		InputStream stream = new FileInputStream("C:\\Vipin\\Files\\pdf.pdf");
		parser.parse(stream, bodyContentHandler, metadata, parseContext);
		System.out.println("dddd:"+bodyContentHandler.toString());
		//fExtractor.extract(stream, xmlContentHandler, metadata, parseContext);
	}

}
