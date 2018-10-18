package db.service;

<<<<<<< HEAD
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

//import org.hibernate.SessionFactory;

import model.Author;
import model.Post;
import model.Tag;

public class Service {
	private final SessionFactory sessionFactory;
	
	public Service() {
		HibernateUtil hu = new HibernateUtil();
		this.sessionFactory = hu.getSessionFactory();
		hu.printConnectInfo();
	}
	public Author getAuthor(String name) {
		return(Author) sessionFactory.openSession().getNamedQuery("Author.findByName").setParameter("name", name).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Author> getAllAuthorWithPosts(){
		return sessionFactory.openSession().getNamedQuery("Author.findAllWithPosts").list();
	}
	@SuppressWarnings("unchecked")
	public List<Author> getAllAuthor(){
		return sessionFactory.openSession().createQuery("from Author a").list();
	}
	public Set<Post> getAllPostsByAuthor(String name){
		return null;
	}
	public Author addAuthor(Author author) {
		sessionFactory.openSession().saveOrUpdate(author);
		return author;
	}
	public Post addPost(Post post) {
		sessionFactory.openSession().saveOrUpdate(post);
		return post;

	}
	public long addTag(Tag tag) {
		return 0;
	}
}
