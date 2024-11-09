package com.estructuras.app.Backend.controllers;

import com.estructuras.app.Backend.models.Leccion;
import com.estructuras.app.Backend.service.LeccionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lecciones")
@CrossOrigin(origins = "*")
public class LeccionController {
    @Autowired
    LeccionServices service;
    @GetMapping
    public List<Leccion> getAllLessons(@RequestParam(required = true) String courseId) {
        System.out.println(courseId);
        System.out.println("holaaa");
        return service.getLessonsByCursoId(1L);

    }
}
