/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import javafx.scene.control.Button;

/**
 *
 * @author House
 */
public class Matiere {
    private int id;
    private String nom;
    private int coefficient;
    private int credit;
<<<<<<< HEAD
      private final Button btn = new Button("Supprimer");

    public Button getBtn() {
        return btn;
=======

    public Matiere(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Matiere(String nom) {
        this.nom = nom;
>>>>>>> ffca43c373411410981efe44bdcefda06fb7f73f
    }
    
    public Matiere(int id, String nom, int coefficient, int credit) {
        this.id = id;
        this.nom = nom;
        this.coefficient = coefficient;
        this.credit = credit;
    }

    public Matiere(int id) {
        this.id = id;
    }
    

    public Matiere(String nom, int coefficient, int credit) {
        this.nom = nom;
        this.coefficient = coefficient;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getCredit() {
        return credit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

   

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    @Override
    public String toString() {
        return " Matiere{" + "id=" + id + ", nom=" + nom + ", coefficient=" + coefficient + ", credit=" + credit + "}\n";
    }

    
}
