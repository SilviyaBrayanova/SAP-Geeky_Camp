package geeky.camp.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

public class DAO {
	protected EntityManagerFactory emf;
	
	protected DAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	protected void deleteEntity(Object toBeDeleted, EntityManager em) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(toBeDeleted);
			tx.commit();
			System.out.println("Entry : " + toBeDeleted + " removed from db");
		} catch (RollbackException e) {
			System.out.println("Couldn't commit transaction, db will be reverted");
			e.printStackTrace();
		} finally {
			if (tx != null && tx.isActive())
				tx.rollback();
			if (em != null)
				em.close();
		}
	}
	
	protected void createNewEntity(Object newEntity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(newEntity);
			tx.commit();
		} catch (RollbackException e) {
			System.out.println("Couldn't commit transaction, db will be reverted");
			e.printStackTrace();
		} finally {
			if (tx != null && tx.isActive())
				tx.rollback();
			if (em != null)
				em.close();
		}
	}
	
	
}
