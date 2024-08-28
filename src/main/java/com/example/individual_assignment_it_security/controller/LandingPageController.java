package com.example.individual_assignment_it_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("isAuthenticated()")
public class LandingPageController {

    @GetMapping("/landing")
    public String landingPage(@AuthenticationPrincipal Object principal, Model model) {
        String name = null;

        if (principal instanceof OAuth2User oauth2User) {
            //För github
            name = oauth2User.getAttribute("name");
        } else if (principal instanceof UserDetails userDetails) {
            //För användare + lösen
            name = userDetails.getUsername();
        }

        model.addAttribute("name", name);
        return "landing";
    }
}
