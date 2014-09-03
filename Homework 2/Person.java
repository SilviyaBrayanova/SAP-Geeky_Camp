// (^_^() (^_^) ()^_^)
// ()^_^) (^_^) (^_^()
package sap2homework;

abstract public class Person implements IMarriage {
	protected String name;
	private int age;
	private Person partner;
	private boolean isMale;
	private Car car;
	
	public Person(String name, int age, boolean isMale) {
		super();
		this.name = name;
		this.age = age;
		this.isMale = isMale;
		this.partner = null;
		this.setCar(null);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person getPartner() {
		return partner;
	}
	
	public void setPartner(Person p) {
		this.partner = p;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean hasPartner() {
		return partner != null;
	}
	
	public boolean isEligibleForMarriage() {
		return age >= IMarriage.MINIMUM_MARRIAGE_AGE && !(hasPartner());
	}
	
	static void setMarriage(Person p1, Person p2) {
		if(p1.isEligibleForMarriage() && p2.isEligibleForMarriage() && p1.isMale != p2.isMale) {
			p1.setPartner(p2);
			p2.setPartner(p1);
		}
	}
	
	@Override
	public boolean isMarriedForTeacher() {
		return partner instanceof Teacher;
	}
	
	// Wanted to define 2 generics X and Y so I could check any combination
	// (Teacher-Teacher, Student-Teacher, etc), but I can't check instanceof X :(
	static int countTeachersMarriedToTeachers(Person... people) {
		int count = 0;
		for(Person person:people) {
			if(person instanceof Teacher && person.getPartner() instanceof Teacher) {
				count++;
			}
		}
		return count;
	}
	
	static int countStudentsMarriedToStudents(Person... people) {
		int count = 0;
		for(Person person:people) {
			if(person instanceof Student && person.getPartner() instanceof Student) {
				count++;
			}
		}
		return count;
	}
	
	static int countTeachersMarriedToStudents(Person... people) {
		int count = 0;
		for(Person person:people) {
			if(person instanceof Teacher && person.getPartner() instanceof Student) {
				count++;
			}
		}
		return count;
	}
	
	abstract public boolean hasGrandChild();
	abstract public boolean hasChild();
}

