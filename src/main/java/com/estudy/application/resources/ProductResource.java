package com.estudy.application.resources;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudy.application.entities.Product;
import com.estudy.application.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> findAll() {        
        List<Product> users = productService.findAll();
        
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {        
        Product user = productService.findProductById(id);
        
        return ResponseEntity.status(200).body(user);
    }
}
