/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.User;
import com.esprit.Service.MailSeance;
import com.esprit.Service.ServiceSeance;
import com.esprit.Service.ServiceUser;
import com.esprit.Utils.DataBase;
import com.esprit.test.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class ModifierUserController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private TextField login;
    @FXML
    private TextField motpasse;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField datenaissance;
    @FXML
    private TextField adresse;
    @FXML
    private TextField cin;
    @FXML
    private TextField niveau;
    @FXML
    private ComboBox<String> role;
 ServiceUser us=new ServiceUser();
 Parent root;
    /**
     * Initializes the controller class.
     * 
     */
 private Connection con;
    private Statement ste;

    public ModifierUserController() {
        con = DataBase.getInstance().getConnection();

    }
 public List<User> remplierModif() throws SQLException{
      
        List<User> listeClasse=new ArrayList<>();
        String num = null;
        String bloc = null;
        ste=con.createStatement();
        
         ResultSet res = null;
         //System.out.println(GestionClasseController.fakhrimalem + "static");
         res = ste.executeQuery("select * from classe where id_classe='"+CompteEtudiantController.malem+"'");
          while (res.next()) {
                
               User    a=new User(res.getInt(1),res.getString("login"),res.getString("mdp"),res.getString("role"),res.getString("nom")+" "+res.getString("prenom"),res.getString("email"),res.getInt("cin"),res.getString("niveau"));
              
                  listeClasse.add(a);
                    } 
       
         
         
         
   return listeClasse;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         cin.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            cin.setText(newValue.replaceAll("[^\\d]", ""));
             
        }
          }
        });
    }    

    @FXML
    private void anulerLajou(ActionEvent event) throws IOException {
         root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    }

    @FXML
    private void ModifierUser(ActionEvent event) throws IOException, SQLException {
        if( login.getText().equals("") || motpasse.getText().equals("") || nom.getText().equals("")|| prenom.getText().equals("") || email.getText().equals("")|| datenaissance.getText().equals("") || adresse.getText().equals("")|| cin.getText().equals("") || niveau.getText().equals("")){
          Alert alert1 = new Alert(Alert.AlertType.WARNING);
        		alert1.setContentText("vérifier votre données ");
        		alert1.show();  
        }else{
        User u=new User(CompteEtudiantController.malem,login.getText(), motpasse.getText(), role.getSelectionModel().getSelectedItem(), nom.getText(), prenom.getText(), email.getText(), datenaissance.getText(), adresse.getText(), Integer.valueOf(cin.getText()), niveau.getText());
        us.update(u);
        try {
              
              MailSeance m=new MailSeance("mahmoud.hadidi1@esprit.tn", "191SMT2006",email.getText(), "Affectation au classe", "<h2> Monsieur "+nom.getText()+",votre compte a été Modifier <br> login: "+login.getText()+" <br> mot de passe: "+motpasse.getText()+"</h3>");
          } catch (Exception ex) {
              Logger.getLogger(ServiceSeance.class.getName()).log(Level.SEVERE, null, ex);
          }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setContentText("Compte bien ajouter");
    			alert.show();
                        root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Manipulation Interface");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    }
    }
    
}
