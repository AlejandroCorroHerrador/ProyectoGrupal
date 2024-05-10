package com.example.proyectogrupal.models.controllers;

import com.example.proyectogrupal.models.daos.AlumnoDao;
import com.example.proyectogrupal.models.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {


    @Autowired
    private final AlumnoDao alumnoDao;


    public AlumnoController(AlumnoDao alumnoDao) {
        this.alumnoDao = alumnoDao;
    }

    //Generá la lista de alumnos y si la encuentra la mostrará
    @GetMapping
    public String findAlumnos(Model model) {
        model.addAttribute("students", alumnoDao.findAll());
        return "students_list";
    }

    //Buscará el identificador de cada alumno
    @GetMapping("/{id_alumno}")
    public String findById(@PathVariable Long id_alumno) {
        Optional<Alumno> alumno = alumnoDao.findById(id_alumno);

        //Si se encuentra la tarea mostrará la lista de estudiantes
        if (alumno.isPresent()) {
            return "students_list";
        } else {
            // Enviar una respuesta HTTP 404 si la tarea no se encuentra
            return String.valueOf(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }


    //Mostrará el formulario de creación de la matrícula del alumnado
    @GetMapping("/create")
    public String createAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "create_student";
    }

    //En este método se almacenará la información generada a partir del método anterior
    @PostMapping("/save")
    public String newMenu(Model model, @ModelAttribute("alumno") Alumno alumno) {
        alumnoDao.createAlumno(alumno);
        return "redirect:/alumno";
    }

    //Aquí se enviará al formulario de actualización e la matrícula del alumnado
    @PostMapping("/update")
    public String updateAlumno(@ModelAttribute("alumno") Alumno alumno){
        alumnoDao.save(alumno);
        return "redirect:/alumno";
    }

    //Se buscará el id del alumnado elegido, y se le enviará a su correspondiente ficha de actualización
    @GetMapping("/update/{id_alumno}")
    public String updateFormAlumno(@PathVariable long id_alumno, Model model) {
        Optional<Alumno> alumno = alumnoDao.findById(id_alumno);
        if (alumno.isPresent()) {
            model.addAttribute("alumno", alumno.get());
            return "update_student"; // Nombre de la página de actualización
        } else {
            //Una vez acabada la operación, nos redirigirá a las listas del alumnado
            return "redirect:/alumno";
        }
    }

    //Borrará los datos del estudiante especificado
    @GetMapping("/delete/{id_alumno}")
    public String deleteAlumno(@PathVariable Long id_alumno) {
        alumnoDao.deleteAlumno(id_alumno);
        return "redirect:/alumno";
    }
}
