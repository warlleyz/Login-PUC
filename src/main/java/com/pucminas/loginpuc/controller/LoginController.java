package com.pucminas.loginpuc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pucminas.loginpuc.model.Usuario;
import com.pucminas.loginpuc.service.UsuarioService;

@Controller
public class LoginController {
    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String cadastrar(
            String name,
            String username,
            String email,
            String password,
            String confirmPassword,
            Model model
    ) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("erro", "As senhas não coincidem.");
            return "register";
        }

        if (usuarioService.emailExiste(email)) {
            model.addAttribute("erro", "Este e-mail já está cadastrado.");
            return "register";
        }

        if (usuarioService.usernameExiste(username)) {
            model.addAttribute("erro", "Este usuário já está cadastrado.");
            return "register";
        }

        Usuario usuario = new Usuario(
                name,
                username,
                email,
                password
        );

        usuarioService.salvar(usuario);

        return "redirect:/login";
    }
}