package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying extends DVDPlayer {
	
	public static DVDPlayer getInstance(DVDPlayer p) {
		
		if(player == null) {
			player = new DrawerClosedNotPlaying ();
			state = DVDPlayer.getInstance();
		}
		return player;
	}

	@Override
	public void openCloseButtonPushed() {
		// TODO Auto-generated method stub
		
		player.open();
		player.changeState(new DrawerOpen());
		
	}

	@Override
	public void playButtonPushed() {
		// TODO Auto-generated method stub
		
		player.play();
		player.changeState(new DrawerClosedPlaying());
		
	}

	@Override
	public void stopButtonPushed() {
		// TODO Auto-generated method stub
		
		System.out.println("Nothing happens");
		
	}
	
	protected DrawerClosedNotPlaying() {
		super(state);
	}

}
