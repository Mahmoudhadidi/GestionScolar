/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.listabsence;
import com.esprit.Service.ServiceAbsenceEmploye;
import com.esprit.Utils.DataBase;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tray.notification.TrayNotification;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AbsenceEmployeController implements Initializable {

    @FXML
    private AnchorPane idEnfant;
    @FXML
    private Button Supprimer;
    @FXML
    private Button retour;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private TableView<listabsence> tabPoint;
    
     @FXML
    private TableColumn<listabsence, String> nom;
    @FXML
    private TableColumn<listabsence, String> pre;
    @FXML
    private TableColumn<listabsence, String> type;
    
    @FXML
    private TableColumn<listabsence, String> date;
    
    ServiceAbsenceEmploye s = new ServiceAbsenceEmploye();
    
    
    /**
     * Initializes the controller class.
     */
    private final Connection con = DataBase.getInstance().getConnection();
    @FXML
    private TableColumn<listabsence, Integer> id;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       affichelisteabsence();
         
        
    }    

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
        
       //notice
        String title = "Notification";
        String message = "Vous avez supprimé l'absence avec succés";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
    
        
    ServiceAbsenceEmploye n = new ServiceAbsenceEmploye();
    listabsence ls = new listabsence();
    ls=tabPoint.getSelectionModel().getSelectedItem();
    n.delete(ls.getId_employe());
   affichelisteabsence();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
          javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("accueil.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        
         javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("ajouterabsenceemp.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }

    @FXML
    private void modifier(ActionEvent event) {
        
      /*  if (event.getClickCount() > 0) {
        onEdita();}*/
        
    }
    
   /* public void onEdita() {
    check the table's selected item and get selected item ;
    if (tabPoint.getSelectionModel().getSelectedItem() != null) {
        listabsence ls = tabPoint.getSelectionModel().getSelectedItem();
        
        nom.setText(ls.getNom());
        pre.setText(ls.getPrenom());
        type.setText(ls.getType_absence());
        date.setText(ls.getDate());
    }
}*/
 
    public void affichelisteabsence(){
     
       
             //mettre les données dans la table view:
//             id.setCellValueFactory(new PropertyValueFactory<>("id_employe"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
             pre.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            type.setCellValueFactory(new PropertyValueFactory<>("type_absence"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
       ObservableList<listabsence> listu  = FXCollections.observableArrayList();
       listu=show();
       tabPoint.setItems(listu);
    }
    public ObservableList<listabsence> show()
    { 

           try {
               ObservableList<listabsence> listu =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                  PreparedStatement pt= con.prepareStatement("SELECT id_employe,nom,prenom,type_absence,date FROM user,absence_employe where absence_employe.id_employe=user.id_user");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 listabsence ls = new listabsence();

                 ls.setId_employe(rs.getInt("id_employe"));
                 ls.setNom(rs.getString("nom"));
                 ls.setPrenom(rs.getString("prenom"));
                 ls.setType_absence(rs.getString("type_absence")); 
                 ls.setDate(rs.getString("date"));
             

                  
                 
         listu.add(ls);
                  }
                  return listu;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    }
}
