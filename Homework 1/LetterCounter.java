package sap1homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class LetterCounter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String currentLine;
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		char c;
		
		System.out.println("Please enter some text (Ctrl+Z to end)");
		while(input.hasNextLine()) {
			currentLine = input.nextLine().toLowerCase();
			for(int i = 0; i < currentLine.length(); i++) {
				c = currentLine.charAt(i);
				if(Character.isLetter(c)) {
					if(count.get(c) == null) {
						count.put(c, 0);
					}
					count.put(c, count.get(c)+1);
				}
			}
		}
		
		input.close();
		List<Entry<Character, Integer>> sorted = sortMapByValue(count);
		for(int i = 0; i < 5 && i < sorted.size() ; i++) {
			System.out.println(sorted.get(i));
		}
	}
	
	static <K,V extends Comparable<? super V>> 
    List<Entry<K, V>> sortMapByValue(Map<K,V> map) {

		List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K,V>>() {
        
			@Override
			public int compare(Entry<K,V> e1, Entry<K,V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});

		return sortedEntries;
	}
}
