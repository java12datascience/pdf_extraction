package com.cgi.bank.controller;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.ToXMLContentHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

@RestController
public class TikkaController {
	
	
    @GetMapping("/pdf")
	public String pdfExtract() throws IOException, SAXException, TikaException {
		BodyContentHandler bodyContentHandler =new BodyContentHandler(-1);
		//Parser parser = new AutoDetectParser();
		PDFParser parser = new PDFParser();
		ParseContext parseContext = new ParseContext();
		//ToXMLContentHandler xmlContentHandler =new ToXMLContentHandler();
		
		Metadata metadata = new Metadata();
		FileInputStream stream = new FileInputStream("C:\\Vipin\\Files\\input.pdf");
		
		parser.parse(stream, bodyContentHandler, metadata, parseContext);
		
		System.out.println("Document Content:" + bodyContentHandler.toString());  
        System.out.println("Document Metadata:");  
        String[] metadatas = metadata.names();   
        for(String data : metadatas) {  
            System.out.println(data + ":   " + metadata.get(data));    
        } 
        return  bodyContentHandler.toString();
	}
	

}
