package com.estudy.application.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estudy.application.entities.Order;
import com.estudy.application.repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
