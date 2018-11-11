package com.training.repo.user;

import com.training.entities.training.user.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long>, QuerydslPredicateExecutor<User> {

}
