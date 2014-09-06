package sap3homework;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class DictionaryTest {

	public static void main(String[] args) {
		File dictionaryFile = new File(args[0]);
		Dictionary dictionary = new Dictionary(dictionaryFile);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the string you would like to search for");
		String pattern = input.nextLine();
		input.close();
		
		List<String> result = dictionary.searchPrefix(pattern);
		for(String word:result) {
			System.out.println(word);
		}
	}

}
