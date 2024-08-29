package com.example.individual_assignment_it_security.service.interfaces;

public interface CrackStationService {

    String crackMD5 (String hashToCrack);
    String crackSHA256 (String hashToCrack);
    String findMatch (String hashToCrack, String pathOfFile);

}
