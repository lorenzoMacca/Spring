package com.springboot.beispiele.springbootBeispiele.service.common;

import com.springboot.beispiele.springbootBeispiele.intermediate.IQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public abstract class CommonService<T, ID> {

    private IQuery<T,ID> query;

    public CommonService(IQuery<T, ID> query) {
        this.query = query;
    }

    public Iterable<T> getAll(){
        return query.getAll();
    }
}
