/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;



/**
 *
 * @author PC-HP
 */
public class Reclamation {

    private String sujet;
    private String description;
    private String etat;
    private String date_env;
    private String  date_rep;
    private int id_user;
    private int id_reclamation;
    private boolean sat;
    public String getId_user;

    public Reclamation( int id_reclamation,int id_user,String description,String etat,String sujet,String date_env, String date_rep) {
        
        this.id_reclamation=id_reclamation;
        this.id_user=id_user;
        this.description = description;
        this.etat=etat;
        this.sujet = sujet;
        this.date_env=date_env;
        this.date_rep=date_rep;
        
    }
     public Reclamation( int id_user,String description,String etat,String sujet,String date_env, String date_rep) {
        
        this.id_user=id_user;
        this.description = description;
        this.etat=etat;
        this.sujet = sujet;
        this.date_env=date_env;
        this.date_rep=date_rep;
        
    }

    public Reclamation(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   

    public String getSujet() {
        return sujet;
    }

    public String getDescription() {
        return description;
    }

    public String getEtat() {
        return etat;
    }

    public String getDate_env() {
        return date_env;
    }

    public String getDate_rep() {
        return date_rep;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDate_env(String date_env) {
        this.date_env = date_env;
    }

    public void setDate_rep(String date_rep) {
        this.date_rep = date_rep;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    @Override
    public String toString() {
        return "reclamation{" + "sujet=" + sujet + ", description=" + description + ", etat=" + etat + ", date_env=" + date_env + ", date_rep=" + date_rep + ", id_user=" + id_user + ", id_reclamation=" + id_reclamation + '}';
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public Reclamation(String sujet, String description, String etat, String date_env, String date_rep, int id_user, int id_reclamation, boolean sat) {
        this.sujet = sujet;
        this.description = description;
        this.etat = etat;
        this.date_env = date_env;
        this.date_rep = date_rep;
        this.id_user = id_user;
        this.id_reclamation = id_reclamation;
        this.sat = sat;
    }

  

   

   
}
