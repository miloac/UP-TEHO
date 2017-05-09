package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.PeriodoDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.PeriodoMapper;
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import java.sql.Date;
import java.util.List;

/**
 * Implementacion de PeriodoDAO MyBATIS
 * @author Daniel Ospina
 */
public class MyBATISPeriodoDAO implements PeriodoDAO {
    
    @Inject
    private PeriodoMapper periodoMapper;

    @Override
    public Periodo consultarPeriodo(String idPeriodo) throws PersistenceException {
        return periodoMapper.consultarPeriodo(idPeriodo);
    }

    @Override
    public List<Periodo> consultarPeriodos() throws PersistenceException {
        return periodoMapper.consultarPeriodos();
    }

    @Override
    public void registrarPeriodo(String nombre, Date fechaInicial, Date fechaFin) {
        periodoMapper.registrarPeriodo(nombre, fechaInicial, fechaFin);
    }
    

}
