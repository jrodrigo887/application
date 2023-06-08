package com.estudy.application.resources;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private OrderService orderService;
    @GetMapping("/")
    public ResponseEntity<List<Order>> findAll() {        
        List<Order> orders = orderService.findAll();
        
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {        
        Order order = orderService.findOrderById(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
}
