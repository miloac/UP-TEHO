/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Cohorte;

/**
 *
 * @author andres
 */
public interface CohorteDAO {
    Cohorte consultarCohorte (int idCurso,int idPrograma)throws PersistenceException;
}
