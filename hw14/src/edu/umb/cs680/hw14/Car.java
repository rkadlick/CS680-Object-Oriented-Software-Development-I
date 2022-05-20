package edu.umb.cs680.hw14;

import java.util.ArrayList;

/*This class holds the Car object and its fields*/
public class Car {
	
	//Fields for Car objects
	private String make, model;
	private int mileage, year, dominationCount;
	private float price;
	
	public Car(String make, String model, int mileage, int year, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}
	
	//Getters and setters
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	//Creates a domination count based on comparing two cars, price mileage and year
	public void setDominationCount(ArrayList<Car> cars) {
		int newDominationCount = 0;
		
		
		for(int i = 0; i<cars.size(); i++) {
			if (this.price <= cars.get(i).getPrice()) {
				if (this.year >= cars.get(i).getYear()) {
					if (this.mileage <= cars.get(i).getMileage()) {
					} else {
						newDominationCount++;
					}
				}else {
					newDominationCount++;
				}
			} else {
				 newDominationCount++;
			}
		}
		
		this.dominationCount = newDominationCount;
	}
	
	public int getDominationCount() {
		return this.dominationCount;
	}
	
	
}
