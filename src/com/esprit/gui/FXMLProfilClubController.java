/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Service.ServiceClub;
import com.esprit.Service.ServiceUser;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;




/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class FXMLProfilClubController implements Initializable {
    
     @FXML
    public ImageView imgc;
     @FXML
    public ImageView imgl ;
     @FXML
    public Label nom;
     @FXML
    public Label slogan;
     @FXML
    public Label titre;
     @FXML
    public Label desc;
     @FXML
    public Label email;

     
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceClub club = new ServiceClub();
            //ServiceUser
            List <String> ll = club.selectClub(ServiceUser.id_user_conecte);

            Image img = new Image(ll.get(1));
            imgc.setImage(img);
            
            Image img1 = new Image(ll.get(2));
            imgl.setImage(img1);
            
            nom.setText(ll.get(0));
            slogan.setText(ll.get(3));
            titre.setText(ll.get(4));
            desc.setText(ll.get(5));
            email.setText(ll.get(6));
            
            
            
            
                       
        } catch (Exception e) {
        }
    }    
    
}
