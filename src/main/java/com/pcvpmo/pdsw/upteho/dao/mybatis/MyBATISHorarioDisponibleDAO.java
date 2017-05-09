/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.HorarioDisponibleDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.HorarioDisponibleMapper;
import com.pcvpmo.pdsw.upteho.entities.HorarioDisponible;
import java.sql.Time;
import java.util.List;

/**
 * Implementacion de HorarioDisponibleDAO MyBATIS
 * @author Andres Felipe Pardo
 */
public class MyBATISHorarioDisponibleDAO implements HorarioDisponibleDAO{
    @Inject
    private HorarioDisponibleMapper horarioDisponibleMapper;

    @Override
    public List<HorarioDisponible> consultarHorarioProfesor(int id) throws PersistenceException {
        return horarioDisponibleMapper.consultarHorarioProfesor(id);
    }

    @Override
    public void insertarHorarioProfesor(int id, String diaDisp, Time horaDisp) throws PersistenceException {
        horarioDisponibleMapper.insertarHorarioProfesor(id, diaDisp, horaDisp);
    }
    
}
