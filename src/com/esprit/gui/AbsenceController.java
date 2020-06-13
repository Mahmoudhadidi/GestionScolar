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
 * @author LENOVO
 */
public class AbsenceController implements Initializable {

    @FXML
    private Button absenceEmploye;
    @FXML
    private Button absenceEtudiant;
    @FXML
    private AnchorPane paneAbsence;
    @FXML
    private Button stat;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  @FXML
    void absenceEmploye(ActionEvent event) throws IOException {
         paneAbsence.getChildren().clear();
     Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/absenceEmploye.fxml"));
     paneAbsence.getChildren().add(newLoadedPane);

    }

    @FXML
    void absenceEtudiant(ActionEvent event) throws IOException {
         paneAbsence.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/absenceEtudient.fxml"));
         paneAbsence.getChildren().add(newLoadedPane);
   
    }

    @FXML
    private void stat(ActionEvent event) throws IOException {
        paneAbsence.getChildren().clear();
     Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/com/esprit/gui/absencestat.fxml"));
     paneAbsence.getChildren().add(newLoadedPane);
    }
    
}
