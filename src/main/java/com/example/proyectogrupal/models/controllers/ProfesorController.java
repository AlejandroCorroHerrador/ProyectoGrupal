package com.example.proyectogrupal.models.controllers;

import com.example.proyectogrupal.models.daos.ProfesorDao;
import com.example.proyectogrupal.models.entities.Alumno;
import com.example.proyectogrupal.models.entities.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

    private final ProfesorDao profesorDao;

    @Autowired
    public ProfesorController(ProfesorDao profesorDao) {
        this.profesorDao = profesorDao;
    }

    //Generá la lista de profesores y si la encuentra la mostrará
    @GetMapping
    public String findProfesores(Model model) {
        model.addAttribute("teachers", profesorDao.findAll());
        return "teachers_list";
    }

    //Buscará el identificador de cada docente
    @GetMapping("/{id_profesor}")
    public String findById(@PathVariable Long id_profesor) {
        Optional<Profesor> profesor = profesorDao.findById(id_profesor);

        //Si se encuentra la tarea mostrará la lista de profesores
        if (profesor.isPresent()) {
            return "teachers_list";
        } else {
            // Enviar una respuesta HTTP 404 si la tarea no se encuentra
            return String.valueOf(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }

    //Mostrará el formulario de creación de la matrícula del profesorado
    @GetMapping("/create")
    public String createProfesor(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "create_teacher";
    }


    //En este método se almacenará la información generada a partir del método anterior
    @PostMapping("/save")
    public String newMenu(Model model, @ModelAttribute("profesor") Profesor profesor) {
        profesorDao.createProfesor(profesor);
        return "redirect:/profesor";
    }

    //Aquí se enviará al formulario de actualización e la matrícula del preofesorado
    @PostMapping("/update")
    public String updateProfesor(@ModelAttribute("profesor") Profesor profesor){
        profesorDao.save(profesor);
        return "redirect:/profesor";
    }

    //Se buscará el id del docente elegido, y se le enviará a su correspondiente ficha de actualización
    @GetMapping("/update/{id_profesor}")
    public String updateFormProfesor(@PathVariable long id_profesor, Model model) {
        Optional<Profesor> profesor = profesorDao.findById(id_profesor);
        if (profesor.isPresent()) {
            model.addAttribute("profesor", profesor.get());
            return "update_teacher"; // Nombre de la página de actualización
        } else {
            return "redirect:/profesor";
        }
    }

    //Borrará los datos del profesor especificado
    @GetMapping("/delete/{id_profesor}")
    public String deleteProfesor(@PathVariable Long id_profesor) {
       profesorDao.deleteProfesor(id_profesor);
       return "redirect:/profesor";
    }
}