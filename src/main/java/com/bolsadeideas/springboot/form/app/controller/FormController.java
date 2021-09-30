package com.bolsadeideas.springboot.form.app.controller;

import com.bolsadeideas.springboot.form.app.model.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("titulo","Formulario Usuario");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(Usuario usuario, Model model){

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
