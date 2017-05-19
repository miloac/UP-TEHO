package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.HorarioDisponible;
import java.sql.Time;
import java.util.List;

/**
 * DAO de Hario Disponible utilizado para Injection
 * @author Andres Felipe Pardo
 */
public interface HorarioDisponibleDAO {
    
    List<HorarioDisponible> consultarHorarioProfesor(int id)throws PersistenceException;
    
    void insertarHorarioProfesor(int id,String diaDisp,Time horaDisp)throws PersistenceException;
}
