package com.estudy.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudy.application.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
