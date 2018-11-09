package com.training.repo.training.swim;

import com.training.entities.training.swim.SwimmingPool;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISwimmingPoolRepository extends CrudRepository<SwimmingPool, Long>, QuerydslPredicateExecutor<SwimmingPool> {
}
