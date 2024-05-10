package com.example.proyectogrupal.models.repositories;

import com.example.proyectogrupal.models.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio de la entidad "alumno"
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
