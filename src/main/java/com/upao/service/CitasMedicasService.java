package com.upao.service;

import com.upao.entity.CitasMedicas;
import com.upao.repository.CitasMedicasRepository;
import com.upao.utils.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.upao.utils.Global.*;

@Service
@Transactional
public class CitasMedicasService {
    private final CitasMedicasRepository citasMedicasRepository;

    public CitasMedicasService(CitasMedicasRepository citasMedicasRepository) {
        this.citasMedicasRepository = citasMedicasRepository;
    }

    public GenericResponse<CitasMedicas> agendarCita(CitasMedicas citasMedicas) {

        if (citasMedicasRepository.existCita(citasMedicas.getFechaHoraCita()) == 1) {
            return new GenericResponse<>("result", -1, "La cita no se pudo agendar: Ya existe una cita en la misma fecha y hora", null);
        }

        CitasMedicas nuevaCitaMedica = citasMedicasRepository.save(citasMedicas);

        if (nuevaCitaMedica != null) {
            return new GenericResponse<>("data", 1, "Cita médica agendada con éxito", nuevaCitaMedica);
        } else {
            return new GenericResponse<>("data", -1, "No se pudo agendar la cita médica", null);
        }
    }

    public GenericResponse<CitasMedicas> actualizarCita(int id, CitasMedicas citasMedicas) {
        Optional<CitasMedicas> citaExistente = citasMedicasRepository.findById(id);

        if (citaExistente.isPresent()) {

            if (citasMedicasRepository.existCitaUpdate(citasMedicas.getFechaHoraCita(), id) == 1) {
                return new GenericResponse<>("result", -1, "La cita no se pudo actualizar: Ya existe una cita en la misma fecha y hora", null);
            }

            CitasMedicas citaActualizada = citaExistente.get();
            citaActualizada.setFechaHoraCita(citasMedicas.getFechaHoraCita());
            citaActualizada.setAreaEspecialidad(citasMedicas.getAreaEspecialidad());
            citaActualizada.setComentarios(citasMedicas.getComentarios());
            citaActualizada.setMedico(citasMedicas.getMedico());
            citaActualizada.setRecordatorioCita(citasMedicas.isRecordatorioCita());

            CitasMedicas citaActualizadaGuardada = citasMedicasRepository.save(citaActualizada);

            return new GenericResponse<>("data", 1, "Cita médica actualizada con éxito", citaActualizadaGuardada);
        } else {
            return new GenericResponse<>("result", -1, "La cita no se pudo actualizar: La cita no existe", null);
        }
    }

    public GenericResponse<Iterable<CitasMedicas>> list() {
        return new GenericResponse<>("result", 1, "Operación correcta", citasMedicasRepository.findAll());
    }
}
