package sap5homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		System.out.println("Please enter some letters and _ (Ctrl+Z to end)");
		while(input.hasNextLine()) {
			builder.append(input.nextLine().toLowerCase());
		}
		input.close();
		
		String s = builder.toString();
		boolean hasPairs = true;
		while(hasPairs) {
			int[] furthestPair = {Integer.MIN_VALUE, Integer.MAX_VALUE};
			hasPairs = false;
			for(int i = 97; i < 123; i++) {
				char compareTo = (char)i;
				List<Integer> matches = new ArrayList<Integer>();
				for(int j = 0; j < s.length(); j++) {
					if(s.charAt(j) == compareTo) {
						matches.add(j);
					}
				}
				if(matches.size() > 1) {
					hasPairs = true;
					// TODO function to find the middle 2 element of an array
					int[] furthest = median(matches);
					if(contains(furthestPair, furthest)) {
						furthestPair = furthest;
					} else if(contains(furthest, furthestPair)) {
						continue;
					} else if(furthestPair[1] - furthestPair[0] < furthest[1] - furthest[0]) {
						furthestPair = furthest;
					} else if(furthestPair[1] - furthestPair[0] == furthest[1] - furthest[0] && furthest[0] < furthestPair[0]) {
						furthestPair = furthest;
					}
				}
			}
			// TODO add case for _

			if(hasPairs) {
				s = changePos(furthestPair[0], furthestPair[1], s);
			}
			System.out.println(s);
		}
		System.out.println(s.split("_")[0]);
	}

	public static boolean contains(int[] a1, int[] a2) {
		return a1[0] < a2[0] && a1[1] > a2[1];
	}
}
