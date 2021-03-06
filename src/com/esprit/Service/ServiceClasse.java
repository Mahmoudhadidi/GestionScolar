/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Classe;
import com.esprit.Entite.Matiere;
import com.esprit.Entite.Salle;
import com.esprit.Entite.User;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import com.esprit.test.Main;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author hadidi
 */
public class ServiceClasse implements IService<Classe>,Initializable{
    
      private Connection con;
    private Statement ste,steer,ster;

    public ServiceClasse() {
        con = DataBase.getInstance().getConnection();

    }

     @FXML
    private TextField nbrEtudiant;

    @FXML
    private Button annuler;

    @FXML
    private Button ajouter;

    @FXML
    private TextField specialite;

    @FXML
    private TextField nomClasse;

Parent root;

    @FXML
    public void fannuler(ActionEvent event) throws IOException {
        
    		root = (AnchorPane)FXMLLoader.load(getClass()
  				.getResource("/com/esprit/gui/accueil.fxml"));

        	    	Main.getStage().getScene().setRoot(root);
        	    	Main.getStage().setTitle("Accueil");
 		Main.getStage().getScene().getStylesheets().add(getClass().getResource("/view/accueil.css").toExternalForm());
           	

    }
 
    @Override
    public void ajouter(Classe t) throws SQLException  {
      
     ste = con.createStatement();
        String requeteInsert = "INSERT INTO classe ( `num_classe`,`nbre_etudient`,`specialite`) VALUES ('" + t.getNum() + "', '" + t.getNbrEtudient()+ "', '" + t.getSpecialite() + "');";
        ste.executeUpdate(requeteInsert);
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @FXML
    public void fajouter(ActionEvent event) {
        if( nomClasse.getText().equals("") ||Integer.valueOf(nbrEtudiant.getText())<0|| Integer.valueOf(nbrEtudiant.getText()).equals("") || specialite.getText().equals("")){
          Alert alert1 = new Alert(AlertType.WARNING);
        		alert1.setContentText("vérifier votre données ");
        		alert1.show();  
        }else{
       ServiceClasse serC= new ServiceClasse();
       Classe c1=new Classe(nomClasse.getText(),Integer.valueOf(nbrEtudiant.getText()),specialite.getText());
         
       try{
           
        serC.ajouter(c1);
        nomClasse.clear();
        nbrEtudiant.clear();
        specialite.clear();
        Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setContentText("Classe bien ajouter");
    			alert.show();
                        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Accueil");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
        }
        
        catch(Exception e){
               // System.out.println(e);
                }

    }

    }
    
    
    
   
    @Override
    public boolean delete(Classe t) throws SQLException {
      ste = con.createStatement();
        String requeteDelete = "DELETE FROM classe WHERE id_classe='" + t.getId()+ "';";
    int w=ste.executeUpdate(requeteDelete);
        if(w>0)
          return true; 
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return false;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Classe t) throws SQLException {
        ste = con.createStatement();//DELETE FROM Pays WHERE Population > 170000;
        String requeteUpdate = "update classe set num_classe='"+t.getNum()+"',nbre_etudient='"+t.getNbrEtudient()+"',specialite='"+t.getSpecialite()+"'where id_classe='"+t.getId()+"'";
    int w=ste.executeUpdate(requeteUpdate);
        if(w>0)
          return true; 
    return false;        

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Classe> readAll() throws SQLException {
        List<Classe> listeClasse=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from classe");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String num=rs.getString(2);
               int nom=rs.getInt(3);
               String bloc=rs.getString(4);
              Classe classe =new Classe(id, num, nom, bloc);
     listeClasse.add(classe);
     }
    return listeClasse;  
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

   public boolean affecterEtudian(Classe t, User u) throws SQLException{
       
       ste = con.createStatement();//DELETE FROM Pays WHERE Population > 170000;
       String requeteUpdate = "update user set id_classe='"+t.getId()+"'where id='"+u.getId()+"'";
       int w=ste.executeUpdate(requeteUpdate);
        if(w>0)
          return true; 
        return false;
}
   public void initialize(URL location, ResourceBundle resources) {
		 nbrEtudiant.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            nbrEtudiant.setText(newValue.replaceAll("[^\\d]", ""));
             
        }
          }
        });
     
		
	}




    public ObservableList<Classe>  SearchEventsF(String n) throws SQLException  {         
      
        ObservableList<Classe>  arr = FXCollections.observableArrayList();     
        steer = con.createStatement();
        ResultSet res ;
        //System.out.println(n);
        res = steer.executeQuery(" select * from classe where  (id_classe like'%"+n+"%')||(num_classe like'%"+n+"%')||(nbre_etudient like'%"+n+"%')||(specialite like'%"+n+"%')");
        // select* from events where (Nom like '%"+n+"%') or (etat like '%"+n+"%') or (date like '%"+n+"%') or (type like '%"+n+"%') or (id like '%"+n+"%') ");
//             res = ste.executeQuery(" select* from events where (Nom like '%"+n+"%') or (etat like '%"+n+"%') or (date like '%"+n+"%') or (type like '%"+n+"%') or (id like '%"+n+"%') ");
            while (res.next())
            {
               Classe    a=new Classe(res.getInt(1),res.getString(2),res.getInt(3),res.getString(4));
               
               arr.add(a);
             //  System.out.println(arr);
            }
        
        return arr;
    }

public boolean verife(Classe c) throws SQLException{
    
    ster = con.createStatement();
        ResultSet res ;
        //System.out.println(n);
        res = ster.executeQuery(" select * from seance where  id_classe='"+c.getId()+"'");
         while (res.next()){
             return false;
         }
    return true;
}


}
