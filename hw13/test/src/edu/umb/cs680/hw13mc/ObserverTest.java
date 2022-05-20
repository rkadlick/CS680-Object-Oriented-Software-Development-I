package edu.umb.cs680.hw13mc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*This class is used to test the Observable and Observer classes, using multicast*/
public class ObserverTest {
	
	//Captures the console log, to prove the observers are being notified
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	/*Testing the StockQuoteObservable class. First add all the observers to it's list.
	 *Then, while we simulate StockEvents, we will print messages to the console as 
	 *each observer is notified. The expected String shows what should happen as all
	 *3 observers are notified 3 times each.
	 */
	
	@Test
	public void testStockQuote() {
		StockQuoteObservable gme = new StockQuoteObservable();
		PieChartObserver pcObserv = new PieChartObserver();
		TableObserver tObserv = new TableObserver();
		ThreeDObserver ThreedObserv = new ThreeDObserver();
		gme.addObserver(pcObserv);
		gme.addObserver(tObserv);
		gme.addObserver(ThreedObserv);
		
		StockEvent a = new StockEvent("gme", 150);
		StockEvent b = new StockEvent("gme", 150);
		StockEvent c = new StockEvent("gme", 150);
		
		gme.notifyObservers(a);
		gme.notifyObservers(b);
		gme.notifyObservers(c);
		
		String expected = "Pie chart Observer StockEvent\n"
				+ "Table Observer StockEvent\n"
				+ "3D Observer StockEvent\n"
				+ "Pie chart Observer StockEvent\n"
				+ "Table Observer StockEvent\n"
				+ "3D Observer StockEvent\n"
				+ "Pie chart Observer StockEvent\n"
				+ "Table Observer StockEvent\n"
				+ "3D Observer StockEvent\n";
		
		assertEquals(expected, outContent.toString());
	}
	
	/*Testing the DIJAQuoteObservable class. First add all the observers to it's list.
	 *Then, while we simulate DIJAEvents, we will print messages to the console as 
	 *each observer is notified. The expected String shows what should happen as all
	 *3 observers are notified 3 times each.
	 */
	@Test
	public void testDIJAQuote() {
		DJIAQuoteObservable dijaQ = new DJIAQuoteObservable();
		PieChartObserver pcObserv = new PieChartObserver();
		TableObserver tObserv = new TableObserver();
		ThreeDObserver ThreedObserv = new ThreeDObserver();
		dijaQ.addObserver(pcObserv);
		dijaQ.addObserver(tObserv);
		dijaQ.addObserver(ThreedObserv);
		
		DIJAEvent a = new DIJAEvent(100);
		DIJAEvent b = new DIJAEvent(200);
		DIJAEvent c = new DIJAEvent(150);
		
		dijaQ.notifyObservers(a);
		dijaQ.notifyObservers(b);
		dijaQ.notifyObservers(c);
		
		
		String expected = "Pie chart Observer DIJAEvent\n"
				+ "Table Observer DIJAEvent\n"
				+ "3D Observer DIJAEvent\n"
				+ "Pie chart Observer DIJAEvent\n"
				+ "Table Observer DIJAEvent\n"
				+ "3D Observer DIJAEvent\n"
				+ "Pie chart Observer DIJAEvent\n"
				+ "Table Observer DIJAEvent\n"
				+ "3D Observer DIJAEvent\n";
		
		assertEquals(expected, outContent.toString());
	}

	
}
