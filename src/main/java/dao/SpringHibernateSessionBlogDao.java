package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NamedQuery;

import model.Author;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public class SpringHibernateSessionBlogDao implements BlogDao{
	private final SessionFactory sessionFactory;
	public SpringHibernateSessionBlogDao (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Author> getAllAuthor(){
		String namedQuery = "Author.findAll";
		List<Author> authors = getList(namedQuery, new HashMap<String, Object>());
		return authors;
	}
	@Override
	public Author getAuthorByName(String name) {
		String namedQuery = "Author.findByName";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		return getUniqueResult(namedQuery,params);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Author> getAllAuthorWithPosts() {
		String namedQuery = "Author.findAllWithPosts";
		return getList(namedQuery, new HashMap<String, Object>());
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public <T> List<T> getList(String queryName, Map<String, Object> params){
		Session session = sessionFactory.getCurrentSession();
		Query<T> query = session.getNamedQuery(queryName);
		params.entrySet().stream().forEach(e->query.setParameter(e.getKey(), e.getValue()));
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public  <T> T getUniqueResult(String queryName, Map<String, Object> params){
		Session session = sessionFactory.getCurrentSession();
		Query<T> query = session.getNamedQuery(queryName);
		params.entrySet().stream().forEach(e->query.setParameter(e.getKey(), e.getValue()));
		return (T) query.uniqueResult();
	}
	@Transactional
	public  <T> T saveOrUpdate(T object){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(object);
		return object;
	}
	@Transactional
	public  <T> void delete(T object){
		Session session = sessionFactory.getCurrentSession();
		session.delete(object);
	}

}
