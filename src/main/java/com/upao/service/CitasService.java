package com.upao.service;

import com.upao.entity.*;
import com.upao.repository.*;
import com.upao.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class CitasService {

    @Autowired
    private CitasRepository citasRepository;

    @Autowired
    private FechasCitaRepository fechasCitaRepository;

    @Autowired
    private HorasCitasRepository horasCitasRepository;

    private DisponibilidadMedicoRepository disponibilidadMedicoRepository;

    // 1. Guardar Cita
    @Transactional
    public GenericResponse<String> guardarCita(Citas nuevaCita) {
        // Verificar si la fecha de la cita existe y está disponible
        Optional<FechasCitas> fechaCitaOpt = fechasCitaRepository.findById(nuevaCita.getFechaCita().getId());
        if (!fechaCitaOpt.isPresent()) {
            return new GenericResponse<>("Cita", 0, "La fecha de la cita no existe o no está disponible", null);
        }
        // Verificar si la hora de la cita existe y está disponible
        Optional<HorasCitas> horaCitaOpt = horasCitasRepository.findById(nuevaCita.getHoraCita().getId());
        if (!horaCitaOpt.isPresent() || !horaCitaOpt.get().getDisponible()) {
            return new GenericResponse<>("Cita", 0, "La hora de la cita no existe o no está disponible", null);
        }
        // Actualizar la disponibilidad de la hora de cita a 'false'
        HorasCitas horaCita = horaCitaOpt.get();
        horaCita.setDisponible(false);
        horasCitasRepository.save(horaCita);
        // Guardar la cita y obtener la cita guardada con su ID generado
        Citas citaGuardada = citasRepository.save(nuevaCita);
        return new GenericResponse("Cita", 1, "Cita guardada exitosamente", citaGuardada);
    }

    // 2. Buscar Cita por Paciente
    public GenericResponse<List<Citas>> buscarCitasPorPaciente(Integer pacienteId) {
        List<Citas> citas = citasRepository.findByPacienteId(pacienteId);
        return new GenericResponse<>("Lista de Citas", 1, "Citas encontradas", citas);
    }

    // 3. Aplazar Cita
    @Transactional
    public GenericResponse<Citas> aplazarCita(Long citaId, String nuevaFecha, String nuevaHora) {
        // Buscar la cita existente
        Optional<Citas> citaExistente = citasRepository.findById(citaId);
        if (!citaExistente.isPresent()) {
            return new GenericResponse<>("Cita", 0, "Cita no encontrada", null);
        }

        // Buscar la nueva fecha en FechasCitas
        Optional<FechasCitas> fechaCitaOpt = fechasCitaRepository.findByFecha(nuevaFecha);
        if (!fechaCitaOpt.isPresent()) {
            return new GenericResponse<>("Cita", 0, "La nueva fecha de cita no está disponible", null);
        }
        FechasCitas fechaCita = fechaCitaOpt.get();

        // Buscar la hora especificada en HorasCitas para la nueva fecha
        Optional<HorasCitas> horaCitaOpt = horasCitasRepository.findHorasDisponiblesEnFecha(nuevaFecha).stream()
                .filter(h -> h.getHora().equals(nuevaHora))
                .findFirst();
        if (!horaCitaOpt.isPresent()) {
            return new GenericResponse<>("Cita", 0, "La nueva hora de cita no está disponible", null);
        }

        // Actualizar la disponibilidad de la hora de cita anterior a 'true'
        HorasCitas horaCitaAnterior = citaExistente.get().getHoraCita();
        horaCitaAnterior.setDisponible(true);
        horasCitasRepository.save(horaCitaAnterior);

        // Actualizar la cita con la nueva fecha y hora
        Citas cita = citaExistente.get();
        cita.setFechaCita(fechaCita);
        cita.setHoraCita(horaCitaOpt.get());

        // Establecer la nueva hora como no disponible
        HorasCitas horaCitaNueva = horaCitaOpt.get();
        horaCitaNueva.setDisponible(false);
        horasCitasRepository.save(horaCitaNueva);

        // Guardar la cita actualizada
        Citas citaActualizada = citasRepository.save(cita);
        // Se muestra la cita actualizada
        return new GenericResponse<>("Cita", 1, "Cita aplazada exitosamente", citaActualizada);
    }



    // 4.. Eliminar Cita
    @Transactional
    public GenericResponse<String> eliminarCita(Long citaId) {
        Optional<Citas> cita = citasRepository.findById(citaId);
        if (!cita.isPresent()) {
            return new GenericResponse<>("Cita", 0, "Cita no encontrada", null);
        }

        // Actualizar la disponibilidad de la hora si es necesario
        HorasCitas horaCita = cita.get().getHoraCita();
        horaCita.setDisponible(true);
        horasCitasRepository.save(horaCita);

        // Eliminar la cita
        citasRepository.deleteById(citaId);
        return new GenericResponse<>("Cita", 1, "Cita eliminada exitosamente", null);
    }


    // 5. Buscar Horas Disponibles en una Fecha
    public GenericResponse<List<HorasCitas>> buscarHorasDisponibles(String fecha) {
        //Lógica para buscar horas disponibles en una fecha específica
        List<HorasCitas> horasDisponibles = horasCitasRepository.findHorasDisponiblesEnFecha(fecha);
        // Imprime las Horas disponibles de la fecha
        return new GenericResponse<>("List<HorasCitas>", 1, "Horas disponibles encontradas", horasDisponibles);
    }

    // 6. Buscar Fechas Disponibles
    public GenericResponse<List<String>> buscarFechasDisponibles() {
        // Este método no necesita cambios si findFechasDisponibles ya devuelve una List<String>
        List<String> fechasDisponibles = fechasCitaRepository.findFechasDisponibles();
        return new GenericResponse<>("List<String>", 1, "Fechas disponibles encontradas", fechasDisponibles);
    }
    // 7. Buscar Todas las citas
    public GenericResponse<List<Citas>> listarTodasLasCitas() {
        List<Citas> todasLasCitas = citasRepository.findAll();
        //Imprime todas las citas que hay en la base de datos.
        return new GenericResponse<>("List<Citas>", 1, "Todas las citas encontradas", todasLasCitas);
    }

    public GenericResponse<List<DisponibilidadMedico>> obtenerDoctoresDisponiblesPorFechaYEspecialidad(String fecha, String especialidad) {
        List<DisponibilidadMedico> disponibilidad = citasRepository.findByFechaAndEspecialidad(fecha, especialidad);
        return new GenericResponse<>("List<DisponibilidadMedico>", 1, "Doctores disponibles encontrados", disponibilidad);
    }
    // en general
    public GenericResponse<List<DisponibilidadMedico>> obtenercitasdisponibles(String fecha) {
        List<DisponibilidadMedico> disponibilidad = citasRepository.findByFecha(fecha);
        return new GenericResponse<>("List<DisponibilidadMedico>", 1, "Doctores disponibles encontrados", disponibilidad);
    }
    public GenericResponse<FechasCitas> agregarFechaConHoras(FechasCitas fechasCitas) {
        if(fechasCitas == null || fechasCitas.getFecha() == null || fechasCitas.getHorasCitas() == null) {
            // Log y manejo de error si la entrada es nula o incompleta
            return new GenericResponse<>("FechasCitas", -1, "Datos de entrada inválidos", null);
        }

        try {
            fechasCitas.getHorasCitas().forEach(horaCita -> horaCita.setFechaCita(fechasCitas));
            FechasCitas guardada = fechasCitaRepository.save(fechasCitas);
            return new GenericResponse<>("FechasCitas", 1, "Fecha y horas de citas agregadas", guardada);
        } catch (Exception e) {
            // Log y manejo de excepciones durante el guardado
            return new GenericResponse<>("FechasCitas", -1, "Error al guardar en base de datos: " + e.getMessage(), null);
        }
    }
    public GenericResponse<String> buscarEspecialidadPorId(Long citaId) {
        String especialidad = citasRepository.findEspecialidadByCitaId(citaId);
        if (especialidad != null) {
            return new GenericResponse<>("Especialidad", 1, "Especialidad encontrada", especialidad);
        } else {
            return new GenericResponse<>("Especialidad", -1, "Especialidad no encontrada", null);
        }
    }

}
