package com.estructuras.app.Backend.controllers;

import com.estructuras.app.Backend.models.Contenido;
import com.estructuras.app.Backend.service.ContenidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contenidos")
@CrossOrigin(origins = "*")
public class ContenidoController {
    @Autowired
    private ContenidoServices service;

    @GetMapping
    public List<Contenido> getContentsByLesson(@RequestParam String lessonId ) {
        return service.getContentByLessonId(Long.valueOf(lessonId));
    }
}
