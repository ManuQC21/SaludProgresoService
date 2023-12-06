package com.upao.service;

import com.upao.entity.RolUsuario;
import com.upao.entity.conversacion.Conversacion;
import com.upao.entity.conversacion.Mensaje;
import com.upao.repository.ConversacionRepository;
import com.upao.repository.MensajeRepository;
import com.upao.repository.UsuarioRepository;
import com.upao.utils.GenericResponse;
import com.upao.utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConversacionService {

    @Autowired
    private ConversacionRepository conversacionRepository;
    @Autowired
    private MensajeRepository mensajeRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public GenericResponse<Conversacion> iniciarOObtenerConversacion(int pacienteId, int medicoId) {
        Optional<Conversacion> existente = conversacionRepository.findByPacienteIdAndMedicoId(pacienteId, medicoId);
        if (existente.isPresent()) {
            return new GenericResponse<>(Global.TIPO_DATA, Global.RPTA_OK, Global.OPERACION_CORRECTA, existente.get());
        } else {
            Conversacion nuevaConversacion = new Conversacion();
            nuevaConversacion.setPaciente(usuarioRepository.findById(pacienteId).orElse(null).getPaciente());
            nuevaConversacion.setMedico(usuarioRepository.findById(medicoId).orElse(null).getMedico());
            return new GenericResponse<>(Global.TIPO_DATA, Global.RPTA_OK, Global.OPERACION_CORRECTA, conversacionRepository.save(nuevaConversacion));
        }
    }

    public GenericResponse<List<Mensaje>> obtenerMensajesDeConversacion(int conversacionId) {
        List<Mensaje> mensajes = mensajeRepository.findByConversacionId(conversacionId);
        if (!mensajes.isEmpty()) {
            return new GenericResponse<>(Global.TIPO_DATA, Global.RPTA_OK, Global.OPERACION_CORRECTA, mensajes);
        } else {
            return new GenericResponse<>(Global.TIPO_DATA, Global.RPTA_ERROR, Global.OPERACION_INCORRECTA, null);
        }
    }

    public GenericResponse<List<Conversacion>> listarConversacionesPorUsuarioId(int usuarioId, RolUsuario rol) {
        List<Conversacion> conversaciones;
        if (rol == RolUsuario.PACIENTE) {
            conversaciones = conversacionRepository.findByPacienteId(usuarioId);
        } else if (rol == RolUsuario.MEDICO) {
            conversaciones = conversacionRepository.findByMedicoId(usuarioId);
        } else {
            return new GenericResponse<>(Global.TIPO_DATA, Global.RPTA_ERROR, Global.OPERACION_ERRONEA, null);
        }

        if (conversaciones.isEmpty()) {
            return new GenericResponse<>(Global.TIPO_DATA, Global.RPTA_WARNING, "No se encontraron conversaciones", null);
        }

        return new GenericResponse<>(Global.TIPO_DATA, Global.RPTA_OK, Global.OPERACION_CORRECTA, conversaciones);
    }
}
