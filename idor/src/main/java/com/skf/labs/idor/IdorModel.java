package com.skf.labs.idor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import java.util.UUID;

public class IdorModel {

   public static String createPdf(String message){
    try{
       String pdfUuid = UUID.randomUUID().toString();
       Document document = new Document();
       PdfWriter.getInstance(document, new FileOutputStream(pdfUuid+".pdf"));
       document.open();
       Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
       Chunk chunk = new Chunk(message, font);
       document.add(chunk);
       document.close();
       return pdfUuid;
    }catch(FileNotFoundException e){
        e.printStackTrace();
    }catch(DocumentException e){
        e.printStackTrace();
    }
    return "";
   }  
}
