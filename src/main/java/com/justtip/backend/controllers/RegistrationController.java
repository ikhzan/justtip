package com.justtip.backend.controllers;

import com.justtip.backend.models.User;
import com.justtip.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String showRegisterForm(Model model){
        model.addAttribute("user",new User());
        return "auths/register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User user, BindingResult result){
        userRepo.save(user);
        return "redirect:/registration?success";
    }
}
