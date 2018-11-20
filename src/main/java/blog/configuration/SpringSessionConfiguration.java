package blog.configuration;

import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import blog.dao.BlogDao;
import blog.dao.SpringHibernateSessionBlogDao;
import blog.model.Author;
import blog.model.Post;
import blog.service.BlogService;
import blog.service.SpringHibernateBlogService;

@Configuration
@EnableTransactionManagement
public class SpringSessionConfiguration {
	@Bean
	public BlogDao springHibernateSessionBlogDao(SessionFactory sessionFactory){
		return new SpringHibernateSessionBlogDao(sessionFactory);
	}
	@Bean
	public BlogService springHibernateBlogService(BlogDao simpleHibernateSessionBlogDao){
		return new SpringHibernateBlogService(simpleHibernateSessionBlogDao);
	}
	@Bean
	public HibernateTransactionManager hibernateTransactionalManager(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setAnnotatedClasses(Author.class, Post.class, blog.model.Tag.class);
        return sessionFactoryBean;
    }
    @Bean
    public DataSource dataSource() {
    	BasicDataSource basicDataSource = new BasicDataSource();
    	basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	basicDataSource.setUrl("jdbc:mysql://localhost:3306/blog");
    	basicDataSource.setUsername("root");
    	basicDataSource.setPassword("root");
    	return basicDataSource;
    }
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        //properties.setProperty(AvailableSettings.URL,"jdbc:mysql://localhost:3306/blog");
        //properties.setProperty(AvailableSettings.USER, "root");
        //properties.setProperty(AvailableSettings.PASS, "root");
        properties.setProperty(AvailableSettings.DIALECT, org.hibernate.dialect.MySQL5Dialect.class.getName());
        properties.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
        properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "");
        return properties;
    }
}
