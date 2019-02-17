package com.training.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.core.training.swim.PoolLength;
import com.training.entities.training.user.User;
import com.training.service.training.swim.SwimminPlaceService;
import com.training.service.user.UserService;

@Controller
public class MainController {
	
	@Autowired
	SwimminPlaceService swimmingPlaceService;
	
	@Autowired
	UserService userService;

    @RequestMapping("/")
    public String welcome(final Model model) {
    	
    	List<User> users = (List<User>) userService.getAllUser();
    	User currentUser = users.get(0);
    	users.remove(currentUser);
    	
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("swimPLaces", this.swimmingPlaceService.getAll());
        model.addAttribute("POOL_LENGTH_25_METER",PoolLength.POOL_LENGTH_25_METER);
        model.addAttribute("POOL_LENGTH_50_METER",PoolLength.POOL_LENGTH_50_METER);
        model.addAttribute("POOL_LENGTH_31_METER",PoolLength.POOL_LENGTH_31_METER);
        model.addAttribute("users", users);
        return "welcome";
    }
}
