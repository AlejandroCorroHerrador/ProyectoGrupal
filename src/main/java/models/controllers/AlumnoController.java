package models.controllers;

import models.daos.AlumnoDao;
import models.entities.Alumno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {


    private final AlumnoDao alumnoDao;


    public AlumnoController(AlumnoDao alumnoDao) {
        this.alumnoDao = alumnoDao;
    }

    @GetMapping
    public List<Alumno> findAlumnos() {
        return alumnoDao.findAll();
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


    @PostMapping("/alumno/create")
    public String createAlumno(@RequestBody Model model) {
        model.addAttribute("student", new Alumno());
        return "create_student";
    }

    @PostMapping("/alumno/save")
    public String newMenu(Model model, @ModelAttribute("alumno") Alumno alumno) {
        alumnoDao.createAlumno(alumno);
        return "redirect:/alumno";
    }

    @PutMapping("alumno/update/{id_alumno}")
    public String updateAlumno(@PathVariable Long id_alumno, @RequestBody Alumno alumno){
        alumnoDao.updateAlumno(alumno, id_alumno);
        return "update_student";
    }

    @GetMapping("/alumno/update/{id_alumno}")
    public String updateFormAlumno(@PathVariable long id_alumno, Model model) {
        Optional<Alumno> alumno = alumnoDao.findById(id_alumno);
        if (alumno.isPresent()) {
            model.addAttribute("alumno", alumno.get());
            return "update_student"; // Nombre de la página de actualización
        } else {
            return "redirect:/alumno";
        }
    }

    @DeleteMapping("alumno/delete/{id_alumno}")
    public String deleteAlumno(@PathVariable Long id_alumno) {
        alumnoDao.deleteAlumno(id_alumno);
        return "redirect:/alumno";
    }


}
