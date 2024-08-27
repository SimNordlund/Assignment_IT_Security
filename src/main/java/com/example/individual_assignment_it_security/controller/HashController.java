package com.example.individual_assignment_it_security.controller;

import com.example.individual_assignment_it_security.crack.MD5;
import com.example.individual_assignment_it_security.crack.SHA256;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("isAuthenticated()")
public class HashController {

    @GetMapping("/hash")
    public String hashPage(@AuthenticationPrincipal OAuth2User oauth2User,
                           Model model) {
        return "hashpassword";
    }

    @PostMapping("/createNewHash")
    public String createNewHash(@RequestParam String password, Model model){
        String hashedPasswordMD5 = MD5.getMD5(password);
        String hashedPasswordSHA256 = SHA256.getSHA256(password);

        model.addAttribute("hashedPasswordMD5", hashedPasswordMD5);
        model.addAttribute("hashedPasswordSHA256", hashedPasswordSHA256);

        return "hashpasswordResult";
    }


}
