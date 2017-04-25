package com.pcvpmo.pdsw.upteho.dao.mybatis;

import com.google.inject.Inject;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.ReservacionSalonDAO;
import com.pcvpmo.pdsw.upteho.dao.mybatis.mappers.ReservacionSalonMapper;
import com.pcvpmo.pdsw.upteho.entities.ReservacionSalon;
import java.util.List;

/**
 *
 * @author Daniel Ospina
 */
public class MyBATISReservacionSalonDAO implements ReservacionSalonDAO{
    @Inject 
    private ReservacionSalonMapper reservacionSalonMapper;

    @Override
    public List<ReservacionSalon> consultarSalonesReservados() throws PersistenceException {
        return reservacionSalonMapper.consultarSalonesReservados();
    }

    @Override
    public List<ReservacionSalon> consultarSalonPeriodo(String periodo) throws PersistenceException {
        return reservacionSalonMapper.consultarSalonPeriodo(periodo);
    }

    @Override
    public List<ReservacionSalon> consultarSalonesCurso(int cohorte) throws PersistenceException {
        return reservacionSalonMapper.consultarSalonesCurso(cohorte);
    }
  
}
