/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class absence {
     private int id_absence;
    private User id_etudiant;
    private Seance id_seance;
    private String type_absence;

    public absence(int id_absence, User id_etudiant, Seance id_seance, String type_absence) {
        this.id_absence = id_absence;
        this.id_etudiant = id_etudiant;
        this.id_seance = id_seance;
        this.type_absence = type_absence;
    }

    public absence(User id_etudiant, Seance id_seance, String type_absence) {
        this.id_etudiant = id_etudiant;
        this.id_seance = id_seance;
        this.type_absence = type_absence;
    }

    public absence() {
    }

    public absence(int id_absence, Seance s, User u, String type_absence) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   

    public void setId_absence(int id_absence) {
        this.id_absence = id_absence;
    }

    public void setType_absence(String type_absence) {
        this.type_absence = type_absence;
    }

    public void setId_etudiant(User id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public void setId_seance(Seance id_seance) {
        this.id_seance = id_seance;
    }

    public int getId_absence() {
        return id_absence;
    }

    public String getType_absence() {
        return type_absence;
    }

    public User getId_etudiant() {
        return id_etudiant;
    }

    public Seance getId_seance() {
        return id_seance;
    }

    @Override
    public String toString() {
        return "absence{" + "id_absence=" + id_absence + ", id_etudiant=" + id_etudiant + ", id_seance=" + id_seance + ", type_absence=" + type_absence + '}';
    }
 
    
}
