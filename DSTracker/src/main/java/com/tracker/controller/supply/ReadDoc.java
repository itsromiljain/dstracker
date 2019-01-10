//package com.tracker.controller.supply;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripperByArea;
//
//
//
//public class ReadDoc {
//	  public static void main(String[] args) throws IOException {
//
//	        try (PDDocument document = PDDocument.load(new File("/Users/10651848/Desktop/Test.pdf"))) {
//
//	            document.getClass();
//
//	            if (!document.isEncrypted()) {
//				
//	                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
//	                stripper.setSortByPosition(true);
//
//	                PDFTextStripper tStripper = new PDFTextStripper();
//
//	                String pdfFileInText = tStripper.getText(document);
//	                //System.out.println("Text:" + st);
//
//					// split by whitespace
//	                String lines[] = pdfFileInText.split("\\r?\\n");
//	               
//	                for (String line : lines) {
//	                   
//	                    if(line.contains("Java")) {
//	                    	 System.out.println(line);
//	                    }else {
//	                    	
//	                    }
//	                }
//
//	            }
//
//	        }
//
//	    }
//}
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List; 
//
//public class ScannerReadFile { 
//public static void main(String[] args) { 
//
//	
//String test = "Java+Spring Boot+MySQL";
//String[] s = test.split("\\+"); 
//System.out.println(Arrays.toString(s));
//
//
//File file = new File("/Users/10651848/Desktop/LT.doc"); 
//
//
////String[] s = {"Java", "SpringBoot", "MySQL"};
//for (String strTemp : s){
//
////System.out.println(strTemp);
//try {
//    BufferedReader reader= new BufferedReader(new FileReader(file)); 
//    String line=null;
//    while((line=reader.readLine()) != null ){
//        //System.out.println(line);
//       if( line.contains(strTemp)) {
//    	   System.out.println(strTemp);
//       }
//    }
//    }catch (Exception ex){
//    	
//    }
//}
//
//} 
//} 