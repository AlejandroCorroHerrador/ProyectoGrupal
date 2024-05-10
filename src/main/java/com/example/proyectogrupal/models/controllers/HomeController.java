package com.example.proyectogrupal.models.controllers;

import com.example.proyectogrupal.models.daos.AlumnoDao;
import com.example.proyectogrupal.models.daos.ProfesorDao;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final AlumnoDao alumnoDao;

    private final ProfesorDao profesorDao;

    public HomeController(AlumnoDao alumnoDao, ProfesorDao profesorDao) {
        this.alumnoDao = alumnoDao;
        this.profesorDao = profesorDao;
    }

    @GetMapping("/")
    public String home(Model model, Authentication authentication) {
        // Obtener el nombre de usuario autenticado
        String username = authentication.getName();

        // Comprobar a qué lista dirigir al usuario según su nombre de usuario
        if (username.equals("pau")) {
            // Si el usuario es "pau", cargar la lista de estudiantes
            model.addAttribute("students", alumnoDao.findAll());
            return "students_list";
        } else if (username.equals("borja") || username.equals("hector")) {
            // Si el usuario es "borja" o "hector", cargar la lista de profesores
            model.addAttribute("teachers", profesorDao.findAll());
            return "teachers_list";
        } else {
            // Por defecto, redirigir a la lista de estudiantes si el usuario no está específicamente mapeado
            model.addAttribute("students", alumnoDao.findAll());
            return "students_list";
        }
    }
}