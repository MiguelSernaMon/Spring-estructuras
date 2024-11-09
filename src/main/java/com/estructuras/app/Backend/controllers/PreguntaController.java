package com.estructuras.app.Backend.controllers;

import com.estructuras.app.Backend.models.Pregunta;
import com.estructuras.app.Backend.service.PreguntaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/preguntas")
@CrossOrigin(origins = "*")
public class PreguntaController {
    @Autowired
    PreguntaServices service;

    @GetMapping
    public List<Pregunta> getPreguntasByLesson(@RequestParam String lessonId){
        return service.getPreguntasByLessonId(Long.valueOf(lessonId));
    }
}
