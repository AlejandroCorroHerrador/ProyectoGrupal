package models.daos;

import models.entities.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorDao {
    List<Profesor> findAll();

    Optional<Profesor> findById(Long id_profesor);

    Profesor createProfesor(Profesor profesor);

    Profesor updateProfesor(Profesor profesor, Long id_profesor);

    void deleteProfesor(Long id_profesor);
}
