package blog.dao;

import java.util.List;

import blog.model.Author;

public interface BlogDao {
	public List<Author> getAllAuthor();
	public Author getAuthorByName(String name);
	public List<Author> getAllAuthorWithPosts();
	public  <T> T saveOrUpdate(T object);
	public  <T> void delete(T object);
}
