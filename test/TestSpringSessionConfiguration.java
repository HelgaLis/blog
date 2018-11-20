import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import blog.configuration.SpringSessionConfiguration;
import blog.dao.BlogDao;
import blog.dao.SimpleHibernateSessionBlogDao;
import blog.dao.SpringHibernateSessionBlogDao;
import blog.model.Author;
import blog.model.Gender;
import blog.service.BlogService;
import blog.service.SimpleHibernateBlogService;
import blog.service.SpringHibernateBlogService;

public class TestSpringSessionConfiguration {
	private static BlogService service;
	@BeforeClass
	public static void setService() {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringSessionConfiguration.class);
		service = context.getBean(BlogService.class);
	}
	@Test
	public void addAuthor() {
		Author author = new Author("Sergey Ivanov", 28, Gender.MALE);
		service.registerUser(author);
		System.out.println(author);
	}
	@Test
	public void getAllAuthors() {
		service.getAllUser().forEach(System.out::println);
	}
}
