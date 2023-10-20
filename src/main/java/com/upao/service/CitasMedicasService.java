package com.upao.service;

import com.upao.entity.CitasMedicas;
import com.upao.repository.CitasMedicasRepository;
import com.upao.utils.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.upao.utils.Global.*;

@Service
@Transactional
public class CitasMedicasService {
    private final CitasMedicasRepository citasMedicasRepository;

    public CitasMedicasService(CitasMedicasRepository citasMedicasRepository){
        this.citasMedicasRepository = citasMedicasRepository;
    }

    public GenericResponse<CitasMedicas> agendarCita(CitasMedicas citasMedicas){
        CitasMedicas nuevaCitaMedica = citasMedicasRepository.save(citasMedicas);

        if (nuevaCitaMedica != null){
            return new GenericResponse<>("data", 1, "Cita medica agendada con exito", nuevaCitaMedica);
        } else {
            return new GenericResponse<>("data", -1, "No se pudo agendar la cita médica", null);
        }
    }

    public GenericResponse<Iterable<CitasMedicas>> list() {
        return new GenericResponse<Iterable<CitasMedicas>>(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, citasMedicasRepository.list());
    }
}
