package com.pucminas.loginpuc.service;

import org.springframework.stereotype.Service;

import com.pucminas.loginpuc.model.Usuario;
import com.pucminas.loginpuc.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean emailExiste(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }

    public boolean usernameExiste(String username) {
        return usuarioRepository.findByUsername(username).isPresent();
    }
}