package edu.umb.cs680.hw13;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

@SuppressWarnings("deprecation")
/*This class contains the StockQuoteObservable*/
public class StockQuoteObservable extends Observable {
	
	//Map used to keep track of tickers and quotes
	private Map<String, Float> tickerMap = new HashMap<>();
	
	//Changes quote of a specific ticker and notifies the observers
	public void changeQuote(String t, float q){
		tickerMap.put(t, q);
		setChanged();
		notifyObservers(new StockEvent(t,q));
	}

}
