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
    public void ajouter(Reclamation t) throws SQLException  {
        
        PreparedStatement pre=con.prepareStatement("INSERT INTO reclamation (`id_user`,`description`,`etat`,`sujet`,`date_env`,`date_rep`,`sat`) VALUES ( ?, ?, ?, ?, ?, ?, ?);");
    pre.setInt(1, t.getId_user()); 
    pre.setString(2, t.getDescription());
    pre.setString(3, t.getEtat());
    pre.setString(4, t.getSujet());
    pre.setString(5, t.getDate_env());
    pre.setString(6, t.getDate_rep());
     pre.setBoolean(7, t.getSat());
    
   
    
//    pre.executeUpdate();
        System.out.println("Note ajoutée !!");
       
       
        
        
    }
//         try {
//             String etat = "no traiter";
//             ste = con.createStatement();
//             String requeteInsert = "INSERT INTO reclamation (`id_user`,`description`,`etat`,`sujet`,`date_env`,`date_rep`,`sat``) VALUES (NULL , '" + t.getId_user() + "','" + t.getDescription()+ "','" +etat+ "','" + t.getSujet()+ "','" + t.getDate_env()+ "','" + t.getDate_rep()+ "');";
//             ste.executeUpdate(requeteInsert);
//         } catch (SQLException ex) {
//             System.out.println("### ERROR : "+ex.getCause());
//            ex.printStackTrace();     
//        }
//             
//         }
       
    

  
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
    public List<Reclamation> readAll() throws SQLException  {
        
             List<Reclamation> arr=new ArrayList<>();
             ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select * from reclamation");
             while (rs.next()) {
                 int id_reclamation=rs.getInt("id_reclamation");
                 //String sujet, String description, String etat, String
                 //date_env, String date_rep, int id_user, boolean sat, String getId_user, boolean getSat)
                 String description=rs.getString("description");
                 String etat=rs.getString("etat");
                 String sujet=rs.getString("sujet");
                 
                 
                 Reclamation p=new Reclamation(description,sujet,id_reclamation);
                 arr.add(p);
             }
             return arr;
         
    }

    public List<Reclamation> readby_id_user(int id)  {
         try {
             List<Reclamation> arr=new ArrayList<>();
             ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select * from reclamation where id_user="+id);
             while (rs.next()) {
                 int id_reclamation=rs.getInt(1);
                 int id_user=rs.getInt(2);
                 //String sujet, String description, String etat, String
                 //date_env, String date_rep, int id_user, boolean sat, String getId_user, boolean getSat)
                 String description=rs.getString("description");
                 String etat=rs.getString("etat");
                 String sujet=rs.getString("sujet");
                 String date_env=rs.getString("date_env");
                 String date_rep=rs.getString("date_rep");
                 boolean sat =rs.getBoolean("sat");
                 
                 Reclamation p=new Reclamation(id_reclamation,id_user,description,etat,sujet,date_env,date_rep,sat);
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
    
    public List chercherEtat() {
         try {
             List<Reclamation> l1 = new ArrayList<>();
             ste=con.createStatement() ;
             
             String requete=" SELECT * FROM `reclamation` ";
             ResultSet rs=ste.executeQuery(requete);
             
             while(rs.next()){
                 
                 int id_reclamation=rs.getInt(1);
                 int id_user=rs.getInt(2);
                 String description=rs.getString("description");
                 String etat=rs.getString("etat");
                 String sujet=rs.getString("sujet");
                 String date_env=rs.getString("date_env");
                 String date_rep=rs.getString("date_rep");
                    boolean sat =rs.getBoolean("sat");
                 
                 Reclamation r = new Reclamation(rs.getInt(1),rs.getInt(2),rs.getString("description"),rs.getString("etat"),rs.getString("sujet"),rs.getString("date_env"),rs.getString("date_rep"),rs.getBoolean("sat"));
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
    public User detaileutilisateur(Reclamation r) {
         
        User user = new User ();
        try {
             String requete=" SELECT * FROM `user` WHERE `id_user`='"+r.getId_user()+"' ";
             System.out.println(requete);
            
                 ste = con.createStatement();
// MOUSH 9OLNA SELECT T7OT executeQuery !!!!
// o ste = con.createStatement(); chbik tansa feha mat7outish feha ??? 
// samahni hhhh LEEEE! :'( behy rakiz 3ala 9al feli badalethoum  bsh ta3ref tsala7 behy
             ResultSet rs =ste.executeQuery(requete);
                
             if(rs.last()){
                 String nom=rs.getString("nom");
                 String prenom=rs.getString("prenom");
                
         
                 user.setNom(nom);
                 user.setPrenom(prenom);
       
             }
              } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
            return null ; 
        }
        return user;
    }
    
    public String detailSujet (Reclamation r) {
        
           try {
              String requete=" SELECT Sujet FROM `reclamation` WHERE `id_user`='"+r.getId_user()+"' ";
                   ste = con.createStatement();

              ResultSet rs =ste.executeQuery(requete);
                
             if(rs.last()){
             String sujet = rs.getString("sujet");
             return sujet ;
             }
              } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }   
           return "Aucun sujet";
    }
    
    public String detailDecription (Reclamation r) {
        
           try {
              String requete=" SELECT description FROM `reclamation` WHERE `id_user`='"+r.getId_user()+"' ";
                   ste = con.createStatement();

              ResultSet rs =ste.executeQuery(requete);
                
             while(rs.next()){
             String description = rs.getString("description");
             return description ;
             }
              } catch (SQLException ex) {
            System.out.println("### ERROR : "+ex.getCause());
            ex.printStackTrace();     
        }   
           return "Aucune description";
    }
     
   
    
}
    
    
    

