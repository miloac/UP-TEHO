/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.CursoDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.CursoMapper;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import java.util.List;

/**
 * Implementacion de CursoDAO MyBATIS
 * @author Daniel Ospina
 */
public class MyBATISCursoDAO implements CursoDAO {
    
    @Inject
    private CursoMapper cursoMapper;
    
    @Override
    public List<Curso> consultarCursos() throws PersistenceException {
        return cursoMapper.consultarCursos();
    }
    
}
