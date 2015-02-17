package com.dc0d.humen;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	World world;
	public Main() {
		init();
	}
	
	public void init() {
		world = new World(this);
	}
	
	public void startWorld() {
		
	}
	
	public void logicLoop() {
		
	}
	
	public static void main(String[] watermelon) throws IOException {
		Main main = new Main();

		float height = Math.max((new Random().nextFloat() * 5F)+5F, 5.0F);
		int age = new Random().nextInt(99);
	}
}
