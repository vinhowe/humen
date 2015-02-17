package com.dc0d.experiments.peoplesim;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	static ArrayList<String> boyNames;
	static ArrayList<String> girlNames;
	static ArrayList<String> surnames;
	public static void main(String[] watermelon) throws IOException {
		boyNames = (ArrayList<String>) Files.readAllLines(Paths.get("boynames.hnf"), StandardCharsets.UTF_8);
		girlNames = (ArrayList<String>) Files.readAllLines(Paths.get("girlnames.hnf"), StandardCharsets.UTF_8);
		surnames = (ArrayList<String>) Files.readAllLines(Paths.get("surnames.hnf"), StandardCharsets.UTF_8);
		Lineage lineage = Lineage.getRandom();
		String name = boyNames.get(new Random().nextInt(boyNames.size()));
		String surname = surnames.get(new Random().nextInt(boyNames.size()));
		System.out.println("Name: " + name.substring(0, name.lastIndexOf(',')) + " " + surname + "\n" + "Lineage: " + lineage.toString());
	}
}
