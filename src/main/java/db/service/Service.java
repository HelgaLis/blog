package db.service;

import java.util.Set;

//import org.hibernate.SessionFactory;

import model.Author;
import model.Post;
import model.Tag;

public class Service {
	private final HibernateUtil sessionFactory;
	
	public Service() {
		HibernateUtil hu = new HibernateUtil();
		this.sessionFactory = hu;
		hu.printConnectInfo();
	}
	public Author getAuthor(String name) {
		return null;
	}
	public Set<Post> getAllPostsByAuthor(String name){
		return null;
	}
	public long addAuthor(Author author) {
		return 0;
	}
	public long savePost(Post post) {
		return 0;
	}
	public long addTag(Tag tag) {
		return 0;
	}
}
