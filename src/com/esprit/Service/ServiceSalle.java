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

/**
 *
 * @author hadidi
 */
public class ServiceSalle  implements IService<Salle>{
      private Connection con;
    private Statement ste;

    public ServiceSalle() {
        con = DataBase.getInstance().getConnection();

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
    
}
