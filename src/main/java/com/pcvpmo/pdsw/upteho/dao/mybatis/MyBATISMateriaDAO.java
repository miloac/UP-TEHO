package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.MateriaDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.MateriaMapper;
import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.ProgramaXmateria;
import com.pcvpmo.pdsw.upteho.entities.Requisito;
import java.util.List;

/**
 * Implementacion de MateriaDAO MyBATIS
 * @author 2102463
 */
public class MyBATISMateriaDAO implements MateriaDAO{

    
    @Inject
    private MateriaMapper materiaMapper;
    
    @Override
    public void save(Materia m) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Materia load(String sigla) throws PersistenceException {
        return materiaMapper.consultarMateria(sigla);
    }

    @Override
    public void registroDeMateria(int idasig, String req, int treq, String nmateria, int c, String smateria, String desc) {
        materiaMapper.registrarMateria(smateria, nmateria, c, desc, idasig);
    }

    @Override
    public List<Programa> consultaProgramas() {
        return materiaMapper.consultarProgramas();
    }

    @Override
    public List<Asignatura> consultarAsigPorPrograma(int programa) {
        return materiaMapper.getAsigXProg(programa);
    }

    @Override
    public List<Materia> consultarMateriasxAsignatura(Integer idAsignatura) throws PersistenceException {
        return materiaMapper.consultarMateriasxAsignatura(idAsignatura);
    }


    @Override
    public Materia consultarMateria(String siglaMateria) throws PersistenceException {
        return materiaMapper.consultarMateria(siglaMateria);
    }
    
    @Override
    public Materia consultarMateriaSigla(String sigla)throws PersistenceException {
        return materiaMapper.consultarMateriaSigla(sigla);
    }

    @Override
    public void registrarMateria(String sigla, String nombre, int creditos, String descripcion, int idAsignatura) throws PersistenceException {
        materiaMapper.registrarMateria(sigla, nombre, creditos, descripcion, idAsignatura);
    }
    
    @Override
    public List<Materia> consultarMateriasxPrograma(Integer programa) throws PersistenceException {
        return materiaMapper.consultarMateriasxPrograma(programa);
    }


    @Override
    public List<Materia> consultarMaterias() throws PersistenceException {
        return materiaMapper.consultarMaterias();
    }

    @Override
    public void registrarRequisito(String mat, String matReq, int tipo) throws PersistenceException {
        materiaMapper.registrarRequisito(mat,matReq,tipo);
    }

    @Override
    public void remover(String sigla) throws PersistenceException {
        materiaMapper.remover(sigla);
    }

    @Override
    public void registrarProgramaMateria(Integer idPrograma, String sigla) throws PersistenceException {
        materiaMapper.registrarPrograma(idPrograma,sigla);
    }

    @Override
    public void removerRequisito(String sigla) throws PersistenceException {
        materiaMapper.quitarRequisito(sigla);
    }
    
    @Override
    public List<Requisito> consultarRequisitos(String sigla) throws PersistenceException{
        return materiaMapper.consultarRequisitos(sigla);
    }

    @Override
    public List<ProgramaXmateria> consultarProgramaMateriaRel(String sigla) throws PersistenceException {
        return materiaMapper.consultarProgramaMateriaRel(sigla);
    }

    @Override
    public List<ProgramaXmateria> consultarMateriaProgramaRel(Integer idProg) throws PersistenceException {
        return materiaMapper.consultarMateriaProgramaRel(idProg);
    }

    @Override
    public List<ProgramaXmateria> consultarMxP() throws PersistenceException {
        return materiaMapper.consultarMxP();
    }
}
