package edu.umb.cs680.hw13mc;

import java.util.ArrayList;
import java.util.Collection;


/*This class contains DJIAQuoteObservable, not using Javas Observable*/
public class DJIAQuoteObservable{
	
	//Creates our own list of observers
	Collection<DIJAQuoteObserver> observers = new ArrayList<>();
	
	//Adds observers to the list
	public void addObserver(DIJAQuoteObserver ob) {
		observers.add(ob);
	}
	
	//Notifies observers of a DIJAEvent
	public void notifyObservers(DIJAEvent event) {
		for (DIJAQuoteObserver ob : observers) {
			ob.updateDIJA(event);
		}
	}

}
