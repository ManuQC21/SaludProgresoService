package com.upao.service;

import com.upao.entity.conversacion.Conversacion;
import com.upao.entity.conversacion.Mensaje;
import com.upao.repository.ConversacionRepository;
import com.upao.repository.MensajeRepository;
import com.upao.repository.UsuarioRepository;
import com.upao.utils.GenericResponse;
import com.upao.utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;
    @Autowired
    private ConversacionRepository conversacionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public GenericResponse<Mensaje> enviarMensaje(int conversacionId, int remitenteId, String contenido) {
        Optional<Conversacion> conversacionOpt = conversacionRepository.findById(conversacionId);
        if (!conversacionOpt.isPresent()) {
            return new GenericResponse<>(Global.TIPO_DATA, Global.RPTA_ERROR, Global.OPERACION_ERRONEA, null);
        }
        Mensaje nuevoMensaje = new Mensaje();
        nuevoMensaje.setConversacion(conversacionOpt.get());
        nuevoMensaje.setRemitenteId(remitenteId);
        nuevoMensaje.setContenido(contenido);
        nuevoMensaje.setFechaHora(LocalDateTime.now());
        return new GenericResponse<>(Global.TIPO_DATA, Global.RPTA_OK, Global.OPERACION_CORRECTA, mensajeRepository.save(nuevoMensaje));
    }
}
