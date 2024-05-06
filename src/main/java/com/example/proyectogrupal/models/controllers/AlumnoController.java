package com.example.proyectogrupal.models.controllers;

import com.example.proyectogrupal.models.daos.AlumnoDao;
import com.example.proyectogrupal.models.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {


    @Autowired
    private final AlumnoDao alumnoDao;


    public AlumnoController(AlumnoDao alumnoDao) {
        this.alumnoDao = alumnoDao;
    }

    @GetMapping
    public String findAlumnos(Model model) {
        model.addAttribute("students", alumnoDao.findAll());
        return "students_list";
    }
    @GetMapping("/{id_alumno}")
    public String findById(@PathVariable Long id_alumno) {
        Optional<Alumno> alumno = alumnoDao.findById(id_alumno);

        if (alumno.isPresent()) {
            return "students_list";
        } else {
            // Enviar una respuesta HTTP 404 si la tarea no se encuentra
            return String.valueOf(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }


    @GetMapping("/create")
    public String createAlumno(Model model) {
        //System.out.println("HOLA");
        model.addAttribute("alumno", new Alumno());
        return "create_student";
    }

    @PostMapping("/save")
    public String newMenu(Model model, @ModelAttribute("alumno") Alumno alumno) {
        alumnoDao.createAlumno(alumno);
        return "redirect:/alumno";
    }




    @GetMapping("/update/{id_alumno}")
    public String updateFormAlumno(@PathVariable long id_alumno, Model model) {
        Optional<Alumno> alumno = alumnoDao.findById(id_alumno);
        if (alumno.isPresent()) {
            model.addAttribute("alumno", alumno.get());
            return "update_student"; // Nombre de la página de actualización
        } else {
            return "redirect:/alumno";
        }
    }

    /*@DeleteMapping("/delete/")
    public String deleteAlumno(@PathVariable Long id_alumno) {
        alumnoDao.deleteAlumno(id_alumno);
        return "redirect:/alumno";
    }*/

    @PostMapping("/delete")
    public String deleteAlumno(@RequestParam Long id_alumno, Model model) {
        alumnoDao.deleteAlumno(id_alumno);
        return "redirect:/alumno";
    }
}
