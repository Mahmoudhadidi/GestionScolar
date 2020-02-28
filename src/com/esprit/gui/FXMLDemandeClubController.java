/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.DemandeClub;
import java.io.IOException;
import com.esprit.Service.ServiceUser;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.esprit.Service.ServiceDemandeClub;
import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class FXMLDemandeClubController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private TextField nomm;
    @FXML
    private TextField domainee;
    @FXML
    private TextField descriptionn;

   

    @FXML
    private void envoyerButtonAction(ActionEvent event) throws IOException {
        //////////////////
        int sessionn = ServiceUser.id_user_conecte;
        //////////////////
        ServiceDemandeClub demande = new ServiceDemandeClub();
        DemandeClub d = new DemandeClub(0, sessionn, nomm.getText(), domainee.getText(), descriptionn.getText(), "no valid");
        try {
            boolean b = demande.verifId(sessionn);
            if (b == true) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Demande non envoyéé");
                alert.setContentText("Vous avez déja envoyer une demande ");
                alert.showAndWait(); 
                
                nomm.clear();
                domainee.clear();
                descriptionn.clear();

            } else {
                demande.ajouterDemande(d);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Demande envoyéé");
                //alert.setContentText("Vous avez envoyé un demande de club sous le nom:");
                alert.showAndWait();
                                  
                nomm.clear();
                domainee.clear();
                descriptionn.clear();

                /*Image img = new Image("/logo.png");
                Notifications notif = Notifications.create()
                        .title("Nouveau Demande Club")
                        .text("Veuillez vérifier s'il vous plait")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(7))
                        .position(Pos.BOTTOM_RIGHT);
                notif.show();*/
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Information");
            alert.setHeaderText("Demande non envoyéé");
            alert.setContentText("Vérifier votre informations");
            alert.showAndWait();
        }
    }
}
