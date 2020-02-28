/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.DemandeClub;
import com.esprit.Entite.User;
import com.esprit.Service.ServiceDemandeClub;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class FXMLListDemandeClubController implements Initializable {

    //liste des demandes
    @FXML
    private ObservableList<DemandeClub> data;
    @FXML
    public  TableView<DemandeClub> tabD;
    @FXML
    public TableColumn<?, ?> idE;
    @FXML
    private TableColumn<?, ?> nomC;
    @FXML
    private TableColumn<?, ?> domC;
    @FXML
    private TableColumn<?, ?> desC;
    @FXML
    private TableColumn<?, ?> etaD;
    @FXML
    private TextField cherF;
    @FXML
    private TextField va;
    @FXML
    private TextField nv;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        ServiceDemandeClub demande = new ServiceDemandeClub();
        try {
            AfficerListDemande();
            va.setText(Integer.toString(demande.DemandeValid()));
            nv.setText(Integer.toString(demande.DemandeNoValid()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListDemandeClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void returneButtonAction(ActionEvent event) throws IOException {
        Parent demandeclub = FXMLLoader.load(getClass().getResource("/com/esprit/gui/accueil.fxml"));
        Scene ajoudemandeclub = new Scene(demandeclub);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(ajoudemandeclub);
        window.show();
    }
    
    private void AfficerListDemande() throws SQLException {

        try {
            
            idE.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
            nomC.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
            domC.setCellValueFactory(new PropertyValueFactory<>("domaine"));
            desC.setCellValueFactory(new PropertyValueFactory<>("description"));
            etaD.setCellValueFactory(new PropertyValueFactory<>("etat"));

            ServiceDemandeClub demande = new ServiceDemandeClub();
            List<DemandeClub> list = demande.readAllDemande();
            data = FXCollections.observableArrayList(list);
            tabD.setItems(data);
                             
        } catch (SQLException e) {
        }
    }
    
     @FXML
        private void ChercherDemande(ActionEvent event) throws IOException {
                  
         try {
            idE.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
            nomC.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
            domC.setCellValueFactory(new PropertyValueFactory<>("domaine"));
            desC.setCellValueFactory(new PropertyValueFactory<>("description"));
            etaD.setCellValueFactory(new PropertyValueFactory<>("etat"));
            
            ServiceDemandeClub demande = new ServiceDemandeClub();
            List<DemandeClub> list = demande.ChercherDemandeClub(cherF.getText());
            data = FXCollections.observableArrayList(list);
            tabD.setItems(data);
    
             
         } catch (SQLException ex) {
             System.out.println(ex);
         }     
    }
    
     @FXML
    private void deleteDemandeAction(ActionEvent event) throws IOException {
            
        ServiceDemandeClub demande = new ServiceDemandeClub();
        DemandeClub myclass = tabD.getSelectionModel().getSelectedItem();
         try {
             demande.deleteDemande(myclass.getId());  
             AfficerListDemande();            
         } catch (SQLException ex) {
             System.out.println(ex);
         }     
    }
    
    @FXML
    public void AfficherDetailsButtonAction(ActionEvent event) throws IOException, SQLException { 
        
       /* Parent demandeclub = FXMLLoader.load(getClass().getResource("/com/esprit/gui/FXMLDetailsDemandeClub.fxml"));
        Scene tableViewScene = new Scene(demandeclub);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
        window.setScene(tableViewScene);
        window.show();*/
        
        ServiceDemandeClub demande = new ServiceDemandeClub();
        DemandeClub column = tabD.getSelectionModel().getSelectedItem();     
        List<String> list =  demande.readEtudiantInfo(column.getId_etudiant());
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDetailsDemandeClub.fxml"));
        Parent root= (Parent) loader.load();
        FXMLDetailsDemandeClubController f = loader.getController();
        f.InfoEtudiant(column.getId_etudiant(), list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
        System.out.println(column.getId_etudiant());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
                           
    }
    
}
