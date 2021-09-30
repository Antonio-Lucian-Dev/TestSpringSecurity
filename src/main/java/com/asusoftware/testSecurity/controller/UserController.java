package com.asusoftware.testSecurity.controller;

import com.asusoftware.testSecurity.model.User;
import com.asusoftware.testSecurity.model.dto.UserDto;
import com.asusoftware.testSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> findAllUsers(Authentication authentication) {
        // Authentication ci da l'utente corrente loggato
        log.info(String.valueOf(authentication.getPrincipal()));
        return userService.findAllUsers();
    }

    @PostMapping(path = "/create")
    public void create(@Valid @RequestBody UserDto userDto) {
        userService.create(userDto);
    }
}
