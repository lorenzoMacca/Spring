package com.training.service.health;
import com.training.entities.health.Bodymeasurement.BodyMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.training.entities.health.Health;
import com.training.entities.health.QHealth;
import com.training.repo.health.IHealthRepository;

import java.util.List;

@Service
public class HealthService {
	
	@Autowired
	private IHealthRepository  healthRepository;
	
	public Health getHealthByUser(Long userId){
		Predicate predicate = QHealth.health.user.id.eq(userId);
		return this.healthRepository.findOne(predicate).get();
	}

	public List<BodyMeasurement> getHealthBodyMeasurementsByUser(Long userId){
		Predicate predicate = QHealth.health.user.id.eq(userId);
		return this.healthRepository.findOne(predicate).get().getBodyMeasurements();
	}

}
