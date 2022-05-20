package edu.umb.cs680.hw13;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
/*This class contains the PieChartObserver*/
public class PieChartObserver implements Observer {

	/*This method is used to decipher what kind of Event happened and
	 * have different outcomes based on the event. 
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof StockEvent) {
			System.out.println("PieChart Observer StockEvent");
		}else if (arg instanceof DIJAEvent){
			System.out.println("PieChart Observer DIJAEvent");
		}else {
			System.out.println("PieChart Observer ?");
		}
		
	}

}
