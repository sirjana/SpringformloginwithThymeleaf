package com.mvc.thymeleaf.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.mvc.thymeleaf.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);
}
