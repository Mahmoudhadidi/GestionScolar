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
public class Etudient extends User{

    public Etudient(String logine, String mdp) {
        super(logine, mdp);
    }

    public Etudient() {
    }

    public Etudient(int id) {
        super(id);
    }

    public Etudient(String logine, String mdp, String role, int id_classe, String nom, String prenom, String mail, String date_N, String adresse, int cin, String niveau) {
        super(logine, mdp, role, id_classe, nom, prenom, mail, date_N, adresse, cin, niveau);
    }

    public Etudient(int id, String logine, String mdp, String role, int id_classe, String nom, String prenom, String mail, String date_N, String adresse, int cin, String niveau) {
        super(id, logine, mdp, role, id_classe, nom, prenom, mail, date_N, adresse, cin, niveau);
    }

    public Etudient(int id, String logine, String mdp, String role, String nom, String prenom, String mail, String date_N, String adresse, int cin, String niveau) {
        super(id, logine, mdp, role, nom, prenom, mail, date_N, adresse, cin, niveau);
    }

    public Etudient(String logine, String mdp, String role, String nom, String prenom, String mail, String date_N, String adresse, int cin, String niveau) {
        super(logine, mdp, role, nom, prenom, mail, date_N, adresse, cin, niveau);
    }

    public Etudient(String nom, String prenom, String date_N, String adresse, int cin) {
        super(nom, prenom, date_N, adresse, cin);
    }

    public Etudient(String nom, String prenom, String date, int cin, String adresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
