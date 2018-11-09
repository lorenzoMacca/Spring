package com.training.repo.student;

import com.training.entities.EStudent;
import com.training.repo.generic.WriteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRWStudent extends WriteRepository<EStudent, Long> {


}
