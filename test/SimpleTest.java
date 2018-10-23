import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Author;
import model.Gender;
import model.Post;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.service.BlogDao;
import db.service.BlogService;



public class SimpleTest {
	private static final BlogDao db = new BlogDao();
	private static final BlogService service = new BlogService();
	private static final List<Author> authors = new ArrayList<>();
	
	public SimpleTest(){
		Author author1 = new Author("Bill Oclus",29, Gender.MALE);
		Author author2 = new Author("Loana Fay",25, Gender.FEMALE);
		Author author3 = new Author("Pussy",4, Gender.UNDEFINED);
		authors.add(author1);
		authors.add(author2);
		authors.add(author3);
	}

	@Before
	public void insertInitialDataToDB(){
		authors.forEach(author->db.addAuthor(author));
	}
	@After
	public void deleteInitialDataFromDB(){
		authors.forEach(author->db.deleteAuthor(author));
		
	}
	@Test
	public void registerUser(){
		Author actulAuthor = new Author("Kim12",29, Gender.MALE);
		actulAuthor.setGender(Gender.MALE);
		db.addAuthor(actulAuthor);
		Author expectedAuthor = db.getAuthorByName("Kim12");
		assertEquals(expectedAuthor.getId(), actulAuthor.getId());

	}
	@Test
	public void deleteUser(){
		Author actulAuthor = new Author("Kim12",29, Gender.MALE);
		actulAuthor.setGender(Gender.MALE);
		db.addAuthor(actulAuthor);
		db.deleteAuthor(actulAuthor);
		assertEquals(null, db.getAuthorByName("Kim12"));
		
	}
	@Test
	public void getUserByName(){
		Author expectedAuthor = authors.get(0);
		Author actualAuthor = service.getUserByName(expectedAuthor.getName());
		assertEquals(expectedAuthor.getId(), actualAuthor.getId());
	}
	@Test
	public void updateUserInfo(){
		
	}
	@Test
	public void getAllUser(){
		List<Author> users = service.getAllUser();
		users.forEach(System.out::println);
		assertEquals(4, users.size());
	}
	@Test
	public void getPostByUser(){
		Author author = authors.get(0);
		Post post = new Post("test", "test", author);
		//author.addPost(post);
		db.addAuthor(author);
		db.addPost(post);
		System.out.println(db.getAllPostsByAuthor(author.getName()));
		assertEquals(author.getId(), post.getAuthor().getId());
		db.deletePost(post);
	}
}
