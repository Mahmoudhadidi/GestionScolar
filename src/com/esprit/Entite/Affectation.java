/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.util.Objects;

/**
 *
 * @author techouse
 */
public class Affectation {
    private int id ;
    private int id_user;
    private int id_stage ;
    private String postuler ;
   
    
    public Affectation() {
    
    
    }

    public Affectation(int id_stage, String postuler) {
        this.id_stage = id_stage;
        this.postuler = postuler;
    }
    

    public Affectation(int id, int id_user, int id_stage, String postuler) {
        this.id = id;
        this.id_user = id_user;
        this.id_stage = id_stage;
        this.postuler = postuler;
    }

    public int getId() {
        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_stage() {
        return id_stage;
    }

    public String getPostuler() {
        return postuler;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_stage(int id_stage) {
        this.id_stage = id_stage;
    }

    public void setPostuler(String postuler) {
        this.postuler = postuler;
    }

    @Override
    public String toString() {
        return "Affectation{" + "id=" + id + ", id_user=" + id_user + ", id_stage=" + id_stage + ", postuler=" + postuler + '}';
    }

}
