package service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BlogDao;
import model.Author;
import model.Post;
import model.Tag;
@Service
@Transactional
public class SpringHibernateBlogService implements BlogService {
	private final BlogDao blogdao; 
	public SpringHibernateBlogService(BlogDao blogDao) {
		this.blogdao = blogDao;
	}
	@Override
	public List<Author> getAllUser() {
		return blogdao.getAllAuthor();
	}

	@Override
	public Author getUserByName(String name) {
		return blogdao.getAuthorByName(name);
	}

	@Override
	public Author registerUser(Author author) {
		return blogdao.saveOrUpdate(author);
	}

	@Override
	public void updateUserInfo(Author author) {
		blogdao.saveOrUpdate(author);

	}

	@Override
	public void deleteUser(Author author) {
		blogdao.delete(author);

	}

	@Override
	public Set<Post> getPostsByUser(String name) {
		return null;
	}

	@Override
	public Post savePost(Post post) {
		return blogdao.saveOrUpdate(post);
	}

	@Override
	public void deletePost(Post post) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tag saveTag(Tag tag) {
		return blogdao.saveOrUpdate(tag);
	}

	@Override
	public void deleteTag(Tag tag) {
		// TODO Auto-generated method stub

	}

}
