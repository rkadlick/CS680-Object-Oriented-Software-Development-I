package edu.umb.cs680.hw13;

import java.util.Observable;

@SuppressWarnings("deprecation")
/*This class contains DJIAQuoteObservable*/
public class DJIAQuoteObservable extends Observable {
	

	private float quote;
	
	//Changes the quote of DIJA, notifies observers
	public void changeQuote(float q) {
		quote = q;
		setChanged();
		notifyObservers(new DIJAEvent(quote));
	}

}
