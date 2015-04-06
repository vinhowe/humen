package com.dc0d.humen;

import java.util.Random;

public class Male extends Human {
	
	Female spouse = null;
	
	public Male(World world, String name, Male father, Female mother) {
		super(world, name, father, mother);
		this.name = name;
	}
	
	public Male(World world, Male father, Female mother) {
		super(world, world.maleNames.get(new Random().nextInt(world.maleNames.size())), father, mother);
		name = world.maleNames.get(new Random().nextInt(world.maleNames.size()));
	}
	
	public Male(World world) {
		super(world);
		name = world.maleNames.get(new Random().nextInt(world.maleNames.size()));
	}
	
	@Override
	public void doLogic() {
		this.age++;
		if (age == deathAge){
			dead = true;
		}
		double rand = Math.random();
		if(rand < 0.1 && age >= 22) {
			if(!married) {
				marry(world.getRandomFemale(true));
			}
		}
	}
	
	public void marry(Female bride) {
		if(bride != null) {
			if(bride.marry(this)){
				spouse = bride;
				married = true;
			}
		}
	}
}
