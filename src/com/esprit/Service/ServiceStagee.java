/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Stagee;
import com.esprit.Entite.User;
//import com.Suptech.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 *
 * @author ADMIN
 */
public class ServiceStagee {
    
    private final Connection con;
    private Statement ste;
    ResultSet s ;
    public List<Stagee> readAllStage;

    public ServiceStagee() {
        con = DataBase.getInstance().getConnection();

    }
    
    
    public void ajouterStage(Stagee s) throws SQLException {
        ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "INSERT INTO `esprit`.`stage` (`id_stage`, `id_user`, `titre`, `description`,`type`,`DATEDEBUT_S`,`DATEFIN_S`,`capacite_max`,`niveau_stage`) VALUES (NULL, '" + s.getId_user()+ "', '" + s.getTitre()+ "', '" + s.getDescription()+ "', '" + s.getType()+ "', '" + s.getDATEDEBUT_S()+ "','" + s.getDATEFIN_S()+ "', '" + s.getCapacite_max()+ "', '" + s.getNiveau_stage()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    
    
    public List<Stagee> readAllStage() throws SQLException {
    List<Stagee> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet s=ste.executeQuery("select * from stage Where `capacite_max`>0");
         while (s.next()) {
        
               int id_stage=s.getInt("id_stage");
               int id_user=s.getInt("id_user");
               String titre=s.getString("titre");
               String description=s.getString("description");
               String type=s.getString("type");
               Date DATEDEBUT_S=s.getDate("DATEDEBUT_S");
               Date DATEFIN_S=s.getDate("DATEFIN_S");
               int capacite_max=s.getInt("capacite_max");
               String niveau_stage=s.getString("niveau_stage");
               
               
               
               Stagee f = new Stagee(id_stage, id_user, titre, description, type, DATEDEBUT_S, DATEFIN_S ,capacite_max,niveau_stage );              
     arr.add(f);
     }
    return arr;
    }
    
    public boolean updateStage(Stagee c , int id ) throws SQLException {
        ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "UPDATE `esprit`.`stage` SET `titre`='"+c.getTitre()+"', `description`='"+c.getDescription()+"', `type`='"+c.getType()+"', `DATEDEBUT_S`='"+c.getDATEDEBUT_S()+"',`DATEFIN_S`='"+c.getDATEFIN_S()+"', `capacite_max`='"+c.getCapacite_max()+"', `niveau_stage`='"+c.getNiveau_stage()+"' WHERE `id_stage`='"+id+"'";
        ste.executeUpdate(requeteInsert);
        return true;        
    }
    
   public boolean deleteStage(int id) throws SQLException {
        ste = con.createStatement();
        
        String requeteInsert;
        requeteInsert = "DELETE FROM `esprit`.`stage` WHERE `id_stage`='"+id+"'";
        ste.executeUpdate(requeteInsert);
        return true;
    }
   public ObservableList<Stagee> displayFiltreStagee(String type) throws SQLException{
        String requete="SELECT * FROM stage Where type = " +type+" ORDER BY `DATEDEBUT_E` DESC" ;
        ste=con.createStatement() ;
        s=ste.executeQuery(requete);
        ObservableList<Stagee> list =FXCollections.observableArrayList(); 
        while(s.next()){                   
        Stagee S = new Stagee(s.getInt(1),s.getInt(2), s.getString(3),s.getString(4),s.getString(5),s.getDate(6),s.getDate(7),s.getInt(8),s.getString(9));
        list.add(S) ;
        }
        System.out.println(list);
        return list ;
    }
    
      public List<Stagee> recherche(String titre) throws SQLException {
    List<Stagee> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from `stage` where titre LIKE '%"+titre +"%' ;");
     while (rs.next()) {                
                Stagee c=new Stagee();
               int id_stage=rs.getInt("id_stage");
               c.setId_user(rs.getInt("id_user"));
               c.setTitre(rs.getString("titre"));
               c.setDescription(rs.getString("description"));
               c.setType(rs.getString("type")); 
               c.setDATEDEBUT_S(rs.getDate("DATEDEBUT_S"));
               c.setDATEFIN_S(rs.getDate("DATEFIN_S"));
               c.setCapacite_max(rs.getInt("capacite_max"));
               c.setNiveau_stage(rs.getString("niveau_stage"));
               
               
     arr.add(c);
     }
    return arr;
    }

}
 
     


 
 