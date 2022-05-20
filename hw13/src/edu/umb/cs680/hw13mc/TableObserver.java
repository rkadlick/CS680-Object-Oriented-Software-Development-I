package edu.umb.cs680.hw13mc;


@SuppressWarnings("deprecation")
/*This class contains the TableObserver*/
public class TableObserver implements DIJAQuoteObserver, StockQuoteObserver {

	//Method for StockEvents
	@Override
	public void updateStock(StockEvent s) {
		System.out.println("Table Observer StockEvent");
		
	}

	//Method for DIJAEvents
	@Override
	public void updateDIJA(DIJAEvent d) {
		System.out.println("Table Observer DIJAEvent");
		
	}
	

}