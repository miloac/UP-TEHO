/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Programa;
import java.util.List;

/**
 *
 * @author 2116177
 */
public interface ProgramaMapper {
    List<Programa> consultarProgramas();
}
