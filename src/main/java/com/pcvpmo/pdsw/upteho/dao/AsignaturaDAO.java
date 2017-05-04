package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import java.util.List;

/**
 * DAO Asignatura utilizado para Injection
 * @author Daniel Ospina
 */
public interface AsignaturaDAO {
    
    List<Asignatura> consultarAsignaturasxPrograma(Integer idPrograma) throws PersistenceException;
}
