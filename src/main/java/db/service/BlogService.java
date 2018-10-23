package db.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import model.Author;
import model.Post;

public class BlogService {
	private final BlogDao dao = new BlogDao();
	public void registerUser(Author author){
		
	}
	public void deleteUser(Author author){
		
	}
	public Author getUserByName(String name){
		Session session = HibernateUtil.getSession();
		return dao.getAuthorByName(session, name);
	}
	public void updateUserInfo(){
		
	}
	public List<Author> getAllUser(){
		
		Session session = HibernateUtil.getSession();
		return dao.getAllAuthor(session);
		
	}
	public Set<Post> getPostByUser(String name){
		return null;
	}
	public void savePost(Post post){
		
	}
	
}
