package com.estudy.application.resources;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User obj) {        
        User user = userService.saveUser(obj); 
        URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
}
