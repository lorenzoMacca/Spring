package com.training.service.health;
import com.training.entities.health.Bodymeasurement.BodyMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.querydsl.core.types.Predicate;
import com.training.entities.common.EntityConverter;
import com.training.entities.health.Health;
import com.training.entities.health.QHealth;
import com.training.repo.health.IBodyMEasurementRepository;
import com.training.repo.health.IHealthRepository;

import java.util.Collections;
import java.util.List;

@Service
public class HealthService {
	
	@Autowired
	private IHealthRepository  healthRepository;
	
	@Autowired
	private IBodyMEasurementRepository bodyMEasurementRepository;
	
	@Autowired
	private EntityConverter<JsonNode, BodyMeasurement> jsonToBodyMeasurementConverter;
	
	public Health getHealthByUser(Long userId){
		Predicate predicate = QHealth.health.user.id.eq(userId);
		Health health =  this.healthRepository.findOne(predicate).get();
		Collections.sort(health.getBodyMeasurements());
		return health;
	}

	public List<BodyMeasurement> getHealthBodyMeasurementsByUser(Long userId){
		Predicate predicate = QHealth.health.user.id.eq(userId);
		return this.healthRepository.findOne(predicate).get().getBodyMeasurements();
	}
	

	public BodyMeasurement save(JsonNode bodyMEasurementJson) {
		BodyMeasurement bodyMeasurement = this.jsonToBodyMeasurementConverter.convert(bodyMEasurementJson);
		return this.bodyMEasurementRepository.save(bodyMeasurement);
	}

}
