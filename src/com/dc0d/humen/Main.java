package com.dc0d.humen;

import java.io.IOException;

public class Main {
	World world;
	boolean running;
	public Main() {
		init();
	}
	
	public void init() {
		world = new World(this);
		world.populate(10);
		running = true;
	}
	
	public void startWorld() throws IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String");
        String s = br.readLine();
        System.out.print("Enter Integer:");
        try{
            int i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }*/
		while(running) {
			if(!world.doLogic()) running = false;
		}
	}
	
	public void logicLoop() {
		
	}
	
	public static void main(String[] watermelon) throws IOException {
		Main main = new Main();
		main.startWorld();
	}
}
