package sap2homework;

public interface IMarriage {
	final int MINIMUM_MARRIAGE_AGE = 18;
	
	/**
	 * 
	 * @return null if there is no partner, returns Partner otherwise
	 */
	public Person getPartner();
	
	public void setPartner(Person p);
	
	public boolean isEligibleForMarriage();
	
	public boolean isMarriedForTeacher();
}

