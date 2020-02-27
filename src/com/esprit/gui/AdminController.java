/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

//import com.esprit.test.Email;

import com.esprit.Entite.Admin;
//import com.esprit.test.send
import com.esprit.Entite.Reclamation;
import com.esprit.Entite.User;
import com.esprit.Utils.DataBase;
import com.esprit.Service.ServiceReclamation;
import com.esprit.test.SendEmail;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author PC-HP
 */
public class AdminController implements Initializable {
     ServiceReclamation serviceReclamation=new ServiceReclamation();

    @FXML
    private TableView<Admin> tabAdmin;


   
    private Parent rootnewLoadedPane;
    @FXML
    private TableColumn<Admin, String> a;
    @FXML
    private TableColumn<Admin, String> b;
    @FXML
    private TableColumn<Admin, String> c;
    @FXML
    private TableColumn<Admin, String> d;
    @FXML
    private TableColumn<Admin, String> e;
    @FXML
    public TextField repo;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     //   afficheliste();
        
    } 
//    @FXML
//    private void envoyerEmail(ActionEvent event) throws SQLException, IOException {
//        
//      System.out.println(repo.getText());
//        
//    }
//    
   @FXML
public void Send(ActionEvent event) {
    SendEmail m = new SendEmail();
    m.sendEmail("mariem.romdhani@esprit.tn", "Réponse reclamation", repo.getText());
       Notifications notificationBuilder=Notifications.create()
    .title("Réponse envoyée").text("vous avez envoyé une reclamation").position(Pos.TOP_RIGHT);
           notificationBuilder.show();
        

    
    }
   
    
    

//    private void btnrep(ActionEvent event) throws SQLException, IOException {
//        
//       AnchorPane newLoadedPane=FXMLLoader.load(getClass().getResource("Repondre.fxml"));
//        Scene sceneview = new Scene(rootnewLoadedPane);
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(sceneview);
//        window.show();
//
//        
//      
//    }
    
    private Connection con = DataBase.getInstance().getConnection();
    
    @FXML
    
    public ObservableList<Admin> show1()
    { 

           try {
               ObservableList<Admin> obl =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                  PreparedStatement pt= con.prepareStatement("SELECT user.nom,user.prenom,sujet,description,date_env from reclamation,user where reclamation.id_user=user.id_user");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 Admin ls = new Admin();

                 ls.setAa(rs.getString("nom")); 
                 ls.setBb(rs.getString("prenom"));
                 ls.setCc(rs.getString("sujet"));
                 ls.setDd(rs.getString("description"));
                 ls.setEe(rs.getString("date_env"));
                 
             

                  
                  System.out.println("ok");
         obl.add(ls);
                  }
                  return obl;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    } 

    
    
    public void afficheliste() {
        
           
                         
      //ajouter les valeurs au tableview
      a.setCellValueFactory(new PropertyValueFactory<>("aa"));
      b.setCellValueFactory(new PropertyValueFactory<>("bb"));
      c.setCellValueFactory(new PropertyValueFactory<>("cc"));
      d.setCellValueFactory(new PropertyValueFactory<>("dd"));
      e.setCellValueFactory(new PropertyValueFactory<>("ee"));
      
            ObservableList<Admin> obl =FXCollections.observableArrayList();

     // tableview.setItems(null);
     obl=show1(); 
      tabAdmin.setItems(obl);
      System.out.println("hemmm"+obl);

                      
    }
  
//     public void afficher(){
//        nom.setCellValueFactory(new PropertyValueFactory<User,String>("nom"));
//         prenom.setCellValueFactory(new PropertyValueFactory<User,String>("prenom"));
//         sujet.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("sujet"));
//         description.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("description"));
//         date.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("date"));
//         try    {
//                      tableStage.getItems().setAll(serviceReclamation.readAll());
//         } 
//         catch(SQLException ex){
//            
//         }
//    }
  
}


