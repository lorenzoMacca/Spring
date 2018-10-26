package com.springboot.beispiele.springbootBeispiele.repo.note;

import com.springboot.beispiele.springbootBeispiele.entities.ENote;
import com.springboot.beispiele.springbootBeispiele.repo.generic.ReadOnlyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRONote extends ReadOnlyRepository<ENote, Long> {
}
