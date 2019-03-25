package com.training.controller.health;

import com.training.entities.health.Bodymeasurement.BodyMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.entities.health.Health;
import com.training.service.health.HealthService;

import java.util.List;

@RestController
public class HelthController {

	@Autowired
	private HealthService healthService;
	
	@GetMapping("/users/{userId}/health")
	public Health getHealthByUser(@PathVariable(name="userId") Long userId){
		return this.healthService.getHealthByUser(userId);
	}

	@GetMapping("/users/{userId}/health/body_measurements")
	public List<BodyMeasurement> getHealthBodyMeasurementsByUser(@PathVariable(name="userId") Long userId){
		return this.healthService.getHealthBodyMeasurementsByUser(userId);
	}
}
