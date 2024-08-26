package com.example.individual_assignment_it_security;

import org.codehaus.groovy.tools.shell.IO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HashFile implements CommandLineRunner {
    @Override
    public void run(String... args) throws IOException {
        System.out.println("HashFile fungerar");
    }
}
