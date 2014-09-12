package geeky.camp.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Student implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int facultyNumber;
	private String firstName;
	private String lastName;
	private Integer credits;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@ManyToMany
	private List<Course> courses = new ArrayList<Course>();
	@ManyToOne
	private Faculty faculty;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}   
	
	public Student(String firstName, String lastName,
			Integer credits, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.credits = credits;
		this.birthDate = birthDate;
	}

	public Student(String firstName, String lastName,
			Integer credits, Date birthDate, List<Course> courses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.credits = credits;
		this.birthDate = birthDate;
		this.courses = courses;
	}

	public int getFacultyNumber() {
		return this.facultyNumber;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	} 
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getCredits() {
		return this.credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Course> getCourses() {
		return courses;
	}
	
	public void addCourse(Course course) {
		this.courses.add(course);
		if(!(course.getStudents().contains(this))) {
			course.addStudent(this);
		}
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
		if(!(faculty.getStudents().contains(this))) {
			faculty.addStudent(this);
		}
	}
	
	@Override
	public String toString() {
		return "Student [facultyNumber=" + facultyNumber + ", firstName="
				+ firstName + ", lastName=" + lastName + ", credits=" + credits
				+ ", birthDate=" + birthDate + "]";
	}
}
