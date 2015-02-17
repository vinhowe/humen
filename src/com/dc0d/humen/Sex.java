package com.dc0d.experiments.peoplesim;

public enum Sex {
	MALE, FEMALE;
	public boolean getType() {
		if(this == MALE){
			return true;
		} else {
			return false;
		}
	}
}
