/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.test.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;



/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class AccueilController implements Initializable {

    /**
     * Initializes the controller class.
     */
    



    @FXML
    private Button gestionreclamation;

    @FXML
    private Button gestionuser;

    @FXML
    private Button gestionaffectation;

    @FXML
    private Button gestionnote;

    @FXML
    private Button quitter;

    @FXML
    private Button gestionAbsence;

    @FXML
    private Button clubs;

    @FXML
    private AnchorPane pane;

    @FXML
    void gestionUser(ActionEvent event) throws IOException {
     pane.getChildren().clear();
     Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/classe.fxml"));
     pane.getChildren().add(newLoadedPane);
        		    }

    @FXML
    void gestionaffectation(ActionEvent event) throws IOException {
        pane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/gestionAffectaion.fxml"));
        pane.getChildren().add(newLoadedPane);

    }

    @FXML
    void gestionAbsence(ActionEvent event) {

    }

    @FXML
    void gestionNote(ActionEvent event) {

    }

    @FXML
    void gestionReclamation(ActionEvent event) throws IOException {
     pane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/ReclamationAdmin.fxml"));
        pane.getChildren().add(newLoadedPane);

    }

    @FXML
    void clubs(ActionEvent event) {

    }

    @FXML
    void quitter(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
