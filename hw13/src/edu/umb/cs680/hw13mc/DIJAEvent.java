package edu.umb.cs680.hw13mc;

/* This class is used to create objects of changes to DIJA*/
public class DIJAEvent {
	
	private float dija;

	public DIJAEvent(float dija) {
		this.dija = dija;
	}
	
	public float getDija() {
		return this.dija;
	}
	
	public void setDija(float newDija) {
		this.dija = newDija;
	}
}
