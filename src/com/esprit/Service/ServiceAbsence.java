/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;
import com.esprit.Entite.Seance;
import com.esprit.Entite.User;
import com.esprit.Entite.absence;
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
 * @author LENOVO
 */
public class ServiceAbsence implements IService<absence>{
    
    private final Connection con;
    private Statement ste;

    public ServiceAbsence() {
        con = DataBase.getInstance().getConnection();

    }
    
    
    @Override
    public void ajouter(absence t) throws SQLException {
        try{
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`absence` (`id_absence`, `id_seance`, `id_etudiant`, `type-absence`) VALUES (NULL, '" + t.getId_seance() + "', '" + t.getId_etudiant() + "', '" + t.getType_absence() + "');";
        ste.executeUpdate(requeteInsert);}
         catch(SQLException e) {
             System.err.println("problem in creating ...");
        }
    }
    
    
    
  
            

    @Override
    public boolean delete(absence t) throws SQLException {
        boolean b = false;
        try{
        ste = con.createStatement();
        
        String requeteDelete = "delete from `esprit`.`absence` where id_etudiant='" +t.getId_etudiant()+"'";
        System.out.println(requeteDelete);
        ste.executeUpdate(requeteDelete);
        System.out.println("User deleted ");
       b = true;}
        catch(SQLException e) {
             System.err.println("problem in deleting ...");
        }
        return b;
    }

    @Override
    public boolean update(absence t) throws SQLException {
        try{
        ste = con.createStatement();
         String requeteUpdate ="update `esprit`.`absence` set type-absence='"+t.getType_absence()+"' where id_absence="+t.getId_absence()+"";
        ste.executeUpdate(requeteUpdate);
        System.out.println("User upated ");}
         catch(SQLException e) {
             System.err.println("problem in deleting ...");
        }
        return false;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
     public List<absence> readAll() throws SQLException {
    List<absence> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from absence");
     while (rs.next()) {                
               int id_absence=rs.getInt(1);
               int id_seance=rs.getInt(2);
               int id_etudiant=rs.getInt(3);
               String type_absence=rs.getString(4);
                 User u = new User();
                 u.setId(u);
                 Seance s=new Seance();
                 s.setId_Seance(s);
        absence a = new absence(id_absence, s, u, type_absence);
     arr.add(a);
     }
    return arr;
    }

  

    public absence find(int id_etudiant) throws SQLException {
   absence absence = new absence();      
      
    try{
        ste=con.createStatement(); 
        String requeteFind = "SELECT * FROM  'esprit'. 'absence' WHERE id_etudiant = " + id_etudiant;
       ResultSet rs=ste.executeQuery(requeteFind);
      
      if(rs.first()) {
      
               String type_absence = rs.getString(4);
       
               int id_absence=rs.getInt(1);
                int id_seance=rs.getInt(2);
                User u = new User();
                 u.setId(u);
                 Seance s=new Seance();
                 s.setId_Seance(s); 
        absence= new absence(id_absence, s,u, type_absence);
                 
    } }
    catch (SQLException e) {
        System.err.println("system dosen't find ...");
    }
    return absence;}
    
    public List<absence> trier() throws SQLException {
        
         
             List<absence> arr=new ArrayList<>();
        ste = con.createStatement();
         String sql="select * from absence order by id_etudiant";
          ResultSet rs=ste.executeQuery(sql);
           while (rs.next()) {                
               int id_absence=rs.getInt(1);
               int id_seance=rs.getInt(2);
               int id_etudiant=rs.getInt(3);
               String type_absence=rs.getString(4);
               User u = new User();
                 u.setId(u);
                 Seance s=new Seance();
                 s.setId_Seance(s);
               absence p=new absence(id_absence, s, u, type_absence);
     arr.add(p);
     }
    return arr;        
    }

   
    public List<String> afficherelimination(User u,Seance s ) throws SQLException {
          List<String> l1 = new ArrayList<>();
             ste=con.createStatement() ;
             
             String requete=" SELECT * FROM `absence` WHERE `type-absence`='"+"noncertifie"+"'and  `id_seance`='"+s.getId_Seance()+"'and  `id_user`='"+u.getId()+"'";
             ResultSet rs=ste.executeQuery(requete);
             
             while(rs.next()){
                 l1.add(rs.getInt(3)+"est iliminé dans"+rs.getInt(2));
             }
             return l1;

    }
    
    public List chercherEtat(String type_absence) {
         try {
             List<absence> l1 = new ArrayList<>();
             ste=con.createStatement() ;
             
             String requete=" SELECT * FROM `absence` WHERE `type-absence`='"+type_absence+"' ";
             ResultSet rs=ste.executeQuery(requete);
             
             while(rs.next()){
                 
                 int id_absence_e=rs.getInt(1);
                 int id_etudiant=rs.getInt(2);
                 int id_senace=rs.getInt(3);
                 
                 User u = new User();
                 u.setId(u);
                 Seance s=new Seance();
                 s.setId_Seance(s);
               
               absence p=new absence(id_absence_e, u, s, type_absence);
                 
                 l1.add(p);
             }
             
             return l1;
         } 
           catch (SQLException e) {
        System.err.println("system dosen't find ...");
    }
         return null;
         
    }
    public float stat()  throws SQLException{
          float s=0;
          float t=0;
         try {
             ste = con.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceAbsence.class.getName()).log(Level.SEVERE, null, ex);
         }
           ResultSet rs1 = null;  
        try {
            rs1 = ste.executeQuery(" select count(*) from absence" );
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAbsenceEmploye.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
             while (rs1.next()) {

                 t = rs1.getInt(1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceAbsenceEmploye.class.getName()).log(Level.SEVERE, null, ex);
         }
             ResultSet rs = null;  
        try {
            rs = ste.executeQuery(" select count(*) from absence  where type-absence=non certifie " );
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAbsenceEmploye.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
             while (rs.next()) {
                 s = rs.getInt(1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceAbsenceEmploye.class.getName()).log(Level.SEVERE, null, ex);
         }
           float m=(float)((s/t)*100);
           return (m);
      }
    
}
