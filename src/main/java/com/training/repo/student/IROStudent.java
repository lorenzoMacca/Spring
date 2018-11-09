package com.training.repo.student;

import com.training.entities.EStudent;
import com.training.repo.generic.ReadOnlyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IROStudent extends ReadOnlyRepository<EStudent, Long> {
}
