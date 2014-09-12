package geeky.camp.jpa.dao;

import geeky.camp.jpa.entities.Faculty;
import geeky.camp.jpa.entities.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

public class StudentDAO extends DAO {

	public StudentDAO(EntityManagerFactory emf) {
		super(emf);
	}
	
	public void deleteStudent(Object primaryKey) {
		EntityManager em = emf.createEntityManager();
		Student toBeDeleted = em.find(Student.class, primaryKey);
		deleteEntity(toBeDeleted, em);
	}

	public void createNewStudent(String firstName, String lastName,
			Date birthDate, Integer credits) {
		Student newStudent = new Student(firstName, lastName, credits,  birthDate);
		createNewEntity(newStudent);
		System.out.println("Student created " + newStudent);
	}

	public void updateStudent(Student updateInfo) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Student willBeUpdated = em.find(Student.class,
					updateInfo.getFacultyNumber());
			System.out.println("Student " + willBeUpdated
					+ " will be updated to " + updateInfo);
			updateProps(willBeUpdated, updateInfo);
			tx.commit();
			System.out.println("Student updated successfully");
		} catch (RollbackException e) {
			System.out
					.println("Couldn't commit transaction, db will be reverted");
			e.printStackTrace();
		} finally {
			if (tx != null && tx.isActive())
				tx.rollback();
			if (em != null)
				em.close();
		}
	}

	public Collection<Student> findAllStudentsWithCreditsMoreThan(
			Integer credits) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			return em
					.createQuery(
							"SELECT s FROM Student s WHERE s.credits > :credits",
							Student.class).setParameter("credits", credits)
					.getResultList();
		} finally {
			if (em != null)
				em.close();
		}
	}
	
	public Student findByPrimaryKey(Object primaryKey) { 
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			return em.find(Student.class, primaryKey);
		}  finally {
			if (em != null)
				em.close();
		}
	}

	public Collection<Student> findStudentsOfAGivenCourseInAFaculty(String courseName, Faculty faculty) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			List<Student> allStudents = em.createQuery(
							"SELECT c.students FROM Course c WHERE c.courseName = :courseName",
							Student.class)
					.setParameter("courseName", courseName).getResultList();
			List<Student> result = new ArrayList<Student>();
			for(Student student : allStudents) {
				if(student.getFaculty() == faculty) {
					result.add(student);
				}
			}
			return result;
		} finally {
			if (em != null)
				em.close();
		}
	}

	private void updateProps(Student willBeUpdated, Student updateInfo) {
		willBeUpdated.setBirthDate(updateInfo.getBirthDate());
		willBeUpdated.setCredits(updateInfo.getCredits());
		willBeUpdated.setFirstName(updateInfo.getFirstName());
		willBeUpdated.setLastName(updateInfo.getLastName());
	}

}
