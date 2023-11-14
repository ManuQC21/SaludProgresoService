package com.upao.controller;

import com.upao.entity.Medico;
import com.upao.entity.Usuario;
import com.upao.service.MedicoService;
import com.upao.utils.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/medico")
public class MedicoController {

    private MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }
    @PostMapping("/guardar")
    public GenericResponse saveMedico(@Valid @RequestBody Usuario usuario) {
        return this.service.save(usuario);
    }
    @PostMapping
    public GenericResponse guardarMedico(@Valid @RequestBody Medico medico) {
        return this.service.guardarMedico(medico);
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

    @GetMapping("/especialidades")
    public ResponseEntity<GenericResponse<List<String>>> listarEspecialidades() {
        GenericResponse<List<String>> response = service.listarEspecialidades();
        return ResponseEntity.ok(response);
    }
}
