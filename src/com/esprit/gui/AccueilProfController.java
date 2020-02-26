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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class AccueilProfController implements Initializable {

    @FXML
    private Button gestionAbsence;
    @FXML
    private Button gestionnote;
    @FXML
    private Button gestionreclamation;
    @FXML
    private Button quitter;
    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gestionAbsence(ActionEvent event) throws IOException {
         pane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/gestionUser.fxml"));
        pane.getChildren().add(newLoadedPane);
    }

    @FXML
    private void gestionNote(ActionEvent event) throws IOException {
         pane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/Interface_Note_Prof.fxml"));
        pane.getChildren().add(newLoadedPane);

    }

    @FXML
    private void gestionReclamation(ActionEvent event) {
    }

    @FXML
    private void quitter(ActionEvent event) {
    }
    
}
