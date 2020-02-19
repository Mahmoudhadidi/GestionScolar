/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.DemandeClub;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ServiceDemandeClub {
    
    private final Connection con;
    private Statement ste;
    
    public ServiceDemandeClub() {
    con = DataBase.getInstance().getConnection();
    }

    public ServiceDemandeClub(int i, int session, String nom_club, String domaine_c, String description_d, String no_valid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //Gestion de Demande********************************************************
    
    public void ajouterDemande(DemandeClub d) throws SQLException {
        ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "INSERT INTO `esprit`.`demande_club` (`id`, `id_etudiant`, `nom_club`, `domaine`,`description`,`etat`) VALUES (NULL, '" + d.getId_etudiant()+ "', '" + d.getNom_club()+ "', '" + d.getDomaine()+ "', '" + d.getDescription()+ "', '" + d.getEtat()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    
     public List<DemandeClub> readAllDemande() throws SQLException {
    List<DemandeClub> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from demande_club");
     while (rs.next()) {    
               int id=rs.getInt("id");
               int id_etudiant=rs.getInt("id_etudiant");
               String nom_club=rs.getString("nom_club");
               String domaine=rs.getString("domaine");
               String description=rs.getString("description");
               String etat =rs.getString("etat");
               //String date = rs.getString("date");
               DemandeClub d = new DemandeClub (id, id_etudiant, nom_club, domaine, description, etat);              
     arr.add(d);
     }
    return arr;
    }
     
     public boolean deleteDemande(int id) throws SQLException {
        ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "DELETE FROM `esprit`.`demande_club` WHERE `id`='"+id+"'";
        ste.executeUpdate(requeteInsert);
        return true;
    }

    public void ajouterDemande(ServiceDemandeClub d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
