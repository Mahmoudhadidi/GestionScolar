/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Classe;
import com.esprit.Entite.Matiere;
import com.esprit.Entite.Salle;
import com.esprit.Entite.Seance;
import com.esprit.Entite.User;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hadidi
 */
public class ServiceSeance implements IService<Seance> {
    
      private Connection con;
    private Statement ste;

    public ServiceSeance() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Seance t) throws SQLException {
             ste = con.createStatement();
        String requeteInsert = "INSERT INTO seance ( `id_ens`,`id_classe`,`id_matiere`,`id_salle`,`duree`,`heure`,`date`) VALUES ('" + 
                t.getEns().getId() + "', '" + t.getClasse().getId()+ "', '" + t.getMatiere().getId() + "', '" + t.getSalle().getIdSalle() + "', '" + t.getDuree() + "', '" + t.getHeure() + "', '" + t.getDate() + "');";
          try {
              MailSeance m=new MailSeance("mahmoud.hadidi1@esprit.tn", "191SMT2006","mahmoudhadidi2017@gmail.com", "Affectation seance", "<h2> Monsieur,vous avez une nouvelle séance de matière au classe..  </h3>");
          } catch (Exception ex) {
              Logger.getLogger(ServiceSeance.class.getName()).log(Level.SEVERE, null, ex);
          }
        ste.executeUpdate(requeteInsert);

       
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance t) throws SQLException {
ste = con.createStatement();
        String requeteDelete = "DELETE FROM seance WHERE id_seance='" + t.getId_Seance()+ "';";
    int w=ste.executeUpdate(requeteDelete);
        if(w>0)
          return true; 
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return false;           
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance t) throws SQLException {
          ste = con.createStatement();//DELETE FROM Pays WHERE Population > 170000;
        String requeteUpdate = "update seance set id_ens='"+t.getEns()+"',id_classe='"+t.getClass()+"',id_matiere='"+t.getMatiere()+"',id_salle='"+t.getSalle()+"',duree='"+t.getDuree()+"',heure='"+t.getHeure()+"',date='"+t.getDate()+"'where id_seance='"+t.getId_Seance()+"'";
    int w=ste.executeUpdate(requeteUpdate);
        if(w>0)
          return true; 
    return false;        

        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public Seance getSeanceByID(int id){
    Seance s = null;
    return s;
}
    @Override
    public List<Seance> readAll() throws SQLException {
        List<Seance> listeClasse=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select id_seance, num_classe,nom_matier,nom_salle,bloc,nom,prenom,heure,date from seance , classe , user ,salle ,matiere  where (seance.id_ens=user.id_user) && (seance.id_classe=classe.id_classe)&&(seance.id_matiere=matiere.id_matiere) && (seance.id_salle=salle.id_salle) ");
     while (rs.next()) {                
               int id=rs.getInt("id_seance");
               String nom_classe=rs.getString("num_classe");
               String nom_matier=rs.getString("nom_matier");
               String nom_salle=rs.getString("nom_salle");
               String bloc=rs.getString("bloc");
               String nomEns=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String heure=rs.getString("heure");
               String date=rs.getString("date");
               nomEns=nomEns+" "+prenom;
               nom_salle=nom_salle+" "+bloc;
               Seance seance =new Seance(id, nomEns, nom_classe, nom_matier, nom_salle, heure, date);
               
              /* Classe classe =new Classe(nom_classe);
               Matiere matiere=new Matiere(nom_matier);
               Salle salle=new Salle(nom_matier);
               User Ens=new User(nomEns,prenom);
              Seance seance =new Seance(id, Ens, classe, matiere, salle, date, heure, date);*/
     listeClasse.add(seance);
     }
    return listeClasse;  
        
     
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
