package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.MateriaDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.MateriaMapper;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import java.util.List;

/**
 * Implementacion de MateriaDAO MyBATIS
 * @author Daniel Ospina
 */
public class MyBATISMateriaDAO implements MateriaDAO {
    
    @Inject
    private MateriaMapper materiaMapper;

    @Override
    public List<Materia> consultarMateriasxAsignatura(Integer idAsignatura) throws PersistenceException {
        return materiaMapper.consultarMateriasxAsignatura(idAsignatura);
    }
    

}
