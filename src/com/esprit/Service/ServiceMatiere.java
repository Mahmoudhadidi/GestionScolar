/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Matiere;
import com.esprit.IService.IService;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class ServiceMatiere implements IService<Matiere> {

    private Connection con;
    private Statement ste;

    public ServiceMatiere() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Matiere t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO matiere ( `nom_matier`, `coefficient`, `cdedit`) VALUES ('" + t.getNom() + "', '" + t.getCoefficient() + "', '" + t.getCredit() + "');";
        ste.executeUpdate(requeteInsert);
    }
    /*public void ajouter1(Matiere p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit1`.`personne` ( `nom`, `prenom`, `age`) VALUES ( ?, ?, ?);");
    pre.setString(1, p.getNom());
    pre.setString(2, p.getPrenom());
    pre.setInt(3, p.getAge());
    pre.executeUpdate();
    }*/
            

    @Override
    public boolean delete(Matiere t) throws SQLException {
        ste = con.createStatement();
        String requeteDelete = "DELETE FROM matiere WHERE id_matiere='" + t.getId()+ "';";
    int w=ste.executeUpdate(requeteDelete);
        if(w>0)
          return true; 
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return false;
    }

    @Override
    public boolean update(Matiere t) throws SQLException {
        ste = con.createStatement();//DELETE FROM Pays WHERE Population > 170000;
        String requeteUpdate = "update matiere set nom_matier='"+t.getNom()+"',coefficient='"+t.getCoefficient()+"',cdedit='"+t.getCredit()+"'where id_matiere='"+t.getId()+"'";
    int w=ste.executeUpdate(requeteUpdate);
        if(w>0)
          return true; 
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return false;
    }

    @Override
    public List<Matiere> readAll() throws SQLException {
    List<Matiere> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from matiere");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom_matier=rs.getString("nom_matier");
               int coefficient=rs.getInt(3);
               int cdedit=rs.getInt("cdedit");
              Matiere p=new Matiere(id, nom_matier, coefficient, cdedit);
     arr.add(p);
     }
    return arr;
    }
}
