/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.absence;
import com.esprit.Utils.DataBase;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    private ComboBox<?> type1;
    
    
    
    
    
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
               String type_absence=rs.getString(4);
                 bloc=rs.getString(4);
                absence c1=new absence(id_s,AbsenceEtudientController.id,type_absence);
                  listeSalle.add(c1);
                    } 
         return listeSalle;
      }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void retourr(ActionEvent event) {
    }
    
}
