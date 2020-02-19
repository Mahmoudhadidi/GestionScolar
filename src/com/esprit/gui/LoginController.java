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
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private TextField password;

    @FXML
    private Button annuler;

    @FXML
    private Button connexion;

    @FXML
    private TextField logine;
Parent root;
    
    @FXML       
   void connexion(ActionEvent event) throws IOException, SQLException {
   User userlogine=new User(logine.getText(), password.getText());
        ServiceUser su=new ServiceUser();
        
        if(su.connexion(userlogine)==true){

        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/Accueil.fxml").toExternalForm());
           	
        }else{
                        logine.clear();
    			password.clear();
      		Alert alert = new Alert(AlertType.WARNING);
        		alert.setContentText("username or password not available");
        		alert.show();
        }
    }

    @FXML
    void annuler(ActionEvent event) {
                        logine.clear();
    			password.clear();
    }

    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
