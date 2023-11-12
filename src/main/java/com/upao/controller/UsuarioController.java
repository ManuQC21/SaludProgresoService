package com.upao.controller;

import com.upao.entity.Usuario;
import com.upao.service.UsuarioService;
import com.upao.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request){
        String email = request.getParameter("correo");
        String contrasenia = request.getParameter("clave");
        return this.service.login(email, contrasenia);
    }
    @PostMapping
    public GenericResponse save(@Valid @RequestBody Usuario u){
        return this.service.guardarUsuario(u);
    }
    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @RequestBody Usuario u){
        return this.service.guardarUsuario(u);
    }
    @GetMapping
    public GenericResponse list() {
        return service.listar();
    }
}
