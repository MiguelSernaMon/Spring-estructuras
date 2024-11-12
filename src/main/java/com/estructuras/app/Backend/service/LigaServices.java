package com.estructuras.app.Backend.service;

import com.estructuras.app.Backend.models.Liga;
import com.estructuras.app.Backend.repositories.LigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LigaServices {
    @Autowired
    private LigaRepository repository;

    public Optional<Liga> getLigaById(int id) {
        return repository.findById(id);
    }
}
