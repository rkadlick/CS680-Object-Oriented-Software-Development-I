package edu.umb.cs680.hw13mc;


/*This class contains the ThreeDObserver*/
public class ThreeDObserver implements DIJAQuoteObserver, StockQuoteObserver {

	//Method for StockEvents
	@Override
	public void updateStock(StockEvent s) {
		System.out.println("3D Observer StockEvent");
		
	}

	//Method for DijaEvents
	@Override
	public void updateDIJA(DIJAEvent d) {
		System.out.println("3D Observer DIJAEvent");
		
	}


}