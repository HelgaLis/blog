package blog.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.dao.SimpleHibernateSessionBlogDao;
import blog.model.Author;
import blog.model.Post;
import blog.model.Tag;
import db.service.HibernateUtil;
public class SimpleHibernateBlogService {
	private SimpleHibernateSessionBlogDao dao;
	public SimpleHibernateBlogService(SimpleHibernateSessionBlogDao dao){
		this.dao = dao;
	}
	public List<Author> getAllUserTest(){
		return dao.getAllAuthor();
	}
	public Author registerUser(Author author){
		Session session = HibernateUtil.getSession();
		return dao.saveOrUpdate(session, author);
	}
	public void deleteUser(Author author){
		Session session = HibernateUtil.getSession();
		dao.delete(session, author);
	}
	public Author getUserByName(String name){
		return dao.getAuthorByName(name);
	}
	public Author updateUserInfo(Author author){
		Session session = HibernateUtil.getSession();
		return dao.saveOrUpdate(session, author);
	}
	public List<Author> getAllUser(){
		return dao.getAllAuthor();
		
	}
	public Set<Post> getPostsByUser(String name){
	
		return dao.getAuthorByName(name).getPosts();
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
