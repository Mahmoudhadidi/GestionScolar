/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;


/**
 * FXML Controller class
 *
 * @author PC-HP
 */
public class ConsulterReclamationController implements Initializable {
@FXML
    private TextField sujet;

    @FXML
    private TextField etat;

    @FXML
    private TextFlow nom;

    @FXML
    private TextArea reponse;

    @FXML
    private RadioButton dislike;

    @FXML
    private RadioButton like;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
