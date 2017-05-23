package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Clase;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * DAO de Clase utilizado para Injection
 * @author Daniel Ospina, Andres Felipe Pardo
 */
public interface ClaseDAO {
    
    List<Clase> consultarClasesxPeriodo(String periodo) throws PersistenceException;
    
    List<Clase> consultarClasesCurso(int id)throws PersistenceException;
    
    void agregarClase(int idCurso,Date fecha,Time hora,String tSalon)throws PersistenceException;
    
    List<Clase> consultarClasesProfesor(int idProf)throws PersistenceException;
    
    void cancelarClase(int id)throws PersistenceException;
    
    List<Clase> consultarClasesHorario(Date fecha,Time hora)throws PersistenceException;
}
