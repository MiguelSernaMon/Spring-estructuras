package com.estructuras.app.Backend.controllers;

import com.estructuras.app.Backend.service.RespuestaXUsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/respuestas-usuario")
@CrossOrigin(origins = "*")
public class RespuestaXUsuarioController {
    @Autowired
    private RespuestaXUsuarioServices service;

    @PostMapping
    public ResponseEntity<?> sendResponse(@RequestParam String idUsuario,
                                          @RequestParam String idRespuesta,
                                          @RequestParam String isCorrect){
        return  service.sendAnswer(Long.valueOf(idUsuario),Long.valueOf(idRespuesta),Boolean.getBoolean(isCorrect));
    }
}
