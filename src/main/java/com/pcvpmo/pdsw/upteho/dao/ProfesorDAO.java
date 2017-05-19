package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Profesor;
import java.util.List;

/**
 * DAO de Profesor utilizado para Injection
 * @author Daniel Ospina
 */
public interface ProfesorDAO {
    
    List<Profesor> consultarProfesores(String nombre) throws PersistenceException;

    void registrarProfesor(int id, String nombre, String correo) throws PersistenceException;
}