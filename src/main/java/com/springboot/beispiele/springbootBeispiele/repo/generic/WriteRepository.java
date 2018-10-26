package com.springboot.beispiele.springbootBeispiele.repo.generic;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface WriteRepository<T, ID> extends Repository<T, ID> {

    public <S extends T> S save(S var1);

}
