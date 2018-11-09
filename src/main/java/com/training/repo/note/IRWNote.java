package com.training.repo.note;

import com.training.entities.ENote;
import com.training.repo.generic.WriteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRWNote extends WriteRepository<ENote, Long> {
}
