/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.uptehu.tests;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.services.impl.ServiciosUnidadProyectosImpl;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeffer
 */

/**
 *  frontera
 * CF1: Registrar una mateira de un programa al que no pertenece, resultado esperado: no se deja registrar la materia 
 * clases de equivalencia 
 * CE1: una materia no puede ser registrada con un nombre nulo; resultado esperado: no se registra la materia
 * CE2: las materias de primer nivel se puede registrar sin prerequisitos; resultado esperado: registro la materia
 * CE3: si una materia A tiene un prerequisito B, la materia B no puede tener prerequisitos en los que A es prerequisito; resultado esperado: error
 * CE4: si se cancela una clase, no debe aparecer en el reporte del periodo; resultado esperado: la clase no aparece
 * CE5: no se puede programar una clase por fuera del horario del periodo; resultado esperado: error
 * CE6: no se puede registrar un curso si el profesor no tiene disponibilidad ; resultado esperado: error
 * CE7: se debe conocer por lo menos el programa y la asignatura de cada materia que aparezaca; resultado esperado: asignatura y programa de las materias
 * CE8: al momento de registrar una mateira, si esta tiene un Cohorte igual a otra ya registrada, deberia informar el error; RE: mensaje de error
 * CE9: al consultar las clases, si un cohorte es valido, el resultado no puede ser vacio; RE: listado no vacio de clases x cohorte
 *
 */
public class UpTehoTest {
    
    public UpTehoTest(){
    }
    
    @Before
    public void setUp(){
    }
    
    @Test
    public void pruebaClaseFrontera1(){
        ServiciosUnidadProyectosImpl sup = new ServiciosUnidadProyectosImpl ();
        List<Materia> l = new List()<Materia>;
        try{
            sup.registrarMateria(0, 0, null, 0, "Programacion Imperativa", "PIM", "introduccion a la programacion");
            l = sup.consultarMaterias(0);
        }catch (PersistenceException e){}
        assertTrue(l.size()==1);
    }
    
    @Test
    public void pruebaNoPermiteRegistrarUnaMateriaConProgramaNull(){
        ServiciosUnidadProyectosImpl sup = new ServiciosUnidadProyectosImpl ();
        List<Materia> l= new List()<Materia>;
        List<Materia> lb= new List()<Materia>;
        try{
            sup.registrarMateria(0, 0, null, 0, null, "PIM", "introduccion a la programacion");
            sup.registrarMateria(1, 0, null, 0, null, "PIM", "materiales magneticos");
            l = sup.consultarMaterias(1);
            lb = sup.consultarMaterias(1);
        }catch (PersistenceException e){}
        assertTrue(l.isEmpty() && lb.isEmpty());
    }
}
