/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Classe;
import com.esprit.Entite.Matiere;
import com.esprit.Entite.Salle;
import com.esprit.Entite.Seance;
import com.esprit.Entite.User;
import com.esprit.Service.ServiceClasse;
import com.esprit.Service.ServiceMatiere;
import com.esprit.Service.ServiceSalle;
import com.esprit.Service.ServiceSeance;
import com.esprit.Service.ServiceUser;
import com.esprit.test.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static jdk.nashorn.internal.objects.ArrayBufferView.length;


/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class AjouterSeanceController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private TextField date;

    @FXML
    private TextField heure;

    @FXML
    private TextField duree;

    @FXML
    private Button ajouter;

    @FXML
    private Button annuler;

    @FXML
    private ComboBox<String> enseignant;

    @FXML
    private ComboBox<String> salle;

    @FXML
    private ComboBox<String> matiere;

    @FXML
    private ComboBox<String> classe;

    ServiceSalle SeC=new ServiceSalle();
ServiceMatiere matier=new ServiceMatiere();
ServiceClasse clas=new ServiceClasse();
ServiceUser user=new ServiceUser();
    
    @FXML
    void ajouter(ActionEvent event) throws SQLException, IOException {
        
       
    int idsalle=  SeC.readAll().get(salle.getSelectionModel().getSelectedIndex()).getIdSalle() ;
    String nomsalle=  SeC.readAll().get(salle.getSelectionModel().getSelectedIndex()).getNomSalle() ;
    int idmatier=  matier.readAll().get(matiere.getSelectionModel().getSelectedIndex()).getId() ;
    String nommatier=  matier.readAll().get(matiere.getSelectionModel().getSelectedIndex()).getNom() ;
    int idclasse= clas.readAll().get(classe.getSelectionModel().getSelectedIndex()).getId() ;
    String nomclasse= clas.readAll().get(classe.getSelectionModel().getSelectedIndex()).getNum() ;
    int iduser= user.readAll().get(enseignant.getSelectionModel().getSelectedIndex()).getId() ;
    String mail= user.readAll().get(enseignant.getSelectionModel().getSelectedIndex()).getMail() ;
    String nom= user.readAll().get(enseignant.getSelectionModel().getSelectedIndex()).getNom() ;
    String dat=date.getText();
    String h=heure.getText();
    String hd=duree.getText();
    User ens=new User(iduser,nom,mail);

    Classe lass = new Classe(idclasse,nomclasse);
    Matiere ma=new Matiere(idmatier,nommatier);
    Salle sal=new Salle(idsalle,nomsalle);
    
    Seance sen=new Seance(ens, lass, ma, sal, hd, h, dat);
        //System.out.println(sen.toString());
    ServiceSeance ss=new ServiceSeance();
    ss.ajouter(sen);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setContentText("Seance bien ajouter");
    			alert.show();
                        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
       
    }
    Parent root;
    @FXML
    void anuler(ActionEvent event) throws IOException {
        root = (AnchorPane)FXMLLoader.load(getClass()
  				.getResource("/com/esprit/gui/accueil.fxml"));

        	    	Main.getStage().getScene().setRoot(root);
        	    	Main.getStage().setTitle("Manipulation Interface");
 		Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
           	


    }

    @FXML
    void classe(ActionEvent event) {

    }

    @FXML
    void enseignant(ActionEvent event) {

    }

    @FXML
    void salle(ActionEvent event) {

    }

 
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            for(Salle sall:SeC.readAll()){
                salle.getItems().addAll (sall.getNomSalle()+" "+sall.getBloc());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterSeanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            for(Matiere m:matier.readAll()){
                matiere.getItems().addAll (m.getNom());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterSeanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for(Classe cl:clas.readAll()){
                classe.getItems().add (cl.getNum());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterSeanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for(User u:user.readAll()){
                enseignant.getItems().addAll(u.getNom()+" "+u.getPrenom());
                    
            }   } catch (SQLException ex) {
            Logger.getLogger(AjouterSeanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
