package com.example.proyectogrupal.models.daos;

import com.example.proyectogrupal.models.entities.Profesor;
import java.util.List;
import java.util.Optional;

//Servicio de la entidad "profesor" (profesorDao). Instancia de las funciones del CRUD (creaar, leeer y guardar, actualizar y borrar)

public interface ProfesorDao {
    List<Profesor> findAll();

    Optional<Profesor> findById(Long id_profesor);

    Profesor createProfesor(Profesor profesor);

    Profesor updateProfesor(Profesor profesor, Long id_profesor);

    Profesor save(Profesor profesor);

    void deleteProfesor(Long id_profesor);
}
