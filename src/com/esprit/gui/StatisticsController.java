/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Service.ServiceNote;
import com.esprit.Utils.DataBase;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Amenallah Lounis
 */
public class StatisticsController implements Initializable {

    Connection con= DataBase.getInstance().getConnection();
    ServiceNote sr = new ServiceNote();
    @FXML
    private BarChart<String, Float> barChart;
    @FXML
    private AnchorPane col;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chart();

        // TODO
    }   
    public void chart(){
           
            String req =" SELECT nom_matier, AVG(moyenne)  from note order by nom_matier desc";
        XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();
        try {
             PreparedStatement ste = (PreparedStatement) con.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getFloat(2)));
            }
            barChart.getData().add(series);
        } catch (SQLException ex) {
           Logger.getLogger(StatisticsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
