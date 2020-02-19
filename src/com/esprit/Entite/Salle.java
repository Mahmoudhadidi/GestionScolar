/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import javafx.scene.control.Button;

/**
 *
 * @author hadidi
 */
public class Salle {
    int idSalle;
    int numSalle;
    String nomSalle;
    String bloc;
      private final Button btn = new Button("Supprimer");

    public Button getBtn() {
        return btn;
    }

    public Salle(int numSalle, String nomSalle, String bloc) {
        this.numSalle = numSalle;
        this.nomSalle = nomSalle;
        this.bloc = bloc;
    }

    public Salle(int idSalle) {
        this.idSalle = idSalle;
    }

    public Salle(int idSalle, int numSalle, String nomSalle, String bloc) {
        this.idSalle = idSalle;
        this.numSalle = numSalle;
        this.nomSalle = nomSalle;
        this.bloc = bloc;
    }

    public Salle() {
    }

    public int getIdSalle() {
        return idSalle;
    }

    public int getNumSalle() {
        return numSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public String getBloc() {
        return bloc;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public void setBloc(String bloc) {
        this.bloc = bloc;
    }

    @Override
    public String toString() {
        return "Salle{" + "idSalle=" + idSalle + ", numSalle=" + numSalle + ", nomSalle=" + nomSalle +
                ", bloc=" + bloc + "}\n";
    }
    
    
    
    
}
