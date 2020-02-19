/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.DemandeClub;
import com.esprit.Entite.Club;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ServiceUser_1 {
    
    private final Connection con;
    private Statement ste;

    public ServiceUser_1() {
        con = DataBase.getInstance().getConnection();

    }
    

   
    
}
