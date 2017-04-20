/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.services;

import com.google.inject.Injector;
import static com.google.inject.Guice.createInjector;
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
            
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServiciosUnidadProyectos.class).to(ServiciosUnidadProyectosImpl.class);
                //TODO agregar bind de DAOS MyBatis
            }
        });
        
        testInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("mybatis-config-h2.xml");
                bind(ServiciosUnidadProyectos.class).to(ServiciosUnidadProyectosImpl.class);
                //TODO agregar binds Daos MyBatis
            }
        });
    }
    /**
     *
     * @return
     */
    public ServiciosUnidadProyectos getServiciosUnidadProyectos() {
        return injector.getInstance(ServiciosUnidadProyectos.class);
    }
    
    //TODO agregar getters de DAOS
    
    public ServiciosUnidadProyectos getServiciosUnidadProyectosTesting() {
        return testInjector.getInstance(ServiciosUnidadProyectos.class);
    }
    
    //TODO Agregar getters DAOS de testing
    
    public static ServiciosUnidadProyectosFactory getInstance() {
        return instance;
    }
}
