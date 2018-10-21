import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import model.Author;
import model.Gender;
import model.Post;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.service.BlogDao;



public class SimpleTest {
	private static final BlogDao db = new BlogDao();
	private static final Set<Author> authors = new HashSet<>();
	
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
	public void registerUser(Author author){
		Author actulAuthor = new Author("Kim12",29, Gender.MALE);
		actulAuthor.setGender(Gender.MALE);
		db.addAuthor(actulAuthor);
		Author expectedAuthor = db.getAuthor("Kim12");
		assertEquals(expectedAuthor.getId(), actulAuthor.getId());

	}
	@Test
	public void deleteUser(){
		Author actulAuthor = new Author("Kim12",29, Gender.MALE);
		actulAuthor.setGender(Gender.MALE);
		db.addAuthor(actulAuthor);
		db.deleteAuthor(actulAuthor);
		assertEquals(null, db.getAuthor("Kim12"));
		
	}
	@Test
	public Author getUserByName(String name){
		return null;
	}
	@Test
	public void updateUserInfo(){
		
	}
	@Test
	public void getAllUser(){
		
	}
	@Test
	public void getPostByUser(){
		
	}
}
