/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.DemandeClub;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.esprit.Service.ServiceDemandeClub;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class FXMLDemandeClubController implements Initializable {
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private TextField nomm;
    @FXML
    private TextField domainee;
    @FXML
    private TextField descriptionn;
    
    @FXML
    private void returneButtonAction(ActionEvent event) throws IOException {
        Parent demandeclub = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene ajoudemandeclub = new Scene(demandeclub);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
        window.setScene(ajoudemandeclub);
        window.show();
    }
    @FXML
    private void envoyerButtonAction(ActionEvent event) throws IOException {
        int sessionn = 1;
        ServiceDemandeClub demande = new ServiceDemandeClub();
        DemandeClub d = new DemandeClub(0,1,nomm.getText(),domainee.getText(),descriptionn.getText(),"no valid");
        try {           
                       
            demande.ajouterDemande(d);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Demande envoyéé");
            //alert.setContentText("Vous avez envoyé un demande de club sous le nom:");
            alert.showAndWait();              
            returneButtonAction(event);
                                              
        } catch (SQLException ex) {
            System.out.println(ex);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Information");
            alert.setHeaderText("Demande non envoyéé");
            alert.setContentText("Vérifier votre informations");
            alert.showAndWait();         
        }           
    }
   
    
}
