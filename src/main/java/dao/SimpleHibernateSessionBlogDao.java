package dao;


import java.util.List;

import org.hibernate.Session;


//import org.hibernate.SessionFactory;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import db.service.HibernateUtil;
import model.Author;
import model.Post;
import model.Tag;

public class SimpleHibernateSessionBlogDao implements BlogDao {
	private final Session session;
	public SimpleHibernateSessionBlogDao(){
		this.session = HibernateUtil.getSession();
	}



	public List<Author> getAllAuthor(){
		Session session = HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		Query<Author> query = session.createQuery("from Author a");
		List<Author> authors = getList(session,query);
		return authors;
	}
	public Author getAuthorByName(String name){
		Session session = HibernateUtil.getSession();
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

	public <T> List<T> getList(Session session, Query<T> query){
		
		
		Transaction tx = session.beginTransaction();
		List<T> result = query.getResultList();
		tx.commit();
		session.close();
		return result;
	}
	public  <T> T getUniqueResult(Session session,Query<T> query){
		Transaction tx = session.beginTransaction();
		T result = query.uniqueResult();
		tx.commit();
		session.close();
		return result;
	}
	public  <T> T saveOrUpdate(Session session,T object){
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(object);
		tx.commit();
		session.close();
		return object;
	}
	public  <T> void delete(Session session,T object){
		Transaction tx = session.beginTransaction();
		session.delete(object);
		tx.commit();
		session.close();
	}



	@Override
	public <T> T saveOrUpdate(T object) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <T> void delete(T object) {
		// TODO Auto-generated method stub
		
	}


}
