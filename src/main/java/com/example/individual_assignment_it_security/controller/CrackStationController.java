package com.example.individual_assignment_it_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("isAuthenticated()")
public class CrackStationController {

    @GetMapping("/crack")
    public String crackStationPage(@AuthenticationPrincipal OAuth2User oAuth2User,
                               Model model) {
        return "crackstation";
    }
}
