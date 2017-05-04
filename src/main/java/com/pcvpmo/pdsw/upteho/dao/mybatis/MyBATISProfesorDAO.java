package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.ProfesorDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.ProfesorMapper;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import java.util.List;

/**
 * Implementacion de ProfesorDAO MyBATIS
 * @author Andres Felipe Pardo
 */
public class MyBATISProfesorDAO implements ProfesorDAO{
    @Inject
    private ProfesorMapper profesorMapper;
    
     @Override
    public List<Profesor> consultarProfesores(String nombre) throws PersistenceException {
        return profesorMapper.consultarProfesoresxNombre(nombre);
    }
}
