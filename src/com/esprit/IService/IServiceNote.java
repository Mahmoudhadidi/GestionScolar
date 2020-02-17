/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;

import com.esprit.Entite.Note;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amenallah Lounis
 */
public interface IServiceNote<T> {
     void ajouter(T t) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(Note n) throws SQLException;
   // List<Note> rechercheParNoteExamen(String nom_matiere)throws SQLException;
    List<Note> trier() throws SQLException;
    List<T> readAll() throws SQLException;
   
    
    }

