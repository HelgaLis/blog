package main;

import java.util.List;

import blog.dao.SimpleHibernateSessionBlogDao;
import blog.model.*;
public class Main {

	public static void main(String[] args) {

	}
	private static void printAuthorWithDetails(List<Author> author) {
		author.stream().map(Author::getPosts).flatMap(posts->posts.stream()).forEach(System.out::println);
	}

}
