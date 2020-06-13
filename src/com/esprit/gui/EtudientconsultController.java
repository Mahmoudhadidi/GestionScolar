/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.listabsence1;
import com.esprit.Service.ServiceAbsence;
import com.esprit.Service.ServiceUser;
import com.esprit.Utils.DataBase;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class EtudientconsultController implements Initializable {

    @FXML
    private Button retour;
  @FXML
    private TableView<listabsence1> tabPoint;
    @FXML
    private TableColumn<listabsence1, Integer> ide;
    @FXML
    private TableColumn<listabsence1, String> nom;
    @FXML
    private TableColumn<listabsence1, String> pre;
    @FXML
    private TableColumn<listabsence1, String> type;
    @FXML
    private TableColumn<listabsence1, Integer> ids;
    ServiceAbsence s = new ServiceAbsence();
     private final Connection con = DataBase.getInstance().getConnection();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affichelisteabsence();
    }    

    @FXML
    private void retour(ActionEvent event) {
    }
    

      public void affichelisteabsence(){
             //mettre les données dans la table view:
             nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
             pre.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            type.setCellValueFactory(new PropertyValueFactory<>("type_absence"));
            ids.setCellValueFactory(new PropertyValueFactory<>("id_seance"));
       ObservableList<listabsence1> listu  = FXCollections.observableArrayList();
       listu=show();
       tabPoint.setItems(listu);
    }
 public ObservableList<listabsence1> show()
    { 

           try {
               ObservableList<listabsence1> listu =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                  PreparedStatement pt= con.prepareStatement("SELECT absence.id_etudiant,nom,prenom,absence.type_absence,absence.id_seance FROM user,seance,absence where absence.id_etudiant='"+ServiceUser.id_user_conecte+"' AND absence.id_seance=seance.id_seance");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 listabsence1 ls = new listabsence1();

                 ls.setId_etudiant(rs.getInt("id_etudiant"));
                 ls.setNom(rs.getString("nom"));
                 ls.setPrenom(rs.getString("prenom"));
                 ls.setType_absence(rs.getString("type_absence")); 
                 ls.setId_seance(rs.getInt("id_seance"));
             

                  
                 
         listu.add(ls);
                  }
                  return listu;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    }
}