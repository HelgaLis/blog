package db.service;


import java.util.List;

import org.hibernate.Session;


//import org.hibernate.SessionFactory;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Author;
import model.Post;
import model.Tag;

public class BlogDao {
	private SessionFactory sessionFactory;
	public BlogDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	//test
	public List<Author> getAllAuthorTest(){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query<Author> query = session.createQuery("from Author a");
		List<Author> authors = getList(session,query);
		return authors;
	}
	public <T> List<T> getList(Session session, Query<T> query){
		Transaction tx = session.beginTransaction();
		List<T> result = query.getResultList();
		tx.commit();
		session.close();
		return result;
	}
	public <T> T getUniqueResult(Session session, Query<T> query){
		Transaction tx = session.beginTransaction();
		T result = query.uniqueResult();
		tx.commit();
		session.close();
		return result;
	}
	public <T> T saveOrUpdate(Session session,T object){
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(object);
		tx.commit();
		session.close();
		return object;
	}
	public <T> void delete(Session session, T object){
		Transaction tx = session.beginTransaction();
		session.delete(object);
		tx.commit();
		session.close();
	}
	public List<Author> getAllAuthor(Session session){
		@SuppressWarnings("unchecked")
		Query<Author> query = session.createQuery("from Author a");
		List<Author> authors = getList(session,query);
		return authors;
	}
	public Author getAuthorByName(Session session, String name){
		@SuppressWarnings("unchecked")
		Query<Author> query = session.getNamedQuery("Author.findByName").setParameter("name", name);
		return getUniqueResult(session, query);
	}
	
	@SuppressWarnings("unchecked")
	public List<Author> getAllAuthorWithPosts(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Author> authors =  session.getNamedQuery("Author.findAllWithPosts").list();
		tx.commit();
		session.close();
		return authors;
	}

	


}
