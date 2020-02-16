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
public class Reponses {
    private int id_rep;
    private String reponse;
    private String date;
    private Questions question ; 

    public Reponses(int id_rep, String reponse, String date) {
        this.id_rep = id_rep;
        this.reponse = reponse;
        this.date = date;
    }

    public int getId_rep() {
        return id_rep;
    }

    public String getReponse() {
        return reponse;
    }

    public String getDate() {
        return date;
    }

    public void setId_rep(int id_rep) {
        this.id_rep = id_rep;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "reponses{" + "id_rep=" + id_rep + ", reponse=" + reponse + ", date=" + date + '}';
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public Reponses(int id_rep, String reponse, String date, Questions question) {
        this.id_rep = id_rep;
        this.reponse = reponse;
        this.date = date;
        this.question = question;
    }
    
    
    
}
