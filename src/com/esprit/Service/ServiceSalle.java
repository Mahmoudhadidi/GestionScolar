/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Matiere;
import com.esprit.Entite.Salle;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hadidi
 */
public class ServiceSalle  implements IService<Salle>{
      private Connection con;
    private Statement ste,ster,steer;

    public ServiceSalle() {
        con = DataBase.getInstance().getConnection();

    }
    
     public ObservableList<Salle>  SearchEventsF(String n) throws SQLException  {         
      
        ObservableList<Salle>  arr = FXCollections.observableArrayList();     
        steer = con.createStatement();
        ResultSet rs ;
        //System.out.println(n);
        rs = steer.executeQuery(" select * from salle where  (id_salle like'%"+n+"%')||(num_salle like'%"+n+"%')||(nom_salle like'%"+n+"%')||(bloc like'%"+n+"%')");
        // select* from events where (Nom like '%"+n+"%') or (etat like '%"+n+"%') or (date like '%"+n+"%') or (type like '%"+n+"%') or (id like '%"+n+"%') ");
//             res = ste.executeQuery(" select* from events where (Nom like '%"+n+"%') or (etat like '%"+n+"%') or (date like '%"+n+"%') or (type like '%"+n+"%') or (id like '%"+n+"%') ");
            while (rs.next())
            {
             int id=rs.getInt(1);
               int num=rs.getInt(2);
               String nom=rs.getString(3);
               String bloc=rs.getString(4);
              Salle a=new Salle(id, num, nom, bloc);
     
               arr.add(a);
             //  System.out.println(arr);
            }
        
        return arr;
    }
    
    
    @Override
    public void ajouter(Salle t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO salle ( `num_salle`, `nom_salle`, `bloc`) VALUES ('" + t.getNumSalle() + "', '" + t.getNomSalle() + "', '" + t.getBloc() + "');";
        ste.executeUpdate(requeteInsert);

             

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Salle t) throws SQLException {
          ste = con.createStatement();
        String requeteDelete = "DELETE FROM salle WHERE id_salle='" + t.getIdSalle()+ "';";
    int w=ste.executeUpdate(requeteDelete);
        if(w>0)
          return true; 
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Salle t) throws SQLException {
       
        ste = con.createStatement();//DELETE FROM Pays WHERE Population > 170000;
        String requeteUpdate = "update salle set num_Salle='"+t.getNumSalle()+"',nom_salle='"+t.getNomSalle()+
                               "',bloc='"+t.getBloc()+"'where id_salle='"+t.getIdSalle()+"'";
    int w=ste.executeUpdate(requeteUpdate);
        if(w>0)
          return true; 
    return false;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Salle> readAll() throws SQLException {
List<Salle> salle=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from salle");
     while (rs.next()) {                
               int id=rs.getInt(1);
               int num=rs.getInt(2);
               String nom=rs.getString(3);
               String bloc=rs.getString(4);
              Salle p=new Salle(id, num, nom, bloc);
     salle.add(p);
     }
    return salle;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean verife(Salle c) throws SQLException{
    
    ster = con.createStatement();
        ResultSet res ;
        //System.out.println(n);
        res = ster.executeQuery(" select * from seance where  id_salle='"+c.getIdSalle()+"'");
         while (res.next()){
             return false;
         }
    return true;
}

    
}
