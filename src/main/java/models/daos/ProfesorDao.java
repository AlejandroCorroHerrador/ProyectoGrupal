package models.daos;

import models.entities.Profesor;

import java.util.List;

public interface ProfesorDao {
    List<Profesor> findAll();

    Profesor createProfesor(Profesor profesor);

    Profesor updateProfesor(Profesor profesor);

    void deleteProfesor(Long id_profesor);
}
