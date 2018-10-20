package main;

import java.util.List;

import db.service.Service;
import model.*;
public class Main {

	public static void main(String[] args) {
		Service dbService = new Service();
		Author au = new Author();
		au.setName("Lilu");
		Post p1 = new Post("First2","Ququ", au);
		Post p2 = new Post("Second2", "Second", au);
		au.addPost(p1);
		au.addPost(p2);
		/*Tag tag1 = new Tag("hobby12789");
		Tag tag2 = new Tag("aroma12789");
		Tag tag3 = new Tag("liby12789");
		p1.addTag(tag1);
		p1.addTag(tag2);
		p2.addTag(tag3);
		p2.addTag(tag1);
		tag1.addPost(p1);
		tag1.addPost(p2);
		tag2.addPost(p1);
		tag3.addPost(p2);*/
		
		//dbService.addTag(tag1);
		//dbService.addTag(tag2);
		//dbService.addTag(tag3);
		dbService.addAuthor(au);
		List<Author> authors = dbService.getAllAuthorWithPosts();
		printAuthorWithDetails(authors);
		dbService.deleteAuthor(au);
	}
	private static void printAuthorWithDetails(List<Author> author) {
		author.stream().map(Author::getPosts).flatMap(posts->posts.stream()).forEach(System.out::println);
	}

}
