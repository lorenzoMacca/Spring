package com.training.repo.training.swim;

import com.training.entities.training.swim.SwimTrainingPattern;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISwimTRainingPatternRepository extends CrudRepository<SwimTrainingPattern, Long>, QuerydslPredicateExecutor<SwimTrainingPattern> {
}
