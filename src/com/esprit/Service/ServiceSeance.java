/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Seance;
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
public class ServiceSeance implements IService<Seance> {
    
      private Connection con;
    private Statement ste;

    public ServiceSeance() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Seance t) throws SQLException {
             ste = con.createStatement();
        String requeteInsert = "INSERT INTO seance ( `id_ens`,`id_classe`,`id_matiere`,`id_salle`,`duree`,`heure`,`date`) VALUES ('" + 
                t.getId_Ens() + "', '" + t.getId_Classe()+ "', '" + t.getId_Matiere() + "', '" + t.getId_Salle() + "', '" + t.getDuree() + "', '" + t.getHeure() + "', '" + t.getDate() + "');";
        ste.executeUpdate(requeteInsert);

       
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance t) throws SQLException {
ste = con.createStatement();
        String requeteDelete = "DELETE FROM seance WHERE id_seance='" + t.getId_Seance()+ "';";
    int w=ste.executeUpdate(requeteDelete);
        if(w>0)
          return true; 
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return false;           
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance t) throws SQLException {
          ste = con.createStatement();//DELETE FROM Pays WHERE Population > 170000;
        String requeteUpdate = "update seance set id_ens='"+t.getId_Ens()+"',id_classe='"+t.getId_Classe()+"',id_matiere='"+t.getId_Matiere()+"',id_salle='"+t.getId_Salle()+"',duree='"+t.getDuree()+"',heure='"+t.getHeure()+"',date='"+t.getDate()+"'where id_seance='"+t.getId_Seance()+"'";
    int w=ste.executeUpdate(requeteUpdate);
        if(w>0)
          return true; 
    return false;        

        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Seance> readAll() throws SQLException {
        List<Seance> listeClasse=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from seance");
     while (rs.next()) {                
               int id=rs.getInt(1);
               int num=rs.getInt(2);
               int nom=rs.getInt(3);
               int bloc=rs.getInt(4);
               int b1=rs.getInt(5);
               String b2=rs.getString(6);
               String b3=rs.getString(7);
               String b4=rs.getString(8);
              Seance seance =new Seance(id, num, nom, bloc,b1,b2,b3,b4);
     listeClasse.add(seance);
     }
    return listeClasse;  
        
     
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
