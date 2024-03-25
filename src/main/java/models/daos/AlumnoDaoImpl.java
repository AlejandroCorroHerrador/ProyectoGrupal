package models.daos;

import models.entities.Alumno;
import models.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoDaoImpl implements AlumnoDao {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAll() {
        return this.alumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> findById(Long id_alumno) {
        return alumnoRepository.findById(id_alumno);
    }

    @Override
    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }


    @Override
    public Alumno updateAlumno(Alumno alumno, Long id_alumno) {
        Alumno currentAlumno = alumnoRepository.findById(alumno.getIdAlumno()).get();
        currentAlumno.setNombre_alumno(alumno.getNombre_alumno());
        currentAlumno.setApellido_alumno(alumno.getApellido_alumno());
        currentAlumno.setEmail(alumno.getEmail());
        currentAlumno.setCurso(alumno.getCurso());
        currentAlumno.setGrupo(alumno.getGrupo());
        currentAlumno.setProfesor(alumno.getProfesor());
        currentAlumno.setUsername(alumno.getUsername());
        currentAlumno.setPassword(alumno.getPassword());
        currentAlumno.setComodin(alumno.getComodin());
        return alumnoRepository.save(currentAlumno);
    }

    @Override
    public void deleteAlumno(Long id_alumno) {
        Optional<Alumno> alumno = alumnoRepository.findById(id_alumno);
        System.out.println(alumno);
        alumnoRepository.deleteById(id_alumno);
    }
}
