package com.upao.service;

import com.upao.entity.Medico;
import com.upao.entity.RolUsuario;
import com.upao.entity.Usuario;
import com.upao.repository.MedicoRepository;
import com.upao.repository.UsuarioRepository;
import com.upao.utils.GenericResponse;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import static com.upao.utils.Global.*;
import static com.upao.utils.Global.RPTA_OK;

@Service
@Transactional
public class MedicoService {
    private MedicoRepository medicoRepository;
    private UsuarioRepository usuarioRepository;

    public MedicoService(MedicoRepository medicoRepository, UsuarioRepository usuarioRepository) {
        this.medicoRepository = medicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public GenericResponse save(Usuario medico) {
        if (!isValidMedico(medico)) {
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "El usuario no cumple los requisitos para ser médico.", null);
        }

        if (usuarioRepository.existsByEmail(medico.getEmail())) {
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Ya existe un médico con este correo electrónico.", null);
        }

        return new GenericResponse(TIPO_DATA, RPTA_OK, "Médico registrado correctamente", usuarioRepository.save(medico));
    }

    private boolean isValidMedico(Usuario medico) {
        return medico.getEmail().toLowerCase().endsWith("@saludprogreso.com") && medico.getClave().matches("\\d+");
    }

    public GenericResponse updateMedico(int id, Medico medicoData) {
        // Verificar que el médico con el ID especificado existe
        if (!medicoRepository.existsById(id)) {
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "No se encontró un médico con el ID especificado.", null);
        }

        // Obtener el médico existente
        Medico existingMedico = medicoRepository.findById(id).orElse(null);
        if (existingMedico != null) {
            // Actualizar solo los campos necesarios
            existingMedico.setNombreMedico(medicoData.getNombreMedico());
            existingMedico.setEspecialidad(medicoData.getEspecialidad());
            existingMedico.setFoto(medicoData.getFoto());

            // Guardar la actualización
            Medico updatedMedico = medicoRepository.save(existingMedico);

            return new GenericResponse(TIPO_DATA, RPTA_OK, "Médico actualizado correctamente", updatedMedico);
        }

        return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "No se pudo actualizar el médico.", null);
    }
    public GenericResponse<Iterable<Medico>> listarMedicos() {
        Iterable<Medico> medicos = medicoRepository.findAll();
        return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Lista de médicos obtenida correctamente", medicos);
    }
}
