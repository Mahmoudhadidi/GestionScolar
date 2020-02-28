/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.absence_employe;
import com.esprit.Service.ServiceAbsenceEmploye;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjouterabsenceempController implements Initializable {

    @FXML
    private ComboBox<String> type;
    @FXML
    private TextField idemplo;
    @FXML
    private DatePicker datee;
    @FXML
    private Button btn;
    @FXML
    private Button retour;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    type.getItems().addAll("certifié","non certifié");
    type.setValue("non certifié");
    }    

    @FXML
    private void ajouterRes(ActionEvent event) throws SQLException {
        
        
         if (type.getSelectionModel().equals("") || idemplo.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Champs Vides");
        }
        else{
        
         String type_absence= type.getValue();
         Integer id_employe= Integer.valueOf(idemplo.getText());
         LocalDate date= datee.getValue();
         
         ServiceAbsenceEmploye sp = new ServiceAbsenceEmploye ();
         absence_employe p = new absence_employe( type_absence, id_employe,date);
         sp.ajouter(p);
         System.out.println(p.toString());
         
         //notice
        String title = "Notification";
        String message = "Vous avez modifier l'absence avec succés";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
    }
    }

    @FXML
    private void retourr(ActionEvent event) throws IOException {
         javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AbsenceEmploye.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
    
}
