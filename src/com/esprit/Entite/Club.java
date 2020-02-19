/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author ADMIN
 */
public class Club {
    private int id;
    private int id_etudiant;
    private String nom;
    private String photo_couverture;
    private String logo;
    private String slogan;
     private String grand_titre;
    private String description;
    private String mail;
    private String etat;

    public Club() {
    }

    public Club(int id, int id_etudiant, String nom, String photo_couverture, String logo, String slogan, String grand_titre, String description, String mail, String etat) {
        this.id = id;
        this.id_etudiant = id_etudiant;
        this.nom = nom;
        this.photo_couverture = photo_couverture;
        this.logo = logo;
        this.slogan = slogan;
        this.grand_titre = grand_titre;
        this.description = description;
        this.mail = mail;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto_couverture() {
        return photo_couverture;
    }

    public void setPhoto_couverture(String photo_couverture) {
        this.photo_couverture = photo_couverture;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getGrand_titre() {
        return grand_titre;
    }

    public void setGrand_titre(String grand_titre) {
        this.grand_titre = grand_titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", id_etudiant=" + id_etudiant + ", nom=" + nom + ", photo_couverture=" + photo_couverture + ", logo=" + logo + ", slogan=" + slogan + ", grand_titre=" + grand_titre + ", description=" + description + ", mail=" + mail + ", etat=" + etat + '}';
    }
    
    
    
}
