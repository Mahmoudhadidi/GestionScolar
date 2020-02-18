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
public class GestionAffectaionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane paneAffectaion;
    
    @FXML
    private Button gestionClasse;

    @FXML
    private Button gestionMatiere;

    @FXML
    private Button gestionSeances;

    @FXML
    private Button gestionSalle;

    @FXML
    void gestionSeances(ActionEvent event) {

    }

    @FXML
    void gestionSalle(ActionEvent event) {

    }

    @FXML
    void gestionClasse(ActionEvent event) {

    }

    @FXML
    void gestionMatiere(ActionEvent event) {

    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
