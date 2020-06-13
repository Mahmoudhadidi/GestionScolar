/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.absence;
import com.esprit.Service.ServiceAbsence;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjouteraetController implements Initializable {
     @FXML
    private ComboBox<String> type1;

    
    @FXML
    private TextField idemplo1;
    @FXML
    private TextField datee1;
    @FXML
    private Button btn2;
    @FXML
    private Button retour2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type1.getItems().addAll("certifié","non certifié");
    type1.setValue("non certifié");
        // TODO
    }    

    @FXML
    private void ajouterRes(ActionEvent event) throws SQLException {
         //notice
        String title = "Notification";
        String message = "Vous avez modifier l'absence avec succés";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
        
         String type_absence= type1.getValue();
         Integer id_etudiant= Integer.valueOf(idemplo1.getText());
         Integer id_seance= Integer.valueOf(datee1.getText());
         
         ServiceAbsence sp = new ServiceAbsence ();
         absence p = new absence(id_etudiant,id_seance,type_absence);
         sp.ajouter(p);
         System.out.println(p.toString());
    }

    @FXML
    private void retourr(ActionEvent event) throws IOException {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AbsenceEtudient.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
    
}
