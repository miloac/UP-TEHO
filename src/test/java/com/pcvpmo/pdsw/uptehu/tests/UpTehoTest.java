package com.pcvpmo.pdsw.uptehu.tests;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.entities.HorarioDisponible;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;

import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectosFactory;
import com.pcvpmo.pdsw.upteho.services.UnidadProyectosException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
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
 * CE12: Al registrar un nuevo Periodo con todos los datos correctos se debe agregar correctamente. TIPO: Normal; Resultado Esperado: Se registra el periodo
 * CE13: Al registrar un periodo nuevo se debe tener un formato adecuado: año, guion y numero del semestre: AAAA-N; TIPO: Normal; Resultado Esperado: error si el formato es incorrecto
 * CE14: Al consultar los periodos se debe obtener una lista de periodos con los datos correctos;  TIPO:  Normal; Resultado Esperado: Lista de Periodos
 * CE15: Al registrar un cohorte con datos correctos se agrega correctamente; TIPO: Normal; Resultado Esperado: Se agrega el cohorte correctamente
 * CE16: Al consultarAsignaturasxPrograma se debe obtener la asignatura requerida TIPO: Normal, Resultado Esperado: Se obtienen las asignaturas esperadas
 * CE17: Al consultarAsignaturaxPrograma con idPrograma == null, se deben obtener todas las asignaturas RE: Lista de Todas las asignaturas
 * CE18: Se debe poder registrar Un Nuevo Programa sin problemas; tipo: Normal; Resultado Esperado: La asignatura queda registrada y se puede consultar
 * CE19:Se debe poder insertar un nuevo horario a un profesor;tipo:Normal;resultado esperado : el profesor tiene el nuevo horario deseado 
 * CE20: Se debe poder agregar una clase a un curso; tipo :Normal ;resultado esperado : se agrega una nueva clase a un curso dado
 * CE21 No debe agregar si el profesor no tiene diponibilidad para la clase;tipo:frontera; resultado esperado: no se agrega la clase al profesor ni al curso
 * CE22 Se deben poder consultar las clases de un profesor; tipo: Normal ;resultado esperado: se pueden consultar las clases de un profesor dado
 * CE23 Se deben poder consultar las clases de un curso; tipo:Normal;resultado esperado : se pueden consultar las clases de un curso especifico
 * CE24 Se debe poder cancelar una clase;tipo:Normal;resultado esperado: se elimina  la clase  referenciada
 * CE25: Se debe poder registrar Un Nuevo Programa sin problemas; tipo: Normal; Resultado Esperado: El programa queda registrada y se puede consultar
 * CE26: Se debe poder registrar una nueva Asignatura sin problemas; tipo: Normal; Resultado Esperado: La asignatura queda registrada y se puede consultar
 */
public class UpTehoTest {
    private ServiciosUnidadProyectos serv;
    private Curso cursoTest;
    private Profesor profesorTest;
    private Materia materiaTest;
    private Periodo periodoTest;
    private Asignatura asignaturaTest;
    private Programa programaTest;
    private Date fechaTest;
    private Time horaTest;
    
    public UpTehoTest(){
    }

    @Before
    public void setUp(){
        serv = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        programaTest=new Programa(12,"PROGRAMADEPRUEBA");
        asignaturaTest=new Asignatura(58,"ASIGNATURADEPRUEBA",programaTest);
        materiaTest=new Materia("MDPR","MATERIADEPRUEBA",5,"PRUEBA",asignaturaTest);
        profesorTest=new Profesor(1014,"PROFESORDEPRUEBA","EMAILPRUEBA");
        java.util.Date fecha = new java.util.Date();
        fechaTest=new Date(fecha.getTime());
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        try{
            horaTest = new Time(formatter.parse("08:00").getTime());
        }catch(Exception e){
            fail("no se  pudo crear Time"+e);
        }
        periodoTest=new Periodo("2017-1",fechaTest,fechaTest);
        cursoTest=new Curso(56,profesorTest,materiaTest,periodoTest);   
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
    
    /**
     *  * CE12: Al registrar un nuevo Periodo con todos los datos correctos se debe agregar correctamente. TIPO: Normal; Resultado Esperado: Se registra el periodo
     */
    @Test
    public void registrarPeriodoCorrectamente() {
        ServiciosUnidadProyectos s = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            s.registrarPeriodo(new Periodo("2015-1", java.sql.Date.valueOf("2015-01-12"), java.sql.Date.valueOf("2015-05-27")));
            s.registrarPeriodo(new Periodo("2015-2", java.sql.Date.valueOf("2015-06-20"), java.sql.Date.valueOf("2015-11-11")));
            s.registrarPeriodo(new Periodo("2016-1", java.sql.Date.valueOf("2016-01-12"), java.sql.Date.valueOf("2015-05-27")));
            assertTrue("Se agregaron 3 valores correctamente", s.consultarPeriodos().size() == 3);
        } catch (UnidadProyectosException ex) {
        }
    }
    
    /**
     * CE13: Al registrar un periodo nuevo se debe tener un formato adecuado: año, guion y numero del semestre: AAAA-N; TIPO: Normal; Resultado Esperado: error si el formato es incorrecto
     */
    @Test
    public void formatoAdecuadoAlRegistrarPeriodo() {
        ServiciosUnidadProyectos s = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            s.registrarPeriodo(new Periodo("201581", java.sql.Date.valueOf("2015-01-12"), java.sql.Date.valueOf("2015-05-27")));
            fail("Se registro un periodo con formato incorrecto");
        } catch (UnidadProyectosException ex) {
        }
    }
    
    /**
     * CE14: Al consultar los periodos se debe obtener una lista de periodos con todos los datos;  TIPO:  Normal; Resultado Esperado: Lista de Periodos
     */
    @Test
    public void consultarTodosLosPeriodosCorrectamente() {
        ServiciosUnidadProyectos s = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            List<Periodo> lista = s.consultarPeriodos();
            s.registrarPeriodo(new Periodo("2013-1", java.sql.Date.valueOf("2013-01-12"), java.sql.Date.valueOf("2013-05-27")));
            lista = s.consultarPeriodos();
            assertTrue("Se comprueba que los datos (nombre) son correctos", lista.get(lista.size() - 1).getNombre().equals("2013-1"));
            assertTrue("Se comprueba que los datos (fechaInicial) son correctos)", lista.get(lista.size() - 1).getFechaInicial().equals(java.sql.Date.valueOf("2013-01-12")));
            assertTrue("Se comprueba que los datos (fechaFin) son correctos)", lista.get(lista.size() - 1).getFechaFin().equals(java.sql.Date.valueOf("2013-05-27")));
        } catch (UnidadProyectosException ex) {
            fail("Se lanzo una excepcion no esperada" + ex.getMessage());
        }
        
    }
    
    /**
     * CE15: Al registrar un cohorte con datos correctos se agrega correctamente; TIPO: Normal; Resultado Esperado: Se agrega el cohorte correctamente
     */
    @Test
    public void registrarCohorteCorrectamente() {
        ServiciosUnidadProyectos s = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            Profesor profesor = new Profesor(74, "Camilo Sanchez", "camilo.sanchez@mail.com");
            s.registrarProfesor(profesor);
            Programa programa = new Programa(6, "Programa Test");
            s.registrarPrograma(programa);
            Asignatura asignatura = new Asignatura(9, "Asignatura Test", programa);
            s.registrarAsignatura(asignatura.getId(), asignatura.getNombre(), asignatura.getPrograma().getId());
            Materia materia = new Materia("MATE", "Materia TEST", 3, "descripcion test", asignatura);
            s.registrarMateria(materia);
            Periodo periodo = new Periodo("2014-1", java.sql.Date.valueOf("2015-01-03"), java.sql.Date.valueOf("2015-06-05"));
            s.registrarPeriodo(periodo);
            Curso curso = new Curso(48, profesor, materia, periodo);
            s.registrarCurso(curso);
            int coh = 17;
            s.registrarCohorte(programa.getId(), curso.getId(), coh);
            int cohorte = s.consultarCohorte(curso, programa);
            if (cohorte == 0) fail("El cohorte no se registro correctamente");
            assertTrue("Comprobando que el cohorte fue el registrado", cohorte == coh);
        } catch (UnidadProyectosException ex) {
            fail("Se lanzo una excepcion no esperada" + ex.getMessage());
        }
    }
    
    /**
     * CE16: Al consultarAsignaturasxPrograma se debe obtener las asignaturas requerida TIPO: Normal, Resultado Esperado: Se obtienen las asignaturas esperadas
     */
    @Test
    public void consultarAsignaturasxProgramaCorrecta() {
        ServiciosUnidadProyectos s = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            Programa programa = new Programa(32, "Programa Test 32");
            s.registrarPrograma(programa);
            Asignatura asignatura = new Asignatura(65, "Asignatura Test 65", programa);
            s.registrarAsignatura(asignatura.getId(), asignatura.getNombre(), programa.getId());
            Programa programa2 = new Programa(30, "Programa Test 30");
            s.registrarPrograma(programa2);
            Asignatura asignatura2 = new Asignatura(66, "Asignatura Test 66", programa2);
            s.registrarAsignatura(asignatura2.getId(), asignatura2.getNombre(), programa2.getId());
            List<Asignatura> lista= s.consultarAsignaturasxPrograma(programa2.getId());
            assertEquals("Se comprueba que el id es el esperado", lista.get(lista.size() - 1).getId(), asignatura2.getId());
            assertEquals("Se comprueba que el nombre es el esperado", lista.get(lista.size() - 1).getNombre(), asignatura2.getNombre());
        } catch (UnidadProyectosException ex) {
            fail("Se lanzo una excepcion no esperada" + ex.getMessage());
        }
    }
    
    /**
     * * CE17: Al consultarAsignaturaxPrograma con idPrograma == null, se deben obtener todas las asignaturas RE: Lista de Todas las asignaturas
     */
    @Test
    public void testConsultarAsignaturasxProgramaConNull() {
        ServiciosUnidadProyectos s = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            Programa programa = new Programa(34, "Programa Test 34");
            s.registrarPrograma(programa);
            Asignatura asignatura = new Asignatura(67, "Asignatura Test 67", programa);
            s.registrarAsignatura(asignatura.getId(), asignatura.getNombre(), programa.getId());
            Programa programa2 = new Programa(37, "Programa Test 37");
            s.registrarPrograma(programa2);
            Asignatura asignatura2 = new Asignatura(68, "Asignatura Test 68", programa2);
            s.registrarAsignatura(asignatura2.getId(), asignatura2.getNombre(), programa2.getId());
            List<Asignatura> lista= s.consultarAsignaturasxPrograma(null);
            assertTrue("Se comprueba que se insertaron dos asignaturas", lista.size() >= 2);
        } catch (UnidadProyectosException ex) {
            fail("Se lanzo una excepcion no esperada" + ex.getMessage());
        }
    }
    
    /**
     * * CE18: Se debe poder registrar Un Nuevo Programa sin problemas; tipo: Normal; Resultado Esperado: El programa queda registrado y se puede consultar
     */
    @Test
    public void registroCorrectoDeProgramas() {
        ServiciosUnidadProyectos s = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        Programa programa = new Programa(40, "Programa Test 40");
        try {
            s.registrarPrograma(programa);
        } catch (UnidadProyectosException ex) {
            fail("Se lanzo una excepcion y no se registro el programa " + ex.getMessage());
        }
    }
    /**
     *  CE19:Se debe poder insertar un nuevo horario a un profesor;tipo:Normal;resultado esperado : el profesor tiene el nuevo horario deseado
     */
    @Test
    public void debeInsertarHorarioProfesor(){
        try{
            serv.registrarPeriodo(periodoTest);
            serv.registrarProfesor(profesorTest);
            serv.insertarHorarioProfesor(profesorTest.getId(),serv.obtenerDiaSemana(fechaTest), horaTest);
            List<HorarioDisponible> horarios=serv.consultarHorarioProfesor(profesorTest.getId());
            assertEquals("no se agregan los horarios",horarios.size(),1);
            assertEquals("no se agrego el horario correctamente",horarios.get(0).getDia(),serv.obtenerDiaSemana(fechaTest));
            assertEquals("no se agrego el horario correctamente",horarios.get(0).getHora(),horaTest);
            assertEquals("no se agrego el horario correctamente",horarios.get(0).getProfesor().getId(),profesorTest.getId());
        }catch(UnidadProyectosException ex){
            fail("No se inserto horario a el profesor " + ex.getMessage());
        }
    }
    /**
     * CE20: Se debe poder agregar una clase a un curso; tipo :Normal ;resultado esperado : se agrega una nueva clase a un curso dado
     */
    @Test
    public void debeAgregarClase(){
        try{
           
            serv.registrarPrograma(programaTest);
            serv.registrarAsignatura(asignaturaTest.getId(),asignaturaTest.getNombre() ,asignaturaTest.getPrograma().getId());
            serv.registrarMateria(materiaTest);
            serv.registrarCurso(cursoTest);
            serv.agregarClase(cursoTest.getId(),fechaTest , horaTest, "SalonDePrueba", profesorTest.getId());
            List<Clase> clases=serv.consultarClasesCurso(cursoTest.getId());
            assertEquals("no se agregan las clases",clases.size(),1);
            assertEquals("no se agrego la clase correctamente",clases.get(0).getCursoId(),cursoTest.getId());
            assertEquals("no se agrego la clase correctamente fecha",clases.get(0).getFecha().toString(),fechaTest.toString());
            assertEquals("no se agrego la clase correctamente",clases.get(0).getHora(),horaTest);
            assertEquals("no se agrego la clase correctamente",clases.get(0).getTipo_salon(),"SalonDePrueba");
            
        }catch(UnidadProyectosException ex){
            fail("No se agrego la clase debido a una inconsistencia" + ex.getMessage());
        }
    }
    /**
     * CE21 No debe agregar si el profesor no tiene diponibilidad para la clase;tipo:frontera; resultado esperado: no se agrega la clase al profesor ni al curso
     */
     @Test
    public void noDebeAgregarSiNoHayDiponibilidad(){
        try{
            DateFormat formatter = new SimpleDateFormat("HH:mm");
            horaTest = new Time(formatter.parse("07:00").getTime());
            serv.agregarClase(cursoTest.getId(),fechaTest , horaTest, "SalonDePrueba", profesorTest.getId());
            List<Clase> clases=serv.consultarClasesCurso(cursoTest.getId());
            assertEquals(" se agregan las clases",clases.size(),1);          
        }catch(Exception ex){
            fail("Ocurrio una inconsistencia" + ex.getMessage());
        }
    }
    /**
     * CE22 Se deben poder consultar las clases de un profesor; tipo: Normal ;resultado esperado: se pueden consultar las clases de un profesor dado
     */
     @Test
    public void seDebeConsultarClasesProfesor(){
        try{
            List<Clase> clases=serv.consultarClasesProfesor(profesorTest.getId());
            assertEquals("no se consultan las clases",clases.size(),1);          
        }catch(Exception ex){
            fail("No se consultaron las clases debido a una inconsistencia" + ex.getMessage());
        }
    }
    /**
     * CE23 Se deben poder consultar las clases de un curso; tipo:Normal;resultado esperado : se pueden consultar las clases de un curso especifico
     */
    @Test
    public void seDebeConsultarClasesDeUnCurso(){
        try{
            List<Clase> clases=serv.consultarClasesCurso(cursoTest.getId());
            assertEquals("no se consultan las clases",clases.size(),1);         
        }catch(Exception ex){
            fail("No se consultaron las clases debido a una inconsistencia" + ex.getMessage());
        }
    }
    @Test
    /**
     * CE24 Se debe poder cancelar una clase;tipo:Normal;resultado esperado: se elimina  la clase  referenciada
     */
    public void deberiaCancelarClase(){
        try{
            List<Clase> clases=serv.consultarClasesCurso(cursoTest.getId());
            serv.cancelarClase(1);
            clases=serv.consultarClasesCurso(cursoTest.getId());
             assertEquals("no se cancelo la clase",clases.size(),0);  
        }catch(Exception ex){
            fail("No se cancelo la clase debido a una inconsistencia" + ex.getMessage());
        }
    }
    
    
    /**
     * CE26: Se debe poder registrar una nueva Asignatura sin problemas; tipo: Normal; Resultado Esperado: La asignatura queda registrada y se puede consultar
     */
    @Test
    public void registroCorrectoDeAsignatura() {
        ServiciosUnidadProyectos s = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        int idprograma = 1;
        Programa programa = new Programa(idprograma, "Programa Test");
        Asignatura asignatura = new Asignatura(65,"Asignatura Test 65", programa);
        try {
            s.registrarPrograma(programa);
            s.registrarAsignatura(asignatura.getNombre(), programa.getId());
        } catch (UnidadProyectosException ex) {
            fail("Se lanzo una excepcion y no se registro la asignatura " + ex.getMessage());
        }
    }
}