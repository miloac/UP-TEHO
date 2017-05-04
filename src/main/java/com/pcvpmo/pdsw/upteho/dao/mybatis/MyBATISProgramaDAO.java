/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.ProgramaDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.ProgramaMapper;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import java.util.List;

/**
 *
 * @author 2116177
 */
public class MyBATISProgramaDAO implements ProgramaDAO{
    
    @Inject
    private ProgramaMapper programaMapper;

    @Override
    public List<Programa> consultarProgramas() throws PersistenceException {
        return programaMapper.consultarProgramas();
    }
    
}
