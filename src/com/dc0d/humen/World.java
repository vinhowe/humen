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
	Main main;
	public World(Main main) {
		this.main = main;
		try {
		maleNames = (ArrayList<String>) Files.readAllLines(Paths.get("malenames.hal"), StandardCharsets.UTF_8);
		femaleNames = (ArrayList<String>) Files.readAllLines(Paths.get("femalenames.hal"), StandardCharsets.UTF_8);
		surnames = (ArrayList<String>) Files.readAllLines(Paths.get("surnames.hal"), StandardCharsets.UTF_8);
		races = (ArrayList<String>) Files.readAllLines(Paths.get("races.hal"), StandardCharsets.UTF_8);
		eyeColors = (ArrayList<String>) Files.readAllLines(Paths.get("eyeColors.hal"), StandardCharsets.UTF_8);
		hairColors = (ArrayList<String>) Files.readAllLines(Paths.get("hairColors.hal"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Male getRandomMale() {
		int rand = (int)Math.random()*humans.size();
		while(!(humans.get(rand) instanceof Male)) {
			rand = (int)Math.random()*humans.size();
		}
		return (Male)humans.get(rand);
	}
	
	public Female getRandomFemale() {
		int rand = (int)Math.random()*humans.size();
		while(!(humans.get(rand) instanceof Female)) {
			rand = (int)Math.random()*humans.size();
		}
		return (Female)humans.get(rand);
	}
}
