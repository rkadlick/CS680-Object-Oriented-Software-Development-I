package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	
	private String[] carToStringArray(Car car) {
		String[] carInfo = {
				car.getMake(), car.getModel(), 
				String.valueOf(car.getYear())};
		return carInfo;
	}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String [] expected = {"Toyota", "Rav4", "2018"};
		Car actual = new Car("Toyota", "Rav4", 50000, 2018, 39594);
		
		assertArrayEquals(expected, carToStringArray(actual));
	}

}
