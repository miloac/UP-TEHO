package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Requisito;

import java.util.List;

/**
 * DAO de Materia utilizado para Injection
 * @author Daniel Ospina
 * @author Jefferson Castañeda
 */
public interface MateriaDAO {
    
    void save (Materia m) throws PersistenceException;
    
    Materia load(String sigla) throws PersistenceException;  
    
    void registroDeMateria(int idasig, String req, int treq, String nmateria,int c, String smateria, String desc);
    
    List<Programa> consultaProgramas();
    
    List<Asignatura> consultarAsigPorPrograma(int programa);
    
    List<Materia> consultarMateriasxAsignatura(Integer idAsignatura) throws PersistenceException;

    List<Materia> consultarMaterias() throws PersistenceException;
    
    Materia consultarMateria(String siglaMateria) throws PersistenceException;
    
    Materia consultarMateriaSigla(String sigla)throws PersistenceException;

    void registrarMateria(String sigla, String nombre, int creditos, String descripcion, int idAsignatura) throws PersistenceException;
    
    List<Materia> consultarMateriasxPrograma(Integer programa) throws PersistenceException;
    
    void registrarRequisito(String mat, String matReq, int tipo) throws PersistenceException;
    
    void remover(String sigla) throws PersistenceException;
    
    void registrarProgramaMateria(Integer idPrograma,String sigla) throws PersistenceException;
    
    void removerRequisito(String sigla) throws PersistenceException;
    
    List<Requisito> consultarRequisitos(String sigla) throws PersistenceException;
    
}