package com.tracker.supply.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

//
//import org.apache.poi.openxml4j.opc.OPCPackage;
//import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;



public class ReadDoc {
	
	public static void main(String[] args) throws  IOException {
		
//		String[] s = { "Java", "Spring", "MySQL", "Kafka", "Casandra" };
//		HashSet<String> set = new HashSet<String>();
//		for (String strTemp : s) {
//		 try {
//			   FileInputStream fis = new FileInputStream("/Users/10654437/Desktop/Java.docx");
//			   XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
//			   XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
//			   
//			   if(extractor.getText().contains(strTemp)) {
//				   set.add(strTemp);
//			   }
//			   
//			} catch(Exception ex) {
//			    ex.printStackTrace();
//			}
//		
//		}
//		 System.out.println(set);
//	 }
		//    public static void main(String[] args) throws IOException{

//		        PdfReader reader;
//
//		        try {
//
//		            reader = new PdfReader("/Users/10654437/Desktop/Java.pdf");
//
//		            // pageNumber = 1
//		            String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);
//
//		           // System.out.println(textFromPage);
//		            if(textFromPage.contains("Java")) {
//		                System.out.println("Contains Java");
//		            }
//
//		            reader.close();
//
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
		    	
		    	
//		    	try (PDDocument document = PDDocument.load(new File("/Users/10654437/Desktop/Java.pdf"))) {
//
//		            document.getClass();
//
//		            if (!document.isEncrypted()) {
//					
//		                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
//		                stripper.setSortByPosition(true);
//
//		                PDFTextStripper tStripper = new PDFTextStripper();
//
//		                String pdfFileInText = tStripper.getText(document);
//		                //System.out.println("Text:" + st);
//
//						// split by whitespace
//		                String lines[] = pdfFileInText.split("\\r?\\n");
//		                for (String line : lines) {
//		                	if(line.contains("Kavya")) {
//		                    System.out.println(line);
//		                }
//		                }
//
//		            }
//
//		        }
//
		    
		  //  }
} 
} 