package com.example.individual_assignment_it_security;

import com.example.individual_assignment_it_security.security.UserDataSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

@SpringBootApplication
public class IndividualAssignmentItSecurityApplication {

    @Autowired
    private UserDataSeeder userDataSeeder;

    public static void main(String[] args) {

        if (args.length == 0){
            SpringApplication.run(IndividualAssignmentItSecurityApplication.class, args);
            System.out.println("Hello, main is running");
        }
        else if (Objects.equals(args[0], "hashFile")) {
            SpringApplication application = new SpringApplication(HashFile.class);
            application.setWebApplicationType(WebApplicationType.NONE);
            application.run(args);
        }
    }

/*    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            userDataSeeder.Seed();
        };
    } */
}
