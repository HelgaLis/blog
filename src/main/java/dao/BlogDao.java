package dao;

import java.util.List;

import model.Author;

public interface BlogDao {
	public List<Author> getAllAuthor();
	public Author getAuthorByName(String name);
	public List<Author> getAllAuthorWithPosts();
}
