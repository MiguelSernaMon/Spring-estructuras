package com.estructuras.app.Backend.controllers;


import com.estructuras.app.Backend.models.Respuesta;
import com.estructuras.app.Backend.service.RespuestaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/respuestas")
@CrossOrigin(origins = "*")
public class RespuestaController {
    @Autowired
    RespuestaServices service;

    @GetMapping
    public List<Respuesta> getRespuestasByQuestion(@RequestParam String questionId) {
        return service.getRespuestasByQuestionId(Long.valueOf(questionId));
    }
}
