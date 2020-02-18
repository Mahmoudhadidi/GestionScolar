/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;


import com.esprit.Entite.User;
import com.esprit.Entite.absence;
import com.esprit.Entite.absence_employe;
import com.esprit.Service.ServiceAbsence;
import com.esprit.Service.ServiceAbsenceEmploye;
import com.esprit.Utils.DataBase;
import com.esprit.Utils.Pdf;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import static java.sql.DriverManager.println;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class Test {
    
    public static void main(String[] args) throws SQLException, DocumentException, BadElementException, IOException, FileNotFoundException, InterruptedException {
           ServiceAbsenceEmploye ser = new ServiceAbsenceEmploye();
           User u = new User();
                      u.setId(3);
                u.setSalair(500);

         double salaire = ser.salair(u);
         System.out.print(salaire);
        
        
           
           
        
       
        
       
       
        
        
        
        
        
    }
}
    

