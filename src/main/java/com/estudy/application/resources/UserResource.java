package com.estudy.application.resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudy.application.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping()
    public ResponseEntity<User> findAll() {        
        User user = new User(1L, "joao", "joao@email.com", "87458788", "123456");
        
        return ResponseEntity.status(200).body(user);
    }
}
