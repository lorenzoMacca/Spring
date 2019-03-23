package com.training.service.health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.training.entities.health.Health;
import com.training.entities.health.QHealth;
import com.training.repo.health.IHealthRepository;

@Service
public class HealthService {
	
	@Autowired
	private IHealthRepository  healthRepository;
	
	public Iterable<Health> getHealthByUser(Long userId){
		Predicate predicate = QHealth.health.user.id.eq(userId);
		return this.healthRepository.findAll(predicate);
	}

}
