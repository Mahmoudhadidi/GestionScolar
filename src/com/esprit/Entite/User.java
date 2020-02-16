/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author techouse
 */
public class User {
   private int id;
   private String logine;
   private String mdp;
   private String role;
   private int id_classe;
   private String nom;
   private String prenom;
   private String mail;
   private String date_N;
   private String adresse;
   private int cin;
   private String niveau;
//dfdfgdf
    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String logine, String mdp, String role, int id_classe, String nom, String prenom, String mail, String date_N, String adresse, int cin, String niveau) {
        this.logine = logine;
        this.mdp = mdp;
        this.role = role;
        this.id_classe = id_classe;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.date_N = date_N;
        this.adresse = adresse;
        this.cin = cin;
        this.niveau = niveau;
    }

    public User(int id, String logine, String mdp, String role, int id_classe, String nom, String prenom, String mail, String date_N, String adresse, int cin, String niveau) {
        this.id = id;
        this.logine = logine;
        this.mdp = mdp;
        this.role = role;
        this.id_classe = id_classe;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.date_N = date_N;
        this.adresse = adresse;
        this.cin = cin;
        this.niveau = niveau;
    }

    public int getId() {
        return id;
    }

    public String getLogine() {
        return logine;
    }

    public String getMdp() {
        return mdp;
    }

    public String getRole() {
        return role;
    }

    public int getId_classe() {
        return id_classe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getDate_N() {
        return date_N;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCin() {
        return cin;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogine(String logine) {
        this.logine = logine;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDate_N(String date_N) {
        this.date_N = date_N;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", logine=" + logine + ", mdp=" + mdp + ", role=" + role + ", id_classe=" + id_classe + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", date_N=" + date_N + ", adresse=" + adresse + ", cin=" + cin + ", niveau=" + niveau + "}\n";
    }

    public User(int id, String logine, String mdp, String role, String nom, String prenom, String mail, String date_N, String adresse, int cin, String niveau) {
        this.id = id;
        this.logine = logine;
        this.mdp = mdp;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.date_N = date_N;
        this.adresse = adresse;
        this.cin = cin;
        this.niveau = niveau;
    }

    public User(String logine, String mdp, String role, String nom, String prenom, String mail, String date_N, String adresse, int cin, String niveau) {
        this.logine = logine;
        this.mdp = mdp;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.date_N = date_N;
        this.adresse = adresse;
        this.cin = cin;
        this.niveau = niveau;
    }
    
    
}
