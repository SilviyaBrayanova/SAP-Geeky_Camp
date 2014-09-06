package sap3homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dictionary {
	List<String> dictionary;
	
	public Dictionary(File file) {
		dictionary = new ArrayList<String>();
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr)) {
			String line;
			while((line = br.readLine()) != null) {
				if(!(line.equals(""))) {
					dictionary.add(line);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		Collections.sort(dictionary);
	}
	
	public void add(String word) {
		dictionary.add(word);
		Collections.sort(dictionary);
	}
	
	public void remove(String word) {
		dictionary.remove(word);
	}
	
	// n = dictionary.size()
	// O(n)
	public List<String> searchPrefix(String prefix) {
		List<String> result = new ArrayList<String>();
		int i = Collections.binarySearch(dictionary, prefix, new Comparator<String>(){ // O(log n)

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.substring(0, Math.min(arg0.length(), arg1.length())).compareToIgnoreCase(arg1);
			}
		});
		
		
		if(i >= 0) {
			result.add(dictionary.get(i));
			continueSearch(result, i, prefix); // O(n)
		}
		Collections.sort(result);
		return result;
	}
	
	// O(n)
	private void continueSearch(List<String> result, int i, String prefix) {
		int j = i - 1;
		if(!(i == 0)) {
			while(true) {
				String word = dictionary.get(j);
				if(word.startsWith(prefix)) {
					result.add(word);
					j--;
					if(j < 0) {
						break;
					}
				} else {
					break;
				}
			}
		}
		
		if(!(i == dictionary.size()-1)) {
			j = i + 1;
			while(true) {
				String word = dictionary.get(j);
				if(word.startsWith(prefix)) {
					result.add(word);
					j++;
					if(j == dictionary.size()) {
						break;
					}
				} else {
					break;
				}
			}
		}
	}
}
