package com.upao.controller;

import com.upao.entity.conversacion.Mensaje;
import com.upao.service.MensajeService;
import com.upao.utils.GenericResponse;
import com.upao.utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @PostMapping("/enviar")
    public ResponseEntity<GenericResponse<Mensaje>> enviarMensaje(@RequestParam int conversacionId,
                                                                  @RequestParam int remitenteId,
                                                                  @RequestBody String contenido) {
        GenericResponse<Mensaje> response = mensajeService.enviarMensaje(conversacionId, remitenteId, contenido);
        return new ResponseEntity<>(response, response.getRpta() == Global.RPTA_OK ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
