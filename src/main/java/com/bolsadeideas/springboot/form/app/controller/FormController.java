package com.bolsadeideas.springboot.form.app.controller;

import com.bolsadeideas.springboot.form.app.model.domain.Usuario;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class FormController {
    @Autowired
    private UsuarioValidador usuarioValidador;

    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Bryan");
        usuario.setApellido("seros");
        usuario.setIdentificador("12.345.654-k");
        model.addAttribute("titulo","Formulario Usuario");
        model.addAttribute("usuario",usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){

        usuarioValidador.validate(usuario,result);
        model.addAttribute("titulo", "Resultado form");

        if(result.hasErrors()){
            /*Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err ->{
                errores.put(err.getField(),"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });
            model.addAttribute("error", errores);*/
            return "form";
        }

        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }
}
