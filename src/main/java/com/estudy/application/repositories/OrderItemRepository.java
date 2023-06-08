package com.estudy.application.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.estudy.application.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
