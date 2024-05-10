package com.example.proyectogrupal.models.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LoginController {

    //Se mostrará el login de la página al iniciar el programa
    @GetMapping("/login")
    public String showMyLoginPage(){
        return "login";
    }


    /*@GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }*/


}

