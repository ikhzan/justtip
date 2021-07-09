package com.justtip.backend.controllers;

import com.justtip.backend.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private BlogRepo blogRepo;

    @GetMapping({"","index"})
    public String index(Model model){
        model.addAttribute("section","index");
        model.addAttribute("page-title","home");
        return "index";
    }

    @GetMapping("about")
    public String about(Model model){
        model.addAttribute("section","about");
        model.addAttribute("page-title","about");
        return "pages/about";
    }

    @PostMapping("about")
    public String editabout(Model model){
        model.addAttribute("section","about");
        model.addAttribute("page-title","about");
        return "pages/about";
    }

    @GetMapping("contact")
    public String contact(Model model){
        model.addAttribute("section","contact");
        model.addAttribute("page-title","contact");
        return "pages/contact";
    }

    @GetMapping("services")
    public String services(Model model){
        model.addAttribute("section","services");
        model.addAttribute("data","mobile");
        model.addAttribute("page-title","services");
        return "pages/services";
    }

    @GetMapping("portfolio")
    public String portfolio(Model model){
        model.addAttribute("section","portfolio");
        model.addAttribute("page-title","portfolio");
        return "pages/portfolio";
    }

    @GetMapping("json_provider")
    public String jsonprovider(Model model){
        model.addAttribute("section","json_provider");
        model.addAttribute("page-title","rest-api");
        return "pages/json_provider";
    }

    @GetMapping("web")
    public String web(Model model){
        model.addAttribute("section","web");
        model.addAttribute("page-title","rest-api");
        return "pages/web";
    }

    @GetMapping("error")
    public String error_page(Model model){
        model.addAttribute("section","error");
        model.addAttribute("page-title","error");
        return "pages/error";
    }

    @GetMapping("mobile")
    public String mobile(Model model){
        model.addAttribute("section","mobile");
        model.addAttribute("page-title","mobile");
        return "pages/mobile";
    }

    @GetMapping("marketing")
    public String marketing(Model model){
        model.addAttribute("section","error");
        model.addAttribute("page-title","error");
        return "pages/marketing";
    }

    @GetMapping("policy")
    public String policy(Model model){
        model.addAttribute("section","policy");
        model.addAttribute("page-title","policy");
        return "pages/policy";
    }

    @GetMapping("users")
    public String userList(Model model){
        model.addAttribute("section","policy");
        model.addAttribute("page-title","policy");
        return "pages/users";
    }
}
