package main;

import java.util.List;

import db.service.Service;
import model.*;
public class Main {

	public static void main(String[] args) {
		Service dbService = new Service();
		Author au = new Author();
		au.setName("Uqunco");
		//Post p1 = new Post("First2","Ququ", au);
		//Post p2 = new Post("Second2", "Second", au);
		//au.addPost(p1);
		//au.addPost(p2);
		Tag tag1 = new Tag("hobby");
		Tag tag2 = new Tag("aroma");
		Tag tag3 = new Tag("liby");
		
		dbService.addAuthor(au);
		List<Author> authors = dbService.getAllAuthorWithPosts();
		System.out.println(authors);
	}


}
