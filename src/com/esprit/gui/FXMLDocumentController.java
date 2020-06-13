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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author ADMIN
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
     @FXML
    private Button button1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent demandeclub = FXMLLoader.load(getClass().getResource("FXMLDemandeClub.fxml"));
        Scene tableViewScene = new Scene(demandeclub);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
        window.setScene(tableViewScene);
        window.show();
    }
    @FXML
    private void handleButton1Action(ActionEvent event) throws IOException {
        Parent demandeclub = FXMLLoader.load(getClass().getResource("FXMLListDemandeClub.fxml"));
        Scene tableViewScene = new Scene(demandeclub);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
        window.setScene(tableViewScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
