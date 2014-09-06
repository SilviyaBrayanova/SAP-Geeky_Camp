package sap3homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class StampCollector {
	private String name;
	private HashSet<Stamp> collection;
	
	public StampCollector(String name) {
		this.name = name;
		collection = new HashSet<Stamp>();
	}
	
	public StampCollector(String name, Collection<Stamp> collection) {
		this.name = name;
		this.collection = new HashSet<Stamp>(collection);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addStamp(Stamp s) {
		collection.add(s);
	}
	
	public void clearCollection() {
		collection.clear();
	}
	
	public boolean collectionContains(Stamp s) {
		return collection.contains(s);
	}
	
	public void removeStamp(Stamp s) {
		collection.remove(s);
	}
	
	public int collectionSize() {
		return collection.size();
	}
	
	public ArrayList<Stamp> sortCollectionByYear() {
		ArrayList<Stamp> sortedCollection = new ArrayList<Stamp>(collection);
		
		Collections.sort(sortedCollection, new Comparator<Stamp>() {
			
			@Override
			public int compare(Stamp s1, Stamp s2) {
				return Integer.compare(s1.year, s2.year);
			}
		});
		
		return sortedCollection;
	}
	
	public ArrayList<Stamp> sortCollectionByCountry() {
		ArrayList<Stamp> sortedCollection = new ArrayList<Stamp>(collection);
		
		Collections.sort(sortedCollection, new Comparator<Stamp>() {
			
			@Override
			public int compare(Stamp s1, Stamp s2) {
				return s1.country.compareToIgnoreCase(s2.country);
			}
		});
		
		return sortedCollection;
	}
}
