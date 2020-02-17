/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Note;
import com.esprit.Entite.TableNote;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amenallah Lounis
 */
public interface IServiceMoyenne {
    public void CalculeMoyenneMatiere() throws SQLException;
    public void CalculeMoyenneMatiere1() throws SQLException;
    public List<TableNote> afficherNoteEtudiant(int x) ;
    
    
}
