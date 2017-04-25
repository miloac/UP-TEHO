/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.SalonDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.SalonMapper;
import com.pcvpmo.pdsw.upteho.entities.Salon;
import java.util.List;

/**
 *
 * @author andres
 */
public class MyBATISSalonDAO implements SalonDAO{
    @Inject 
    private SalonMapper salonMapper;

    @Override
    public List<Salon> consultarSalones() throws PersistenceException {
        return salonMapper.consultarSalones();
    }

    @Override
    public List<Salon> consultarSalonPeriodo(String periodo) throws PersistenceException {
        return salonMapper.consultarSalonPeriodo(periodo);
    }

    @Override
    public List<Salon> consultarSalonCurso(int idCohorte) throws PersistenceException {
        return salonMapper.consultarSalonCurso(idCohorte);
    }
   
  
}
