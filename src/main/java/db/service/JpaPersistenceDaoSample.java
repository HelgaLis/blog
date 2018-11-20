package db.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import blog.model.Author;

public class JpaPersistenceDaoSample {
	private javax.persistence.EntityManagerFactory emf;
	public JpaPersistenceDaoSample(){
		emf = Persistence.createEntityManagerFactory("blog");
	}
	public void store(Author author){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(author);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally{
			em.close();
		}
	}
}
