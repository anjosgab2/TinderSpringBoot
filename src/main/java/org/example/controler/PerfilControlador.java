package org.example.controler;

import org.example.model.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class PerfilControlador {

    @GetMapping
    public String teste() {
        return "Controller funcionando!";
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuario;
    }
}