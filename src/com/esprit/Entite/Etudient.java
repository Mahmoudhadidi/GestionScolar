/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author hadidi
 */
public class Etudient {
    String nom;
    String prenom;
    String date_naissance;
    int cin;
    String adresse;

    public Etudient(String nom, String prenom, String date_naissance, int cin, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.cin = cin;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public int getCin() {
        return cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Etudient{" + "nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", cin=" + cin + ", adresse=" + adresse + "}\n";
    }
    
    
}
