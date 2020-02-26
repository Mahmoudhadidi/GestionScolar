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
public class listabsence1 {
     private String nom,prenom,type_absence;
      private int id_etudiant,id_seance;

    public listabsence1() {
    }

    @Override
    public String toString() {
        return "listabsence1{" + "nom=" + nom + ", prenom=" + prenom + ", type_absence=" + type_absence + ", id_etudiant=" + id_etudiant + ", id_seance=" + id_seance + '}';
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

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
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

    public int getId_etudiant() {
        return id_etudiant;
    }

    public int getId_seance() {
        return id_seance;
    }

    public listabsence1(String nom, String prenom, String type_absence, int id_etudiant, int id_seance) {
        this.nom = nom;
        this.prenom = prenom;
        this.type_absence = type_absence;
        this.id_etudiant = id_etudiant;
        this.id_seance = id_seance;
    }
  
    
}
