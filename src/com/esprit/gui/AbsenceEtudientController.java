/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.listabsence1;
import com.esprit.Service.ServiceAbsence;
import com.esprit.Utils.DataBase;
import com.esprit.Utils.Pdf;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
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

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AbsenceEtudientController implements Initializable {

    @FXML
    private AnchorPane idEnfant;
    @FXML
    private Button Supprimer;
    @FXML
    private Button retour;
    @FXML
    private Button ajouter;
    @FXML
    private TableView<listabsence1> tabPoint;
    @FXML
    private TableColumn<listabsence1, Integer> ide;
    @FXML
    private TableColumn<listabsence1, String> nom;
    @FXML
    private TableColumn<listabsence1, String> pre;
    @FXML
    private TableColumn<listabsence1, String> type;
    @FXML
    private TableColumn<listabsence1, Integer> ids;
    @FXML
    private Button Supprimer1;
    ServiceAbsence s = new ServiceAbsence();
     private final Connection con = DataBase.getInstance().getConnection();
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affichelisteabsence();
        
    }    
ServiceAbsence n = new ServiceAbsence();
    listabsence1 ls = new listabsence1();
    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
       //notice
        String title = "Notification";
        String message = "Vous avez supprimé l'absence avec succés";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
    
        
    
    ls=tabPoint.getSelectionModel().getSelectedItem();
    n.delete(ls.getId_etudiant());
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
      javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("ajouteraet.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }

    @FXML
        private void Pdf(ActionEvent event) throws FileNotFoundException, SQLException, DocumentException {
        Pdf p=new Pdf();
         p.add("abs145.pdf");
    }
        
        public void affichelisteabsence(){
             //mettre les données dans la table view:
             nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
             pre.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            type.setCellValueFactory(new PropertyValueFactory<>("type_absence"));
            ids.setCellValueFactory(new PropertyValueFactory<>("id_seance"));
       ObservableList<listabsence1> listu  = FXCollections.observableArrayList();
       listu=show();
       tabPoint.setItems(listu);
    }
    public ObservableList<listabsence1> show()
    { 

           try {
               ObservableList<listabsence1> listu =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                  PreparedStatement pt= con.prepareStatement("SELECT absence.id_etudiant,nom,prenom,absence.type_absence,absence.id_seance FROM user,seance,absence where absence.id_etudiant=user.id_user AND absence.id_seance=seance.id_seance");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 listabsence1 ls = new listabsence1();

                 ls.setId_etudiant(rs.getInt("id_etudiant"));
                 ls.setNom(rs.getString("nom"));
                 ls.setPrenom(rs.getString("prenom"));
                 ls.setType_absence(rs.getString("type_absence")); 
                 ls.setId_seance(rs.getInt("id_seance"));
             

                  
                 
         listu.add(ls);
                  }
                  return listu;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    }
 static int id;
    @FXML
    private void modifier(ActionEvent event) throws IOException {
        id=ls.getId_etudiant();
         javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("modEt.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
    
}
