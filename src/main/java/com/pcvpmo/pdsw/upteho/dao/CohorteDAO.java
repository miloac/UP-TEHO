package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Cohorte;

/**
 * DAO Cohorte utilizado para Injection
 * @author Andres Felipe Pardo
 */
public interface CohorteDAO {
    Cohorte consultarCohorte (int idCurso,int idPrograma)throws PersistenceException;
    
    Cohorte consultarCohortexId(int idCohorte) throws PersistenceException;
}
