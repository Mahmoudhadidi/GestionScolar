/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Club;
import com.esprit.Service.ServiceClub;
import com.esprit.Service.ServiceDemandeClub;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class FXMLDetailsDemandeClubController implements Initializable {
    

    @FXML
    public Label nomE;
    @FXML
    public Label prenomE;
    @FXML
    public Label mailE;
    @FXML
    public Label niveauE;
    @FXML
    public Label classeE;
    @FXML
    public ImageView imgP;
 
    @FXML
    public DatePicker dateP;
    
    int etud = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img = new Image("/moi.jpg");
        imgP.setImage(img);
    }    
    
     public void InfoEtudiant (int text,String text1,String text2,String text3,String text4,String text5)
    {
        etud = text;
        nomE.setText(text1);
        prenomE.setText(text2);
        mailE.setText(text3);
        niveauE.setText(text4);
        classeE.setText(text5);   
    }
     
     @FXML
    private void ValidClub(ActionEvent event) throws IOException {
            
        String s = null;
         ServiceDemandeClub demande = new ServiceDemandeClub();
        ServiceClub club = new ServiceClub();
        Club c = new Club(0, etud, "Nom De Clib", "/photoCov.jpg", "/logo.png", "Ajouter Votre Slogan", "Votre Grand Titre", "Modifier Votre Description", mailE.getText(), "private");
        
         try {
             s = demande.verifEtatEnDemandeClub(etud);
              System.out.println(s);
          
              if("no valid".equals(s))
              {
                  club.ajouterClub(c, etud);
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Demande Validé !");
            //alert.setContentText("Vous avez envoyé un demande de club sous le nom:");
            alert.showAndWait();  
                  
              }else
              {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information");
            alert.setHeaderText("Demande Déja validé !");
            //alert.setContentText("Vous avez envoyé un demande de club sous le nom:");
            alert.showAndWait();  
              }
             
                       
             
         } catch (SQLException ex) {
             System.out.println(ex);
         }     
    }   
    
    @FXML
    private void sendMail(ActionEvent event) throws IOException, Exception {
            
        //LocalDate da = dateP.getValue();
        //System.out.println(da);
        try {
            EmailZ.sendMail(mailE.getText(), prenomE.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Mail Envoyer");
            //alert.setContentText("Vous avez envoyé un demande de club sous le nom:");
            alert.showAndWait();  
            
            
        } catch (Exception e) {
            
        }
       
    }
    
}
