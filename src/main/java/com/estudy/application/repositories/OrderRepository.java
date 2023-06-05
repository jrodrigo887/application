package com.estudy.application.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.estudy.application.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
