package com.example.individual_assignment_it_security.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrackStationServiceImpl {

    public String crackMD5(String hashToCrack) {
        String tempLine;
        List<String> passwordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader
                (new FileReader("src/main/java/com/example/individual_assignment_it_security/files/HashesMD5.txt"))) {

            while ((tempLine = reader.readLine()) != null) {
                passwordList.add(tempLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : passwordList) {
            int index = line.indexOf(':');
            String password = line.substring(0, index);
            String hash = line.substring(index + 1);

            if (hashToCrack.equals(hash)) {
                return password;
            }
        }
        return "Not found";
    }

    public String crackSHA256(String hashToCrack) {
        String tempLine;
        List<String> passwordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader
                (new FileReader("src/main/java/com/example/individual_assignment_it_security/files/HashesSHA256.txt"))) {

            while ((tempLine = reader.readLine()) != null) {
                passwordList.add(tempLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : passwordList) {
            int index = line.indexOf(':');
            String password = line.substring(0, index);
            String hash = line.substring(index + 1);

            if (hashToCrack.equals(hash)) {
                return password;
            }
        }
        return "Not found";
    }
}
