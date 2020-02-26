/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Reclamation;
import com.esprit.Service.ServiceReclamation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author PC-HP
 */
public class ReclamationController implements Initializable {
    
   
    @FXML
    private TextField nom;

    @FXML
    private TextArea Description;

    @FXML
    private TextField Sujet;

    @FXML
    private TextField etat;
    @FXML
    private ComboBox<String> Reclamations;

    @FXML
    private ComboBox<String> Satisfaction;
     ServiceReclamation sr=new ServiceReclamation();
     //  Reclamation r=new Reclamation(8);
    /**
     * Initializes the controller class.
     */
    
    
//     public void ComboBoxUpdated(){
//        this.ComboBox.SetText("course selected: \n"+ ComboBox.getValue().toString());
//   }
    
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        

        Reclamations.getItems().addAll ("Reclamations traitées","Reclamation non traitées","Reclamations");
        
        Satisfaction.getItems().addAll ("satisfait","non satisfait");
        
      //  Description.setText(sr.detailDecription(r));
        
        
//    ServiceReclamation sr = new ServiceReclamation();
//          List<Reclamation> arr=new ArrayList<>();
//          arr = sr.readAll();
//          for (Reclamation r : arr){
//                  this.id_user.setText(r.getId_user());
//          } 
      
   
            
    }
    
}
