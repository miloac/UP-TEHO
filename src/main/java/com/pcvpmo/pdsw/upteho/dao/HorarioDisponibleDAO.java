/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.HorarioDisponible;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author andres
 */
public interface HorarioDisponibleDAO {
    List<HorarioDisponible> consultarHorarioProfesor(int id)throws PersistenceException;
    void insertarHorarioProfesor(int id,String diaDisp,Time horaDisp)throws PersistenceException;
}
