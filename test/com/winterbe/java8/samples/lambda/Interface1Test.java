package com.winterbe.java8.samples.lambda;

import static org.junit.Assert.assertEquals;

import java.util.function.BiFunction;

import org.junit.Test;

public class Interface1Test {

	@Test
	public void test1 ()
	{
		assertEquals(Interface1.Formula.positive(0), 0);
	}
	
	@Test
	public void test2 ()
	{
		assertEquals(Interface1.Formula.positive(-1), 0);
	}
	
	@Test
	public void test3 ()
	{
		assertEquals(Interface1.Formula.positive(1), 1);
	}
	
	private final Interface1.Formula calculator = new Interface1.Formula() {
		
		@Override
		public double calculate(int a) {
			// TODO Auto-generated method stub
			return sqrt(100 * a);
		}
	};
	
	@Test
	public void test4 ()
	{
		assertEquals(calculator.calculate(100), 100, 0);
	}
	
	@Test
	public void test5 ()
	{
		BiFunction<? super Interface1.Formula, ? super Integer, ? extends Double> calculator2 = Interface1.Formula::sqrt;
		
		assertEquals(calculator2.apply(calculator, -23), calculator.sqrt(-23), 0);
	}
	
}
