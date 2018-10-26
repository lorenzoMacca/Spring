package com.springboot.beispiele.springbootBeispiele.repo;

import com.springboot.beispiele.springbootBeispiele.entities.ENote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRNote extends JpaRepository<ENote, Long> {
}
