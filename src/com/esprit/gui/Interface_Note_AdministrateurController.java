/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Entite.listeetudiants;
import com.esprit.Service.ServiceMoyenne;
import com.esprit.Utils.DataBase;
import static java.lang.Float.parseFloat;
import java.net.URL;
import java.sql.ResultSet;



import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
public class Interface_Note_AdministrateurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
   

      @FXML
    private Button btncalculer;
    
     @FXML
    private TableView<listeetudiants> tableview;

    @FXML
    private TableColumn<?, ?> colcc;

    @FXML
    private TableColumn<?, ?> colds;

    @FXML
    private TableColumn<?, ?> colexamen;

    @FXML
    private TableColumn<?, ?> colmoy;

    @FXML
    private TableColumn<?, ?> colnet;

    @FXML
    private TableColumn<?, ?> colcin;

    @FXML
    private TableColumn<?, ?> colmat;

    @FXML
    private TextField taux1;

    @FXML
    private TextField taux2;

    @FXML
    private TextField taux3;

    @FXML
    private TextField nom_mat;
                                private Connection con = DataBase.getInstance().getConnection();


    @FXML

    void calculer(ActionEvent event) throws SQLException {
        //notice
        String title = "Notification";
        String message = "Moyenne Matiére calculée";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
        
  ServiceMoyenne se = new ServiceMoyenne();
      
        
        String t1 = taux1.getText();
        String t2 = taux2.getText();
        String t3 = taux3.getText();
       
        float taux11=parseFloat(t1);
        float taux22=parseFloat(t2);
        float taux33=parseFloat(t3);
        String mat = nom_mat.getText();
      
           PreparedStatement  pst1;

         pst1 =con.prepareStatement("select note_cc, note_ds,note_examun  from note where nom_matier='"+mat+"'");
            
            ResultSet rs= pst1.executeQuery();
            while (rs.next()){
             Note a=new Note();
             Float x =  rs.getFloat("note_cc");
             a.setNote_cc(rs.getFloat("note_cc"));
            Float y = rs.getFloat("note_ds");
            a.setNote_ds(rs.getFloat("note_ds"));
            Float z = rs.getFloat("note_examun");

            a.setNote_examun(rs.getFloat("note_examun"));
            System.out.println("NOTES"+x+y+z);
            float t= taux11*x+taux22*y+taux33*z;
            System.out.println("Moyenne"+t);
             a.setMoyenne(t);
             float pp = a.getMoyenne();
           System.out.println("mat"+mat);             
             a.setId_matiere(mat);
             a.setNote_cc(x);
             a.setNote_ds(y);
             a.setNote_examun(z);
             se.CalculeMoyenneMatiere(a);

            }
         System.out.println("Moyenne Matière calculé");

      
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       affiche();
    } 
    
    
     public ObservableList<listeetudiants> show1()
    { 

           try {
               ObservableList<listeetudiants> obl =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                  PreparedStatement pt= con.prepareStatement("SELECT DISTINCT note_cc,note_ds,note_examun,note.moyenne,net, note.cin, matiere.nom_matier from note, user, matiere");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 listeetudiants ls = new listeetudiants();

                 ls.setA(rs.getString("note_cc")); 
                 ls.setB(rs.getString("note_ds"));
                 ls.setC(rs.getString("note_examun"));
                 ls.setD(rs.getInt("moyenne"));
                 ls.setE(rs.getString("net"));
                 ls.setF(rs.getString("cin"));
                 ls.setG(rs.getString("nom_matier"));
             

                  
                  System.out.println("heeeeeeeyyyyyy");
         obl.add(ls);
                  }
                  return obl;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    } 

    private void affiche() {
   
         //ajouter les valeurs au tableview
      colcc.setCellValueFactory(new PropertyValueFactory<>("A"));
      colds.setCellValueFactory(new PropertyValueFactory<>("B"));
      colexamen.setCellValueFactory(new PropertyValueFactory<>("C"));
      colmoy.setCellValueFactory(new PropertyValueFactory<>("D"));
      colnet.setCellValueFactory(new PropertyValueFactory<>("E"));
      colcin.setCellValueFactory(new PropertyValueFactory<>("F"));
      colmat.setCellValueFactory(new PropertyValueFactory<>("G"));
            ObservableList<listeetudiants> obl =FXCollections.observableArrayList();

     // tableview.setItems(null);
     obl=show1(); 
      tableview.setItems(obl);
      System.out.println("hemmm"+obl);
        
    }
    
}
