package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.ClaseDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.ClaseMapper;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Implementacion de ClaseDAO MyBATIS
 * @author Andres Felipe Pardo
 */
public class MyBATISClaseDAO implements ClaseDAO{
    
    @Inject
    private ClaseMapper claseMapper;

    @Override
    public List<Clase> consultarClasesxPeriodo(String periodo) throws PersistenceException {
        return claseMapper.consultarClasesxPeriodo(periodo);
    }

    @Override
    public List<Clase> consultarClasesCurso(int id) throws PersistenceException {
        return claseMapper.consultarClasesCurso(id);
    }

    @Override
    public void agregarClase(int idCurso, Date fecha, Time hora, String tSalon) throws PersistenceException {
        claseMapper.agregarClase(idCurso, fecha, hora, tSalon);
    }

    @Override
    public List<Clase> consultarClasesProfesor(int idProf) throws PersistenceException {
        return claseMapper.consultarClasesProfesor(idProf);
    }

    @Override
    public void cancelarClase(int id) throws PersistenceException {
        claseMapper.cancelarClase(id);
    }

    @Override
    public List<Clase> consultarClasesHorario(Date fecha, Time hora) throws PersistenceException {
        return claseMapper.consultarClasesHorario(fecha, hora);
    }
    
    
}
