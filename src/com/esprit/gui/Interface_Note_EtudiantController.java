/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Utils.DataBase;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Amenallah Lounis
 */
public class Interface_Note_EtudiantController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private Button btnconsulter;
    @FXML
    private TextField consulter;
     @FXML
    private TableView<Note> tablenote;

    @FXML
    private TableColumn<Note, Float> colcc;

    @FXML
    private TableColumn<Note, Float> colds;

    @FXML
    private TableColumn<Note, Float> colexamen;

    @FXML
    private TableColumn<Note, Float> colmoyenne;

    @FXML
    private TableColumn<Note, String> colnommatier;

    private ObservableList<Note> data;
    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
   
  public  ObservableList<Note>look(int cin) throws SQLException
    {        Connection con=DataBase.getInstance().getConnection();
           ObservableList<Note>data= FXCollections.observableArrayList();
        PreparedStatement pt = con.prepareStatement("select note_cc, note_ds, note_examun, moyenne, note.nom_matier from note,user,matiere where note.nom_matier = matiere.nom_matier and note.cin = user.cin and note.cin='"+cin+"'");
      
        ResultSet rs=pt.executeQuery();
    while (rs.next())
    { Note n = new Note();
    n.setNote_cc(rs.getFloat("note_cc"));
    n.setNote_ds(rs.getFloat("note_ds"));
    n.setNote_examun(rs.getFloat("note_examun"));
    n.setMoyenne(rs.getFloat("moyenne"));
    n.setId_matiere("nom_matier");
    data.add(n);
    

    }
    return data;
        }
     @FXML
    private void display(ActionEvent event) throws SQLException {
            String x =consulter.getText();
             int x1=parseInt(x);
             
        
        colcc.setCellFactory(new PropertyValueFactory<>("note_cc"));
        colds.setCellFactory(new PropertyValueFactory<>("note_ds"));
        colexamen.setCellFactory(new PropertyValueFactory<>("note_examun"));
        colmoyenne.setCellFactory(new PropertyValueFactory<>("moyenne"));
        colnommatier.setCellFactory(new PropertyValueFactory<>("nom_matier"));           
           
      
             tablenote.setItems(look(x1));
    }
    
}
