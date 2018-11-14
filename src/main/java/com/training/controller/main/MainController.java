package com.training.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.training.entities.training.user.User;

@Controller
public class MainController {

    @RequestMapping("/")
    public String welcome(final Model model) {
        model.addAttribute("currentUser", User.builder().name("Lorenzo").surname("cozza").build());
        return "welcome";
    }
}
