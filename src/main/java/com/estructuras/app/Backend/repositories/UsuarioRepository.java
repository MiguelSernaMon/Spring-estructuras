/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.estructuras.app.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estructuras.app.Backend.models.Usuario;
import java.util.Optional;

/**
 *
 * @author Miguel
 */

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}