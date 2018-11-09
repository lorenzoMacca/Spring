package com.training.repo.generic;

import com.querydsl.core.types.Predicate;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID> extends Repository<T, ID>, QuerydslPredicateExecutor<T> {

    Iterable<T> findAll();

    Iterable<T> findAll(Predicate var1);

}


