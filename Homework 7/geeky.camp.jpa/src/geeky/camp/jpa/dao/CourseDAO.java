package geeky.camp.jpa.dao;

import geeky.camp.jpa.entities.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

public class CourseDAO extends DAO {

	public CourseDAO(EntityManagerFactory emf) {
		super(emf);
	}
	
	public void deleteCourse(Object primaryKey) {
		EntityManager em = emf.createEntityManager();
		Course toBeDeleted = em.find(Course.class, primaryKey);
		deleteEntity(toBeDeleted, em);
	}

	public void createNewCourse(String name) {
		Course newCourse = new Course(name);
		createNewEntity(newCourse);
		System.out.println("Course created " + newCourse);
	}

	public void updateCourse(Course updateInfo) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Course willBeUpdated = em.find(Course.class,
					updateInfo.getId());
			System.out.println("Course " + willBeUpdated
					+ " will be updated to " + updateInfo);
			updateProps(willBeUpdated, updateInfo);
			tx.commit();
			System.out.println("Course updated successfully");
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
	
	public Course findByPrimaryKey(Object primaryKey) { 
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			return em.find(Course.class, primaryKey);
		}  finally {
			if (em != null)
				em.close();
		}
	}
	
	private void updateProps(Course willBeUpdated, Course updateInfo) {
		willBeUpdated.setName(updateInfo.getName());
	}
}
