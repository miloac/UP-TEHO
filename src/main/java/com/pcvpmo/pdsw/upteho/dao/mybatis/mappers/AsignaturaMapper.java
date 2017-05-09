package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 * Interface para el Mapper Asignatura
 * @author Daniel Ospina
 */
public interface AsignaturaMapper {

    List<Asignatura> consultarAsignaturasxPrograma(@Param("idPrograma")Integer idPrograma);
    
    List<Asignatura> consultarAsignaturas();
    
<<<<<<< HEAD
    public Asignatura getAsignaturaPorID(@Param("idAsig") Integer id);
    
=======
    void registrarAsignatura(@Param("nombreAsig")String nombreAsig,@Param("idProg")int idProg);

    void registrarAsignaturaFull(@Param("idAsignatura")int idAsignatura, @Param("nombreAsig")String nombreAsig, @Param("idProg")int idProg);

>>>>>>> b6a8a44ec1056e283918b7ff529628ec170c60b0
}
