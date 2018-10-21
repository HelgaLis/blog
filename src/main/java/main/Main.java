package main;

import java.util.List;

import db.service.BlogDao;
import model.*;
public class Main {

	public static void main(String[] args) {

	}
	private static void printAuthorWithDetails(List<Author> author) {
		author.stream().map(Author::getPosts).flatMap(posts->posts.stream()).forEach(System.out::println);
	}

}
