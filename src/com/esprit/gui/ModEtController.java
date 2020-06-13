/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.absence;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 * 
 */

public class ModEtController implements Initializable {

    @FXML
    private TextField idemplo1;
    @FXML
    private TextField datee1;
    @FXML
    private Button ajouter;
    @FXML
    private Button retour2;
    @FXML
    private ComboBox<String> type1;
    
    
    
    
    
    private Connection con;
    private Statement ste;

    public ModEtController() {
        con = DataBase.getInstance().getConnection();

    }
    
 public List<absence> remplierModif() throws SQLException{
      
        List<absence> listeSalle=new ArrayList<>();
        
        String bloc = null;
        ste=con.createStatement();
        
         ResultSet rs = null;
       
         rs = ste.executeQuery("select * from absence where id_absence='"+AbsenceEtudientController.id+"'");
          while (rs.next()) {
                int id=rs.getInt(2);
                int id_s=rs.getInt(3);
               String type_absence=rs.getString("type-absence");
                 
                absence c1=new absence(id_s,AbsenceEtudientController.id,type_absence);
                  listeSalle.add(c1);
                    } 
         return listeSalle;
      }
       Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         type1.getItems().addAll("certifié","non certifié");
    type1.setValue("non certifié");
        try {
            System.out.println(remplierModif());
            String idEtudiant = null, idSeance = null,typeAb = null;
            try {
            List<absence> list=remplierModif();
            idEtudiant =String.valueOf(list.get(0).getId_etudiant());
            
            int nb= list.get(0).getId_seance();
            idSeance=String.valueOf(nb);
            typeAb  =list.get(0).getType_absence();
            
            
            } catch (SQLException ex) {
            Logger.getLogger(ModifierClasseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            idemplo1.setText(idEtudiant);
            datee1.setText(idSeance);
            int nb = 0;
            
            if(typeAb.equalsIgnoreCase("certifié")) 
            nb=0;
            if(typeAb.equalsIgnoreCase("non certifié")) 
            nb=1;
            
            //
            type1.getSelectionModel().select(nb);//);
        } catch (SQLException ex) {
            Logger.getLogger(ModEtController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }    

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void retourr(ActionEvent event) throws IOException {
        root = (AnchorPane)FXMLLoader.load(getClass()
  				.getResource("/com/esprit/gui/accueil.fxml"));

        	    	Main.getStage().getScene().setRoot(root);
        	    	Main.getStage().setTitle("Manipulation Interface");
 		Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    
    }
    
}
