package models.daos;

import models.entities.Alumno;
import models.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoDaoImpl implements AlumnoDao {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAll() {
        return this.alumnoRepository.findAll();
    }

    @Override
    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno updateAlumno(Alumno alumno) {
        return null;
    }

    @Override
    public void deleteAlumno(Long id_alumno) {
        alumnoRepository.deleteById(id_alumno);
    }
}
