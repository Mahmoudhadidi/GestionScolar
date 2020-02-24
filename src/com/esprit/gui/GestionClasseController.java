/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Classe;
import com.esprit.Service.ServiceClasse;
import com.esprit.test.Main;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
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
    static int fakhrimalem = 0;
    @FXML
    private TableView<Classe> tableClasse;

    @FXML
    private TableColumn<?, ?> classe;

    @FXML
    private TableColumn<?, ?> capacite;

    @FXML
    private TableColumn<?, ?> spécialiste;
    Parent root;
    @FXML
    private Button ajouterClasse;

    public void navModif() throws IOException {
        root = (AnchorPane) FXMLLoader.load(getClass()
                .getResource("/com/esprit/gui/modifierClasse.fxml"));

        Main.getStage().getScene().setRoot(root);
        Main.getStage().setTitle("Modifier Classe");
        Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/modifierClasse.fxml").toExternalForm());
    }

    @FXML
    void ajouterClasse(ActionEvent event) throws IOException {

        root = (AnchorPane) FXMLLoader.load(getClass()
                .getResource("/com/esprit/gui/classe.fxml"));

        Main.getStage().getScene().setRoot(root);
        Main.getStage().setTitle("Ajouter classe");
        Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/classe.fxml").toExternalForm());
    }

    @FXML
    private TableColumn<?, ?> idC;
    public ObservableList<Classe> list;

    ServiceClasse SeC = new ServiceClasse();

    public List<Classe> listTable() {

        List<Classe> listClasse = null;
        try {
            listClasse = SeC.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClasse;
    }

    @FXML
    private TextField tcherche;

    void refreshtable(String n) throws SQLException {
        idC.setVisible(false);
        tableClasse.setEditable(false);
        
       

        list = SeC.SearchEventsF(n);
        
        classe.setCellValueFactory(new PropertyValueFactory<>("num"));
        capacite.setCellValueFactory(new PropertyValueFactory<>("nbrEtudient"));
        spécialiste.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));

        tableClasse.setItems(list);

    }

    @FXML
    private void ch(javafx.scene.input.KeyEvent event) throws SQLException {

        String s = tcherche.getText();
        refreshtable(s);
    }

    Parent root1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

//        Classe c=new Classe();
        idC.setVisible(false);
        tableClasse.setEditable(false);

        list = FXCollections.observableArrayList(listTable());

        classe.setCellValueFactory(new PropertyValueFactory<>("num"));
        capacite.setCellValueFactory(new PropertyValueFactory<>("nbrEtudient"));
        spécialiste.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));

        tableClasse.setItems(list);

        tableClasse.setRowFactory(tv -> {
            TableRow<Classe> row = new TableRow<>();
            row.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Classe rowData = row.getItem();
                    Alert alert = new Alert(AlertType.CONFIRMATION);

                    alert.setTitle("Action ");
                    alert.setHeaderText("Modifier ou supprimer le classe " + rowData.getNum());

                    ButtonType supprimer = new ButtonType("Supprimer");
                    //alert.show();
                    ButtonType modifier = new ButtonType("Modifier");

                    alert.getButtonTypes().clear();
                    alert.getButtonTypes().addAll(supprimer, modifier);

                    // option != null.
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get() == supprimer) {
                        Classe c = new Classe(rowData.getId());

                        try {
                            SeC.delete(c);

                            tableClasse.getItems().clear();
                            list = FXCollections.observableArrayList(listTable());

                            classe.setCellValueFactory(new PropertyValueFactory<>("num"));
                            capacite.setCellValueFactory(new PropertyValueFactory<>("nbrEtudient"));
                            spécialiste.setCellValueFactory(new PropertyValueFactory<>("specialite"));
                            idC.setCellValueFactory(new PropertyValueFactory<>("id"));

                            tableClasse.setItems(list);
                            Alert aler = new Alert(AlertType.INFORMATION);
                            aler.setContentText("Classe bien supprimer");
                            aler.show();

                            //tableClasse.
                        } catch (SQLException ex) {
                            Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (option.get() == modifier) {
                        fakhrimalem = rowData.getId();
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
