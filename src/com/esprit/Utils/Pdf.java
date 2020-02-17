/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Utils;
import com.esprit.Entite.absence;
import com.esprit.IService.IService;
import com.esprit.Service.ServiceAbsence;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrator
 */

public class Pdf {
      
        //webcam.main(args);  
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
        //Image img = Image.getInstance("photo.png");
        //Image img2 = Image.getInstance("logo.png");
       ServiceAbsence us=new ServiceAbsence();
        List<absence> list=us.readAll();
        for(absence u:list)
        {
        document.add(new Paragraph("id_absence :"+u.getId_absence()));
        document.add(new Paragraph("id_etudiant:"+u.getId_etudiant()));
        document.add(new Paragraph("id_seance :"+u.getId_seance()));
        document.add(new Paragraph("type_absence :"+u.getType_absence()));
           //document.add(img);
         //document.add(img2);
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        }//Notification.main(args);
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }
}
