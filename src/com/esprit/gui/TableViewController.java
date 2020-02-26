/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Reclamation;
import com.esprit.Service.ServiceReclamation;
//import com.esprit.service.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author PC-HP
 */
public class TableViewController implements Initializable {
    ServiceReclamation serviceReclamation=new ServiceReclamation();

    @FXML
    private TableView<Reclamation> tableStage;
    @FXML
    private TableColumn<Reclamation, String> sujet;
    @FXML
    private TableColumn<Reclamation, String> description;
    @FXML
    private Button supp;
    @FXML
    private AnchorPane content2;

private static ServiceReclamation reclamationser = new ServiceReclamation();
     private static Reclamation reclamation_modifié = new Reclamation();

    public static Reclamation getReclamation_modifié() {
        return reclamation_modifié;
    }

    public static void setSujet_modifié(Reclamation reclamation_modifié) {
        TableViewController.reclamation_modifié = reclamation_modifié;
    }


    /**
     * Initializes the controller class.
     */
    public void afficher(){
        sujet.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("sujet"));
         description.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("description"));
         try    {
                      tableStage.getItems().setAll(serviceReclamation.readAll());
         } 
         catch(SQLException ex){
            
         }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
               // TODO
    } 
    @FXML
    void retour(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane=FXMLLoader.load(getClass().getResource("AjoutReclamation.fxml"));
        content2.getChildren().clear();
        content2.getChildren().add(newLoadedPane);

    }
    @FXML
    void modifier2(ActionEvent event) throws IOException {
reclamation_modifié = tableStage.getSelectionModel().getSelectedItem();
         AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("ModifierReclamation.fxml"));
        content2.getChildren().clear();
        content2.getChildren().add(newLoadedPane);

    
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        ObservableList<Reclamation> selectedRows,Reclamation;
        Reclamation=tableStage.getItems();
        selectedRows=tableStage.getSelectionModel().getSelectedItems();
        for(Reclamation reclamation:selectedRows){
            Reclamation.remove(reclamation);
            
            serviceReclamation.delete(reclamation);
             Notifications notificationBuilder=Notifications.create()
    .title("Reclamation supprimé").text("vous avez s une reclamation").position(Pos.TOP_RIGHT);
             notificationBuilder.show();
           
            
            
        }
        
        
    }
    
    
}
