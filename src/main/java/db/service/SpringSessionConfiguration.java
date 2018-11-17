package db.service;

import java.util.Properties;

import javax.swing.text.html.HTML.Tag;

import model.Author;
import model.Post;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class SpringSessionConfiguration {
	@Bean
	public BlogDao blogDao(SessionFactory sessionFactory){
		return new BlogDao(sessionFactory);
	}
	@Bean
	public BlogService blogService(BlogDao blogDao){
		return new BlogService(blogDao);
	}
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setAnnotatedClasses(Author.class, Post.class, model.Tag.class);
        return sessionFactoryBean;
    }
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(AvailableSettings.URL,"jdbc:mysql://localhost:3306/blog");
        properties.setProperty(AvailableSettings.USER, "root");
        properties.setProperty(AvailableSettings.PASS, "root");
        properties.setProperty(AvailableSettings.DIALECT, org.hibernate.dialect.MySQL5Dialect.class.getName());
        properties.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
        properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        return properties;
    }
}
