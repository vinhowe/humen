package com.dc0d.experiments.peoplesim;

public enum Lineage {
	CAUCASIAN,
	AFRICANAMERICAN,
	ASIAN,
	HISPANIC,
	NATIVEAMERICAN;
	
	public static Lineage getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
