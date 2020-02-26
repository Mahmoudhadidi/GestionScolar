/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Classe;
import com.esprit.Entite.Seance;
import com.esprit.Service.ServiceClasse;
import com.esprit.Service.ServiceSeance;
import static com.esprit.gui.GestionClasseController.fakhrimalem;
import com.esprit.test.Main;
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
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class GestionSeanceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
   @FXML
    private TableView<Seance> tableseance;
    
    @FXML
    private TableColumn<?, ?> classe;

    @FXML
    private TableColumn<?, ?> matiere;

    @FXML
    private TableColumn<?, ?> salle;

    @FXML
    private TableColumn<?, ?> heure;

    @FXML
    private TableColumn<?, ?> date;

     @FXML
    private TableColumn<?, ?> ensignant;

    @FXML
    private TableColumn<?, ?> matiere1;
      @FXML
    private TableColumn<?, ?> id;

    @FXML
    private Button ajouterSeance;
    
     public ObservableList<Seance> list;

    ServiceSeance SeC=new ServiceSeance();
    public List<Seance> listTable(){
               
               List<Seance> listClasse = null;
        try {
            listClasse = SeC.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClasse;
        }
      Parent root;
      @FXML
    void ajouterSeance(ActionEvent event) throws IOException {
        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/ajouterSeance.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Ajouter seance");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/ajouterSeance.fxml").toExternalForm());
              

    } 
    Parent root1; 
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // idC.setVisible(false);
        tableseance.setEditable(false);
 
          tableseance.getItems().clear();
                
          
         
	list=FXCollections.observableArrayList(listTable());
       
        classe.setCellValueFactory(new PropertyValueFactory<>("nomclasse"));
 	matiere.setCellValueFactory(new PropertyValueFactory<>("nommatiere"));
 	salle.setCellValueFactory(new PropertyValueFactory<>("nomsalle"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        ensignant.setCellValueFactory(new PropertyValueFactory<>("nomens"));
        id.setCellValueFactory(new PropertyValueFactory<>("id_Seance"));
        
        
       
	tableseance.setItems(list);
     
        tableseance.setRowFactory( tv -> {
    TableRow<Seance> row = new TableRow<>();
    row.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
            Seance rowData = row.getItem();
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            
               alert.setTitle("Action ");
              alert.setHeaderText("Supprimer le Seance "+rowData.getNommatiere()+"de classe"+rowData.getNomclasse()+" :date"+rowData.getDate());
              
               ButtonType supprimer = new ButtonType("Supprimer");
               //alert.show();
                ButtonType Annuler = new ButtonType("Annuler");
        
        

           alert.getButtonTypes().clear();
           alert.getButtonTypes().addAll(Annuler,supprimer);


          // option != null.

      Optional<ButtonType> option = alert.showAndWait();


    if (option.get() == supprimer) {
 Seance c=new Seance(rowData.getId_Seance());

                try {
                    SeC.delete(c);
                   tableseance.getItems().clear();
                    list=FXCollections.observableArrayList(listTable());
       
        classe.setCellValueFactory(new PropertyValueFactory<>("nomclasse"));
 	matiere.setCellValueFactory(new PropertyValueFactory<>("nommatiere"));
 	salle.setCellValueFactory(new PropertyValueFactory<>("nomsalle"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        ensignant.setCellValueFactory(new PropertyValueFactory<>("nomens"));
        id.setCellValueFactory(new PropertyValueFactory<>("id_Seance"));
        
        
       
	tableseance.setItems(list);
        Alert aler = new Alert(Alert.AlertType.INFORMATION);
    			aler.setContentText("Seance bien supprimer");
    			aler.show();
        
                    //tableClasse.
                    
                } catch (SQLException ex) {
                    Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
                }
        } 
    else if (option.get() == Annuler) {
       tableseance.getItems().clear();
                    list=FXCollections.observableArrayList(listTable());
       
        classe.setCellValueFactory(new PropertyValueFactory<>("nomclasse"));
 	matiere.setCellValueFactory(new PropertyValueFactory<>("nommatiere"));
 	salle.setCellValueFactory(new PropertyValueFactory<>("nomsalle"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        ensignant.setCellValueFactory(new PropertyValueFactory<>("nomens"));
        id.setCellValueFactory(new PropertyValueFactory<>("id_Seance"));
        
        
       
	tableseance.setItems(list);       
                
 }  
        }
    });
    return row ;
});
        
        // TODO
    }    
    
}
