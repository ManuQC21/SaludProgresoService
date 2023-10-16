package com.upao.controller;

import com.upao.entity.Paciente;
import com.upao.service.PacienteService;
import com.upao.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("api/paciente")
public class PacienteController {
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public GenericResponse save(@Valid @RequestBody Paciente c){
        return this.service.save(c);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody Paciente c){
        c.setID_Paciente(id);
        return this.service.save(c);
    }
}
