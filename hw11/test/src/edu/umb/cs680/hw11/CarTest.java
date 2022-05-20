package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;


import org.junit.jupiter.api.Test;

/*This class is used to test the Car class as well as the Comparator classes created in the package*/
public class CarTest {
	
	//Turns the fields of a Car object into a string array
	private String[] carToStringArray(Car car) {
		String[] carInfo = {
				car.getMake(), car.getModel(), 
				String.valueOf(car.getYear())};
		return carInfo;
	}
	
	//Turns a list of cars into a string array of their models, for testing
		private ArrayList<String> carListToStringArray(ArrayList<Car> cars){
			ArrayList<String> carModels = new ArrayList<String>();
			
			for(Car c : cars) {
				carModels.add(c.getMake());
			}
			return carModels;
		}
	
	//This method tests a Car object's fields
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String [] expected = {"Toyota", "Rav4", "2018"};
		Car actual = new Car("Toyota", "Rav4", 50000, 2018, 39594);
		
		assertArrayEquals(expected, carToStringArray(actual));
	}
	
	//This method tests the PriceComparator class by sorting a list of cars by their price and comparing to an expected list
	@Test
	public void testPriceComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		
		Collections.sort(cars, new PriceComparator());
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Chevrolet");
		expected.add("Jeep");
		expected.add("Honda");
		
		assertEquals(expected, carListToStringArray(cars));
	}

	//This method tests the YearComparator class by sorting a list of cars by their year and comparing to an expected list
	@Test
	public void testYearComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		
		Collections.sort(cars, new YearComparator());
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Jeep");
		expected.add("Honda");
		expected.add("Chevrolet");
		
		assertEquals(expected, carListToStringArray(cars));
	}
	
	//This method tests the MileageComparator class by sorting a list of cars by their mileage and comparing to an expected list
	@Test
	public void testMileageComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		
		Collections.sort(cars, new MileageComparator());
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Honda");
		expected.add("Jeep");
		expected.add("Chevrolet");
		
		assertEquals(expected, carListToStringArray(cars));
	}
	
	//This method tests the ParetoComparator class by sorting a list of cars by their dominationCount and comparing to an expected list
	@Test
	public void testParetoComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		Car car4 = new Car("Audi", "A4", 0, 2021, 25000);
	
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		cars.add(car4);
		
		for (Car c : cars) {
			c.setDominationCount(cars);
		}
		
		Collections.sort(cars, new ParetoComparator());
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Audi");
		expected.add("Honda");
		expected.add("Jeep");
		expected.add("Chevrolet");
		
		
		assertEquals(expected, carListToStringArray(cars));;
	}

}
