# UP-TEHO

ESCUELA COLOMBIANA DE INGENIERÍA JULIO GARAVITO

PROCESOS DE DESARROLLO DE SOFTWARE 2017-1

PROFESOR: Hector Fabio Cadavid Rengifo [Dueño del Producto]

INTEGRANTES: 

* Daniel Ospina [TEAM] [SCRUM MASTER]
* Andrés Felipe Pardo [TEAM]
* Juan Villate [TEAM]
* Jefferson Castañeda [TEAM]
* Juan Camilo Mantilla [TEAM]
* Gabriel Peña [TEAM]

## DESCRIPCIÓN DEL PRODUCTO

El proyecto fue planteado como una solución para el registro de los programas de Postgrado, manejados por la Unidad de Proyectos de la Escuela Colombiana de Ingeniería Julio Garavito.  
Su propósito principal es el de poder mantener un control más organizado de las planeaciones que se llevan y se hacen para la programación semanal de los cursos, automatizando el proceso actual, permitiendo un manejo de registros historicos a largo plazo.

La función principal del proyecto permite ver un reporte de programación semestral, detallando las diferentes materias inscritas, con sus datos respectivos.
![](img/ReporteProgramacion.PNG?raw=true)

El botón de consultar permite conocer los datos especificos para las sesiones existentes de la materia seleccionada, con la opcion de agregar una nueva sesion, acorde al horario del profesor.
![](img/ProgramarSesion.PNG?raw=true)

Se tiene un reporte de salones, el cual permite ver que tipo de salones de cada tipo están disponibles en diferentes fechas, permitiendo buscar por periodo.
![](img/ReporteSalones.PNG?raw=true)

También hay un reporte de las Materias, organizadas por el programa.
![](img/ReporteMaterias.PNG?raw=true)

Para la programación de los cursos, se tiene su registro propio, al registrar un curso, este aparece disponible en el reporte de programación, donde es posible definir sus sesiones.
![](img/ProgramarCurso.PNG?raw=true)

## ARQUITECTURA Y DISEÑO DETALLADO
### Modelo Entidad Relación
![](img/modelo_ER.png?raw=true)

### Diagrama de Clases
El modelo se encuentra seccionado en sus partes más importantes

#### Servicios
![](img/servicios.png?raw=true)

#### Entidades
![](img/entities.png?raw=true)

#### Mappers
![](img/mappers.png?raw=true)

#### DAOs
![](img/daos.png?raw=true)

#### MyBatis
![](img/mybatis.png?raw=true)

### Tecnologías utilizadas

#### Apache Shiro
![](img/ApacheShiro.PNG?raw=true)
Un poderoso y sencillo Framework de seguridad de Java. Cuenta con funciones de autenticación, autorización, criptografía, y manejo de sesiones. Es versatil y permite asegurar desde aplicaciones móviles hasta grandes aplicaciones web. [Página oficial.](https://shiro.apache.org/)

#### PrimeFaces
![](img/PrimeFaces.PNG?raw=true)
Una biblioteca de JavaServerFaces que facilita el desarrollo de aplicaciones web con una gran variedad de componentes disponibles para diseño web. [Página oficial.](https://www.primefaces.org/)

#### Google Guice
![](img/GoogleGuice.png?raw=true)
Framework de inyección de dependencias de Java, la cual pretende evitar el uso de fabricas, al automatizarlas haciendo que el código no sea dependiente de estas, y que sea más flexible en su edicion, manejo de pruebas y reusabilidad. [Repositorio oficial.](https://github.com/google/guice)

#### Postgres SQL
![](img/Postgres.PNG?raw=true)
Sistema de gestión de bases de datos objeto-relacionales, de código abierto y el más potente del mercado. [Página oficial.](https://www.postgresql.org/)

### Aplicación
![](img/Inicio.PNG?raw=true)
La aplicación se puede acceder haciendo [click aqui.](https://up-teho.herokuapp.com/UnidadProyectos/index.xhtml "UP-TEHO")

## DESCRIPCION DEL PROCESO

### Metodología
La forma de planeamiento utilizada por el equipo se hizo siguiendo el modelo de SCRUM, el cual consiste en dividir los requerimientos del proyecto en diferentes "historias de usuario", las cuales son valoradas con "puntos de historia" bajo una votación del equipo. Estas son registradas bajo el nombre de "Backlog del proyecto". Para cada Sprint se se define el "Backlog del Sprint" escogiendo un número determinado de historias de usuario, las cuales son divididas entre los integrantes del equipo dependiendo del valor que cada una de estas tenga.  
Para el trabajo del proyecto, se utilizó la funcionalidad de github conocida como *fork*, la cual crea una copia vinculada directamente con el repositorio principal, en donde cada integrante puede realizar su progreso y subir sus cambios a su propia version del proyecto. Una vez se tenga una versión correcta y funcional de lo que cada integrante haya implementado, se hace un *pull-request* al repositorio principal, lo cual mezcla los cambios realizados por el integrante con los ya presentes, manteniendo el orden cronológico de los cambios.

### Backlog del proyecto
El backlog del proyecto puede accederse haciendo [click aqui.](https://trello.com/b/bZFNLwbJ/2017-1-proypdsw-pcvpmo "Backlog UP-TEHO")

### Release Burndown Chart
![](img/BurndownChart.PNG?raw=true)
Las historias de usuario realizadas fueron:
* Generar reporte de programación semestral
* Generar reporte de salones
* Registrar materia
* Programar materia
* Generar horario de profesor

Los faltantes fueron:
* Generar reporte de recursos
* Registro de recursos
* Enviar recordatorio
* Registrar profesor

### Sprint 1

#### Backlog
![](img/BacklogS1.PNG?raw=true)

#### Burndown Chart
![](img/BurndownS1.PNG?raw=true)

#### Reporte GIT
![](img/GraficaS1.PNG?raw=true)

Para este primer Sprint se dedicó mucho tiempo al diseño de la base de datos y al final se tuvo que trabajar apresuradamente para terminar los requerimientos, fue una etapa de adaptación al estilo de trabajo del SCRUM y nos dejó ver que debiamos mejorar para los siguientes Sprints.

### Sprint 2

#### Backlog
![](img/BacklogS2.PNG?raw=true)

#### Burndown Chart
![](img/BurndownS2.PNG?raw=true)

#### Reporte GIT
![](img/GraficaS2.PNG?raw=true)

En este Sprint el trabajo distribuido entre el equipo fue mejor que en el anterior, pues cada persona estuvo a cargo de diferentes funcionalidades, lo cual permitió un trabajo más eficaz y arduo entre todos.

### Sprint 3

#### Backlog
![](img/BacklogS3.PNG?raw=true)

#### Burndown Chart
![](img/BurndownS3.PNG?raw=true)

#### Reporte GIT
![](img/GraficaS2.PNG?raw=true)

### Reporte de pruebas
![](img/tests.png?raw=true)

### Reporte de cubrimiento
![](img/Cubrimiento.PNG?raw=true)
