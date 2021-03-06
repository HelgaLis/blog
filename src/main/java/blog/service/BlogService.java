package blog.service;

import java.util.List;
import java.util.Set;

import blog.model.Author;
import blog.model.Post;
import blog.model.Tag;

public interface BlogService {
	public List<Author> getAllUser();
	public Author getUserByName(String name);
	public Author registerUser(Author author);
	public void updateUserInfo(Author author);
	public void deleteUser(Author author);
	public Set<Post> getPostsByUser(String name);
	public Post savePost(Post post);
	public void deletePost(Post post);
	public Tag saveTag(Tag tag);
	public void deleteTag(Tag tag);
	public Author findAuthorById(long id);
}
