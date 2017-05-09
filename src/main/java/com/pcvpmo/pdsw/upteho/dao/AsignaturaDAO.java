package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import java.util.List;

/**
 * DAO Asignatura utilizado para Injection
 * @author Daniel Ospina
 */
public interface AsignaturaDAO {
    
    List<Asignatura> consultarAsignaturasxPrograma(Integer idPrograma) throws PersistenceException;
<<<<<<< HEAD
    
    Asignatura consultarAsignaturaPorID(Integer id) throws PersistenceException;
=======

    List<Asignatura> consultarAsignaturas() throws PersistenceException;
    
    void registrarAsignatura(String nombreAsig,int idProg) throws PersistenceException;;

    void registrarAsignatura(int idAsignatura, String nombreAsig, int idProg) throws PersistenceException;
>>>>>>> b6a8a44ec1056e283918b7ff529628ec170c60b0
}
