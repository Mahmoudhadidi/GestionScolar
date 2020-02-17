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

/**
 *
 * @author hadidi
 */
public class ServiceUser {
    private Connection con;
    private Statement ste,stee;

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
}
