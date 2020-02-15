/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Classe;
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
import java.util.Map;

/**
 *
 * @author hadidi
 */
public class ServiceClasse implements IService<Classe> {
    
      private Connection con;
    private Statement ste;

    public ServiceClasse() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Classe t) throws SQLException {
      
     ste = con.createStatement();
        String requeteInsert = "INSERT INTO classe ( `num_classe`,`nbre_etudient`,`specialite`) VALUES ('" + t.getNum() + "', '" + t.getNbrEtudient()+ "', '" + t.getSpecialite() + "');";
        ste.executeUpdate(requeteInsert);
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Classe t) throws SQLException {
      ste = con.createStatement();
        String requeteDelete = "DELETE FROM classe WHERE id_classe='" + t.getId()+ "';";
    int w=ste.executeUpdate(requeteDelete);
        if(w>0)
          return true; 
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return false;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Classe t) throws SQLException {
        ste = con.createStatement();//DELETE FROM Pays WHERE Population > 170000;
        String requeteUpdate = "update classe set num_classe='"+t.getNum()+"',nbre_etudient='"+t.getNbrEtudient()+"',specialite='"+t.getSpecialite()+"'where id_classe='"+t.getId()+"'";
    int w=ste.executeUpdate(requeteUpdate);
        if(w>0)
          return true; 
    return false;        

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Classe> readAll() throws SQLException {
        List<Classe> listeClasse=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from classe");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String num=rs.getString(2);
               int nom=rs.getInt(3);
               String bloc=rs.getString(4);
              Classe classe =new Classe(id, num, nom, bloc);
     listeClasse.add(classe);
     }
    return listeClasse;  
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

   public boolean affecterEtudian(Classe t, int id) throws SQLException{
       
       ste = con.createStatement();//DELETE FROM Pays WHERE Population > 170000;
       String requeteUpdate = "update user set id_classe='"+t.getId()+"'where id_user='"+id+"'";
       int w=ste.executeUpdate(requeteUpdate);
        if(w>0)
          return true; 
    return false;
   }

    
}
