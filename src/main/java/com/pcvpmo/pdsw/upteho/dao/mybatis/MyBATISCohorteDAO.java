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

    @Override
    public Cohorte consultarCohortexId(int idCohorte) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarCohorte(int idPrograma, int idCurso, int cohorte) throws PersistenceException {
        cohorteMapper.registrarCohorte(idPrograma, idCurso, cohorte);
    }
    
    
}
