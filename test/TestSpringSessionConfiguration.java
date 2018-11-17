import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import service.SimpleHibernateBlogService;
import configuration.SpringSessionConfiguration;
import dao.SimpleHibernateSessionBlogDao;

public class TestSpringSessionConfiguration {
	@Test
	public void getAllAuthors() {
		ApplicationContext ap = new AnnotationConfigApplicationContext(SpringSessionConfiguration.class);
		/*SimpleHibernateSessionBlogDao b= ap.getBean(SimpleHibernateSessionBlogDao.class);
		b.getAllAuthorTest().forEach(System.out::println);*/
		SimpleHibernateBlogService bs = ap.getBean(SimpleHibernateBlogService.class);
		bs.getAllUserTest().forEach(System.out::println);
	}
}
