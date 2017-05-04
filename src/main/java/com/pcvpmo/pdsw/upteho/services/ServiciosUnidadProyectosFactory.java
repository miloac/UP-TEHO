package com.pcvpmo.pdsw.upteho.services;

import com.google.inject.Injector;
import static com.google.inject.Guice.createInjector;
import com.pcvpmo.pdsw.upteho.dao.AsignaturaDAO;
import com.pcvpmo.pdsw.upteho.dao.ClaseDAO;
import com.pcvpmo.pdsw.upteho.dao.CohorteDAO;
import com.pcvpmo.pdsw.upteho.dao.CursoDAO;
import com.pcvpmo.pdsw.upteho.dao.HorarioDisponibleDAO;
import com.pcvpmo.pdsw.upteho.dao.MateriaDAO;
import com.pcvpmo.pdsw.upteho.dao.PeriodoDAO;
import com.pcvpmo.pdsw.upteho.dao.ProfesorDAO;
import com.pcvpmo.pdsw.upteho.dao.ProgramaDAO;
import com.pcvpmo.pdsw.upteho.dao.RecursoDAO;
import com.pcvpmo.pdsw.upteho.dao.RequisitoDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.MyBATISAsignaturaDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.MyBATISClaseDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.MyBATISCohorteDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.MyBATISCursoDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.MyBATISHorarioDisponibleDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.MyBATISMateriaDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.MyBATISProfesorDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.MyBATISProgramaDAO;
import com.pcvpmo.pdsw.upteho.services.impl.ServiciosUnidadProyectosImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

/**
 * Fabrica de Servicios para la aplicacion Unidad de Proyectos
 * @author Daniel Ospina
 */
public class ServiciosUnidadProyectosFactory {
    
    private static ServiciosUnidadProyectosFactory instance = new ServiciosUnidadProyectosFactory();
    
    private static Injector injector;
    
    private static Injector testInjector;
    
    private ServiciosUnidadProyectosFactory() {
        injector = createInjector(new XMLMyBatisModule() {
            
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServiciosUnidadProyectos.class).to(ServiciosUnidadProyectosImpl.class);
                bind(CursoDAO.class).to(MyBATISCursoDAO.class);
                bind(ClaseDAO.class).to(MyBATISClaseDAO.class);
                bind(CohorteDAO.class).to(MyBATISCohorteDAO.class);
                bind(HorarioDisponibleDAO.class).to(MyBATISHorarioDisponibleDAO.class);
                bind(ProfesorDAO.class).to(MyBATISProfesorDAO.class);
                bind(ProgramaDAO.class).to(MyBATISProgramaDAO.class);
                bind(AsignaturaDAO.class).to(MyBATISAsignaturaDAO.class);
                bind(MateriaDAO.class).to(MyBATISMateriaDAO.class);
                //TODO agregar bind de DAOS MyBatis
            }
        });
        
        testInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("mybatis-config-h2.xml");
                bind(ServiciosUnidadProyectos.class).to(ServiciosUnidadProyectosImpl.class);
                bind(CursoDAO.class).to(MyBATISCursoDAO.class);
                bind(ClaseDAO.class).to(MyBATISClaseDAO.class);
                bind(CohorteDAO.class).to(MyBATISCohorteDAO.class);
                bind(HorarioDisponibleDAO.class).to(MyBATISHorarioDisponibleDAO.class);
                bind(ProfesorDAO.class).to(MyBATISProfesorDAO.class);
                bind(ProgramaDAO.class).to(MyBATISProgramaDAO.class);
                bind(AsignaturaDAO.class).to(MyBATISAsignaturaDAO.class);
                bind(MateriaDAO.class).to(MyBATISMateriaDAO.class);
                //TODO agregar binds Daos MyBatis
            }
        });
    }
    
    public ServiciosUnidadProyectos getServiciosUnidadProyectos() {
        return injector.getInstance(ServiciosUnidadProyectos.class);
    }
    
    public AsignaturaDAO getAsignaturaDAO() {
        return injector.getInstance(AsignaturaDAO.class);
    }
    
    public ClaseDAO getClaseDAO() {
        return injector.getInstance(ClaseDAO.class);
    }
    
    public CursoDAO getCursoDAO() {
        return injector.getInstance(CursoDAO.class);
    }
    
    public MateriaDAO getMateriaDAO() {
        return injector.getInstance(MateriaDAO.class);
    }
    
    public PeriodoDAO getPeriodoDAO() {
        return injector.getInstance(PeriodoDAO.class);
    }
    
    public ProfesorDAO getProfesorDAO() {
        return injector.getInstance(ProfesorDAO.class);
    }
    
    public ProgramaDAO getProgramaDAO() {
        return injector.getInstance(ProgramaDAO.class);
    }
    
    public RecursoDAO getRecursoDAO() {
        return injector.getInstance(RecursoDAO.class);
    }
    
    public RequisitoDAO getRequisitoDAO() {
        return injector.getInstance(RequisitoDAO.class);
    }
    
    public CohorteDAO getCohorteDAO() {
        return injector.getInstance(CohorteDAO.class);
    }
    
    public HorarioDisponibleDAO getHorarioDisponibleDAO(){
        return injector.getInstance(HorarioDisponibleDAO.class);
    } 
    
    public ServiciosUnidadProyectos getServiciosUnidadProyectosTesting() {
        return testInjector.getInstance(ServiciosUnidadProyectos.class);
    }
    
    public AsignaturaDAO getAsignaturaDAOTesting() {
        return testInjector.getInstance(AsignaturaDAO.class);
    }
    
    public ClaseDAO getClaseDAOTesting() {
        return testInjector.getInstance(ClaseDAO.class);
    }
    
    public CursoDAO getCursoDAOTesting() {
        return testInjector.getInstance(CursoDAO.class);
    }
    
    public MateriaDAO getMateriaDAOTesting() {
        return testInjector.getInstance(MateriaDAO.class);
    }
    
    public PeriodoDAO getPeriodoDAOTesting() {
        return testInjector.getInstance(PeriodoDAO.class);
    }
    
    public ProfesorDAO getProfesorDAOTesting() {
        return testInjector.getInstance(ProfesorDAO.class);
    }
    
    public ProgramaDAO getProgramaDAOTesting() {
        return testInjector.getInstance(ProgramaDAO.class);
    }
    
    public RecursoDAO getRecursoDAOTesting() {
        return testInjector.getInstance(RecursoDAO.class);
    }
    
    public RequisitoDAO getRequisitoDAOTesting() {
        return testInjector.getInstance(RequisitoDAO.class);
    }
    
    public CohorteDAO getCohorteDAOTesting() {
        return testInjector.getInstance(CohorteDAO.class);
    }
    
    public HorarioDisponibleDAO getHorarioDisponibleDAOTesting(){
        return testInjector.getInstance(HorarioDisponibleDAO.class);
    } 
    
    public static ServiciosUnidadProyectosFactory getInstance() {
        return instance;
    }
}
