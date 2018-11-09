package com.training.repo.training.swim;

import com.training.entities.training.swim.IndoorSwim;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISwimTrainingRepository extends CrudRepository<IndoorSwim, Long>, QuerydslPredicateExecutor<IndoorSwim> {
}
