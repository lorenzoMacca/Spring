package com.springboot.beispiele.springbootBeispiele.intermediate;

import com.springboot.beispiele.springbootBeispiele.repo.generic.ReadOnlyRepository;

public interface IQuery<T, ID> {

    Iterable<T> getAll();

}
