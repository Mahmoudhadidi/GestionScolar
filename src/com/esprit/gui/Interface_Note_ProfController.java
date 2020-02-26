/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Entite.User;
import com.esprit.Entite.listeetudiants;
import com.esprit.Service.ServiceNote;
import java.net.URL;
import com.esprit.Utils.DataBase;
//import java.awt.event.MouseEvent;
import javafx.scene.input.MouseEvent;


import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.management.Notification;
import javax.swing.JOptionPane;
import tray.notification.NotificationType;

import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Amenallah Lounis
 */
public class Interface_Note_ProfController implements Initializable {
    

    
    ServiceNote sn=new ServiceNote();
  
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

    private ComboBox<String> cmbliste;

    
    
    //les élements du tableview
     @FXML
    private TableView<listeetudiants> tableview;

    @FXML
    private TableColumn<listeetudiants, String> colcc;

    @FXML
    private TableColumn<listeetudiants, String> colds;

    @FXML
    private TableColumn<listeetudiants, String> colexamen;

    @FXML
    private TableColumn<listeetudiants, String> colcin;

    @FXML
    private TableColumn<listeetudiants, String> colmat;
    
    @FXML
    private TableColumn<listeetudiants, String> nom;

    @FXML
    private TableColumn<listeetudiants, String> prenom;
    @FXML
    private ComboBox<String> listeclasse;    
    @FXML
    private TableView<User> le;
    @FXML
    private TableColumn<User, String> n;
    @FXML
    private TableColumn<User, String> p;
    @FXML
    private TableColumn<User, Integer> c;

    public ObservableList<listeetudiants> show1()
    { 

           try {
               ObservableList<listeetudiants> obl =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                  PreparedStatement pt= con.prepareStatement("SELECT note_cc,note_ds,note_examun,note.cin,nom_matier ,nom ,prenom from note, user where note.cin=user.cin");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 listeetudiants ls = new listeetudiants();

                 ls.setA(rs.getString("note_cc")); 
                 ls.setB(rs.getString("note_ds"));
                 ls.setC(rs.getString("note_examun"));
                 ls.setD(rs.getInt("cin"));
                 ls.setE(rs.getString("nom_matier"));
                 ls.setF(rs.getString("nom"));
                 ls.setG(rs.getString("prenom"));
             

                  
                  System.out.println("heeeeeeeyyyyyy");
         obl.add(ls);
                  }
                  return obl;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    } 
 public ObservableList<User> showByClasse(int id_classe)
    { 

           try {
               ObservableList<User> ob2 =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                  PreparedStatement pt= con.prepareStatement("SELECT nom ,prenom, cin from user where id_classe="+id_classe);
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 User u=new User();

                 u.setNom(rs.getString("nom"));
                 u.setPrenom(rs.getString("prenom"));
                 u.setCin(rs.getInt("cin"));
              
             

                  
                  System.out.println("heeeeeeeiiiiyyyyyy");
         ob2.add(u);
                  }
                  return ob2;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    } 

    
     public void affichelistenomByclasse() throws SQLException {
        
           
                         
      //ajouter les valeurs au tableview
      n.setCellValueFactory(new PropertyValueFactory<>("nom"));
      p.setCellValueFactory(new PropertyValueFactory<>("prenom"));
      c.setCellValueFactory(new PropertyValueFactory<>("cin"));
      
            ObservableList<User> ob2 =FXCollections.observableArrayList();
 int n= sn.findidclassebyclasse(listeclasse.getSelectionModel().getSelectedItem().toString());
     // tableview.setItems(null);
     ob2= showByClasse(n);
      le.setItems(ob2);
      System.out.println("hemmm"+ob2);

                      
    }
    
    public void affichelistenote() {
        
           
                         
      //ajouter les valeurs au tableview
      colcc.setCellValueFactory(new PropertyValueFactory<>("A"));
      colds.setCellValueFactory(new PropertyValueFactory<>("B"));
      colexamen.setCellValueFactory(new PropertyValueFactory<>("C"));
      colcin.setCellValueFactory(new PropertyValueFactory<>("D"));
      colmat.setCellValueFactory(new PropertyValueFactory<>("E"));
      nom.setCellValueFactory(new PropertyValueFactory<>("F"));
      prenom.setCellValueFactory(new PropertyValueFactory<>("G"));
            ObservableList<listeetudiants> obl =FXCollections.observableArrayList();

     // tableview.setItems(null);
     obl=show1(); 
      tableview.setItems(obl);
      System.out.println("hemmm"+obl);

                      
    }
    
   
    
    //----------------------------------------
    

                private Connection con = DataBase.getInstance().getConnection();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
              try {
                  fillcombo();
                  fillcombo2();
               affichelistenote();
              } catch (SQLException ex) {
                
              }
    }  
    ServiceNote sb = new ServiceNote();
    @FXML 
    private void nomm() throws SQLException 
    {}
    
     @FXML
    void Ajouter(ActionEvent event) throws SQLException {
        
         //notice
        String title = "Notification";
        String message = "Vous avez ajouté la note avec succés";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
        
        if (cc.getText().equals("") && ds.getText().equals("")){
            
            JOptionPane.showMessageDialog(null, "champs vides !!");
        
        }
        
        if (cc.getText().contains(" ") && ds.getText().contains(" ")){
            
            JOptionPane.showMessageDialog(null, "Espaces interdit !!");
        
        }
        
        float cc1= parseFloat(cc.getText());
        float ds1= parseFloat(ds.getText());
        float examen1= parseFloat(examen.getText());
        
        int idetd1= parseInt(cinetd.getText());
        
        Note sn = new Note(cc1,ds1,examen1,0,0,idetd1, (String) nommatiere.getValue());
        
         sb.ajouter(sn);
             affichelistenote();
           
       cc.clear();
       ds.clear();
       examen.clear();
       

    }





    @FXML
    void Modifier(ActionEvent event) throws SQLException { 
         //notice
        String title = "Notification";
        String message = "Vous avez modifier la note avec succés";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
        
        
        ServiceNote sn = new ServiceNote();
        listeetudiants ls ;
    ls=tableview.getSelectionModel().getSelectedItem();
    ls.setA(cc.getText());
    ls.setB(ds.getText());
    ls.setC(examen.getText());
    sn.Modifier(ls);
    affichelistenote();


                
    
    
    }
    

    @FXML
    void Supprimer(ActionEvent event) throws SQLException {
        
        //notice
        String title = "Notification";
        String message = "Vous avez supprimé la note avec succés";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
    
        
    ServiceNote n = new ServiceNote();
    listeetudiants ls = new listeetudiants();
    ls=tableview.getSelectionModel().getSelectedItem();
    n.supprimer(ls.getD());
    affichelistenote();
        
    }
    
    
      @FXML
    void afficher(ActionEvent event) throws SQLException {
        
        affichelistenomByclasse();
        
        
                // first I execute the query that select name of department one by one
//        resultSet = statement.executeQuery("Select num_class from classe");
//
//        while (resultSet.next()) {  // loop
//
//           // Now add the comboBox addAll statement 
//            cmbliste.getItems().addAll(resultSet.getString("num_classe")); 
       }
       @FXML
    void editer(MouseEvent event) {
  if (event.getClickCount() > 0) {
        onEdita();}
    
    }
    public void onEdita() {
    // check the table's selected item and get selected item
    if (tableview.getSelectionModel().getSelectedItem() != null) {
        listeetudiants ls = tableview.getSelectionModel().getSelectedItem();
        cc.setText(ls.getA());
        ds.setText(ls.getB());
        examen.setText(ls.getC());
        nommatiere.setValue(ls.getE());
    }
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
            listeclasse.setItems(combo1);

        }

    }
         
    }

    


