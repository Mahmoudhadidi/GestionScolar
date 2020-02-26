/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.User;
import com.esprit.Entite.absence_employe;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public  class ServiceAbsenceEmploye implements IService<absence_employe>{
     private final Connection con;
    private Statement ste;

    public ServiceAbsenceEmploye() {
        con = DataBase.getInstance().getConnection();

    }
    
    
     
     @Override
     public void ajouter(absence_employe t) throws SQLException {
         try{
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`absence_employe` (`id_absence_e`, `type_absence`, `id_employe`, `date`) VALUES (NULL, '" + t.getType_absence() + "', '" + t.getId_employe() + "', '" + t.getDate() + "');";
        ste.executeUpdate(requeteInsert);}
         catch(SQLException e) {
             System.err.println("problem in creating ...");
        }
    }

    
     
    public boolean delete(int id) throws SQLException {
        boolean b = false;
        
        try
        {
            PreparedStatement pst ;
            pst=con.prepareStatement("delete from `esprit`.`absence_employe` where id_employe = ? ");
            
            pst.setInt(1, id);
            pst.executeUpdate();
            
        } catch (SQLException e){
            System.out.println(e);}
        return b;
    }

    /**
     *
     * @param t
     * @return 
     * @throws SQLException
     */
     @Override
    public boolean update(absence_employe t) throws SQLException{
        try{
      ste = con.createStatement();
         String requeteUpdate ="update `esprit`.`absence_employe` set type_absence='"+t.getType_absence()+"' where id_employe="+t.getId_employe()+"";
        
        ste.executeUpdate(requeteUpdate);
        System.out.println("User upated ");}
        catch(SQLException e) {
             System.err.println("problem in updating ...");
        }
         return false;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
     @Override
    public List<absence_employe> readAll() throws SQLException {
         List<absence_employe> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from absence_employe");
     while (rs.next()) {                
               int id_absence_e=rs.getInt(1);
               String type_absence=rs.getString(2);
               int id_employe=rs.getInt(3);
               String date=rs.getString(4);
                
        absence_employe a = new absence_employe(id_absence_e, type_absence, id_employe, date);
     arr.add(a);
     }
    return arr;
    }

    /**
     *
     * @param id_employe
     * @return
     * @throws java.sql.SQLException
     */
    public absence_employe find(int id_employe) throws SQLException {
   absence_employe absenceemp = new absence_employe();      
      
    try{
        ste=con.createStatement(); 
        String requeteFind = "SELECT * FROM  'esprit'. 'absence_employe' WHERE id_employe = " + id_employe;
       ResultSet rs=ste.executeQuery(requeteFind);
      
      if(rs.first()) {
      
               String type_absence = rs.getString(2);
       
               int id_absence_e=rs.getInt(1);
               String date=rs.getString(4);
  
        absenceemp = new absence_employe(id_absence_e, type_absence, id_employe, date);
                 
                          } 
    }
    catch (SQLException e) {
    }
    return absenceemp;
  }
    public List<absence_employe> trier() throws SQLException {
        
         
             List<absence_employe> arr=new ArrayList<>();
        ste = con.createStatement();
         String sql="select * from absence_employe order by id_employe";
          ResultSet rs=ste.executeQuery(sql);
           while (rs.next()) {                
               int id_absence_e=rs.getInt(1);
               String type_absence=rs.getString(2);
               int id_employe=rs.getInt(3);
               String date= rs.getString(4);
               
               absence_employe p=new absence_employe(id_absence_e, type_absence, id_employe, date);
     arr.add(p);
     }
    return arr;        
    }

    
    /* public int salair(absence_employe t) throws SQLException {
        int s=0;
    try{
      ste = con.createStatement();
         String requeteUpdate ="update `esprit`.`user` set salair='"+t.getSalair()+"' where id_employe="+t.getId_employe()+"";
        
        ste.executeUpdate(requeteUpdate);
        System.out.println("salair upated ");}
        
    catch(SQLException e) {
             System.err.println("problem in updating ...");
        }
         return s;}*/


    public double salair(User u) throws SQLException {
             ste=con.createStatement() ;
             
             String requete=" SELECT * FROM `absence_employe` WHERE `id_employe`='"+u.getId()+"' ";
             ResultSet rs=ste.executeQuery(requete);
               int abs=0;
             while(rs.next()){
                 if (rs.getString(2).equals("noncertifie")) {
                     abs++;
                 }
               
             }
                          System.out.print (u.getSalair());

             double  x = u.getSalair()-((u.getSalair()/30)*abs);
             System.out.print(x);
             u.setSalair2(x);
                ste = con.createStatement();
         String requeteUpdate ="update `User` set salair2='"+u.getSalair2()+"' where id_user="+u.getId()+"";
        
        ste.executeUpdate(requeteUpdate);
        return u.getSalair2();
      
    }
    
    
    public List chercherEtat(String type_absence) {
         try {
             List<absence_employe> l1 = new ArrayList<>();
             ste=con.createStatement() ;
             
             String requete=" SELECT * FROM `absence_employe` WHERE `tupe_absence`='"+type_absence+"' ";
             ResultSet rs=ste.executeQuery(requete);
             
             while(rs.next()){
                 
                 int id_absence_e=rs.getInt(1);
                 int id_employe=rs.getInt(3);
                 String date= rs.getString(4);
               
               absence_employe p=new absence_employe(id_absence_e, type_absence, id_employe, date);
                 
                 l1.add(p);
             }
             
             return l1;
         } catch (SQLException ex) {
             System.out.println("### ERROR : "+ex.getCause());
        }
         return null;
         
    }
    
    public float stat()  throws SQLException{
          float s=0;
          float t=0;
         try {
             ste = con.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceAbsenceEmploye.class.getName()).log(Level.SEVERE, null, ex);
         }
           ResultSet rs1 = null;  
        try {
            rs1 = ste.executeQuery(" select count(*) from absence_employe" );
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
            rs = ste.executeQuery(" select count(*) from absence_employe  where type_absence=noncertifie " );
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

    @Override
    public boolean delete(absence_employe t) throws SQLException {
         return false;
    }

    
}



   
    

