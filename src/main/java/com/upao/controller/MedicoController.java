package com.upao.controller;

import com.upao.entity.Medico;
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
    public GenericResponse savemedico(@Valid @RequestBody Medico m){
        return this.service.savemedico(m);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody Medico m){
        m.setId(id);
        return this.service.savemedico(m);
    }
}
