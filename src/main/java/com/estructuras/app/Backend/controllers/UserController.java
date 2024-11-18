/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras.app.Backend.controllers;

import com.estructuras.app.Backend.dto.LoginResponse;
import com.estructuras.app.Backend.dto.UsuarioLigaDTO;
import com.estructuras.app.Backend.models.LoginRequest;
import com.estructuras.app.Backend.service.UsuarioServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.estructuras.app.Backend.models.Usuario;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Miguel
 */

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Allow all origins
public class UserController {
    
    @Autowired
    private UsuarioServices service; 
    
    @GetMapping
    public List<Usuario> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/idusuario")
    public ResponseEntity<Usuario> getUserById(@RequestParam Long id) {
        Optional<Usuario> userById = service.getUserById(id);
        // Devuelve un 404 si el usuario no se encuentra
        return userById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/ligaData")
    public ResponseEntity<UsuarioLigaDTO> getLeagueById(@RequestParam("id") Long id) {
        Optional<UsuarioLigaDTO> usuarioDTO = service.getUserLigaById(id);
        return usuarioDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Usuario> createdUser(@RequestBody Usuario usuario){
        Usuario createUsuario = service.createUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUsuario);
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<Usuario> optionalUsuario = service.getUserByEmail(loginRequest.getEmail());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            String decodedPassword = service.decodeString(loginRequest.getPass());
            System.out.println(decodedPassword);
            boolean isPasswordValid = service.checkPassword(usuario, decodedPassword);
            if (isPasswordValid) {
                LoginResponse response = new LoginResponse(isPasswordValid, usuario.getId());
                return ResponseEntity.ok(response);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false, null));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false, null));
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        Optional<Usuario> updateUser = service.updateUser(id, usuario);
        return updateUser.map(ResponseEntity::ok).orElseGet(
        ()-> ResponseEntity.noContent().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id){
     
        boolean deleted = service.deleteUser(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
    
}
