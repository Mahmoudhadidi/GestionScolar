/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Utils.DataBase;
import com.esprit.Utils.pdf1;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Amenallah Lounis
 */
public class Consultation_noteController implements Initializable {

    @FXML
    private Button btnaffiche;
    @FXML
    private TableView<Note> table;
    @FXML
    private TableColumn<Note, Float> cc;
    @FXML
    private TableColumn<Note, Float> ds;
    @FXML
    private TableColumn<Note, Float> examen;
    @FXML
    private TableColumn<Note, Float> moy;
    @FXML
    private TableColumn<Note, String> mat;
    @FXML
    private TextField cin;
    @FXML
    private Button extraire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public ObservableList<Note>look(int cin) throws SQLException
    {        Connection con=DataBase.getInstance().getConnection();
           ObservableList<Note>data= FXCollections.observableArrayList();
        PreparedStatement pt = con.prepareStatement("select note_cc, note_ds, note_examun, moyenne, nom_matier from note where cin='"+cin+"'");
    ResultSet rs=pt.executeQuery();
    while (rs.next())
    { Note n = new Note();
    n.setNote_cc(rs.getFloat("note_cc"));
    n.setNote_ds(rs.getFloat("note_ds"));
    n.setNote_examun(rs.getFloat("note_examun"));
    n.setMoyenne(rs.getFloat("moyenne"));
    n.setId_matiere(rs.getString("nom_matier"));
    data.add(n);
    

    }
    return data;
        }

    @FXML
    private void aficher(ActionEvent event) throws SQLException {
        
         //notice
        String title = "Notification";
        String message = "Votre rélevé des notes";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
         
              
        
        cc.setCellValueFactory(new PropertyValueFactory<>("note_cc"));
        ds.setCellValueFactory(new PropertyValueFactory<>("note_ds"));
        examen.setCellValueFactory(new PropertyValueFactory<>("note_examun"));
        moy.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        mat.setCellValueFactory(new PropertyValueFactory<>("id_matiere"));           
           
       String x =cin.getText();
              int x1=parseInt(x);
             table.setItems(look(x1));
    }

    @FXML
    private void extraire(ActionEvent event) throws DocumentException, BadElementException, IOException, FileNotFoundException, InterruptedException, SQLException {
        pdf1 p = new pdf1();
        p.GeneratePdf("relevédenote.pdf");
    }
    
}
