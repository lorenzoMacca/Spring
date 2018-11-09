package com.training.service.common;

import com.training.intermediate.IQuery;

public abstract class CommonService<T, ID> {

    private IQuery<T,ID> query;

    public CommonService(IQuery<T, ID> query) {
        this.query = query;
    }

    public Iterable<T> getAll(){
        return query.getAll();
    }
}
