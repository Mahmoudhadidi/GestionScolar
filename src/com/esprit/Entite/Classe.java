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
public class Classe {
    int id;
    String num;
    int nbrEtudient;
    String specialite;

    public Classe(int id) {
        this.id = id;
    }

    public Classe(String num, int nbrEtudient, String specialite) {
        this.num = num;
        this.nbrEtudient = nbrEtudient;
        this.specialite = specialite;
    }

    public Classe(int id, String num, int nbrEtudient, String specialite) {
        this.id = id;
        this.num = num;
        this.nbrEtudient = nbrEtudient;
        this.specialite = specialite;
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

    @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", num=" + num + ", nbrEtudient=" + nbrEtudient + ", specialite=" + specialite + "}\n";
    } 
    
}