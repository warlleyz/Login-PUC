package com.pucminas.loginpuc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucminas.loginpuc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String email);

}