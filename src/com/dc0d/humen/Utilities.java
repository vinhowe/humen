package com.dc0d.humen;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public final class Utilities {
	public static String capitalizeString(String string) {
		  char[] chars = string.toLowerCase().toCharArray();
		  boolean found = false;
		  for (int i = 0; i < chars.length; i++) {
		    if (!found && Character.isLetter(chars[i])) {
		      chars[i] = Character.toUpperCase(chars[i]);
		      found = true;
		    } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
		      found = false;
		    }
		  }
		  return String.valueOf(chars);
		}
	/**
	 * Writes a string to a file
	 */
	
	public static boolean writeToFile(String string, String path, boolean append) {
		FileWriter writer;
		try {
			writer = new FileWriter(path , append);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		PrintWriter printWriter = new PrintWriter(writer);
		printWriter.printf( "%s" + "%n" , string);
		printWriter.close();
		return true;
	}
}
