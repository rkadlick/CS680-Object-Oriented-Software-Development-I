package edu.umb.cs680.hw13mc;

/*This class is used to create objects out of events on the stock market*/
public class StockEvent {
	
	private String ticker;
	private float quote;
	
	StockEvent(String ticker, float quote){
		this.ticker = ticker;
		this.quote = quote;
	}
	
	public String getTicker() {
		return this.ticker;
	}
	
	public float getQuote() {
		return this.quote;
	}
	
	public void setTicker(String newTicker) {
		this.ticker = newTicker;
	}
	
	public void setQuote(float newQuote) {
		this.quote = newQuote;
	}

}
