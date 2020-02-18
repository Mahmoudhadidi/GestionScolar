/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author LENOVO
 */
public class absence_employe {
     private int id_absence_e;
     private String type_absence;
     private User id_employe;
    private String date;

    public absence_employe(int id_absence_e, String type_absence, User id_employe, String date) {
        this.id_absence_e = id_absence_e;
        this.type_absence = type_absence;
        this.id_employe = id_employe;
        this.date = date;
    }

    public absence_employe(String type_absence, User id_employe, String date) {
        this.type_absence = type_absence;
        this.id_employe = id_employe;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public absence_employe() {
    }

    public int getId_absence_e() {
        return id_absence_e;
    }

    public String getType_absence() {
        return type_absence;
    }

    public User getId_employe() {
        return id_employe;
    }

    public void setId_absence_e(int id_absence_e) {
        this.id_absence_e = id_absence_e;
    }

    public void setType_absence(String type_absence) {
        this.type_absence = type_absence;
    }

    public void setId_employe(User id_employe) {
        this.id_employe = id_employe;
    }

    @Override
    public String toString() {
        return "absence_employe{" + "id_absence_e=" + id_absence_e + ", type_absence=" + type_absence + ", id_employe=" + id_employe + ", date=" + date + '}';
    }

    public int stat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
