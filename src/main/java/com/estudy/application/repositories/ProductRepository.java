package com.estudy.application.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.estudy.application.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
