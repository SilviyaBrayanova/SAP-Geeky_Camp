package sap3homework;

public class Stamp {
	String name;
	int year;
	String country;
	Boolean isBlock;
	Boolean isStamped;
	
	public Stamp(String name, int year, String country) {
		this(name, year, country, false, false);
	}
	
	public Stamp(String name, int year, String country, Boolean isBlock, Boolean isStamped) {
		this.name = name;
		this.year = year;
		this.country = country;
		this.isBlock = isBlock;
		this.isStamped = isStamped;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Boolean isBlock() {
		return isBlock;
	}
	public void setBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}
	public Boolean isStamped() {
		return isStamped;
	}
	public void setStamped(boolean isStamped) {
		this.isStamped = isStamped;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Stamp) {
			return name.equals(((Stamp) obj).name) && year == ((Stamp) obj).year &&
				   country.equals(((Stamp) obj).country) && isBlock == ((Stamp)obj).isBlock &&
				   isStamped == ((Stamp) obj).isStamped;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (StringTool.sum(name) + year + StringTool.sum(country)+ 
				isBlock.compareTo(false) + isStamped.compareTo(false)) % 31;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(name);
		result.append(" (");
		result.append(country);
		result.append(", ");
		result.append(year);
		result.append(")");
		
		return result.toString();
	}
}
