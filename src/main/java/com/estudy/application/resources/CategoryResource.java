package com.estudy.application.resources;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudy.application.entities.Category;
import com.estudy.application.services.CategoryService;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    @Autowired
    private CategoryService userService;
    @GetMapping("/")
    public ResponseEntity<List<Category>> findAll() {        
        List<Category> users = userService.findAll();
        
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {        
        Category user = userService.findCategoryById(id);
        
        return ResponseEntity.status(200).body(user);
    }
}
