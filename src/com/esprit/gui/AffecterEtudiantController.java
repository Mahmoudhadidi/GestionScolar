/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Classe;
import com.esprit.Entite.User;
import com.esprit.Service.MailSeance;
import com.esprit.Service.ServiceClasse;
import com.esprit.Service.ServiceSeance;
import com.esprit.Service.ServiceUser;
import com.esprit.test.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class AffecterEtudiantController implements Initializable {

    @FXML
    private ComboBox<String> classe;
   
    @FXML
    private Button affecter;
    @FXML
    private Button annuler;
    ServiceClasse clas=new ServiceClasse();
    ServiceUser etu=new ServiceUser();
final CheckBox chk1 = new CheckBox("chk 1");
final CheckBox chk2 = new CheckBox("chk 2");
   
    @FXML
    private VBox vbox;
    /**
     * Initializes the controller class.
     */
    List<User> et=new ArrayList<>();
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
               
          CheckBox c=     new CheckBox(cl.getNom()+" "+cl.getPrenom()+" "+cl.getNiveau());
                vbox.getChildren().add(c);
         c.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
     User ue= new User(cl.getId(),cl.getNom(),cl.getMail());
       et.add(ue);
      
    }
});
/*
c.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        System.out.println("decocher");
    }
});

EventHandler eh = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof CheckBox) {
            CheckBox chk = (CheckBox) event.getSource();
            System.out.println("Action performed on checkbox " + chk.getText());
            if ("chk 1".equals(chk.getText())) {
                c.setSelected(!c.isSelected());
            } else if ("chk 2".equals(chk.getText())) {
                c.setSelected(!c.isSelected());
            }
        }
    }
};

chk1.setOnAction(eh);
chk2.setOnAction(eh);
*/       
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterSeanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
         
        
        
        
        
        
        
        
        
        
    }    
    Parent root;
    @FXML
    private void affecter(ActionEvent event) throws SQLException, IOException {
       
        int idclasse=  clas.readAll().get(classe.getSelectionModel().getSelectedIndex()).getId() ;
        String nomClasse=  clas.readAll().get(classe.getSelectionModel().getSelectedIndex()).getNum() ;
//    int idetudiant=  etu.readAll_etudiant().get(etudiant.getSelectionModel().getSelectedIndex()).getId() ;
//    String nometudiant=  etu.readAll_etudiant().get(etudiant.getSelectionModel().getSelectedIndex()).getNom() ;
//    String Mailetudiant=  etu.readAll_etudiant().get(etudiant.getSelectionModel().getSelectedIndex()).getMail() ;
    Classe classe=new Classe(idclasse,nomClasse);
    //User user=new User(idetudiant,nometudiant,Mailetudiant);
    for(User e:et){
        
    
    clas.affecterEtudian(classe, e);
    try {
              
              MailSeance m=new MailSeance("mahmoud.hadidi1@esprit.tn", "191SMT2006",e.getMail(), "Affectation au classe", "<h2> Monsieur "+e.getNom()+",vous etes affecter au classe "+classe.getNum()+" </h3>");
          } catch (Exception ex) {
              Logger.getLogger(ServiceSeance.class.getName()).log(Level.SEVERE, null, ex);
          }}
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setContentText("affectaion ou classe"+classe.getNum()+"avec succès");
    			alert.show();
                        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    }
    
}
