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
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AbsenceController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private Button absenceEmploye;

    @FXML
    private Button absenceEtudiant;
    @FXML
    private AnchorPane paneAbsence;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
