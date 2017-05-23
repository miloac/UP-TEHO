-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-04-27 17:04:25.01

-- tables
-- Table: Asignaturas
CREATE TABLE Asignaturas (
    id int  NOT NULL,
    nombre varchar(50)  NOT NULL,
    Programas_id int  NOT NULL,
    CONSTRAINT Asignaturas_pk PRIMARY KEY (id)
);

-- Table: Clases
CREATE TABLE Clases (
    Cursos_id int  NOT NULL,
    id_clase int  NOT NULL,
    fecha date  NOT NULL,
    hora time  NOT NULL,
    tipo_salon varchar(15)  NOT NULL,
    CONSTRAINT Clases_pk PRIMARY KEY (Cursos_id,id_clase)
);

-- Table: Cohortes
CREATE TABLE Cohortes (
    Programas_id int  NOT NULL,
    Cursos_id int  NOT NULL,
    cohorte int  NOT NULL,
    CONSTRAINT Cohortes_pk PRIMARY KEY (Programas_id,Cursos_id)
);

-- Table: Comites
CREATE TABLE Comites (
    id int  NOT NULL,
    fecha_hora timestamp  NOT NULL,
    CONSTRAINT Comites_pk PRIMARY KEY (id)
);

-- Table: Cursos
CREATE TABLE Cursos (
    id int  NOT NULL,
    Profesor_id int  NOT NULL,
    Materias_sigla varchar(4)  NOT NULL,
    Periodo_nombre varchar(6)  NOT NULL,
    CONSTRAINT Cursos_pk PRIMARY KEY (id)
);

-- Table: HorarioDispRecurso
CREATE TABLE HorarioDispRecurso (
    Recursos_id int  NOT NULL,
    fecha_hora timestamp  NOT NULL,
    CONSTRAINT HorarioDispRecurso_pk PRIMARY KEY (Recursos_id,fecha_hora)
);

-- Table: HorarioDisponible
CREATE TABLE HorarioDisponible (
    Profesores_id int  NOT NULL,
    dia varchar(2)  NOT NULL,
    hora time  NOT NULL,
    CONSTRAINT HorarioDisponible_pk PRIMARY KEY (Profesores_id,dia,hora)
);

-- Table: IntegrantesComites
CREATE TABLE IntegrantesComites (
    Profesores_id int  NOT NULL,
    Comites_id int  NOT NULL,
    CONSTRAINT IntegrantesComites_pk PRIMARY KEY (Profesores_id,Comites_id)
);

-- Table: Materias
CREATE TABLE Materias (
    sigla varchar(4)  NOT NULL,
    nombre varchar(50)  NOT NULL,
    creditos int  NOT NULL,
    descripcion varchar(100)  NOT NULL,
    Asignaturas_id int  NOT NULL,
    CONSTRAINT Materias_pk PRIMARY KEY (sigla)
);

-- Table: Periodos
CREATE TABLE Periodos (
    nombre varchar(6)  NOT NULL,
    fecha_inicio date  NOT NULL,
    fecha_fin date  NOT NULL,
    CONSTRAINT Periodos_pk PRIMARY KEY (nombre)
);

-- Table: Profesores
CREATE TABLE Profesores (
    id int  NOT NULL,
    nombre varchar(50)  NOT NULL,
    correo varchar(50)  NOT NULL,
    CONSTRAINT Profesores_pk PRIMARY KEY (id)
);

-- Table: Programas
CREATE TABLE Programas (
    id int  NOT NULL,
    nombre varchar(40)  NOT NULL,
    CONSTRAINT Programas_pk PRIMARY KEY (id)
);

-- Table: Recursos
CREATE TABLE Recursos (
    id int  NOT NULL,
    nombre varchar(50)  NOT NULL,
    CONSTRAINT Recursos_pk PRIMARY KEY (id)
);

-- Table: RecursosdeClase
CREATE TABLE RecursosdeClase (
    Clases_Curso_id int  NOT NULL,
    Clases_id_clase int  NOT NULL,
    Recursos_id int  NOT NULL,
    CONSTRAINT RecursosdeClase_pk PRIMARY KEY (Clases_Curso_id,Clases_id_clase,Recursos_id)
);

-- Table: Requisitos
CREATE TABLE Requisitos (
    sigla_materia varchar(4)  NOT NULL,
    sigla_requisito varchar(4)  NOT NULL,
    tipo int  NOT NULL,
    CONSTRAINT Requisitos_pk PRIMARY KEY (sigla_materia,sigla_requisito)
);

--Table: materiasporprograma
CREATE TABLE Materiasporprograma(
	idPrograma int NOT NULL,
	siglaMateria varchar(4) NOT NULL,
	CONSTRAINT Materiasporprograma_pk PRIMARY KEY (idPrograma,siglaMateria)
);

-- Table: Usuarios
CREATE TABLE Usuarios (
    id int  NOT NULL,
    nombre varchar(20)  NOT NULL,
    apellido varchar(20)  NOT NULL,
    rol varchar(2)  NOT NULL,
    CONSTRAINT Usuarios_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Asignaturas_Programas (table: Asignaturas)
ALTER TABLE Asignaturas ADD CONSTRAINT Asignaturas_Programas
    FOREIGN KEY (Programas_id)
    REFERENCES Programas (id)  
;

-- Reference: Clases_Cursos (table: Clases)
ALTER TABLE Clases ADD CONSTRAINT Clases_Cursos
    FOREIGN KEY (Cursos_id)
    REFERENCES Cursos (id)  
;

-- Reference: Cohortes_Cursos (table: Cohortes)
ALTER TABLE Cohortes ADD CONSTRAINT Cohortes_Cursos
    FOREIGN KEY (Cursos_id)
    REFERENCES Cursos (id)  
;

-- Reference: Cohortes_Programas (table: Cohortes)
ALTER TABLE Cohortes ADD CONSTRAINT Cohortes_Programas
    FOREIGN KEY (Programas_id)
    REFERENCES Programas (id)  
;

-- Reference: Curso_Materias (table: Cursos)
ALTER TABLE Cursos ADD CONSTRAINT Curso_Materias
    FOREIGN KEY (Materias_sigla)
    REFERENCES Materias (sigla)  
;

-- Reference: Curso_Profesores (table: Cursos)
ALTER TABLE Cursos ADD CONSTRAINT Curso_Profesores
    FOREIGN KEY (Profesor_id)
    REFERENCES Profesores (id)  
;

-- Reference: Cursos_Periodo (table: Cursos)
ALTER TABLE Cursos ADD CONSTRAINT Cursos_Periodo
    FOREIGN KEY (Periodo_nombre)
    REFERENCES Periodos (nombre)  
;

-- Reference: HorarioDispRecurso_Recursos (table: HorarioDispRecurso)
ALTER TABLE HorarioDispRecurso ADD CONSTRAINT HorarioDispRecurso_Recursos
    FOREIGN KEY (Recursos_id)
    REFERENCES Recursos (id)  
;

-- Reference: HorarioDisponible_Profesores (table: HorarioDisponible)
ALTER TABLE HorarioDisponible ADD CONSTRAINT HorarioDisponible_Profesores
    FOREIGN KEY (Profesores_id)
    REFERENCES Profesores (id)  
;

-- Reference: IntegrantesComites_Comites (table: IntegrantesComites)
ALTER TABLE IntegrantesComites ADD CONSTRAINT IntegrantesComites_Comites
    FOREIGN KEY (Comites_id)
    REFERENCES Comites (id)  
;

-- Reference: IntegrantesComites_Profesores (table: IntegrantesComites)
ALTER TABLE IntegrantesComites ADD CONSTRAINT IntegrantesComites_Profesores
    FOREIGN KEY (Profesores_id)
    REFERENCES Profesores (id)  
;

-- Reference: Materias_Asignaturas (table: Materias)
ALTER TABLE Materias ADD CONSTRAINT Materias_Asignaturas
    FOREIGN KEY (Asignaturas_id)
    REFERENCES Asignaturas (id)  
;

-- Reference: RecursosdeClase_Clases (table: RecursosdeClase)
ALTER TABLE RecursosdeClase ADD CONSTRAINT RecursosdeClase_Clases
    FOREIGN KEY (Clases_Curso_id, Clases_id_clase)
    REFERENCES Clases (Cursos_id, id_clase)  
;

-- Reference: RecursosdeClase_Recursos (table: RecursosdeClase)
ALTER TABLE RecursosdeClase ADD CONSTRAINT RecursosdeClase_Recursos
    FOREIGN KEY (Recursos_id)
    REFERENCES Recursos (id)  
;

-- Reference: Requisitos_Materias (table: Requisitos)
ALTER TABLE Requisitos ADD CONSTRAINT Requisitos_Materias
    FOREIGN KEY (sigla_requisito)
    REFERENCES Materias (sigla)  
;

-- Reference: Requisitos_Materias2 (table: Requisitos)
ALTER TABLE Requisitos ADD CONSTRAINT Requisitos_Materias2
    FOREIGN KEY (sigla_materia)
    REFERENCES Materias (sigla)  
;

-- Reference: Materias_programas (table: Materiasporprograma)
    ALTER TABLE Materiasporprograma ADD CONSTRAINT Materias_programas
    FOREIGN KEY (idPrograma)
    REFERENCES programas (id)  
;

-- Reference: Materias_programas2 (table: Materiasporprograma)
    ALTER TABLE Materiasporprograma ADD CONSTRAINT Materias_programas2
    FOREIGN KEY (siglaMateria)
    REFERENCES Materias (sigla)  
;

-- End of file.

