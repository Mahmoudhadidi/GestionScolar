/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author PC-HP
 */
public class ReclamationController implements Initializable {
    
    @FXML
    private TextField nom;
    @FXML
    private TextField Description;
    @FXML
    private TextField Sujet;
    @FXML
    private TextField etat;
    @FXML
    private ComboBox Reclamations;
    @FXML
    private ComboBox Satisfaction;
    @FXML
    private ComboBox<String> ComboBox;

    /**
     * Initializes the controller class.
     */
    
    
//     public void ComboBoxUpdated(){
//        this.ComboBox.SetText("course selected: \n"+ ComboBox.getValue().toString());
//   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        

         Reclamations.getItems().addAll ("Reclamations traitées","Reclamation non traitées");
            
    }
    
}
