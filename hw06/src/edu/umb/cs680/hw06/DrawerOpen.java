package edu.umb.cs680.hw06;

public class DrawerOpen extends DVDPlayer {
	

	
	public static DVDPlayer getInstance(DVDPlayer p) {
		if(player == null) {
			player = new DrawerOpen ();
			state = DVDPlayer.getInstance();
		}
		return player;
	}

	public void openCloseButtonPushed() {
		// TODO Auto-generated method stub
		
		player.close();
		player.changeState(new DrawerClosedNotPlaying());
		
	}

	public void playButtonPushed() {
		// TODO Auto-generated method stub
		
		player.close();
		player.play();
		player.changeState(new DrawerClosedPlaying());
		
	}

	public void stopButtonPushed() {
		// TODO Auto-generated method stub
		System.out.println("Nothing happens");
		
	}
	
	protected DrawerOpen() {
		super(state);
	}

}
