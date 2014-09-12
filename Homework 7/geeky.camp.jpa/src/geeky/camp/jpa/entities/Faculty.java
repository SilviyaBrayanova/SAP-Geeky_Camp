package geeky.camp.jpa.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Faculty implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	@OneToMany
	private List<Student> students = new ArrayList<Student>();
	private static final long serialVersionUID = 1L;

	public Faculty() {
		super();
	}
	
	public Faculty(String name) {
		this.name = name;
	}
	
	public Faculty(String name, List<Student> students) {
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
		if(student.getFaculty() != this) {
			student.setFaculty(this);
		}
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + "]";
	}
}
