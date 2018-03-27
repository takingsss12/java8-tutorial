package com.winterbe.java8.samples.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class Lambda1Test {

	private List<String> names, names2, names3;
	private final List<String> expectedNames = Arrays.asList("xenia", "peter", "mike", "anna");
	private final List<String> expectedNames2 = Arrays.asList("anna", "mike", "peter", "xenia", null);
	
	@Before
	public void init ()
	{
		names = Arrays.asList("peter", "anna", "mike", "xenia");
		names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
	}
	
	@Test
	public void test1 ()
	{
		Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
		
		assertEquals(expectedNames, names);
	}
	
	@Test
	public void test2 ()
	{
		Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
		
		assertEquals(expectedNames, names);
	}
	
	@Test
	public void test3 ()
	{
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		
		assertEquals(expectedNames, names);
	}
	
	@Test
	public void test4 ()
	{
		Collections.sort(names, (a, b) -> b.compareTo(a));
		
		assertEquals(expectedNames, names);
	}
	
	@Test
	public void test5 ()
	{
		names.sort(Collections.reverseOrder());
		
		assertEquals(expectedNames, names);
	}
	
	@Test
	public void test6 ()
	{
		names2.sort(Comparator.nullsLast(Comparator.naturalOrder()));
		
		assertEquals(expectedNames2, names2);
	}
	
	@Test
	public void test7 ()
	{
		Optional.ofNullable(names3).ifPresent(Collections::sort);
		
		assertNull(names3);
	}
	
}
