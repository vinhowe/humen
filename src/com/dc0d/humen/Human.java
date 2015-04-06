package com.dc0d.humen;

import java.util.ArrayList;
import java.util.Random;

abstract class Human {
	short age;
	short height;
	World world;
	String name;
	String surname;
	String race;
	String eyeColor;
	String hairColor;
	boolean married = false;
	short deathAge;
	Male father;
	Female mother;
	boolean dead;
	Traits traits;
	int extraversion;
	int aggression;
	int health;
	ArrayList<Human> friends = new ArrayList<Human>();
	
	public Human(World world, String name, Male father, Female mother) {
		this.world = world;
		surname = father.surname;
		eyeColor = Math.random() > 0.5 ? father.race : mother.race;
		eyeColor = Math.random() > 0.5 ? father.eyeColor : mother.eyeColor;
		hairColor = Math.random() > 0.5 ? father.hairColor : mother.hairColor;
		deathAge = (short) (new Random().nextInt(20)+80);
		age = 0;
		world.totalPopulationCounter++;
		traits = new Traits();
		extraversion = (int) ((Math.random() * 200) -100);
	}
	
	public Human(World world) {
		this.world = world;
		surname = world.surnames.get(new Random().nextInt(world.maleNames.size()-1));
		race = world.races.get(new Random().nextInt(world.races.size()));
		eyeColor = world.eyeColors.get(new Random().nextInt(world.eyeColors.size()-1));
		hairColor = world.hairColors.get(new Random().nextInt(world.hairColors.size()-1));
		deathAge = (short) (new Random().nextInt(20)+80);
		age = 0;
		world.totalPopulationCounter++;
		traits = new Traits();
		extraversion = (int) ((Math.random() * 200) -100);
	}
	
	public void logAttributes() {
		String sex;
		if (this instanceof Male) {
			sex = "Male";
		} else {
			sex = "Female";
		}
		System.out.println(
				"Name: " + name.substring(0, name.lastIndexOf(',')) + " " + surname + "\n" +
				"Race: " + race + "\n" +
				"Sex: " + sex + "\n" +
				"Eye Color: " + eyeColor + "\n" +
				"Hair Color: " + hairColor + "\n" +
				"Height: " + height + " Feet" + "\n" +
				"Age: " + age + " years" + "\n"
				);
	}
	
	protected void doLogic() {
		this.age++;
		if (age == deathAge){
			dead = true;
		}
		double rand = Math.random();
		if(rand < 0.5) {
			//TODO make humans get married with a small chance every year - unless they're married already ;)
			//world.humans;
		}
	}
}
