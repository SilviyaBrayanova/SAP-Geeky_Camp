package sap3homework;

import java.util.Collection;
import java.util.HashSet;

public class StampGroup {
	private String name;
	private HashSet<Stamp> stamps;
	
	public StampGroup(String name) {
		this.name = name;
		stamps = new HashSet<Stamp>();
	}
	
	public StampGroup(String name, Collection<Stamp> collection) {
		this.name = name;
		stamps = new HashSet<Stamp>(collection);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addStamp(Stamp s) {
		stamps.add(s);
	}
	
	public void clearStamps() {
		stamps.clear();
	}
	
	public boolean contains(Stamp s) {
		return stamps.contains(s);
	}
	
	public void removeStamp(Stamp s) {
		stamps.remove(s);
	}
	
	public int size() {
		return stamps.size();
	}
}
