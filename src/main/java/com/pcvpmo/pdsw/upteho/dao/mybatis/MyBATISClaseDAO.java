/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.ClaseDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.ClaseMapper;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import java.util.List;

/**
 *
 * @author andres
 */
public class MyBATISClaseDAO implements ClaseDAO{
    
    @Inject
    private ClaseMapper claseMapper;
    
    @Override
    public List<Clase> consultarClases() throws PersistenceException {
        return claseMapper.consultarClases();
    }

    @Override
    public List<Clase> consultarClaseCurso(int idCohorte) throws PersistenceException {
        return claseMapper.consultarClaseCurso(idCohorte);
    }
    
}
