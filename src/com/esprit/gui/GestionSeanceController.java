/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Seance;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class GestionSeanceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
   @FXML
    private TableView<Seance> tableseance;
    
    @FXML
    private TableColumn<?, ?> classe;

    @FXML
    private TableColumn<?, ?> matiere;

    @FXML
    private TableColumn<?, ?> salle;

    @FXML
    private TableColumn<?, ?> heure;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> ensignant;

    @FXML
    private TableColumn<?, ?> matiere1;

   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
