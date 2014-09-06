package sap3homework;

import java.util.Collection;

public class Serie extends StampGroup {
	int year;
	String country;
	
	Serie(String name, int year, String country) {
		super(name);
		this.year = year;
		this.country = country;
	}
	
	Serie(String name, int year, String country, Collection<Stamp> collection) {
		super(name, collection);
		this.year = year;
		this.country = country;
	}
}
