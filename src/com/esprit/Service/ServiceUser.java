/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.User;
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
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author hadidi
 */
public class ServiceUser implements IService<User>{
    private Connection con;
    private Statement ste,steer;
public static int id_user_conecte;
    public ServiceUser() {
        con = DataBase.getInstance().getConnection();
    }
    public boolean connexion(User u) throws SQLException{
        ste=con.createStatement();
    ResultSet resultat=ste.executeQuery("select * from user where login='"+u.getLogine()+"' and mdp='"+u.getMdp()+"'");
          while(resultat.next()) 
          { 
              id_user_conecte=resultat.getInt(1);
             return true;
          }
   
    return false;
    }
    public String typeuser(User u) throws SQLException{
        String type_conecte=null;
        ste=con.createStatement();
    ResultSet resultat=ste.executeQuery("select * from user where login='"+u.getLogine()+"' and mdp='"+u.getMdp()+"'");
          while(resultat.next()) 
          {  id_user_conecte=resultat.getInt(1);
              type_conecte=resultat.getString("role");
              id_user_conecte = resultat.getInt(1);
           
          }
    return   type_conecte;
    }//etudiant
    
     public List<User> readAll_connecte(int i) throws SQLException {
List<User> etu=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user where id_user='"+i+"' ");
     while (rs.next()) {                
               int id=rs.getInt(1);
              
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
              String mail=rs.getString("email");
              String niveau=rs.getString("niveau");
              User p=new User(id,nom,prenom,mail,niveau);
     etu.add(p);
     }
    return etu;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<User> readAll_etudiant() throws SQLException {
List<User> etu=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user where role='etudiant' && id_classe=0");
     while (rs.next()) {                
               int id=rs.getInt(1);
              
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
              String mail=rs.getString("email");
              String niveau=rs.getString("niveau");
              User p=new User(id,nom,prenom,mail,niveau);
     etu.add(p);
     }
    return etu;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public List<User> readAll() throws SQLException {
List<User> ens=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user where role='enseignant'");
     while (rs.next()) {                
               int id=rs.getInt(1);
              
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String mail=rs.getString("email");
              String niveau=rs.getString("niveau");
              User p=new User(id,nom,prenom,mail,niveau);
     ens.add(p);
     }
    return ens;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public List<User> readall() throws SQLException{
     List<User> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet res=ste.executeQuery("select * from user");
     while (res.next())
            {
               User    a=new User(res.getInt(1),res.getString("login"),res.getString("mdp"),res.getString("role"),res.getString("nom")+" "+res.getString("prenom"),res.getString("email"),res.getInt("cin"),res.getString("niveau"));
               
               arr.add(a);
             //  System.out.println(arr);
            }
    return arr; 
 }
    @Override
    public void ajouter(User t) throws SQLException {
 ste = con.createStatement();
        String requeteInsert = "INSERT INTO user ( `login`, `mdp`, `role`,`nom`, `prenom`, `email`, `date_naissance`,`adresse`, `cin`, `niveau`) VALUES ('" + t.getLogine() + "', '" + t.getMdp()+ "', '" + t.getRole() +"', '" + t.getNom() + "', '" + t.getPrenom() +"', '" + t.getMail() + "', '" + t.getDate_N()+ "', '" + t.getAdresse() +"', '" + t.getCin() + "', '" + t.getNiveau() + "');";
        ste.executeUpdate(requeteInsert);       
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }

    @Override
    public boolean delete(User t) throws SQLException {
 ste = con.createStatement();
        String requeteDelete = "DELETE FROM user WHERE id_user='" + t.getId()+ "';";
    int w=ste.executeUpdate(requeteDelete);
        if(w>0)
          return true; 
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return false;       
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   public boolean update(User c) throws SQLException {
        ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "UPDATE esprit.`user` SET login`='"+c.getLogine()+"',mdp`='"+c.getMdp()+"', role`='"+c.getRole()+"',id_classe`='"+c.getId_classe()+"',`nom`='"+c.getNom()+"', prenom`='"+c.getPrenom()+"',email`='"+c.getMail()+"',`date_naissance`='"+c.getDate_N()+"',`adresse`='"+c.getAdresse()+"',`cin`='"+c.getCin()+"',`niveau`='"+c.getNiveau()+"', WHERE `id_user`='"+c.getId()+"'";
        ste.executeUpdate(requeteInsert);
        
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ObservableList<User>  SearchEventsF(String n) throws SQLException  {         
      
        ObservableList<User>  arr = FXCollections.observableArrayList();     
        steer = con.createStatement();
        ResultSet res ;
        //System.out.println(n);
        res = steer.executeQuery(" select * from user where  (login like'%"+n+"%')||(mdp like'%"+n+"%')||(role like'%"+n+"%')||(nom like'%"+n+"%'||(email like'%"+n+"%')||(cin like'%"+n+"%')||(niveau like'%"+n+"%'))");
        // select* from events where (Nom like '%"+n+"%') or (etat like '%"+n+"%') or (date like '%"+n+"%') or (type like '%"+n+"%') or (id like '%"+n+"%') ");
//             res = ste.executeQuery(" select* from events where (Nom like '%"+n+"%') or (etat like '%"+n+"%') or (date like '%"+n+"%') or (type like '%"+n+"%') or (id like '%"+n+"%') ");
            while (res.next())
            {
               User    a=new User(res.getInt(1),res.getString("login"),res.getString("mdp"),res.getString("role"),res.getString("nom")+" "+res.getString("prenom"),res.getString("email"),res.getInt("cin"),res.getString("niveau"));
               
               arr.add(a);
             //  System.out.println(arr);
            }
        
        return arr;
    }
    
}
