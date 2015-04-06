package com.dc0d.humen;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class World {
	public ArrayList<String> maleNames;
	public ArrayList<String> femaleNames;
	public ArrayList<String> surnames;
	public ArrayList<String> races;
	public ArrayList<String> eyeColors;
	public ArrayList<String> hairColors;
	
	public ArrayList<Human> humans;
	
	public Main main;
	
	String csvData = "";
	
	int totalPopulationCounter = 0;
	
	public World(Main main) {
		this.main = main;
		try {
		maleNames = (ArrayList<String>) Files.readAllLines(Paths.get("malenames.hal"), StandardCharsets.UTF_8);
		femaleNames = (ArrayList<String>) Files.readAllLines(Paths.get("femalenames.hal"), StandardCharsets.UTF_8);
		surnames = (ArrayList<String>) Files.readAllLines(Paths.get("surnames.hal"), StandardCharsets.UTF_8);
		races = (ArrayList<String>) Files.readAllLines(Paths.get("races.hal"), StandardCharsets.UTF_8);
		eyeColors = (ArrayList<String>) Files.readAllLines(Paths.get("eyeColors.hal"), StandardCharsets.UTF_8);
		hairColors = (ArrayList<String>) Files.readAllLines(Paths.get("hairColors.hal"), StandardCharsets.UTF_8);
		humans = new ArrayList<Human>();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//csvData = "Population,Total Population,Females,Males,Married Females,Married Males,Girls,Boys";
	}
	
	public boolean doLogic() {
		for(int p = 0; p < humans.size(); p++) {
			humans.get(p).doLogic();
			if (humans.get(p).dead) {
				humans.remove(p);
			}
		}
		//TODO Remove cap on population
		/*csvData = csvData + "\n"+humans.size()+","+totalPopulationCounter+","+
		numberFemales(false)+","+numberMales(false)+
		","+numberFemales(true)+","+numberMales(true)+
		","+numberGirls()+","+numberBoys();
		if(humans.size() == 0 || humans.size() >= 100000) {
			Utilities.writeToFile(csvData, "recentpopstats.csv", false);
			return false;
		}*/
		//System.out.println(numberFemales(true)+","+numberMales(true));
		return true;
	}
	
	public void populate(int people) {
		if(people >= 2){
			for(int p = 0; p < people/2; p++) {
				Human human = new Female(this);
				humans.add(human);
			}
			for(int p = 0; p < people/2; p++) {
				Human human = new Male(this);
				humans.add(human);
			}
		}
	}
	
	public Male getRandomMale() {
		for(int p = 0; p < humans.size(); p++) {
			if (humans.get(p) instanceof Male) {
				return (Male) humans.get(p);
			}
		}
		return null;
	}
	
	public Female getRandomFemale(boolean unmarried) {
		ArrayList<Female> females = new ArrayList<Female>();
		for(int p = 0; p < humans.size(); p++) {
			if (humans.get(p) instanceof Female) {
				if(unmarried){
					if(!humans.get(p).married && humans.get(p).age >= 22){
						females.add((Female) humans.get(p));
					}
				} else {
					females.add((Female) humans.get(p));
				}
			}
		}
		if(females.size() > 0) {
			int femaleRand = (int) Math.random() * females.size();
			return females.get(femaleRand);
		}
		return null;
	}
	
	public int numberFemales(boolean unmarried) {
		ArrayList<Female> females = new ArrayList<Female>();
		for(int p = 0; p < humans.size(); p++) {
			if (humans.get(p) instanceof Female) {
				if(unmarried){
					if(!humans.get(p).married && humans.get(p).age >= 22){
						females.add((Female) humans.get(p));
					}
				} else {
					females.add((Female) humans.get(p));
				}
			}
		}
		return females.size();
	}
	
	public int numberMales(boolean unmarried) {
		ArrayList<Male> males = new ArrayList<Male>();
		for(int p = 0; p < humans.size(); p++) {
			if (humans.get(p) instanceof Male) {
				if(unmarried){
					if(!humans.get(p).married && humans.get(p).age >= 22){
						males.add((Male) humans.get(p));
					}
				} else {
					males.add((Male) humans.get(p));
				}
			}
		}
		return males.size();
	}
	
	public int numberGirls() {
		ArrayList<Female> females = new ArrayList<Female>();
		for(int p = 0; p < humans.size(); p++) {
			if (humans.get(p) instanceof Female) {
				if(!humans.get(p).married && humans.get(p).age < 18){
					females.add((Female) humans.get(p));
				}
			}
		}
		return females.size();
	}
	
	public int numberBoys() {
		ArrayList<Male> males = new ArrayList<Male>();
		for(int p = 0; p < humans.size(); p++) {
			if (humans.get(p) instanceof Male) {
				if(humans.get(p).age < 18){
					males.add((Male) humans.get(p));
				}
			}
		}
		return males.size();
	}
}
