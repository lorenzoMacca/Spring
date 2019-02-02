package com.training.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.training.entities.training.user.User;
import com.training.service.training.swim.SwimminPlaceService;

@Controller
public class MainController {
	
	@Autowired
	SwimminPlaceService swimmingPlaceService;

    @RequestMapping("/")
    public String welcome(final Model model) {
        model.addAttribute("currentUser", User.builder().name("Lorenzo").surname("cozza").build());
        model.addAttribute("swimPLaces", this.swimmingPlaceService.getAll());
        return "welcome";
    }
}
