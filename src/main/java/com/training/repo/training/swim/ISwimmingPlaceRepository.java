package com.training.repo.training.swim;

import com.training.entities.training.swim.SwimmingPlace;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISwimmingPlaceRepository extends CrudRepository<SwimmingPlace, Long>, QuerydslPredicateExecutor<SwimmingPlace> {
}
