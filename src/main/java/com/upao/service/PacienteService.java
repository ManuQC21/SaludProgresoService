package com.upao.service;

import com.upao.entity.Paciente;
import com.upao.repository.PacienteRepository;
import com.upao.utils.GenericResponse;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
import static com.upao.utils.Global.*;

@Service
@Transactional
public class PacienteService {
    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }


    public GenericResponse save(Paciente c){
        Optional<Paciente> opt = this.repository.findById(c.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        if(idf == 0){
            if(repository.existByDoc(c.getNumDoc().trim()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Lo sentimos: " +
                        "Ya existe un Paciente con ese mismo numero de documento, " +
                        "y si el problema persiste comuniquese con el soporte técnico", null);
            }else{

                c.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, "Paciente registrado correctamente", this.repository.save(c));
            }
        }else{

            if(repository.existByDocForUpdate(c.getNumDoc().trim(), c.getId()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Error: Ya existe un Paciente con esos mismos datos - " +
                        "verifique e intente de nuevo", null);
            }else{

                c.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del Paciente actualizado", this.repository.save(c));
            }
        }
    }
}