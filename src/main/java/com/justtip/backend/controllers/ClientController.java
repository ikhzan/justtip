package com.justtip.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping({"","index"})
    public String index(){
        return "index";
    }

    @GetMapping("about")
    public String about(){
        return "about";
    }

    @GetMapping("contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("services")
    public String services(){
        return "services";
    }

    @GetMapping("testimonials")
    public String testimonials(){
        return "testimonials";
    }

    @GetMapping("team")
    public String team(){
        return "team";
    }

    @GetMapping("pricing")
    public String pricing(){
        return "pricing";
    }

    @GetMapping("portfolio")
    public String portfolio(){
        return "portfolio";
    }
}
