package com.training.intermediate;

public interface IQuery<T, ID> {

    Iterable<T> getAll();

}
