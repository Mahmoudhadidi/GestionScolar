/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Matiere;
import com.esprit.Service.ServiceMatiere;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class ModifierMatiereController implements Initializable {

    @FXML
    private TextField nomMatiere;
    @FXML
    private TextField coefficient;
    @FXML
    private TextField credit;
    @FXML
    private Button Annuler;
    @FXML
    private Button Modifier;
    private Connection con;
    private Statement ste;
    public ModifierMatiereController() {
        con = DataBase.getInstance().getConnection();

    }
    
     ServiceMatiere serC= new ServiceMatiere();

    /**
     * Initializes the controller class.
     */
     public List<Matiere> remplierModif() throws SQLException{
      
        List<Matiere> listeClasse=new ArrayList<>();
        String num = null;
        int bloc;
        ste=con.createStatement();
        
         ResultSet rs = null;
         //System.out.println(GestionClasseController.fakhrimalem + "static");
         rs = ste.executeQuery("select * from matiere where id_matiere='"+GestionMatiereController.malem+"'");
          while (rs.next()) {
                int id=rs.getInt(1);
                 num=rs.getString(2);
                int nom=rs.getInt(3);
                 bloc=rs.getInt(4);
                Matiere c1=new Matiere(GestionMatiereController.malem,num,nom,bloc);
                  listeClasse.add(c1);
                    } 
       
         
         
         
   return listeClasse;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          String nom = null, coff = null,credi = null;
          int credit,cof ;
        try {
            List<Matiere> list=remplierModif();
            nom =list.get(0).getNom();
            
             cof= list.get(0).getCoefficient();
              coff=String.valueOf(cof);
           
            credit  =list.get(0).getCredit();
          credi=String.valueOf(credit);
                
        } catch (SQLException ex) {
            Logger.getLogger(ModifierClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
                nomMatiere.setText(nom);
        
                coefficient.setText(coff);
               
        
                this.credit.setText(credi);
    }    
Parent root;
    @FXML
    private void annulerModif(ActionEvent event) throws IOException {
        root = (AnchorPane)FXMLLoader.load(getClass()
  				.getResource("/com/esprit/gui/accueil.fxml"));

        	    	Main.getStage().getScene().setRoot(root);
        	    	Main.getStage().setTitle("Manipulation Interface");
 		Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
           	
    
    }

    @FXML
    private void modifierMatiere(ActionEvent event) throws SQLException, IOException {
         Matiere c1=new Matiere(GestionMatiereController.malem,nomMatiere.getText(),Integer.valueOf(coefficient.getText()),Integer.valueOf(credit.getText()));
         
       
            serC.update(c1);
          Alert aler = new Alert(Alert.AlertType.INFORMATION);
    			aler.setContentText("Matiere bien modifier");
    			aler.show();
          root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Modifier Classe");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    }
    
}
