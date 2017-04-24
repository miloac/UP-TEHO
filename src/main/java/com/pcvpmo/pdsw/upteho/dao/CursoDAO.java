package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Curso;
import java.util.List;

/**
 * DAO de Curso utilizado para Injection
 * @author Daniel Ospina
 */
public interface CursoDAO {
    List<Curso> consultarCursos() throws PersistenceException;
}
