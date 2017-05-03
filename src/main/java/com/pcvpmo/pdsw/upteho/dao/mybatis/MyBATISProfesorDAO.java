/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.ProfesorDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.ProfesorMapper;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import java.util.List;

/**
 *
 * @author andres
 */
public class MyBATISProfesorDAO implements ProfesorDAO{
    @Inject
    private ProfesorMapper profesorMapper;
    
     @Override
    public List<Profesor> consultarProfesores(String nombre) throws PersistenceException {
        return profesorMapper.consultarProfesoresxNombre(nombre);
    }
}
