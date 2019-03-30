package com.training.repo.health;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.training.entities.health.Bodymeasurement.BodyMeasurement;

@Repository
public interface IBodyMEasurementRepository extends JpaRepository<BodyMeasurement, Long>, QuerydslPredicateExecutor<BodyMeasurement>{

}
