package db.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import model.Author;
import model.Post;
import model.Tag;

public class BlogService {
	private final BlogDao dao = new BlogDao();
	public Author registerUser(Author author){
		Session session = HibernateUtil.getSession();
		return dao.saveOrUpdate(session, author);
	}
	public void deleteUser(Author author){
		Session session = HibernateUtil.getSession();
		dao.delete(session, author);
	}
	public Author getUserByName(String name){
		Session session = HibernateUtil.getSession();
		return dao.getAuthorByName(session, name);
	}
	public Author updateUserInfo(Author author){
		Session session = HibernateUtil.getSession();
		return dao.saveOrUpdate(session, author);
	}
	public List<Author> getAllUser(){
		
		Session session = HibernateUtil.getSession();
		return dao.getAllAuthor(session);
		
	}
	public Set<Post> getPostsByUser(String name){
		Session session = HibernateUtil.getSession();
		return dao.getAuthorByName(session, name).getPosts();
	}
	public Post savePost(Post post){
		Session session = HibernateUtil.getSession();
		return dao.saveOrUpdate(session, post);
		
	}
	public void deletePost(Post post){
		Session session = HibernateUtil.getSession();
		dao.delete(session, post);
	}
	public Tag saveTag(Tag tag){
		Session session = HibernateUtil.getSession();
		return dao.saveOrUpdate(session, tag);
	}
	public void deleteTag(Tag tag){
		Session session = HibernateUtil.getSession();
		dao.delete(session, tag);
	}
	
}
