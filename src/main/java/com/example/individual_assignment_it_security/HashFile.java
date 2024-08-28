package com.example.individual_assignment_it_security;

import com.example.individual_assignment_it_security.crackUtilis.MD5;
import com.example.individual_assignment_it_security.crackUtilis.SHA256;
import org.springframework.boot.CommandLineRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HashFile implements CommandLineRunner {

    @Override
    public void run(String... args) throws IOException {
        System.out.println("HashFile fungerar");

        //Läser in data ifrån Passwords.txt
        String tempLine;
        List<String> passwordList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader
                (new FileReader("src/main/java/com/example/individual_assignment_it_security/files/Passwords.txt"))) {

            while ((tempLine = reader.readLine()) != null) {
                passwordList.add(tempLine);
            }
        }

        //Hashar lösenord ifrån Passwords.txt med MD5. Sparar i HashesMD5.
        try (BufferedWriter writerMD5 = new BufferedWriter(new FileWriter("src/main/java/com/example/individual_assignment_it_security/files/HashesMD5.txt"))) {

            for (String s : passwordList) {
                writerMD5.write(s + ":" + MD5.getMD5(s));
                writerMD5.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Hashar lösenord ifrån Passwords.txt med SHA256. Sparar i HashesSHA256.
        try (BufferedWriter writerSHA256 = new BufferedWriter(new FileWriter("src/main/java/com/example/individual_assignment_it_security/files/HashesSHA256.txt"))) {

            for (String s : passwordList) {
                writerSHA256.write(s + ":" + SHA256.getSHA256(s));
                writerSHA256.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

