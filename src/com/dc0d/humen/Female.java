package com.dc0d.humen;

import java.util.Random;

public class Female extends Human {
	
	boolean canGiveBirth;
	Human[] children;
	int childrenNumber = 0;
	int childrenMax;
	String maidenName;
	
	Male spouse = null;
	
	public Female(World world, String name, Male father, Female mother) {
		super(world, name, father, mother);
		this.name = name;
		surname = father.surname;
		maidenName = surname;
		childrenMax = new Random().nextInt(11);
		canGiveBirth = Math.random() > 0.01 ? true : false;
		children = new Human[childrenMax];
	}
	
	public Female(World world, Male father, Female mother) {
		super(world, world.femaleNames.get(new Random().nextInt(world.femaleNames.size())), father, mother);
		name = world.femaleNames.get(new Random().nextInt(world.femaleNames.size()));
		surname = father.surname;
		maidenName = surname;
		childrenMax = new Random().nextInt(9);
		canGiveBirth = Math.random() > 0.01 ? true : false;
		children = new Human[childrenMax];
	}
	
	public Female(World world) {
		super(world);
		name = world.femaleNames.get(new Random().nextInt(world.femaleNames.size()));
		surname = world.surnames.get(new Random().nextInt(world.surnames.size()));
		maidenName = surname;
		race = world.races.get(new Random().nextInt(world.races.size()));
		childrenMax = new Random().nextInt(9);
		canGiveBirth = Math.random() > 0.01 ? true : false;
		children = new Human[childrenMax];
	}
	
	@Override
	public void doLogic() {
		this.age++;
		if (age == deathAge){
			dead = true;
		}
		double rand = Math.random();
		if(rand < 0.1 && married && childrenMax > 0) {
			double childrenrand = Math.random();
			if(childrenNumber < childrenMax) {
				if(childrenrand < 0.5) {
					Male boy = new Male(world, spouse, this);
					children[childrenNumber] = boy;
					world.humans.add(boy);
					childrenNumber++;
					//System.out.println(boy.name + " was born to " + this.name + " " + this.surname);
				} else {
					Female girl = new Female(world, spouse, this);
					children[childrenNumber] = girl;
					world.humans.add(girl);
					childrenNumber++;
					//System.out.println(girl.name + " was born to " + this.name + " " + this.surname);
				}
			}
		}
		// Females can't ask to marry males - I don't know why, but that makes a tiny bit more tidy for me - no offense to anybody ;)
		// TODO Females don't seem to have a choice whether they get paired up. I'll change that.
	}
	
	public boolean marry(Male groom) {
		if(!married) {
			spouse = groom;
			married = true;
			this.surname = groom.surname;
			//System.out.println(name + " " + maidenName + " was married to " + spouse.name + " " + spouse.surname);
			return true;
		} else {
			return false;
		}
	}
}
