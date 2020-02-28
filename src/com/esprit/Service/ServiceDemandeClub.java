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
    ResultSet rs=ste.executeQuery("select * from demande_club order by id DESC");
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
     
    public List<DemandeClub> ChercherDemandeClub(String non) throws SQLException {
    List<DemandeClub> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT * FROM demande_club WHERE nom_club LIKE '%"+non+"%' order by id DESC");
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

   public List<String> readEtudiantInfo(int id_etud) throws SQLException {
        
    List<String> listeE=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT `nom`, `prenom`,`email`,`niveau`,`num_classe` FROM `user`,`demande_club`,`classe` WHERE demande_club.id_etudiant=user.id_user and user.id_classe=classe.id_classe and demande_club.id_etudiant='"+id_etud+"'");
    
while (rs.next()) {    
               
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String email=rs.getString("email");
               String niveau =rs.getString("niveau");
               String nomclasse =rs.getString("num_classe");
    listeE.add(nom);
    listeE.add(prenom);
    listeE.add(email);
    listeE.add(niveau);
    listeE.add(nomclasse);
    
    }
        return listeE;
    }
   
    public int DemandeNoValid() throws SQLException {
    String no_valid = "no valid";
    int nb=0;
    ste=con.createStatement();
    ResultSet rs = ste.executeQuery("SELECT COUNT(*) FROM demande_club WHERE `etat`='"+no_valid+"'");
    while (rs.next()) {    
               
        
        nb = (int)rs.getInt(1);
        
    }
        return nb;
    }
    
    public int DemandeValid() throws SQLException {
    String valid = "valid";
    int nb=0;
    ste=con.createStatement();
    ResultSet rs = ste.executeQuery("SELECT COUNT(*) FROM demande_club WHERE `etat`='"+valid+"'");
    while (rs.next()) {    
               
        
        nb = (int)rs.getInt(1);
        
    }
        return nb;
    }

    
    public Boolean verifId(int id_e) throws SQLException {
        
    int i =0;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT `id_etudiant` FROM `demande_club` WHERE `id_etudiant` = '"+id_e+"'");
    
    while (rs.next()) {    
               
               int id=rs.getInt("id_etudiant");
               i = id;  
    }
        return i == id_e;
    }
    
    public Boolean verifIdEnClub(int id_user) throws SQLException {
        
    int i =0;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT `id_etudiant` FROM `club` WHERE `id_etudiant` = '"+id_user+"'");
    
    while (rs.next()) {    
               
               int id=rs.getInt("id_etudiant");
               i = id;  
    }
        return i == id_user;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
