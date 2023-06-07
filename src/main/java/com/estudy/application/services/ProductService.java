package com.estudy.application.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estudy.application.entities.Product;
import com.estudy.application.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}
