package db.service;


import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import org.hibernate.SessionFactory;


import org.hibernate.Transaction;

import model.Author;
import model.Post;
import model.Tag;

public class Service {
	

	@SuppressWarnings("unchecked")
	public Author getAuthor(String name) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Author author = (Author) session.getNamedQuery("Author.findByName").setParameter("name", name).uniqueResult();

		System.out.println("get");
		tx.commit();
		session.close();
		return author;
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
	@SuppressWarnings("unchecked")
	public List<Author> getAllAuthor(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Author> authors = session.createQuery("from Author a").list();
		tx.commit();
		session.close();
		return authors;
	}
	public Set<Post> getAllPostsByAuthor(String name){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//TODO: add functionality
		tx.commit();
		session.close();
		return null;
		
	}
	public Author addAuthor(Author author) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(author);
		tx.commit();
		session.close();
		return author;
	}
	public Post addPost(Post post) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(post);
		tx.commit();
		session.close();
		return post;

	}
	public Tag addTag(Tag tag) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(tag);
		tx.commit();
		session.close();
		return tag;
	}
	
	public void deleteAuthor(Author author){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(author);
		tx.commit();
		session.close();
	}
}
