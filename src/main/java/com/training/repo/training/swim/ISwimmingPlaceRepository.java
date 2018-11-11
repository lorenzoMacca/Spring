package com.training.repo.training.swim;

import com.training.entities.training.swim.SwimmingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ISwimmingPlaceRepository extends JpaRepository<SwimmingPlace, Long>, QuerydslPredicateExecutor<SwimmingPlace> {
}
