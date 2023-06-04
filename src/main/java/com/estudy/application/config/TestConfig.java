package com.estudy.application.config;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudy.application.entities.User;
import com.estudy.application.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    public void insertUserData() {
        User us1 = new User(null, "Joao", "joao@email.com", "8578545854", "123456");
        User us2 = new User(null, "Filipe", "filipe@email.com", "8578545548", "9874256");
        userRepository.saveAll(Arrays.asList(us1, us2));
    }

    @Override
    public void run(String... args) throws Exception {
        insertUserData();
    }
}
