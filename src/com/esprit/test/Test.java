/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.Entite.Classe;
import com.esprit.Entite.Etudient;
import com.esprit.Entite.Matiere;
import com.esprit.Entite.Salle;
import com.esprit.Entite.Seance;
import com.esprit.Service.ServiceClasse;
import com.esprit.Service.ServiceEtudient;
import com.esprit.Service.ServiceMatiere;
import com.esprit.Service.ServiceSalle;
import com.esprit.Service.ServiceSeance;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class Test {
    
    public static void main(String[] args) {
        ServiceMatiere ser = new ServiceMatiere(); 
        ServiceSalle serS= new ServiceSalle();
        ServiceClasse serC= new ServiceClasse();
        ServiceSeance serSean= new ServiceSeance();
        ServiceEtudient seretudient= new ServiceEtudient();
        
        
        Matiere m1 = new Matiere("Java", 2, 2);
        Matiere m2 = new Matiere("SQL", 2, 2);
        Matiere M1 = new Matiere(1);
        Matiere M2 = new Matiere(4);
        Matiere mo1 = new Matiere(8,"JAVA", 5, 5);
        Matiere mo2 = new Matiere(5,"PlSql", 4, 4);
        Salle s=new Salle(1,"salle 1","B");
        Salle s1 = new Salle(1);
        Salle s2=new Salle(2,2,"salle3","C");
        Classe c=new Classe("3A13",39,"info");
        Classe c1 = new Classe(1);
        Classe c3 = new Classe(3);
        Classe c2=new Classe(3,"3A15",40,"informatique");
        Seance seance=new Seance(8,8, 8, 8, "3h", "9h", "13/02/2020");
        Seance seance1=new Seance(2,7,7, 7, 7, "3h", "15h", "18/01/2020");
        Seance seance2=new Seance(1);
        try {
//         
           // ajouter
            ser.ajouter(m1);
            ser.ajouter(m1);
            serS.ajouter(s);
            serC.ajouter(c);
            
            serSean.ajouter(seance);
            
           //delete 
           if( ser.delete(M2))
                System.out.println("Matier est bine supprime");
           else
               System.out.println("Matier n'existe pas pour supprime");
           
           
           if( serS.delete(s1))
                System.out.println("Salle est bine supprime");
           else
               System.out.println("Salle n'existe pas pour supprime");
           
           
           if( serC.delete(c1))
                System.out.println("Classe est bine supprime");
           else
               System.out.println("Classe n'existe pas pour supprime");
           
           if( serSean.delete(seance2))
                System.out.println("Classe est bine supprime");
           else
               System.out.println("Classe n'existe pas pour supprime");
           
           
           
           //update
           if( ser.update(mo1))
                System.out.println("Matier est bine modifier");
           else
               System.out.println("Matier n'existe pas pour modifier");
           
           
           if( serS.update(s2))
                System.out.println("Salle est bine modifier");
           else
               System.out.println("Salle n'existe pas pour modifier");
           
           if( serC.update(c2))
                System.out.println("Classe est bine modifier");
           else
               System.out.println("Classe n'existe pas pour modifier");
           
           if( serSean.update(seance1))
                System.out.println("Classe est bine modifier");
           else
               System.out.println("Classe n'existe pas pour modifier");
           
           
           //affectation etudiant
           if( serC.affecterEtudian(c3, 5))
                System.out.println("etudient afectee");
           else
               System.out.println("etudient pas afectee");
           if( serC.affecterEtudian(c3, 6))
               System.out.println("etudient afectee");
           else
               System.out.println("etudient pas afectee");
           if( serC.affecterEtudian(c3, 7))
              System.out.println("etudient afectee");
           else
               System.out.println("etudient pas afectee");
           
           
           
            List<Matiere> list = ser.readAll();
            System.out.println(list);
            
            List<Salle> listSalle = serS.readAll();
            System.out.println(listSalle);
            
            List<Classe> listClasse = serC.readAll();
            System.out.println(listClasse);
                    
            List<Seance> listSeance = serSean.readAll();
            System.out.println(listSeance); 
            
        
            Map<String, List<Etudient>> listeClase=seretudient.readclasse();
            listeClase.forEach((a,b)->System.out.println("classe "+a+" : "+b));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
