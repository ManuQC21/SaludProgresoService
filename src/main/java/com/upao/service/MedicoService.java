package com.upao.service;

import com.upao.entity.Medico;
import com.upao.repository.MedicoRepository;
import com.upao.utils.GenericResponse;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import static com.upao.utils.Global.*;
import static com.upao.utils.Global.RPTA_OK;

@Service
@Transactional
public class MedicoService {

    private MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public GenericResponse savemedico(Medico m){
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Medico registrado correctamente", this.repository.save(m));
    }
}
