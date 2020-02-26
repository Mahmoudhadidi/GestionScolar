/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class GestionUserController implements Initializable {

    @FXML
    private Button admin;
    @FXML
    private Button enseignant;
    @FXML
    private Button etudiant;
    @FXML
    private Button ajouCompte;
    Parent root;
    @FXML
    private AnchorPane panUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    @FXML
    private void etudiant(ActionEvent event) throws IOException {
     panUser.getChildren().clear();
      Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/compteEtudiant.fxml"));
     panUser.getChildren().add(newLoadedPane);
    
    }

    @FXML
    private void ajoutCompte(ActionEvent event) throws IOException {
        panUser.getChildren().clear();
      Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/ajouterCompte.fxml"));
     panUser.getChildren().add(newLoadedPane);

    }
    
}
