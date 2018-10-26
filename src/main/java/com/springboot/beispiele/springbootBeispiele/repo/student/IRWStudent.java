package com.springboot.beispiele.springbootBeispiele.repo.student;

import com.springboot.beispiele.springbootBeispiele.entities.EStudent;
import com.springboot.beispiele.springbootBeispiele.repo.generic.WriteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRWStudent extends WriteRepository<EStudent, Long> {
}
