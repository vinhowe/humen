package com.dc0d.humen;

import java.util.Random;

public class Female extends Human {
	
	boolean canGiveBirth;
	Human[] children;
	int childrenNumber;
	
	Male spouse = null;
	
	public Female(World world, String name, Male father, Female mother) {
		super(world, name, father, mother);
		name = world.femaleNames.get(new Random().nextInt(world.maleNames.size()));
		surname = father.surname;
		race = Math.random() < 0.5 ? father.race : mother.race;
		childrenNumber = new Random().nextInt(11);
		canGiveBirth = Math.random() > 0.05 ? true : false;
		children = new Human[childrenNumber];
		// TODO Auto-generated constructor stub
	}
	
	public Female(World world, Male father, Female mother) {
		super(world, world.maleNames.get(new Random().nextInt(world.maleNames.size())), father, mother);
		surname = father.surname;
		race = Math.random() < 0.5 ? father.race : mother.race;
		childrenNumber = new Random().nextInt(11);
		canGiveBirth = Math.random() > 0.05 ? true : false;
		children = new Human[childrenNumber];
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doLogic() {
		this.age++;
		if (age == deathAge){
			dead = true;
		}
		double rand = Math.random();
		//TODO Do something with children and set cap with array
		if(rand < 0.2) {
			double childrenrand = Math.random();
			if(childrenrand < 0.5) {
				Male boy = new Male(world, spouse, this);
			} else {
				Female girl = new Female(world, spouse, this);
				
			}
		}
		// Females can't ask to marry males - I don't know why, but that makes a tiny bit more tidy for me - no offense to anybody ;)
		// TODO Females don't seem to have a choice whether they get paired up. I'll change that.
	}
	
	public void marry(Male groom) {
		spouse = groom;
	}
}
