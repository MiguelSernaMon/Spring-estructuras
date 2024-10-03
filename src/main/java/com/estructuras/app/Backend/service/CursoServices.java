/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras.app.Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estructuras.app.Backend.repositories.CursoRepository;
import java.util.List;

/**
 *
 * @author Miguel
 */
@Service
public class CursoServices {
    @Autowired
    private CursoRepository repository;
    public List getAllCourses(){
        return repository.findAll();
    }
}
