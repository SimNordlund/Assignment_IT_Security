package com.example.individual_assignment_it_security.controller;

import com.example.individual_assignment_it_security.service.CrackStationServiceImpl;
import com.example.individual_assignment_it_security.service.interfaces.CrackStationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;

@Controller
@PreAuthorize("isAuthenticated()")
public class CrackStationController {

    private final CrackStationService crackStationService;

    public CrackStationController(CrackStationServiceImpl crackStationService) {
        this.crackStationService = crackStationService;
    }


    @GetMapping("/crack")
    public String crackStationPage(@AuthenticationPrincipal OAuth2User oAuth2User,
                                   Model model) {
        return "crackstation";
    }

    @PostMapping("/crackHash")
    public String crackHash(@RequestParam String hashToCrack, Model model) throws FileNotFoundException {

        String crackedPasswordMD5 = crackStationService.crackMD5(hashToCrack);
        model.addAttribute("crackedPasswordMD5", crackedPasswordMD5);

        String crackedPasswordSHA256 = crackStationService.crackSHA256(hashToCrack);
        model.addAttribute("crackedPasswordSHA256", crackedPasswordSHA256);

        return "crackstationResult";
    }
}
