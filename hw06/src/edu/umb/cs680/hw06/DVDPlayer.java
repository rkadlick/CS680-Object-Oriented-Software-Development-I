package edu.umb.cs680.hw06;

import org.junit.platform.commons.annotation.Testable;

public class DVDPlayer implements State {
	
	
	protected static DVDPlayer player = null;
	protected static State state = null;
	protected DVDPlayer(State state) {};
	
	public static DVDPlayer getInstance() {
		if(player == null) {
			state = DrawerClosedNotPlaying.getInstance(player);
		} 
		return player;
	}
	
	public void changeState(DVDPlayer p) {
		
		player = p;
		state = DVDPlayer.getInstance();
		

		
	}

	@Override
	public void openCloseButtonPushed() {
		// TODO Auto-generated method stub
		
		state.openCloseButtonPushed();
		
	}

	@Override
	public void playButtonPushed() {
		// TODO Auto-generated method stub
		
		state.playButtonPushed();
		
	}

	@Override
	public void stopButtonPushed() {
		// TODO Auto-generated method stub
		
		state.stopButtonPushed();
		
	}
	
	public void open() {
		System.out.println("DVD Player - Open");
	}
	
	public void close() {
		System.out.println("DVD Player - Close");
	}
	
	public void play() {
		System.out.println("DVD Player - Play");
	}
	
	public void stop() {
		System.out.println("DVD Player - Stop");
	}
	
	
	

}
