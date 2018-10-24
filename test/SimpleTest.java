import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Author;
import model.Gender;
import model.Post;
import model.Tag;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.service.BlogDao;
import db.service.BlogService;



public class SimpleTest {
	private static final BlogService service = new BlogService();
	private static final List<Author> authors = new ArrayList<>();
	private static final List<Tag> tags = new ArrayList<>();
	

	@BeforeClass
	public static void insertInitialDataToDB(){
		Author author1 = new Author("Bill Oclus",29, Gender.MALE);
		//Author author2 = new Author("Loana Fay",25, Gender.FEMALE);
		//Author author3 = new Author("Pussy",4, Gender.UNDEFINED);
		authors.add(author1);
		//authors.add(author2);
		//authors.add(author3);
		authors.forEach(author->service.registerUser(author));
		tags.add(new Tag("hobby"));
		tags.add(new Tag("math"));
		tags.add(new Tag("writing"));
		tags.forEach(tag->service.saveTag(tag));
	}
	@AfterClass
	public static void deleteInitialDataFromDB(){
		authors.forEach(author->service.deleteUser(author));
		tags.forEach(tag->service.deleteTag(tag));
		
	}
	@Test
	public void registerUser(){
		Author actulAuthor = new Author("Kim13",29, Gender.MALE);
		actulAuthor.setGender(Gender.MALE);
		service.registerUser(actulAuthor);
		Author expectedAuthor = service.getUserByName("Kim13");
		assertEquals(expectedAuthor.getId(), actulAuthor.getId());
		service.deleteUser(expectedAuthor);

	}
	@Test
	public void deleteUser(){
		Author actulAuthor = new Author("Kim13",29, Gender.MALE);
		actulAuthor.setGender(Gender.MALE);
		service.registerUser(actulAuthor);
		service.deleteUser(actulAuthor);
		assertEquals(null, service.getUserByName("Kim13"));
		
	}
	@Test
	public void getUserByName(){
		Author expectedAuthor = authors.get(0);
		Author actualAuthor = service.getUserByName(expectedAuthor.getName());
		assertEquals(expectedAuthor.getId(), actualAuthor.getId());
	}
	@Test
	public void updateUserInfo(){
		Author author = authors.get(0);
		author.setName("John Dow");
		service.updateUserInfo(author);
		assertEquals("John Dow",author.getName());
	}
	@Test
	public void getAllUser(){
		List<Author> users = service.getAllUser();
		users.forEach(System.out::println);
		assertEquals(1, users.size());
	}
	@Test
	public void getPostByUser(){
		Author author = authors.get(0);
		Post post = new Post("test", "test", author);

		service.savePost(post);
		System.out.println(service.getPostsByUser(author.getName()));
		assertEquals(author.getId(), post.getAuthor().getId());
		service.deletePost(post);
	}
	@Test
	public void getPostWithTags(){
		Author author = authors.get(0);
		Post post = new Post("Post with tags", "Something", author);
		tags.forEach(tag->post.addTag(tag));
		service.savePost(post);
		System.out.println(post+" "+post.getTags().size());
		assertEquals(3, post.getTags().size());
		//service.deleteTag(tags.get(0));
		post.setTags(new HashSet<Tag>());
		service.savePost(post);
		service.deletePost(post);
		
	}
}
