/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;
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
        String requeteInsert = "INSERT INTO `esprit`.`absence` (`id_absence`, `id_seance`, `id_etudiant`, `type_absence`) VALUES (NULL, '" + t.getId_seance() + "', '" + t.getId_etudiant() + "', '" + t.getType_absence() + "');";
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
        
        String requeteDelete = "delete from `esprit`.`absence` where id_absence='" +t.getId_absence()+"'";
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
         String requeteUpdate ="update `esprit`.`absence` set type_absence='"+t.getType_absence()+"' where id_absence="+t.getId_absence()+"";
        ste.executeUpdate(requeteUpdate);
        System.out.println("User upated ");}
         catch(SQLException e) {
             System.err.println("problem in deleting ...");
        }
        return true;
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
        absence a = new absence(id_absence, id_seance, id_etudiant, type_absence);
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
      
               String type_absence = rs.getString(3);
       
               int id_absence=rs.getInt(1);
                int id_seance=rs.getInt(1);
  
        absence= new absence(id_absence, id_seance,id_etudiant, type_absence);
                 
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
               
               absence p=new absence(id_absence, id_seance, id_etudiant, type_absence);
     arr.add(p);
     }
    return arr;        
    }

    public List<absence> afficherelimination() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
