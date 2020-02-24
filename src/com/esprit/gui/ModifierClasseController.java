/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Classe;
import com.esprit.Service.ServiceClasse;
import com.esprit.Utils.DataBase;
import com.esprit.test.Main;
import java.io.IOException;
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
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    Parent root;

    @FXML
    void fannuler(ActionEvent event) throws IOException {

    		root = (AnchorPane)FXMLLoader.load(getClass()
  				.getResource("/com/esprit/gui/accueil.fxml"));

        	    	Main.getStage().getScene().setRoot(root);
        	    	Main.getStage().setTitle("Manipulation Interface");
 		Main.getStage().getScene().getStylesheets().add(getClass().getResource("/view/ServiceSalle.css").toExternalForm());
           	
    }
private Connection con;
    private Statement ste;

    public ModifierClasseController() {
        con = DataBase.getInstance().getConnection();

    }
    
     ServiceClasse serC= new ServiceClasse();
    @FXML
    void moudifier(ActionEvent event) throws SQLException, IOException {
          Classe c1=new Classe(GestionClasseController.fakhrimalem,nomClasse.getText(),Integer.valueOf(nbrEtudiant.getText()),specialite.getText());
         serC.update(c1);
          Alert aler = new Alert(Alert.AlertType.INFORMATION);
    			aler.setContentText("Classe bien modifier");
    			aler.show();
          root = (AnchorPane)FXMLLoader.load(getClass()
				.getResource("/com/esprit/gui/accueil.fxml"));

        
        	Main.getStage().getScene().setRoot(root);
    	    	Main.getStage().setTitle("Modifier Classe");
                Main.getStage().getScene().getStylesheets().add(getClass().getResource("/com/esprit/gui/accueil.fxml").toExternalForm());
    }
    public List<Classe> remplierModif() throws SQLException{
      
        List<Classe> listeClasse=new ArrayList<>();
        String num = null;
        String bloc = null;
        ste=con.createStatement();
        
         ResultSet rs = null;
         System.out.println(GestionClasseController.fakhrimalem + "static");
         rs = ste.executeQuery("select * from classe where id_classe='"+GestionClasseController.fakhrimalem+"'");
          while (rs.next()) {
                int id=rs.getInt(1);
                 num=rs.getString(2);
                int nom=rs.getInt(3);
                 bloc=rs.getString(4);
                Classe c1=new Classe(GestionClasseController.fakhrimalem,num,nom,bloc);
                  listeClasse.add(c1);
                    } 
       
         
         
         
   return listeClasse;
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String nom = null, nbr = null,sb = null;
        try {
            List<Classe> list=remplierModif();
            nom =list.get(0).getNum();
            
            int nb= list.get(0).getNbrEtudient();
            nbr=String.valueOf(nb);
            sb  =list.get(0).getSpecialite();
        
                
        } catch (SQLException ex) {
            Logger.getLogger(ModifierClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
                nomClasse.setText(nom);
                nbrEtudiant.setText(nbr);
        
                specialite.setText(sb);
    }    
    
}
