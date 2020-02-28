/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Matiere;
import com.esprit.Service.ServiceMatiere;
import com.esprit.test.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class AjouterMatierController implements Initializable {

    @FXML
    private TextField nomMatiere;
    @FXML
    private TextField coefficient;
    @FXML
    private TextField credit;
    @FXML
    private Button Annuler;
    @FXML
    private Button Ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         coefficient.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            coefficient.setText(newValue.replaceAll("[^\\d]", ""));
             
        }
          }
        });
    
          credit.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            credit.setText(newValue.replaceAll("[^\\d]", ""));
             
        }
          }
        });
    
    }    
    Parent root;
    @FXML
    private void ajouterMatiere(ActionEvent event) throws SQLException, IOException {
         if( nomMatiere.getText().equals("") ||Integer.valueOf(coefficient.getText())<0|| Integer.valueOf(coefficient.getText()).equals("") || credit.getText().equals("")){
          Alert alert1 = new Alert(Alert.AlertType.WARNING);
        		alert1.setContentText("vérifier votre données ");
        		alert1.show();  
        }else{
       ServiceMatiere serC= new ServiceMatiere();
       Matiere c1=new Matiere(nomMatiere.getText(),Integer.valueOf(coefficient.getText()),Integer.valueOf(credit.getText()));
         
       
           
        serC.ajouter(c1);
        coefficient.clear();
        nomMatiere.clear();
        credit.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setContentText("Matiere bien ajouter");
    			alert.show();
                        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Accueil");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
        }
    }
    

    @FXML
    private void annulerMatiere(ActionEvent event) throws IOException {
        root = (AnchorPane)FXMLLoader.load(getClass()
  				.getResource("/com/esprit/gui/accueil.fxml"));

        	    	Main.getStage().getScene().setRoot(root);
        	    	Main.getStage().setTitle("Manipulation Interface");
 		Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
           
    }
    
}
