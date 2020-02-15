/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Etudient;
import com.esprit.Entite.Seance;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hadidi
 */
public class ServiceEtudient {
    
    private Connection con;
    private Statement ste,stee;

    public ServiceEtudient() {
        con = DataBase.getInstance().getConnection();

    }
    
    public Map<String, List<Etudient>> readclasse() throws SQLException{
        
         Map<String, List<Etudient>> listeClasse=new HashMap<>();
         
    ste=con.createStatement();
    ResultSet rsClasse=ste.executeQuery("select * from classe");
    while(rsClasse.next()){
        List<Etudient> listeEtudient=new ArrayList<>();
   int idC=rsClasse.getInt(1);
   String nomC=rsClasse.getString(2);
   stee=con.createStatement();
    ResultSet rs=stee.executeQuery("select * from user WHERE id_classe='"+idC+"'");
     while (rs.next()) {                
               
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String date=rs.getString("date_naissance");
               String adresse=rs.getString("adresse");
               int cin=rs.getInt("cin");
              Etudient etudiant =new Etudient(nom,prenom,date,cin,adresse);
     listeEtudient.add(etudiant);
     }
     listeClasse.put(nomC, listeEtudient);
    }
    return listeClasse; 
    }
}
