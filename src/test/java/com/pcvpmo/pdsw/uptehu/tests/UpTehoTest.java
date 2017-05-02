package com.pcvpmo.pdsw.uptehu.tests;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;

import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectosFactory;
import com.pcvpmo.pdsw.upteho.services.UnidadProyectosException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de Test de Unidad para Servicios de Unidad de proyectos
 * @author Jefferson Castañeda - Gabriel Peña
 *
 * Frontera
 * CF1: Registrar una materia de un programa al que no pertenece, resultado esperado: no se deja registrar la materia 
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
 * CE9: no se puede consultar los curso 
 * CE10: al consultar un curso, el cohorte no puede ser negativo; resultado esperado: error
 * CE11: al consultar cursos por periodo, el periodo debe tener un formato adecuado de: año, guion y numero del semestre: AAAA-N; resultado esperado: error si no se sigue el formato
 *
 */
public class UpTehoTest {
    
    public UpTehoTest(){
    }

    @Before
    public void setUp(){
    }
    
    /**
     * CF1: Registrar una materia de un programa al que no pertenece, resultado esperado: no se deja registrar la materia 
     */
    //@Test
    public void pruebaClaseFrontera1(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        List<Materia> l = null;
        try{
            sup.registrarMateria(0, 0, null, 0, "Programacion Imperativa", "PIM", "introduccion a la programacion");
            l = sup.consultarMaterias(0);
        }catch (UnidadProyectosException e){}
        assertTrue(l.size()==1);
    }
    
    /**
     * CE1: una materia no puede ser registrada con un nombre nulo; resultado esperado: no se registra la materia
     */
    //@Test
    public void pruebaNoPermiteRegistrarUnaMateriaConProgramaNull(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        List<Materia> l= null;
        List<Materia> lb= null;
        try{
            sup.registrarMateria(0, 0, null, 0, null, "PIM", "introduccion a la programacion");
            sup.registrarMateria(1, 0, null, 0, null, "PIM", "materiales magneticos");
            l = sup.consultarMaterias(1);
            lb = sup.consultarMaterias(1);
        }catch (UnidadProyectosException e){}
        assertTrue(l.isEmpty() && lb.isEmpty());
    }
    
    /**
     * CE3: si una materia A tiene un prerequisito B, la materia B no puede tener prerequisitos en los que A es prerequisito; resultado esperado: error
     * 
     */
    //@Test 
    public void pruebaNorequisitosCiclicos(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            sup.registrarMateria(0, 0, "pwea", 1, "programacion orientada objetos", "poob", "enseñanza de objetos y su respectiva programacion");
            sup.registrarMateria(0, 0, "powe", 1, "programacion web y aplicaciones", "pwea", "desarrollo de aplicaciones web");
            sup.registrarMateria(0, 0, "poob", 0, "programacion de objetos en aplicaciones we", "powe", "desarrollo de aplicaiones dinamicas");
        }catch(UnidadProyectosException e){
            assert(true);
        }
    }
    
    /**
     * CE4: si se cancela una clase, no debe aparecer en el reporte del periodo; resultado esperado: la clase no aparece
     */
    //@Test
    public void pruebaReporteSinUnaMateriaCancelada(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            sup.registrarMateria(0, 0, "pwea", 1, "programacion orientada objetos", "poob", "enseñanza de objetos y su respectiva programacion");
            sup.registrarMateria(0, 0, "powe", 1, "programacion web y aplicaciones", "pwea", "desarrollo de aplicaciones web");
            sup.registrarMateria(1, 0, null, 0, "vision arquitectonica simplificada", "vias", "diseño de estructuras viales ");
            sup.registrarMateria(1, 0, null, 0, "estructuras metalicas para terremotos", "estr", "diseño de sistemas de amortiguacion");
            //como se relaciona una clase con una materia?, no se ha implementado el metodo de generar reporte
            // RE: Ya estan correctas las entities y relaciones, el reporte sale de la entities.Clase y se piden los atributos, 
            //la descripcion de este test parece mas una Prueba de aceptacion que de unidad...
        }catch(UnidadProyectosException e){
        }
        assertTrue(true);       
    }
    
    /**
     * CE5: no se puede programar una clase por fuera del horario del periodo; resultado esperado: error
     */

    //@Test
    public void pruebaClasePorFueraDelPeriodo(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            //como se sabe cual es el periodo y su respectivo horario
            sup.programarClase("10/6/2017", "21:00", new Curso());//Ya se cambio este metodo en Services para que tenga sentido
            // RE: Curso tiene los atributos para el periodo, para hacer el test tendria que crear los objetos necesarios
            // O rgistrar un nuevo curso, cambiando el metodo registrarClase
        }catch (UnidadProyectosException e){}
        assertTrue(true);
    }
    
    /**
     * CE6: no se puede registrar un curso si el profesor no tiene disponibilidad ; resultado esperado: error
     */
    //@Test
    public void elCursoInvalidaElHorarioDelProfesorAsignado(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            //la prueba no se puede hacer si no se conoce el horario de un profesor, ¿com ose pueden registrar?
            //sup.registrarProfesor con un horario que no sea valido con cierto curso
            //RE: Primero se registra el curso, el profesor y su respectivo horario, y luego hacen la prueba de si se puede registrar
            sup.registrarMateria(0, 0, "pwea", 1, "programacion orientada objetos", "poob", "enseñanza de objetos y su respectiva programacion");
            sup.registrarMateria(0, 0, null, 0, "programacion web y aplicaciones", "pwea", "desarrollo de aplicaciones web");
            sup.registrarCurso(0, "poob", 0);
        }catch (UnidadProyectosException e){
        }
        assertTrue(true);
    }
    
    /**
     * CE7: se debe conocer por lo menos el programa y la asignatura de cada materia que aparezca; resultado esperado: asignatura y programa de las materias
     */
    //@Test 
    public void registroDeMateriasValido(){
        ServiciosUnidadProyectos sup = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        List<Materia> lista = null;
        try{
            sup.registrarMateria(0, 0, "pwea", 1, "programacion orientada objetos", "poob", "enseñanza de objetos y su respectiva programacion");
            sup.registrarMateria(0, 0, "powe", 1, "programacion web y aplicaciones", "pwea", "desarrollo de aplicaciones web");
            sup.registrarMateria(1, 0, null, 0, "vision arquitectonica simplificada", "vias", "diseño de estructuras viales ");
            sup.registrarMateria(1, 0, null, 0, "estructuras metalicas para terremotos", "estr", "diseño de sistemas de amortiguacion");
            lista = sup.consultarMaterias();
        }catch (UnidadProyectosException e){  
        }
        boolean ans=true;
        for (int i=0; i<lista.size(); i++){
            //ans= lista.get(i).metodoparaobtenerla asignaturadeunamateria!=null && lista.get(i).metodoparaobtenerelprograma();
        }
        assertTrue(ans);
    }

    
    
    /**
     * CE6: no se puede registrar un curso si el profesor no tiene disponibilidad ; resultado esperado: error
     */
    //@Test

    public void ce6(){
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            s.registrarCurso(0001, "PDSW", 001);
            //falta implementar en el metodo la disponibilidad del profesor, incluyendo la lista con los horarios que 
//            ya tiene registrados
        } catch (UnidadProyectosException e) {
        }
    }
    
    /**
     * CE8: al momento de registrar una mateira, si esta tiene un Cohorte igual a otra ya registrada, deberia informar el error; RE: mensaje de error
     */
    //@Test
    public void ce8(){
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            //TODO falta implementar en el metodo de registrar materia la variable de cohorte
            s.registrarMateria(001, 002, "MBDA", 1, "Arquitectura empresarial", "AREM", "enfoca al desarrolllo del "
                    + "emprendimiento empresarial");
        } catch (UnidadProyectosException e) {
        }
    }
    
     /**

     * ConsultarCursoValido: consulta en el metodo Consultar curso si el resultado es el esperado, con unos datos

     * registrados en la memoria volatil
     */

    //    @Test

//    public void consultarCursoValido() throws UnidadProyectosException{
//
//        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
//
//        Profesor p=new Profesor(12, "pablo", "pablo@escuela.com");        
//
//        Programa pro=new Programa(95, "maestria en gerencia");
//
//        Asignatura a=new Asignatura(56, "procesos", pro);
//
//        Materia m=new Materia("qwer", "proceso de desarrollo", 3, "introduccion a los procesos de desarrollo", a);
//
//        Periodo per=new Periodo("2017-1", java.sql.Date.valueOf("2017-01-15"), java.sql.Date.valueOf("2017-06-05"));
//
//        Curso c=new Curso(123, p, m,per);
//
//        assertEquals("no se consulta correctamente el curso",c, s.consultarCurso(123));
//
//    }

    

    /**

     * La prueba numeroCursosCorrectos utiliza el metodo consultarCursos para consultar el numero de cursos

     * inscritos y lo compara con un arreglo de cursos registrados en la memoria volatil.

     * @throws UnidadProyectosException 

     */

//    @Test

//    public void numeroCursosCorrecto() throws UnidadProyectosException{
//
//        Profesor p1=new Profesor(12, "pablo", "pablo@escuela.com");        
//
//        Programa pro1=new Programa(95, "maestria en gerencia");
//
//        Asignatura a1=new Asignatura(56, "procesos", pro1);
//
//        Materia m1=new Materia("qwer", "proceso de desarrollo", 3, "introduccion a los procesos de desarrollo", a1);
//
//        Periodo per1=new Periodo("2017-1", java.sql.Date.valueOf("2017-01-15"), java.sql.Date.valueOf("2017-06-05"));
//
//        Curso c1=new Curso(123, p1, m1,per1);
//
//        
//
//        Profesor p2=new Profesor(123, "pedro", "pedro@escuela.com");        
//
//        Programa pro2=new Programa(951, "maestria en finanzas");
//
//        Asignatura a2=new Asignatura(564, "fundamentos", pro2);
//
//        Materia m2=new Materia("fghb", "fundamentos de desarrollo", 4, "introduccion a los fundamentos de desarrollo", a2);
//
//        Periodo per2=new Periodo("2017-2", java.sql.Date.valueOf("2017-08-15"), java.sql.Date.valueOf("2017-12-05"));
//
//        Curso c2=new Curso(1234, p2, m2,per2);
//
//        
//
//        Profesor p3=new Profesor(1237, "manuel", "manuel@escuela.com");        
//
//        Programa pro3=new Programa(9541, "maestria en economia");
//
//        Asignatura a3=new Asignatura(5624, "introduccion", pro3);
//
//        Materia m3=new Materia("gghv", "introduccion al desarrollo", 3, "introduccion a los fundamentos", a3);
//
//        Curso c3=new Curso(1239, p3, m3,per1);
//
//        
//
//        ArrayList<Curso> cursos =new ArrayList<>();
//
//        cursos.add(c1);
//
//        cursos.add(c2);
//
//        cursos.add(c3);
//
//        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
//
//        try {
//
//            assertEquals("el numero de cursos no es correcto", cursos.size(), s.consultarCursos().size());
//
//        } catch (UnidadProyectosException ex) {
//
//             
//            new UnidadProyectosException("se produjo un error en el test de consultar cursos", ex);
//
//        }
//
//    }

    /**
     * CE10: al consultar un curso, el cohorte no puede ser negativo; resultado esperado: error
     */
    @Test
    public void consultarCursoCohorteNegativo(){
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            s.consultarCurso(-1);
            fail("No debe dejar consultar un numero negativo");
        } catch (UnidadProyectosException ex) {
            
        }
        
    }
    
    /**
     * CE11: al consultar cursos por periodo, el periodo debe tener un formato adecuado de: año, guion y numero del semestre: AAAA-N; resultado esperado: error si no se sigue el formato
     */
    @Test
    public void consultarCursoPeriodoCorrecto(){
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            s.consultarCursosPorPeriodo("20162");
            fail("No debe consultar un periodo con formato erroneo");
        } catch (UnidadProyectosException ex) {
            
        }
    }
    
    /**
     * CE11: al consultar cursos por periodo, el periodo debe tener un formato adecuado de: año, guion y numero del semestre: AAAA-N; resultado esperado: error si no se sigue el formato
     */
    @Test
    public void consultarClasesPeriodoCorrecto(){
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try{
            s.consultarClasesxPeriodo("20162");
            fail("No debe consultar un periodo con formato erroneo");
        } catch (UnidadProyectosException ex) {
            
        }
    }
}