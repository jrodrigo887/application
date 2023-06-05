package com.estudy.application.resources;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudy.application.entities.Order;
import com.estudy.application.services.OrderService;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    @Autowired
    private OrderService userService;
    @GetMapping("/")
    public ResponseEntity<List<Order>> findAll() {        
        List<Order> users = userService.findAll();
        
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {        
        Order user = userService.findOrderById(id);
        
        return ResponseEntity.status(200).body(user);
    }
}
