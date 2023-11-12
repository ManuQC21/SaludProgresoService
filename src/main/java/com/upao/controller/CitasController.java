package com.upao.controller;

import com.upao.entity.Citas;
import com.upao.entity.HorasCitas;
import com.upao.service.CitasService;
import com.upao.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    private CitasService citasService;

    @PostMapping("/guardar")
    public ResponseEntity<GenericResponse<String>> guardarCita(@RequestBody Citas nuevaCita) {
        GenericResponse<String> response = citasService.guardarCita(nuevaCita);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscarPorPaciente/{pacienteId}")
    public ResponseEntity<GenericResponse<List<Citas>>> buscarCitasPorPaciente(@PathVariable Integer pacienteId) {
        GenericResponse<List<Citas>> response = citasService.buscarCitasPorPaciente(pacienteId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/aplazar/{citaId}")
    public ResponseEntity<GenericResponse<Citas>> aplazarCita(@PathVariable Long citaId,
                                                              @RequestParam String nuevaFecha,
                                                              @RequestParam String nuevaHora) {
        LocalDate fecha = LocalDate.parse(nuevaFecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        GenericResponse<Citas> response = citasService.aplazarCita(citaId, fecha, nuevaHora);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{citaId}")
    public ResponseEntity<GenericResponse<String>> eliminarCita(@PathVariable Long citaId) {
        GenericResponse<String> response = citasService.eliminarCita(citaId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/horasDisponibles")
    public ResponseEntity<GenericResponse<List<HorasCitas>>> buscarHorasDisponibles(@RequestParam String fecha) {
        LocalDate fechaLocalDate = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        GenericResponse<List<HorasCitas>> response = citasService.buscarHorasDisponibles(fechaLocalDate);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fechasDisponibles")
    public ResponseEntity<GenericResponse<List<String>>> buscarFechasDisponibles() {
        GenericResponse<List<String>> response = citasService.buscarFechasDisponibles();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listarTodas")
    public ResponseEntity<GenericResponse<List<Citas>>> listarTodasLasCitas() {
        GenericResponse<List<Citas>> response = citasService.listarTodasLasCitas();
        return ResponseEntity.ok(response);
    }

}
