package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*This class is used to test the Observable and Observer classes*/
public class ObserverTest {
	
	//Captures the console log, to prove the observers are being notified
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	/*Testing the StockQuoteObservable class. First add all the observers to it's list.
	 *Then, while we are updating the quote, we will print messages to the console as 
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
		
		
		
		gme.changeQuote("gme", 150);
		gme.changeQuote("gme", 160);
		gme.changeQuote("gme", 170);
		
		String expected = "3D Observer StockEvent\n"
				+ "Table Observer StockEvent\n"
				+ "PieChart Observer StockEvent\n"
				+ "3D Observer StockEvent\n"
				+ "Table Observer StockEvent\n"
				+ "PieChart Observer StockEvent\n"
				+ "3D Observer StockEvent\n"
				+ "Table Observer StockEvent\n"
				+ "PieChart Observer StockEvent\n";
		
		assertEquals(expected, outContent.toString());
	}
	
	/*Testing the DIJAQuoteObservable class. First add all the observers to it's list.
	 *Then, while we are updating the quote, we will print messages to the console as 
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
		
		dijaQ.changeQuote(100);
		dijaQ.changeQuote(200);
		dijaQ.changeQuote(150);
		
		String expected = "3D Observer DIJAEvent\n"
				+ "Table Observer DIJAEvent\n"
				+ "PieChart Observer DIJAEvent\n"
				+ "3D Observer DIJAEvent\n"
				+ "Table Observer DIJAEvent\n"
				+ "PieChart Observer DIJAEvent\n"
				+ "3D Observer DIJAEvent\n"
				+ "Table Observer DIJAEvent\n"
				+ "PieChart Observer DIJAEvent\n";
		
		assertEquals(expected, outContent.toString());
	}

	
}
