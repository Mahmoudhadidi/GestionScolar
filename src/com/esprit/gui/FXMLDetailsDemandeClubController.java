/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Club;
import com.esprit.Service.ServiceClub;
import com.esprit.Utils.EmailZ;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class FXMLDetailsDemandeClubController implements Initializable {

    
    int id ;
    @FXML
    public Label nom;
    @FXML
    public Label prenom;
    @FXML
    public Label mail;
    @FXML
    public Label niveau;
    @FXML
    public Label classe;
    @FXML
    public DatePicker dateP;

    public void InfoEtudiant (int text,String text1,String text2,String text3,String text4,String text5)
    {
        id = text;
        nom.setText(text1);
        prenom.setText(text2);
        mail.setText(text3);
        niveau.setText(text4);
        classe.setText(text5);   
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void ValidClub(ActionEvent event) throws IOException {
            
        ServiceClub club = new ServiceClub();
        Club c = new Club(0, id, "", "", "", "", "", "", mail.getText(), "private");
        
         try {
                       club.ajouterClub(c, 1);
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Demande Valider!");
            //alert.setContentText("Vous avez envoyé un demande de club sous le nom:");
            alert.showAndWait();  
            

             
         } catch (SQLException ex) {
             System.out.println(ex);
         }     
    }   
    
    @FXML
    private void sendMail(ActionEvent event) throws IOException, Exception {
        //LocalDate da = dateP.getValue();
        //System.out.println(da);
        try {
            EmailZ.sendMail(mail.getText(), prenom.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Mail Envoyer");
            //alert.setContentText("Vous avez envoyé un demande de club sous le nom:");
            alert.showAndWait();  
            
            
        } catch (Exception e) {
            
        }
       
    }
    
    
    
    
}
