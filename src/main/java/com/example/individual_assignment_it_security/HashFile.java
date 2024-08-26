package com.example.individual_assignment_it_security;

import org.codehaus.groovy.tools.shell.IO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HashFile implements CommandLineRunner {
    @Override
    public void run(String... args) throws IOException {
        System.out.println("HashFile fungerar");

        String tempLine;
        List<String> passwordList = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader
                (new FileReader("src/main/java/com/example/individual_assignment_it_security/files/Passwords.txt"))) {

            while ((tempLine = reader.readLine()) != null) {
                passwordList.add(tempLine);
            }
        }

        System.out.println(passwordList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/com/example/individual_assignment_it_security/files/Hashes.txt"))) {
            writer.write("bejs");
            writer.newLine();  // To add a newline
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

