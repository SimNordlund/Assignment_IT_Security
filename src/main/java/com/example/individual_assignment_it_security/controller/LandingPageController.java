package com.example.individual_assignment_it_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("/landing")
    public String landingPage(@AuthenticationPrincipal OAuth2User oauth2User, Model model) {
        String name = oauth2User.getAttribute("name");

        model.addAttribute("name", name);

        return "landing";
    }
}
