/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras.app.Backend.service;

import com.estructuras.app.Backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estructuras.app.Backend.models.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Miguel
 */

@Service
public class UsuarioServices {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UsuarioRepository repository;
    
    public List<Usuario> getAllUsers(){
        return repository.findAll();
    }
    
    public Optional<Usuario> getUserById(Long id){
        return repository.findById(id);
    }
    
    public Optional<Usuario> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
    
    public Usuario createUser(Usuario usuario) {
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hashedPassword);
        return repository.save(usuario);
    }
    
    public boolean checkPassword(Usuario usuario ,String pass) {
        return passwordEncoder.matches(pass, usuario.getPassword());
    }
    
    public Optional<Usuario> updateUser(Long id, Usuario usuario){
        if(!repository.existsById(id)){
            return Optional.empty();
        }
        usuario.setId(id);
        return Optional.of(repository.save(usuario));
    }
    
    public boolean deleteUser(Long id){
        if(!repository.existsById(id)){
            return false;
        }
        repository.deleteById(id);
        return true;
    }
    
}
