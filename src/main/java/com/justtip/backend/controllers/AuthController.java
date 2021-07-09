package com.justtip.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("section","login");
        model.addAttribute("page-title","login");
        return "auths/login";
    }
}
