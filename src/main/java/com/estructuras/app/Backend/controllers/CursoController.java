/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras.app.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estructuras.app.Backend.service.CursoServices;
import com.estructuras.app.Backend.models.Curso;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author Miguel
 */
@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*") // Allow all origins
public class CursoController {
    @Autowired
    private CursoServices service;
    
    @GetMapping
    public List<Curso> getAllCourses(){
        return service.getAllCourses();
    }
}
