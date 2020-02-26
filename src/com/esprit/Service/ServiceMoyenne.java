/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Note;
import com.esprit.Entite.TableNote;
import com.esprit.IService.IServiceMoyenne;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amenallah Lounis
 */
public class ServiceMoyenne implements IServiceMoyenne {
    private Connection con;
    private Statement stm;

    public ServiceMoyenne() {
        con=DataBase.getInstance().getConnection();
    }

  @Override
    public void CalculeMoyenneMatiere(Note note) throws SQLException {
        
        try {
            PreparedStatement pst ;
            pst = con.prepareStatement( "UPDATE note SET note.moyenne = ? WHERE nom_matier=? and note_cc=? and note_ds=? and note_examun=? ;");
            pst.setFloat(1, note.getMoyenne());
            pst.setString(2, note.getId_matiere());
            pst.setFloat(3, note.getNote_cc());
            pst.setFloat(4, note.getNote_ds());
            pst.setFloat(5, note.getNote_examun());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
       
     
     
    }
    
    
     @Override
    public void CalculeMoyenneMatiere1() throws SQLException {

         String sql = "UPDATE note SET  note.moyenne=note.moyenne*0+note_cc*0+note_ds*0+note_examun*1 WHERE id_user=id_user ;";
 
PreparedStatement statement = con.prepareStatement(sql);

int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("Moyenne Matiére calculé!");
}
        
    }

    @Override
    public List<TableNote> afficherNoteEtudiant(int x)  {
        try {
       List<TableNote> arr2=new ArrayList<>();
        stm = con.createStatement();
         String sql="select note_cc, note_ds, note_examun, moyenne, net, note.nom_matier, coefficient, nom, prenom from note, matiere, user where note.nom_matier = matiere.nom_matier and note.cin = user.cin and note.cin='"+x+"'";
          ResultSet rs=stm.executeQuery(sql);
           while (rs.next()) {                
               float cc=rs.getFloat("note_cc");
               float ds=rs.getFloat("note_ds");
               float note_examun=rs.getFloat("note_examun");
               float moyenne =rs.getFloat("moyenne");
               float net =rs.getFloat("net");
               String matiere =rs.getString("nom_matier");
               int coef = rs.getInt("coefficient");
               String nom = rs.getString("nom");
               String prenom = rs.getString("prenom");
               int iduser = rs.getInt("cin");
               
               TableNote p=new TableNote(cc,ds,note_examun,moyenne,net,matiere,coef,nom,prenom,iduser);
               arr2.add(p);
     }
          
    return arr2;  
        }
        catch (Exception ex){
        System.out.println(ex);
        }
        return null ;
    }

   

   
   

   
    
    
}
