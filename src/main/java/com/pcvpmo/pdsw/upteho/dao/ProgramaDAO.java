package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Programa;
import java.util.List;

/**
 * DAO de Programa utilizado para Injection
 * @author Daniel Ospina, Juan Camilo mantilla
 */
public interface ProgramaDAO {

    public List<Programa> consultarProgramas() throws PersistenceException;
    
    public Programa consultarPrograma(Integer id) throws PersistenceException;

    void registrarPrograma(int id, String nombre) throws PersistenceException;
    
    void removerPrograma(int id) throws PersistenceException;
}