/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Utils.DataBase;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hadidi
 */
public class ModifierClasseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField nomClasse;

    @FXML
    private TextField nbrEtudiant;

    @FXML
    private TextField specialite;

    @FXML
    private Button annuler;

    @FXML
    private Button ajouter;

    @FXML
    void fannuler(ActionEvent event) {

    }
private Connection con;
    private Statement ste;

    public ModifierClasseController() {
        con = DataBase.getInstance().getConnection();

    }
    @FXML
    void moudifier(ActionEvent event) throws SQLException {
        
        

    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ModifierClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    ResultSet rs = null;
        try {
            rs = ste.executeQuery("select * from classe where id='"+GestionClasseController.fakhrimalem+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ModifierClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                int id=rs.getInt(1);
                String num=rs.getString(2);
                int nom=rs.getInt(3);
                String bloc=rs.getString(4);
                nomClasse.setText(num);
                nbrEtudiant.setText(num.toString());
                specialite.setText(bloc);
            }  } catch (SQLException ex) {
            Logger.getLogger(ModifierClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
