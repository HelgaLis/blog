package dao;

import java.util.List;

import model.Author;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SpringHibernateSessionBlogDao implements BlogDao{
	private final SessionFactory sessionFactory;
	public SpringHibernateSessionBlogDao (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Author> getAllAuthor(){
		String query = "from Author a";
		List<Author> authors = getList(query);
		return authors;
	}
	@Override
	public Author getAuthorByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Author> getAllAuthorWithPosts() {
		// TODO Auto-generated method stub
		return null;
	}
	public <T> List<T> getList(String query){
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> result = session.createQuery(query).getResultList();
		tx.commit();
		session.close();
		return result;
	}
	public  <T> T getUniqueResult(Query<T> query){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T result = query.uniqueResult();
		tx.commit();
		session.close();
		return result;
	}
	public  <T> T saveOrUpdate(T object){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(object);
		tx.commit();
		session.close();
		return object;
	}
	public  <T> void delete(T object){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(object);
		tx.commit();
		session.close();
	}

}
