package com.training.repo.note;

import com.training.entities.ENote;
import com.training.repo.generic.ReadOnlyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRONote extends ReadOnlyRepository<ENote, Long> {
}
