/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author PC-HP
 */
public class Questions {
    private int id_ques;
    private int id_user;
    private String question;
    private String date;

    public Questions(int id_ques, int id_user, String question, String date) {
        this.id_ques = id_ques;
        this.id_user = id_user;
        this.question = question;
        this.date = date ;
    }

    public int getId_ques() {
        return id_ques;
    }

    public int getId_user() {
        return id_user;
    }

    public String getQuestion() {
        return question;
    }

    public String getDate() {
        return date;
    }

    public void setId_ques(int id_ques) {
        this.id_ques = id_ques;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "questions{" + "id_ques=" + id_ques + ", id_user=" + id_user + ", question=" + question + ", date=" + date + '}';
    }

   
    
}
