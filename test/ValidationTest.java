import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import blog.model.Author;
import blog.model.Gender;


public class ValidationTest {
	private static Validator validator;

	   @BeforeClass
	   public static void setUp() {
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	   }
	   @Test
	   public void nameIs(){
		   Author author = new Author(null, 15, Gender.FEMALE);
		   Set<ConstraintViolation<Author>> constViolanstions = validator.validate(author);
		   constViolanstions.stream().map(ConstraintViolation<Author>::getMessage).forEach(System.out::println);
		   assertEquals(1,constViolanstions.size());
	   }
	   @Test
	   public void ageIsTooLow(){
		   Author author = new Author("Borris Carloff", 12, Gender.FEMALE);
		   Set<ConstraintViolation<Author>> constViolanstions = validator.validate(author);
		   constViolanstions.stream().map(ConstraintViolation<Author>::getMessage).forEach(System.out::println);
		   assertEquals(1,constViolanstions.size());
		   
	   }
	   @Test 
	   public void authorIsValid(){
		   Author author = new Author("Borris Carloff", 15, Gender.FEMALE);
		   Set<ConstraintViolation<Author>> constViolanstions = validator.validate(author);
		   constViolanstions.stream().map(ConstraintViolation<Author>::getMessage).forEach(System.out::println);
		   assertEquals(0,constViolanstions.size());
		   
	   }

}
