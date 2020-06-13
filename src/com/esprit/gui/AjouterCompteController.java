/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.User;
import com.esprit.Service.MailSeance;
import com.esprit.Service.ServiceSeance;
import com.esprit.Service.ServiceUser;
import com.esprit.test.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class AjouterCompteController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private TextField login;
    @FXML
    private TextField motpasse;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField datenaissance;
    @FXML
    private TextField adresse;
    @FXML
    private TextField cin;
    @FXML
    private TextField niveau;
    @FXML
    private ComboBox<String> role;
    ServiceUser us=new ServiceUser();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        role.getItems().addAll("administrateur","enseignant","etudiant");
         cin.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            cin.setText(newValue.replaceAll("[^\\d]", ""));
             
        }
          }
        });
    }    
Parent root;
    @FXML
    private void anulerLajou(ActionEvent event) throws IOException {
      
                        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    }

    @FXML
    private void ajouterUser(ActionEvent event) throws SQLException, IOException {
        
        
        if( login.getText().equals("") || motpasse.getText().equals("") || nom.getText().equals("")|| prenom.getText().equals("") || email.getText().equals("")|| datenaissance.getText().equals("") || adresse.getText().equals("")|| cin.getText().equals("") || niveau.getText().equals("")){
          Alert alert1 = new Alert(Alert.AlertType.WARNING);
        		alert1.setContentText("vérifier votre données ");
        		alert1.show();  
        }else{
        User u=new User(login.getText(), motpasse.getText(), role.getSelectionModel().getSelectedItem(), nom.getText(), prenom.getText(), email.getText(), datenaissance.getText(), adresse.getText(), Integer.valueOf(cin.getText()), niveau.getText());
        us.ajouter(u);
        try {
              
              MailSeance m=new MailSeance("mahmoud.hadidi1@esprit.tn", "191SMT2006",email.getText(), "Affectation au classe", "<h2> Monsieur "+nom.getText()+",votre compte a été creé <br> login: "+login.getText()+" <br> mot de passe: "+motpasse.getText()+"</h3>");
          } catch (Exception ex) {
              Logger.getLogger(ServiceSeance.class.getName()).log(Level.SEVERE, null, ex);
          }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setContentText("Compte bien ajouter");
    			alert.show();
                        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    }
    }
}
