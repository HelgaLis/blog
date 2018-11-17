import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import db.service.BlogDao;
import db.service.BlogService;
import db.service.SpringSessionConfiguration;

public class TestSpringSessionConfiguration {
	@Test
	public void getAllAuthors() {
		ApplicationContext ap = new AnnotationConfigApplicationContext(SpringSessionConfiguration.class);
		/*BlogDao b= ap.getBean(BlogDao.class);
		b.getAllAuthorTest().forEach(System.out::println);*/
		BlogService bs = ap.getBean(BlogService.class);
		bs.getAllUserTest().forEach(System.out::println);
	}
}
