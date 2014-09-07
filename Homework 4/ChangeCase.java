package sap4homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChangeCase {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String path;
		System.out.println("Please enter a valid path to a directory");
		path = input.nextLine();
		input.close();
		
		File dir = new File(path);
		for(File file:dir.listFiles()) {
			swapCaseFilename(file);
			// Is there a way to check for EVERY type of text file, not just .txt?
			if(file.getName().matches("(?i).*txt$")) {
				swapCaseFile(file);
			}
		}
	}
	
	public static void swapCaseFilename(File file) {
		StringBuilder successMessage = new StringBuilder();
		successMessage.append("Successfully renamed ");
		successMessage.append(file.getName());
		successMessage.append(" to ");
		File file2 = new File(file.getParent(), swapCase(file.getName()));
		successMessage.append(file2.getName());
		if(file.renameTo(file2)) {
			System.out.println(successMessage.toString());
		} else {
			System.out.println("Could not rename file " + file.getName());
		}
	}
	
	public static void swapCaseFile(File file) {
		String text = "";
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr)) {
			String line;
			StringBuilder builder = new StringBuilder();
			while((line = br.readLine()) != null) {
				builder.append(line);
				builder.append(System.lineSeparator());
			}
		
			text = swapCase(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write(text);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Changed content of " + file.getName());
	}
	
	public static String swapCase(String s) {
		char[] chars = s.toCharArray();
		
		for(int i = 0; i < chars.length; i++) {
			if(Character.isUpperCase(chars[i])) {
				chars[i] = Character.toLowerCase(chars[i]);
			} else if(Character.isLowerCase(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
			}
		}
		
		return new String(chars);
	}
}
