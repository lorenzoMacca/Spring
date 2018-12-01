package com.training.entities.common;

public interface EntityConverter<FROMA, TOB> {

	TOB convert(FROMA a);
}
