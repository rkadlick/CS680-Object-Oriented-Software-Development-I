package edu.umb.cs680.hw13mc;

import java.util.ArrayList;
import java.util.Collection;


/*This class contains the StockQuoteObservable, not using Javas Observable class*/
public class StockQuoteObservable{
	
	//Creates a list of our observers
	Collection<StockQuoteObserver> observers = new ArrayList<>();
	
	//Adds observer to the list
	public void addObserver(StockQuoteObserver ob) {
		observers.add(ob);
	}
	
	//Updates observers with StockEvents
	public void notifyObservers(StockEvent event) {
		for (StockQuoteObserver ob : observers) {
			ob.updateStock(event);
		}
	}

}

