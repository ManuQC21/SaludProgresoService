package com.upao.controller;

import com.upao.entity.RolUsuario;
import com.upao.entity.conversacion.Conversacion;
import com.upao.entity.conversacion.Mensaje;
import com.upao.service.ConversacionService;
import com.upao.utils.GenericResponse;
import com.upao.utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversaciones")
public class ConversacionController {

    @Autowired
    private ConversacionService conversacionService;

    @PostMapping("/iniciar")
    public ResponseEntity<GenericResponse<Conversacion>> iniciarConversacion(@RequestParam int pacienteId, @RequestParam int medicoId) {
        GenericResponse<Conversacion> response = conversacionService.iniciarOObtenerConversacion(pacienteId, medicoId);
        return new ResponseEntity<>(response, response.getRpta() == Global.RPTA_OK ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{conversacionId}/mensajes")
    public ResponseEntity<GenericResponse<List<Mensaje>>> obtenerMensajesDeConversacion(@PathVariable int conversacionId) {
        GenericResponse<List<Mensaje>> response = conversacionService.obtenerMensajesDeConversacion(conversacionId);
        return new ResponseEntity<>(response, response.getRpta() == Global.RPTA_OK ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    @GetMapping("/usuario/{usuarioId}/{rol}")
    public ResponseEntity<GenericResponse<List<Conversacion>>> listarConversacionesPorUsuario(@PathVariable int usuarioId, @PathVariable RolUsuario rol) {
        GenericResponse<List<Conversacion>> response = conversacionService.listarConversacionesPorUsuarioId(usuarioId, rol);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
