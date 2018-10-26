package com.springboot.beispiele.springbootBeispiele.repo.student;

import com.springboot.beispiele.springbootBeispiele.entities.EStudent;
import com.springboot.beispiele.springbootBeispiele.repo.generic.ReadOnlyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IROStudent extends ReadOnlyRepository<EStudent, Long> {
}
