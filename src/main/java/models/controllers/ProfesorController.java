package models.controllers;

import models.daos.ProfesorDao;
import models.entities.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    private final ProfesorDao profesorDao;

    @Autowired
    public ProfesorController(ProfesorDao profesorDao) {
        this.profesorDao = profesorDao;
    }

    @GetMapping
    public List<Profesor> findProfesores() {
        return profesorDao.findAll();
    }

    @GetMapping("/{id_profesor}")
    public String findById(@PathVariable Long id_profesor) {
        Optional<Profesor> profesor = profesorDao.findById(id_profesor);

        if (profesor.isPresent()) {
            return "teachers_list";
        } else {
            // Enviar una respuesta HTTP 404 si la tarea no se encuentra
            return String.valueOf(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }


    @PostMapping
    public Profesor createProfesor(@RequestBody Profesor profesor) {
        return profesorDao.createProfesor(profesor);
    }

    @PutMapping("/{id_profesor}")
    public Profesor updateProfesor(@PathVariable Long id_profesor, @RequestBody Profesor profesor){
        return profesorDao.updateProfesor(profesor, id_profesor);
    }

    @DeleteMapping("/{id_profesor}")
    public void deleteProfesor(@PathVariable Long id_profesor) {
        profesorDao.deleteProfesor(id_profesor);
    }

}
