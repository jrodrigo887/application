package com.estudy.application.resources;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudy.application.entities.User;
import com.estudy.application.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {        
        List<User> users = userService.findAll();
        
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {        
        User user = userService.findUserById(id);
        
        return ResponseEntity.status(200).body(user);
    }
}
