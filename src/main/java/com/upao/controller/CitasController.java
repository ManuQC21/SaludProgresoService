package com.upao.controller;

import com.upao.entity.*;
import com.upao.repository.MedicoRepository;
import com.upao.service.CitasService;
import com.upao.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    private CitasService citasService;
    private MedicoRepository medicoRepository;

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
        GenericResponse<Citas> response = citasService.aplazarCita(citaId, nuevaFecha, nuevaHora);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{citaId}")
    public ResponseEntity<GenericResponse<String>> eliminarCita(@PathVariable Long citaId) {
        GenericResponse<String> response = citasService.eliminarCita(citaId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/horasDisponibles")
    public ResponseEntity<GenericResponse<List<Horario_Cita>>> buscarHorasDisponibles(@RequestParam String fecha) {
        GenericResponse<List<Horario_Cita>> response = citasService.buscarHorasDisponibles(fecha);
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

    @GetMapping("/obtenerPorFechaYEspecialidad")
    public ResponseEntity<GenericResponse<List<Agenda_Medica>>> obtenerDoctoresDisponiblesPorFechaYEspecialidad(
            @RequestParam String fecha,
            @RequestParam String especialidad) {
        GenericResponse<List<Agenda_Medica>> response = citasService.obtenerDoctoresDisponiblesPorFechaYEspecialidad(fecha, especialidad);
        return ResponseEntity.ok(response);
    }
    //en general:
    @GetMapping("/citasdisponibles")
    public ResponseEntity<GenericResponse<List<Agenda_Medica>>> obtenerCitasDisponibles(
            @RequestParam String fecha) {
        GenericResponse<List<Agenda_Medica>> response = citasService.obtenercitasdisponibles(fecha);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/agregarFechaConHoras")
    public ResponseEntity<GenericResponse<Programacion_Cita>> agregarFechaConHoras(@RequestBody Programacion_Cita fechasCitas) {
        // Convertir DTO a Entidad si estás utilizando un DTO

        System.out.println("Fecha: " + fechasCitas.getFecha());
        fechasCitas.getHorasCitas().forEach(hora -> System.out.println("Hora: " + hora.getHora() + ", Disponible: " + hora.getDisponible()));

        System.out.println("Recibido en agregarFechaConHoras: " + fechasCitas);

        try {
            GenericResponse<Programacion_Cita> response = citasService.agregarFechaConHoras(fechasCitas);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log del error
            System.err.println("Error en agregarFechaConHoras: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<>("FechasCitas", -1, "Error interno del servidor", null));
        }
    }

    @GetMapping("/{citaId}/especialidad")
    public ResponseEntity<GenericResponse<String>> obtenerEspecialidadPorId(@PathVariable Long citaId) {
        GenericResponse<String> response = citasService.buscarEspecialidadPorId(citaId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/vigentes")
    public ResponseEntity<GenericResponse<List<Citas>>> buscarCitasVigentes() {
        GenericResponse<List<Citas>> response = citasService.findCitasVigentes();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/vencidas")
    public ResponseEntity<GenericResponse<List<Citas>>> buscarCitasVencidas() {
        GenericResponse<List<Citas>> response = citasService.findCitasVencidas();
        return ResponseEntity.ok(response);
    }
}
