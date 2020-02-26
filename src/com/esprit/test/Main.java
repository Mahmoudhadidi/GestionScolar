/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

/**
 *
 * @author hadidi
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private static Stage stage;
	
	public void start(Stage primaryStage) {
		try {
			setStage(primaryStage);
			primaryStage.setTitle("login");
			
 			Parent root = (AnchorPane)FXMLLoader.load(getClass()
                                
                                
                                //      .getResource("/com/esprit/gui/Statistics.fxml"));
                                       //  .getResource("/com/esprit/gui/Consultation_note.fxml"));
 				
                                        //    .getResource("/com/esprit/gui/Interface_Note_Prof.fxml"));
                                  //        .getResource("/com/esprit/gui/Interface_Note_Administrateur.fxml"));
					.getResource("/com/esprit/gui/login.fxml"));

			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("/view/MainStyle.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Main.stage = stage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}

