package com.training.repo.training.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.training.entities.training.exercise.ExerciseRep;

@Repository
public interface IExerciseRepRepository extends JpaRepository<ExerciseRep, Long>, QuerydslPredicateExecutor<ExerciseRep>{

}
