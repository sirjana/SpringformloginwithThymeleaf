package com.mvc.thymeleaf.config;

import com.mvc.thymeleaf.entity.Role;
import com.mvc.thymeleaf.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
@Configuration
public class InitialConfig {

    private RoleRepository roleRepository;

    public InitialConfig(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void setInitialRoles() {
        if (roleRepository.count() == 0) {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roleRepository.save(role1);
        roleRepository.save(role2);
        }
    }
}
