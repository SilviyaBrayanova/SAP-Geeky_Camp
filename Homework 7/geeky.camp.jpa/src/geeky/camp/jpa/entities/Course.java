package geeky.camp.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	@ManyToMany
	private List<Student> students = new ArrayList<Student>();
	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}
	
	public Course(String name) {
		this.name = name;
	}
	
	public Course(String name, List<Student> students) {
		this.name = name;
		this.students = students;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
	public List<Student> getStudents() {
		return this.students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
		if(!(student.getCourses().contains(this))) {
			student.addCourse(this);
		}
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
}
