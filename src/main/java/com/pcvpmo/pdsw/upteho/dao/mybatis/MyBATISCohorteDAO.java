package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.CohorteDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.CohorteMapper;
import com.pcvpmo.pdsw.upteho.entities.Cohorte;

/**
 * Implementacion de CohorteDAO MyBATIS
 * @author andres
 */
public class MyBATISCohorteDAO implements CohorteDAO{
    @Inject
    private CohorteMapper cohorteMapper;

    @Override
    public Cohorte consultarCohorte(int idCurso, int idPrograma) throws PersistenceException {
        return cohorteMapper.consultarCohorte(idCurso,idPrograma);
    }
    
    
}
