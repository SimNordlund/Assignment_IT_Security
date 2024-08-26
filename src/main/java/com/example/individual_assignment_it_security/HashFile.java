package com.example.individual_assignment_it_security;

import org.codehaus.groovy.tools.shell.IO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@ComponentScan
public class HashFile implements CommandLineRunner {
    @Override
    public void run(String... args) throws IOException {
        System.out.println("HashFile fungerar");
    }
}
