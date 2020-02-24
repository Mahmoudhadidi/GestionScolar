/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Classe;
import com.esprit.Entite.Salle;
import com.esprit.Service.ServiceClasse;
import com.esprit.Service.ServiceSalle;
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
public class GestionSalleController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private TableView<Salle> tableClasse;

    @FXML
    private TableColumn<?, ?> bloc;

    @FXML
    private TableColumn<?, ?> nomsalle;

    @FXML
    private TableColumn<?, ?> numSallle;

    @FXML
    private TableColumn<?, ?> idC;

    @FXML
    private Button ajouterSalle;
    Parent root;
    
    public void navModif() throws IOException {
        root = (AnchorPane) FXMLLoader.load(getClass()
                .getResource("/com/esprit/gui/modifierSalle.fxml"));

        Main.getStage().getScene().setRoot(root);
        Main.getStage().setTitle("Modifier Classe");
        Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/modifierSalle.fxml").toExternalForm());
    }

    @FXML
    void ajouterSalle(ActionEvent event) throws IOException {
        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/ajouterSalle.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/classe.fxml").toExternalForm());
             

    }
    static    int malem;
    ServiceSalle SeC=new ServiceSalle();
public List<Salle> listTable(){
               
               List<Salle> listClasse = null;
        try {
            listClasse = SeC.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClasse;
        }
       Parent root1; 
     public ObservableList<Salle> list;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         idC.setVisible(false);
        tableClasse.setEditable(false);
 
        
                
           
	list=FXCollections.observableArrayList(listTable());
       
        nomsalle.setCellValueFactory(new PropertyValueFactory<>("nomSalle"));
 	numSallle.setCellValueFactory(new PropertyValueFactory<>("numSalle"));
 	bloc.setCellValueFactory(new PropertyValueFactory<>("bloc"));
        idC.setCellValueFactory(new PropertyValueFactory<>("idSalle"));
        
        
       
	tableClasse.setItems(list);
         tableClasse.setRowFactory( tv -> {
    TableRow<Salle> row = new TableRow<>();
    row.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
            Salle rowData = row.getItem();
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            
               alert.setTitle("Action ");
              alert.setHeaderText("Modifier ou supprimer le classe "+rowData.getNomSalle()+" "+rowData.getBloc());
              
               ButtonType supprimer = new ButtonType("Supprimer");
               //alert.show();
        ButtonType modifier = new ButtonType("Modifier");
        

           alert.getButtonTypes().clear();
           alert.getButtonTypes().addAll(supprimer, modifier);


          // option != null.

      Optional<ButtonType> option = alert.showAndWait();


    if (option.get() == supprimer) {
 Salle c=new Salle(rowData.getIdSalle());

                try {
                    SeC.delete(c);
                   
                    tableClasse.getItems().clear();
                    	list=FXCollections.observableArrayList(listTable());
       
       
        nomsalle.setCellValueFactory(new PropertyValueFactory<>("nomSalle"));
 	numSallle.setCellValueFactory(new PropertyValueFactory<>("numSalle"));
 	bloc.setCellValueFactory(new PropertyValueFactory<>("bloc"));
        idC.setCellValueFactory(new PropertyValueFactory<>("idSalle"));
        
        
       
	tableClasse.setItems(list);
        Alert aler = new Alert(Alert.AlertType.INFORMATION);
    			aler.setContentText("salle bien supprimer");
    			aler.show();
        
                    //tableClasse.
                    
                } catch (SQLException ex) {
                    Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
                }
        } else if (option.get() == modifier) {
            malem = rowData.getIdSalle();
                try {
                    navModif();
                    //Classe c=new Classe(,rowData.getNum(),rowData.getNbrEtudient(),rowData.getSpecialite());  
                } catch (IOException ex) {
                    Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
                }
 }  
        }
    });
    return row ;
});
    }    
    
}
