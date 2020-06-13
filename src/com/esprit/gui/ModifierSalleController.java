/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Salle;
import com.esprit.Service.ServiceSalle;
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
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
public class ModifierSalleController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField numeroSalle;

    @FXML
    private TextField nomSalle;

    @FXML
    private TextField bloc;

    @FXML
    private Button Annuler;

    @FXML
    private Button Modifier;
    Parent root;
 ServiceSalle serC= new ServiceSalle();
    @FXML
    void ModifierSalle(ActionEvent event) throws SQLException, IOException {
         Salle c1=new Salle(GestionSalleController.malem,Integer.valueOf(numeroSalle.getText()),nomSalle.getText(),bloc.getText());
         serC.update(c1);
          Alert aler = new Alert(Alert.AlertType.INFORMATION);
    			aler.setContentText("Salle bien modifier");
    			aler.show();
          root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Modifier Salle");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    

    }

    @FXML
    void annulerSalle(ActionEvent event) throws IOException {
     
        root = (AnchorPane)FXMLLoader.load(getClass()
  				.getResource("/com/esprit/gui/accueil.fxml"));

        	    	Main.getStage().getScene().setRoot(root);
        	    	Main.getStage().setTitle("Manipulation Interface");
 		Main.getStage().getScene().getStylesheets().add(getClass().getResource("/view/ServiceSalle.css").toExternalForm());
           
    }
    
private Connection con;
    private Statement ste;

    public ModifierSalleController() {
        con = DataBase.getInstance().getConnection();

    }
    
    
      public List<Salle> remplierModif() throws SQLException{
      
        List<Salle> listeSalle=new ArrayList<>();
        int num ;
        String bloc = null;
        ste=con.createStatement();
        
         ResultSet rs = null;
       
         rs = ste.executeQuery("select * from salle where id_salle='"+GestionSalleController.malem+"'");
          while (rs.next()) {
                int id=rs.getInt(1);
                 num=rs.getInt(2);
                String nom=rs.getString(3);
                 bloc=rs.getString(4);
                Salle c1=new Salle(GestionSalleController.malem,num,nom,bloc);
                  listeSalle.add(c1);
                    } 
         return listeSalle;
      }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         String nom = null, nbr = null,bloc = null;
        try {
            List<Salle> list=remplierModif();
            nom =list.get(0).getNomSalle();
            
            int nb= list.get(0).getNumSalle();
            nbr=String.valueOf(nb);
            bloc  =list.get(0).getBloc();
        
                
        } catch (SQLException ex) {
            Logger.getLogger(ModifierClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
                nomSalle.setText(nom);
                numeroSalle.setText(nbr);
        
               this.bloc.setText(bloc);
    }    
    }    
    

