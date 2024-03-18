package models.daos;

import models.entities.Alumno;

import java.util.List;

public interface AlumnoDao {
    List<Alumno> findAll();

    Alumno createAlumno(Alumno alumno);

    Alumno updateAlumno(Alumno alumno);

    void deleteAlumno(Long id_alumno);



}
