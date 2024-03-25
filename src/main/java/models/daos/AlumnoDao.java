package models.daos;

import models.entities.Alumno;
import models.entities.Profesor;

import java.util.List;
import java.util.Optional;

public interface AlumnoDao {
    List<Alumno> findAll();

    Optional<Alumno> findById(Long id_alumno);

    Alumno createAlumno(Alumno alumno);

    Alumno updateAlumno(Alumno alumno, Long id_alumno);

    void deleteAlumno(Long id_alumno);



}
