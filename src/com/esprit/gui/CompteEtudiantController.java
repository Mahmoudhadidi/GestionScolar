/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.User;
import com.esprit.Service.ServiceUser;
import com.esprit.test.Main;
import java.awt.event.KeyEvent;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class CompteEtudiantController implements Initializable {

    @FXML
    private TableView<User> tableEtudiant;
    @FXML
    private TableColumn<?, ?> login;
    @FXML
    private TableColumn<?, ?> motDePasse;
    @FXML
    private TableColumn<?, ?> role;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> cin;
    @FXML
    private TableColumn<?, ?> niveau;
    @FXML
    private TableColumn<?, ?> id;
      @FXML
    private TextField cherche;
   
    /**
     * Initializes the controller class.
     */
      static int  malem;
      Parent root;
       public ObservableList<User> list;
       public void navModif() throws IOException {
        root = (AnchorPane) FXMLLoader.load(getClass()
                .getResource("/com/esprit/gui/modifierUser.fxml"));

        Main.getStage().getScene().setRoot(root);
        Main.getStage().setTitle("Modifier compte");
        Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/modifierUser.fxml").toExternalForm());
    }

    ServiceUser SeC = new ServiceUser();

    public List<User> listTable() {

        List<User> listuser = null;
        try {
            listuser = SeC.readall();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listuser;
    }
    void refreshtable(String n) throws SQLException {
        id.setVisible(false);
        tableEtudiant.setEditable(false);
        
       

        list = SeC.SearchEventsF(n);
        
        login.setCellValueFactory(new PropertyValueFactory<>("logine"));
        motDePasse.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        niveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));


        tableEtudiant.setItems(list);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setVisible(false);
        tableEtudiant.setEditable(false);
        
       

        list = list=FXCollections.observableArrayList(listTable());
        
        login.setCellValueFactory(new PropertyValueFactory<>("logine"));
        motDePasse.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        niveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));


        tableEtudiant.setItems(list);
        tableEtudiant.setRowFactory( tv -> {
    TableRow<User> row = new TableRow<>();
    row.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
            User rowData = row.getItem();
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            
               alert.setTitle("Action ");
              alert.setHeaderText("Modifier ou supprimer le compte "+rowData.getNom());
              
               ButtonType supprimer = new ButtonType("Supprimer");
               //alert.show();
        ButtonType modifier = new ButtonType("Modifier");
        

           alert.getButtonTypes().clear();
           alert.getButtonTypes().addAll(supprimer, modifier);


          // option != null.

      Optional<ButtonType> option = alert.showAndWait();


    if (option.get() == supprimer) {
 User c=new User(rowData.getId());
            System.out.println(rowData.getId());    
                    
                        try {
                            SeC.delete(c);
                            
                            tableEtudiant.getItems().clear();
                             list = list=FXCollections.observableArrayList(listTable());
        
        login.setCellValueFactory(new PropertyValueFactory<>("logine"));
        motDePasse.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        niveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));


        tableEtudiant.setItems(list);
                            Alert aler = new Alert(Alert.AlertType.INFORMATION);
                            aler.setContentText("Compte bien supprimer");
                            aler.show();
                                                
                            //tableClasse.
                            
                      
                    
                } catch (SQLException ex) {
                    Logger.getLogger(GestionSalleController.class.getName()).log(Level.SEVERE, null, ex);
                }
        } else if (option.get() == modifier) {
           malem = rowData.getId();
                try {
                    navModif();
                    //Classe c=new Classe(,rowData.getNum(),rowData.getNbrEtudient(),rowData.getSpecialite());
                } catch (IOException ex) {
                    Logger.getLogger(CompteEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
                }
 }  
        }
    });
    return row ;
});
    
    }    

    @FXML
    private void cheche_Etudiant(javafx.scene.input.KeyEvent event) throws SQLException {
    String s = cherche.getText();
        refreshtable(s);
    }
    
}
