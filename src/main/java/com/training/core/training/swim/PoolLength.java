package com.training.core.training.swim;

public enum PoolLength {
	
    POOL_LENGTH_25_METER("POOL_LENGTH_25_METER"), POOL_LENGTH_50_METER("POOL_LENGTH_25_METER");

	private PoolLength(String l) {
		this.lenght = l;
	}
	
	private String lenght;
	
	public String getValue() {
		return this.lenght;
	}
}
