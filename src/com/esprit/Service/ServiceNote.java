package com.esprit.Service;


import com.esprit.Entite.Note;
import com.esprit.Entite.listeetudiants;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.esprit.IService.IServiceNote;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amenallah Lounis
 */
public class ServiceNote implements IServiceNote<Note> {
    
     private Connection con;
    private Statement ste;

    public ServiceNote() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Note p) throws SQLException {
        
        PreparedStatement pre=con.prepareStatement("INSERT INTO `note` ( `note_cc`, `note_ds`, `note_examun`, `moyenne`, `net`, `cin`, `nom_matier`) VALUES ( ?, ?, ?, ?, ?, ?, ?);");
    pre.setFloat(1, p.getNote_cc()); 
    pre.setFloat(2, p.getNote_ds());
    pre.setFloat(3, p.getNote_examun());
    pre.setFloat(4, p.getMoyenne());
    pre.setFloat(5, p.getNet());
    pre.setInt(6, p.getId_user());
    
    pre.setString(7, p.getId_matiere());
    
    pre.executeUpdate();
        System.out.println("Note ajoutée !!");
       
        pre.setFloat(1, p.getNote_cc()); 

    }
 

    @Override
    public boolean delete(int id) throws SQLException {

try{  
         ste = con.createStatement();
        String requesteDelete=" DELETE FROM note where id_note ='"+ id +"'" ;
        ste.executeUpdate(requesteDelete);
        System.out.println("Note supprimer");
      } catch(Exception ex){
          System.err.println("ex");
      
      }

        return true ;        
    }
    
    public int findidclassebyclasse(String classe) throws SQLException{
        ste = con.createStatement();
        ResultSet rs=ste.executeQuery(" SELECT id_classe FROM classe where num_classe ='"+ classe +"'") ;
        int idclasse=0;
         while (rs.next()) {                
               idclasse=rs.getInt(1);
         }
          return idclasse;
    
    
    }
    
    public void supprimer(int cin,String nom_matier) throws SQLException
    {
        try
        {
            PreparedStatement pst ;
            pst=con.prepareStatement("Delete from note where cin = ? and nom_matier=? ");
            
            pst.setInt(1, cin);
            pst.setString(2, nom_matier);
            pst.executeUpdate();
            
        } catch (SQLException e){
            System.out.println(e);}
    }
            

    @Override
    public boolean update(Note p) throws SQLException {
        
        String sql = "UPDATE note SET note_cc=?, note_ds=?, note_examun=?,nom_matier=?  WHERE id_note=?";
 
PreparedStatement statement = con.prepareStatement(sql);
statement.setFloat(1, p.getNote_cc());
statement.setFloat(2, p.getNote_ds());
statement.setFloat(3, p.getNote_examun());
statement.setFloat(4, p.getMoyenne());
statement.setFloat(5, p.getNet());
statement.setInt(6, p.getId_user());
statement.setString(7, p.getId_matiere());
statement.setInt(8, p.getId_note());
 
int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("Modification terminé!");
}
        return true;
    }
    
    public void Modifier(listeetudiants pan) {
        try {
            PreparedStatement pst;
            pst = con.prepareStatement("UPDATE note SET note_cc=?, note_ds=?, note_examun=?  WHERE cin=? and nom_matier=?");
            
            pst.setString(1, pan.getA());
            pst.setString(2, pan.getB());
            pst.setString(3, pan.getC());
            pst.setInt(4, pan.getD());
            pst.setString(5, pan.getE());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            
        }
                 System.out.println("Moyenne Matière calculé");

    }

    @Override
    public List readAll() throws SQLException {
List<Note> arr=new ArrayList<>();
    ste=con.createStatement();
   
    ResultSet rs=ste.executeQuery("select * from note");
     while (rs.next()) {                
               int id_note=rs.getInt(1);
               float note_cc=rs.getFloat("note_cc");
               float note_ds=rs.getFloat("note_ds");
               float note_examun=rs.getFloat(4);
               float moyenne =rs.getFloat("moyenne");
               float net=rs.getFloat("net");
               int id_user =rs.getInt("id_user");
               String id_matiere = rs.getString(8);
               Note p=new Note(id_note, note_cc, note_ds, note_examun, moyenne, net, id_user, id_matiere);
     arr.add(p);
     }
    return arr;        
    }

   

//    @Override
//    public List<Note> rechercheParNoteExamen(String nom_matiere)throws SQLException {
//        List<Note> arr=new ArrayList<>();
//    ste=con.createStatement();
//   
//    ResultSet rs=ste.executeQuery("select note_examun from note, matiere where note.id_matiere=matiere.id_matiere and matiere.nom_matier='"+nom_matiere+"' desc");
//     while (rs.next()) {                
//               int id_note=rs.getInt(1);
//               float note_ds=rs.getFloat("note_ds");
//               float note_examun=rs.getFloat(3);f
//               float moyenne =rs.getFloat("moyenne");
//               int id_user =rs.getInt("id_user");
//               int id_matiere = rs.getInt(6);
//               Note p=new Note(id_note, note_ds, note_examun, moyenne, id_user, id_matiere);
//     arr.add(p);
//     }
//    return arr;
//     }

            

    @Override
    public List<Note> trier() throws SQLException {
        
         
             List<Note> arr=new ArrayList<>();
        ste = con.createStatement();
         String sql="select * from note order by note_examun desc";
          ResultSet rs=ste.executeQuery(sql);
           while (rs.next()) {                
               int id_note=rs.getInt(1);
               int note_cc=rs.getInt(2);
               float note_ds=rs.getFloat("note_ds");
               float note_examun=rs.getFloat(4);
               float moyenne =rs.getFloat("moyenne");
               int net=rs.getInt(6);
               int id_user =rs.getInt("id_user");
               String id_matiere = rs.getString(7);
               Note p=new Note(id_note, note_cc, note_ds, note_examun, moyenne, net, id_user, id_matiere);
     arr.add(p);
     }
    return arr;        
    }
    public void  afficherListEtudiant() {
    
        
    }

    private String parseString(int cin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
