package me.xjn.bloglite.manager.controller;

import me.xjn.bloglite.manager.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired private LoginService loginService;

    @GetMapping(value = {"/", "/Home/Index"})
    public String index(Model model) {
        model.addAttribute("userName", "admin");
        return "/home/index";
    }

    @PostMapping(value = "/Home/Index")
    public String login(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value = "remember", required = false) String remember) {
        Object[] ret = loginService.login(username, password, remember != null);
        if (!(boolean)ret[0]){
            model.addAttribute("errorMsg", ret[1]);
        }
        return "/home/login";
    }

    @GetMapping(value = "/Home/Welcome")
    public String welcome(Model model){
        return "/home/welcome";
    }
}
