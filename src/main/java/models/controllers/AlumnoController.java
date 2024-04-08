package models.controllers;

import models.daos.AlumnoDao;
import models.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private final AlumnoDao alumnoDao;


    public AlumnoController(AlumnoDao alumnoDao) {
        this.alumnoDao = alumnoDao;
    }

    @GetMapping
    public List<Alumno> findAlumnos() {
        return alumnoDao.findAll();
    }

    @GetMapping("/{id_alumno}")
    public ResponseEntity<Alumno> findById(@PathVariable Long id_alumno) {
        Optional<Alumno> alumno = alumnoDao.findById(id_alumno);

        if (alumno.isPresent()) {
            return new ResponseEntity<>(alumno.get(), HttpStatus.OK);
        } else {
            // Enviar una respuesta HTTP 404 si la tarea no se encuentra
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoDao.createAlumno(alumno);
    }

    @PutMapping("/{id_alumno}")
    public Alumno updateAlumno(@PathVariable Long id_alumno, @RequestBody Alumno alumno){
        return alumnoDao.updateAlumno(alumno, id_alumno);
    }

    @DeleteMapping("/{id_alumno}")
    public void deleteAlumno(@PathVariable Long id_alumno) {
        alumnoDao.deleteAlumno(id_alumno);
    }
}
