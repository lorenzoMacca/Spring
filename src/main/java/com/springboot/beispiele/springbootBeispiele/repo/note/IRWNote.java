package com.springboot.beispiele.springbootBeispiele.repo.note;

import com.springboot.beispiele.springbootBeispiele.entities.ENote;
import com.springboot.beispiele.springbootBeispiele.repo.generic.WriteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRWNote extends WriteRepository<ENote, Long> {
}
