package com.example.individual_assignment_it_security.service;

import com.example.individual_assignment_it_security.service.interfaces.CrackStationService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrackStationServiceImpl implements CrackStationService {

    @Override
    public String crackMD5(String hashToCrack) {
        String pathMD5 = "src/main/java/com/example/individual_assignment_it_security/files/HashesMD5.txt";
        return findMatch(hashToCrack, pathMD5);
    }

    @Override
    public String crackSHA256(String hashToCrack) {
        String pathSHA256 = "src/main/java/com/example/individual_assignment_it_security/files/HashesSHA256.txt";

        return findMatch(hashToCrack, pathSHA256);
    }

    @Override
    public String findMatch (String hashToCrack, String pathOfFile){

        String tempLine;
        List<String> passwordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader
                (new FileReader(pathOfFile))) {

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
        return "Fanns inte!";

    }
}
