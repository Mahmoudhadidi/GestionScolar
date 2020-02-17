/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;


import com.esprit.Entite.Questions;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC-HP
 */
public class ServiceQuestions  implements IService<Questions>{
    private final Connection con;
    private Statement ste;

    public ServiceQuestions() {
        con = DataBase.getInstance().getConnection();}


    @Override
    public void ajouter(Questions t)  {
        try {
            ste = con.createStatement();
            String requeteInsert = "INSERT INTO questions ( `id_user`,`question`,`date`) VALUES ( '" + t.getId_user() + "','" + t.getQuestion()+ "','" + t.getDate()+ "');";
            ste.executeUpdate(requeteInsert);
        } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
        
    }

    @Override
    public boolean delete(Questions t) {
        try{
            ste=con.createStatement();
            String requestDelete= "delete from `esprit`.`questions` WHERE `id_ques`='"+t.getId_ques()+"'";
            System.out.println(requestDelete);
            ste.execute(requestDelete);
            System.out.println("question supprimé");
            return true ;
        }
        catch(SQLException ex){
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
            return false ;
        }  
    }
    @Override
    public boolean update(Questions t) {
        try {
            ste=con.createStatement();
            String requestUpdate="update `esprit`.`questions` set `question`='"+t.getQuestion()+"',`id_user`='"+t.getId_user()+"',`date`='"+t.getDate()+"' WHERE `id_ques`='"+t.getId_ques()+"'";
            ste.executeUpdate(requestUpdate);
            System.out.println("question updated");
        } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
        return false;
    }

    @Override
    public List<Questions> readAll()  {
        try {
            List<Questions> arr=new ArrayList<>();
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from questions");
            while (rs.next()) {
                int id_ques=rs.getInt(1);
                int id_user=rs.getInt(2);
                String question=rs.getString("question");
                String date=rs.getString("date");
                
                Questions p=new Questions(id_ques,id_user,question,date);
                arr.add(p);
            }
            return arr;
        } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();   
            return null ; 
        }
    }
       
    

    
        
    
}
