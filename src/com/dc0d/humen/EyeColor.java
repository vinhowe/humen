package com.dc0d.experiments.peoplesim;

public enum EyeColor {
	AMBER,
	BLACK,
	BLUE,
	LIGHTBLUE,
	BROWN,
	DARKBROWN,
	GRAY,
	HAZEL;
    
	public static EyeColor getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
