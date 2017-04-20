package com.pcvpmo.pdsw.upteho.dao;

/**
 * Clase Excepcion dedicada al manejo de Excepciones de la capa de Persistencia
 * @author Daniel Ospina
 */
public class PersistenceException extends Exception{
    /**
     * Constructor de una nueva excepcion con un mensaje
     * @param message mensaje de la excepcion
     */
    public PersistenceException(String message) {
        super(message);
    }
    
    /**
     * Constructor de una nueva excepcion con un mensaje y su causa
     * @param message mensaje de la excepcion
     * @param cause causa de la excepcion
     */
    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
