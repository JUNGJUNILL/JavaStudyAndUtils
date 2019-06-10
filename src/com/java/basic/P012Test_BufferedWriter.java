package com.java.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P012Test_BufferedWriter {

	public static void main(String[] args) {
		String greetings = "Hello!!!";
		String description = "I am written into a file jung!!";

		BufferedWriter writer = null;
		BufferedReader reader = null; 
		try {
			writer = new BufferedWriter(new FileWriter(new File("c:\\test.txt")));
			writer.write(greetings);
			writer.newLine();
			writer.write(description);
			
	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
