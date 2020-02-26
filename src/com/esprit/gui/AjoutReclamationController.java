/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;
import com.esprit.Entite.Reclamation;
import com.esprit.Utils.DataBase;
import com.esprit.Service.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author PC-HP
 */
public class AjoutReclamationController implements Initializable {
ServiceReclamation serviceReclamation=new ServiceReclamation();
    @FXML
    private AnchorPane content;
    @FXML
    private Rectangle rec;
    @FXML
    private TextArea desc1;
    @FXML
    private TextField sujet1;
    @FXML
    private Button btnenvoyer1;
    @FXML
    private Tab ajouter_rec;

    @FXML
    private Tab consulter_rec;
    private ObservableList<Reclamation> obl;
       
     @FXML
    private TableView<Reclamation> cons;

    @FXML
    private TableColumn<Reclamation,String> sujetR;

    @FXML
    private TableColumn<Reclamation,String> descR;

    @FXML
    private TableColumn<Reclamation,String> date1R;

    @FXML
    private TableColumn<Reclamation,String> etat;
    private List<Reclamation> reclamation;
     @FXML
   
    private Object Sujet;

 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
        affiche();
        
//    sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
//    description.setCellValueFactory(new PropertyValueFactory<>("description"));
//    date_e.setCellValueFactory(new PropertyValueFactory<>("date_env"));
//    etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
//
//    tablerec.setItems(getRec());
//       
//    }
//
//       
//        // TODO
    } catch (SQLException ex) {
        Logger.getLogger(AjoutReclamationController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(AjoutReclamationController.class.getName()).log(Level.SEVERE, null, ex);
    }
   }    

    @FXML
    private void envoyer1(ActionEvent event) throws SQLException, IOException {
        
        
        
        Reclamation reclamation=new Reclamation();
        reclamation.setSujet(sujet1.getText());
        reclamation.setDescription(desc1.getText());
        serviceReclamation.ajouter(reclamation);
        AnchorPane newLoadedPane=FXMLLoader.load(getClass().getResource("TableView.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);
           Notifications notificationBuilder=Notifications.create()
    .title("Reclamation ajouté").text("vous avez ajouté une reclamation").position(Pos.TOP_RIGHT);
           notificationBuilder.show();
        
        
    }
    private Connection con= DataBase.getInstance().getConnection();
    
       public ObservableList<Reclamation> show1()
    { 

           try {
               ObservableList<Reclamation> obl =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                  PreparedStatement pt= con.prepareStatement("SELECT description,sujet,etat,date_env fROM `reclamation` WHERE id_user=0");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 Reclamation ls = new Reclamation();

                 ls.setSujet(rs.getString("sujet")); 
                 ls.setDescription(rs.getString("description"));
                 ls.setDate_env(rs.getString("date_env"));
                 ls.setEtat(rs.getString("etat"));
                

                  
                 
         obl.add(ls);
                  }
                  return obl;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    }
    
    public void affiche()  throws SQLException, IOException{
    
    //ajouter les valeurs au tableview
      sujetR.setCellValueFactory(new PropertyValueFactory<>("sujet"));
      descR.setCellValueFactory(new PropertyValueFactory<>("description"));
      date1R.setCellValueFactory(new PropertyValueFactory<>("date_env"));
      etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
     
            ObservableList<Reclamation> obl =FXCollections.observableArrayList();

     // tableview.setItems(null);
      obl=show1(); 
      cons.setItems(obl);
      System.out.println("done");
    
    
    }
    
 
}
 
    
                
        

