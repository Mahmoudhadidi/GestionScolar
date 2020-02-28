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
public class listabsence {
    private String nom,prenom,type_absence,date;
   private int id_employe;
   private User empl;

    public listabsence(String type_absence, String date, User empl) {
        this.type_absence = type_absence;
        this.date = date;
        this.empl = empl;
    }
   

    public listabsence(String nom, String prenom, String type_absence, String date, int id_employe) {
        this.nom = nom;
        this.prenom = prenom;
        this.type_absence = type_absence;
        this.date = date;
        this.id_employe = id_employe;
    }

    public listabsence() {
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getType_absence() {
        return type_absence;
    }

    public String getDate() {
        return date;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setType_absence(String type_absence) {
        this.type_absence = type_absence;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    @Override
    public String toString() {
        return "listabsence{" + "nom=" + nom + ", prenom=" + prenom + ", type_absence=" + type_absence + ", date=" + date + ", id_employe=" + id_employe + '}';
    }
   

  
}
