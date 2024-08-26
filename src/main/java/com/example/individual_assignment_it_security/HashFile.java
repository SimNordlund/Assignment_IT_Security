package com.example.individual_assignment_it_security;

import com.example.individual_assignment_it_security.crack.MD5;
import org.springframework.boot.CommandLineRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HashFile implements CommandLineRunner {

    MD5 md5;

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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/com/example/individual_assignment_it_security/files/Hashes.txt"))) {

            for (int i = 0; i < passwordList.size(); i++) {
                writer.write(passwordList.get(i) + ":" + MD5.getMd5(passwordList.get(i)));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

