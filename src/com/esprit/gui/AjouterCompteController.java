/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.User;
import com.esprit.Service.ServiceUser;
import com.esprit.test.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
    }    

    @FXML
    private void anulerLajou(ActionEvent event) {
    }
Parent root;
    @FXML
    private void ajouterUser(ActionEvent event) throws SQLException, IOException {
        User u=new User(login.getText(), motpasse.getText(), role.getSelectionModel().getSelectedItem(), nom.getText(), prenom.getText(), email.getText(), datenaissance.getText(), adresse.getText(), Integer.valueOf(cin.getText()), niveau.getText());
        us.ajouter(u);
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
