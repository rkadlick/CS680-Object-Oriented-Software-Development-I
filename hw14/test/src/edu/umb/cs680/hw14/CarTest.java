package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

/*This class is used to test using comparators with lambda functions, using the Car class*/
public class CarTest {
	
	//Turns a car object into an string array of its fields for testing
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
	
	//This method verifies the car object and its fields
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String [] expected = {"Toyota", "Rav4", "2018"};
		Car actual = new Car("Toyota", "Rav4", 50000, 2018, 39594);
		
		assertArrayEquals(expected, carToStringArray(actual));
	}
	
	//This method tests sorting a list of cars by price lowest to highest using lambda functions
	@Test
	public void testPriceComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		
		Collections.sort(cars, Comparator.comparing(Car::getPrice));
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Honda");
		expected.add("Jeep");
		expected.add("Chevrolet");
		
		assertEquals(expected, carListToStringArray(cars));
	}
	
	//This method tests sorting a list of cars by price highest to lowest using lambda functions
	@Test
	public void testReversePriceComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		
		Collections.sort(cars, Comparator.comparing(Car::getPrice).reversed());
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Chevrolet");
		expected.add("Jeep");
		expected.add("Honda");
		
		assertEquals(expected, carListToStringArray(cars));
	}
	
	//This method tests sorting a list of cars by year going oldest to newest using lambda functions
	@Test
	public void testYearComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		
		Collections.sort(cars, Comparator.comparing(Car::getYear));
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Chevrolet");
		expected.add("Honda");
		expected.add("Jeep");
		
		assertEquals(expected, carListToStringArray(cars));
	}
	
	//This method tests sorting a list of cars by year going newest to oldest using lambda functions
	@Test
	public void testReverseYearComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		
		Collections.sort(cars, Comparator.comparing(Car::getYear).reversed());
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Jeep");
		expected.add("Honda");
		expected.add("Chevrolet");
		
		assertEquals(expected, carListToStringArray(cars));
	}
	
	//This method tests sorting a list of cars by mileage going from lowest to highest using lambda functions
	@Test
	public void testMileageComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		
		Collections.sort(cars, Comparator.comparing(Car::getMileage));
		
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Honda");
		expected.add("Jeep");
		expected.add("Chevrolet");
		
		assertEquals(expected, carListToStringArray(cars));
	}
	
	//This method tests sorting a list of cars by mileage going highest to lowest, using lambda functions
	@Test
	public void testReverseMileageComparator() {
		Car car1 = new Car("Jeep", "Wrangler", 20000, 2020, 40000);
		Car car2 = new Car("Chevrolet", "Cruze", 80000, 2015, 50000);
		Car car3 = new Car("Honda", "Civic", 10000, 2018, 30000);
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car3);
		cars.add(car2);
		cars.add(car1);
		
		Collections.sort(cars, Comparator.comparing(Car::getMileage).reversed());
		
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Chevrolet");
		expected.add("Jeep");
		expected.add("Honda");
		
		assertEquals(expected, carListToStringArray(cars));
	}
	
	

}
