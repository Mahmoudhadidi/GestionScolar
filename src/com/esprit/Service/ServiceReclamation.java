package com.esprit.Service;

import com.esprit.Entite.Reclamation;
import com.esprit.Entite.User;
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
public  class ServiceReclamation implements IService<Reclamation> {
     private final Connection con;
    private Statement ste;
    private ResultSet rs;

    public ServiceReclamation() {
        con = DataBase.getInstance().getConnection();

    }

    /**
     *
     * @param t
     * @throws SQLException
     */
     @Override
    public void ajouter(Reclamation t)  {
         try {
             String etat = "no traiter";
             ste = con.createStatement();
             String requeteInsert = "INSERT INTO reclamation ( `id_reclamation`, `id_user`,`description`,`etat`,`sujet`,`date_env`,`date_rep`) VALUES (NULL , '" + t.getId_user() + "','" + t.getDescription()+ "','" +etat+ "','" + t.getSujet()+ "','" + t.getDate_env()+ "','" + t.getDate_rep()+ "');";
             ste.executeUpdate(requeteInsert);
         } catch (SQLException ex) {
             System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
             
         }
       
    

  
   @Override
    public boolean update(Reclamation r )  {
         try {
             ste = con.createStatement();
             String requeteInsert;
             requeteInsert = "UPDATE `esprit`.`reclamation` SET `description`='"+r.getDescription()+"', `etat`='"+r.getEtat()+"', `sujet`='"+r.getSujet()+"', `date_env`='"+r.getDate_env()+"', `date_rep`='"+r.getDate_rep()+"' WHERE `id_reclamation`='"+ r.getId_reclamation()+"'";
             ste.executeUpdate(requeteInsert);
         } catch (SQLException ex) {
             System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
         return false;
         }
   
    
   @Override
   public boolean delete(Reclamation r)  {
         try {
             ste = con.createStatement();
             String requeteInsert;
             requeteInsert = "DELETE FROM `esprit`.`reclamation` WHERE `id_reclamation`='"+r.getId_reclamation()+"'";
             ste.executeUpdate(requeteInsert);
             return true;
         } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
           return false;
    }

   @Override
    public List<Reclamation> readAll()  {
         try {
             List<Reclamation> arr=new ArrayList<>();
             ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select * from reclamation");
             while (rs.next()) {
                 int id_reclamation=rs.getInt(1);
                 int id_user=rs.getInt(2);
                 
                 String description=rs.getString("description");
                 String etat=rs.getString("etat");
                 String sujet=rs.getString("sujet");
                 String date_env=rs.getString("date_env");
                 String date_rep=rs.getString("date_rep");
                 
                 Reclamation p=new Reclamation(id_reclamation,id_user,description,etat,sujet,date_env,date_rep);
                 arr.add(p);
             }
             return arr;
         } catch (SQLException ex) {
             System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
         return null;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List chercherEtat(String etatRec) {
         try {
             List<Reclamation> l1 = new ArrayList<>();
             ste=con.createStatement() ;
             
             String requete=" SELECT * FROM `reclamation` WHERE `etat`='"+etatRec+"' ";
             ResultSet rs=ste.executeQuery(requete);
             
             while(rs.next()){
                 
                 int id_reclamation=rs.getInt(1);
                 int id_user=rs.getInt(2);
                 String description=rs.getString("description");
                 String etat=rs.getString("etat");
                 String sujet=rs.getString("sujet");
                 String date_env=rs.getString("date_env");
                 String date_rep=rs.getString("date_rep");
                 
                 Reclamation r = new Reclamation(rs.getInt(1),rs.getInt(2),rs.getString("description"),rs.getString("etat"),rs.getString("sujet"),rs.getString("date_env"),rs.getString("date_rep"));
                 l1.add(r);
             }
             
             return l1;
         } catch (SQLException ex) {
             System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
         return null;
         
    }
    public void ChangerStatusToTraite(Reclamation r) {
         try {
             String requete = "Update reclamation set etat='traite' where ID_RECLAMATION="+r.getId_reclamation() ;
             ste=con.createStatement() ; 
             ste.executeUpdate(requete);
         } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
    }

    /**
     *
     * @param r
     * @return
     */
    public void detaileutilisateur(Reclamation r) {
           try {
              String requete=" SELECT nom FROM `user` WHERE `id_user`='"+r.getId_user()+"' ";
             ste.executeUpdate(requete);
              } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
    }
    
    public void detailSujet (Reclamation r) {
           try {
              String requete=" SELECT Sujet FROM `reclamation` WHERE `id_user`='"+r.getId_user()+"' ";
             ste.executeUpdate(requete);
              } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }         
    }
     
    public void detailDescription (Reclamation r) {
           try {
              String requete=" SELECT description FROM `reclamation` WHERE `id_user`='"+r.getId_user()+"' ";
             ste.executeUpdate(requete);
              } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }
    }
}
    
    
    

