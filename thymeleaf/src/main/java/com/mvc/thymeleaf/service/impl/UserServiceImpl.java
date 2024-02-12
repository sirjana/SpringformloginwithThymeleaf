package com.mvc.thymeleaf.service.impl;

import com.mvc.thymeleaf.dto.UserResponseDto;
import com.mvc.thymeleaf.dto.UsersRequestDto;
import com.mvc.thymeleaf.entity.Role;
import com.mvc.thymeleaf.entity.Users;
import com.mvc.thymeleaf.repository.RoleRepository;
import com.mvc.thymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

@Service
public class UserServiceImpl {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public UserResponseDto saveUser(UsersRequestDto usersRequestDto) {
        Users users = new Users();
        users.setRoles(usersRequestDto
                .getRoles()
                .stream()
                .map(role->roleRepository.findByName(role).orElseThrow(()->new RuntimeException("Role name not found")))
                .collect(Collectors.toSet()));
        users.setUsername(usersRequestDto.getUsername());
        users.setPassword(passwordEncoder.encode(usersRequestDto.getPassword()));
        userRepository.save(users);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setMessage("User saved Successfully");
        return userResponseDto;
    }
    public String greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }
   }
