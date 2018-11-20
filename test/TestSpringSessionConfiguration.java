import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import service.BlogService;
import service.SimpleHibernateBlogService;
import service.SpringHibernateBlogService;
import configuration.SpringSessionConfiguration;
import dao.BlogDao;
import dao.SimpleHibernateSessionBlogDao;
import dao.SpringHibernateSessionBlogDao;
import model.Author;
import model.Gender;

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
