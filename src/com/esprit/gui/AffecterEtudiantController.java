/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Classe;
import com.esprit.Entite.User;
import com.esprit.Service.ServiceClasse;
import com.esprit.Service.ServiceUser;
import com.esprit.test.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class AffecterEtudiantController implements Initializable {

    @FXML
    private ComboBox<String> classe;
    @FXML
    private ComboBox<String> etudiant;
    @FXML
    private Button affecter;
    @FXML
    private Button annuler;
    ServiceClasse clas=new ServiceClasse();
    ServiceUser etu=new ServiceUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            for(Classe cl:clas.readAll()){
                classe.getItems().add (cl.getNum());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterSeanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            for(User cl:etu.readAll_etudiant()){
                etudiant.getItems().add (cl.getNom()+" "+cl.getPrenom());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterSeanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    Parent root;
    @FXML
    private void affecter(ActionEvent event) throws SQLException, IOException {
        int idclasse=  clas.readAll().get(classe.getSelectionModel().getSelectedIndex()).getId() ;
    int idetudiant=  etu.readAll_etudiant().get(etudiant.getSelectionModel().getSelectedIndex()).getId() ;
    Classe classe=new Classe(idclasse);
    User user=new User(idetudiant);
    clas.affecterEtudian(classe, user);
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setContentText("Etudiant afecter ou classe");
    			alert.show();
                        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    
    }

    @FXML
    private void annuler(ActionEvent event) {
        Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    }
    
}
