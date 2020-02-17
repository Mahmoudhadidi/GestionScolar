/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;



import com.esprit.Entite.Reponses;
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
 * @author PC-HP
 */
public class ServiceReponses implements IService<Reponses> {
     private final Connection con;
    private Statement ste;
    
     public ServiceReponses() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Reponses t) throws SQLException {
       ste = con.createStatement();
        String requeteInsert = "INSERT INTO reponses ( `id_rep`, `reponse`,`date`) VALUES ('" + t.getId_rep()+ "','" + t.getReponse()+ "','" + t.getDate()+ "');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(Reponses t) throws SQLException {
       boolean b=false; 
        try{
            ste=con.createStatement();
            String requestDelete= "delete from `esprit`.`reponses` WHERE `id_rep`='"+t.getId_rep()+"'";
            System.out.println(requestDelete);
            ste.execute(requestDelete);
            System.out.println("reponse supprimé");
            b=true;}
        catch(SQLException e){
            System.err.println("probleme");
        }
         return b;   
    
    }

    @Override
    public boolean update(Reponses t) throws SQLException {
       ste=con.createStatement(); 
       String requestUpdate="update `esprit`.`reponses` set `reponse`='"+t.getReponse()+"',`date`='"+t.getDate()+"' WHERE `id_rep`='"+t.getId_rep()+"'";
       ste.executeUpdate(requestUpdate);
       System.out.println("reponse updated");
         return false;
    }

    @Override
    public List<Reponses> readAll() throws SQLException {
        List<Reponses> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reponses");
     while (rs.next()) {                
               int id_rep=rs.getInt(1);
               String reponse=rs.getString("reponse");
               String date =rs.getString("date");
               
               Reponses  p=new Reponses(id_rep,reponse,date);
     arr.add(p);
     }
    return arr;
             
               
       
        
    }
    
}
