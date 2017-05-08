package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Programa;
import java.util.List;

/**
 * DAO de Programa utilizado para Injection
 * @author Daniel Ospina
 */
public interface ProgramaDAO {

    public List<Programa> consultarProgramas() throws PersistenceException;
    
    public Programa consultarPrograma(Integer id) throws PersistenceException;
    
}