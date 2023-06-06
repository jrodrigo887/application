package com.estudy.application.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.estudy.application.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
