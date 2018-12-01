package com.training.core.training.swim;

public enum PoolLength {
	
    POOL_LENGTH_25_METER("POOL_LENGTH_25_METER"), POOL_LENGTH_50_METER("POOL_LENGTH_25_METER");

	private PoolLength(String s) {
		this.poolLength = s;
	}
	
	private final String poolLength;
	
	public String getPoolLength() {
		return this.poolLength;
	}
}
