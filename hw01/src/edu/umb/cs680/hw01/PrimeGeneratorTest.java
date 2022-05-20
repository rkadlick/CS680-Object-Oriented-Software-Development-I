package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {
	@Test
	public void positiveCase(){
		LinkedList<Long> actual = new LinkedList<Long>();
		LinkedList<Long> expected = new LinkedList<Long>();
		
		expected.add((long) 2);
		expected.add((long) 3);
		expected.add((long) 5);
		expected.add((long) 7);
		expected.add((long) 11);
		expected.add((long) 13);
		expected.add((long) 17);
		expected.add((long) 19);
		expected.add((long) 23);
		
		long from = 1;
		long to = 25;
		PrimeGenerator gen = new PrimeGenerator(from, to);
		gen.generatePrimes();
		actual = gen.getPrimes();
		
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void negativeNumber() {
		long from = -10;
		long to = 10;
		try {
			PrimeGenerator gen = new PrimeGenerator(from, to);
		}catch(RuntimeException ex){
			assertEquals("Wrong input values: from=" + from + " to=" + to, ex.getMessage());
		}
	}
	
	@Test
	public void mixedOrder() {
		long from = 100;
		long to = 1;
		try {
			PrimeGenerator gen = new PrimeGenerator(from, to);
		}catch(RuntimeException ex){
			assertEquals("Wrong input values: from=" + from + " to=" + to, ex.getMessage());	
	}

	}
}
