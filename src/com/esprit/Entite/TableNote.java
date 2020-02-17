/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author Amenallah Lounis
 */
public class TableNote {
    int id;
    float note_cc;
    float noteds;
    float noteexamen;
    float moyenne;
    float net;
    String matiere;
    int coef;
    String nom;
    String prenom;
    int iduser;

    public TableNote(float note_cc, float noteds, float noteexamen, float moyenne, float net, String matiere, int coef, String nom, String prenom, int iduser) {
        this.note_cc = note_cc;
        this.noteds = noteds;
        this.noteexamen = noteexamen;
        this.moyenne = moyenne;
        this.net = net;
        this.matiere = matiere;
        this.coef = coef;
        this.nom = nom;
        this.prenom = prenom;
        this.iduser = iduser;
    }

    public TableNote(int id, float note_cc, float noteds, float noteexamen, float moyenne, float net, String matiere, int coef, String nom, String prenom, int iduser) {
        this.id = id;
        this.note_cc = note_cc;
        this.noteds = noteds;
        this.noteexamen = noteexamen;
        this.moyenne = moyenne;
        this.net = net;
        this.matiere = matiere;
        this.coef = coef;
        this.nom = nom;
        this.prenom = prenom;
        this.iduser = iduser;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNote_cc() {
        return note_cc;
    }

    public void setNote_cc(float note_cc) {
        this.note_cc = note_cc;
    }

    public float getNoteds() {
        return noteds;
    }

    public void setNoteds(float noteds) {
        this.noteds = noteds;
    }

    public float getNoteexamen() {
        return noteexamen;
    }

    public void setNoteexamen(float noteexamen) {
        this.noteexamen = noteexamen;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public float getNet() {
        return net;
    }

    public void setNet(float net) {
        this.net = net;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIduser() {
        return iduser;
    }
    
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    
    @Override
    public String toString() {
        return "TableNote{" + "id=" + id + ", note_cc=" + note_cc + ", noteds=" + noteds + ", noteexamen=" + noteexamen + ", moyenne=" + moyenne + ", net=" + net + ", matiere=" + matiere + ", coef=" + coef + ", nom=" + nom + ", prenom=" + prenom + ", iduser=" + iduser + '}';
    }

    
   
}
