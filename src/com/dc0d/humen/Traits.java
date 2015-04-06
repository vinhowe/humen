package com.dc0d.humen;

public class Traits {
	//Caring, Honest, Enthusiastic, Assertive, Courteous, Courageous, Friendly, Generous, SelfReliant, Conventional, Alert,
	//Uncaring, Dishonest, Unenthusiastic, Indecisive, Impolite, Hostile, Selfish, Dependent, Adventurous, Dull;
	
	int extraversion = 0;
	int agreeableness = 0;
	int conscientiousness = 0;
	int neuroticism = 0;
	int openness = 0;
	
	public Traits() {
		extraversion = (int) ((Math.random() * 200) -100);
	}
}
