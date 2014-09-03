package sap2homework;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("a", 20, true);
		s1.setCar(new BMW(100, "Red", "CA 5468 AA"));
		
		Teacher t1 = new Teacher("b", 40, s1,  true);
		t1.setCar(new Volkswagen(90, "Green", "PK 1234 PK"));
		
		Teacher t2 = new Teacher("c", 80, t1, true);
		t2.setCar(new BMW(110, "Green", "CA 8872 KM"));
		
		Car.findGreenCarsUsedByTeachers(s1, t1, t2);
		Car.findBMWUsedByParents(s1, t1, t2);
		
		
		Teacher t3 = new Teacher("d", 18, true);
		Teacher t4 = new Teacher("e", 18, false);
		Person.setMarriage(t3, t4);
		
		Student s2 = new Student("f", 30, true);
		Student s3 = new Student("g", 30, false);
		Person.setMarriage(s2, s3);
		
		Student s4 = new Student("h", 21, false);
		Person.setMarriage(t1, s4);
		Student s5 = new Student("i", 28, false);
		Person.setMarriage(s5, t2);
		
		System.out.println(Person.countTeachersMarriedToTeachers(s1,s2,s3,s4,s5,t1,t2,t3,t4) + " teachers are married to teachers.");
		System.out.println(Person.countStudentsMarriedToStudents(s1,s2,s3,s4,s5,t1,t2,t3,t4) + " students are married to students.");
		System.out.println(Person.countTeachersMarriedToStudents(s1,s2,s3,s4,s5,t1,t2,t3,t4) + " teachers are married to students.");
	}

}
