package geeky.camp.jpa.dao;

import geeky.camp.jpa.entities.Faculty;
import geeky.camp.jpa.entities.Student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

public class FacultyDAO extends DAO {

	public FacultyDAO(EntityManagerFactory emf) {
		super(emf);
	}

	public void deleteFaculty(Object primaryKey) {
		EntityManager em = emf.createEntityManager();
		Faculty toBeDeleted = em.find(Faculty.class, primaryKey);
		deleteEntity(toBeDeleted, em);
	}

	public void createNewFaculty(String name) {
		Faculty newFaculty = new Faculty(name);
		createNewEntity(newFaculty);
		System.out.println("Faculty created " + newFaculty);
	}

	public void updateFaculty(Faculty updateInfo) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Faculty willBeUpdated = em.find(Faculty.class,
					updateInfo.getId());
			System.out.println("Faculty " + willBeUpdated
					+ " will be updated to " + updateInfo);
			updateProps(willBeUpdated, updateInfo);
			tx.commit();
			System.out.println("Faculty updated successfully");
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
	
	public void printAllStudentsInFacuilties() {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			List<Faculty> allFaculties = em.createQuery(
							"SELECT f FROM Faculty f",
							Faculty.class).getResultList();
			for(Faculty faculty : allFaculties) {
				System.out.println("In faculty " + faculty.getName() + ":");
				for(Student student : faculty.getStudents()) {
					System.out.println(student);
				}
			}
		} finally {
			if (em != null)
				em.close();
		}
	}
	
	public boolean studentInFaculty(Student student, Faculty faculty) {
		return faculty.getStudents().contains(student);
	}
	
	public Faculty findByPrimaryKey(Object primaryKey) { 
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			return em.find(Faculty.class, primaryKey);
		}  finally {
			if (em != null)
				em.close();
		}
	}
	
	private void updateProps(Faculty willBeUpdated, Faculty updateInfo) {
		willBeUpdated.setName(updateInfo.getName());
	}
}
