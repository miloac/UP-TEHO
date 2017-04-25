package com.pcvpmo.pdsw.upteho.dao;

import com.pcvpmo.pdsw.upteho.entities.ReservacionSalon;
import java.util.List;

/**
 *
 * @author Daniel Ospina
 */
public interface ReservacionSalonDAO {
    List<ReservacionSalon> consultarSalonesReservados()throws PersistenceException;
    List<ReservacionSalon> consultarSalonPeriodo(String periodo)throws PersistenceException;
    List<ReservacionSalon> consultarSalonesCurso(int cohorte) throws PersistenceException;
}
