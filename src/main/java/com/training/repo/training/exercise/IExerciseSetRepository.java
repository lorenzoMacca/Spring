package com.training.repo.training.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.training.entities.training.exercise.ExerciseSet;

@Repository
public interface IExerciseSetRepository extends JpaRepository<ExerciseSet, Long>, QuerydslPredicateExecutor<ExerciseSet>{

}
