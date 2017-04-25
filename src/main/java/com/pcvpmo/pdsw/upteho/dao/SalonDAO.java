/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Salon;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author andres
 */
public interface SalonDAO {
    List<Salon> consultarSalones()throws PersistenceException;
    List<Salon> consultarSalonPeriodo(String periodo)throws PersistenceException;
    List<Salon> consultarSalonCurso(int idCohorte)throws PersistenceException;
}
