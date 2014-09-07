package sap5homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		System.out.println("Please enter some letters and _ (Ctrl+Z to end)");
		while (input.hasNextLine()) {
			builder.append(input.nextLine().toLowerCase());
		}
		input.close();

		String s = builder.toString();
		boolean hasPairs = true;
		while (hasPairs) {
			int[] furthestPair = { Integer.MIN_VALUE, Integer.MAX_VALUE };
			hasPairs = false;
			for (int i = 97; i < 123; i++) {
				char currentLetter = (char) i;
				List<Integer> matches = checkForMatches(currentLetter, s);
				if (matches.size() > 1) {
					hasPairs = true;
					int[] contenderPair = median(matches);
					if (isNewBestPair(furthestPair, contenderPair)) {
						furthestPair = contenderPair;
					}
				}
			}
			List<Integer> matches = checkForMatches('_', s);
			if (matches.size() > 1) {
				hasPairs = true;
				int[] contenderPair = median(matches);
				if (isNewBestPair(furthestPair, contenderPair)) {
					furthestPair = contenderPair;
				}
			}
			if (hasPairs) {
				s = changePos(furthestPair[0], furthestPair[1], s);
			}
		}
		System.out.println(s.split("_")[0]);
	}

	public static int[] median(List<Integer> m) {
		int[] possitions = { 0, 0 };
		int middle = m.size() / 2 - 1;
		if (m.size() % 2 == 1) {
			possitions[0] = m.get(middle);
			possitions[1] = m.get(middle + 1);
			return possitions;
		} else {
			possitions[0] = m.get(middle);
			possitions[1] = m.get(middle + 1);
			return possitions;
		}
	}

	public static boolean contains(int[] a1, int[] a2) {
		return a1[0] < a2[0] && a1[1] > a2[1];
	}

	public static String changePos(int pos1, int pos2, String s) {
		char value;
		StringBuilder sb = new StringBuilder(s);
		value = sb.charAt(pos1);
		sb.deleteCharAt(pos2);
		sb.deleteCharAt(pos1);
		sb.append(value);
		return sb.toString();
	}

	public static List<Integer> checkForMatches(char currentLetter, String s) {
		List<Integer> matches = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == currentLetter) {
				matches.add(i);
			}
		}
		return matches;
	}

	public static boolean isNewBestPair(int[] oldPair, int[] newPair) {
		if (contains(oldPair, newPair)) {
			return true;
		}
		if (contains(newPair, oldPair)) {
			return false;
		}
		if (oldPair[1] - oldPair[0] < newPair[1] - newPair[0]) {
			return true;
		}
		if (oldPair[1] - oldPair[0] == newPair[1] - newPair[0]
				&& oldPair[0] > newPair[0]) {
			return true;
		}
		return false;
	}
}
