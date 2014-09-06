package sap3homework;

import java.util.Collection;

public class JubileeEnvelope extends StampGroup {
	String occasion;
	
	JubileeEnvelope(String name, String occasion) {
		super(name);
		this.occasion = occasion;
	}
	
	JubileeEnvelope(String name, String occasion, Collection<Stamp> collection) {
		super(name, collection);
		this.occasion = occasion;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	
	
}
