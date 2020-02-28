/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Service.ServiceDemandeClub;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import com.esprit.Service.ServiceUser;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.swing.JButton;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class AccueilEtudiantController implements Initializable {

    @FXML
    private Button gestionAbsence;
    @FXML
    private Button gestionnote;
    @FXML
    private Button gestionreclamation;
    @FXML
    private Button clubs;
    @FXML
    private Button quitter;
    @FXML
    private AnchorPane pane;
    @FXML
    private Hyperlink dd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            verifIdUserEnClub();
        } catch (SQLException ex) {
            Logger.getLogger(AccueilEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
     @FXML
    private void VaDemanderClubButtonAction(ActionEvent event) throws IOException {
       
        /*Parent demandeclub = FXMLLoader.load(getClass().getResource("/com/esprit/gui/FXMLDemandeClub.fxml"));
        Scene tableViewScene = new Scene(demandeclub);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
        window.setScene(tableViewScene);
        window.show();*/
        
        pane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/FXMLDemandeClub.fxml"));
        pane.getChildren().add(newLoadedPane);
    }
    
    private void verifIdUserEnClub() throws SQLException
    {
        Boolean test;
        ServiceDemandeClub demande = new ServiceDemandeClub();
        test = demande.verifIdEnClub(ServiceUser.id_user_conecte);
        if (test == true) {
            dd.setVisible(false);          
        }
    }

    @FXML
    private void gestionAbsence(ActionEvent event) throws IOException {
        pane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/etudientconsult.fxml"));
        pane.getChildren().add(newLoadedPane);

    }

    @FXML
    private void gestionNote(ActionEvent event) throws IOException {
        
         pane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/Consultation_note.fxml"));
        pane.getChildren().add(newLoadedPane);

    }

    @FXML
    private void gestionReclamation(ActionEvent event) throws IOException {
      pane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/AjoutReclamation.fxml"));
        pane.getChildren().add(newLoadedPane);
    }
    @FXML
    private void retureAcceuil(ActionEvent event) throws IOException {
        
       pane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/AccueilEtudiant.fxml"));
        pane.getChildren().add(newLoadedPane);
    }

    @FXML
    private void clubs(ActionEvent event) throws IOException, SQLException {
        boolean b ;
        ServiceDemandeClub demande = new ServiceDemandeClub();
        b = demande.verifIdEnClub(ServiceUser.id_user_conecte);
        if (b == true) {
            
        Parent demandeclub = FXMLLoader.load(getClass().getResource("FXMLProfilClub.fxml"));
        Scene tableViewScene = new Scene(demandeclub);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
        window.setScene(tableViewScene);
        window.show();          
        }else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information");
            alert.setHeaderText("Vous n'avez pas un Club ");
            alert.setContentText("Click au dessus (Demande Club ) pour Faire une Demande de Club valid !");
            alert.showAndWait();  
        }
       
    }

    @FXML
    private void quitter(ActionEvent event) {
        System.exit(0);
    }
    
}
