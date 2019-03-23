package com.training.controller.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.entities.health.Health;
import com.training.service.health.HealthService;

@RestController
public class HelthController {

	@Autowired
	private HealthService healthService;
	
	@GetMapping("/users/{userId}/health")
	public Iterable<Health> getHealthByUser(@PathVariable(name="userId") Long userId){
		return this.healthService.getHealthByUser(userId);
	}
}
