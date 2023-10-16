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

    //Método para guardar y actualizar paciente
    public GenericResponse save(Paciente c){
        Optional<Paciente> opt = this.repository.findById(c.getID_Paciente());
        int idf = opt.isPresent() ? opt.get().getID_Paciente() : 0;
        if(idf == 0){
            if(repository.existByDoc(c.getNumDoc().trim()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Lo sentimos: " +
                        "Ya existe un Paciente con ese mismo numero de documento, " +
                        "y si el problema persiste comuniquese con el soporte técnico", null);
            }else{
                //Guarda
                c.setID_Paciente(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, "Paciente registrado correctamente", this.repository.save(c));
            }
        }else{
            //Actualizar Registro
            if(repository.existByDocForUpdate(c.getNumDoc().trim(), c.getID_Paciente()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Error: Ya existe un Paciente con esos mismos datos - " +
                        "verifique e intente de nuevo", null);
            }else{
                //Actualiza
                c.setID_Paciente(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del Paciente actualizado", this.repository.save(c));
            }
        }
    }
}