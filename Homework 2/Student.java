package sap2homework;

public class Student extends Person {
	private Person child;
	
	public Student(String name, int age, boolean isMale) {
		super(name, age, isMale);
		child = null;
	}

	public Student(String name, int age, Person child, boolean isMale) {
		super(name, age, isMale);
		this.child = child;
	}
	
	public boolean hasChild() {
		return child != null;
	}
	
	@Override
	public boolean hasGrandChild() {
		return child != null && child.hasChild();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Name: ");
		result.append(name);
		result.append(".\n");
		if(child != null) {
			result.append("Has a child: ");
			result.append(child.toString());
			result.append("\n");
		} else {
			result.append("Has no children.\n");
		}
		return result.toString();
	}
	
}
