package edu.umb.cs680.hw13mc;

import java.util.Observer;

@SuppressWarnings("deprecation")
/*This class contains the PieChartObserver*/
public class PieChartObserver implements DIJAQuoteObserver, StockQuoteObserver {

	//Method for stock Events
	@Override
	public void updateStock(StockEvent s) {
		System.out.println("Pie chart Observer StockEvent");
		
	}

	//Method for DIJA events
	@Override
	public void updateDIJA(DIJAEvent d) {
		System.out.println("Pie chart Observer DIJAEvent");
		
	}

}