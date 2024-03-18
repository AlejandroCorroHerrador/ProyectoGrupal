package models.daos;

import models.entities.Profesor;
import models.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorDaoImpl implements ProfesorDao {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> findAll() {
        return this.profesorRepository.findAll();
    }

    @Override
    public Profesor createProfesor(Profesor profesor) {
        return this.profesorRepository.save(profesor);
    }

    @Override
    public Profesor updateProfesor(Profesor profesor) {
        return null;
    }

    @Override
    public void deleteProfesor(Long id_profesor) {
        profesorRepository.deleteById(id_profesor);
    }
}
