package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.Requisito;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Materia
 * @author Daniel Ospina
 * @author Jefferson Castañeda
 */
public interface MateriaMapper {

    
    /**
     * consultar una materia por su sigla
     * @param sigla de la materia a consultar
     * @return Materia consultada
     */
    Materia consultarMateria(@Param("sigla") String sigla);
    
    /**
     * consultar una materia por su sigla
     * @param sigla a consultar 
     * @return Materia materia consultada
     */
    Materia consultarMateriaSigla(@Param ("sigla") String sigla);
    
    /**
     * consulta los programas para poder asignar alguno a una nueva materia
     * @return programas consultados
     */
    List<Programa> consultarProgramas();
    
    /**
     * consulta las asignaturas por programa
     * @param programa id del programa para sacar la asignatura
     * @return lista de asignaturas
     */
    List<Asignatura> getAsigXProg(@Param("programa") int programa);
    
    /**
     * consulta las materias de determinada asignatura
     * @param idAsignatura asignatura de la que se obtendran las materias
     * @return listado de materias consultadas de la asig
     */
    List<Materia> consultarMateriasxAsignatura(@Param("idAsignatura")Integer idAsignatura);

    /**
     * registra una materia en la base de datos
     * @param sigla sigla de la materia a registrar
     * @param nombre nombre de la materia a registrar
     * @param creditos creditos de la materia a registrar
     * @param descripcion descripcion de la materia a registrar
     * @param idAsignatura asignatura asociada de la materia a registrar
     */
    void registrarMateria(@Param("sigla")String sigla,
                                 @Param("nombre")String nombre, 
                                 @Param("creditos")int creditos, 
                                 @Param("descripcion")String descripcion, 
                                 @Param("idAsignatura")int idAsignatura);
    
    /**
     * remueve una materia por su sigla
     * @param sigla de la materia a ser removida
     */
    void remover(@Param("sigla") String sigla);
    
    /**
     * consulta las materias segun el programa
     * @param programa programa del que se obtendran las materias
     * @return  listado de sus materias
     */
    List<Materia> consultarMateriasxPrograma(@Param("programa")Integer programa);

    /**
     * consulta todas las materias
     * @return todas las  materias del sistema
     */
    List<Materia> consultarMaterias();
    
    /**
     * registra los requisitos de una materia 
     * @param mat materia a la que se le quiere asignar el requisito
     * @param matReq requisito a registrar
     * @param tipo co o requisito 
     */
    public void registrarRequisito(@Param("materia") String mat, @Param("materiaReq") String matReq, @Param("tipo") Integer tipo);
    
    /**
     * consulta los requisitos de cierta materia
     * @param sigla de la materia
     * @return listado de requisitos de dicha materia
     * 
     */
    public List<Requisito> consultarRequisitos(@Param("siglaMateria") String sigla);
    
    /**
     * quitar un requisito de requisitos
     * @param sigla del requisito que se quiere quitar
     */
    public void quitarRequisito(@Param("siglaReq") String sigla);
    
    /**
     * registra el programa asociado que puede ver cierta materia
     * @param idPrograma programa que puede ver cierta materia
     * @param sigla materia que puede ser vista por el programa
     */
    public void registrarPrograma(@Param("idPrograma") Integer idPrograma, @Param("sigla") String sigla);
}

