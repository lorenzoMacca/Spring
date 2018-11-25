package com.training.repo.training.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.training.entities.training.exercise.ExerciseType;

@Repository
public interface IExerciseTypeRepository extends JpaRepository<ExerciseType, Long>, QuerydslPredicateExecutor<ExerciseType>{

}
