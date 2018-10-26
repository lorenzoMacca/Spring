package com.springboot.beispiele.springbootBeispiele.intermediate;

import com.springboot.beispiele.springbootBeispiele.repo.generic.ReadOnlyRepository;

public class Query<T, ID> implements IQuery<T, ID> {

    private ReadOnlyRepository<T,ID> readOnlyRepository;

    public Query(ReadOnlyRepository<T, ID> readOnlyRepository) {

        this.readOnlyRepository = readOnlyRepository;
    }

    public Iterable<T> getAll(){
        Iterable<T> i = readOnlyRepository.findAll();

        return i;
    }

}
