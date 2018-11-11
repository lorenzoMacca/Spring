package com.training.repo.training.swim;

import com.training.entities.training.swim.SwimTrainingPattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISwimTRainingPatternRepository extends JpaRepository<SwimTrainingPattern, Long>, QuerydslPredicateExecutor<SwimTrainingPattern> {
}
