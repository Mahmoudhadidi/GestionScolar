/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.absence_employe;
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
 * @author LENOVO
 */
public class ServiceAbsenceEmploye implements IService<absence_employe>{
     private final Connection con;
    private Statement ste;

    public ServiceAbsenceEmploye() {
        con = DataBase.getInstance().getConnection();

    }
    
    
     @Override
     public void ajouter(absence_employe t) throws SQLException {
         try{
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`absence_employe` (`id_absence_e`, `type_absence`, `id_employe`, `date`) VALUES (NULL, '" + t.getType_absence() + "', '" + t.getId_employe() + "', '"+ t.getDate() + "');";
        ste.executeUpdate(requeteInsert);}
         catch(SQLException e) {
             System.err.println("problem in creating ...");
        }
    }

    @Override
    public boolean delete(absence_employe t) throws SQLException {
        boolean b = false;
        try{
        ste = con.createStatement();
        
        String requeteDelete = "delete from `esprit`.`absence_employe` where id_absence_e='" +t.getId_absence_e()+"'";
        System.out.println(requeteDelete);
        ste.executeUpdate(requeteDelete);
        System.out.println("User deleted ");
       b = true;}
        catch(SQLException e) {
             System.err.println("problem in deleting ...");
        }
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
        return true;
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
        absence_employe a = new absence_employe(id_absence_e, type_absence,id_employe,date);
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
               String date = rs.getString(4);
               
  
        absenceemp = new absence_employe(id_absence_e, type_absence, id_employe, date);
                 
    } }
    catch (SQLException e) {
    }
    return absenceemp;
  }
    public List<absence_employe> trier() throws SQLException {
        
         
             List<absence_employe> arr=new ArrayList<>();
        ste = con.createStatement();
         String sql="select * from absence order by id_etudiant";
          ResultSet rs=ste.executeQuery(sql);
           while (rs.next()) {                
               int id_absence_e=rs.getInt(1);
               String type_absence=rs.getString(2);
               int id_employe=rs.getInt(3);
               String date=rs.getString(4);
               
               absence_employe p=new absence_employe(id_absence_e, type_absence, id_employe, date);
     arr.add(p);
     }
    return arr;        
    }

    
    /*public int salair(absence_employe t) throws SQLException {
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
    
   
}



   
    

