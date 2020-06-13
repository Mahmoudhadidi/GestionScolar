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
public class Seance {
    private int id_Seance;
    private User ens;
    private String nomens;
    private Classe classe;
    private String nomclasse;
    private Matiere matiere;
    private String nommatiere;
    private Salle salle;
    private String nomsalle;
    private String duree;
    private String heure;
    private String date;

    @Override
    public String toString() {
        return "Seance{" + "id_Seance=" + id_Seance + ", ens=" + ens + ", nomens=" + nomens + ", classe=" + classe + ", nomclasse=" + nomclasse + ", matiere=" + matiere + ", nommatiere=" + nommatiere + ", salle=" + salle + ", nomsalle=" + nomsalle + ", duree=" + duree + ", heure=" + heure + ", date=" + date + "}\n";
    }

    public Seance(int id_Seance, String nomens, String nomclasse, String nommatiere, String nomsalle, String heure, String date) {
        this.id_Seance = id_Seance;
        this.nomens = nomens;
        this.nomclasse = nomclasse;
        this.nommatiere = nommatiere;
        this.nomsalle = nomsalle;
        
        this.heure = heure;
        this.date = date;
    }

    public int getId_Seance() {
        return id_Seance;
    }

    public void setId_Seance(int id_Seance) {
        this.id_Seance = id_Seance;
    }

    public void setEns(User ens) {
        this.ens = ens;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
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

    public User getEns() {
        return ens;
    }

    public Classe getClasse() {
        return classe;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public Salle getSalle() {
        return salle;
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

    public void setNomens(String nomens) {
        this.nomens = nomens;
    }

    public void setNomclasse(String nomclasse) {
        this.nomclasse = nomclasse;
    }

    public void setNommatiere(String nommatiere) {
        this.nommatiere = nommatiere;
    }

    public void setNomsalle(String nomsalle) {
        this.nomsalle = nomsalle;
    }

    public String getNomens() {
        return nomens;
    }

    public String getNomclasse() {
        return nomclasse;
    }

    public String getNommatiere() {
        return nommatiere;
    }

    public String getNomsalle() {
        return nomsalle;
    }

    public Seance(User ens, Classe classe, Matiere matiere, Salle salle, String duree, String heure, String date) {
        this.ens = ens;
        this.classe = classe;
        this.matiere = matiere;
        this.salle = salle;
        this.duree = duree;
        this.heure = heure;
        this.date = date;
    }

    public Seance(int id_Seance) {
        this.id_Seance = id_Seance;
    }

    public Seance(int id_Seance, User ens, Classe classe, Matiere matiere, Salle salle, String duree, String heure, String date) {
        this.id_Seance = id_Seance;
        this.ens = ens;
        this.classe = classe;
        this.matiere = matiere;
        this.salle = salle;
        this.duree = duree;
        this.heure = heure;
        this.date = date;
    }
    
    

    
    
}
