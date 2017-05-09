package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.ProgramaDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.ProgramaMapper;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import java.util.List;

/**
 * Implementacion de ProgramaDAO MyBATIS
 * @author Daniel Ospina
 */
public class MyBATISProgramaDAO implements ProgramaDAO {
    
    @Inject
    private ProgramaMapper programaMapper;

    @Override
    public List<Programa> consultarProgramas() throws PersistenceException {
        return programaMapper.consultarProgramas();
    }

    @Override
    public void registrarPrograma(int id, String nombre) throws PersistenceException {
        programaMapper.registrarPrograma(id, nombre);
    }
}
