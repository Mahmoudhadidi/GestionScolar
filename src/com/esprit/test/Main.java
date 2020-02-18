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

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private static Stage stage;
	
        @Override
	public void start(Stage primaryStage) {
		try {
			setStage(primaryStage);

			primaryStage.setTitle("logine");

			primaryStage.setTitle("");

			
 			Parent root = (AnchorPane)FXMLLoader.load(getClass()
 					.getResource("/com/esprit/gui/login.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("/view/MainStyle.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(IOException e) {
		}
	}
/*	User u = new User();
        u.setId("");
        abs.setIdUser(u)*/
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

