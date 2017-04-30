package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Clase;
import java.util.List;

/**
 * DAO de Clase utilizado para Injection
 * @author Daniel Ospina,Andres Felipe Pardo
 */
public interface ClaseDAO {
    List<Clase> consultarClasesxPeriodo(String periodo) throws PersistenceException;
}
