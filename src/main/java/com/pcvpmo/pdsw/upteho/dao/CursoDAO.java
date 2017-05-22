package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Curso;
import java.util.List;

/**
 * DAO de Curso utilizado para Injection
 * @author Daniel Ospina
 */
public interface CursoDAO {
    
    List<Curso> consultarCursos() throws PersistenceException;
    
    Curso consultarCurso(int cohorte) throws PersistenceException;
    
    List<Curso> consultarCursosPorPeriodo(String nombre) throws PersistenceException;

    int getNextCurso() throws PersistenceException;

    void registrarCurso(int id, int idProfesor, String siglaMateria, String nombrePeriodo) throws PersistenceException;
    
   
}
