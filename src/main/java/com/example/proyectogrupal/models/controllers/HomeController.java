package com.example.proyectogrupal.models.controllers;

import com.example.proyectogrupal.models.daos.AlumnoDao;
import com.example.proyectogrupal.models.daos.ProfesorDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final AlumnoDao alumnoDao;

    //private final ProfesorDao profesorDao;

    public HomeController(AlumnoDao alumnoDao) {
        this.alumnoDao = alumnoDao;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("students", alumnoDao.findAll());
        return "students_list";
    }

    /*@GetMapping("/")
    public String home(Model model){
        model.addAttribute("teachers", profesorDao.findAll());
        return "teachers_list";
    }*/



}
