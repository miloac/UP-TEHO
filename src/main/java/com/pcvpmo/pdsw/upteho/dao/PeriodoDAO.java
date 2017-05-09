package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Periodo;
import java.sql.Date;
import java.util.List;

/**
 * DAO de Periodo utilizado para Injection
 * @author Daniel Ospina
 */
public interface PeriodoDAO {

    Periodo consultarPeriodo(String idPeriodoActual) throws PersistenceException;

    List<Periodo> consultarPeriodos() throws PersistenceException;

    void registrarPeriodo(String nombre, Date fechaInicial, Date fechaFin) throws PersistenceException;
    
}
