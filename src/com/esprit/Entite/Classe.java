/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import javafx.scene.control.Button;

/**
 *
 * @author hadidi
 */
public class Classe {
    
    int id;
    String num;
    int nbrEtudient;
    String specialite;
    private final Button btnSupprimer = new Button("Supprimer");
    private final Button btnModifier = new Button("Modifer");

    public Classe(String num) {
        this.num = num;
    }
   

    public Button getBtnSupprimer() {
        
        return btnSupprimer;
    }

    public Button getBtnModifier() {
        return btnModifier;
    }

    
    public Classe(int id) {
        this.id = id;
    }

    public Classe(String num, int nbrEtudient, String specialite) {
        this.num = num;
        this.nbrEtudient = nbrEtudient;
        this.specialite = specialite;
    }

    public Classe(int id, String num) {
        this.id = id;
        this.num = num;
    }

    public Classe(int id, String num, int nbrEtudient, String specialite) {
        this.id = id;
        this.num = num;
        this.nbrEtudient = nbrEtudient;
        this.specialite = specialite;
    }

    public Classe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public int getNbrEtudient() {
        return nbrEtudient;
    }

    @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", num=" + num + ", nbrEtudient=" + nbrEtudient + ", specialite=" + specialite + ", btnSupprimer=" + btnSupprimer + ", btnModifier=" + btnModifier + '}';
    }

   

    public String getSpecialite() {
        return specialite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setNbrEtudient(int nbrEtudient) {
        this.nbrEtudient = nbrEtudient;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

   /* @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", num=" + num + ", nbrEtudient=" + nbrEtudient + ", specialite=" + specialite + "}\n";
    } */
    
}
