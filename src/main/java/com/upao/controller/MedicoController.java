package com.upao.controller;

import com.upao.entity.Medico;
import com.upao.entity.Usuario;
import com.upao.service.MedicoService;
import com.upao.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/medico")
public class MedicoController {

    private MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public GenericResponse saveMedico(@Valid @RequestBody Usuario usuario) {
        return this.service.save(usuario);
    }

    @PutMapping("/{id}")
    public GenericResponse updateMedico(@PathVariable int id, @RequestBody Medico medico) {
        medico.setId(id);
        return this.service.updateMedico(id, medico);
    }

    @GetMapping
    public GenericResponse<Iterable<Medico>> listarMedicos() {
        return this.service.listarMedicos();
    }
}
