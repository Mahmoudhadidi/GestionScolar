/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Classe;
import com.esprit.Entite.Salle;
import com.esprit.Service.ServiceClasse;
import com.esprit.Service.ServiceSalle;
import com.esprit.test.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
public class AjouterSalleController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
  @FXML
    private TextField numeroSalle;

    @FXML
    private TextField nomSalle;

    @FXML
    private TextField bloc;

    @FXML
    private Button Annuler;

    @FXML
    private Button Ajouter;
    Parent root;
    @FXML
    void ajouterSalle(ActionEvent event) {
         if( nomSalle.getText().equals("") ||Integer.valueOf(numeroSalle.getText())<0|| Integer.valueOf(numeroSalle.getText()).equals("") || bloc.getText().equals("")){
          Alert alert1 = new Alert(Alert.AlertType.WARNING);
        		alert1.setContentText("vérifier votre données ");
        		alert1.show();  
        }
       ServiceSalle serC= new ServiceSalle();
       Salle c1=new Salle(Integer.valueOf(numeroSalle.getText()),nomSalle.getText(),bloc.getText());
         
       try{
           
        serC.ajouter(c1);
        numeroSalle.clear();
        nomSalle.clear();
        bloc.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setContentText("Salle bien ajouter");
    			alert.show();
                        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Accueil");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
        }
        
        catch(Exception e){
                System.out.println(e);
                }


    }

    @FXML
    void annulerSalle(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
