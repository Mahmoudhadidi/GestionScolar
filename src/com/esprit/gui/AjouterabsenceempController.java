/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.User;
import com.esprit.Entite.absence_employe;
import com.esprit.Entite.listabsence;
import com.esprit.Service.ServiceAbsenceEmploye;
import com.esprit.Service.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private TextField idemplo;
    @FXML
    private DatePicker datee;
    @FXML
    private Button btn;
    @FXML
    private Button retour;
    @FXML
    private ComboBox<String> emplobox;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    ServiceUser u=new ServiceUser();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    type.getItems().addAll("certifié","non certifié");
    type.setValue("non certifié");
        try {
            for(User ue:u.readAll()){
                emplobox.getItems().addAll(ue.getNom()+""+ue.getPrenom());
            }   } catch (SQLException ex) {
            Logger.getLogger(AjouterabsenceempController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ajouterRes(ActionEvent event) throws SQLException {
        
        
         if (type.getSelectionModel().equals("") || emplobox.getSelectionModel().equals("") ){
            JOptionPane.showMessageDialog(null, "Champs Vides");
        }
        else{
      //  int idsalle=  SeC.readAll().get(salle.getSelectionModel().getSelectedIndex()).getIdSalle() ;
         String type_absence= type.getValue();
         Integer id_employe= u.readAll().get(emplobox.getSelectionModel().getSelectedIndex()).getId();
             System.out.println(id_employe);
         LocalDate date= datee.getValue();
        // User
        ServiceAbsenceEmploye sp = new ServiceAbsenceEmploye ();
        User user=new User(id_employe);
             absence_employe p=new absence_employe(type_absence, id_employe, date);
         sp.ajouter(p);
       //  System.out.println(p.toString());
         
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
