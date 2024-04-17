package com.example.proyectogrupal.models.repositories;

import com.example.proyectogrupal.models.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
