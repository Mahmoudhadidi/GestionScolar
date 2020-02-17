/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

//import java.sql.Date;

import java.sql.Date;
import java.util.Objects;


/**
 *
 * @author ADMIN
 */
public class Stagee {
    private int id_stage;
    private int id_user;
    private String titre;
    private String description;
    private String type;
    private Date DATEDEBUT_S ; 
    private Date DATEFIN_S ;
    private int capacite_max ;
    private String niveau_stage ;

    public Stagee() {
    }
    

    public Stagee(int id_stage, int id_user, String titre, String description, String type, Date DATEDEBUT_S, Date DATEFIN_S, int capacite_max, String niveau_stage) {
        this.id_stage = id_stage;
        this.id_user = id_user;
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.DATEDEBUT_S = DATEDEBUT_S;
        this.DATEFIN_S = DATEFIN_S;
        this.capacite_max = capacite_max;
        this.niveau_stage = niveau_stage;
    }

    public Stagee(String titre, String description, String type, Date DATEDEBUT_S, Date DATEFIN_S, int capacite_max, String niveau_stage) {
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.DATEDEBUT_S = DATEDEBUT_S;
        this.DATEFIN_S = DATEFIN_S;
        this.capacite_max = capacite_max;
        this.niveau_stage = niveau_stage;
    }

    public int getId_stage() {
        return id_stage;
    }

    public int getId_user() {
        return id_user;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Date getDATEDEBUT_S() {
        return DATEDEBUT_S;
    }

    public Date getDATEFIN_S() {
        return DATEFIN_S;
    }

    public int getCapacite_max() {
        return capacite_max;
    }

    public String getNiveau_stage() {
        return niveau_stage;
    }

    public void setId_stage(int id_stage) {
        this.id_stage = id_stage;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDATEDEBUT_S(Date DATEDEBUT_S) {
        this.DATEDEBUT_S = DATEDEBUT_S;
    }

    public void setDATEFIN_S(Date DATEFIN_S) {
        this.DATEFIN_S = DATEFIN_S;
    }

    public void setCapacite_max(int capacite_max) {
        this.capacite_max = capacite_max;
    }

    public void setNiveau_stage(String niveau_stage) {
        this.niveau_stage = niveau_stage;
    }

    @Override
    public String toString() {
        return "Stagee{" + "id_stage=" + id_stage + ", id_user=" + id_user + ", titre=" + titre + ", description=" + description + ", type=" + type + ", DATEDEBUT_S=" + DATEDEBUT_S + ", DATEFIN_S=" + DATEFIN_S + ", capacite_max=" + capacite_max + ", niveau_stage=" + niveau_stage + '}';
    }
    
    

   
    
   
}
