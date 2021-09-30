package com.asusoftware.testSecurity.service;

import com.asusoftware.testSecurity.model.User;
import com.asusoftware.testSecurity.model.dto.UserDto;
import com.asusoftware.testSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setUsername(user.getUsername());
            userDto.setUserRole(user.getUserRole());
            userDto.setPassword(user.getPassword());
            return userDto;
        }).collect(Collectors.toList());
    }

    public void create(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserRole(userDto.getUserRole());
        userRepository.save(user);
    }
}
