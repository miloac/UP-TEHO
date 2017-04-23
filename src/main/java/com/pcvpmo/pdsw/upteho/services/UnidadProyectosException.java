/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.services;

/**
 * Excepcion de Unidad de Proyectos para errores de la capa lógica
 * @author Daniel Ospina
 */
public class UnidadProyectosException extends Exception {
    
    /**
     * Constructor de una nueva excepcion simple
     */
    public UnidadProyectosException() {
    }
    
    /**
     * Constructor de una nueva excepcion con un mensaje
     * @param message mensaje de la excepcion
     */
    public UnidadProyectosException(String message) {
        super(message);
    }
    
    /**
     * Constructor de una nueva excepcion con un mensaje y una causa
     * @param message mensaje de la excepcion
     * @param cause causa de la excepcion
     */
    public UnidadProyectosException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructor de una nueva excepcion con una causa
     * @param cause causa de la excepcion
     */
    public UnidadProyectosException(Throwable cause) {
        super(cause);
    }
    
}
