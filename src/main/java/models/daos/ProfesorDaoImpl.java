package models.daos;

import models.entities.Profesor;
import models.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorDaoImpl implements ProfesorDao {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> findAll() {
        return this.profesorRepository.findAll();
    }

    @Override
    public Optional<Profesor> findById(Long id_profesor) {
        return profesorRepository.findById(id_profesor);
    }

    @Override
    public Profesor createProfesor(Profesor profesor) {
        return this.profesorRepository.save(profesor);
    }

    @Override
    public Profesor updateProfesor(Profesor profesor, Long id_profesor) {
        Profesor currentProfesor = profesorRepository.findById(profesor.getIdProfesor()).get();
        currentProfesor.setNombre_profesor(profesor.getNombre_profesor());
        currentProfesor.setApellido_profesor(profesor.getApellido_profesor());
        currentProfesor.setEmail(profesor.getEmail());
        currentProfesor.setAlumno(profesor.getAlumno());
        currentProfesor.setNombre_instituto(profesor.getNombre_instituto());
        currentProfesor.setDireccion(profesor.getDireccion());
        currentProfesor.setPoblacion(profesor.getPoblacion());
        currentProfesor.setCod_postal(profesor.getCod_postal());
        currentProfesor.setFase(profesor.getFase());
        return profesorRepository.save(currentProfesor);
    }

    @Override
    public void deleteProfesor(Long id_profesor) {
        Optional<Profesor> profesor = profesorRepository.findById(id_profesor);
        System.out.println(profesor);
        profesorRepository.deleteById(id_profesor);
    }
}
