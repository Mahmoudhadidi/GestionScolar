/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Club;
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
public class ServiceClub {
    
    private final Connection con;
    private Statement ste;
    
    public ServiceClub() {
    con = DataBase.getInstance().getConnection();
    }
        
    //Gestion de Club********************************************************
    
    public void ajouterClub(Club c , int id_etud) throws SQLException {
        String valid = "valid";
        ste = con.createStatement();
        String requeteInsert;
        String requeteInsert2;
        requeteInsert = "INSERT INTO `esprit`.`club` (`id`, `id_etudiant`, `nom`, `photo_couverture`,`logo`,`slogan`,`grand_titre`, `description`, `mail`, `etat`) VALUES (NULL, '" + c.getId_etudiant()+ "', '" + c.getNom()+ "', '" + c.getPhoto_couverture()+ "', '" + c.getLogo()+ "', '" + c.getSlogan()+ "', '" + c.getGrand_titre()+ "', '" + c.getDescription()+ "', '" + c.getMail()+ "', '" + c.getEtat()+ "');";
        requeteInsert2 = "UPDATE `esprit`.`demande_club` SET `etat`='"+valid+"' WHERE `id_etudiant`='"+id_etud+"'";
        ste.executeUpdate(requeteInsert);
        ste.executeUpdate(requeteInsert2);
    }
    
     public List<Club> readAllClub() throws SQLException {
        String Etat = "public";
    List<Club> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from club WHERE `etat`= '"+Etat+"'");
     while (rs.next()) {    
               int id=rs.getInt("id");
               int id_etudiant=rs.getInt("id_etudiant");
               String nom=rs.getString("nom");
               String photo_couverture=rs.getString("photo_couverture");
               String logo=rs.getString("logo");
               String slogan =rs.getString("slogan");
               String grand_titre=rs.getString("grand_titre");
               String description =rs.getString("description");
               String mail=rs.getString("mail");
               String etat =rs.getString("etat");
               //String date = rs.getString("date");
               Club d = new Club (id, id_etudiant, nom, photo_couverture, logo, slogan,grand_titre,description,mail,etat);              
     arr.add(d);
     }
    return arr;
    }
     
      public boolean updateClub(Club c , int id ) throws SQLException {
        ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "UPDATE `esprit`.`club` SET `nom`='"+c.getNom()+"', `photo_couverture`='"+c.getPhoto_couverture()+"', `logo`='"+c.getLogo()+"', `slogan`='"+c.getSlogan()+"', `grand_titre`='"+c.getGrand_titre()+"', `description`='"+c.getDescription()+"', `mail`='"+c.getMail()+"', `etat`='"+c.getEtat()+"' WHERE `id`='"+id+"'";
        ste.executeUpdate(requeteInsert);
        return true;        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
