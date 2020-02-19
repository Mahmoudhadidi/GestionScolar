/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.DemandeClub;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class FXMLListDemandeClubController implements Initializable {

    @FXML
    private Label L1;
    @FXML
    private ObservableList<DemandeClub> data;
    @FXML
    private TableView<DemandeClub> tabD;
    @FXML
    private TableColumn<?, ?> idE;
    @FXML
    private TableColumn<?, ?> nomC;
    @FXML
    private TableColumn<?, ?> domC;
    @FXML
    private TableColumn<?, ?> desC;
    @FXML
    private TableColumn<?, ?> etaD;
    @FXML
    private TableColumn<?, ?> detD;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AfficerListDemande();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListDemandeClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void returneButtonAction(ActionEvent event) throws IOException {
        Parent demandeclub = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene ajoudemandeclub = new Scene(demandeclub);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(ajoudemandeclub);
        window.show();
    }
    

    private void AfficerListDemande() throws SQLException {

        try {

            ServiceDemandeClub demande = new ServiceDemandeClub();
            List<DemandeClub> list = demande.readAllDemande();
            data = FXCollections.observableArrayList(list);
            tabD.setItems(data);
           
            idE.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
            nomC.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
            domC.setCellValueFactory(new PropertyValueFactory<>("domaine"));
            desC.setCellValueFactory(new PropertyValueFactory<>("description"));
            etaD.setCellValueFactory(new PropertyValueFactory<>("etat"));

            /*Callback<TableColumn<DemandeClub,String>,TableCell<DemandeClub,String>> cellFactory = (param) -> {
                final TableCell<DemandeClub, String> cell = new TableCell<DemandeClub, String>() {

                    //@Override
                    public void updateiitem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            final Button detailleBtn = new Button("detaille");
                            detailleBtn.setOnAction(event -> {
                                DemandeClub d = getTableView().getItems().get(getIndex());

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setContentText("le nom de club:" + d.getNom_club() + "et domaine:" + d.getDomaine());
                                alert.show();
                            });
                            setGraphic(detailleBtn);
                            setText(null);
                        }
                    };
                };
                    return cell;
            };
            
            //detD.setCellFactory(cellFactory);*/
           
        } catch (SQLException e) {
        }
    }

}
