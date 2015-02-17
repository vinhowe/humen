package com.dc0d.humen;

import java.util.Random;

public class Male extends Human {
	
	Female spouse = null;
	
	public Male(World world, String name, Male father, Female mother) {
		super(world, name, father, mother);
		surname = father.surname;
		race = Math.random() < 0.5 ? father.race : mother.race;
	}
	
	public Male(World world, Male father, Female mother) {
		super(world, world.maleNames.get(new Random().nextInt(world.maleNames.size())), father, mother);
		surname = father.surname;
		race = Math.random() < 0.5 ? father.race : mother.race;
	}
	
	@Override
	public void doLogic() {
		this.age++;
		if (age == deathAge){
			dead = true;
		}
		double rand = Math.random();
		if(rand < 0.1) {
			if(!married) {
				marry(world.getRandomFemale());
			}
		}
	}
	
	public void marry(Female bride) {
		bride.marry(this);
		spouse = bride;
	}
}
