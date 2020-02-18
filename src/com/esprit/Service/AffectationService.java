/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

//import com.Suptech.Entite.Stagee;
import com.esprit.Entite.Affectation;
import com.esprit.Entite.Etudient;
import com.esprit.Entite.Stagee;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author techouse
 */
public class AffectationService implements IService<Affectation> {
      private final Connection con;
    private Statement ste,stem,steS,steM;
      public AffectationService() {
        con = DataBase.getInstance().getConnection();
    }
      
       public void Postuler(Affectation c) throws SQLException {
        
        ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "INSERT INTO `esprit`.`affectation` (`id`, `id_stage`, `id_user`, `postuler`) VALUES (NULL, '" + c.getId_stage()+ "', '" + c.getId_user()+ "', '" + c.getPostuler()+ "');";
        ste.executeUpdate(requeteInsert);
    }
     public boolean affecterStageur(int id_user , int id_stage ) throws SQLException {
         String v = "valid";
        ste = con.createStatement();
        String requeteInsert , requeteInsert2;
        requeteInsert = "UPDATE `esprit`.`affectation` SET `postuler`='"+v+"' WHERE `id_user`='"+id_user+"'";
        requeteInsert2 = "UPDATE `esprit`.`stage` SET `nombre`= `nombre`-1  WHERE `id_user`='"+id_stage+"'";
        
        ste.executeUpdate(requeteInsert);
        ste.executeUpdate(requeteInsert2);
        return true;        
    }
        
     

    @Override
    public void ajouter(Affectation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Affectation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Affectation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public List<Affectation> readAll() throws SQLException {
         List<Affectation> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from affectation ");
     while (rs.next()) {    
             //  int id=rs.getInt("id");
               //int id_stage=rs.getInt("id_stage");
               int id_etudiant=rs.getInt("id_user");
               
               String postuler=rs.getString("postuler");
               
               
               
               Affectation c = new Affectation( id_etudiant, postuler );              
             arr.add(c);
     }
    return arr;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
  public Map<String, List<Etudient>> afficherAffectation() throws SQLException{
        
         Map<String, List<Etudient>> listeAffectation=new HashMap<>();
         
    ste=con.createStatement();
    steS=con.createStatement();
    steM=con.createStatement();
  /*  ResultSet rsClasse=ste.executeQuery("SELECT affectation.id_user, nom, prenom, affectation.id_stage, stage.titre,"
            + " type FROM affectation, stage, user where affectation.id_user=user.id_user and affectation.id_user='6'");*/
   ResultSet rsStage=ste.executeQuery("SELECT * FROM affectation");
    while(rsStage.next()){
        List<Etudient> listeEtudient=new ArrayList<>();  
   int id_stage=rsStage.getInt(2);
   String postile=rsStage.getString(4);
   ResultSet rsAfectation=steS.executeQuery("SELECT * FROM affectation  WHERE id_stage='"+id_stage+"'and postuler='valid'");
   ResultSet rsTitreStage=steM.executeQuery("SELECT * FROM stage  WHERE id_stage='"+id_stage+"'");
  
   while (rsAfectation.next()) {  
   int id_user=rsAfectation.getInt(3);
   
   stem=con.createStatement();
    ResultSet rs=stem.executeQuery("select * from user WHERE id_user='"+id_user+"'");
         while (rs.next()) {           
               
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String date=rs.getString("date_naissance");
               String adresse=rs.getString("adresse");
               int cin=rs.getInt("cin");
              Etudient etudiant =new Etudient(nom,prenom,date,cin,adresse);
     listeEtudient.add(etudiant);
         }
     }
    while (rsTitreStage.next()) {
   String titreStage= rsTitreStage.getString("titre");
   listeAffectation.put(titreStage, listeEtudient);
   }
     
    }
    return listeAffectation; 
    }

    @Override
    public List<Affectation> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
