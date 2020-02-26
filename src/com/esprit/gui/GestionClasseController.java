/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;
import com.esprit.Entite.Classe;
import com.esprit.Service.ServiceClasse;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class GestionClasseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private TableView<Classe> tableClasse;

    @FXML
    private TableColumn<?, ?> classe;

    @FXML
    private TableColumn<?, ?> capacite;

    @FXML
    private TableColumn<?, ?> spécialiste;

    @FXML
    private TableColumn<?, ?> action;
    @FXML
    private Button exemple;
    
    public ObservableList<Classe> list;
    
    
    
  
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
              
               ServiceClasse SeC=new ServiceClasse();
               List<Classe> listClasse = null;
        try {
            listClasse = SeC.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
                
           
	 list=FXCollections.observableArrayList(listClasse);
       
        classe.setCellValueFactory(new PropertyValueFactory<>("num"));
 	capacite.setCellValueFactory(new PropertyValueFactory<>("nbrEtudient"));
 	spécialiste.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        action.setCellValueFactory(new PropertyValueFactory<>("btn")); 
       
	tableClasse.setItems(list);
          
    }    
    
}
