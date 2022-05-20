package edu.umb.cs680.hw13mc;

/*This interface is used to update all observers during a StockEvent*/
public interface StockQuoteObserver {

	void updateStock(StockEvent s);
	
}
