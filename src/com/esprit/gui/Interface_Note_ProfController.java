/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Service.ServiceNote;
import java.net.URL;
import com.esprit.Utils.DataBase;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amenallah Lounis
 */
public class Interface_Note_ProfController implements Initializable {
    

    
    
  
          ObservableList combo = FXCollections.observableArrayList();
          ObservableList combo1 = FXCollections.observableArrayList();

    
      @FXML
    private Button btnajouter;

    @FXML
    private TextField cc;

    @FXML
    private TextField ds;

    @FXML
    private TextField examen;

      
    
     @FXML
    private TextField cinetd;

  

  @FXML
    private ComboBox<String> nommatiere;

    @FXML
    private Button btnmodifier;

    @FXML
    private Button btnsupprimer;

    @FXML
    private ComboBox<String> cmbliste;

    @FXML
    private ListView<?> listeetudients;

                private Connection con = DataBase.getInstance().getConnection();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
              try {
                  fillcombo();
                  fillcombo2();

              } catch (SQLException ex) {
                
              }
    }  
    ServiceNote sb = new ServiceNote();
    @FXML 
    private void nomm() throws SQLException 
    {}
    
     @FXML
    void Ajouter(ActionEvent event) throws SQLException {
        
        float cc1= parseFloat(cc.getText());
        float ds1= parseFloat(ds.getText());
        float examen1= parseFloat(examen.getText());
        
        int idetd1= parseInt(cinetd.getText());
        
        Note sn = new Note(cc1,ds1,examen1,0,0,idetd1, (String) nommatiere.getValue());
        
         sb.ajouter(sn);
         

    }





    @FXML
    void Modifier(ActionEvent event) throws SQLException { 
    
    }
    

    @FXML
    void Supprimer(ActionEvent event) {

    }
    
    
      @FXML
    void afficher(ActionEvent event) {
        
        
                // first I execute the query that select name of department one by one
//        resultSet = statement.executeQuery("Select num_class from classe");
//
//        while (resultSet.next()) {  // loop
//
//           // Now add the comboBox addAll statement 
//            cmbliste.getItems().addAll(resultSet.getString("num_classe")); 
       }

        public void fillcombo() throws SQLException {
        PreparedStatement pst;
        String query = "select nom_matier from matiere";
        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            combo.add(rs.getString("nom_matier"));
            nommatiere.setItems(combo);

        }

    }
        
         public void fillcombo2() throws SQLException {
        PreparedStatement pst;
        String query = "select num_classe from classe";
        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            combo1.add(rs.getString("num_classe"));
            cmbliste.setItems(combo1);

        }

    }
    }

    


