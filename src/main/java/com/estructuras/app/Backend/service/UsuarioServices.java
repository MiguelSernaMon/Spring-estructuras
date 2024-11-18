/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras.app.Backend.service;

import com.estructuras.app.Backend.dto.UsuarioLigaDTO;
import com.estructuras.app.Backend.models.Liga;
import com.estructuras.app.Backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estructuras.app.Backend.models.Usuario;
import java.util.Base64;
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
    
    public static String decodeString(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes);
    }

    public Optional<UsuarioLigaDTO> getUserLigaById(Long id) {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isPresent()) {
            Usuario u = usuario.get();
            // Retornamos el DTO con la ligaId y los puntos
            return Optional.of(new UsuarioLigaDTO(u.getLiga() != null ? u.getLiga().getId() : null, u.getPuntosLiga()));
        }
        return Optional.empty();
    }
    
    public Optional<Usuario> getUserById(Long id){
        return repository.findById(id);
    }
    
    public Optional<Usuario> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
    
    public Usuario createUser(Usuario usuario) {
        String decodedPass = decodeString(usuario.getPassword());
        String hashedPassword = passwordEncoder.encode(decodedPass);
        usuario.setPassword(hashedPassword);
        Liga leagueNewUser = new Liga();
        leagueNewUser.setNombre("Liga de Otoño");
        leagueNewUser.setId(3);
        usuario.setLiga(leagueNewUser);
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
