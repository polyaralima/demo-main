package com.biblioteca.demo.authentication.controller;

import com.biblioteca.demo.authentication.model.UserModel;
import com.biblioteca.demo.authentication.service.TokenService;
import com.biblioteca.demo.authentication.service.UserDetailsServiceImpl;
import com.biblioteca.demo.dto.TokenDto;
import com.biblioteca.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@Controller
@RequestMapping("/auth")
public class UserModelController {

    @Autowired
    UserDetailsServiceImpl service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/criar-usuario", method = RequestMethod.POST)
    public ResponseEntity<UserDTO>  criarUsuario (@RequestBody UserDTO user) {

        return ResponseEntity.status(201).body(service.criarUsuario(user));
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<TokenDto>  login (@RequestBody UserModel user) {

        UsernamePasswordAuthenticationToken userToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication authentication =  this.authenticationManager.authenticate(userToken);

        var usuario = (UserModel) authentication.getPrincipal();

        return ResponseEntity.ok(tokenService.gerarToken(usuario));
    }

}