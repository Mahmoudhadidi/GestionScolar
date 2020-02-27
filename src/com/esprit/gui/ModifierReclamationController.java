/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

//import com.esprit.service.ServiceReclamation;
import com.esprit.Service.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author PC-HP
 */
public class ModifierReclamationController implements Initializable {

    @FXML
    private AnchorPane content3;
    @FXML
    private Rectangle rec;
    @FXML
    private TextArea desc2;
    @FXML
    private TextField sujet2;
    @FXML
    private Button btnmodifier;
public static ServiceReclamation reclamationService=new ServiceReclamation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
sujet2.setText(TableViewController.getReclamation_modifié().getSujet());
         desc2.setText(TableViewController.getReclamation_modifié().getDescription());    // TDO
    }    

    @FXML
    private void modifier(ActionEvent event) {
        TableViewController.getReclamation_modifié().setSujet(sujet2.getText());
      TableViewController.getReclamation_modifié().setDescription(desc2.getText());
        
      reclamationService.update( TableViewController.getReclamation_modifié());
      Notifications notificationBuilder=Notifications.create()
    .title("Reclamation modifié").text("vous avez modifié une reclamation").position(Pos.TOP_RIGHT);
           notificationBuilder.show();
        try {
                        
                       AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("TableView.fxml"));
                        content3.getChildren().clear();
			content3.getChildren().add(newLoadedPane);
                    } catch (IOException ex) {
                        Logger.getLogger(ModifierReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
    }

    @FXML
    private void retour3(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane=FXMLLoader.load(getClass().getResource("TableView.fxml"));
        content3.getChildren().clear();
        content3.getChildren().add(newLoadedPane);
    }
    
}
