/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public class Pdf {

    private final Connection con;
        private Statement ste;
    public Pdf()  {
        
        con = DataBase.getInstance().getConnection();
          
    
}
    public void add(String file) throws FileNotFoundException, SQLException, DocumentException{
        
        /* Create Connection objects */
//                con = DataBase.getInstance().getConnection();
                Document my_pdf_report = new Document();
                    
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream(file));
                 ste=con.createStatement();
                  PdfPCell table_cell, table_cell_1,table_cell_2,table_cell_3;
                  PdfPTable my_report_table = new PdfPTable(3);
                  table_cell=new PdfPCell(new Phrase("nom"));
                  table_cell_1=new PdfPCell(new Phrase("prenom"));
                  table_cell_2=new PdfPCell(new Phrase("type_absence"));
                 // table_cell_3=new PdfPCell(new Phrase("id_seance"));
                  my_report_table.addCell(table_cell);
                  my_report_table.addCell(table_cell_1);
                  my_report_table.addCell(table_cell_2);
                //  my_report_table.addCell(table_cell_3);
                  ResultSet rs=ste.executeQuery("SELECT nom,prenom,absence.type_absence,absence.id_seance FROM user,seance,absence where absence.id_etudiant=user.id_user AND absence.id_seance=seance.id_seance");
                  my_pdf_report.open(); 

                        
                               
                                
               
                while (rs.next()) {  
                    
                              String orderState= rs.getString("nom");
                                table_cell=new PdfPCell(new Phrase(orderState));
                               my_report_table.addCell(table_cell);
                                           
                                String orderState1= rs.getString("prenom");
                                table_cell_1=new PdfPCell(new Phrase(orderState1));
                               my_report_table.addCell(table_cell_1);
                                
                               
                                String orderState2= rs.getString("type_absence");
                                table_cell_2=new PdfPCell(new Phrase(orderState2));
                               my_report_table.addCell(table_cell_2);
                               
                               /* my_report_table.addCell(""+table_cell_2);
                                String orderState2=rs.getString("type_absence");*/
                                
                               //  table_cell_3=new PdfPCell(new Phrase("id_seance"));
                                //my_report_table.addCell(table_cell_3).toString();
                                 //String orderState3= rs.getString("id_seance");
                                
                                 
                                
                                
                                
                                //my_report_table.addCell(""+orderState);
                                
                                
//                                table_cell=new PdfPCell(new Phrase(id));
//                                my_report_table.addCell(table_cell).toString();
                                
//                                
//                                
//                                float tt=rs.getFloat("total");
//                                table_cell=new PdfPCell(new Phrase(tt));
//                                my_report_table.addCell(table_cell);
//                                
//                                String orderState= rs.getString("orderState");
//                                table_cell=new PdfPCell(new Phrase(orderState));
//                                my_report_table.addCell(table_cell);
                }
                                
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);                       
                my_pdf_report.close();
                
               /* Close all DB related objects */
                 rs.close();
                ste.close();
                con.close();
        
    }
} 
    