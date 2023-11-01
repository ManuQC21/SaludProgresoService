package com.upao.controller;

import com.upao.entity.CitasMedicas;
import com.upao.service.CitasMedicasService;
import com.upao.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/citas-medicas")
public class CitasMedicasController {
    private CitasMedicasService citasMedicasService;

    @Autowired
    public CitasMedicasController(CitasMedicasService citasMedicasService) {
        this.citasMedicasService = citasMedicasService;
    }

    @PostMapping("/agendar")
    public GenericResponse<CitasMedicas> agendarCita (@RequestBody CitasMedicas citasMedicas){
        return citasMedicasService.agendarCita(citasMedicas);
    }

    @GetMapping
    public GenericResponse list() {
        return citasMedicasService.list();
    }

    @PutMapping("/{id}")
    public GenericResponse<CitasMedicas> actualizarCita(@PathVariable int id, @RequestBody CitasMedicas citasMedicas) {
        return citasMedicasService.actualizarCita(id, citasMedicas);
    }
}
