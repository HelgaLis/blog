import model.Author;
import model.Gender;

import org.junit.Test;

import db.service.JpaPersistenceDaoSample;


public class EntityManagerTest {
@Test
public void testAuthorStore(){
	Author author = new Author("Purtuk", 17, Gender.MALE);
	System.out.println(author);
	JpaPersistenceDaoSample emfm = new JpaPersistenceDaoSample();
	emfm.store(author);
	System.out.println(author);
}
}
