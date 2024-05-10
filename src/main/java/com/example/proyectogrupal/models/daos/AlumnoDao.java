package com.example.proyectogrupal.models.daos;

import com.example.proyectogrupal.models.entities.Alumno;

import java.util.List;
import java.util.Optional;

//Servicio de la entidad "alumno" (alumnoDao). Instancia de las funciones del CRUD (creaar, leeer y guardar, actualizar y borrar).
public interface AlumnoDao {
    List<Alumno> findAll();

    Optional<Alumno> findById(Long id_alumno);

    Alumno createAlumno(Alumno alumno);

    Alumno updateAlumno(Alumno alumno, Long id_alumno);

    Alumno save(Alumno alumno);

    void deleteAlumno(Long id_alumno);



}
