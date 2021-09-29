package com.asusoftware.testSecurity.controller;

import com.asusoftware.testSecurity.model.User;
import com.asusoftware.testSecurity.model.dto.UserDto;
import com.asusoftware.testSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping(path = "/create")
    public void create(@Valid @RequestBody UserDto userDto) {
        userService.create(userDto);
    }
}
