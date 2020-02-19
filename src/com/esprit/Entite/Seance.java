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
public class Seance {
    int id_Seance;
    int id_Ens;
    int id_Classe;
    int id_Matiere;
    int id_Salle;
    String duree;
    String heure;
    String date;
      private final Button btn = new Button("Supprimer");

    public Button getBtn() {
        return btn;
    }

    public Seance(int id_Seance, int id_Ens, int id_Classe, int id_Matiere, int id_Salle, String duree, String heure, String date) {
        this.id_Seance = id_Seance;
        this.id_Ens = id_Ens;
        this.id_Classe = id_Classe;
        this.id_Matiere = id_Matiere;
        this.id_Salle = id_Salle;
        this.duree = duree;
        this.heure = heure;
        this.date = date;
    }

    public Seance(int id_Ens, int id_Classe, int id_Matiere, int id_Salle, String duree, String heure, String date) {
        this.id_Ens = id_Ens;
        this.id_Classe = id_Classe;
        this.id_Matiere = id_Matiere;
        this.id_Salle = id_Salle;
        this.duree = duree;
        this.heure = heure;
        this.date = date;
    }

    public Seance(int id_Seance) {
        this.id_Seance = id_Seance;
    }

    public int getId_Seance() {
        return id_Seance;
    }

    public int getId_Ens() {
        return id_Ens;
    }

    public int getId_Classe() {
        return id_Classe;
    }

    public int getId_Matiere() {
        return id_Matiere;
    }

    public int getId_Salle() {
        return id_Salle;
    }

    public String getDuree() {
        return duree;
    }

    public String getHeure() {
        return heure;
    }

    public String getDate() {
        return date;
    }

    public void setId_Seance(int id_Seance) {
        this.id_Seance = id_Seance;
    }

    public void setId_Ens(int id_Ens) {
        this.id_Ens = id_Ens;
    }

    public void setId_Classe(int id_Classe) {
        this.id_Classe = id_Classe;
    }

    public void setId_Matiere(int id_Matiere) {
        this.id_Matiere = id_Matiere;
    }

    public void setId_Salle(int id_Salle) {
        this.id_Salle = id_Salle;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Seance{" + "id_Seance=" + id_Seance + ", id_Ens=" + id_Ens + ", id_Classe=" + id_Classe + ", id_Matiere=" + id_Matiere + ", id_Salle=" + id_Salle + ", duree=" + duree + ", heure=" + heure + ", date=" + date + "}\n";
    }
    
    
}
