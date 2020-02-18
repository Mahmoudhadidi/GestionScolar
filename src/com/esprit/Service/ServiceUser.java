/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.User;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static sun.security.jgss.GSSUtil.login;
import com.esprit.Entite.Stagee;
import com.esprit.Entite.User;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

    



/**
 *
 * @author techouse
 */
public class ServiceUser implements IService<User>{
  
    private final Connection con;
    private Statement ste;
    ResultSet s ;
    public List<Stagee> readAllStage;

    public ServiceUser() {
        con = DataBase.getInstance().getConnection();

    }
    public boolean connexion(User u) throws SQLException{
        ste=con.createStatement();
    ResultSet resultat=ste.executeQuery("select * from user where login='"+u.getLogine()+"' and mdp='"+u.getMdp()+"'");
          while(resultat.next()) 
          { 
             return true;
          }
   
    return false;
    }
    
    @Override
    public void ajouter(User s) throws SQLException {
         ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "INSERT INTO user (`login`, `mdp`, `role`,`nom`,`prenom`,`email`,`date_naissance`,`adresse`,`cin`,`niveau`) VALUES ('" + s.getLogine()+ "', '" + s.getMdp()+ "', '" + s.getRole()+ "', '" + s.getNom()+ "','" + s.getPrenom()+ "', '" + s.getMail()+"', '"+ s.getDate_N()+ "', '" + s.getAdresse()+ "','" + s.getCin()+ "', '" + s.getNiveau()+ "');";
        ste.executeUpdate(requeteInsert);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }

    @Override
    public boolean delete(User t) throws SQLException {
        ste = con.createStatement();
        
        String requeteInsert;
        requeteInsert = "DELETE FROM `esprit`.`user` WHERE `id_user`='"+t.getId()+"'";
        ste.executeUpdate(requeteInsert);
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public boolean update(User c) throws SQLException {
        ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "UPDATE `esprit`.`user` SET `login`='"+c.getLogine()+"', `mdp`='"+c.getMdp()+"', `role`='"+c.getRole()+"', `id_classe`='"+c.getId_classe()+"',`nom`='"+c.getNom()+"', `prenom`='"+c.getPrenom()+"',`email`='"+c.getMail()+"',`date_naissance`='"+c.getDate_N()+"',`adresse`='"+c.getAdresse()+"',`cin`='"+c.getCin()+"',`niveau`='"+c.getNiveau()+"', WHERE `id_user`='"+c.getId()+"'";
        ste.executeUpdate(requeteInsert);
        
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> readAll() throws SQLException {
         
    List<User> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet s=ste.executeQuery("select * from user");
         while (s.next()) {
        
               
               String login=s.getString(2);
               String mdp=s.getString(3);
               String role=s.getString(4);
               int id_classe=s.getInt(5);
               String nom=s.getString(6);
               String prenom=s.getString(7);
               String email=s.getString(8);
               String date_naissance=s.getString(9);
               String adresse=s.getString(10);
               int cin=s.getInt(11);
               String niveau=s.getString(12);
               
               
               
               
               
               
               User f = new User(login, mdp, role, id_classe, nom, prenom, email ,date_naissance,adresse,cin,niveau );              
     arr.add(f);
     }
    return arr;
    }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
/*
    @Override
    public boolean update(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
   
}
