package com.cgi.bank.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import org.apache.tika.exception.TikaException;
import org.apache.tika.extractor.EmbeddedDocumentExtractor;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class A {

	/*
	 * public static void setPdfConfig(ParseContext context) { PDFParserConfig
	 * pdfConfig = new PDFParserConfig();
	 * 
	 * pdfConfig.setExtractInlineImages(false);
	 * pdfConfig.setExtractUniqueInlineImagesOnly(false);
	 * pdfConfig.getSpacingTolerance(); pdfConfig.setEnableAutoSpace(true);
	 * 
	 * pdfConfig.setExtractAcroFormContent(true);
	 * 
	 * 
	 * context.set(PDFParserConfig.class, pdfConfig); }
	 */

	public static String parseDocument(String path) {
		String xhtmlContents = "";

		PDFParser parser = new PDFParser();
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		ParseContext context = new ParseContext();

		/*
		 * EmbeddedDocumentExtractor embeddedDocumentExtractor = new
		 * EmbeddedDocumentExtractor() {
		 * 
		 * @Override public boolean shouldParseEmbedded(Metadata metadata) {
		 * 
		 * return true; }
		 * 
		 * @Override public void parseEmbedded(InputStream stream, ContentHandler
		 * handler, Metadata metadata, boolean outputHtml) throws SAXException,
		 * IOException {
		 * 
		 * } };
		 * 
		 * 
		 * 
		 * context.set(EmbeddedDocumentExtractor.class, embeddedDocumentExtractor);
		 */
		// context.set(PDFParser.class, parser);
		/*
		 * PDFParserConfig pdfConfig = new PDFParserConfig();
		 * pdfConfig.setExtractAcroFormContent(false);
		 */
	//pdfConfig.setExtractActions(false);

		// setPdfConfig(context);

		try (InputStream stream = new FileInputStream(path)) {
			parser.parse(stream, handler, metadata, context);
			xhtmlContents = handler.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException | TikaException e) {
			e.printStackTrace();
		}

		return xhtmlContents;
	}

}
