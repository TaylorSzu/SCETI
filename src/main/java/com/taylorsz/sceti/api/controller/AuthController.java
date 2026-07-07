package com.taylorsz.sceti.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taylorsz.sceti.api.dto.LoginDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationManager authenticationManager;

  @PostMapping
  public ResponseEntity<?> login(LoginDTO dto) {
    Authentication auth = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(dto.username(), dto.password()));
    return ResponseEntity.ok(dto);
  }
}
