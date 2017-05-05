package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Periodo;
import java.util.List;

/**
 * DAO de Periodo utilizado para Injection
 * @author Daniel Ospina
 */
public interface PeriodoDAO {

    public Periodo consultarPeriodo(String idPeriodoActual) throws PersistenceException;

    public List<Periodo> consultarPeriodos() throws PersistenceException;
    
}
