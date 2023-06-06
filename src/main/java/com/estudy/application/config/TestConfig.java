package com.estudy.application.config;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudy.application.entities.Order;
import com.estudy.application.entities.User;
import com.estudy.application.entities.enums.OrderStatus;
import com.estudy.application.repositories.OrderRepository;
import com.estudy.application.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    public void insertUserData() {
        User us1 = new User(null, "Joao", "joao@email.com", "8578545854", "123456");
        User us2 = new User(null, "Filipe", "filipe@email.com", "8578545548", "9874256");
        
        Order ord1 = new Order(null, Instant.parse("2023-05-01T19:20:12Z"), OrderStatus.PAID, us1);
        Order ord2 = new Order(null, Instant.parse("2023-05-01T20:08:26Z"), OrderStatus.SHIPPED, us1);
        Order ord3 = new Order(null, Instant.parse("2023-05-01T20:16:13Z"), OrderStatus.PAID, us1);
        Order ord4 = new Order(null, Instant.parse("2023-05-01T18:16:13Z"), OrderStatus.SHIPPED, us2);
        Order ord5 = new Order(null, Instant.parse("2023-05-01T19:16:13Z"), OrderStatus.CANCELED, us2);
        userRepository.saveAll(Arrays.asList(us1, us2));
        orderRepository.saveAll(Arrays.asList(ord1, ord2, ord3, ord4, ord5));
    }

    @Override
    public void run(String... args) throws Exception {
        insertUserData();
    }
}
