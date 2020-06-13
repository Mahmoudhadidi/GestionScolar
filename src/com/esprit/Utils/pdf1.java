/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Utils;
import com.esprit.Entite.Note;
import com.esprit.Entite.TableNote;
import com.esprit.Service.ServiceMoyenne;
import com.esprit.gui.Consultation_noteController;
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

public class pdf1 {
      
        //webcam.main(args);  
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
        //Image img = Image.getInstance("photo.png");
        //Image img2 = Image.getInstance("logo.png");
        Consultation_noteController us=new Consultation_noteController();
        List<Note> list=us.look(0);
        
  
        
        for(Note u:list)
        {
          
        document.add(new Paragraph("note.note_cc :"+u.getNote_cc()));
        document.add(new Paragraph("note.note_ds :"+u.getNote_ds()));
        document.add(new Paragraph(" note_examen:"+u.getNote_examun()));
        document.add(new Paragraph("moyenne :"+u.getMoyenne())); 
      //  document.add(new Paragraph("Matiere :"+u.getNom_matier()));
      
       
           //document.add(img);
         //document.add(img2);
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        //}//Notification.main(args);
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
       
    }
    }
}
