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
public class Note {
    private int id_note;
    private float note_cc;
    private float note_ds;
    private float note_examun;
    private float moyenne;
    private float net;
    private int id_user;
    private String id_matiere;
    
    
    public Note(int id_note, float note_cc, float note_ds, float note_examun, float moyenne, float net, int id_user, String id_matiere) {
        this.id_note=id_note;
        this.note_cc=note_cc;
        this.note_ds=note_ds;
        this.note_examun=note_examun;
        this.moyenne=moyenne;
        this.net=net;
        this.id_user=id_user;
        this.id_matiere=id_matiere;
    }

    public Note(float note_cc, float note_ds, float note_examun, float moyenne, float net, int id_user, String id_matiere) {
         this.note_cc=note_cc;
        this.note_ds=note_ds;
        this.note_examun=note_examun;
        this.moyenne=moyenne;
        this.net=net;
        this.id_user=id_user;
        this.id_matiere=id_matiere;
    }
    
    public Note(float note_cc, float note_ds, float note_examun, int id_user, String id_matiere) {
         this.note_cc=note_cc;
        this.note_ds=note_ds;
        this.note_examun=note_examun;
        this.id_user=id_user;
        this.id_matiere=id_matiere;
    }
    public Note ()
    {}

    public Note (float note_cc, float note_ds, float examun, float moyenne , String id_matiere)
    {
        this.note_cc=note_cc;
        this.note_ds=note_ds;
        this.note_examun=note_examun;
        this.moyenne=moyenne;
        this.id_matiere=id_matiere;
    }
   

    public int getId_note() {
        return id_note;
    }

    public float getNote_cc() {
        return note_cc;
    }

    public void setNote_cc(float note_cc) {
        this.note_cc = note_cc;
    }

    public float getNet() {
        return net;
    }

    public void setNet(float net) {
        this.net = net;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public float getNote_ds() {
        return note_ds;
    }

    public void setNote_ds(float note_ds) {
        this.note_ds = note_ds;
    }

    public float getNote_examun() {
        return note_examun;
    }

    public void setNote_examun(float note_examun) {
        this.note_examun = note_examun;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(String id_matiere) {
        this.id_matiere = id_matiere;
    }

    @Override
    public String toString() {
        return "Note{" + "id_note=" + id_note +",Note_cc="+note_cc +  ", note_ds=" + note_ds + ", note_examun=" + note_examun + ", moyenne=" + moyenne + ", net="+ net + ", id_user=" + id_user + ", id_matiere=" + id_matiere + '}';
    }
    
    
}
