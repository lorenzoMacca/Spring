package com.training.controller.health;

import com.training.entities.health.Bodymeasurement.BodyMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.training.entities.health.Health;
import com.training.service.health.HealthService;

import java.util.List;

@RestController
public class HelthController {

	@Autowired
	private HealthService healthService;

	@GetMapping("/users/{userId}/health/body_measurements")
	public Health getHealthBodyMeasurementsByUser(@PathVariable(name="userId") Long userId){
		return this.healthService.getHealthByUser(userId);
	}
	
	@PostMapping("/users/health/body_measurements")
	public ResponseEntity<BodyMeasurement> saveBodyMEasurement(
			@RequestBody JsonNode bodyMEasurementJson){
		BodyMeasurement bodyMeasurementFromDb = this.healthService.save(bodyMEasurementJson);
		return new ResponseEntity<>(bodyMeasurementFromDb, HttpHeaders.EMPTY, HttpStatus.CREATED);
	}
}
