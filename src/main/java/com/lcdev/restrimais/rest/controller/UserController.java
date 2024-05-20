package com.lcdev.restrimais.rest.controller;

import com.lcdev.restrimais.rest.dto.user.UserLoggedDTO;
import com.lcdev.restrimais.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserServiceImpl service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserLoggedDTO> getMe(){
        UserLoggedDTO dto = service.getMe();
        return ResponseEntity.ok(dto);
    }

}
