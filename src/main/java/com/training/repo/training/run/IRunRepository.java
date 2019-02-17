package com.training.repo.training.run;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.training.entities.training.Run;

@Repository
public interface IRunRepository extends JpaRepository<Run, Long>, QuerydslPredicateExecutor<Run>{

}
