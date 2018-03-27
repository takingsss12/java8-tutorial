package com.winterbe.java8.samples.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.winterbe.java8.samples.lambda.Lambda2.PersonFactory;

public class Lambda2Test {

	@Test
	public void test ()
	{
		final Lambda2.Converter<? super String, Integer> integerConverter1 = Integer::valueOf;
		final Integer converted1 = integerConverter1.convert("123");
		assertEquals(Integer.valueOf(123), converted1);
	}
	
	@Test
	public void test2 ()
	{
		final class Worker extends Person
		{

			private Worker(String firstName, String lastName) {
				super(firstName, lastName);
				// TODO Auto-generated constructor stub
			}
			
		}
		
		final PersonFactory<Person> personFactory = Worker::new;
		
		assertTrue(personFactory.create(null, null) instanceof Worker);
	}
	
}
