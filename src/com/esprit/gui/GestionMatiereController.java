/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Matiere;
import com.esprit.Service.ServiceMatiere;
import com.esprit.test.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class GestionMatiereController implements Initializable {

    /**
     * Initializes the controller class.
     */
    // @FXML
   // private TableView<Matiere> tableMatiere;

   



   
     @FXML
    private TableView<Matiere> tablematiere;

     @FXML
    private TableColumn<?, ?> nomMatier;

    @FXML
    private TableColumn<?, ?> cofficient;

    @FXML
    private TableColumn<?, ?> credit;

    @FXML
    private TableColumn<?, ?> idC;

    @FXML
    private Button ajouterMatiere;

    @FXML
    private TextField cherche;

    @FXML
    void ajouterClasse(ActionEvent event) throws IOException {
         root = (AnchorPane) FXMLLoader.load(getClass()
                .getResource("/com/esprit/gui/ajouterMatier.fxml"));

        Main.getStage().getScene().setRoot(root);
        Main.getStage().setTitle("Ajouter Matiere");
        Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/classe.fxml").toExternalForm());
  

    }

    @FXML
    void chercheMatiere(KeyEvent event) {

    }

   Parent root;
    
    
     public void navModif() throws IOException {
        root = (AnchorPane) FXMLLoader.load(getClass()
                .getResource("/com/esprit/gui/modifierMatiere.fxml"));

        Main.getStage().getScene().setRoot(root);
        Main.getStage().setTitle("Modifier Matiere");
        Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/modifierMatiere.fxml").toExternalForm());
    }

   

    
    public ObservableList<Matiere> list;

    ServiceMatiere SeC = new ServiceMatiere();

    public List<Matiere> listTable() {

        List<Matiere> listClasse = null;
        try {
            listClasse = SeC.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClasse;
    }

   

    void refreshtable(String n) throws SQLException {
        idC.setVisible(false);
        tablematiere.setEditable(false);
        
       

        list = SeC.SearchEventsF(n);
        
        nomMatier.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cofficient.setCellValueFactory(new PropertyValueFactory<>("coefficient"));
        credit.setCellValueFactory(new PropertyValueFactory<>("credit"));
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));

        tablematiere.setItems(list);

    }

   

  
     @FXML
    private void chercheMatiere(javafx.scene.input.KeyEvent event) throws SQLException {
         String s = cherche.getText();
        refreshtable(s);
    }

    
    
    
    
    Parent root1;
    
    
    
     static int malem;;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         idC.setVisible(false);
        tablematiere.setEditable(false);

        list = FXCollections.observableArrayList(listTable());
  
         nomMatier.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cofficient.setCellValueFactory(new PropertyValueFactory<>("coefficient"));
        credit.setCellValueFactory(new PropertyValueFactory<>("credit"));
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));

        tablematiere.setItems(list);

        tablematiere.setRowFactory(tv -> {
            TableRow<Matiere> row = new TableRow<>();
            row.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Matiere rowData = row.getItem();
                    Alert alert = new Alert(AlertType.CONFIRMATION);

                    alert.setTitle("Action ");
                    alert.setHeaderText("Modifier ou supprimer le matiere " + rowData.getNom());

                    ButtonType supprimer = new ButtonType("Supprimer");
                    //alert.show();
                    ButtonType modifier = new ButtonType("Modifier");

                    alert.getButtonTypes().clear();
                    alert.getButtonTypes().addAll(supprimer, modifier);

                    // option != null.
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get() == supprimer) {
                        Matiere c = new Matiere(rowData.getId());
                        try {
                            if(SeC.verife(c)){
                                try {
                                    SeC.delete(c);
                                    
                                    tablematiere.getItems().clear();
                                    list = FXCollections.observableArrayList(listTable());
                                    
                                    nomMatier.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                    cofficient.setCellValueFactory(new PropertyValueFactory<>("coefficient"));
                                    credit.setCellValueFactory(new PropertyValueFactory<>("credit"));
                                    idC.setCellValueFactory(new PropertyValueFactory<>("id"));
                                    
                                    tablematiere.setItems(list);
                                    Alert aler = new Alert(AlertType.INFORMATION);
                                    aler.setContentText("Classe bien supprimer");
                                    aler.show();
                                    
                                    //tableClasse.
                                } catch (SQLException ex) {
                                    Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else{
                                Alert ale = new Alert(AlertType.WARNING);
                                ale.setContentText("Impossible !!!. Matiere déjà affecter a une seance ");
                                ale.show();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(GestionMatiereController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (option.get() == modifier) {
                       malem = rowData.getId();
                        try {
                            navModif();
                            //Classe c=new Classe(,rowData.getNum(),rowData.getNbrEtudient(),rowData.getSpecialite());  
                        } catch (IOException ex) {
                            Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            return row;
        });

    }

    

    }    
    

