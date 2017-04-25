-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-04-20 19:55:18.123

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
    Cursos_cohorte int  NOT NULL,
    id_clase int  NOT NULL,
    fecha_hora timestamp  NOT NULL,
    duracion time  NOT NULL,
    CONSTRAINT Clases_pk PRIMARY KEY (Cursos_cohorte,id_clase)
);

-- Table: Comites
CREATE TABLE Comites (
    id int  NOT NULL,
    fecha_hora timestamp  NOT NULL,
    CONSTRAINT Comites_pk PRIMARY KEY (id)
);

-- Table: Cursos
CREATE TABLE Cursos (
    cohorte int  NOT NULL,
    Profesor_id int  NOT NULL,
    Materias_sigla varchar(4)  NOT NULL,
    Periodo_nombre varchar(6)  NOT NULL,
    CONSTRAINT Cursos_pk PRIMARY KEY (cohorte)
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

-- Table: Periodo
CREATE TABLE Periodo (
    nombre varchar(6)  NOT NULL,
    fecha_inicio date  NOT NULL,
    fecha_fin date  NOT NULL,
    CONSTRAINT Periodo_pk PRIMARY KEY (nombre)
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
    Clases_Cursos_cohorte int  NOT NULL,
    Clases_id_clase int  NOT NULL,
    Recursos_id int  NOT NULL,
    CONSTRAINT RecursosdeClase_pk PRIMARY KEY (Clases_Cursos_cohorte,Clases_id_clase,Recursos_id)
);

-- Table: Requisitos
CREATE TABLE Requisitos (
    sigla_materia varchar(4)  NOT NULL,
    sigla_requisito varchar(4)  NOT NULL,
    tipo int  NOT NULL,
    CONSTRAINT Requisitos_pk PRIMARY KEY (sigla_materia,sigla_requisito)
);

-- Table: ReservacionSalones
CREATE TABLE ReservacionSalones (
    Clases_Cursos_cohorte int  NOT NULL,
    Clases_id_clase int  NOT NULL,
    Salon_id_salon varchar(10)  NOT NULL,
    CONSTRAINT ReservacionSalones_pk PRIMARY KEY (Clases_Cursos_cohorte,Clases_id_clase)
);

-- Table: Salon
CREATE TABLE Salon (
    id_salon varchar(10)  NOT NULL,
    tipo_salon varchar(10)  NOT NULL,
    CONSTRAINT Salon_pk PRIMARY KEY (id_salon)
);

-- foreign keys
-- Reference: Asignaturas_Programas (table: Asignaturas)
ALTER TABLE Asignaturas ADD CONSTRAINT Asignaturas_Programas
    FOREIGN KEY (Programas_id)
    REFERENCES Programas (id)  
;

-- Reference: Clases_Cursos (table: Clases)
ALTER TABLE Clases ADD CONSTRAINT Clases_Cursos
    FOREIGN KEY (Cursos_cohorte)
    REFERENCES Cursos (cohorte)  
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
    REFERENCES Periodo (nombre)  
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
    FOREIGN KEY (Clases_Cursos_cohorte, Clases_id_clase)
    REFERENCES Clases (Cursos_cohorte, id_clase) 
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

-- Reference: ReservacionSalones_Salon (table: ReservacionSalones)
ALTER TABLE ReservacionSalones ADD CONSTRAINT ReservacionSalones_Salon
    FOREIGN KEY (Salon_id_salon)
    REFERENCES Salon (id_salon)  
;

-- Reference: Salon_Clases (table: ReservacionSalones)
ALTER TABLE ReservacionSalones ADD CONSTRAINT Salon_Clases
    FOREIGN KEY (Clases_Cursos_cohorte, Clases_id_clase)
    REFERENCES Clases (Cursos_cohorte, id_clase)  
;

-- End of file.
