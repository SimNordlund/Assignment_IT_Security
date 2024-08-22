package com.example.individual_assignment_it_security;

import com.example.individual_assignment_it_security.security.UserDataSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IndividualAssignmentItSecurityApplication {

    @Autowired
    private UserDataSeeder userDataSeeder;


    public static void main(String[] args) {
        SpringApplication.run(IndividualAssignmentItSecurityApplication.class, args);
        System.out.println("Hello");
        System.out.println("Hello2");
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            userDataSeeder.Seed();
        };
    }
}
