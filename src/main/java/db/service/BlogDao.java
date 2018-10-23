package db.service;


import java.util.List;

import org.hibernate.Session;


//import org.hibernate.SessionFactory;


import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Author;
import model.Post;
import model.Tag;

public class BlogDao {
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
	public Author getAuthorByName(String name) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Author author = (Author) session.getNamedQuery("Author.findByName").setParameter("name", name).uniqueResult();
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
	@SuppressWarnings("unchecked")
	public List<Post> getAllPostsByAuthor(String name){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Author author = getAuthorByName(name);
		List<Post> posts = session.createNamedQuery("Post.findAllPostByAuthor").setParameter("authorId", author.getId()).list();
		
		tx.commit();
		session.close();
		return posts;
		
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
	public void deletePost(Post post){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(post);
		tx.commit();
		session.close();
	}
}
