package com.training.repo.training.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.training.entities.training.session.Session;

@Repository
public interface ISessionRepository extends JpaRepository<Session, Long>, QuerydslPredicateExecutor<Session> {

}
