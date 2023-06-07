package com.estudy.application.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudy.application.entities.Category;
import com.estudy.application.entities.Order;
import com.estudy.application.entities.Product;
import com.estudy.application.entities.User;
import com.estudy.application.entities.enums.OrderStatus;
import com.estudy.application.repositories.CategoryRepository;
import com.estudy.application.repositories.OrderRepository;
import com.estudy.application.repositories.ProductRepository;
import com.estudy.application.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public void insertUserData() {
        User us1 = new User(null, "Joao", "joao@email.com", "8578545854", "123456");
        User us2 = new User(null, "Filipe", "filipe@email.com", "8578545548", "9874256");

        Order ord1 = new Order(null, Instant.parse("2023-05-01T19:20:12Z"), OrderStatus.PAID, us1);
        Order ord2 = new Order(null, Instant.parse("2023-05-01T20:08:26Z"), OrderStatus.SHIPPED, us1);
        Order ord3 = new Order(null, Instant.parse("2023-05-01T20:16:13Z"), OrderStatus.PAID, us1);
        Order ord4 = new Order(null, Instant.parse("2023-05-01T18:16:13Z"), OrderStatus.SHIPPED, us2);
        Order ord5 = new Order(null, Instant.parse("2023-05-01T19:16:13Z"), OrderStatus.CANCELED, us2);

        Category ct1 = new Category(null, "Eletronics");
        Category ct2 = new Category(null, "Books");
        Category ct3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        userRepository.saveAll(Arrays.asList(us1, us2));
        orderRepository.saveAll(Arrays.asList(ord1, ord2, ord3, ord4, ord5));
        categoryRepository.saveAll(Arrays.asList(ct1, ct2, ct3));
    }

    @Override
    public void run(String... args) throws Exception {
        insertUserData();
    }
}
